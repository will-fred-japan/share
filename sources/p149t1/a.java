package p149t1;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p061i1.h;
import p165v1.c;
import p165v1.d;
import p165v1.e;

/* JADX INFO: compiled from: HttpURLConnectionExtension.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends HttpURLConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final J6.a f21385c = p191y1.a.f22366a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpURLConnection f21386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p182x1.a f21387b;

    /* JADX INFO: renamed from: t1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpURLConnectionExtension.java */
    public class C0256a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p182x1.a f21388a;

        public C0256a(p182x1.a aVar) {
            this.f21388a = aVar;
        }

        @Override // p165v1.d
        public final void a(c cVar) {
            p182x1.a aVar = this.f21388a;
            if (!aVar.b()) {
                aVar.a(cVar.f21886a);
            }
            a.this.b(cVar.f21887b);
        }

        @Override // p165v1.d
        public final void b(c cVar) {
            p182x1.a aVar = this.f21388a;
            if (aVar.b()) {
                return;
            }
            a aVar2 = a.this;
            long contentLength = aVar2.f21386a.getContentLength();
            if (contentLength < 0) {
                contentLength = cVar.f21886a;
            }
            aVar.a(contentLength);
            aVar2.c(aVar);
        }
    }

    /* JADX INFO: compiled from: HttpURLConnectionExtension.java */
    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p182x1.a f21390a;

        public b(p182x1.a aVar) {
            this.f21390a = aVar;
        }

        @Override // p165v1.d
        public final void a(c cVar) {
            p182x1.a aVar = this.f21390a;
            if (!aVar.b()) {
                aVar.c(cVar.f21886a);
            }
            a.this.b(cVar.f21887b);
        }

        @Override // p165v1.d
        public final void b(c cVar) {
            long j;
            p182x1.a aVar = this.f21390a;
            if (aVar.b()) {
                return;
            }
            a aVar2 = a.this;
            String requestProperty = aVar2.f21386a.getRequestProperty("content-length");
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
            aVar2.c(aVar);
        }
    }

    public a(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.f21386a = httpURLConnection;
    }

    public final void a() {
        if (e().b()) {
            return;
        }
        c.b(e(), this.f21386a);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        this.f21386a.addRequestProperty(str, str2);
    }

    public final void b(IOException iOException) {
        p182x1.a aVarE = e();
        c.a(aVarE, iOException);
        if (aVarE.b()) {
            return;
        }
        HttpURLConnection httpURLConnection = this.f21386a;
        c.b(aVarE, httpURLConnection);
        aVarE.f22275b.f22061e.f22094d = httpURLConnection.usingProxy();
        A1.b.X(aVarE);
    }

    public final void c(p182x1.a aVar) {
        if (aVar != null) {
            try {
                aVar.f22275b.f22061e.f22094d = this.f21386a.usingProxy();
                a();
                A1.b.X(aVar);
            } catch (Exception unused) {
            }
        }
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        HttpURLConnection httpURLConnection = this.f21386a;
        e();
        try {
            p182x1.a aVar = this.f21387b;
            if (aVar != null) {
                p173w1.c cVar = aVar.f22275b;
                JSONObject jSONObject = cVar.f22062f;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String requestProperty = httpURLConnection.getRequestProperty("Host");
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
            httpURLConnection.connect();
        } catch (IOException e10) {
            b(e10);
            throw e10;
        }
    }

    public final void d() {
        HttpURLConnection httpURLConnection = this.f21386a;
        try {
            if (h.f19247u) {
                if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("x-rum-traceparent"))) {
                    String strU0 = A1.b.U0();
                    httpURLConnection.setRequestProperty("x-rum-traceparent", strU0);
                    if (h.f19230b) {
                        Log.d("ApmInsight", p199z2.b.f(new String[]{"x-rum-traceparent:" + strU0}));
                    }
                }
                if (!TextUtils.isEmpty(httpURLConnection.getRequestProperty("x-rum-tracestate")) || TextUtils.isEmpty(h.a())) {
                    return;
                }
                httpURLConnection.setRequestProperty("x-rum-tracestate", "app_id=" + h.a() + ",origin=rum");
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
        p182x1.a aVar = this.f21387b;
        if (aVar != null && !aVar.b()) {
            c(this.f21387b);
        }
        this.f21386a.disconnect();
    }

    public final p182x1.a e() {
        if (this.f21387b == null) {
            p182x1.a aVar = new p182x1.a();
            p173w1.c cVar = aVar.f22275b;
            this.f21387b = aVar;
            int i9 = c.f21399a;
            cVar.f22065i.f22071b = this.f21386a.getURL().toString();
            cVar.f22063g.f22100a = System.currentTimeMillis();
        }
        return this.f21387b;
    }

    @Override // java.net.URLConnection
    public final boolean getAllowUserInteraction() {
        return this.f21386a.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public final int getConnectTimeout() {
        return this.f21386a.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public final Object getContent() throws IOException {
        HttpURLConnection httpURLConnection = this.f21386a;
        e();
        try {
            Object content = httpURLConnection.getContent();
            int contentLength = httpURLConnection.getContentLength();
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
        String contentEncoding = this.f21386a.getContentEncoding();
        a();
        return contentEncoding;
    }

    @Override // java.net.URLConnection
    public final int getContentLength() {
        e();
        int contentLength = this.f21386a.getContentLength();
        a();
        return contentLength;
    }

    @Override // java.net.URLConnection
    public final String getContentType() {
        e();
        String contentType = this.f21386a.getContentType();
        a();
        return contentType;
    }

    @Override // java.net.URLConnection
    public final long getDate() {
        e();
        long date = this.f21386a.getDate();
        a();
        return date;
    }

    @Override // java.net.URLConnection
    public final boolean getDefaultUseCaches() {
        return this.f21386a.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public final boolean getDoInput() {
        return this.f21386a.getDoInput();
    }

    @Override // java.net.URLConnection
    public final boolean getDoOutput() {
        return this.f21386a.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        HttpURLConnection httpURLConnection = this.f21386a;
        e();
        try {
            return new p165v1.a(httpURLConnection.getErrorStream(), 0);
        } catch (Exception e9) {
            e9.toString();
            f21385c.d();
            return httpURLConnection.getErrorStream();
        }
    }

    @Override // java.net.URLConnection
    public final long getExpiration() {
        e();
        long expiration = this.f21386a.getExpiration();
        a();
        return expiration;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i9) {
        e();
        String headerField = this.f21386a.getHeaderField(i9);
        a();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final long getHeaderFieldDate(String str, long j) {
        e();
        long headerFieldDate = this.f21386a.getHeaderFieldDate(str, j);
        a();
        return headerFieldDate;
    }

    @Override // java.net.URLConnection
    public final int getHeaderFieldInt(String str, int i9) {
        e();
        int headerFieldInt = this.f21386a.getHeaderFieldInt(str, i9);
        a();
        return headerFieldInt;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i9) {
        e();
        String headerFieldKey = this.f21386a.getHeaderFieldKey(i9);
        a();
        return headerFieldKey;
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getHeaderFields() {
        e();
        Map<String, List<String>> headerFields = this.f21386a.getHeaderFields();
        a();
        return headerFields;
    }

    @Override // java.net.URLConnection
    public final long getIfModifiedSince() {
        e();
        long ifModifiedSince = this.f21386a.getIfModifiedSince();
        a();
        return ifModifiedSince;
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        p182x1.a aVarE = e();
        try {
            p165v1.a aVar = new p165v1.a(this.f21386a.getInputStream());
            c.b(aVarE, this.f21386a);
            C0256a c0256a = new C0256a(aVarE);
            e eVar = aVar.f21880c;
            synchronized (eVar.f21889b) {
                eVar.f21889b.add(c0256a);
            }
            return aVar;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.HttpURLConnection
    public final boolean getInstanceFollowRedirects() {
        return this.f21386a.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public final long getLastModified() {
        e();
        long lastModified = this.f21386a.getLastModified();
        a();
        return lastModified;
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        p182x1.a aVarE = e();
        try {
            p165v1.b bVar = new p165v1.b(this.f21386a.getOutputStream());
            b bVar2 = new b(aVarE);
            e eVar = bVar.f21885c;
            synchronized (eVar.f21889b) {
                eVar.f21889b.add(bVar2);
            }
            return bVar;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() {
        return this.f21386a.getPermission();
    }

    @Override // java.net.URLConnection
    public final int getReadTimeout() {
        return this.f21386a.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public final String getRequestMethod() {
        return this.f21386a.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getRequestProperties() {
        return this.f21386a.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        return this.f21386a.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        e();
        try {
            int responseCode = this.f21386a.getResponseCode();
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
            String responseMessage = this.f21386a.getResponseMessage();
            a();
            return responseMessage;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.URLConnection
    public final URL getURL() {
        return this.f21386a.getURL();
    }

    @Override // java.net.URLConnection
    public final boolean getUseCaches() {
        return this.f21386a.getUseCaches();
    }

    @Override // java.net.URLConnection
    public final void setAllowUserInteraction(boolean z8) {
        this.f21386a.setAllowUserInteraction(z8);
    }

    @Override // java.net.HttpURLConnection
    public final void setChunkedStreamingMode(int i9) {
        this.f21386a.setChunkedStreamingMode(i9);
    }

    @Override // java.net.URLConnection
    public final void setConnectTimeout(int i9) {
        this.f21386a.setConnectTimeout(i9);
    }

    @Override // java.net.URLConnection
    public final void setDefaultUseCaches(boolean z8) {
        this.f21386a.setDefaultUseCaches(z8);
    }

    @Override // java.net.URLConnection
    public final void setDoInput(boolean z8) {
        this.f21386a.setDoInput(z8);
    }

    @Override // java.net.URLConnection
    public final void setDoOutput(boolean z8) {
        this.f21386a.setDoOutput(z8);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(int i9) {
        this.f21386a.setFixedLengthStreamingMode(i9);
    }

    @Override // java.net.URLConnection
    public final void setIfModifiedSince(long j) {
        this.f21386a.setIfModifiedSince(j);
    }

    @Override // java.net.HttpURLConnection
    public final void setInstanceFollowRedirects(boolean z8) {
        this.f21386a.setInstanceFollowRedirects(z8);
    }

    @Override // java.net.URLConnection
    public final void setReadTimeout(int i9) {
        this.f21386a.setReadTimeout(i9);
    }

    @Override // java.net.HttpURLConnection
    public final void setRequestMethod(String str) throws ProtocolException {
        e();
        try {
            this.f21386a.setRequestMethod(str);
            e().f22275b.f22065i.f22070a = str;
        } catch (ProtocolException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        this.f21386a.setRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z8) {
        this.f21386a.setUseCaches(z8);
    }

    @Override // java.net.URLConnection
    public final String toString() {
        return this.f21386a.toString();
    }

    @Override // java.net.HttpURLConnection
    public final boolean usingProxy() {
        return this.f21386a.usingProxy();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        e();
        String headerField = this.f21386a.getHeaderField(str);
        a();
        return headerField;
    }

    @Override // java.net.URLConnection
    public final Object getContent(Class[] clsArr) throws IOException {
        e();
        try {
            Object content = this.f21386a.getContent(clsArr);
            a();
            return content;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }
}
