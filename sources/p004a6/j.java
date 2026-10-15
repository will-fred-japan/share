package p004a6;

import X5.c;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: PrfHmacJce.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f5715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f5717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5718d;

    /* JADX INFO: compiled from: PrfHmacJce.java */
    public class a extends ThreadLocal<Mac> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        public final Mac initialValue() {
            j jVar = j.this;
            try {
                g<h.e, Mac> gVar = g.f5708c;
                Mac macA = gVar.f5709a.a(jVar.f5716b);
                macA.init(jVar.f5717c);
                return macA;
            } catch (GeneralSecurityException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    public j(String str, SecretKeySpec secretKeySpec) throws GeneralSecurityException {
        a aVar = new a();
        this.f5715a = aVar;
        if (!Q5.a.EnumC0044a.f3867b.a()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.f5716b = str;
        this.f5717c = secretKeySpec;
        if (secretKeySpec.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.getClass();
        switch (str) {
            case "HMACSHA1":
                this.f5718d = 20;
                break;
            case "HMACSHA224":
                this.f5718d = 28;
                break;
            case "HMACSHA256":
                this.f5718d = 32;
                break;
            case "HMACSHA384":
                this.f5718d = 48;
                break;
            case "HMACSHA512":
                this.f5718d = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(str));
        }
        aVar.get();
    }

    @Override // X5.c
    public final byte[] a(int i9, byte[] bArr) throws InvalidAlgorithmParameterException {
        if (i9 > this.f5718d) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        a aVar = this.f5715a;
        aVar.get().update(bArr);
        return Arrays.copyOf(aVar.get().doFinal(), i9);
    }
}
