package Y5;

import X5.c;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: PrfAesCmacConscrypt.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f5263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Provider f5264b;

    public b(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (!Q5.a.EnumC0044a.f3866a.a()) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode, as BoringCrypto module is not available");
        }
        this.f5263a = new SecretKeySpec(bArr, "AES");
        this.f5264b = provider;
    }

    @Override // X5.c
    public final byte[] a(int i9, byte[] bArr) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (i9 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength must not be larger than 16");
        }
        Mac mac = Mac.getInstance("AESCMAC", this.f5264b);
        mac.init(this.f5263a);
        byte[] bArrDoFinal = mac.doFinal(bArr);
        return i9 == bArrDoFinal.length ? bArrDoFinal : Arrays.copyOf(bArrDoFinal, i9);
    }
}
