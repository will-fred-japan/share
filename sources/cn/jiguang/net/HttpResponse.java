package cn.jiguang.net;

import H2.a;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Object> f10623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10629i;

    public HttpResponse() {
        this.f10628h = -1;
        this.f10629i = -1;
        this.f10623c = new HashMap();
    }

    private int a() {
        int iIndexOf;
        try {
            String str = (String) this.f10623c.get("cache-control");
            if (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf("max-age=")) == -1) {
                return -1;
            }
            int iIndexOf2 = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP, iIndexOf);
            int i9 = iIndexOf + 8;
            return Integer.parseInt(iIndexOf2 != -1 ? str.substring(i9, iIndexOf2) : str.substring(i9));
        } catch (Exception unused) {
            return -1;
        }
    }

    private long b() {
        int iA = a();
        if (iA != -1) {
            return System.currentTimeMillis() + ((long) (iA * 1000));
        }
        if (TextUtils.isEmpty(getExpiresHeader())) {
            return -1L;
        }
        return HttpUtils.parseGmtTime(getExpiresHeader());
    }

    public long getExpiredTime() {
        if (this.f10627g) {
            return this.f10625e;
        }
        this.f10627g = true;
        long jB = b();
        this.f10625e = jB;
        return jB;
    }

    public String getExpiresHeader() {
        try {
            Map<String, Object> map = this.f10623c;
            if (map == null) {
                return null;
            }
            return (String) map.get("expires");
        } catch (Exception unused) {
            return null;
        }
    }

    public String getResponseBody() {
        return this.f10622b;
    }

    public int getResponseCode() {
        return this.f10628h;
    }

    public Map<String, Object> getResponseHeaders() {
        return this.f10623c;
    }

    public int getStatusCode() {
        return this.f10629i;
    }

    public int getType() {
        return this.f10624d;
    }

    public String getUrl() {
        return this.f10621a;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f10625e;
    }

    public boolean isInCache() {
        return this.f10626f;
    }

    public void setExpiredTime(long j) {
        this.f10627g = true;
        this.f10625e = j;
    }

    public HttpResponse setInCache(boolean z8) {
        this.f10626f = z8;
        return this;
    }

    public void setResponseBody(String str) {
        this.f10622b = str;
    }

    public void setResponseCode(int i9) {
        this.f10628h = i9;
    }

    public void setResponseHeader(String str, String str2) {
        Map<String, Object> map = this.f10623c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void setResponseHeaders(Map<String, Object> map) {
        this.f10623c = map;
    }

    public void setStatusCode(int i9) {
        this.f10629i = i9;
    }

    public void setType(int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException("The type of HttpResponse cannot be smaller than 0.");
        }
        this.f10624d = i9;
    }

    public void setUrl(String str) {
        this.f10621a = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpResponse{responseBody='");
        sb.append(this.f10622b);
        sb.append("', responseCode=");
        return a.a(sb, this.f10628h, '}');
    }

    public HttpResponse(String str) {
        this.f10628h = -1;
        this.f10629i = -1;
        this.f10621a = str;
        this.f10624d = 0;
        this.f10626f = false;
        this.f10627g = false;
        this.f10623c = new HashMap();
    }
}
