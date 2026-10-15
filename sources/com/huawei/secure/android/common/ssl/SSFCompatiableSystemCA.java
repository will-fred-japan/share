package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import defpackage.f;
import java.io.IOException;
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

/* JADX INFO: loaded from: classes.dex */
public class SSFCompatiableSystemCA extends SSLSocketFactory {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15811i = "SSFCompatiableSystemCA";
    private static volatile SSFCompatiableSystemCA j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f15812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSocket f15813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f15814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f15815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private X509TrustManager f15816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f15817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f15818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f15819h;

    private SSFCompatiableSystemCA(Context context, SecureRandom secureRandom) throws KeyManagementException {
        this.f15812a = null;
        this.f15813b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager sSFSecureX509SingleInstance = SSFSecureX509SingleInstance.getInstance(context);
        this.f15816e = sSFSecureX509SingleInstance;
        this.f15812a.init(null, new X509TrustManager[]{sSFSecureX509SingleInstance}, secureRandom);
    }

    @Deprecated
    public static void a(X509TrustManager x509TrustManager) {
        e.c(f15811i, "ssfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            j = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f15811i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f15811i, "NoSuchAlgorithmException");
        }
        f.j(jCurrentTimeMillis, new StringBuilder("SSF system ca update: cost : "), " ms", f15811i);
    }

    @Deprecated
    public static SSFCompatiableSystemCA getInstance(Context context) {
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                try {
                    if (j == null) {
                        j = new SSFCompatiableSystemCA(context, (SecureRandom) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (j.f15814c == null && context != null) {
            j.setContext(context);
        }
        return j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i9) throws IOException {
        e.c(f15811i, "createSocket: host , port");
        Socket socketCreateSocket = this.f15812a.getSocketFactory().createSocket(str, i9);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15813b = sSLSocket;
            this.f15815d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f15817f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f15816e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f15814c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f15819h;
    }

    public SSLContext getSslContext() {
        return this.f15812a;
    }

    public SSLSocket getSslSocket() {
        return this.f15813b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f15815d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f15818g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f15816e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f15817f = strArr;
    }

    public void setContext(Context context) {
        this.f15814c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f15819h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f15812a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f15818g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f15816e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i9) {
        return createSocket(inetAddress.getHostAddress(), i9);
    }

    @Deprecated
    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws KeyManagementException {
        this.f15812a = null;
        this.f15813b = null;
        this.f15812a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15812a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i9, InetAddress inetAddress, int i10) {
        return createSocket(str, i9);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i9, InetAddress inetAddress2, int i10) {
        return createSocket(inetAddress.getHostAddress(), i9);
    }

    public static SSFCompatiableSystemCA getInstance(Context context, SecureRandom secureRandom) {
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                try {
                    if (j == null) {
                        j = new SSFCompatiableSystemCA(context, secureRandom);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (j.f15814c == null && context != null) {
            j.setContext(context);
        }
        return j;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i9, boolean z8) throws IOException {
        e.c(f15811i, "createSocket: s , host , port , autoClose");
        Socket socketCreateSocket = this.f15812a.getSocketFactory().createSocket(socket, str, i9, z8);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15813b = sSLSocket;
            this.f15815d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f15811i, "ssfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            j = new SSFCompatiableSystemCA(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f15811i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f15811i, "NoSuchAlgorithmException");
        }
        f.j(jCurrentTimeMillis, new StringBuilder("SSF system ca update: cost : "), " ms", f15811i);
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws KeyManagementException {
        this.f15812a = null;
        this.f15813b = null;
        this.f15812a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15812a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }

    private void a(Socket socket) {
        boolean enabledProtocols;
        boolean blackListCipherSuites = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f15819h)) {
            enabledProtocols = false;
        } else {
            e.c(f15811i, "set protocols");
            enabledProtocols = SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f15819h);
        }
        if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15818g) || !com.huawei.secure.android.common.ssl.util.a.a(this.f15817f)) {
            e.c(f15811i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15818g)) {
                blackListCipherSuites = SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f15818g);
            } else {
                blackListCipherSuites = SSLUtil.setBlackListCipherSuites(sSLSocket, this.f15817f);
            }
        }
        if (!enabledProtocols) {
            e.c(f15811i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (blackListCipherSuites) {
            return;
        }
        e.c(f15811i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }
}
