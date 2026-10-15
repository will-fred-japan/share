package Q4;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: Q4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentCallbacks2C0346b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ComponentCallbacks2C0346b f3801e = new ComponentCallbacks2C0346b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f3802a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f3803b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f3804c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3805d = false;

    /* JADX INFO: renamed from: Q4.b$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public interface a {
        void a(boolean z8);
    }

    public final void a(boolean z8) {
        synchronized (f3801e) {
            try {
                Iterator it = this.f3804c.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(z8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f3803b;
        boolean zCompareAndSet = this.f3802a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f3803b;
        boolean zCompareAndSet = this.f3802a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            a(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i9) {
        if (i9 == 20 && this.f3802a.compareAndSet(false, true)) {
            this.f3803b.set(true);
            a(true);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
