package p004a6;

import L5.a;
import U5.G;
import U5.J;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AesGcmJce.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f5692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f5693b;

    public c(byte[] bArr, p012b6.a aVar) throws GeneralSecurityException {
        if (!Q5.a.EnumC0044a.f3867b.a()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        N5.c.a aVar2 = N5.c.f3215a;
        l.a(bArr.length);
        this.f5692a = new SecretKeySpec(bArr, "AES");
        this.f5693b = aVar.b();
    }

    @Override // L5.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrA = G.a(12);
        AlgorithmParameterSpec algorithmParameterSpecA = N5.c.a(0, bArrA.length, bArrA);
        Cipher cipher = N5.c.f3215a.get();
        cipher.init(1, this.f5692a, algorithmParameterSpecA);
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        int outputSize = cipher.getOutputSize(bArr.length);
        byte[] bArr3 = this.f5693b;
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
        byte[] bArr3 = this.f5693b;
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!J.b(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        AlgorithmParameterSpec algorithmParameterSpecA = N5.c.a(bArr3.length, 12, bArr);
        Cipher cipher = N5.c.f3215a.get();
        cipher.init(2, this.f5692a, algorithmParameterSpecA);
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        return cipher.doFinal(bArr, bArr3.length + 12, (bArr.length - bArr3.length) - 12);
    }
}
