package p061i1;

import A4.d;
import android.app.Application;
import android.text.TextUtils;
import com.apm.insight.MonitorCrash;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.services.apm.api.IHttpService;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p090m1.a;
import p142s2.j;

/* JADX INFO: compiled from: ApmContext.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f19229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f19230b;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f19238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f19239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f19240m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f19241n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f19242o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f19244q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static j f19245r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f19246s;
    public static String t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f19247u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f19248v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f19249w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static MonitorCrash f19251y;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static JSONObject f19231c = new JSONObject();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static JSONObject f19232d = new JSONObject();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f19233e = new j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static HashMap f19234f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static IHttpService f19235g = new DefaultHttpServiceImpl();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f19236h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile int f19237i = -1;
    public static boolean j = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f19243p = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f19250x = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f19252z = false;

    public static String a() {
        JSONObject jSONObject = f19231c;
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("aid"))) ? "" : f19231c.optString("aid");
    }

    public static void b(String str, String str2) {
        JSONObject jSONObject = f19231c;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(str, str2);
            JSONObject jSONObject2 = f19232d;
            if (jSONObject2 != null) {
                jSONObject2.put(str, str2);
            }
        } catch (JSONException unused) {
        }
    }

    public static String c() {
        if (TextUtils.isEmpty(f19241n)) {
            f19241n = d.a();
        }
        return f19241n;
    }

    public static JSONObject d() {
        JSONObject jSONObject = f19231c;
        if (jSONObject != null) {
            try {
                jSONObject.put(MTCoreConstants.Register.KEY_USER_ID, f19233e.getUserId());
                f19231c.put("device_id", f19233e.getDid());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return f19231c;
    }

    public static synchronized Map<String, String> e() {
        HashMap map = f19234f;
        if (map == null) {
            return null;
        }
        map.put("device_id", f19233e.getDid());
        f19234f.put("uid", f19233e.getUserId());
        return f19234f;
    }

    public static long f() {
        if (f19236h == -1) {
            f19236h = System.currentTimeMillis();
        }
        return f19236h;
    }

    public static boolean g() {
        return f19230b;
    }

    public static boolean h() {
        Application application;
        if (f19242o) {
            return true;
        }
        String strC = c();
        if (strC == null || !strC.contains(Constants.COLON_SEPARATOR)) {
            f19242o = (strC == null || (application = f19229a) == null || !strC.equals(application.getPackageName())) ? false : true;
        } else {
            f19242o = false;
        }
        return f19242o;
    }
}
