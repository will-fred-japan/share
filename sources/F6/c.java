package F6;

import A6.f;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import com.lzf.easyfloat.data.FloatConfig;
import java.lang.ref.WeakReference;
import java.util.Map;
import p188x7.k;

/* JADX INFO: compiled from: LifecycleUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (activity == null) {
            return;
        }
        WeakReference weakReference = p027d5.a.f18519d;
        if (weakReference != null) {
            weakReference.clear();
        }
        p027d5.a.f18519d = new WeakReference(activity);
        for (Map.Entry<String, A6.c> entry : f.f1505a.entrySet()) {
            String key = entry.getKey();
            FloatConfig floatConfig = entry.getValue().f1490b;
            if (floatConfig.getShowPattern() != B6.a.f1745a) {
                if (floatConfig.getShowPattern() == B6.a.f1747c) {
                    p027d5.a.z(key, false);
                } else if (floatConfig.getNeedShow$easyfloat_release()) {
                    p027d5.a.z(key, !floatConfig.getFilterSet().contains(activity.getComponentName().getClassName()));
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (activity == null) {
            return;
        }
        p027d5.a.f18518c++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        FloatConfig floatConfig;
        IBinder iBinder;
        View decorView;
        if (activity == null) {
            return;
        }
        p027d5.a.f18518c--;
        if (activity.isFinishing() || p027d5.a.f18518c <= 0) {
            for (Map.Entry<String, A6.c> entry : f.f1505a.entrySet()) {
                String key = entry.getKey();
                A6.c value = entry.getValue();
                if (activity.isFinishing() && (iBinder = value.c().token) != null) {
                    Window window = activity.getWindow();
                    IBinder windowToken = null;
                    if (window != null && (decorView = window.getDecorView()) != null) {
                        windowToken = decorView.getWindowToken();
                    }
                    if (iBinder.equals(windowToken)) {
                        f.a(key);
                    }
                }
                FloatConfig floatConfig2 = value.f1490b;
                if (p027d5.a.f18518c <= 0 && floatConfig2.getShowPattern() != B6.a.f1745a) {
                    boolean needShow$easyfloat_release = true;
                    boolean z8 = floatConfig2.getShowPattern() != B6.a.f1746b && floatConfig2.getNeedShow$easyfloat_release();
                    A6.c cVar = f.f1505a.get(key);
                    if (cVar != null && (floatConfig = cVar.f1490b) != null) {
                        needShow$easyfloat_release = floatConfig.getNeedShow$easyfloat_release();
                    }
                    A6.c cVarB = f.b(key);
                    if (cVarB != null) {
                        cVarB.f(z8 ? 0 : 8, needShow$easyfloat_release);
                        k kVar = k.f22364a;
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
