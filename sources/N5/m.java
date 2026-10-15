package N5;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

/* JADX INFO: compiled from: InsecureNonceChaCha20Poly1305Base.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f3245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f3246b;

    public m(byte[] bArr) throws GeneralSecurityException {
        if (!Q5.a.EnumC0044a.f3866a.a()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.f3245a = d(1, bArr);
        this.f3246b = d(0, bArr);
    }

    public static byte[] c(ByteBuffer byteBuffer, byte[] bArr) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int iRemaining = byteBuffer.remaining();
        int i9 = iRemaining % 16;
        int i10 = (i9 == 0 ? iRemaining : (iRemaining + 16) - i9) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i10 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(i10);
        byteBufferOrder.putLong(bArr.length);
        byteBufferOrder.putLong(iRemaining);
        return byteBufferOrder.array();
    }

    public final byte[] a(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            this.f3246b.a(0, bArr).get(bArr4);
            if (!MessageDigest.isEqual(p199z2.b.u(bArr4, c(byteBuffer, bArr2)), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(iPosition);
            k kVar = this.f3245a;
            kVar.getClass();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            kVar.d(bArr, byteBufferAllocate, byteBuffer);
            return byteBufferAllocate.array();
        } catch (GeneralSecurityException e9) {
            throw new AEADBadTagException(e9.toString());
        }
    }

    public final void b(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBuffer.position();
        k kVar = this.f3245a;
        kVar.getClass();
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        kVar.d(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        byte[] bArr4 = new byte[32];
        this.f3246b.a(0, bArr).get(bArr4);
        byte[] bArrU = p199z2.b.u(bArr4, c(byteBuffer, bArr3));
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(bArrU);
    }

    public abstract k d(int i9, byte[] bArr);
}
