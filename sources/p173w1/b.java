package p173w1;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.f;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import p061i1.h;
import p099n1.d;

/* JADX INFO: compiled from: OkHttpEventListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends EventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EventListener f22042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f22043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f22046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f22047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f22048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f22049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f22050i;
    public long j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f22051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f22052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSONObject f22054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JSONObject f22055o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public StringBuilder f22056p;

    public final void a() {
        if (!this.f22045d) {
            this.f22056p = new StringBuilder();
            return;
        }
        c cVar = this.f22043b;
        cVar.f22063g.f22101b = System.currentTimeMillis() - cVar.f22063g.f22100a;
        cVar.f22069n.f22089a = "okhttp";
        try {
            JSONObject jSONObject = new JSONObject(cVar.toString());
            jSONObject.put("net_consume_type", "okhttp");
            jSONObject.put("timing_totalSendBytes", cVar.f22061e.f22092b);
            jSONObject.put("timing_totalReceivedBytes", cVar.f22061e.f22093c);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("request_log", jSONObject.toString());
            if (cVar.f22066k.f22076e == 1 && this.f22053m == 0) {
                this.f22053m = 3;
            }
            jSONObject2.put("data_type", this.f22053m);
            jSONObject2.put("eventListener", this.f22056p.toString());
            this.f22056p = new StringBuilder();
            JSONObject jSONObject3 = this.f22054n;
            jSONObject2.put("requestHeader", jSONObject3 != null ? jSONObject3.toString() : "");
            c.i iVar = cVar.f22063g;
            A1.b.C(iVar.f22101b, iVar.f22100a, this.f22044c, cVar.f22060d.f22096a, cVar.f22061e.f22091a, jSONObject2);
            if (h.f19230b) {
                Log.d("net_info:", p199z2.b.f(new String[]{"request_log:" + jSONObject.toString() + "\n" + jSONObject2.toString()}));
            }
        } catch (Exception unused) {
        }
    }

    @Override // okhttp3.EventListener
    public final void cacheConditionalHit(Call call, Response response) {
        this.f22043b.f22066k.f22074c = true;
        f.m(new StringBuilder(" cacheConditionalHit() "), this.f22056p);
    }

    @Override // okhttp3.EventListener
    public final void cacheHit(Call call, Response response) {
        this.f22043b.f22066k.f22072a = true;
        f.m(new StringBuilder(" cacheHit() "), this.f22056p);
    }

    @Override // okhttp3.EventListener
    public final void cacheMiss(Call call) {
        this.f22043b.f22066k.f22073b = true;
        f.m(new StringBuilder(" cacheMiss() "), this.f22056p);
    }

    @Override // okhttp3.EventListener
    public final void callEnd(Call call) {
        super.callEnd(call);
        f.m(new StringBuilder(" callEnd() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
        a();
    }

    @Override // okhttp3.EventListener
    public final void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        f.m(new StringBuilder(" callFailed() "), this.f22056p);
        this.f22053m = 2;
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.callFailed(call, iOException);
        }
        if (this.f22045d) {
            c cVar = this.f22043b;
            cVar.j.f22085a = A1.b.q(Thread.currentThread().getStackTrace());
            cVar.j.f22087c = iOException.getClass().getName();
            cVar.j.f22086b = iOException.getClass().getName() + Constants.COLON_SEPARATOR + iOException.getMessage();
            cVar.j.f22088d = A1.b.e(iOException);
        }
        a();
    }

    @Override // okhttp3.EventListener
    public final void callStart(Call call) {
        c cVar = this.f22043b;
        super.callStart(call);
        try {
            if (this.f22056p.length() > 1000) {
                this.f22056p = new StringBuilder();
            }
            String string = call.request().url().toString();
            this.f22056p.append(" url " + string);
            this.f22056p.append(" callStart() " + System.currentTimeMillis());
        } catch (Throwable unused) {
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
        if (this.f22045d) {
            try {
                cVar.f22063g.f22100a = System.currentTimeMillis();
                cVar.f22065i.f22070a = call.request().method();
                String string2 = call.request().url().toString();
                this.f22044c = string2;
                cVar.f22065i.f22071b = string2;
            } catch (Exception unused2) {
            }
        }
    }

    @Override // okhttp3.EventListener
    public final void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        f.m(new StringBuilder(" connectEnd() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
        if (this.f22045d) {
            c cVar = this.f22043b;
            cVar.f22061e.f22094d = proxy.address() != null;
            if (inetSocketAddress == null || inetSocketAddress.getAddress() == null) {
                return;
            }
            String hostAddress = inetSocketAddress.getAddress().getHostAddress();
            int port = inetSocketAddress.getPort();
            cVar.f22060d.f22096a = hostAddress + Constants.COLON_SEPARATOR + port;
            c.h hVar = cVar.f22060d;
            hVar.f22097b = hostAddress;
            hVar.f22098c = port + "";
        }
    }

    @Override // okhttp3.EventListener
    public final void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        f.m(new StringBuilder(" connectFailed() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public final void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        f.m(new StringBuilder(" connectStart() "), this.f22056p);
        if (this.f22045d) {
            this.f22048g = System.currentTimeMillis();
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public final void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        f.m(new StringBuilder(" connectionAcquired() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
        if (this.f22045d) {
            long j = this.f22047f;
            c cVar = this.f22043b;
            if (j == 0) {
                cVar.f22060d.f22099d = true;
            } else {
                cVar.f22060d.f22099d = false;
            }
        }
    }

    @Override // okhttp3.EventListener
    public final void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        f.m(new StringBuilder(" connectionReleased() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public final void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        f.m(new StringBuilder(" dnsEnd() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
        if (this.f22045d) {
            c cVar = this.f22043b;
            cVar.f22064h.f22077a = (int) (System.currentTimeMillis() - this.f22047f);
            if (list == null || list.size() <= 0) {
                return;
            }
            for (InetAddress inetAddress : list) {
                c.d dVar = new c.d();
                dVar.f22084a = inetAddress.getHostAddress();
                cVar.f22059c.add(dVar);
            }
        }
    }

    @Override // okhttp3.EventListener
    public final void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        f.m(new StringBuilder(" dnsStart() "), this.f22056p);
        if (this.f22045d) {
            this.f22047f = System.currentTimeMillis();
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.dnsStart(call, str);
        }
    }

    @Override // okhttp3.EventListener
    public final void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        f.m(new StringBuilder(" requestBodyEnd() "), this.f22056p);
        c cVar = this.f22043b;
        boolean z8 = this.f22045d;
        if (z8) {
            this.j = System.currentTimeMillis();
            cVar.f22064h.f22080d = (int) (System.currentTimeMillis() - this.f22050i);
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j);
        }
        if (z8) {
            cVar.f22061e.f22092b += j;
        }
    }

    @Override // okhttp3.EventListener
    public final void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        f.m(new StringBuilder(" requestBodyStart() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        f.m(new StringBuilder(" requestHeadersEnd() "), this.f22056p);
        c cVar = this.f22043b;
        boolean z8 = this.f22045d;
        if (z8) {
            this.f22046e = System.currentTimeMillis();
            cVar.f22064h.f22080d = (int) (System.currentTimeMillis() - this.f22050i);
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
        request.header("User-Agent");
        if (z8) {
            try {
                cVar.f22061e.f22092b += request.headers().byteCount();
                this.f22044c = request.url().toString();
                cVar.f22065i.f22070a = request.method();
                cVar.f22065i.f22071b = this.f22044c;
                Headers headers = request.headers();
                JSONObject jSONObject = new JSONObject();
                if (headers != null) {
                    try {
                        if (!TextUtils.isEmpty("Host")) {
                            jSONObject.put("Host", headers.get("Host"));
                        }
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
                this.f22054n = jSONObject;
                if (h.f19247u) {
                    cVar.f22068m = request.header("x-rum-traceparent");
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        f.m(new StringBuilder(" requestHeadersStart() "), this.f22056p);
        if (this.f22045d) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f22050i = jCurrentTimeMillis;
            this.f22043b.f22063g.f22102c = jCurrentTimeMillis;
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        f.m(new StringBuilder(" responseBodyEnd() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j);
        }
        if (this.f22045d) {
            c cVar = this.f22043b;
            cVar.f22061e.f22093c += j;
            cVar.f22064h.f22083g = (int) (System.currentTimeMillis() - this.f22052l);
        }
    }

    @Override // okhttp3.EventListener
    public final void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        f.m(new StringBuilder(" responseBodyStart() "), this.f22056p);
        if (this.f22045d) {
            this.f22052l = System.currentTimeMillis();
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersEnd(Call call, Response response) {
        c cVar = this.f22043b;
        super.responseHeadersEnd(call, response);
        f.m(new StringBuilder(" responseHeadersEnd() "), this.f22056p);
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
        if (this.f22045d) {
            try {
                int iCode = response.code();
                cVar.f22064h.f22082f = (int) (System.currentTimeMillis() - this.f22051k);
                c.g gVar = cVar.f22061e;
                gVar.f22091a = iCode;
                gVar.f22093c += response.headers().byteCount();
                cVar.f22061e.f22095e = d.a(h.f19229a);
                if (iCode >= 400) {
                    this.f22053m = 1;
                    cVar.j.f22085a = A1.b.q(Thread.currentThread().getStackTrace());
                    cVar.j.f22088d = iCode;
                } else {
                    this.f22053m = 3;
                }
                Headers headers = response.headers();
                JSONObject jSONObject = new JSONObject();
                if (headers != null) {
                    try {
                        for (String str : headers.names()) {
                            try {
                                jSONObject.put(str, headers.get(str));
                            } catch (JSONException e9) {
                                e9.printStackTrace();
                            }
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                this.f22055o = jSONObject;
                if (TextUtils.isEmpty(h.f19246s) || TextUtils.isEmpty(this.f22055o.optString(h.f19246s))) {
                    return;
                }
                cVar.f22067l = this.f22055o.optString(h.f19246s);
            } catch (Exception unused) {
            }
        }
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersStart(Call call) {
        long jCurrentTimeMillis;
        long j;
        super.responseHeadersStart(call);
        f.m(new StringBuilder(" responseHeadersStart() "), this.f22056p);
        if (this.f22045d) {
            this.f22051k = System.currentTimeMillis();
            if (this.j != 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
                j = this.j;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                j = this.f22046e;
            }
            long j8 = jCurrentTimeMillis - j;
            c cVar = this.f22043b;
            cVar.f22064h.f22081e = (int) j8;
            cVar.f22063g.f22103d = System.currentTimeMillis();
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void satisfactionFailure(Call call, Response response) {
        this.f22043b.f22066k.f22075d = true;
        f.m(new StringBuilder(" satisfactionFailure() "), this.f22056p);
    }

    @Override // okhttp3.EventListener
    public final void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        f.m(new StringBuilder(" secureConnectEnd() "), this.f22056p);
        if (this.f22045d) {
            this.f22043b.f22064h.f22079c = (int) (System.currentTimeMillis() - this.f22049h);
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public final void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        f.m(new StringBuilder(" secureConnectStart() "), this.f22056p);
        if (this.f22045d) {
            this.f22043b.f22064h.f22078b = (int) (System.currentTimeMillis() - this.f22048g);
            this.f22049h = System.currentTimeMillis();
        }
        EventListener eventListener = this.f22042a;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
    }
}
