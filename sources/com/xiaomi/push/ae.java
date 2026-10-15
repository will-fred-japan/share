package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f17015a = "0123456789ABCDEF".toCharArray();

    public static boolean a(Context context) {
        return ad.f17014a;
    }

    public static String a(byte[] bArr, int i9, int i10) {
        StringBuilder sb = new StringBuilder(i10 * 2);
        for (int i11 = 0; i11 < i10; i11++) {
            byte b9 = bArr[i9 + i11];
            char[] cArr = f17015a;
            sb.append(cArr[(b9 & 255) >> 4]);
            sb.append(cArr[b9 & 15]);
        }
        return sb.toString();
    }
}
