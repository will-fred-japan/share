package N5;

import U5.G;
import U5.J;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AesGcmSiv.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements L5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f3220d = p199z2.b.v("7a806c");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f3221e = p199z2.b.v("46bb91c3c5");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f3222f = p199z2.b.v("36864200e0eaf5284d884a0e77d31646");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f3223g = p199z2.b.v("bae8e37fc83441b16034566b");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f3224h = p199z2.b.v("af60eb711bd85bc1e4d3e0a462e074eea428a8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A.f f3225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SecretKeySpec f3226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f3227c;

    public e(byte[] bArr, byte[] bArr2, A.f fVar) throws InvalidAlgorithmParameterException {
        this.f3227c = bArr2;
        p004a6.l.a(bArr.length);
        this.f3226b = new SecretKeySpec(bArr, "AES");
        this.f3225a = fVar;
    }

    public static boolean c(Cipher cipher) {
        try {
            byte[] bArr = f3223g;
            cipher.init(2, new SecretKeySpec(f3222f, "AES"), new GCMParameterSpec(128, bArr, 0, bArr.length));
            cipher.updateAAD(f3221e);
            byte[] bArr2 = f3224h;
            return MessageDigest.isEqual(cipher.doFinal(bArr2, 0, bArr2.length), f3220d);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // L5.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipherG = this.f3225a.g();
        int length = bArr.length;
        byte[] bArr3 = this.f3227c;
        if (length > 2147483619 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + bArr.length + 16);
        byte[] bArrA = G.a(12);
        System.arraycopy(bArrA, 0, bArrCopyOf, bArr3.length, 12);
        cipherG.init(1, this.f3226b, new GCMParameterSpec(128, bArrA, 0, bArrA.length));
        if (bArr2 != null && bArr2.length != 0) {
            cipherG.updateAAD(bArr2);
        }
        int iDoFinal = cipherG.doFinal(bArr, 0, bArr.length, bArrCopyOf, bArr3.length + 12);
        if (iDoFinal == bArr.length + 16) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException(defpackage.f.b(iDoFinal - bArr.length, "encryption failed; AES-GCM-SIV tag must be 16 bytes, but got only ", " bytes"));
    }

    @Override // L5.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.f3227c;
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!J.b(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipherG = this.f3225a.g();
        cipherG.init(2, this.f3226b, new GCMParameterSpec(128, bArr, bArr3.length, 12));
        if (bArr2 != null && bArr2.length != 0) {
            cipherG.updateAAD(bArr2);
        }
        return cipherG.doFinal(bArr, bArr3.length + 12, (bArr.length - bArr3.length) - 12);
    }
}
