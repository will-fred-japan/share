package p152t4;

import com.apm.insight.b;
import com.apm.insight.e;
import com.apm.insight.f;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011b4.h;
import p056h5.C0598e;
import p127q4.o;
import p142s2.j;
import p144s4.d;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21406a = 0;

    static {
        new ConcurrentLinkedQueue();
    }

    public static int a(String... strArr) {
        return h.b(b(), -1, strArr);
    }

    public static JSONObject b() {
        c cVar = c.f21414c.get(f.a().e());
        if (cVar != null) {
            return cVar.f21415a;
        }
        return null;
    }

    public static void c(JSONArray jSONArray, boolean z8) {
        JSONObject jSONObjectOptJSONObject;
        Map<String, String> map;
        j.e("apmconfig", "fromnet " + z8 + " : " + jSONArray);
        if (z8 && (map = o.f20983e) != null) {
            map.clear();
        }
        int i9 = 0;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i10);
                String next = jSONObjectOptJSONObject2.keys().next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
                j.d("update config " + next + " : " + jSONObjectOptJSONObject3);
                c.a(next, jSONObjectOptJSONObject3);
                if (z8) {
                    if (o.f20983e == null) {
                        o.f20983e = new HashMap();
                    }
                    o.f20983e.put(next, String.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable unused) {
            }
        }
        String strE = f.a().e();
        if (jSONArray.length() == 0) {
            jSONObjectOptJSONObject = null;
            break;
        }
        while (true) {
            if (i9 >= jSONArray.length()) {
                jSONObjectOptJSONObject = null;
                break;
            }
            jSONObjectOptJSONObject = jSONArray.optJSONObject(i9).optJSONObject(strE);
            if (jSONObjectOptJSONObject != null) {
                break;
            } else {
                i9++;
            }
        }
        JSONObject jSONObject = i.f21432a;
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("exception_modules");
                String strOptString = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString("npth") : null;
                File file = new File(C0598e.w(f.f11853a), "apminsight/configCrash/configNative");
                if (strOptString != null) {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    i.f21432a = jSONObject2;
                    d.k(file, i.e(jSONObject2));
                } else {
                    i.f21432a = new JSONObject();
                }
            } catch (JSONException unused2) {
            } catch (Throwable th) {
                int i11 = b.f11841a;
                p027d5.a.k("NPTH_CATCH", th);
            }
        }
        if (z8) {
            File file2 = o.f20979a;
            try {
                d.j(new File(C0598e.w(f.f11853a), "apminsight/configCrash/configFile"), jSONArray);
            } catch (IOException unused3) {
            }
            try {
                d.i(o.c(), o.f20983e);
            } catch (Throwable unused4) {
            }
        }
    }

    public static boolean d(Object obj) {
        c cVar;
        String strF = h4.b.f(obj);
        if (strF != null && (cVar = c.f21414c.get(strF)) != null) {
            if (cVar.f21415a == null ? false : cVar.f21416b) {
                c cVar2 = c.f21414c.get(strF);
                if (cVar2 == null || cVar2.f()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(String str) {
        JSONObject jSONObject;
        if (!c.d(str)) {
            p127q4.a.a();
        }
        c cVar = c.f21414c.get(str);
        return cVar != null && (jSONObject = cVar.f21415a) != null && 1 == h.b(jSONObject, 0, "crash_module", "switcher") && cVar.f();
    }

    public static boolean f() {
        return a("custom_event_settings", "npth_simple_setting", "disable_looper_monitor") == 1;
    }

    public static boolean g(String str) {
        c cVar;
        JSONObject jSONObject;
        return c.d(str) && (cVar = c.f21414c.get(str)) != null && (jSONObject = cVar.f21415a) != null && 1 == h.b(jSONObject, 0, "crash_module", "upload_alog") && cVar.c() && cVar.f();
    }

    public static boolean h(String str) {
        c cVar;
        JSONObject jSONObject;
        return c.d(str) && (cVar = c.f21414c.get(str)) != null && (jSONObject = cVar.f21415a) != null && 1 == h.b(jSONObject, 0, "crash_module", "apmplus_alog_rate") && cVar.f();
    }

    public static boolean i() {
        JSONObject jSONObject;
        try {
            c cVar = c.f21414c.get(h4.b.f(e.f11842b));
            return cVar != null && (jSONObject = cVar.f21415a) != null && 1 == h.b(jSONObject, 0, "crash_module", "custom_file_sampling_rate") && cVar.c() && cVar.f();
        } catch (Throwable unused) {
        }
    }

    public static boolean j() {
        JSONObject jSONObject;
        try {
            c cVar = c.f21414c.get(h4.b.f(e.f11842b));
            return cVar != null && (jSONObject = cVar.f21415a) != null && 1 == h.b(jSONObject, 0, "exit_module", "switcher") && 1 == h.b(cVar.f21415a, 0, "exit_module", "exit_sampling_rate") && cVar.f();
        } catch (Throwable unused) {
        }
    }
}
