package N2;

import A1.b;
import A4.d;
import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p061i1.h;
import p061i1.j;
import p142s2.i;

/* JADX INFO: compiled from: ApmContext.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static i f3184L = null;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static String f3185M = null;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static Boolean f3186N = null;
    public static String O = null;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static int f3187P = -1;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static String f3188Q = null;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static int f3189R = -1;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static String f3190S = null;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static String f3191T = null;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static long f3192U = -1;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static long f3193V = 0;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static int f3194W = -1;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static JSONObject f3195X = null;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static HashMap f3196Y = null;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static long f3197Z = -1;
    public static boolean a0 = false;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static boolean f3198b0 = true;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static boolean f3199c0 = true;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static boolean f3200d0 = true;

    public static Map<String, String> A1() {
        HashMap map;
        if (f3196Y == null) {
            HashMap map2 = new HashMap();
            f3196Y = map2;
            map2.put("aid", String.valueOf(t1()));
            f3196Y.put("os", "Android");
            f3196Y.put("device_platform", "android");
            if (f3199c0) {
                f3196Y.put("os_api", Build.VERSION.SDK_INT + "");
            }
            if (f3198b0) {
                f3196Y.put("device_model", Build.MODEL);
            }
            f3196Y.put("update_version_code", String.valueOf(z1()));
            f3196Y.put("version_code", P0());
            f3196Y.put("channel", U0());
            f3196Y.put("device_brand", Build.BRAND);
        }
        f3196Y.put("device_id", v1());
        if (b.f1393A) {
            f3196Y.put("_log_level", "debug");
        }
        try {
            f3184L.getClass();
            j jVar = h.f19245r;
            if (jVar != null) {
                map = jVar.f19262i;
                map.put(MTCoreConstants.Register.KEY_USER_ID, h.f19233e.getUserId());
                map.put("device_id", h.f19233e.getDid());
            } else {
                map = null;
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    f3196Y.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return f3196Y;
    }

    public static int B1() {
        if (f3189R == -1) {
            synchronized (a.class) {
                try {
                    if (f3189R == -1) {
                        f3184L.getClass();
                        j jVar = h.f19245r;
                        f3189R = jVar != null ? jVar.f19256c : 0;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3189R;
    }

    public static boolean C1() {
        if (f3186N == null) {
            synchronized (a.class) {
                try {
                    if (f3186N == null) {
                        String strU1 = u1();
                        if (strU1 == null || !strU1.contains(Constants.COLON_SEPARATOR)) {
                            f3186N = Boolean.valueOf(strU1 != null && strU1.equals(b.f1394B.getPackageName()));
                        } else {
                            f3186N = Boolean.FALSE;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3186N.booleanValue();
    }

    public static String P0() {
        if (TextUtils.isEmpty(f3190S)) {
            synchronized (a.class) {
                try {
                    if (TextUtils.isEmpty(f3190S)) {
                        f3184L.getClass();
                        j jVar = h.f19245r;
                        f3190S = jVar != null ? jVar.f19259f : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3190S;
    }

    public static String U0() {
        if (O == null) {
            synchronized (a.class) {
                try {
                    if (O == null) {
                        f3184L.getClass();
                        j jVar = h.f19245r;
                        O = jVar != null ? jVar.f19255b : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return O;
    }

    public static int t1() {
        f3184L.getClass();
        j jVar = h.f19245r;
        if (jVar != null) {
            return jVar.f19254a;
        }
        return 0;
    }

    public static String u1() {
        if (f3185M == null) {
            synchronized (a.class) {
                try {
                    if (f3185M == null) {
                        f3184L.getClass();
                        Application application = h.f19229a;
                        f3185M = d.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3185M;
    }

    public static String v1() {
        f3184L.getClass();
        p090m1.a aVar = h.f19233e;
        if (aVar != null) {
            return aVar.getDid();
        }
        return null;
    }

    public static long w1() {
        if (f3193V <= 0) {
            f3193V = System.currentTimeMillis();
        }
        return f3193V;
    }

    public static JSONObject x1() {
        if (f3195X == null) {
            synchronized (a.class) {
                try {
                    if (f3195X == null) {
                        f3184L.getClass();
                        j jVar = h.f19245r;
                        f3195X = jVar != null ? jVar.f19261h : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3195X;
    }

    public static long y1() {
        if (f3192U < 0) {
            f3192U = System.currentTimeMillis();
        }
        return f3192U;
    }

    public static int z1() {
        if (f3187P == -1) {
            synchronized (a.class) {
                try {
                    if (f3187P == -1) {
                        f3184L.getClass();
                        j jVar = h.f19245r;
                        f3187P = jVar != null ? jVar.f19256c : 0;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3187P;
    }
}
