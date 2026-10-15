package okhttp3.internal.http;

import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String method) {
        k.e(method, "method");
        return (method.equals(HttpRequestBean.METHOD_GET) || method.equals("HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String method) {
        k.e(method, "method");
        return method.equals(HttpRequestBean.METHOD_POST) || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT");
    }

    public final boolean invalidatesCache(String method) {
        k.e(method, "method");
        return method.equals(HttpRequestBean.METHOD_POST) || method.equals("PATCH") || method.equals("PUT") || method.equals("DELETE") || method.equals("MOVE");
    }

    public final boolean redirectsToGet(String method) {
        k.e(method, "method");
        return !method.equals("PROPFIND");
    }

    public final boolean redirectsWithBody(String method) {
        k.e(method, "method");
        return method.equals("PROPFIND");
    }
}
