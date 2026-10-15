package p173w1;

import android.text.TextUtils;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OkHttpRecord.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22057a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f22058b = new JSONObject();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f22059c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f22060d = new h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f22061e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f22062f = new JSONObject();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f22063g = new i();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0277c f22064h = new C0277c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f22065i = new a();
    public final e j = new e();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f22066k = new b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f22067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f22068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f22069n;

    /* JADX INFO: compiled from: OkHttpRecord.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22071b;
    }

    /* JADX INFO: compiled from: OkHttpRecord.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f22072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f22074c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f22075d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22076e;
    }

    /* JADX INFO: renamed from: w1.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OkHttpRecord.java */
    public static class C0277c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22081e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f22082f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f22083g;
    }

    /* JADX INFO: compiled from: OkHttpRecord.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22084a;
    }

    /* JADX INFO: compiled from: OkHttpRecord.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22088d;
    }

    /* JADX INFO: compiled from: OkHttpRecord.java */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22090b;
    }

    /* JADX INFO: compiled from: OkHttpRecord.java */
    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f22092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f22093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f22094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f22095e;
    }

    /* JADX INFO: compiled from: OkHttpRecord.java */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f22099d;
    }

    /* JADX INFO: compiled from: OkHttpRecord.java */
    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f22100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f22101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f22102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f22103d;
    }

    public c() {
        f fVar = new f();
        fVar.f22089a = "";
        fVar.f22090b = p061i1.h.h();
        this.f22069n = fVar;
    }

    public final String toString() {
        f fVar = this.f22069n;
        a aVar = this.f22065i;
        e eVar = this.j;
        i iVar = this.f22063g;
        h hVar = this.f22060d;
        g gVar = this.f22061e;
        C0277c c0277c = this.f22064h;
        JSONObject jSONObject = this.f22058b;
        JSONObject jSONObject2 = new JSONObject();
        ArrayList arrayList = this.f22059c;
        if (!arrayList.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((d) it.next()).f22084a);
            }
            try {
                jSONObject2.put("address_list", jSONArray);
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
        }
        try {
            jSONObject.put(TCPTimingCache.P_DNS, jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("remote", hVar.f22096a);
            jSONObject3.put("remote_host", hVar.f22097b);
            jSONObject3.put("remote_port", hVar.f22098c);
            jSONObject3.put("socket_reused", hVar.f22099d);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("socket", jSONObject3);
        } catch (JSONException e12) {
            e12.printStackTrace();
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("code", gVar.f22091a);
            jSONObject4.put("sent_bytes", gVar.f22092b);
            jSONObject4.put("received_bytes", gVar.f22093c);
            jSONObject4.put("via_proxy", gVar.f22094d);
            jSONObject4.put("network_accessed", gVar.f22095e);
        } catch (JSONException e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("response", jSONObject4);
        } catch (JSONException e14) {
            e14.printStackTrace();
        }
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject6.put("duration", iVar.f22101b);
            jSONObject6.put("request_sent_time", iVar.f22102c);
            jSONObject6.put("response_recv_time", iVar.f22103d);
            jSONObject6.put("start_time", iVar.f22100a);
            jSONObject5.put("request", jSONObject6);
        } catch (JSONException e15) {
            e15.printStackTrace();
        }
        JSONObject jSONObject7 = new JSONObject();
        try {
            jSONObject7.put("ttfb", c0277c.f22081e);
            jSONObject7.put(TCPTimingCache.P_DNS, c0277c.f22077a);
            jSONObject7.put("tcp", c0277c.f22078b);
            jSONObject7.put("ssl", c0277c.f22079c);
            jSONObject7.put("send", c0277c.f22080d);
            jSONObject7.put("header_recv", c0277c.f22082f);
            jSONObject7.put("body_recv", c0277c.f22083g);
            jSONObject5.put("detailed_duration", jSONObject7);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        try {
            jSONObject.put("timing", jSONObject5);
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        JSONObject jSONObject8 = new JSONObject();
        try {
            jSONObject8.put("method", aVar.f22070a);
            jSONObject8.put(RemoteMessageConst.Notification.URL, aVar.f22071b);
        } catch (JSONException e18) {
            e18.printStackTrace();
        }
        try {
            jSONObject.put("base", jSONObject8);
        } catch (JSONException e19) {
            e19.printStackTrace();
        }
        JSONObject jSONObject9 = new JSONObject();
        try {
            jSONObject9.put("stack", eVar.f22085a);
            jSONObject9.put("error_msg", eVar.f22086b);
            jSONObject9.put("error_class", eVar.f22087c);
            jSONObject9.put("error_code", eVar.f22088d);
        } catch (JSONException e20) {
            e20.printStackTrace();
        }
        try {
            jSONObject.put("error", jSONObject9);
        } catch (JSONException e21) {
            e21.printStackTrace();
        }
        JSONObject jSONObject10 = new JSONObject();
        try {
            b bVar = this.f22066k;
            bVar.f22076e = 0;
            if (bVar.f22075d) {
                bVar.f22076e = 5;
            } else if (bVar.f22074c) {
                if (bVar.f22072a) {
                    bVar.f22076e = 3;
                } else if (bVar.f22073b) {
                    bVar.f22076e = 4;
                }
            } else if (bVar.f22072a) {
                bVar.f22076e = 1;
            } else if (bVar.f22073b) {
                bVar.f22076e = 2;
            }
            jSONObject10.put("cache_type", bVar.f22076e);
        } catch (JSONException e22) {
            e22.printStackTrace();
        }
        try {
            jSONObject.put("cache", jSONObject10);
        } catch (JSONException e23) {
            e23.printStackTrace();
        }
        JSONObject jSONObject11 = new JSONObject();
        try {
            jSONObject11.put("libcore", fVar.f22089a);
            jSONObject11.put("version", "");
            jSONObject11.put("is_main_process", fVar.f22090b);
        } catch (JSONException e24) {
            e24.printStackTrace();
        }
        try {
            jSONObject.put("other", jSONObject11);
        } catch (JSONException e25) {
            e25.printStackTrace();
        }
        try {
            if (!TextUtils.isEmpty(this.f22067l)) {
                jSONObject.put("external_trace_id", this.f22067l);
            }
            if (!TextUtils.isEmpty(this.f22068m)) {
                jSONObject.put("x-rum-traceparent", this.f22068m);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }
}
