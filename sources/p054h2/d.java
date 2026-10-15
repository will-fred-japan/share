package p054h2;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.bytedance.apm6.traffic.TrafficTransportService;
import java.util.Map;
import org.json.JSONObject;
import p061i1.h;
import p115p1.c;

/* JADX INFO: compiled from: SubProcessBizTrafficStats.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p054h2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Y2.a f19023b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19022a = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f19024c = new b();

    /* JADX INFO: compiled from: SubProcessBizTrafficStats.java */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Y2.a aVar;
            int i9 = Y2.a.AbstractBinderC0078a.f5222a;
            if (iBinder == null) {
                aVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof Y2.a)) {
                    Y2.a.AbstractBinderC0078a.C0079a c0079a = new Y2.a.AbstractBinderC0078a.C0079a();
                    c0079a.f5223a = iBinder;
                    aVar = c0079a;
                } else {
                    aVar = (Y2.a) iInterfaceQueryLocalInterface;
                }
            }
            d.this.f19023b = aVar;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.f19023b = null;
        }
    }

    /* JADX INFO: compiled from: SubProcessBizTrafficStats.java */
    public class b implements p115p1.b {
        public b() {
        }

        @Override // p115p1.b
        public final void b(String str, JSONObject jSONObject) {
            d dVar = d.this;
            if (dVar.f19022a) {
                dVar.b(str, jSONObject);
            }
        }
    }

    @Override // p054h2.b
    public final void a() {
        if (h.f19230b) {
            p010b3.b.d("APM-Traffic-Detail", "SubBiz start called");
        }
        this.f19022a = true;
        a aVar = new a();
        Application application = h.f19229a;
        int i9 = TrafficTransportService.f12128b;
        application.bindService(new Intent(application, (Class<?>) TrafficTransportService.class), aVar, 1);
        int i10 = c.f20774p;
        c cVar = c.a.f20785a;
        b bVar = this.f19024c;
        if (cVar.f20783n.contains(bVar)) {
            return;
        }
        cVar.f20783n.add(bVar);
    }

    @Override // p054h2.b
    public final long b() {
        return 0L;
    }

    @Override // p054h2.b
    public final void c(double d9) {
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> d() {
        return null;
    }

    @Override // p054h2.b
    public final void e(double d9) {
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> f() {
        return null;
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> g() {
        return null;
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> h() {
        return null;
    }

    @Override // p054h2.b
    public final void b(String str) {
        Y2.a aVar = this.f19023b;
        if (aVar != null) {
            try {
                aVar.b(str);
                if (h.f19230b) {
                    p010b3.b.d("APM-Traffic-Detail", "SubBiz initCustomMetricBizTrafficStats " + str);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> c() {
        return null;
    }

    @Override // p054h2.b
    public final void d(String str) {
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> e() {
        return null;
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> c(String str) {
        return null;
    }

    @Override // p054h2.b
    public final void d(long j, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        String string;
        if (this.f19023b != null) {
            if (jSONObject != null) {
                try {
                    string = jSONObject.toString();
                } catch (RemoteException unused) {
                    return;
                }
            } else {
                string = "";
            }
            String string2 = jSONObject2 != null ? jSONObject2.toString() : "";
            this.f19023b.q(str, str2, str3, string, string2, j);
            if (h.f19230b) {
                p010b3.b.d("APM-Traffic-Detail", "SubBiz trafficStats(trafficBytes=" + j + ", sourceId=" + str + ", business=" + str2 + ", scene=" + str3 + ", extraStatus=" + string + ", extraLog=" + string2);
            }
        }
    }

    @Override // p054h2.b
    public final void b(String str, JSONObject jSONObject) {
        String string;
        if (this.f19023b != null) {
            if (jSONObject != null) {
                try {
                    string = jSONObject.toString();
                } catch (RemoteException unused) {
                    return;
                }
            } else {
                string = "";
            }
            this.f19023b.a(str, string);
            if (h.f19230b) {
                p010b3.b.d("APM-Traffic-Detail", "SubBiz httpApiTrafficStats url=" + str + ", extJson=" + string);
            }
        }
    }

    @Override // p054h2.b
    @Deprecated
    public final void a(JSONObject jSONObject) {
        String string;
        if (this.f19023b != null) {
            if (jSONObject != null) {
                try {
                    string = jSONObject.toString();
                } catch (RemoteException unused) {
                    return;
                }
            } else {
                string = "";
            }
            this.f19023b.c(string);
            if (h.f19230b) {
                p010b3.b.d("APM-Traffic-Detail", "SubBiz httpImageApiTrafficStats extJson=" + string);
            }
        }
    }

    @Override // p054h2.b
    public final void clear() {
    }
}
