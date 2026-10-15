package com.starburst.sdk.core.feed.utils;

import com.starburst.sdk.core.feed.model.ContentWithTag;
import com.starburst.sdk.utils.j;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TextBinConveter {
    private static final String TAG = "lishunTextBinConveter";
    private static volatile TextBinConveter instance;

    public static class ContentIndex {
        final int offset;
        final int size;

        public ContentIndex(int i9, int i10) {
            this.offset = i9;
            this.size = i10;
        }
    }

    private TextBinConveter() {
    }

    private static List<byte[]> buildContents(List<ContentWithTag> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (ContentWithTag contentWithTag : list) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String tagId = contentWithTag.getTagId();
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = tagId.getBytes(charset);
            byteArrayOutputStream.write(intToBytesLE(bytes.length));
            byteArrayOutputStream.write(bytes);
            byte[] bytes2 = contentWithTag.getTagName().getBytes(charset);
            byteArrayOutputStream.write(intToBytesLE(bytes2.length));
            byteArrayOutputStream.write(bytes2);
            byte[] bytes3 = contentWithTag.getContent().getId().getBytes(charset);
            byteArrayOutputStream.write(intToBytesLE(bytes3.length));
            byteArrayOutputStream.write(bytes3);
            byteArrayOutputStream.write(intToBytesLE(contentWithTag.getContent().getIndex()));
            byte[] bytes4 = contentWithTag.getContent().getTitle().getBytes(charset);
            byteArrayOutputStream.write(intToBytesLE(bytes4.length));
            byteArrayOutputStream.write(bytes4);
            byte[] bytes5 = contentWithTag.getContent().getContent().getBytes(charset);
            byteArrayOutputStream.write(intToBytesLE(bytes5.length));
            byteArrayOutputStream.write(bytes5);
            byteArrayOutputStream.write(shortToBytesLE((short) CRC16Util.calculate(byteArrayOutputStream.toByteArray())));
            arrayList.add(byteArrayOutputStream.toByteArray());
        }
        return arrayList;
    }

    private static byte[] buildHeader(int i9, List<ContentWithTag> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(intToBytesLE(15));
        byteArrayOutputStream.write((byte) i9);
        byteArrayOutputStream.write(intToBytesLE(list.size()));
        writeTimestamp(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static List<ContentIndex> buildIndices(List<ContentWithTag> list, int i9) {
        ArrayList arrayList = new ArrayList();
        int size = (list.size() * 8) + i9;
        Iterator<ContentWithTag> it = list.iterator();
        while (it.hasNext()) {
            int iCalculateContentSize = calculateContentSize(it.next());
            arrayList.add(new ContentIndex(size, iCalculateContentSize));
            size += iCalculateContentSize;
        }
        return arrayList;
    }

    private static int calculateContentSize(ContentWithTag contentWithTag) {
        String tagId = contentWithTag.getTagId();
        Charset charset = StandardCharsets.UTF_8;
        return tagId.getBytes(charset).length + 8 + contentWithTag.getTagName().getBytes(charset).length + 4 + contentWithTag.getContent().getId().getBytes(charset).length + 8 + contentWithTag.getContent().getTitle().getBytes(charset).length + 4 + contentWithTag.getContent().getContent().getBytes(charset).length + 2;
    }

    public static byte[] convertToBinary(int i9, List<ContentWithTag> list) {
        j.f(TAG, "contentWithTagList.size() = " + list.size());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArrBuildHeader = buildHeader(i9, list);
            byteArrayOutputStream.write(bArrBuildHeader);
            for (ContentIndex contentIndex : buildIndices(list, bArrBuildHeader.length)) {
                byteArrayOutputStream.write(intToBytesLE(contentIndex.offset));
                byteArrayOutputStream.write(intToBytesLE(contentIndex.size));
            }
            Iterator<byte[]> it = buildContents(list).iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write(it.next());
            }
            byteArrayOutputStream.write(intToBytesLE(CRC16Util.calculate(byteArrayOutputStream.toByteArray())));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static TextBinConveter getInstance() {
        if (instance == null) {
            synchronized (TextBinConveter.class) {
                try {
                    if (instance == null) {
                        instance = new TextBinConveter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private static byte[] intToBytesLE(int i9) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i9).array();
    }

    private static byte[] shortToBytesLE(short s8) {
        return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(s8).array();
    }

    private static void writeTimestamp(ByteArrayOutputStream byteArrayOutputStream) {
        Calendar calendar = Calendar.getInstance();
        byteArrayOutputStream.write(calendar.get(1) + PushMessageHelper.MESSAGE_THAW_APP);
        byteArrayOutputStream.write(calendar.get(2) + 1);
        byteArrayOutputStream.write(calendar.get(5));
        byteArrayOutputStream.write(calendar.get(11));
        byteArrayOutputStream.write(calendar.get(12));
        byteArrayOutputStream.write(calendar.get(13));
    }
}
