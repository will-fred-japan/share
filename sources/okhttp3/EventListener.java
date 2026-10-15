package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* JADX INFO: compiled from: EventListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response cachedResponse) {
        k.e(call, "call");
        k.e(cachedResponse, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        k.e(call, "call");
        k.e(response, "response");
    }

    public void cacheMiss(Call call) {
        k.e(call, "call");
    }

    public void callEnd(Call call) {
        k.e(call, "call");
    }

    public void callFailed(Call call, IOException ioe) {
        k.e(call, "call");
        k.e(ioe, "ioe");
    }

    public void callStart(Call call) {
        k.e(call, "call");
    }

    public void canceled(Call call) {
        k.e(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        k.e(call, "call");
        k.e(inetSocketAddress, "inetSocketAddress");
        k.e(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        k.e(call, "call");
        k.e(inetSocketAddress, "inetSocketAddress");
        k.e(proxy, "proxy");
        k.e(ioe, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        k.e(call, "call");
        k.e(inetSocketAddress, "inetSocketAddress");
        k.e(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        k.e(call, "call");
        k.e(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        k.e(call, "call");
        k.e(connection, "connection");
    }

    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        k.e(call, "call");
        k.e(domainName, "domainName");
        k.e(inetAddressList, "inetAddressList");
    }

    public void dnsStart(Call call, String domainName) {
        k.e(call, "call");
        k.e(domainName, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> proxies) {
        k.e(call, "call");
        k.e(url, "url");
        k.e(proxies, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl url) {
        k.e(call, "call");
        k.e(url, "url");
    }

    public void requestBodyEnd(Call call, long j) {
        k.e(call, "call");
    }

    public void requestBodyStart(Call call) {
        k.e(call, "call");
    }

    public void requestFailed(Call call, IOException ioe) {
        k.e(call, "call");
        k.e(ioe, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        k.e(call, "call");
        k.e(request, "request");
    }

    public void requestHeadersStart(Call call) {
        k.e(call, "call");
    }

    public void responseBodyEnd(Call call, long j) {
        k.e(call, "call");
    }

    public void responseBodyStart(Call call) {
        k.e(call, "call");
    }

    public void responseFailed(Call call, IOException ioe) {
        k.e(call, "call");
        k.e(ioe, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        k.e(call, "call");
        k.e(response, "response");
    }

    public void responseHeadersStart(Call call) {
        k.e(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        k.e(call, "call");
        k.e(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        k.e(call, "call");
    }

    public void secureConnectStart(Call call) {
        k.e(call, "call");
    }
}
