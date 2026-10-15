package com.starburst.sdk.core.audio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AudioUploadPacketizer {
    public static final int DEFAULT_BIT_DEPTH = 16;
    public static final int DEFAULT_CHANNELS = 1;
    public static final int DEFAULT_PACKET_DURATION_MS = 240;
    public static final int DEFAULT_SAMPLE_RATE = 16000;
    private byte[] cache = new byte[0];
    private int packetSizeBytes = calculatePacketSizeBytes("raw", 0, 0);
    private int frameAlignmentBytes = 2;

    public static int calculateBytesForDuration(String str, int i9, int i10, int i11) {
        if (i11 <= 0) {
            return 0;
        }
        return (!isOpus(str) || i9 <= 0 || i10 <= 0) ? saturatedPositiveInt((((((long) i11) * 16000) / 1000) * 16) / 8) : saturatedPositiveInt(Math.max(1L, ((((long) i11) * 16000) / 1000) / ((long) i10)) * ((long) i9));
    }

    public static int calculatePacketSizeBytes(String str, int i9, int i10) {
        return (!isOpus(str) || i9 <= 0 || i10 <= 0) ? saturatedPositiveInt(7680L) : saturatedPositiveInt(Math.max(1L, 3840 / ((long) i10)) * ((long) i9));
    }

    private static boolean isOpus(String str) {
        return "opus".equalsIgnoreCase(str);
    }

    private static int saturatedPositiveInt(long j) {
        return (int) Math.max(1L, Math.min(2147483647L, j));
    }

    public synchronized void configure(String str, int i9, int i10) {
        int iCalculatePacketSizeBytes = calculatePacketSizeBytes(str, i9, i10);
        if (!isOpus(str) || i9 <= 0) {
            i9 = 2;
        }
        configurePacketSize(iCalculatePacketSizeBytes, i9);
    }

    public synchronized void configurePacketSize(int i9, int i10) {
        this.packetSizeBytes = Math.max(1, i9);
        this.frameAlignmentBytes = Math.max(1, i10);
        this.cache = new byte[0];
    }

    public synchronized byte[] drain() {
        byte[] bArrCopyOfRange;
        try {
            byte[] bArr = this.cache;
            int length = bArr.length - (bArr.length % this.frameAlignmentBytes);
            bArrCopyOfRange = length > 0 ? Arrays.copyOfRange(bArr, 0, length) : new byte[0];
            this.cache = new byte[0];
        } catch (Throwable th) {
            throw th;
        }
        return bArrCopyOfRange;
    }

    public synchronized int getPacketSizeBytes() {
        return this.packetSizeBytes;
    }

    public synchronized List<byte[]> offer(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                byte[] bArr2 = this.cache;
                int length = bArr2.length;
                byte[] bArrCopyOf = Arrays.copyOf(bArr2, bArr.length + length);
                this.cache = bArrCopyOf;
                System.arraycopy(bArr, 0, bArrCopyOf, length, bArr.length);
                int length2 = this.cache.length / this.packetSizeBytes;
                if (length2 == 0) {
                    return Collections.EMPTY_LIST;
                }
                ArrayList arrayList = new ArrayList(length2);
                int i9 = 0;
                for (int i10 = 0; i10 < length2; i10++) {
                    arrayList.add(Arrays.copyOfRange(this.cache, i9, this.packetSizeBytes + i9));
                    i9 += this.packetSizeBytes;
                }
                byte[] bArr3 = this.cache;
                this.cache = Arrays.copyOfRange(bArr3, i9, bArr3.length);
                return arrayList;
            }
        }
        return Collections.EMPTY_LIST;
    }

    public synchronized void reset() {
        this.cache = new byte[0];
    }
}
