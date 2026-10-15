package okhttp3.internal.platform;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: compiled from: ConscryptPlatform.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConscryptPlatform extends Platform {
    public static final Companion Companion;
    private static final boolean isSupported;
    private final Provider provider;

    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ boolean atLeastVersion$default(Companion companion, int i9, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = 0;
            }
            return companion.atLeastVersion(i9, i10, i11);
        }

        public final boolean atLeastVersion(int i9, int i10, int i11) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i9) {
                return version.major() > i9;
            }
            if (version.minor() != i10) {
                return version.minor() > i10;
            }
            return version.patch() >= i11;
        }

        public final ConscryptPlatform buildIfSupported() {
            f fVar = null;
            if (isSupported()) {
                return new ConscryptPlatform(fVar);
            }
            return null;
        }

        public final boolean isSupported() {
            return ConscryptPlatform.isSupported;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        public static final DisabledHostnameVerifier INSTANCE = new DisabledHostnameVerifier();

        private DisabledHostnameVerifier() {
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        public boolean verify(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) {
            return true;
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        boolean z8 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, companion.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && companion.atLeastVersion(2, 1, 0)) {
                z8 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        isSupported = z8;
    }

    private ConscryptPlatform() {
        Provider providerNewProvider = Conscrypt.newProvider();
        k.d(providerNewProvider, "Conscrypt.newProvider()");
        this.provider = providerNewProvider;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        k.e(sslSocket, "sslSocket");
        k.e(protocols, "protocols");
        if (!Conscrypt.isConscrypt(sslSocket)) {
            super.configureTlsExtensions(sslSocket, str, protocols);
            return;
        }
        Conscrypt.setUseSessionTickets(sslSocket, true);
        Object[] array = Platform.Companion.alpnProtocolNames(protocols).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sslSocket) {
        k.e(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket) ? Conscrypt.getApplicationProtocol(sslSocket) : super.getSelectedProtocol(sslSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.provider);
        k.d(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLSocketFactory newSslSocketFactory(X509TrustManager trustManager) throws NoSuchAlgorithmException, KeyManagementException {
        k.e(trustManager, "trustManager");
        SSLContext sSLContextNewSSLContext = newSSLContext();
        sSLContextNewSSLContext.init(null, new TrustManager[]{trustManager}, null);
        SSLSocketFactory socketFactory = sSLContextNewSSLContext.getSocketFactory();
        k.d(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        k.b(trustManagers);
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            String string = Arrays.toString(trustManagers);
            k.d(string, "java.util.Arrays.toString(this)");
            throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
        }
        TrustManager trustManager = trustManagers[0];
        if (trustManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
        Conscrypt.setHostnameVerifier(x509TrustManager, DisabledHostnameVerifier.INSTANCE);
        return x509TrustManager;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        k.e(sslSocketFactory, "sslSocketFactory");
        return null;
    }

    public /* synthetic */ ConscryptPlatform(f fVar) {
        this();
    }
}
