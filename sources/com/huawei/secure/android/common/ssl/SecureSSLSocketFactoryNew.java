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
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15848i = "SSLFNew";
    private static volatile SecureSSLSocketFactoryNew j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SSLContext f15849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected SSLSocket f15850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f15851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String[] f15852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected X509TrustManager f15853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String[] f15854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String[] f15855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String[] f15856h;

    @Deprecated
    public SecureSSLSocketFactoryNew(InputStream inputStream, String str) throws KeyManagementException {
        this.f15849a = null;
        this.f15850b = null;
        this.f15849a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f15849a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    private void a(Socket socket) {
        boolean enabledProtocols;
        boolean whiteListCipherSuites = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f15856h)) {
            enabledProtocols = false;
        } else {
            e.c(f15848i, "set protocols");
            enabledProtocols = SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f15856h);
        }
        if (!com.huawei.secure.android.common.ssl.util.a.a(this.f15855g) || !com.huawei.secure.android.common.ssl.util.a.a(this.f15854f)) {
            e.c(f15848i, "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            whiteListCipherSuites = !com.huawei.secure.android.common.ssl.util.a.a(this.f15855g) ? SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f15855g) : SSLUtil.setBlackListCipherSuites(sSLSocket, this.f15854f);
        }
        if (!enabledProtocols) {
            e.c(f15848i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (whiteListCipherSuites) {
            return;
        }
        e.c(f15848i, "set default cipher");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public static SecureSSLSocketFactoryNew getInstance(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                try {
                    if (j == null) {
                        j = new SecureSSLSocketFactoryNew(context, (SecureRandom) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (j.f15851c == null && context != null) {
            j.setContext(context);
        }
        f.j(jCurrentTimeMillis, new StringBuilder("getInstance: cost : "), " ms", f15848i);
        return j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i9) throws IOException {
        e.c(f15848i, "createSocket: host , port");
        Socket socketCreateSocket = this.f15849a.getSocketFactory().createSocket(str, i9);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15850b = sSLSocket;
            this.f15852d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f15854f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f15853e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f15851c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f15856h;
    }

    public SSLContext getSslContext() {
        return this.f15849a;
    }

    public SSLSocket getSslSocket() {
        return this.f15850b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f15852d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f15855g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f15853e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f15854f = strArr;
    }

    public void setContext(Context context) {
        this.f15851c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f15856h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f15849a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f15855g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f15853e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i9) {
        return createSocket(inetAddress.getHostAddress(), i9);
    }

    public SecureSSLSocketFactoryNew(InputStream inputStream, String str, SecureRandom secureRandom) throws KeyManagementException {
        this.f15849a = null;
        this.f15850b = null;
        this.f15849a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f15849a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
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
        e.c(f15848i, "createSocket");
        Socket socketCreateSocket = this.f15849a.getSocketFactory().createSocket(socket, str, i9, z8);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f15850b = sSLSocket;
            this.f15852d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    private SecureSSLSocketFactoryNew(Context context, SecureRandom secureRandom) throws KeyManagementException {
        this.f15849a = null;
        this.f15850b = null;
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f15853e = secureX509SingleInstance;
        this.f15849a.init(null, new X509TrustManager[]{secureX509SingleInstance}, secureRandom);
    }

    public static SecureSSLSocketFactoryNew getInstance(Context context, SecureRandom secureRandom) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                try {
                    if (j == null) {
                        j = new SecureSSLSocketFactoryNew(context, secureRandom);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (j.f15851c == null && context != null) {
            j.setContext(context);
        }
        f.j(jCurrentTimeMillis, new StringBuilder("getInstance: cost : "), " ms", f15848i);
        return j;
    }

    @Deprecated
    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws KeyManagementException {
        this.f15849a = null;
        this.f15850b = null;
        this.f15849a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15849a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws KeyManagementException {
        this.f15849a = null;
        this.f15850b = null;
        this.f15849a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f15849a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
