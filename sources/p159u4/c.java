package p159u4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import p152t4.n;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f21682a;

    public c(d dVar) {
        this.f21682a = dVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String name = activity.getClass().getName();
        d dVar = this.f21682a;
        dVar.f21694f = name;
        dVar.f21695g = System.currentTimeMillis();
        d.f21683u = bundle != null;
        d.f21684v = true;
        dVar.f21689a.add(dVar.f21694f);
        dVar.f21690b.add(Long.valueOf(dVar.f21695g));
        d.b(dVar.f21695g, dVar.f21694f, AppAgent.ON_CREATE, dVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        String name = activity.getClass().getName();
        d dVar = this.f21682a;
        int iIndexOf = dVar.f21689a.indexOf(name);
        if (iIndexOf > -1 && iIndexOf < dVar.f21689a.size()) {
            dVar.f21689a.remove(iIndexOf);
            dVar.f21690b.remove(iIndexOf);
        }
        dVar.f21691c.add(name);
        long jCurrentTimeMillis = System.currentTimeMillis();
        dVar.f21692d.add(Long.valueOf(jCurrentTimeMillis));
        d.b(jCurrentTimeMillis, name, "onDestroy", dVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        String name = activity.getClass().getName();
        d dVar = this.f21682a;
        dVar.f21699l = name;
        dVar.f21700m = System.currentTimeMillis();
        int i9 = dVar.f21706s - 1;
        dVar.f21706s = i9;
        if (i9 != 0) {
            if (i9 < 0) {
                dVar.f21706s = 0;
                dVar.f21703p = false;
                d.f21684v = false;
            }
            d.b(dVar.f21700m, dVar.f21699l, "onPause", dVar);
        }
        dVar.f21703p = false;
        d.f21684v = false;
        dVar.f21704q = SystemClock.uptimeMillis();
        d.b(dVar.f21700m, dVar.f21699l, "onPause", dVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        String name = activity.getClass().getName();
        d dVar = this.f21682a;
        dVar.j = name;
        long jCurrentTimeMillis = System.currentTimeMillis();
        dVar.f21698k = jCurrentTimeMillis;
        dVar.f21706s++;
        if (!dVar.f21703p) {
            dVar.f21703p = true;
            if (d.t) {
                d.t = false;
                d.f21685w = 1;
                d.f21687y = jCurrentTimeMillis;
            }
            if (dVar.j.equals(dVar.f21699l)) {
                boolean z8 = d.f21684v;
                if (z8 && !d.f21683u) {
                    d.f21685w = 4;
                } else if (!z8) {
                    d.f21685w = 3;
                }
                d.f21687y = dVar.f21698k;
            }
            n.d("Background", "false");
        }
        d.b(dVar.f21698k, dVar.j, "onResume", dVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        String name = activity.getClass().getName();
        d dVar = this.f21682a;
        dVar.f21696h = name;
        dVar.f21697i = System.currentTimeMillis();
        d.b(dVar.f21697i, dVar.f21696h, "onStart", dVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        String name = activity.getClass().getName();
        d dVar = this.f21682a;
        dVar.f21701n = name;
        dVar.f21702o = System.currentTimeMillis();
        d.b(dVar.f21702o, dVar.f21701n, "onStop", dVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
