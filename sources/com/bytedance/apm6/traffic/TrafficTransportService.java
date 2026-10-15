package com.bytedance.apm6.traffic;

import A1.b;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import org.json.JSONException;
import org.json.JSONObject;
import p046g2.c;

/* JADX INFO: loaded from: classes.dex */
public class TrafficTransportService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f12128b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f12129a;

    public TrafficTransportService() {
        a aVar = new a();
        aVar.attachInterface(aVar, "com.bytedance.apm6.traffic.ITrafficTransportInterface");
        this.f12129a = aVar;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        a aVar = this.f12129a;
        aVar.getClass();
        return aVar;
    }

    public class a extends Y2.a.AbstractBinderC0078a {
        @Override // Y2.a
        public final void a(String str) {
            if (b.f1393A) {
                p010b3.b.d("APM-Traffic-Detail", "stopMetric " + str);
            }
            c.a.f18855a.a(str);
        }

        @Override // Y2.a
        public final void b(String str) {
            if (b.f1393A) {
                p010b3.b.d("APM-Traffic-Detail", "initCustomMetricBizTrafficStats " + str);
            }
            p046g2.a.C0201a.f18847a.b(str);
        }

        @Override // Y2.a
        public final void c(String str) {
            JSONObject jSONObject;
            if (b.f1393A) {
                p010b3.b.d("APM-Traffic-Detail", "httpImageApiTrafficStats " + str);
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            p046g2.a.C0201a.f18847a.a(jSONObject);
        }

        @Override // Y2.a
        public final void q(String str, String str2, String str3, String str4, String str5, long j) {
            long j8;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            if (b.f1393A) {
                StringBuilder sb = new StringBuilder("trafficStats ");
                j8 = j;
                sb.append(j8);
                sb.append(", ");
                sb.append(str);
                H2.a.j(sb, ", ", str2, ", ", str3);
                sb.append(", ");
                sb.append(str4);
                sb.append(", ");
                sb.append(str5);
                p010b3.b.d("APM-Traffic-Detail", sb.toString());
            } else {
                j8 = j;
            }
            try {
                jSONObject = new JSONObject(str4);
                try {
                    jSONObject2 = new JSONObject(str5);
                } catch (JSONException unused) {
                    jSONObject2 = null;
                }
            } catch (JSONException unused2) {
                jSONObject = null;
            }
            p046g2.a.C0201a.f18847a.d(j8, str, str2, str3, jSONObject, jSONObject2);
        }

        @Override // Y2.a
        public final void a(String str, String str2) {
            JSONObject jSONObject;
            if (b.f1393A) {
                p010b3.b.d("APM-Traffic-Detail", "httpApiTrafficStats " + str + ", " + str2);
            }
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            p046g2.a.C0201a.f18847a.f18846a.b(str, jSONObject);
        }

        @Override // Y2.a
        public final void a(String str, boolean z8) {
            if (b.f1393A) {
                p010b3.b.d("APM-Traffic-Detail", "startMetric " + str + ", " + z8);
            }
            c.a.f18855a.a(str, z8);
        }
    }
}
