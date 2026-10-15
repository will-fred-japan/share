package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;
import y7.i;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes2.dex */
public class Platform {
    public static final Companion Companion;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    private static volatile Platform platform;

    /* JADX INFO: compiled from: Platform.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform platformBuildIfSupported = Android10Platform.Companion.buildIfSupported();
            if (platformBuildIfSupported != null) {
                return platformBuildIfSupported;
            }
            Platform platformBuildIfSupported2 = AndroidPlatform.Companion.buildIfSupported();
            k.b(platformBuildIfSupported2);
            return platformBuildIfSupported2;
        }

        private final Platform findJvmPlatform() {
            OpenJSSEPlatform openJSSEPlatformBuildIfSupported;
            BouncyCastlePlatform bouncyCastlePlatformBuildIfSupported;
            ConscryptPlatform conscryptPlatformBuildIfSupported;
            if (isConscryptPreferred() && (conscryptPlatformBuildIfSupported = ConscryptPlatform.Companion.buildIfSupported()) != null) {
                return conscryptPlatformBuildIfSupported;
            }
            if (isBouncyCastlePreferred() && (bouncyCastlePlatformBuildIfSupported = BouncyCastlePlatform.Companion.buildIfSupported()) != null) {
                return bouncyCastlePlatformBuildIfSupported;
            }
            if (isOpenJSSEPreferred() && (openJSSEPlatformBuildIfSupported = OpenJSSEPlatform.Companion.buildIfSupported()) != null) {
                return openJSSEPlatformBuildIfSupported;
            }
            Jdk9Platform jdk9PlatformBuildIfSupported = Jdk9Platform.Companion.buildIfSupported();
            if (jdk9PlatformBuildIfSupported != null) {
                return jdk9PlatformBuildIfSupported;
            }
            Platform platformBuildIfSupported = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            return platformBuildIfSupported != null ? platformBuildIfSupported : new Platform();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Platform findPlatform() {
            return isAndroid() ? findAndroidPlatform() : findJvmPlatform();
        }

        private final boolean isBouncyCastlePreferred() {
            Provider provider = Security.getProviders()[0];
            k.d(provider, "Security.getProviders()[0]");
            return "BC".equals(provider.getName());
        }

        private final boolean isConscryptPreferred() {
            Provider provider = Security.getProviders()[0];
            k.d(provider, "Security.getProviders()[0]");
            return "Conscrypt".equals(provider.getName());
        }

        private final boolean isOpenJSSEPreferred() {
            Provider provider = Security.getProviders()[0];
            k.d(provider, "Security.getProviders()[0]");
            return "OpenJSSE".equals(provider.getName());
        }

        public static /* synthetic */ void resetForTests$default(Companion companion, Platform platform, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                platform = companion.findPlatform();
            }
            companion.resetForTests(platform);
        }

        public final List<String> alpnProtocolNames(List<? extends Protocol> protocols) {
            k.e(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(i.E(arrayList));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] concatLengthPrefixed(List<? extends Protocol> protocols) {
            k.e(protocols, "protocols");
            Buffer buffer = new Buffer();
            for (String str : alpnProtocolNames(protocols)) {
                buffer.writeByte(str.length());
                buffer.writeUtf8(str);
            }
            return buffer.readByteArray();
        }

        public final Platform get() {
            return Platform.platform;
        }

        public final boolean isAndroid() {
            return "Dalvik".equals(System.getProperty("java.vm.name"));
        }

        public final void resetForTests(Platform platform) {
            k.e(platform, "platform");
            Platform.platform = platform;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        platform = companion.findPlatform();
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static final Platform get() {
        return Companion.get();
    }

    public static /* synthetic */ void log$default(Platform platform2, String str, int i9, Throwable th, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i10 & 2) != 0) {
            i9 = 4;
        }
        if ((i10 & 4) != 0) {
            th = null;
        }
        platform2.log(str, i9, th);
    }

    public void afterHandshake(SSLSocket sslSocket) {
        k.e(sslSocket, "sslSocket");
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager trustManager) {
        k.e(trustManager, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(trustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager trustManager) {
        k.e(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        k.d(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureTlsExtensions(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        k.e(sslSocket, "sslSocket");
        k.e(protocols, "protocols");
    }

    public void connectSocket(Socket socket, InetSocketAddress address, int i9) throws IOException {
        k.e(socket, "socket");
        k.e(address, "address");
        socket.connect(address, i9);
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sslSocket) {
        k.e(sslSocket, "sslSocket");
        return null;
    }

    public Object getStackTraceForCloseable(String closer) {
        k.e(closer, "closer");
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String hostname) {
        k.e(hostname, "hostname");
        return true;
    }

    public void log(String message, int i9, Throwable th) {
        k.e(message, "message");
        logger.log(i9 == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void logCloseableLeak(String message, Object obj) {
        k.e(message, "message");
        if (obj == null) {
            message = message.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(message, 5, (Throwable) obj);
    }

    public SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        k.d(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager trustManager) {
        k.e(trustManager, "trustManager");
        try {
            SSLContext sSLContextNewSSLContext = newSSLContext();
            sSLContextNewSSLContext.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextNewSSLContext.getSocketFactory();
            k.d(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e9) {
            throw new AssertionError("No System TLS: " + e9, e9);
        }
    }

    public X509TrustManager platformTrustManager() {
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
        if (trustManager != null) {
            return (X509TrustManager) trustManager;
        }
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        k.e(sslSocketFactory, "sslSocketFactory");
        try {
            Object fieldOrNull = Util.readFieldOrNull(sslSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (fieldOrNull != null) {
                return (X509TrustManager) Util.readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager");
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e9) {
            if (!e9.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
                throw e9;
            }
            return null;
        }
    }
}
