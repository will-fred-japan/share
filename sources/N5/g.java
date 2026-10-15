package N5;

import U5.G;
import U5.J;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: ChaCha20Poly1305Jce.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements L5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f3232d = p199z2.b.v("808182838485868788898a8b8c8d8e8f909192939495969798999a9b9c9d9e9f");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f3233e = p199z2.b.v("070000004041424344454647");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f3234f = p199z2.b.v("a0784d7a4716f3feb4f64e7f4b39bf04");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f3235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider f3237c;

    public g(byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!Q5.a.EnumC0044a.f3866a.a()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f3235a = new SecretKeySpec(bArr, "ChaCha20");
        this.f3236b = bArr2;
        this.f3237c = provider;
    }

    public static Cipher c() {
        Cipher cipherA = p004a6.g.f5707b.f5709a.a("ChaCha20-Poly1305");
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f3233e);
            byte[] bArr = f3232d;
            cipherA.init(2, new SecretKeySpec(bArr, "ChaCha20"), ivParameterSpec);
            byte[] bArr2 = f3234f;
            if (cipherA.doFinal(bArr2).length == 0) {
                cipherA.init(2, new SecretKeySpec(bArr, "ChaCha20"), ivParameterSpec);
                if (cipherA.doFinal(bArr2).length == 0) {
                    return cipherA;
                }
            }
        } catch (GeneralSecurityException unused) {
        }
        throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
    }

    @Override // L5.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrA = G.a(12);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrA);
        Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305", this.f3237c);
        cipher.init(1, this.f3235a, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        int outputSize = cipher.getOutputSize(bArr.length);
        byte[] bArr3 = this.f3236b;
        if (outputSize > 2147483635 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
        System.arraycopy(bArrA, 0, bArrCopyOf, bArr3.length, 12);
        if (cipher.doFinal(bArr, 0, bArr.length, bArrCopyOf, bArr3.length + 12) == outputSize) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }

    @Override // L5.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.f3236b;
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!J.b(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = new byte[12];
        System.arraycopy(bArr, bArr3.length, bArr4, 0, 12);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305", this.f3237c);
        cipher.init(2, this.f3235a, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        return cipher.doFinal(bArr, bArr3.length + 12, (bArr.length - bArr3.length) - 12);
    }
}
