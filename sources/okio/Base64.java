package okio;

import java.util.Arrays;
import kotlin.jvm.internal.k;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: compiled from: Base64.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Base64 {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] decodeBase64ToArray(String str) {
        int i9;
        char cCharAt;
        k.e(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i10 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i10];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            char cCharAt2 = str.charAt(i14);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i9 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                i9 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                i9 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i9 = 62;
            } else {
                if (cCharAt2 == '/' || cCharAt2 == '_') {
                    i9 = 63;
                } else if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i12 = (i12 << 6) | i9;
            i11++;
            if (i11 % 4 == 0) {
                bArr[i13] = (byte) (i12 >> 16);
                int i15 = i13 + 2;
                bArr[i13 + 1] = (byte) (i12 >> 8);
                i13 += 3;
                bArr[i15] = (byte) i12;
            }
        }
        int i16 = i11 % 4;
        if (i16 == 1) {
            return null;
        }
        if (i16 == 2) {
            bArr[i13] = (byte) ((i12 << 12) >> 16);
            i13++;
        } else if (i16 == 3) {
            int i17 = i12 << 6;
            int i18 = i13 + 1;
            bArr[i13] = (byte) (i17 >> 16);
            i13 += 2;
            bArr[i18] = (byte) (i17 >> 8);
        }
        if (i13 == i10) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i13);
        k.d(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final String encodeBase64(byte[] bArr, byte[] map) {
        k.e(bArr, "<this>");
        k.e(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i9 = 0;
        int i10 = 0;
        while (i9 < length) {
            byte b9 = bArr[i9];
            int i11 = i9 + 2;
            byte b10 = bArr[i9 + 1];
            i9 += 3;
            byte b11 = bArr[i11];
            bArr2[i10] = map[(b9 & 255) >> 2];
            bArr2[i10 + 1] = map[((b9 & 3) << 4) | ((b10 & 255) >> 4)];
            int i12 = i10 + 3;
            bArr2[i10 + 2] = map[((b10 & 15) << 2) | ((b11 & 255) >> 6)];
            i10 += 4;
            bArr2[i12] = map[b11 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b12 = bArr[i9];
            bArr2[i10] = map[(b12 & 255) >> 2];
            bArr2[i10 + 1] = map[(b12 & 3) << 4];
            bArr2[i10 + 2] = 61;
            bArr2[i10 + 3] = 61;
        } else if (length2 == 2) {
            int i13 = i9 + 1;
            byte b13 = bArr[i9];
            byte b14 = bArr[i13];
            bArr2[i10] = map[(b13 & 255) >> 2];
            bArr2[i10 + 1] = map[((b13 & 3) << 4) | ((b14 & 255) >> 4)];
            bArr2[i10 + 2] = map[(b14 & 15) << 2];
            bArr2[i10 + 3] = 61;
        }
        return _JvmPlatformKt.toUtf8String(bArr2);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }
}
