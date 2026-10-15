package p159u4;

import android.app.Application;
import android.content.Context;
import com.apm.insight.f;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p056h5.C0598e;
import p152t4.l;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static boolean t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f21683u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f21684v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f21685w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f21686x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f21687y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile d f21688z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f21694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f21695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f21696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f21697i;
    public String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f21698k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f21699l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f21700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f21701n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f21702o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f21706s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f21689a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f21690b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f21691c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f21692d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<a> f21693e = new LinkedList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f21703p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f21704q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f21705r = 50;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f21708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f21709c;

        public final String toString() {
            return C0598e.h().format(new Date(this.f21709c)) + " : " + this.f21707a + ' ' + this.f21708b;
        }
    }

    public d(Application application) {
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(new c(this));
            } catch (Throwable unused) {
            }
        }
    }

    public static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        Context context = f.f11853a;
        if (Y3.a.f5234p) {
            try {
                jSONObject.put(MTCommonConstants.Network.KEY_NAME, str);
                jSONObject.put(CrashHianalyticsData.TIME, j);
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static void b(long j, String str, String str2, d dVar) {
        dVar.getClass();
        l.a().a(new b(j, str, str2, dVar));
    }

    public static d c() {
        if (f21688z == null) {
            synchronized (d.class) {
                try {
                    if (f21688z == null) {
                        f21688z = new d(f.f11854b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21688z;
    }

    public final JSONArray d() {
        ArrayList arrayList;
        JSONArray jSONArray = new JSONArray();
        Context context = f.f11853a;
        if (Y3.a.f5234p && (arrayList = this.f21689a) != null && !arrayList.isEmpty()) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                try {
                    jSONArray.put(a((String) arrayList.get(i9), ((Long) this.f21690b.get(i9)).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public final JSONArray e() {
        ArrayList arrayList;
        JSONArray jSONArray = new JSONArray();
        Context context = f.f11853a;
        if (Y3.a.f5234p && (arrayList = this.f21691c) != null && !arrayList.isEmpty()) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                try {
                    jSONArray.put(a((String) arrayList.get(i9), ((Long) this.f21692d.get(i9)).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }
}
