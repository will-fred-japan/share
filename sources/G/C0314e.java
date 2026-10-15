package G;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: renamed from: G.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0314e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f2073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f2074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field f2075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f2076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f2077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f2078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f2079g = new Handler(Looper.getMainLooper());

    static {
        Class<?> cls;
        Field declaredField;
        Field declaredField2;
        Method declaredMethod;
        Method declaredMethod2;
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        f2073a = cls;
        try {
            declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
        } catch (Throwable unused2) {
            declaredField = null;
        }
        f2074b = declaredField;
        try {
            declaredField2 = Activity.class.getDeclaredField("mToken");
            declaredField2.setAccessible(true);
        } catch (Throwable unused3) {
            declaredField2 = null;
        }
        f2075c = declaredField2;
        Class<?> cls2 = f2073a;
        Class cls3 = Boolean.TYPE;
        if (cls2 == null) {
            declaredMethod = null;
        } else {
            try {
                declaredMethod = cls2.getDeclaredMethod("performStopActivity", IBinder.class, cls3, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
                declaredMethod = null;
            }
        }
        f2076d = declaredMethod;
        Class<?> cls4 = f2073a;
        if (cls4 == null) {
            declaredMethod2 = null;
        } else {
            try {
                declaredMethod2 = cls4.getDeclaredMethod("performStopActivity", IBinder.class, cls3);
                declaredMethod2.setAccessible(true);
            } catch (Throwable unused5) {
                declaredMethod2 = null;
            }
        }
        f2077e = declaredMethod2;
        Class<?> cls5 = f2073a;
        int i9 = Build.VERSION.SDK_INT;
        if ((i9 == 26 || i9 == 27) && cls5 != null) {
            try {
                Class cls6 = Integer.TYPE;
                Class cls7 = Boolean.TYPE;
                Method declaredMethod3 = cls5.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, cls6, cls7, Configuration.class, Configuration.class, cls7, cls7);
                declaredMethod3.setAccessible(true);
                method = declaredMethod3;
            } catch (Throwable unused6) {
            }
        }
        f2078f = method;
    }

    /* JADX INFO: renamed from: G.e$a */
    /* JADX INFO: compiled from: ActivityRecreator.java */
    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Activity f2081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2083d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2084e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2085f = false;

        public a(Activity activity) {
            this.f2081b = activity;
            this.f2082c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (this.f2081b == activity) {
                this.f2081b = null;
                this.f2084e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            if (!this.f2084e || this.f2085f || this.f2083d) {
                return;
            }
            Object obj = this.f2080a;
            try {
                Object obj2 = C0314e.f2075c.get(activity);
                if (obj2 == obj && activity.hashCode() == this.f2082c) {
                    C0314e.f2079g.postAtFrontOfQueue(new D1.d(C0314e.f2074b.get(activity), obj2, 1, false));
                    this.f2085f = true;
                    this.f2080a = null;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while fetching field values", th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (this.f2081b == activity) {
                this.f2083d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
