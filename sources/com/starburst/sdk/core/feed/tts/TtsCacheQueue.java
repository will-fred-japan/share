package com.starburst.sdk.core.feed.tts;

import J6.c;
import com.starburst.sdk.business.a56;
import com.starburst.sdk.core.opus.BaseOpusEncoder;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class TtsCacheQueue {
    private int pcmFrameByteSize;
    private String TAG = "TtsCacheQueue";
    private Lock cacheLock = new ReentrantLock();
    private byte[] pcmCache = new byte[0];
    private Queue<byte[]> opusFrameQueue = new LinkedList();

    public TtsCacheQueue(int i9) {
        this.pcmFrameByteSize = i9 * 2;
        c.f().f2731c.setOpusDataListener(new BaseOpusEncoder.OpusDataListener() { // from class: com.starburst.sdk.core.feed.tts.TtsCacheQueue.1
            @Override // com.starburst.sdk.core.opus.BaseOpusEncoder.OpusDataListener
            public void onOpusDataError(String str, int i10, String str2) {
                a56.a56("Opus encoding error: ", str2, TtsCacheQueue.this.TAG);
            }

            @Override // com.starburst.sdk.core.opus.BaseOpusEncoder.OpusDataListener
            public void onOpusDataSuccess(String str, byte[] bArr) {
                TtsCacheQueue.this.opusFrameQueue.offer(bArr);
            }
        });
    }

    private byte[] concatBytes(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private void processPcmToOpus(boolean z8) {
        int i9;
        int length = this.pcmCache.length;
        while (true) {
            i9 = this.pcmFrameByteSize;
            if (length < i9) {
                break;
            }
            byte[] bArr = new byte[i9];
            System.arraycopy(this.pcmCache, 0, bArr, 0, i9);
            c.f().f2731c.encode(this.TAG, bArr);
            byte[] bArrSubBytes = subBytes(this.pcmCache, this.pcmFrameByteSize);
            this.pcmCache = bArrSubBytes;
            length = bArrSubBytes.length;
        }
        if (!z8 || length <= 0) {
            return;
        }
        byte[] bArr2 = new byte[i9];
        System.arraycopy(this.pcmCache, 0, bArr2, 0, length);
        c.f().f2731c.encode(this.TAG, bArr2);
        this.pcmCache = new byte[0];
    }

    private byte[] subBytes(byte[] bArr, int i9) {
        int length = bArr.length - i9;
        if (length <= 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i9, bArr2, 0, length);
        return bArr2;
    }

    public void clear() {
        this.cacheLock.lock();
        try {
            this.pcmCache = new byte[0];
            this.opusFrameQueue.clear();
        } finally {
            this.cacheLock.unlock();
        }
    }

    public byte[] dequeueOpus() {
        this.cacheLock.lock();
        try {
            return this.opusFrameQueue.poll();
        } finally {
            this.cacheLock.unlock();
        }
    }

    public byte[][] dequeueOpusBatch(int i9) {
        if (i9 <= 0) {
            return new byte[0][];
        }
        this.cacheLock.lock();
        try {
            int iMin = Math.min(i9, this.opusFrameQueue.size());
            byte[][] bArr = new byte[iMin][];
            for (int i10 = 0; i10 < iMin; i10++) {
                bArr[i10] = this.opusFrameQueue.poll();
            }
            this.cacheLock.unlock();
            return bArr;
        } catch (Throwable th) {
            this.cacheLock.unlock();
            throw th;
        }
    }

    public void enqueuePcm(byte[] bArr, boolean z8) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this.cacheLock.lock();
        try {
            this.pcmCache = concatBytes(this.pcmCache, bArr);
            processPcmToOpus(z8);
        } finally {
            this.cacheLock.unlock();
        }
    }

    public int getOpusQueueSize() {
        this.cacheLock.lock();
        try {
            return this.opusFrameQueue.size();
        } finally {
            this.cacheLock.unlock();
        }
    }

    public int getPcmCacheSize() {
        this.cacheLock.lock();
        try {
            return this.pcmCache.length;
        } finally {
            this.cacheLock.unlock();
        }
    }
}
