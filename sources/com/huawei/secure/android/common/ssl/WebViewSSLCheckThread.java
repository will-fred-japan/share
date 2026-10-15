package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.e;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import com.starburst.sdk.req.GuiControlRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* JADX INFO: loaded from: classes.dex */
public class WebViewSSLCheckThread extends Thread {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15868i = "WebViewSSLCheckThread";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f15869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HostnameVerifier f15870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f15871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private X509HostnameVerifier f15872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SslErrorHandler f15873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Callback f15875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f15876h;

    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    public static class a implements okhttp3.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f15877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f15880d;

        public a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f15877a = callback;
            this.f15878b = context;
            this.f15879c = str;
            this.f15880d = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            e.b(WebViewSSLCheckThread.f15868i, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.f15877a;
            if (callback != null) {
                callback.onCancel(this.f15878b, this.f15879c);
            } else {
                this.f15880d.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            e.b(WebViewSSLCheckThread.f15868i, "onResponse . proceed");
            Callback callback = this.f15877a;
            if (callback != null) {
                callback.onProceed(this.f15878b, this.f15879c);
            } else {
                this.f15880d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    private void b() throws IOException {
        this.f15871c.setHostnameVerifier(this.f15872d);
        org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory = this.f15871c;
        if (sSLSocketFactory instanceof SecureApacheSSLSocketFactory) {
            ((SecureApacheSSLSocketFactory) sSLSocketFactory).setContext(this.f15876h);
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("https", this.f15871c, 443));
        schemeRegistry.register(new Scheme(GuiControlRequest.IMAGE_TYPE_HTTP, PlainSocketFactory.getSocketFactory(), 80));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(new URI(this.f15874f));
        HttpResponse httpResponseExecute = defaultHttpClient.execute(httpGet);
        e.c(f15868i, "status code is : " + httpResponseExecute.getStatusLine().getStatusCode());
    }

    private void c() {
        String str = f15868i;
        e.c(str, "callbackCancel: ");
        Callback callback = this.f15875g;
        if (callback != null) {
            callback.onCancel(this.f15876h, this.f15874f);
        } else if (this.f15873e != null) {
            e.c(str, "callbackCancel 2: ");
            this.f15873e.cancel();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    private void d() {
        e.c(f15868i, "callbackProceed: ");
        Callback callback = this.f15875g;
        if (callback != null) {
            callback.onProceed(this.f15876h, this.f15874f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f15873e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    private void e() throws Throwable {
        HttpsURLConnection httpsURLConnection;
        Throwable th;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            URLConnection uRLConnectionOpenConnection = new URL(this.f15874f).openConnection();
            if (uRLConnectionOpenConnection instanceof HttpsURLConnection) {
                httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                try {
                    httpsURLConnection.setSSLSocketFactory(this.f15869a);
                    httpsURLConnection.setHostnameVerifier(this.f15870b);
                    httpsURLConnection.setRequestMethod(HttpRequestBean.METHOD_GET);
                    httpsURLConnection.setConnectTimeout(10000);
                    httpsURLConnection.setReadTimeout(BluetoothConstant.RECEIVE_OTA_CMD_TIMEOUT);
                    httpsURLConnection.connect();
                    httpsURLConnection2 = httpsURLConnection;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
        } catch (Throwable th3) {
            httpsURLConnection = null;
            th = th3;
        }
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f15872d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f15871c;
    }

    public Callback getCallback() {
        return this.f15875g;
    }

    public Context getContext() {
        return this.f15876h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f15870b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f15873e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f15869a;
    }

    public String getUrl() {
        return this.f15874f;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        super.run();
        if (this.f15871c == null || this.f15872d == null) {
            if (this.f15869a == null || this.f15870b == null) {
                c();
                return;
            }
            try {
                e();
                d();
                return;
            } catch (Exception e9) {
                e.b(f15868i, "exception : " + e9.getMessage());
                c();
                return;
            }
        }
        if (this.f15873e == null || TextUtils.isEmpty(this.f15874f)) {
            e.b(f15868i, "sslErrorHandler or url is null");
            c();
            return;
        }
        try {
            b();
            d();
        } catch (Exception e10) {
            e.b(f15868i, "run: exception : " + e10.getMessage());
            c();
        }
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.f15872d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f15871c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.f15875g = callback;
    }

    public void setContext(Context context) {
        this.f15876h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f15870b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f15873e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f15869a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f15874f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory(null, new c(context)));
        } catch (UnrecoverableKeyException e9) {
            e.b(f15868i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e9.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            e.b(f15868i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new c(context));
            secureSSLSocketFactoryNew.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactoryNew, new c(context));
            builder.hostnameVerifier(new StrictHostnameVerifier());
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new a(callback, context, str, sslErrorHandler));
        } catch (Exception e9) {
            e.b(f15868i, "checkServerCertificateWithOK: exception : " + e9.getMessage());
            sslErrorHandler.cancel();
        }
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.f15873e = sslErrorHandler;
        this.f15874f = str;
        this.f15871c = sSLSocketFactory;
        this.f15872d = x509HostnameVerifier;
        this.f15875g = callback;
        this.f15876h = context;
    }
}
