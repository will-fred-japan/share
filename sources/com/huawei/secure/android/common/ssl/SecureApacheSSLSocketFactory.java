package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: classes.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15830i = "SecureApacheSSLSocketFactory";
    private static volatile SecureApacheSSLSocketFactory j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f15831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSocket f15832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f15833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f15834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private X509TrustManager f15835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f15836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f15837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f15838h;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) {
        super(keyStore);
        this.f15832b = null;
    }

    @Deprecated
    public static void a(X509TrustManager x509TrustManager) {
        e.c(f15830i, "sasf update socket factory trust manager");
        try {
            j = new SecureApacheSSLSocketFactory(null, x509TrustManager);
        } catch (IOException unused) {
            e.b(f15830i, "IOException");
        } catch (KeyManagementException unused2) {
            e.b(f15830i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            e.b(f15830i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            e.b(f15830i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            e.b(f15830i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            e.b(f15830i, "CertificateException");
        }
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) {
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                try {
                    if (j == null) {
                        j = new SecureApacheSSLSocketFactory(keyStore, context, (SecureRandom) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i9, boolean z8) throws IOException {
        e.c(f15830i, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.f15831a.getSocketFactory().createSocket(socket, str, i9, z8);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15832b = sSLSocket;
            this.f15834d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f15836f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f15835e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f15833c;
    }

    public String[] getProtocols() {
        return this.f15838h;
    }

    public SSLContext getSslContext() {
        return this.f15831a;
    }

    public SSLSocket getSslSocket() {
        return this.f15832b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f15834d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f15837g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f15835e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f15836f = strArr;
    }

    public void setContext(Context context) {
        this.f15833c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f15838h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f15831a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f15832b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f15837g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f15835e = x509TrustManager;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context, SecureRandom secureRandom) throws KeyManagementException {
        super(keyStore);
        this.f15832b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f15835e = secureX509SingleInstance;
        this.f15831a.init(null, new X509TrustManager[]{secureX509SingleInstance}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.c(f15830i, "createSocket: ");
        Socket socketCreateSocket = this.f15831a.getSocketFactory().createSocket();
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15832b = sSLSocket;
            this.f15834d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) {
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                try {
                    if (j == null) {
                        j = new SecureApacheSSLSocketFactory(keyStore, context, secureRandom);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws KeyManagementException {
        super(keyStore);
        this.f15832b = null;
        this.f15831a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f15831a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    public static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f15830i, "sasf update socket factory trust manager");
        try {
            j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager, secureRandom);
        } catch (IOException unused) {
            e.b(f15830i, "IOException");
        } catch (KeyManagementException unused2) {
            e.b(f15830i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            e.b(f15830i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            e.b(f15830i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            e.b(f15830i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            e.b(f15830i, "CertificateException");
        }
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws KeyManagementException {
        super(keyStore);
        this.f15832b = null;
        this.f15831a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f15831a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    private void a(Socket socket) {
        boolean enabledProtocols;
        boolean blackListCipherSuites = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f15838h)) {
            enabledProtocols = false;
        } else {
            e.c(f15830i, "set protocols");
            enabledProtocols = SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f15838h);
        }
        if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15837g) || !com.huawei.secure.android.common.ssl.util.a.a(this.f15836f)) {
            e.c(f15830i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15837g)) {
                blackListCipherSuites = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f15837g);
            } else {
                blackListCipherSuites = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f15836f);
            }
        }
        if (!enabledProtocols) {
            e.c(f15830i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (blackListCipherSuites) {
            return;
        }
        e.c(f15830i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws KeyManagementException {
        super(keyStore);
        this.f15832b = null;
        this.f15831a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15831a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws KeyManagementException {
        super(keyStore);
        this.f15832b = null;
        this.f15831a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15831a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
