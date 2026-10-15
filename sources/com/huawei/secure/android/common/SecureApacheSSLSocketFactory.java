package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile SecureApacheSSLSocketFactory f15663c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f15664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15665b;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) {
        super(keyStore);
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        SSLUtil.setEnabledProtocols(sSLSocket);
        SSLUtil.setEnableSafeCipherSuites(sSLSocket);
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) {
        if (f15663c == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                try {
                    if (f15663c == null) {
                        f15663c = new SecureApacheSSLSocketFactory(keyStore, context, (SecureRandom) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15663c;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i9, boolean z8) throws IOException {
        Socket socketCreateSocket = this.f15664a.getSocketFactory().createSocket(socket, str, i9, z8);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context, SecureRandom secureRandom) throws KeyManagementException {
        super(keyStore);
        this.f15665b = context;
        this.f15664a = SSLUtil.setSSLContext();
        this.f15664a.init(null, new X509TrustManager[]{new SecureX509TrustManager(this.f15665b)}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        Socket socketCreateSocket = this.f15664a.getSocketFactory().createSocket();
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws KeyManagementException {
        super(keyStore);
        this.f15664a = SSLUtil.setSSLContext();
        this.f15664a.init(null, new X509TrustManager[]{new HiCloudX509TrustManager(inputStream, str)}, null);
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) {
        if (f15663c == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                try {
                    if (f15663c == null) {
                        f15663c = new SecureApacheSSLSocketFactory(keyStore, context, secureRandom);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15663c;
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws KeyManagementException {
        super(keyStore);
        this.f15664a = SSLUtil.setSSLContext();
        this.f15664a.init(null, new X509TrustManager[]{new HiCloudX509TrustManager(inputStream, str)}, secureRandom);
    }
}
