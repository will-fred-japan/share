package p004a6;

import com.starburst.sdk.core.tts.EventType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f5700a = Charset.forName("UTF-8");

    /* JADX INFO: compiled from: Base64.java */
    public static abstract class a {
    }

    /* JADX INFO: compiled from: Base64.java */
    public static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f5701a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    /* JADX INFO: compiled from: Base64.java */
    public static class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f5702a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, EventType.ERROR, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        if (r7 != 4) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p004a6.e.a(java.lang.String):byte[]");
    }

    public static String b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = c.f5702a;
        int i9 = (length / 3) * 4;
        if (length % 3 > 0) {
            i9 += 4;
        }
        byte[] bArr3 = new byte[i9];
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int i13 = i10 + 3;
            if (i13 > length) {
                break;
            }
            int i14 = (bArr[i10 + 2] & 255) | ((bArr[i10] & 255) << 16) | ((bArr[i10 + 1] & 255) << 8);
            bArr3[i12] = bArr2[(i14 >> 18) & 63];
            bArr3[i12 + 1] = bArr2[(i14 >> 12) & 63];
            bArr3[i12 + 2] = bArr2[(i14 >> 6) & 63];
            bArr3[i12 + 3] = bArr2[i14 & 63];
            int i15 = i12 + 4;
            i11--;
            if (i11 == 0) {
                i12 += 5;
                bArr3[i15] = 10;
                i11 = 19;
            } else {
                i12 = i15;
            }
            i10 = i13;
        }
        if (i10 == length - 1) {
            int i16 = (bArr[i10] & 255) << 4;
            bArr3[i12] = bArr2[(i16 >> 6) & 63];
            bArr3[i12 + 1] = bArr2[i16 & 63];
            bArr3[i12 + 2] = 61;
            bArr3[i12 + 3] = 61;
        } else if (i10 == length - 2) {
            int i17 = ((bArr[i10 + 1] & 255) << 2) | ((bArr[i10] & 255) << 10);
            bArr3[i12] = bArr2[(i17 >> 12) & 63];
            bArr3[i12 + 1] = bArr2[(i17 >> 6) & 63];
            bArr3[i12 + 2] = bArr2[i17 & 63];
            bArr3[i12 + 3] = 61;
        }
        return new String(bArr3, StandardCharsets.US_ASCII);
    }
}
