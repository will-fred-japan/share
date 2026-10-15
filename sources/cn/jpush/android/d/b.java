package cn.jpush.android.d;

import android.content.Context;
import android.content.Intent;
import cn.jpush.android.helper.Logger;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f11287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f11288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f11289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f11290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f11291e;

    static {
        Class<cn.jpush.android.m.a> cls;
        Method method;
        Method method2;
        Method method3;
        Method method4 = null;
        try {
            cls = cn.jpush.android.m.a.class;
            int i9 = cn.jpush.android.m.a.f11447a;
            try {
                method = cls.getMethod("a", Context.class, d.class);
                try {
                    method2 = cls.getMethod("b", Context.class, d.class);
                    try {
                        method3 = cls.getMethod("c", Context.class, d.class, Intent.class);
                        try {
                            method4 = cls.getMethod("d", Context.class, d.class, Intent.class);
                        } catch (Throwable th) {
                            th = th;
                            Logger.w("FloatMessageHelper", "FloatMessage bridge init failed: cn.jpush.android.m.a", th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        method3 = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    method2 = null;
                    method3 = method2;
                    Logger.w("FloatMessageHelper", "FloatMessage bridge init failed: cn.jpush.android.m.a", th);
                    f11287a = cls;
                    f11288b = method;
                    f11289c = method2;
                    f11290d = method3;
                    f11291e = method4;
                }
            } catch (Throwable th4) {
                th = th4;
                method = null;
                method2 = method;
                method3 = method2;
                Logger.w("FloatMessageHelper", "FloatMessage bridge init failed: cn.jpush.android.m.a", th);
                f11287a = cls;
                f11288b = method;
                f11289c = method2;
                f11290d = method3;
                f11291e = method4;
            }
        } catch (Throwable th5) {
            th = th5;
            cls = null;
            method = null;
        }
        f11287a = cls;
        f11288b = method;
        f11289c = method2;
        f11290d = method3;
        f11291e = method4;
    }

    public static void a(Context context, d dVar, Intent intent) {
        Method method;
        Logger.d("FloatMessageHelper", "clickEvent: " + dVar);
        if (f11287a == null || (method = f11290d) == null) {
            Logger.w("FloatMessageHelper", "clickEvent: bridge missing, skip");
            return;
        }
        try {
            method.invoke(null, context, dVar, intent);
        } catch (Throwable th) {
            Logger.e("FloatMessageHelper", "clickEvent reflect failed", th);
        }
    }

    public static void b(Context context, d dVar) {
        Method method;
        Logger.d("FloatMessageHelper", "showMessage: " + dVar);
        if (f11287a == null || (method = f11289c) == null) {
            Logger.w("FloatMessageHelper", "showMessage: bridge missing, skip");
            return;
        }
        try {
            method.invoke(null, context, dVar);
        } catch (Throwable th) {
            Logger.e("FloatMessageHelper", "showMessage reflect failed", th);
        }
    }

    public static boolean a(Context context, d dVar) {
        Method method;
        Logger.d("FloatMessageHelper", "verifyJgPopupNotification: " + dVar);
        if (f11287a != null && (method = f11288b) != null) {
            try {
                Object objInvoke = method.invoke(null, context, dVar);
                boolean z8 = (objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue();
                Logger.d("FloatMessageHelper", "verifyJgPopupNotification: " + z8);
                return z8;
            } catch (Throwable th) {
                Logger.e("FloatMessageHelper", "verifyJgPopupNotification reflect failed", th);
            }
        }
        return false;
    }

    public static void b(Context context, d dVar, Intent intent) {
        Method method;
        Logger.d("FloatMessageHelper", "dismissEvent: " + dVar);
        if (f11287a == null || (method = f11291e) == null) {
            Logger.w("FloatMessageHelper", "dismissEvent: bridge missing, skip");
            return;
        }
        try {
            method.invoke(null, context, dVar, intent);
        } catch (Throwable th) {
            Logger.e("FloatMessageHelper", "dismissEvent reflect failed", th);
        }
    }
}
