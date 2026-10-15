package N5;

import com.starburst.sdk.core.tts.EventType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: ChaCha20Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f3242a = e(new byte[]{101, 120, 112, 97, 110, EventType.ERROR, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int[] iArrB = b(e(bArr), e(bArr2));
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(iArrB.length * 4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrB);
        return byteBufferOrder.array();
    }

    public static int[] b(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        int[] iArr4 = f3242a;
        System.arraycopy(iArr4, 0, iArr3, 0, iArr4.length);
        System.arraycopy(iArr, 0, iArr3, iArr4.length, 8);
        iArr3[12] = iArr2[0];
        iArr3[13] = iArr2[1];
        iArr3[14] = iArr2[2];
        iArr3[15] = iArr2[3];
        d(iArr3);
        iArr3[4] = iArr3[12];
        iArr3[5] = iArr3[13];
        iArr3[6] = iArr3[14];
        iArr3[7] = iArr3[15];
        return Arrays.copyOf(iArr3, 8);
    }

    public static void c(int i9, int i10, int i11, int i12, int[] iArr) {
        int i13 = iArr[i9] + iArr[i10];
        iArr[i9] = i13;
        int i14 = i13 ^ iArr[i12];
        int i15 = (i14 >>> (-16)) | (i14 << 16);
        iArr[i12] = i15;
        int i16 = iArr[i11] + i15;
        iArr[i11] = i16;
        int i17 = iArr[i10] ^ i16;
        int i18 = (i17 >>> (-12)) | (i17 << 12);
        iArr[i10] = i18;
        int i19 = iArr[i9] + i18;
        iArr[i9] = i19;
        int i20 = iArr[i12] ^ i19;
        int i21 = (i20 >>> (-8)) | (i20 << 8);
        iArr[i12] = i21;
        int i22 = iArr[i11] + i21;
        iArr[i11] = i22;
        int i23 = iArr[i10] ^ i22;
        iArr[i10] = (i23 >>> (-7)) | (i23 << 7);
    }

    public static void d(int[] iArr) {
        for (int i9 = 0; i9 < 10; i9++) {
            c(0, 4, 8, 12, iArr);
            c(1, 5, 9, 13, iArr);
            c(2, 6, 10, 14, iArr);
            c(3, 7, 11, 15, iArr);
            c(0, 5, 10, 15, iArr);
            c(1, 6, 11, 12, iArr);
            c(2, 7, 8, 13, iArr);
            c(3, 4, 9, 14, iArr);
        }
    }

    public static int[] e(byte[] bArr) {
        if (bArr.length % 4 != 0) {
            throw new IllegalArgumentException("invalid input length");
        }
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }
}
