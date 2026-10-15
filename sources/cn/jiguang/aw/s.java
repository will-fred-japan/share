package cn.jiguang.aw;

import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.jieli.jl_bt_ota.constant.JL_Constant;
import com.starburst.sdk.core.tts.EventType;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f9543a = {-42, -112, -23, -2, -52, -31, 61, -73, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, JL_Constant.END_FLAG, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, -128, -33, -108, -6, 117, -113, Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, 23, JL_Constant.PREFIX_FLAG_THIRD, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, EventType.ERROR, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, 14, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, 13, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, -68, 127, 17, -39, 92, 65, 31, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, JL_Constant.PREFIX_FLAG_SECOND, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f9544b = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    private static int a(char c5) {
        return (byte) "0123456789abcdef".indexOf(c5);
    }

    private int b(int i9) {
        return a(i9, 24) ^ (((a(i9, 2) ^ i9) ^ a(i9, 10)) ^ a(i9, 18));
    }

    private int c(int i9) {
        return a(i9, 23) ^ (a(i9, 13) ^ i9);
    }

    private int a(int i9) {
        byte[] bArr = this.f9543a;
        return (bArr[i9 & 255] & 255) | ((bArr[(i9 >>> 24) & 255] & 255) << 24) | ((bArr[(i9 >>> 16) & 255] & 255) << 16) | ((bArr[(i9 >>> 8) & 255] & 255) << 8);
    }

    private static byte[] b(byte[] bArr) {
        int length = 16 - (bArr.length % 16);
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + length);
        for (int i9 = 0; i9 < length; i9++) {
            bArrCopyOf[bArr.length + i9] = (byte) length;
        }
        return bArrCopyOf;
    }

    private static byte[] c(byte[] bArr) {
        int length = bArr.length - bArr[bArr.length - 1];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private int a(int i9, int i10) {
        return (i9 >>> (32 - i10)) | (i9 << i10);
    }

    public byte[] b(byte[] bArr, String str) {
        return b(bArr, a(str), str.substring(0, 16).getBytes("utf-8"));
    }

    private static void a(byte[] bArr, byte[] bArr2) {
        for (int i9 = 0; i9 < bArr.length; i9++) {
            bArr[i9] = (byte) (bArr[i9] ^ bArr2[i9]);
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        int[] iArrA = a(bArr2, true);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[bArr.length];
        int i9 = 0;
        while (true) {
            int i10 = i9 + 16;
            if (i10 > bArr.length) {
                return c(bArr6);
            }
            System.arraycopy(bArr, i9, bArr4, 0, 16);
            a(bArr4, bArr5, iArrA);
            if (bArr3 != null) {
                a(bArr5, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            System.arraycopy(bArr, i9, bArr3, 0, 16);
            System.arraycopy(bArr5, 0, bArr6, i9, 16);
            i9 = i10;
        }
    }

    public void a(byte[] bArr, byte[] bArr2, int[] iArr) {
        int[] iArrA = a(bArr);
        for (int i9 = 0; i9 < 32; i9 += 4) {
            int iB = iArrA[0] ^ b(a(((iArrA[1] ^ iArrA[2]) ^ iArrA[3]) ^ iArr[i9]));
            iArrA[0] = iB;
            int iB2 = b(a((iB ^ (iArrA[2] ^ iArrA[3])) ^ iArr[i9 + 1])) ^ iArrA[1];
            iArrA[1] = iB2;
            int iB3 = b(a((iB2 ^ (iArrA[3] ^ iArrA[0])) ^ iArr[i9 + 2])) ^ iArrA[2];
            iArrA[2] = iB3;
            iArrA[3] = b(a((iB3 ^ (iArrA[1] ^ iArrA[0])) ^ iArr[i9 + 3])) ^ iArrA[3];
        }
        for (int i10 = 0; i10 < 16; i10 += 4) {
            int i11 = iArrA[3 - (i10 / 4)];
            bArr2[i10] = (byte) ((i11 >>> 24) & 255);
            bArr2[i10 + 1] = (byte) ((i11 >>> 16) & 255);
            bArr2[i10 + 2] = (byte) ((i11 >>> 8) & 255);
            bArr2[i10 + 3] = (byte) (i11 & 255);
        }
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 2;
            bArr[i9] = (byte) (a(charArray[i10 + 1]) | (a(charArray[i10]) << 4));
        }
        return bArr;
    }

    public byte[] a(byte[] bArr, String str) {
        byte[] bArrA = a(str);
        String strSubstring = str.substring(0, 16);
        cn.jiguang.x.f.c("SM4", "seed=".concat(str));
        return a(bArr, bArrA, strSubstring.getBytes("utf-8"));
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        byte[] bArrB = b(bArr);
        int[] iArrA = a(bArr2, false);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[bArrB.length];
        int i9 = 0;
        while (true) {
            int i10 = i9 + 16;
            if (i10 > bArrB.length) {
                return bArr5;
            }
            System.arraycopy(bArrB, i9, bArr4, 0, 16);
            if (bArr3 != null) {
                a(bArr4, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            a(bArr4, bArr3, iArrA);
            System.arraycopy(bArr3, 0, bArr5, i9, bArr3.length);
            i9 = i10;
        }
    }

    private int[] a(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = i9 * 4;
            iArr[i9] = (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
        }
        return iArr;
    }

    public int[] a(byte[] bArr, boolean z8) {
        int[] iArrA = a(bArr);
        iArrA[0] = iArrA[0] ^ (-1548633402);
        iArrA[1] = iArrA[1] ^ 1453994832;
        iArrA[2] = iArrA[2] ^ 1736282519;
        iArrA[3] = iArrA[3] ^ (-1301273892);
        int[] iArr = new int[32];
        for (int i9 = 0; i9 < 32; i9 += 4) {
            int iC = iArrA[0] ^ c(a(((iArrA[1] ^ iArrA[2]) ^ iArrA[3]) ^ this.f9544b[i9]));
            iArrA[0] = iC;
            iArr[i9] = iC;
            int i10 = i9 + 1;
            int iC2 = iArrA[1] ^ c(a(((iArrA[2] ^ iArrA[3]) ^ iArrA[0]) ^ this.f9544b[i10]));
            iArrA[1] = iC2;
            iArr[i10] = iC2;
            int i11 = i9 + 2;
            int iC3 = iArrA[2] ^ c(a(((iArrA[3] ^ iArrA[0]) ^ iArrA[1]) ^ this.f9544b[i11]));
            iArrA[2] = iC3;
            iArr[i11] = iC3;
            int i12 = i9 + 3;
            int iC4 = iArrA[3] ^ c(a(((iArrA[0] ^ iArrA[1]) ^ iArrA[2]) ^ this.f9544b[i12]));
            iArrA[3] = iC4;
            iArr[i12] = iC4;
        }
        if (z8) {
            for (int i13 = 0; i13 < 16; i13++) {
                int i14 = iArr[i13];
                int i15 = 31 - i13;
                iArr[i13] = iArr[i15];
                iArr[i15] = i14;
            }
        }
        return iArr;
    }
}
