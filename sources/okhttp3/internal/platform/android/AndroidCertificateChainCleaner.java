package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.tls.CertificateChainCleaner;

/* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);
    private final X509TrustManager trustManager;
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    /* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
    public static final class Companion {
        private Companion() {
        }

        @SuppressSignatureCheck
        public final AndroidCertificateChainCleaner buildIfSupported(X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            k.e(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new AndroidCertificateChainCleaner(trustManager, x509TrustManagerExtensions);
            }
            return null;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public AndroidCertificateChainCleaner(X509TrustManager trustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        k.e(trustManager, "trustManager");
        k.e(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.trustManager = trustManager;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    @SuppressSignatureCheck
    public List<Certificate> clean(List<? extends Certificate> chain, String hostname) throws SSLPeerUnverifiedException {
        k.e(chain, "chain");
        k.e(hostname, "hostname");
        Object[] array = chain.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        try {
            List<X509Certificate> listCheckServerTrusted = this.x509TrustManagerExtensions.checkServerTrusted((X509Certificate[]) array, "RSA", hostname);
            k.d(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e9) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e9.getMessage());
            sSLPeerUnverifiedException.initCause(e9);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) obj).trustManager == this.trustManager;
    }

    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }
}
