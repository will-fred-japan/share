package com.xiaomi.push;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class hm {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final char[] f557a = "&quot;".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f17648b = "&apos;".toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f17649c = "&amp;".toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f17650d = "&lt;".toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f17651e = "&gt;".toCharArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Random f17647a = new Random();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static char[] f17652f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (((double) length) * 1.3d));
        int i9 = 0;
        int i10 = 0;
        while (i9 < length) {
            char c5 = charArray[i9];
            if (c5 <= '>') {
                if (c5 == '<') {
                    if (i9 > i10) {
                        sb.append(charArray, i10, i9 - i10);
                    }
                    i10 = i9 + 1;
                    sb.append(f17650d);
                } else if (c5 == '>') {
                    if (i9 > i10) {
                        sb.append(charArray, i10, i9 - i10);
                    }
                    i10 = i9 + 1;
                    sb.append(f17651e);
                } else if (c5 == '&') {
                    if (i9 > i10) {
                        sb.append(charArray, i10, i9 - i10);
                    }
                    int i11 = i9 + 5;
                    if (length <= i11 || charArray[i9 + 1] != '#' || !Character.isDigit(charArray[i9 + 2]) || !Character.isDigit(charArray[i9 + 3]) || !Character.isDigit(charArray[i9 + 4]) || charArray[i11] != ';') {
                        i10 = i9 + 1;
                        sb.append(f17649c);
                    }
                } else if (c5 == '\"') {
                    if (i9 > i10) {
                        sb.append(charArray, i10, i9 - i10);
                    }
                    i10 = i9 + 1;
                    sb.append(f557a);
                } else if (c5 == '\'') {
                    if (i9 > i10) {
                        sb.append(charArray, i10, i9 - i10);
                    }
                    i10 = i9 + 1;
                    sb.append(f17648b);
                }
            }
            i9++;
        }
        if (i10 == 0) {
            return str;
        }
        if (i9 > i10) {
            sb.append(charArray, i10, i9 - i10);
        }
        return sb.toString();
    }

    public static final String b(String str) {
        return a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", ContainerUtils.FIELD_DELIMITER);
    }

    public static final String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(str2, 0);
        if (iIndexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, iIndexOf);
        sb.append(charArray2);
        int i9 = iIndexOf + length;
        while (true) {
            int iIndexOf2 = str.indexOf(str2, i9);
            if (iIndexOf2 > 0) {
                sb.append(charArray, i9, iIndexOf2 - i9);
                sb.append(charArray2);
                i9 = iIndexOf2 + length;
            } else {
                sb.append(charArray, i9, charArray.length - i9);
                return sb.toString();
            }
        }
    }

    public static String a(byte[] bArr) {
        return String.valueOf(bj.a(bArr));
    }

    public static String a(int i9) {
        if (i9 < 1) {
            return null;
        }
        char[] cArr = new char[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            cArr[i10] = f17652f[f17647a.nextInt(71)];
        }
        return new String(cArr);
    }
}
