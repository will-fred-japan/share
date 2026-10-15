package okhttp3;

import W5.e;
import java.io.Closeable;
import java.io.EOFException;
import java.util.List;
import kotlin.jvm.internal.k;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import y7.p;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Response implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(Request request, Protocol protocol, String message, int i9, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j8, Exchange exchange) {
        k.e(request, "request");
        k.e(protocol, "protocol");
        k.e(message, "message");
        k.e(headers, "headers");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i9;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j8;
        this.exchange = exchange;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final ResponseBody m966deprecated_body() {
        return this.body;
    }

    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m967deprecated_cacheControl() {
        return cacheControl();
    }

    /* JADX INFO: renamed from: -deprecated_cacheResponse, reason: not valid java name */
    public final Response m968deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    /* JADX INFO: renamed from: -deprecated_code, reason: not valid java name */
    public final int m969deprecated_code() {
        return this.code;
    }

    /* JADX INFO: renamed from: -deprecated_handshake, reason: not valid java name */
    public final Handshake m970deprecated_handshake() {
        return this.handshake;
    }

    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m971deprecated_headers() {
        return this.headers;
    }

    /* JADX INFO: renamed from: -deprecated_message, reason: not valid java name */
    public final String m972deprecated_message() {
        return this.message;
    }

    /* JADX INFO: renamed from: -deprecated_networkResponse, reason: not valid java name */
    public final Response m973deprecated_networkResponse() {
        return this.networkResponse;
    }

    /* JADX INFO: renamed from: -deprecated_priorResponse, reason: not valid java name */
    public final Response m974deprecated_priorResponse() {
        return this.priorResponse;
    }

    /* JADX INFO: renamed from: -deprecated_protocol, reason: not valid java name */
    public final Protocol m975deprecated_protocol() {
        return this.protocol;
    }

    /* JADX INFO: renamed from: -deprecated_receivedResponseAtMillis, reason: not valid java name */
    public final long m976deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    /* JADX INFO: renamed from: -deprecated_request, reason: not valid java name */
    public final Request m977deprecated_request() {
        return this.request;
    }

    /* JADX INFO: renamed from: -deprecated_sentRequestAtMillis, reason: not valid java name */
    public final long m978deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final ResponseBody body() {
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

    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int i9 = this.code;
        if (i9 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i9 != 407) {
                return p.f22408a;
            }
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public final int code() {
        return this.code;
    }

    public final Exchange exchange() {
        return this.exchange;
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final String header(String str) {
        return header$default(this, str, null, 2, null);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i9 = this.code;
        if (i9 == 307 || i9 == 308) {
            return true;
        }
        switch (i9) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public final boolean isSuccessful() {
        int i9 = this.code;
        return 200 <= i9 && 299 >= i9;
    }

    public final String message() {
        return this.message;
    }

    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final ResponseBody peekBody(long j) throws EOFException {
        ResponseBody responseBody = this.body;
        k.b(responseBody);
        BufferedSource bufferedSourcePeek = responseBody.source().peek();
        Buffer buffer = new Buffer();
        bufferedSourcePeek.request(j);
        buffer.write((Source) bufferedSourcePeek, Math.min(j, bufferedSourcePeek.getBuffer().size()));
        return ResponseBody.Companion.create(buffer, this.body.contentType(), buffer.size());
    }

    public final Response priorResponse() {
        return this.priorResponse;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Request request() {
        return this.request;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public final Headers trailers() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.trailers();
        }
        throw new IllegalStateException("trailers not available");
    }

    public final String header(String name, String str) {
        k.e(name, "name");
        String str2 = this.headers.get(name);
        return str2 != null ? str2 : str;
    }

    public final List<String> headers(String name) {
        k.e(name, "name");
        return this.headers.values(name);
    }

    /* JADX INFO: compiled from: Response.kt */
    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Exchange exchange;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private long receivedResponseAtMillis;
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null");
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException(e.u(str, ".body != null").toString());
                }
                if (!(response.networkResponse() == null)) {
                    throw new IllegalArgumentException(e.u(str, ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse() == null)) {
                    throw new IllegalArgumentException(e.u(str, ".cacheResponse != null").toString());
                }
                if (!(response.priorResponse() == null)) {
                    throw new IllegalArgumentException(e.u(str, ".priorResponse != null").toString());
                }
            }
        }

        public Builder addHeader(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            this.headers.add(name, value);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            int i9 = this.code;
            if (!(i9 >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.message;
            if (str != null) {
                return new Response(request, protocol, str, i9, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw new IllegalStateException("message == null");
        }

        public Builder cacheResponse(Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        public Builder code(int i9) {
            this.code = i9;
            return this;
        }

        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public Builder handshake(Handshake handshake) {
            this.handshake = handshake;
            return this;
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

        public final void initExchange$okhttp(Exchange deferredTrailers) {
            k.e(deferredTrailers, "deferredTrailers");
            this.exchange = deferredTrailers;
        }

        public Builder message(String message) {
            k.e(message, "message");
            this.message = message;
            return this;
        }

        public Builder networkResponse(Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            k.e(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public Builder removeHeader(String name) {
            k.e(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public Builder request(Request request) {
            k.e(request, "request");
            this.request = request;
            return this;
        }

        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public final void setBody$okhttp(ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i9) {
            this.code = i9;
        }

        public final void setExchange$okhttp(Exchange exchange) {
            this.exchange = exchange;
        }

        public final void setHandshake$okhttp(Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            k.e(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j) {
            this.receivedResponseAtMillis = j;
        }

        public final void setRequest$okhttp(Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j) {
            this.sentRequestAtMillis = j;
        }

        public Builder(Response response) {
            k.e(response, "response");
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }
    }
}
