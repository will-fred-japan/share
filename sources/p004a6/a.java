package p004a6;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AesCtrJceCipher.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0087a f5683d = new C0087a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f5684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5686c;

    /* JADX INFO: renamed from: a6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AesCtrJceCipher.java */
    public class C0087a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        public final Cipher initialValue() {
            try {
                return g.f5707b.f5709a.a("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    public a(byte[] bArr, int i9) throws GeneralSecurityException {
        if (!Q5.a.EnumC0044a.f3867b.a()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        l.a(bArr.length);
        this.f5684a = new SecretKeySpec(bArr, "AES");
        int blockSize = f5683d.get().getBlockSize();
        this.f5686c = blockSize;
        if (i9 < 12 || i9 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f5685b = i9;
    }

    public final void a(byte[] bArr, int i9, int i10, byte[] bArr2, int i11, byte[] bArr3, boolean z8) throws GeneralSecurityException {
        Cipher cipher = f5683d.get();
        byte[] bArr4 = new byte[this.f5686c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f5685b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        SecretKeySpec secretKeySpec = this.f5684a;
        if (z8) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i9, i10, bArr2, i11) != i10) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}
