package p149t1;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;
import p061i1.h;
import p165v1.c;
import p165v1.d;
import p165v1.e;

/* JADX INFO: compiled from: HttpsURLConnectionExtension.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends HttpsURLConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final J6.a f21392c = p191y1.a.f22366a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpsURLConnection f21393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p182x1.a f21394b;

    /* JADX INFO: compiled from: HttpsURLConnectionExtension.java */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p182x1.a f21395a;

        public a(p182x1.a aVar) {
            this.f21395a = aVar;
        }

        @Override // p165v1.d
        public final void a(c cVar) {
            p182x1.a aVar = this.f21395a;
            if (!aVar.b()) {
                aVar.a(cVar.f21886a);
            }
            b.this.b(cVar.f21887b);
        }

        @Override // p165v1.d
        public final void b(c cVar) {
            p182x1.a aVar = this.f21395a;
            if (aVar.b()) {
                return;
            }
            b bVar = b.this;
            long contentLength = bVar.f21393a.getContentLength();
            if (contentLength < 0) {
                contentLength = cVar.f21886a;
            }
            aVar.a(contentLength);
            bVar.c(aVar);
        }
    }

    /* JADX INFO: renamed from: t1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpsURLConnectionExtension.java */
    public class C0257b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p182x1.a f21397a;

        public C0257b(p182x1.a aVar) {
            this.f21397a = aVar;
        }

        @Override // p165v1.d
        public final void a(c cVar) {
            p182x1.a aVar = this.f21397a;
            if (!aVar.b()) {
                aVar.c(cVar.f21886a);
            }
            b.this.b(cVar.f21887b);
        }

        @Override // p165v1.d
        public final void b(c cVar) {
            long j;
            p182x1.a aVar = this.f21397a;
            if (aVar.b()) {
                return;
            }
            b bVar = b.this;
            String requestProperty = bVar.f21393a.getRequestProperty("content-length");
            if (requestProperty != null) {
                try {
                    j = Long.parseLong(requestProperty);
                } catch (NumberFormatException unused) {
                    j = cVar.f21886a;
                }
            } else {
                j = cVar.f21886a;
            }
            aVar.c(j);
            bVar.c(aVar);
        }
    }

    public b(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        this.f21393a = httpsURLConnection;
    }

    public final void a() {
        if (e().b()) {
            return;
        }
        c.b(e(), this.f21393a);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        this.f21393a.addRequestProperty(str, str2);
    }

    public final void b(IOException iOException) {
        HttpsURLConnection httpsURLConnection = this.f21393a;
        try {
            p182x1.a aVarE = e();
            c.a(aVarE, iOException);
            if (aVarE.b()) {
                return;
            }
            c.b(aVarE, httpsURLConnection);
            aVarE.f22275b.f22061e.f22094d = httpsURLConnection.usingProxy();
            A1.b.X(aVarE);
        } catch (Exception unused) {
        }
    }

    public final void c(p182x1.a aVar) {
        if (aVar != null) {
            try {
                aVar.f22275b.f22061e.f22094d = this.f21393a.usingProxy();
                a();
                A1.b.X(aVar);
            } catch (Exception unused) {
            }
        }
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        HttpsURLConnection httpsURLConnection = this.f21393a;
        e();
        try {
            p182x1.a aVar = this.f21394b;
            if (aVar != null) {
                p173w1.c cVar = aVar.f22275b;
                JSONObject jSONObject = cVar.f22062f;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String requestProperty = httpsURLConnection.getRequestProperty("Host");
                if (!TextUtils.isEmpty(requestProperty)) {
                    try {
                        jSONObject.put("Host", requestProperty);
                    } catch (JSONException e9) {
                        e9.printStackTrace();
                    }
                }
                cVar.f22062f = jSONObject;
            }
            d();
        } catch (Exception unused) {
        }
        try {
            httpsURLConnection.connect();
        } catch (IOException e10) {
            b(e10);
            throw e10;
        }
    }

    public final void d() {
        HttpsURLConnection httpsURLConnection = this.f21393a;
        try {
            if (h.f19247u) {
                if (TextUtils.isEmpty(httpsURLConnection.getRequestProperty("x-rum-traceparent"))) {
                    String strU0 = A1.b.U0();
                    httpsURLConnection.setRequestProperty("x-rum-traceparent", strU0);
                    if (h.f19230b) {
                        Log.d("ApmInsight", p199z2.b.f(new String[]{"x-rum-traceparent:" + strU0}));
                    }
                }
                if (!TextUtils.isEmpty(httpsURLConnection.getRequestProperty("x-rum-tracestate")) || TextUtils.isEmpty(h.a())) {
                    return;
                }
                httpsURLConnection.setRequestProperty("x-rum-tracestate", "app_id=" + h.a() + ",origin=rum");
                if (h.f19230b) {
                    Log.d("ApmInsight", p199z2.b.f(new String[]{"x-rum-tracestate:app_id=" + h.a() + ",origin=rum"}));
                }
            }
        } catch (Throwable th) {
            if (h.f19230b) {
                th.printStackTrace();
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public final void disconnect() {
        p182x1.a aVar = this.f21394b;
        if (aVar != null && !aVar.b()) {
            c(this.f21394b);
        }
        this.f21393a.disconnect();
    }

    public final p182x1.a e() {
        if (this.f21394b == null) {
            p182x1.a aVar = new p182x1.a();
            p173w1.c cVar = aVar.f22275b;
            this.f21394b = aVar;
            int i9 = c.f21399a;
            cVar.f22065i.f22071b = this.f21393a.getURL().toString();
            cVar.f22063g.f22100a = System.currentTimeMillis();
        }
        return this.f21394b;
    }

    @Override // java.net.URLConnection
    public final boolean getAllowUserInteraction() {
        return this.f21393a.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final String getCipherSuite() {
        return this.f21393a.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public final int getConnectTimeout() {
        return this.f21393a.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public final Object getContent() throws IOException {
        HttpsURLConnection httpsURLConnection = this.f21393a;
        e();
        try {
            Object content = httpsURLConnection.getContent();
            int contentLength = httpsURLConnection.getContentLength();
            if (contentLength >= 0) {
                p182x1.a aVarE = e();
                if (!aVarE.b()) {
                    aVarE.a(contentLength);
                    c(aVarE);
                }
            }
            return content;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.URLConnection
    public final String getContentEncoding() {
        e();
        String contentEncoding = this.f21393a.getContentEncoding();
        a();
        return contentEncoding;
    }

    @Override // java.net.URLConnection
    public final int getContentLength() {
        e();
        int contentLength = this.f21393a.getContentLength();
        a();
        return contentLength;
    }

    @Override // java.net.URLConnection
    public final String getContentType() {
        e();
        String contentType = this.f21393a.getContentType();
        a();
        return contentType;
    }

    @Override // java.net.URLConnection
    public final long getDate() {
        e();
        long date = this.f21393a.getDate();
        a();
        return date;
    }

    @Override // java.net.URLConnection
    public final boolean getDefaultUseCaches() {
        return this.f21393a.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public final boolean getDoInput() {
        return this.f21393a.getDoInput();
    }

    @Override // java.net.URLConnection
    public final boolean getDoOutput() {
        return this.f21393a.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        HttpsURLConnection httpsURLConnection = this.f21393a;
        e();
        try {
            return new p165v1.a(httpsURLConnection.getErrorStream(), 0);
        } catch (Exception e9) {
            e9.toString();
            f21392c.d();
            return httpsURLConnection.getErrorStream();
        }
    }

    @Override // java.net.URLConnection
    public final long getExpiration() {
        e();
        long expiration = this.f21393a.getExpiration();
        a();
        return expiration;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i9) {
        e();
        String headerField = this.f21393a.getHeaderField(i9);
        a();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final long getHeaderFieldDate(String str, long j) {
        e();
        long headerFieldDate = this.f21393a.getHeaderFieldDate(str, j);
        a();
        return headerFieldDate;
    }

    @Override // java.net.URLConnection
    public final int getHeaderFieldInt(String str, int i9) {
        e();
        int headerFieldInt = this.f21393a.getHeaderFieldInt(str, i9);
        a();
        return headerFieldInt;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i9) {
        e();
        String headerFieldKey = this.f21393a.getHeaderFieldKey(i9);
        a();
        return headerFieldKey;
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getHeaderFields() {
        e();
        Map<String, List<String>> headerFields = this.f21393a.getHeaderFields();
        a();
        return headerFields;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final HostnameVerifier getHostnameVerifier() {
        return this.f21393a.getHostnameVerifier();
    }

    @Override // java.net.URLConnection
    public final long getIfModifiedSince() {
        e();
        long ifModifiedSince = this.f21393a.getIfModifiedSince();
        a();
        return ifModifiedSince;
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        p182x1.a aVarE = e();
        try {
            p165v1.a aVar = new p165v1.a(this.f21393a.getInputStream());
            c.b(aVarE, this.f21393a);
            a aVar2 = new a(aVarE);
            e eVar = aVar.f21880c;
            synchronized (eVar.f21889b) {
                eVar.f21889b.add(aVar2);
            }
            return aVar;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.HttpURLConnection
    public final boolean getInstanceFollowRedirects() {
        return this.f21393a.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public final long getLastModified() {
        e();
        long lastModified = this.f21393a.getLastModified();
        a();
        return lastModified;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Certificate[] getLocalCertificates() {
        return this.f21393a.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Principal getLocalPrincipal() {
        return this.f21393a.getLocalPrincipal();
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        p182x1.a aVarE = e();
        try {
            p165v1.b bVar = new p165v1.b(this.f21393a.getOutputStream());
            C0257b c0257b = new C0257b(aVarE);
            e eVar = bVar.f21885c;
            synchronized (eVar.f21889b) {
                eVar.f21889b.add(c0257b);
            }
            return bVar;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Principal getPeerPrincipal() {
        return this.f21393a.getPeerPrincipal();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() {
        return this.f21393a.getPermission();
    }

    @Override // java.net.URLConnection
    public final int getReadTimeout() {
        return this.f21393a.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public final String getRequestMethod() {
        return this.f21393a.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getRequestProperties() {
        return this.f21393a.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        return this.f21393a.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        e();
        try {
            int responseCode = this.f21393a.getResponseCode();
            a();
            return responseCode;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.HttpURLConnection
    public final String getResponseMessage() throws IOException {
        e();
        try {
            String responseMessage = this.f21393a.getResponseMessage();
            a();
            return responseMessage;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final SSLSocketFactory getSSLSocketFactory() {
        return this.f21393a.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        try {
            return this.f21393a.getServerCertificates();
        } catch (SSLPeerUnverifiedException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.URLConnection
    public final URL getURL() {
        return this.f21393a.getURL();
    }

    @Override // java.net.URLConnection
    public final boolean getUseCaches() {
        return this.f21393a.getUseCaches();
    }

    @Override // java.net.URLConnection
    public final void setAllowUserInteraction(boolean z8) {
        this.f21393a.setAllowUserInteraction(z8);
    }

    @Override // java.net.HttpURLConnection
    public final void setChunkedStreamingMode(int i9) {
        this.f21393a.setChunkedStreamingMode(i9);
    }

    @Override // java.net.URLConnection
    public final void setConnectTimeout(int i9) {
        this.f21393a.setConnectTimeout(i9);
    }

    @Override // java.net.URLConnection
    public final void setDefaultUseCaches(boolean z8) {
        this.f21393a.setDefaultUseCaches(z8);
    }

    @Override // java.net.URLConnection
    public final void setDoInput(boolean z8) {
        this.f21393a.setDoInput(z8);
    }

    @Override // java.net.URLConnection
    public final void setDoOutput(boolean z8) {
        this.f21393a.setDoOutput(z8);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(int i9) {
        this.f21393a.setFixedLengthStreamingMode(i9);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f21393a.setHostnameVerifier(hostnameVerifier);
    }

    @Override // java.net.URLConnection
    public final void setIfModifiedSince(long j) {
        this.f21393a.setIfModifiedSince(j);
    }

    @Override // java.net.HttpURLConnection
    public final void setInstanceFollowRedirects(boolean z8) {
        this.f21393a.setInstanceFollowRedirects(z8);
    }

    @Override // java.net.URLConnection
    public final void setReadTimeout(int i9) {
        this.f21393a.setReadTimeout(i9);
    }

    @Override // java.net.HttpURLConnection
    public final void setRequestMethod(String str) throws ProtocolException {
        try {
            this.f21393a.setRequestMethod(str);
            e().f22275b.f22065i.f22070a = str;
        } catch (ProtocolException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        this.f21393a.setRequestProperty(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f21393a.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z8) {
        this.f21393a.setUseCaches(z8);
    }

    @Override // java.net.URLConnection
    public final String toString() {
        return this.f21393a.toString();
    }

    @Override // java.net.HttpURLConnection
    public final boolean usingProxy() {
        return this.f21393a.usingProxy();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        e();
        String headerField = this.f21393a.getHeaderField(str);
        a();
        return headerField;
    }

    @Override // java.net.URLConnection
    public final Object getContent(Class[] clsArr) throws IOException {
        e();
        try {
            Object content = this.f21393a.getContent(clsArr);
            a();
            return content;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }
}
