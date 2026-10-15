package P0;

import U0.l;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: Navigator.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static l f3605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f3606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashSet<Integer> f3607d;

    static {
        new HashMap();
        f3607d = new HashSet<>(8);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        f3607d.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        f3607d.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        l lVar = f3605b;
        if (lVar != null) {
            f3606c = lVar.f4648n;
            long jCurrentTimeMillis = System.currentTimeMillis();
            l lVar2 = f3605b;
            l lVar3 = (l) lVar2.clone();
            lVar3.c(jCurrentTimeMillis);
            long j = jCurrentTimeMillis - lVar2.f4596b;
            if (j <= 0) {
                j = 1000;
            }
            lVar3.f4646l = j;
            Y3.a.f(lVar3);
            f3605b = null;
            if (activity != null) {
                activity.isChild();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Window window;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String name = activity.getClass().getName();
        String str = f3606c;
        l lVar = new l();
        if (TextUtils.isEmpty("")) {
            lVar.f4648n = name;
        } else {
            lVar.f4648n = name.concat(Constants.COLON_SEPARATOR);
        }
        lVar.c(jCurrentTimeMillis);
        lVar.f4646l = -1L;
        if (str == null) {
            str = "";
        }
        lVar.f4647m = str;
        Y3.a.f(lVar);
        f3605b = lVar;
        lVar.f4649o = !f3607d.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild() || (window = activity.getWindow()) == null || window.getDecorView() == null) {
            return;
        }
        window.getDecorView().hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        f3604a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (f3606c != null) {
            int i9 = f3604a - 1;
            f3604a = i9;
            if (i9 <= 0) {
                f3606c = null;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
