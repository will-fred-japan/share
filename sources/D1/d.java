package D1;

import G.C0314e;
import Q4.C0352h;
import S4.C0376g;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.CrashType;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONObject;
import p017c2.i;
import p094m5.n;
import p124q1.f;
import p127q4.g;
import p142s2.j;

/* JADX INFO: compiled from: BatteryTemperatureCollector.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1851c;

    public /* synthetic */ d(int i9, Object obj, Object obj2) {
        this.f1849a = i9;
        this.f1851c = obj;
        this.f1850b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Exception exc;
        switch (this.f1849a) {
            case 0:
                e eVar = (e) this.f1851c;
                try {
                    JSONObject jSONObject = new JSONObject();
                    i iVar = i.a.f8764a;
                    jSONObject.put("battery_temperature", iVar.f8761d);
                    jSONObject.put("capacity_all", A1.b.x0());
                    jSONObject.put("capacity_pct", iVar.f8763f);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("scene", (String) this.f1850b);
                    jSONObject2.put("is_front", !eVar.f8692b);
                    eVar.d(new f("temperature", "", "", jSONObject, jSONObject2, null));
                    Log.d("ApmInsight", p199z2.b.f(new String[]{"temperature"}));
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 1:
                try {
                    Method method = C0314e.f2076d;
                    Object obj = this.f1851c;
                    Object obj2 = this.f1850b;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        C0314e.f2077e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e9) {
                    if (e9.getClass() == RuntimeException.class && e9.getMessage() != null && e9.getMessage().startsWith("Unable to stop")) {
                        throw e9;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 2:
                C0352h c0352h = (C0352h) this.f1850b;
                C0352h.b bVar = (C0352h.b) this.f1851c;
                x4.d.a aVar = c0352h.f3825b;
                if (aVar == null) {
                    return;
                }
                bVar.a(aVar);
                return;
            case 3:
                p127q4.f fVarA = p127q4.f.a();
                h4.d dVar = (h4.d) this.f1851c;
                String str = dVar.f19041e;
                String str2 = dVar.f19040d;
                String str3 = dVar.f19042f;
                List<String> list = dVar.f19043g;
                fVarA.getClass();
                boolean zF = false;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && list != null && list.size() != 0) {
                    try {
                        zF = g.f(com.apm.insight.f.f11859g.getAlogUploadUrl(), str, str2, str3, list);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    break;
                }
                j.d("upload ALog " + dVar.f19043g);
                if (zF) {
                    p144s4.d.n((String) this.f1850b);
                    return;
                }
                return;
            case 4:
                p115p1.a.g().c(new p124q1.d((String) this.f1850b, (JSONObject) this.f1851c));
                return;
            case 5:
                synchronized (((p094m5.j) this.f1851c).f20362b) {
                    p094m5.c cVar = ((p094m5.j) this.f1851c).f20363c;
                    n nVar = (n) this.f1850b;
                    synchronized (nVar.f20368a) {
                        exc = nVar.f20373f;
                        break;
                    }
                    C0376g.e(exc);
                    cVar.onFailure(exc);
                }
                return;
            default:
                if (p144s4.a.g(com.apm.insight.f.f11853a)) {
                    p011b4.e eVar2 = p011b4.f.f8537d;
                    if (eVar2 != null) {
                        eVar2.stopWatching();
                    }
                    String str4 = (String) this.f1850b;
                    p011b4.e eVar3 = new p011b4.e(str4, (com.apm.insight.d) this.f1851c, str4);
                    p011b4.f.f8537d = eVar3;
                    eVar3.startWatching();
                    return;
                }
                return;
        }
    }

    public d(h4.d dVar, CrashType crashType, String str) {
        this.f1849a = 3;
        this.f1851c = dVar;
        this.f1850b = str;
    }

    public /* synthetic */ d(Object obj, Object obj2, int i9, boolean z8) {
        this.f1849a = i9;
        this.f1850b = obj;
        this.f1851c = obj2;
    }
}
