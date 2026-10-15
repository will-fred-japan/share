package E3;

import P3.d;
import P3.e;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.services.apm.api.HttpResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import p056h5.C0598e;
import p061i1.h;

/* JADX INFO: compiled from: CloudMessageManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Context f1969e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f1970f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static T1.b.C0055b f1971g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f1972h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile String f1973i = "";
    public static String j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<O3.b> f1974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f1975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Map<String, String> f1976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1977d;

    public a() {
        this.f1976c = new HashMap();
        new Vector(10);
        this.f1975b = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        A1.b.f1427z = h.f19230b;
        F3.a aVarB = F3.a.b(f1973i);
        L3.a.C0029a c0029a = new L3.a.C0029a();
        ArrayList arrayList = M3.a.f2904a;
        ArrayList arrayList2 = M3.a.f2905b;
        ArrayList arrayList3 = M3.a.f2906c;
        c0029a.f2836a = h.a();
        Application application = h.f19229a;
        c0029a.f2838c = f1969e;
        c0029a.f2837b = h.f19230b;
        if (h.e() != null) {
        }
        c0029a.f2839d = new p199z2.b();
        if (TextUtils.isEmpty(c0029a.f2836a)) {
            throw new IllegalArgumentException("aid must not be empty");
        }
        if (c0029a.f2838c == null) {
            throw new IllegalArgumentException("context must not be empty");
        }
        if (c0029a.f2839d == null) {
            throw new IllegalArgumentException("SDKIDynamicParams must not be empty");
        }
        L3.a aVar = new L3.a(c0029a);
        aVarB.f2038c = aVar;
        aVarB.f2037b = new File(aVar.f2835c.getFilesDir(), "cloud_uploading" + aVar.f2833a);
        ArrayList arrayList4 = new ArrayList(10);
        P3.c cVar = new P3.c();
        cVar.f3468a = f1973i;
        P3.b bVar = new P3.b();
        bVar.f3468a = f1973i;
        P3.a aVar2 = new P3.a();
        aVar2.f3468a = f1973i;
        e eVar = new e();
        eVar.f3468a = f1973i;
        arrayList4.add(cVar);
        arrayList4.add(bVar);
        arrayList4.add(aVar2);
        arrayList4.add(eVar);
        List<O3.b> listUnmodifiableList = Collections.unmodifiableList(arrayList4);
        this.f1974a = listUnmodifiableList;
        T1.b.C0055b c0055b = f1971g;
        if (c0055b != null) {
            for (O3.b bVar2 : listUnmodifiableList) {
                if (bVar2 instanceof d) {
                    ((d) bVar2).f3612c = c0055b;
                }
            }
            f1971g = null;
        }
        this.f1976c = h.e() != null ? h.e() : new HashMap<>();
    }

    public static a b() {
        if (f1970f == null) {
            synchronized (a.class) {
                try {
                    if (f1970f == null) {
                        if (!f1972h) {
                            throw new RuntimeException("call CloudMessageManager.init() first");
                        }
                        f1970f = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1970f;
    }

    public final void a() {
        String value;
        JSONArray jSONArrayOptJSONArray;
        j = A1.b.f1397E;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!h.f19250x) {
            if (h.f19230b) {
                Log.d("ApmInsight", p199z2.b.f(new String[]{"can not report,fetch cloud message return"}));
                return;
            }
            return;
        }
        if (!h.f19230b && jCurrentTimeMillis - this.f1977d < 120000) {
            Log.d("ApmInsight", p199z2.b.f(new String[]{"fetchCommandImmediately too fast. just ignore for this time."}));
            return;
        }
        this.f1977d = jCurrentTimeMillis;
        try {
            String strL = A1.b.l(p199z2.b.f22481l + j + "/monitor/collect/c/cloudcontrol/get", h.e());
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put("Version-Code", "1");
            map.put("Accept", "application/json");
            HttpResponse httpResponseDoPost = h.f19235g.doPost(strL, Z2.b.a(new JSONObject().toString()), map);
            if (h.f19230b) {
                Log.d("ApmInsight", p199z2.b.f(new String[]{"fetchCommandImmediately: url=" + strL}));
            }
            if (httpResponseDoPost == null) {
                Log.d("ApmInsight", p199z2.b.f(new String[]{"fetchCommandImmediately: res null"}));
                return;
            }
            if (httpResponseDoPost.getStatusCode() == 200) {
                JSONObject jSONObject = new JSONObject(new String(httpResponseDoPost.getResponseBytes()));
                if (h.f19230b) {
                    Log.d("ApmInsight", p199z2.b.f(new String[]{"fetchCommandImmediately: resultMsg=" + jSONObject.toString()}));
                }
                Map<String, String> headers = httpResponseDoPost.getHeaders();
                if (headers == null || headers.isEmpty()) {
                    value = null;
                } else {
                    value = headers.get("ran");
                    try {
                        if (TextUtils.isEmpty(value)) {
                            for (Map.Entry<String, String> entry : headers.entrySet()) {
                                if ("ran".equalsIgnoreCase(entry.getKey())) {
                                    value = entry.getValue();
                                    break;
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                String strOptString = jSONObject.optString("data");
                if (!strOptString.isEmpty()) {
                    jSONObject = !TextUtils.isEmpty(value) ? new JSONObject(C0598e.g(strOptString.getBytes(), value)) : new JSONObject(new String(strOptString.getBytes()));
                }
                if (h.f19230b) {
                    Log.d("ApmInsight", p199z2.b.f(new String[]{"fetchCommandImmediately resultMsg=" + jSONObject}));
                }
                if (A1.b.w0(jSONObject)) {
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("configs");
                if (A1.b.w0(jSONObjectOptJSONObject) || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("cloud_commands")) == null) {
                    return;
                }
                for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                    this.f1975b.execute(new b(0, this, jSONArrayOptJSONArray.optString(i9)));
                }
            }
        } catch (Exception e9) {
            String strF = p199z2.b.f(new String[]{"fetchCommandImmediately error."});
            if (strF == null) {
                strF = "";
            }
            StringBuilder sbC = p171w.a.c(strF, "  ");
            sbC.append(Log.getStackTraceString(e9));
            Log.e("ApmInsight", sbC.toString());
        }
    }
}
