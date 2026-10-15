package okhttp3;

import A.a;
import R7.i;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import p188x7.e;
import y7.h;
import y7.u;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    /* JADX INFO: compiled from: Request.kt */
    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = HttpRequestBean.METHOD_GET;
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i9, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i9 & 1) != 0) {
                requestBody = Util.EMPTY_REQUEST;
            }
            return builder.delete(requestBody);
        }

        public Builder addHeader(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            this.headers.add(name, value);
            return this;
        }

        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            k.e(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder get() {
            return method(HttpRequestBean.METHOD_GET, null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            this.headers.set(name, value);
            return this;
        }

        public Builder headers(Headers headers) {
            k.e(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String method, RequestBody requestBody) {
            k.e(method, "method");
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                if (HttpMethod.requiresRequestBody(method)) {
                    throw new IllegalArgumentException(a.i("method ", method, " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(method)) {
                throw new IllegalArgumentException(a.i("method ", method, " must not have a request body.").toString());
            }
            this.method = method;
            this.body = requestBody;
            return this;
        }

        public Builder patch(RequestBody body) {
            k.e(body, "body");
            return method("PATCH", body);
        }

        public Builder post(RequestBody body) {
            k.e(body, "body");
            return method(HttpRequestBean.METHOD_POST, body);
        }

        public Builder put(RequestBody body) {
            k.e(body, "body");
            return method("PUT", body);
        }

        public Builder removeHeader(String name) {
            k.e(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            k.e(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            k.e(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            k.e(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(HttpUrl url) {
            k.e(url, "url");
            this.url = url;
            return this;
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public <T> Builder tag(Class<? super T> type, T t) {
            k.e(type, "type");
            if (t == null) {
                this.tags.remove(type);
                return this;
            }
            if (this.tags.isEmpty()) {
                this.tags = new LinkedHashMap();
            }
            Map<Class<?>, Object> map = this.tags;
            T tCast = type.cast(t);
            k.b(tCast);
            map.put(type, tCast);
            return this;
        }

        public Builder url(String url) {
            k.e(url, "url");
            if (i.N(url, "ws:", true)) {
                String strSubstring = url.substring(3);
                k.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                url = "http:".concat(strSubstring);
            } else if (i.N(url, "wss:", true)) {
                String strSubstring2 = url.substring(4);
                k.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                url = "https:".concat(strSubstring2);
            }
            return url(HttpUrl.Companion.get(url));
        }

        public Builder(Request request) {
            LinkedHashMap linkedHashMapJ;
            k.e(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                linkedHashMapJ = new LinkedHashMap();
            } else {
                linkedHashMapJ = u.J(request.getTags$okhttp());
            }
            this.tags = linkedHashMapJ;
            this.headers = request.headers().newBuilder();
        }

        public Builder url(URL url) {
            k.e(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String string = url.toString();
            k.d(string, "url.toString()");
            return url(companion.get(string));
        }
    }

    public Request(HttpUrl url, String method, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> tags) {
        k.e(url, "url");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(tags, "tags");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = requestBody;
        this.tags = tags;
    }

    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m961deprecated_body() {
        return this.body;
    }

    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m962deprecated_cacheControl() {
        return cacheControl();
    }

    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m963deprecated_headers() {
        return this.headers;
    }

    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name */
    public final String m964deprecated_method() {
        return this.method;
    }

    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m965deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String name) {
        k.e(name, "name");
        return this.headers.get(name);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i9 = 0;
            for (e<? extends String, ? extends String> eVar : this.headers) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    h.D();
                    throw null;
                }
                e<? extends String, ? extends String> eVar2 = eVar;
                String str = (String) eVar2.f22353a;
                String str2 = (String) eVar2.f22354b;
                if (i9 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i9 = i10;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String string = sb.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String name) {
        k.e(name, "name");
        return this.headers.values(name);
    }

    public final <T> T tag(Class<? extends T> type) {
        k.e(type, "type");
        return type.cast(this.tags.get(type));
    }
}
