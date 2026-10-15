package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.SecureRandom;
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
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f15666c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f15667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15668b;

    private SecureSSLSocketFactory(Context context, SecureRandom secureRandom) throws KeyManagementException {
        this.f15667a = null;
        this.f15668b = context;
        this.f15667a = SSLUtil.setSSLContext();
        this.f15667a.init(null, new X509TrustManager[]{new SecureX509TrustManager(this.f15668b)}, secureRandom);
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        SSLUtil.setEnabledProtocols(sSLSocket);
        SSLUtil.setEnableSafeCipherSuites(sSLSocket);
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) {
        if (f15666c == null) {
            synchronized (SecureSSLSocketFactory.class) {
                try {
                    if (f15666c == null) {
                        f15666c = new SecureSSLSocketFactory(context, (SecureRandom) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15666c;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i9) throws IOException {
        Socket socketCreateSocket = this.f15667a.getSocketFactory().createSocket(str, i9);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i9) {
        return createSocket(inetAddress.getHostAddress(), i9);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i9, InetAddress inetAddress, int i10) {
        return createSocket(str, i9);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i9, InetAddress inetAddress2, int i10) {
        return createSocket(inetAddress.getHostAddress(), i9);
    }

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws KeyManagementException {
        this.f15667a = null;
        this.f15667a = SSLUtil.setSSLContext();
        this.f15667a.init(null, new X509TrustManager[]{new HiCloudX509TrustManager(inputStream, str)}, null);
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context, SecureRandom secureRandom) {
        if (f15666c == null) {
            synchronized (SecureSSLSocketFactory.class) {
                try {
                    if (f15666c == null) {
                        f15666c = new SecureSSLSocketFactory(context, secureRandom);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15666c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i9, boolean z8) throws IOException {
        Socket socketCreateSocket = this.f15667a.getSocketFactory().createSocket(socket, str, i9, z8);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
        }
        return socketCreateSocket;
    }

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str, SecureRandom secureRandom) throws KeyManagementException {
        this.f15667a = null;
        this.f15667a = SSLUtil.setSSLContext();
        this.f15667a.init(null, new X509TrustManager[]{new HiCloudX509TrustManager(inputStream, str)}, secureRandom);
    }
}
