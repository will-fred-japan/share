package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: CertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: CertificateChainCleaner.kt */
    public static final class Companion {
        private Companion() {
        }

        public final CertificateChainCleaner get(X509TrustManager trustManager) {
            k.e(trustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(trustManager);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final CertificateChainCleaner get(X509Certificate... caCerts) {
            k.e(caCerts, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(caCerts, caCerts.length)));
        }
    }

    public abstract List<Certificate> clean(List<? extends Certificate> list, String str);
}
