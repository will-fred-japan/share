package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import defpackage.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SecureSSLSocketFactory extends SSLSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15839i = "SecureSSLSocketFactory";
    private static volatile SecureSSLSocketFactory j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f15840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSocket f15841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f15842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f15843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private X509TrustManager f15844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f15845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f15846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f15847h;

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws KeyManagementException {
        this.f15840a = null;
        this.f15841b = null;
        this.f15840a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f15840a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    @Deprecated
    public static void a(X509TrustManager x509TrustManager) {
        e.c(f15839i, "ssf update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            j = new SecureSSLSocketFactory(x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f15839i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f15839i, "NoSuchAlgorithmException");
        }
        f.j(jCurrentTimeMillis, new StringBuilder("update: cost : "), " ms", f15839i);
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                try {
                    if (j == null) {
                        j = new SecureSSLSocketFactory(context, (SecureRandom) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (j.f15842c == null && context != null) {
            j.setContext(context);
        }
        f.j(jCurrentTimeMillis, new StringBuilder("getInstance: cost : "), " ms", f15839i);
        return j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i9) throws IOException {
        e.c(f15839i, "createSocket: host , port");
        Socket socketCreateSocket = this.f15840a.getSocketFactory().createSocket(str, i9);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15841b = sSLSocket;
            this.f15843d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f15845f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f15844e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f15842c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f15847h;
    }

    public SSLContext getSslContext() {
        return this.f15840a;
    }

    public SSLSocket getSslSocket() {
        return this.f15841b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f15843d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f15846g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f15844e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f15845f = strArr;
    }

    public void setContext(Context context) {
        this.f15842c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f15847h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f15840a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f15846g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f15844e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i9) {
        return createSocket(inetAddress.getHostAddress(), i9);
    }

    public SecureSSLSocketFactory(InputStream inputStream, String str, SecureRandom secureRandom) throws KeyManagementException {
        this.f15840a = null;
        this.f15841b = null;
        this.f15840a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f15840a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i9, InetAddress inetAddress, int i10) {
        return createSocket(str, i9);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i9, InetAddress inetAddress2, int i10) {
        return createSocket(inetAddress.getHostAddress(), i9);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i9, boolean z8) throws IOException {
        e.c(f15839i, "createSocket s host port autoClose");
        Socket socketCreateSocket = this.f15840a.getSocketFactory().createSocket(socket, str, i9, z8);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15841b = sSLSocket;
            this.f15843d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f15839i, "ssf update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            j = new SecureSSLSocketFactory(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f15839i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f15839i, "NoSuchAlgorithmException");
        }
        f.j(jCurrentTimeMillis, new StringBuilder("update: cost : "), " ms", f15839i);
    }

    private SecureSSLSocketFactory(Context context, SecureRandom secureRandom) throws KeyManagementException {
        this.f15840a = null;
        this.f15841b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f15844e = secureX509SingleInstance;
        this.f15840a.init(null, new X509TrustManager[]{secureX509SingleInstance}, secureRandom);
    }

    public static SecureSSLSocketFactory getInstance(Context context, SecureRandom secureRandom) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                try {
                    if (j == null) {
                        j = new SecureSSLSocketFactory(context, secureRandom);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (j.f15842c == null && context != null) {
            j.setContext(context);
        }
        f.j(jCurrentTimeMillis, new StringBuilder("getInstance: cost : "), " ms", f15839i);
        return j;
    }

    @Deprecated
    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws KeyManagementException {
        this.f15840a = null;
        this.f15841b = null;
        this.f15840a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15840a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    private void a(Socket socket) {
        boolean z8;
        boolean blackListCipherSuites = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f15847h)) {
            z8 = false;
        } else {
            e.c(f15839i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f15847h);
            z8 = true;
        }
        if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15846g) || !com.huawei.secure.android.common.ssl.util.a.a(this.f15845f)) {
            e.c(f15839i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15846g)) {
                blackListCipherSuites = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f15846g);
            } else {
                blackListCipherSuites = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f15845f);
            }
        }
        if (!z8) {
            e.c(f15839i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (blackListCipherSuites) {
            return;
        }
        e.c(f15839i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws KeyManagementException {
        this.f15840a = null;
        this.f15841b = null;
        this.f15840a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15840a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
