package cn.jpush.android.ad;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WeakReference<Activity> f11115a;

    public static Activity a() {
        WeakReference<Activity> weakReference = f11115a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void b(Activity activity) {
        if (activity == null) {
            return;
        }
        f11115a = new WeakReference<>(activity);
    }

    public static void c(Activity activity) {
        WeakReference<Activity> weakReference;
        if (activity == null || (weakReference = f11115a) == null || weakReference.get() != activity) {
            return;
        }
        f11115a.clear();
    }

    public static void a(Activity activity) {
    }

    public static void d(Activity activity) {
    }

    public static void e(Activity activity) {
    }
}
