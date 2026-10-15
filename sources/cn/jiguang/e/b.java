package cn.jiguang.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.aw.h;
import cn.jiguang.aw.t;
import java.io.File;
import java.io.FileInputStream;
import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f10480a = new SecureRandom().nextLong() | 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f10481b = com.heytap.mcssdk.constant.a.f14256r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f10482c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f10483d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Bundle f10484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f10485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f10486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile long f10487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f10488i;

    public static long a(Context context) {
        return a(a(context, "uid_n"), 0L);
    }

    private static File b(Context context, String str) {
        return new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), W5.e.l("cn.jiguang.cache.identity_", str));
    }

    public static String c(Context context) {
        return a(context, "pwd_n");
    }

    public static long d(Context context) {
        Context contextN = n(context);
        if (contextN == null) {
            return 0L;
        }
        return o(contextN) ? h(contextN).getLong("rid_time", 0L) : k(contextN).getLong("rid_time", 0L);
    }

    public static String e(Context context) {
        String strA = a(context, "device_id_n");
        return !TextUtils.isEmpty(strA) ? strA : h.c(context);
    }

    public static boolean f(Context context) {
        return a(context) > 0 && !TextUtils.isEmpty(b(context));
    }

    public static void g(Context context) {
        Bundle bundleA;
        Context contextN = n(context);
        if (contextN == null || !o(contextN)) {
            return;
        }
        if (!m(contextN).contains("state")) {
            h(contextN);
            return;
        }
        synchronized (f10482c) {
            bundleA = a(m(contextN));
        }
        b(contextN, bundleA);
    }

    private static SharedPreferences h(Context context) {
        SharedPreferences sharedPreferencesM = m(context);
        if (!sharedPreferencesM.contains("state")) {
            a(context, sharedPreferencesM);
        }
        return sharedPreferencesM;
    }

    private static boolean i(Context context) {
        FileInputStream fileInputStream = null;
        try {
            File fileB = b(context, ".xml");
            if (!fileB.exists()) {
                cn.jiguang.x.f.i("IdentityStore", "verify: xml missing");
                return false;
            }
            FileInputStream fileInputStream2 = new FileInputStream(fileB);
            try {
                int iMin = (int) Math.min(fileB.length(), 65536L);
                byte[] bArr = new byte[iMin];
                int i9 = 0;
                while (i9 < iMin) {
                    int i10 = fileInputStream2.read(bArr, i9, iMin - i9);
                    if (i10 < 0) {
                        break;
                    }
                    i9 += i10;
                }
                String str = new String(bArr, 0, i9, "UTF-8");
                String str2 = "name=\"ver\" value=\"" + m(context).getLong("ver", 0L) + "\"";
                boolean zContains = str.contains(str2);
                if (!zContains) {
                    cn.jiguang.x.f.i("IdentityStore", "verify: " + str2 + " not on disk, len=" + i9);
                }
                try {
                    fileInputStream2.close();
                } catch (Throwable unused) {
                }
                return zContains;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    cn.jiguang.x.f.i("IdentityStore", "verify failed, " + th.getMessage());
                    return false;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static JSONObject j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            File fileB = b(context, ".xml");
            jSONObject.put("sz", fileB.exists() ? fileB.length() : -1L);
            jSONObject.put("bak", b(context, ".xml.bak").exists() ? 1 : 0);
            jSONObject.put("intr", Thread.currentThread().isInterrupted() ? 1 : 0);
            return jSONObject;
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("collect diag failed, "), "IdentityStore");
            return jSONObject;
        }
    }

    private static Bundle k(Context context) {
        Bundle bundleA = f10484e;
        if (bundleA == null) {
            synchronized (f10482c) {
                try {
                    bundleA = f10484e;
                    if (bundleA == null) {
                        SharedPreferences sharedPreferencesM = m(context);
                        bundleA = sharedPreferencesM.contains("state") ? a(sharedPreferencesM) : c.a(context);
                        if (bundleA == null) {
                            bundleA = new Bundle();
                        } else {
                            f10484e = bundleA;
                            f10485f = 0L;
                            f10486g = bundleA.getLong("ver", 0L);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        l(context);
        return bundleA;
    }

    private static void l(Context context) {
        if (cn.jiguang.aw.a.b(context)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = f10487h;
            if (j == 0 || jElapsedRealtime - j >= f10481b) {
                f10487h = jElapsedRealtime;
                try {
                    cn.jiguang.w.g.a().b();
                } catch (Throwable th) {
                    W5.e.t(th, new StringBuilder("request sync failed, "), "IdentityStore");
                }
            }
        }
    }

    private static SharedPreferences m(Context context) {
        return context.getSharedPreferences("cn.jiguang.cache.identity_", 0);
    }

    private static Context n(Context context) {
        if (context == null) {
            return cn.jiguang.aw.d.a();
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    private static boolean o(Context context) {
        try {
            return cn.jiguang.w.d.b(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static long a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Long.parseLong(str);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    private static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (o(context)) {
            return true;
        }
        String strI = A.a.i("identity write violation, op=", str, ", cur process is not owner");
        Throwable th = new Throwable();
        StringBuilder sbC = p171w.a.c(strI, "\n");
        sbC.append(Log.getStackTraceString(th));
        cn.jiguang.x.f.m("IdentityStore", sbC.toString());
        cn.jiguang.f.b.a(context, str, th);
        return false;
    }

    private static SharedPreferences.Editor a(Context context, SharedPreferences.Editor editor) {
        return editor.putLong("ver", m(context).getLong("ver", 0L) + 1);
    }

    private static Bundle a(SharedPreferences sharedPreferences) {
        Bundle bundle = new Bundle();
        bundle.putInt("state", sharedPreferences.getInt("state", 1));
        bundle.putString("uid_n", sharedPreferences.getString("uid_n", ""));
        bundle.putString("pwd_n", sharedPreferences.getString("pwd_n", ""));
        bundle.putString("rid_n", sharedPreferences.getString("rid_n", ""));
        bundle.putLong("rid_time", sharedPreferences.getLong("rid_time", 0L));
        bundle.putString("device_id_n", sharedPreferences.getString("device_id_n", ""));
        bundle.putLong("ver", sharedPreferences.getLong("ver", 0L));
        bundle.putLong("owner_token", f10480a);
        return bundle;
    }

    private static String a(Context context, String str) {
        Context contextN = n(context);
        if (contextN == null) {
            return "";
        }
        return b(o(contextN) ? h(contextN).getString(str, "") : k(contextN).getString(str, ""));
    }

    public static String a(String str) {
        String strA;
        return (TextUtils.isEmpty(str) || (strA = t.a(str, cn.jiguang.a.a.j)) == null) ? "" : strA;
    }

    private static void a(Context context, SharedPreferences sharedPreferences) {
        Bundle bundleA;
        synchronized (f10482c) {
            try {
                if (!sharedPreferences.contains("state") && (bundleA = c.a(context)) != null) {
                    b(context, a(context, sharedPreferences.edit()).putInt("state", bundleA.getInt("state")).putString("uid_n", bundleA.getString("uid_n", "")).putString("pwd_n", bundleA.getString("pwd_n", "")).putString("rid_n", bundleA.getString("rid_n", "")).putLong("rid_time", bundleA.getLong("rid_time", 0L)).putString("device_id_n", bundleA.getString("device_id_n", "")), "migrate");
                    b(context, a(sharedPreferences));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String b(Context context) {
        return a(context, "rid_n");
    }

    private static void a(Context context, String str, String str2, String str3, long j, JSONObject jSONObject) {
        long jOptLong = jSONObject.optLong("sz", -1L);
        jSONObject.remove("sz");
        try {
            File parentFile = b(context, ".xml").getParentFile();
            jSONObject.put("cost", j);
            jSONObject.put("free", new File(context.getApplicationInfo().dataDir).getUsableSpace());
            int i9 = 1;
            if (!parentFile.exists()) {
                i9 = 0;
            } else if (parentFile.canWrite()) {
                i9 = 2;
            }
            jSONObject.put("dir", i9);
            jSONObject.put("legacy", c.b(context) ? 1 : 0);
            jSONObject.put("spc", m(context).getClass().getName());
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("collect diag failed, "), "IdentityStore");
        }
        cn.jiguang.f.c.a(context, "identity_sp", "publish", str, jOptLong, str3, str2, jSONObject);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        ConcurrentHashMap<String, String> concurrentHashMap = f10483d;
        String str2 = concurrentHashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String strB = t.b(str, cn.jiguang.a.a.j);
        String str3 = strB != null ? strB : "";
        concurrentHashMap.put(str, str3);
        return str3;
    }

    private static void b(Context context, Bundle bundle) {
        try {
            String strA = cn.jiguang.aw.a.a(context);
            if (strA != null && !strA.equals(context.getPackageName())) {
                cn.jiguang.w.g.a().a("identitySync", bundle);
                cn.jiguang.x.f.c("IdentityStore", "identity pushed to main process");
            }
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("push identity failed, "), "IdentityStore");
        }
    }

    public static boolean a(int i9, long j, String str, String str2) {
        if (i9 == 3) {
            return (j <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
        }
        return i9 == 2 || i9 == 4 || i9 == 5;
    }

    private static boolean b(Context context, SharedPreferences.Editor editor, String str) {
        String string;
        boolean zCommit;
        String str2;
        int i9;
        boolean z8;
        String strB;
        String str3;
        String strI;
        long jElapsedRealtime;
        Context context2 = context;
        String str4 = str;
        JSONObject jSONObjectJ = j(context2);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        try {
            zCommit = editor.commit();
            string = null;
            while (true) {
                if (!zCommit || f10488i || i(context2)) {
                    z8 = zCommit;
                    strB = string;
                    str3 = str2;
                    strI = null;
                    break;
                }
                if (i9 >= 2) {
                    if (jSONObjectJ.optLong("sz", -1L) < 0 && !b(context2, ".xml").exists()) {
                        f10488i = true;
                        cn.jiguang.x.f.i("IdentityStore", str4 + " xml never appeared, treat as non-file SharedPreferences, skip verify from now on");
                        strI = "nofile";
                        z8 = zCommit;
                        strB = string;
                        str3 = str2;
                        break;
                    }
                    strB = defpackage.f.b(i9, "verify failed after ", " rewrites");
                    str3 = "retry";
                    z8 = false;
                    strI = null;
                    break;
                }
                i9++;
                cn.jiguang.x.f.i("IdentityStore", str4 + " verify mismatch, rewrite #" + i9);
                try {
                    zCommit = a(context2, m(context2).edit()).commit();
                    string = "rewrite #" + i9 + " commit=false";
                } catch (Throwable th) {
                    string = "rewrite #" + i9 + " " + th;
                    zCommit = false;
                }
                if (!zCommit) {
                    str2 = "retry";
                }
            }
        } catch (Throwable th2) {
            StringBuilder sbC = p171w.a.c(str4, " failed, ");
            sbC.append(th2.getMessage());
            cn.jiguang.x.f.i("IdentityStore", sbC.toString());
            string = th2.toString();
            zCommit = false;
        }
        cn.jiguang.x.f.c("IdentityStore", str4 + ", ok=" + zCommit);
        str2 = "commit";
        i9 = 0;
        if (z8) {
            c.c(context2);
            if (strI == null && i9 > 0) {
                strI = W5.e.i(i9, "repaired by rewrite #");
            }
            strB = strI;
            if (strB != null) {
                jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                str3 = "verify";
            }
            return z8;
        }
        jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
        context2 = context;
        str4 = str;
        a(context2, str3, str4, strB, jElapsedRealtime, jSONObjectJ);
        return z8;
    }

    public static boolean a(Context context, long j, String str, String str2, String str3) {
        Context contextN = n(context);
        if (!c(contextN, "commitRegister")) {
            return false;
        }
        if (j <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            cn.jiguang.x.f.i("IdentityStore", "commitRegister reject, incomplete credential");
            return false;
        }
        String strA = a(String.valueOf(j));
        String strA2 = a(str);
        String strA3 = a(str2);
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2) || TextUtils.isEmpty(strA3)) {
            cn.jiguang.x.f.m("IdentityStore", "commitRegister reject, encrypt failed");
            a(contextN, "encode", "commitRegister", null, -1L, j(contextN));
            return false;
        }
        SharedPreferences.Editor editorPutLong = m(contextN).edit().putInt("state", 3).putString("uid_n", strA).putString("pwd_n", strA2).putString("rid_n", strA3).putLong("rid_time", System.currentTimeMillis());
        if (!TextUtils.isEmpty(str3)) {
            String strA4 = a(str3);
            if (TextUtils.isEmpty(strA4)) {
                cn.jiguang.x.f.m("IdentityStore", "commitRegister deviceId encrypt failed, keep existing");
                a(contextN, "encode", "commitRegister.deviceId", null, -1L, j(contextN));
            } else {
                editorPutLong.putString("device_id_n", strA4);
            }
        }
        return a(contextN, editorPutLong, "commitRegister");
    }

    private static boolean a(Context context, SharedPreferences.Editor editor, String str) {
        boolean zB;
        Bundle bundleA;
        synchronized (f10482c) {
            zB = b(context, a(context, editor), str);
            bundleA = a(m(context));
        }
        b(context, bundleA);
        return zB;
    }

    public static boolean a(Context context, Bundle bundle) {
        try {
            Context contextN = n(context);
            if (contextN != null && bundle != null && bundle.containsKey("state") && !o(contextN)) {
                int i9 = bundle.getInt("state");
                if (!a(i9, a(b(bundle.getString("uid_n")), 0L), b(bundle.getString("pwd_n")), b(bundle.getString("rid_n")))) {
                    cn.jiguang.x.f.i("IdentityStore", "sync reject, state=" + i9);
                    return false;
                }
                long j = bundle.getLong("ver", 0L);
                long j8 = bundle.getLong("owner_token", 0L);
                synchronized (f10482c) {
                    try {
                        if (f10484e != null && j8 == f10485f && j < f10486g) {
                            cn.jiguang.x.f.i("IdentityStore", "sync stale, ver=" + j + " < " + f10486g);
                            return false;
                        }
                        f10484e = new Bundle(bundle);
                        f10485f = j8;
                        f10486g = j;
                        f10487h = SystemClock.elapsedRealtime();
                        cn.jiguang.x.f.c("IdentityStore", "identity synced, state=" + i9 + ", ver=" + j);
                        return true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            W5.e.t(th2, new StringBuilder("apply sync failed, "), "IdentityStore");
            return false;
        }
    }

    public static boolean a(Context context, boolean z8) {
        Context contextN = n(context);
        if (!c(contextN, "commitClear")) {
            return false;
        }
        SharedPreferences.Editor editorRemove = m(contextN).edit().putInt("state", 4).remove("uid_n").remove("pwd_n").remove("rid_n").remove("rid_time");
        if (z8) {
            editorRemove.remove("device_id_n");
        }
        return a(contextN, editorRemove, "commitClear");
    }
}
