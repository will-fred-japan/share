package p107o1;

import A4.d;
import N1.g;
import Q4.RunnableC0366w;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import p061i1.h;
import p061i1.k;
import p107o1.b;
import p192y2.c;

/* JADX INFO: compiled from: BaseDataPipeline.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends b> implements p175w3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f20664d = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f20666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f20667c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<T> f20665a = new LinkedList<>();

    /* JADX INFO: renamed from: o1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseDataPipeline.java */
    public class RunnableC0238a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20668a;

        public RunnableC0238a(b bVar) {
            this.f20668a = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            a.this.e(this.f20668a);
        }
    }

    public static void a(String str, String str2, JSONObject jSONObject, boolean z8) {
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray;
        if (!h.f19250x) {
            if (h.f19230b) {
                Log.d("ApmInsight", p199z2.b.f(new String[]{"can not report，log send return"}));
                return;
            }
            return;
        }
        if (h.f19230b) {
            int iIncrementAndGet = f20664d.incrementAndGet();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("DATA_ID", iIncrementAndGet);
                jSONObject3.put("DATA_PROCESS", d.a());
                jSONObject.put("DATA_DOCTOR", jSONObject3);
                Q1.a.b.f3740a.b("DATA_RECEIVE", jSONObject);
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        if (!TextUtils.equals(str, "timer")) {
            JSONObject jSONObject4 = jSONObject == null ? new JSONObject() : jSONObject;
            try {
                if (jSONObject4.isNull("network_type")) {
                    jSONObject4.put("network_type", A4.b.b(h.f19229a).f1474a);
                }
                if (jSONObject4.isNull("timestamp") || jSONObject4.optLong("timestamp") <= 0) {
                    jSONObject4.put("timestamp", System.currentTimeMillis());
                }
                if (jSONObject4.isNull("sid")) {
                    jSONObject4.put("sid", h.f());
                }
            } catch (Exception unused) {
            }
        }
        if (z8) {
            JSONArray jSONArray = null;
            if (jSONObject == null) {
                jSONObject2 = null;
            } else {
                try {
                    jSONObject2 = new JSONObject(jSONObject.toString());
                } catch (Exception unused2) {
                    jSONObject2 = jSONObject;
                }
            }
            if (TextUtils.equals(str, "tracing")) {
                if ("batch_tracing".equals(str2)) {
                    if (jSONObject2 != null && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("wrapper_array_data")) != null) {
                        jSONArray = jSONArrayOptJSONArray;
                    }
                    c cVar = new c();
                    cVar.f22371a = jSONArray;
                    p174w2.a.b(cVar);
                } else {
                    c cVar2 = new c();
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject2);
                    cVar2.f22371a = jSONArray2;
                    p174w2.a.b(cVar2);
                }
            } else if (TextUtils.equals(str, "common_log")) {
                p192y2.b bVar = new p192y2.b(str2, jSONObject2);
                boolean z9 = p174w2.a.f22104a;
                p150t2.a.a(bVar);
            } else {
                p192y2.b bVar2 = new p192y2.b(str, jSONObject2);
                boolean z10 = p174w2.a.f22104a;
                p150t2.a.a(bVar2);
            }
        }
        p133r2.b.f21107i.d(new g(str, str2, jSONObject));
        if (TextUtils.equals(str, "ui_action")) {
            p125q2.a aVar = p132r1.a.a().f21104a;
            int size = ((LinkedList) aVar.f20907b).size();
            int i9 = aVar.f20906a;
            LinkedList linkedList = (LinkedList) aVar.f20907b;
            if (size > i9) {
                linkedList.removeFirst();
            }
            linkedList.addLast(jSONObject);
        }
    }

    public boolean b(T t) {
        return true;
    }

    public final void c(T t) {
        r2.c.d dVar;
        Looper looperMyLooper = Looper.myLooper();
        p133r2.b bVar = p133r2.b.f21107i;
        p133r2.c cVar = bVar.f21109b;
        if (looperMyLooper != ((cVar == null || (dVar = cVar.f21119a) == null) ? null : dVar.getLooper())) {
            bVar.a(new RunnableC0238a(t));
        } else {
            e(t);
        }
    }

    public abstract void d(T t);

    public final void e(T t) {
        if (b(t)) {
            f(t);
            if (this.f20666b) {
                d(t);
                return;
            }
            synchronized (this.f20665a) {
                try {
                    if (this.f20665a.size() > 1000) {
                        this.f20665a.poll();
                        if (!this.f20667c) {
                            k.a.f19265a.a("apm_cache_buffer_full");
                            this.f20667c = true;
                        }
                    }
                    this.f20665a.add(t);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // p175w3.a
    public final void onReady() {
        this.f20666b = true;
        p133r2.b.f21107i.a(new RunnableC0366w(5, this));
        if (h.f19230b) {
            Q1.a.b.f3740a.a("APM_SETTING_READY", null);
        }
    }

    public void f(T t) {
    }

    @Override // p175w3.a
    public void onRefresh(JSONObject jSONObject, boolean z8) {
    }
}
