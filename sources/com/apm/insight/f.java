package com.apm.insight;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.apm.insight.runtime.ConfigManager;
import com.huawei.hms.framework.common.BundleUtil;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import p011b4.h;
import p127q4.i;
import p127q4.m;
import p127q4.n;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static String f11852A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f11853a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f11854b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f11855c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f11856d = "default";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f11857e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static p049g6.f f11858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConfigManager f11859g = new ConfigManager();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f11860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f11861i;
    public static q6.a j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile String f11862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f11863l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile int f11864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile String f11865n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f11866o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Z3.a f11867p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f11868q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f11869r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f11870s;
    public static boolean t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f11871u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f11872v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f11873w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f11874x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f11875y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f11876z;

    static {
        a aVar = new a();
        aVar.f11837a = new HashMap();
        aVar.f11838b = new HashMap();
        aVar.f11839c = new HashMap();
        aVar.f11840d = null;
        f11860h = aVar;
        j = null;
        f11862k = null;
        f11863l = new Object();
        f11864m = 0;
        f11866o = 0;
        f11867p = null;
        f11868q = ExitType.NONE.type;
        f11869r = false;
        f11870s = Build.VERSION.SDK_INT < 31 || !p144s4.b.d();
        t = true;
        f11871u = true;
        f11872v = false;
        f11873w = true;
        f11874x = false;
        f11875y = true;
        f11876z = true;
        f11852A = null;
    }

    public static p049g6.f a() {
        if (f11858f == null) {
            f11858f = new p049g6.f(f11853a, new h(), null);
        }
        return f11858f;
    }

    public static String b(long j8, CrashType crashType, boolean z8, boolean z9) {
        StringBuilder sb = new StringBuilder();
        sb.append(j8);
        sb.append(BundleUtil.UNDERLINE_TAG);
        sb.append(crashType.getName());
        sb.append('_');
        sb.append(g());
        sb.append('_');
        sb.append(z8 ? "oom_" : "normal_");
        sb.append(f11855c);
        sb.append('_');
        sb.append(z9 ? "ignore_" : "normal_");
        sb.append(Long.toHexString(new Random().nextLong()));
        sb.append("G");
        return sb.toString();
    }

    public static p127q4.b c(String str, HashMap map, boolean z8) {
        Z3.a aVar = f11867p;
        return (aVar == null || (aVar instanceof i)) ? new m(str, map, z8) : new n(str, map, z8);
    }

    public static void d(Application application, Context context) {
        if (f11854b == null) {
            f11855c = System.currentTimeMillis();
            f11853a = context;
            f11854b = application;
            f11862k = Long.toHexString(new Random().nextLong()) + "G";
        }
    }

    public static q6.a e() {
        if (j == null) {
            synchronized (f.class) {
                q6.a aVar = new q6.a();
                aVar.f20987a = null;
                aVar.f20988b = null;
                j = aVar;
            }
        }
        return j;
    }

    public static String f() {
        return g() + '_' + Long.toHexString(new Random().nextLong()) + "G";
    }

    public static String g() {
        if (f11862k == null) {
            synchronized (f11863l) {
                try {
                    if (f11862k == null) {
                        f11862k = Long.toHexString(new Random().nextLong()) + "U";
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11862k;
    }
}
