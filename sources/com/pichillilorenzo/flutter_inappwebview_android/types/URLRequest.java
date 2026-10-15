package com.pichillilorenzo.flutter_inappwebview_android.types;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class URLRequest {
    private byte[] body;
    private Map<String, String> headers;
    private String method;
    private String url;

    public URLRequest(String str, String str2, byte[] bArr, Map<String, String> map) {
        this.url = str;
        this.method = str2;
        this.body = bArr;
        this.headers = map;
    }

    public static URLRequest fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        String str = (String) map.get(RemoteMessageConst.Notification.URL);
        if (str == null) {
            str = "about:blank";
        }
        return new URLRequest(str, (String) map.get("method"), (byte[]) map.get("body"), (Map) map.get("headers"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            URLRequest uRLRequest = (URLRequest) obj;
            String str = this.url;
            if (str == null ? uRLRequest.url != null : !str.equals(uRLRequest.url)) {
                return false;
            }
            String str2 = this.method;
            if (str2 == null ? uRLRequest.method != null : !str2.equals(uRLRequest.method)) {
                return false;
            }
            if (!Arrays.equals(this.body, uRLRequest.body)) {
                return false;
            }
            Map<String, String> map = this.headers;
            Map<String, String> map2 = uRLRequest.headers;
            if (map != null) {
                return map.equals(map2);
            }
            if (map2 == null) {
                return true;
            }
        }
        return false;
    }

    public byte[] getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.method;
        int iHashCode2 = (Arrays.hashCode(this.body) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31;
        Map<String, String> map = this.headers;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put(RemoteMessageConst.Notification.URL, this.url);
        map.put("method", this.method);
        map.put("headers", this.headers);
        map.put("body", this.body);
        map.put("allowsCellularAccess", null);
        map.put("allowsConstrainedNetworkAccess", null);
        map.put("allowsExpensiveNetworkAccess", null);
        map.put("cachePolicy", null);
        map.put("httpShouldHandleCookies", null);
        map.put("httpShouldUsePipelining", null);
        map.put("networkServiceType", null);
        map.put("timeoutInterval", null);
        map.put("mainDocumentURL", null);
        map.put("assumesHTTP3Capable", null);
        map.put("attribution", null);
        return map;
    }

    public String toString() {
        return "URLRequest{url='" + this.url + "', method='" + this.method + "', body=" + Arrays.toString(this.body) + ", headers=" + this.headers + '}';
    }
}
