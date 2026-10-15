package p076k1;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p017c2.f;
import p061i1.h;

/* JADX INFO: compiled from: FpsAggregateManger.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r2.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, a> f19916a = new HashMap<>();

    /* JADX INFO: compiled from: FpsAggregateManger.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f19917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19919c;
    }

    /* JADX INFO: renamed from: k1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FpsAggregateManger.java */
    public static class C0221b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19920a = new b();
    }

    public b() {
        p133r2.b.f21107i.c(this);
    }

    @Override // r2.b.d
    public final void b(long j) {
        HashMap<String, a> map = this.f19916a;
        if (map.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, a> next = it.next();
            String key = next.getKey();
            a value = next.getValue();
            if (j - value.f19918b > 120000) {
                it.remove();
                int i9 = value.f19919c;
                float f6 = i9 > 0 ? value.f19917a / i9 : -1.0f;
                if (h.f19230b) {
                    Log.i("<monitor><perf>", p199z2.b.f(new String[]{"聚合 fps: " + key + " , value: " + f6}));
                }
                if (f6 > 0.0f) {
                    if (f6 > 60.0f) {
                        f6 = 60.0f;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("fps", f6);
                        JSONObject jSONObjectB = f.a().b("fps");
                        jSONObjectB.put("scene", key);
                        p124q1.f fVar = new p124q1.f("fps", key, "", jSONObject, jSONObjectB, null);
                        fVar.f20900f = p158u2.a.a().b();
                        if (h.f19230b) {
                            Log.d("ApmInsight", p199z2.b.f(new String[]{"Receive:FpsData"}));
                        }
                        p115p1.a.g().c(fVar);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
