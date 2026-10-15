package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import defpackage.f;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15802i = "SASFCompatiableSystemCA";
    private static volatile SASFCompatiableSystemCA j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f15803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSocket f15804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f15805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f15806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private X509TrustManager f15807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f15808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f15809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f15810h;

    private SASFCompatiableSystemCA(KeyStore keyStore) {
        super(keyStore);
        this.f15804b = null;
    }

    @Deprecated
    public static void a(X509TrustManager x509TrustManager) {
        e.c(f15802i, "sasfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            j = new SASFCompatiableSystemCA(null, x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f15802i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            e.b(f15802i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            e.b(f15802i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            e.b(f15802i, "UnrecoverableKeyException");
        }
        f.j(jCurrentTimeMillis, new StringBuilder("sasf system ca update: cost : "), " ms", f15802i);
    }

    @Deprecated
    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) {
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                try {
                    if (j == null) {
                        j = new SASFCompatiableSystemCA(keyStore, context, (SecureRandom) null);
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
        e.c(f15802i, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.f15803a.getSocketFactory().createSocket(socket, str, i9, z8);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15804b = sSLSocket;
            this.f15806d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f15808f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f15807e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f15805c;
    }

    public String[] getProtocols() {
        return this.f15810h;
    }

    public SSLContext getSslContext() {
        return this.f15803a;
    }

    public SSLSocket getSslSocket() {
        return this.f15804b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f15806d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f15809g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f15807e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f15808f = strArr;
    }

    public void setContext(Context context) {
        this.f15805c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f15810h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f15803a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f15804b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f15809g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f15807e = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context, SecureRandom secureRandom) throws KeyManagementException {
        super(keyStore);
        this.f15804b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager sSFSecureX509SingleInstance = SSFSecureX509SingleInstance.getInstance(context);
        this.f15807e = sSFSecureX509SingleInstance;
        this.f15803a.init(null, new X509TrustManager[]{sSFSecureX509SingleInstance}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.c(f15802i, "createSocket: ");
        Socket socketCreateSocket = this.f15803a.getSocketFactory().createSocket();
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15804b = sSLSocket;
            this.f15806d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) {
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                try {
                    if (j == null) {
                        j = new SASFCompatiableSystemCA(keyStore, context, secureRandom);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    @Deprecated
    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws KeyManagementException {
        super(keyStore);
        this.f15804b = null;
        this.f15803a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15803a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws KeyManagementException {
        super(keyStore);
        this.f15804b = null;
        this.f15803a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15803a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }

    public static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f15802i, "sasfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f15802i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            e.b(f15802i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            e.b(f15802i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            e.b(f15802i, "UnrecoverableKeyException");
        }
        f.j(jCurrentTimeMillis, new StringBuilder("sasf system ca update: cost : "), " ms", f15802i);
    }

    private void a(Socket socket) {
        boolean enabledProtocols;
        boolean blackListCipherSuites = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f15810h)) {
            enabledProtocols = false;
        } else {
            e.c(f15802i, "set protocols");
            enabledProtocols = SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f15810h);
        }
        if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15809g) || !com.huawei.secure.android.common.ssl.util.a.a(this.f15808f)) {
            e.c(f15802i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15809g)) {
                blackListCipherSuites = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f15809g);
            } else {
                blackListCipherSuites = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f15808f);
            }
        }
        if (!enabledProtocols) {
            e.c(f15802i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (blackListCipherSuites) {
            return;
        }
        e.c(f15802i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }
}
