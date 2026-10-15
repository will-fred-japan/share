package com.starburst.sdk.core.feed.bt;

import J6.c;
import android.text.TextUtils;
import com.starburst.sdk.business.a56;
import com.starburst.sdk.business.b89;
import com.starburst.sdk.core.asr.cc;
import com.starburst.sdk.core.device.bt.BleMsgManager;
import com.starburst.sdk.core.feed.FeedManager;
import com.starburst.sdk.core.feed.utils.OkHttpDownloader;
import com.starburst.sdk.utils.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AudioSplitSender {
    private static final byte HEADER = 65;
    private static final int MTU_SAFE_OFFSET = 40;
    private static final String TAG = "shunli";
    private static volatile AudioSplitSender instance;
    private List<byte[]> splits = new ArrayList();
    private final ConcurrentHashMap<String, LinkedList<SplitRequest>> pendingRequests = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> processingContentIds = new ConcurrentHashMap<>();
    private int currentMtu = BleMsgManager.getInstance().getMsgMtu();

    public static class SplitRequest {
        final byte fileType;
        final int splitIndex;
        final String tagId;

        public SplitRequest(byte b9, String str, int i9) {
            this.fileType = b9;
            this.tagId = str;
            this.splitIndex = i9;
        }
    }

    private AudioSplitSender() {
    }

    public static byte[] buildA2dpStartRspPacket(byte b9, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(69);
        byteArrayOutputStream.write(b9);
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        try {
            byteArrayOutputStream.write(intToBytesLittleEndian(bytes.length));
        } catch (IOException e9) {
            j.f(TAG, "buildA2dpStartRspPacket failed: " + e9.getMessage());
        }
        try {
            byteArrayOutputStream.write(bytes);
        } catch (IOException e10) {
            j.f(TAG, "buildA2dpStartRspPacket failed: " + e10.getMessage());
        }
        byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
        try {
            byteArrayOutputStream.write(intToBytesLittleEndian(bytes2.length));
        } catch (IOException e11) {
            j.f(TAG, "buildA2dpStartRspPacket failed: " + e11.getMessage());
        }
        try {
            byteArrayOutputStream.write(bytes2);
        } catch (IOException e12) {
            j.f(TAG, "buildA2dpStartRspPacket failed: " + e12.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] buildA2dpStopReqPacket(byte b9, byte b10) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(70);
        byteArrayOutputStream.write(b9);
        byteArrayOutputStream.write(b10);
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildAudioPacket(byte b9, String str, String str2, int i9, int i10, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(65);
            byteArrayOutputStream.write(b9);
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            byteArrayOutputStream.write(intToBytesLittleEndian(bytes.length));
            j.f(TAG, "idBytes.length = " + bytes.length);
            byteArrayOutputStream.write(bytes);
            j.f(TAG, "tag id = ".concat(str));
            byte[] bytes2 = str2.getBytes(charset);
            byteArrayOutputStream.write(intToBytesLittleEndian(bytes2.length));
            j.f(TAG, "contentIdBytes.length = " + bytes2.length);
            byteArrayOutputStream.write(bytes2);
            j.f(TAG, "contentId = ".concat(str2));
            byteArrayOutputStream.write(intToBytesLittleEndian(i9));
            j.f(TAG, "totalSplits = " + i9);
            byteArrayOutputStream.write(intToBytesLittleEndian(i10));
            j.f(TAG, "splitIndex = " + i10);
            byteArrayOutputStream.write(intToBytesLittleEndian(bArr.length));
            j.f(TAG, "splitData = " + bArr);
            byteArrayOutputStream.write(bArr);
        } catch (IOException e9) {
            j.j(TAG, "Packet build failed", e9);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private int calculateSplitSize() {
        return (Math.max(this.currentMtu - 40, 80) / 80) * 80;
    }

    private boolean checkLocalFile(String str) {
        return new File(getOpusFilePath(str)).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupAfterFailure(String str) {
        synchronized (this.processingContentIds) {
            this.processingContentIds.remove(str);
            this.pendingRequests.remove(str);
        }
        new File(getOpusFilePath(str)).delete();
    }

    public static AudioSplitSender getInstance() {
        if (instance == null) {
            synchronized (AudioSplitSender.class) {
                try {
                    if (instance == null) {
                        instance = new AudioSplitSender();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getOpusFilePath(String str) {
        return OkHttpDownloader.getInstance(c.f().g(), null).getBaseDir() + "/" + str + ".opus";
    }

    private static byte[] intToBytesLittleEndian(int i9) {
        return new byte[]{(byte) (i9 & 255), (byte) ((i9 >> 8) & 255), (byte) ((i9 >> 16) & 255), (byte) ((i9 >> 24) & 255)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LinkedList lambda$requestAudioData$0(String str) {
        return new LinkedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LinkedList lambda$requestAudioData$1(String str) {
        return new LinkedList();
    }

    private void processExistingFile(String str) {
        a56.a56("Processing existing file for contentId: ", str, TAG);
        if (prepareAudioData(new File(getOpusFilePath(str)))) {
            processQueuedRequests(str);
        }
        synchronized (this.processingContentIds) {
            this.processingContentIds.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processQueuedRequests(String str) {
        LinkedList<SplitRequest> linkedListRemove;
        synchronized (this.pendingRequests) {
            linkedListRemove = this.pendingRequests.remove(str);
        }
        if (linkedListRemove != null) {
            j.f(TAG, "Processing " + linkedListRemove.size() + " queued requests for " + str);
            for (SplitRequest splitRequest : linkedListRemove) {
                b89.a56(A1.b.g0("Sending audio packet for contentId: ", str, ", splitIndex: "), splitRequest.splitIndex, TAG);
                sendAudioPacket(splitRequest.fileType, splitRequest.tagId, str, splitRequest.splitIndex);
            }
        }
    }

    private byte[] readFileToBytes(File file) {
        return Files.readAllBytes(file.toPath());
    }

    public static void sendA2dpStartRsp(byte b9, String str, String str2) {
        com.starburst.sdk.core.asr.b89.a56(BleMsgManager.getInstance(), 75, buildA2dpStartRspPacket(b9, str, str2));
    }

    public static void sendA2dpStopReq(byte b9, byte b10) {
        com.starburst.sdk.core.asr.b89.a56(BleMsgManager.getInstance(), 75, buildA2dpStopReqPacket(b9, b10));
    }

    private void sendAudioPacket(byte b9, String str, String str2, int i9) {
        if (i9 >= 0 && i9 < this.splits.size()) {
            com.starburst.sdk.core.asr.b89.a56(BleMsgManager.getInstance(), 75, buildAudioPacket(b9, str, str2, this.splits.size(), i9, this.splits.get(i9)));
        } else {
            j.i(TAG, "Invalid splitIndex: " + i9);
        }
    }

    private void splitAudioData(byte[] bArr) {
        int iCalculateSplitSize = calculateSplitSize();
        cc.a56("Calculated split size: ", iCalculateSplitSize, TAG);
        int i9 = 0;
        while (i9 < bArr.length) {
            int i10 = i9 + iCalculateSplitSize;
            this.splits.add(Arrays.copyOfRange(bArr, i9, Math.min(i10, bArr.length)));
            i9 = i10;
        }
    }

    private void startDownloadAndConvert(final String str, byte b9, String str2, int i9) {
        j.f(TAG, "Starting download for contentId: " + str);
        String audioUrl = FeedManager.getInstance().getAudioUrl(b9, str);
        if (audioUrl == null) {
            a56.a56("No URL mapping for contentId: ", str, TAG);
            return;
        }
        j.f(TAG, "URL mapping for contentId: " + str + " is " + audioUrl);
        OkHttpDownloader.getInstance(c.f().g(), null).downloadUrgent(audioUrl, A.a.j(new StringBuilder(), str, ".pcm"), new OkHttpDownloader.DownloadListener() { // from class: com.starburst.sdk.core.feed.bt.AudioSplitSender.1
            @Override // com.starburst.sdk.core.feed.utils.OkHttpDownloader.DownloadListener
            public void onFailure(String str3, File file, Throwable th) {
                p142s2.j.j(new StringBuilder("Download failed: "), str, AudioSplitSender.TAG);
                AudioSplitSender.this.cleanupAfterFailure(str);
            }

            @Override // com.starburst.sdk.core.feed.utils.OkHttpDownloader.DownloadListener
            public void onSuccess(String str3, File file) {
                String opusFilePath = AudioSplitSender.this.getOpusFilePath(str);
                File file2 = new File(opusFilePath);
                if (!file2.exists()) {
                    c.f().f2731c.encodeFile(str, file.getAbsolutePath(), opusFilePath);
                }
                if (AudioSplitSender.this.prepareAudioData(file2)) {
                    AudioSplitSender.this.processQueuedRequests(str);
                }
                synchronized (AudioSplitSender.this.processingContentIds) {
                    AudioSplitSender.this.processingContentIds.remove(str);
                }
            }

            @Override // com.starburst.sdk.core.feed.utils.OkHttpDownloader.DownloadListener
            public void onCancel(String str3, File file) {
            }

            @Override // com.starburst.sdk.core.feed.utils.OkHttpDownloader.DownloadListener
            public void onStart(String str3, File file) {
            }

            @Override // com.starburst.sdk.core.feed.utils.OkHttpDownloader.DownloadListener
            public void onProgress(String str3, long j, long j8) {
            }
        });
    }

    public boolean prepareAudioData(File file) {
        if (!file.exists()) {
            j.i(TAG, "Opus file not found: " + file.getAbsolutePath());
            return false;
        }
        try {
            byte[] fileToBytes = readFileToBytes(file);
            this.splits.clear();
            splitAudioData(fileToBytes);
            return true;
        } catch (IOException e9) {
            j.j(TAG, "Failed to read opus file", e9);
            return false;
        }
    }

    public synchronized boolean requestAudioData(byte b9, String str, String str2, int i9) {
        j.f(TAG, "Requesting audio data for contentId: " + str2 + ", splitIndex: " + i9);
        if (TextUtils.isEmpty(str2)) {
            j.f(TAG, "Content ID is empty");
            return false;
        }
        synchronized (this.processingContentIds) {
            if (this.processingContentIds.containsKey(str2)) {
                this.pendingRequests.computeIfAbsent(str2, new a()).add(new SplitRequest(b9, str, i9));
                j.f(TAG, "Queued request for contentId: " + str2);
                return true;
            }
            if (checkLocalFile(str2)) {
                j.f(TAG, "File exists for contentId: " + str2 + ", splitIndex: " + i9);
                this.processingContentIds.put(str2, Boolean.TRUE);
                this.pendingRequests.computeIfAbsent(str2, new b()).add(new SplitRequest(b9, str, i9));
                processExistingFile(str2);
            } else {
                j.f(TAG, "File not found for contentId: " + str2 + ", splitIndex: " + i9);
                this.processingContentIds.put(str2, Boolean.TRUE);
                startDownloadAndConvert(str2, b9, str, i9);
            }
            return true;
        }
    }
}
