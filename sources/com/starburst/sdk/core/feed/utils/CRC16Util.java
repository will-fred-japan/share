package com.starburst.sdk.core.feed.utils;

import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes.dex */
public class CRC16Util {
    public static int calculate(byte[] bArr) {
        return calculate(bArr, null);
    }

    public static byte[] toLittleEndianBytes(int i9) {
        return new byte[]{(byte) (i9 & 255), (byte) ((i9 >> 8) & 255)};
    }

    public static int calculate(byte[] bArr, Integer num) {
        int iIntValue = num != null ? num.intValue() : 65535;
        for (int i9 : bArr) {
            int i10 = (i9 & 255) ^ (iIntValue & 255);
            int i11 = i10 ^ ((i10 << 4) & 255);
            iIntValue = ((((iIntValue >>> 8) ^ (i11 << 8)) ^ (i11 << 3)) ^ (i11 >>> 4)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        }
        return iIntValue;
    }
}
