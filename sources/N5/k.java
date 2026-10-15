package N5;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: InsecureNonceChaCha20Base.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f3243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3244b;

    public k(byte[] bArr, int i9) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f3243a = i.e(bArr);
        this.f3244b = i9;
    }

    public final ByteBuffer a(int i9, byte[] bArr) {
        int[] iArrB = b(i.e(bArr), i9);
        int[] iArr = (int[]) iArrB.clone();
        i.d(iArr);
        for (int i10 = 0; i10 < iArrB.length; i10++) {
            iArrB[i10] = iArrB[i10] + iArr[i10];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrB, 0, 16);
        return byteBufferOrder;
    }

    public abstract int[] b(int[] iArr, int i9);

    public abstract int c();

    public final void d(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != c()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + c());
        }
        int iRemaining = byteBuffer2.remaining();
        int i9 = iRemaining / 64;
        int i10 = i9 + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer byteBufferA = a(this.f3244b + i11, bArr);
            if (i11 == i9) {
                A1.b.q1(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                A1.b.q1(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }
}
