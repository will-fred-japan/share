package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10607b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f10610e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f10612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10614i;
    private boolean j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private X509TrustManager f10618n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f10619o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private HostnameVerifier f10620p;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f10615k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f10616l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f10617m = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10608c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10609d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f10611f = new HashMap();

    public HttpRequest(String str) {
        this.f10606a = str;
    }

    public Object getBody() {
        return this.f10612g;
    }

    public int getConnectTimeout() {
        return this.f10608c;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f10620p;
    }

    public byte[] getParas() {
        Object obj = this.f10612g;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f10612g).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String strJoinParasWithEncodedValue = HttpUtils.joinParasWithEncodedValue(this.f10610e);
        if (TextUtils.isEmpty(strJoinParasWithEncodedValue)) {
            return null;
        }
        return strJoinParasWithEncodedValue.getBytes();
    }

    public Map<String, String> getParasMap() {
        return this.f10610e;
    }

    public int getReadTimeout() {
        return this.f10609d;
    }

    public Map<String, String> getRequestProperties() {
        return this.f10611f;
    }

    public String getRequestProperty(String str) {
        return this.f10611f.get(str);
    }

    public X509TrustManager getSslTrustManager() {
        return this.f10618n;
    }

    public String getType() {
        return this.f10607b;
    }

    public String getUrl() {
        return this.f10606a;
    }

    public boolean isDoInPut() {
        return this.f10614i;
    }

    public boolean isDoOutPut() {
        return this.f10613h;
    }

    public boolean isHaveRspData() {
        return this.f10615k;
    }

    public boolean isNeedErrorInput() {
        return this.f10617m;
    }

    public boolean isNeedRetryIfHttpsFailed() {
        return this.f10619o;
    }

    public boolean isRspDatazip() {
        return this.f10616l;
    }

    public boolean isUseCaches() {
        return this.j;
    }

    public void setBody(Object obj) {
        this.f10612g = obj;
    }

    public void setConnectTimeout(int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f10608c = i9;
    }

    public void setDoInPut(boolean z8) {
        this.f10614i = z8;
    }

    public void setDoOutPut(boolean z8) {
        this.f10613h = z8;
    }

    public void setHaveRspData(boolean z8) {
        this.f10615k = z8;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f10620p = hostnameVerifier;
    }

    public void setNeedErrorInput(boolean z8) {
        this.f10617m = z8;
    }

    public void setNeedRetryIfHttpsFailed(boolean z8) {
        this.f10619o = z8;
    }

    public void setParasMap(Map<String, String> map) {
        this.f10610e = map;
    }

    public void setReadTimeout(int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f10609d = i9;
    }

    public void setRequestProperties(Map<String, String> map) {
        this.f10611f = map;
    }

    public void setRequestProperty(String str, String str2) {
        this.f10611f.put(str, str2);
    }

    public void setRspDatazip(boolean z8) {
        this.f10616l = z8;
    }

    public void setSslTrustManager(X509TrustManager x509TrustManager) {
        this.f10618n = x509TrustManager;
    }

    public void setType(String str) {
        this.f10607b = str;
    }

    public void setUrl(String str) {
        this.f10606a = str;
    }

    public void setUseCaches(boolean z8) {
        this.j = z8;
    }

    public void setUserAgent(String str) {
        this.f10611f.put("User-Agent", str);
    }

    public HttpRequest(String str, Map<String, String> map) {
        this.f10606a = str;
        this.f10610e = map;
    }
}
