package M1;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Choreographer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import p061i1.h;

/* JADX INFO: compiled from: MainThreadMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements p167v3.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f f2884p = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f2885a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f2890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object[] f2891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long[] f2892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Method f2893i;
    public Choreographer j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e.a f2896m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2898o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f2886b = new long[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f2887c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2888d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2889e = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2894k = 16666666;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2895l = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f2897n = -1;

    public static Object a(f fVar, Object obj, String str) {
        fVar.getClass();
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }

    public static void g(f fVar) {
        fVar.getClass();
        System.nanoTime();
        try {
            int i9 = Build.VERSION.SDK_INT;
            long[] jArr = fVar.f2892h;
            if (jArr == null) {
                fVar.f2897n = SystemClock.uptimeMillis();
            } else if (i9 >= 31) {
                fVar.f2897n = jArr[2] / 1000000;
            } else {
                fVar.f2897n = jArr[1] / 1000000;
            }
            fVar.f2889e = true;
        } finally {
            fVar.f2895l = false;
            Application application = h.f19229a;
        }
    }

    public static Object h(f fVar, Object obj, String str) {
        fVar.getClass();
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(obj.getClass(), str);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }

    public final void b(K1.a aVar) {
        if (!this.f2885a) {
            synchronized (this) {
                try {
                    if (h.h()) {
                        if (!this.f2898o) {
                            throw new RuntimeException("never init!");
                        }
                        if (!this.f2885a) {
                            this.f2885a = true;
                        }
                        if (this.f2888d) {
                            d(this.f2896m);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (this.f2887c.contains(aVar)) {
            return;
        }
        this.f2887c.add(aVar);
    }

    @Override // p167v3.b
    public final void c(Activity activity) {
    }

    public final synchronized void d(e.a aVar) {
        if (this.f2885a) {
            if (this.f2895l) {
                return;
            }
            try {
                synchronized (this.f2890f) {
                    try {
                        Method method = this.f2893i;
                        if (method != null) {
                            method.invoke(this.f2891g[0], -1L, aVar, null);
                            this.f2895l = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // p167v3.b
    /* JADX INFO: renamed from: c */
    public final void mo848c() {
        if (this.j == null && this.f2888d) {
            HashSet<String> hashSet = p076k1.c.f19921a;
            this.j = Choreographer.getInstance();
            p133r2.b.f21107i.a(new e(this));
        }
    }

    @Override // p167v3.b
    public final void e(Bundle bundle) {
    }

    @Override // p167v3.b
    public final void f(Activity activity) {
    }

    @Override // p167v3.b
    public final void onActivityStarted(Activity activity) {
    }
}
