package U5;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;

/* JADX INFO: compiled from: Random.java */
/* JADX INFO: loaded from: classes.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4684a = new a();

    /* JADX INFO: compiled from: Random.java */
    public class a extends ThreadLocal<SecureRandom> {
        /* JADX WARN: Code duplicated, block: B:12:0x002d  */
        /* JADX WARN: Code duplicated, block: B:20:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.ThreadLocal
        public final SecureRandom initialValue() {
            SecureRandom secureRandom;
            Provider provider;
            Provider providerA = C0439a.a();
            if (providerA != null) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG", providerA);
                } catch (GeneralSecurityException unused) {
                    provider = null;
                    try {
                        provider = (Provider) Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", new Class[0]).invoke(null, new Object[0]);
                    } catch (Throwable unused2) {
                    }
                    if (provider != null) {
                        try {
                            secureRandom = SecureRandom.getInstance("SHA1PRNG", provider);
                        } catch (GeneralSecurityException unused3) {
                            secureRandom = new SecureRandom();
                        }
                    } else {
                        secureRandom = new SecureRandom();
                    }
                }
            } else {
                provider = null;
                provider = (Provider) Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", new Class[0]).invoke(null, new Object[0]);
                if (provider != null) {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG", provider);
                } else {
                    secureRandom = new SecureRandom();
                }
            }
            secureRandom.nextLong();
            return secureRandom;
        }
    }

    public static byte[] a(int i9) {
        byte[] bArr = new byte[i9];
        f4684a.get().nextBytes(bArr);
        return bArr;
    }
}
