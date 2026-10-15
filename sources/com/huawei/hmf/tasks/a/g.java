package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Activity, WeakReference<g>> f14676b = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<WeakReference<ExecuteResult<?>>> f14677a = new ArrayList();

    public final void a(ExecuteResult executeResult) {
        synchronized (this.f14677a) {
            this.f14677a.add(new WeakReference<>(executeResult));
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        synchronized (this.f14677a) {
            try {
                Iterator<WeakReference<ExecuteResult<?>>> it = this.f14677a.iterator();
                while (it.hasNext()) {
                    ExecuteResult<?> executeResult = it.next().get();
                    if (executeResult != null) {
                        executeResult.cancel();
                    }
                }
                this.f14677a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        g gVar;
        WeakReference<g> weakReference = f14676b.get(activity);
        if (weakReference == null || weakReference.get() == null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            g gVar2 = null;
            try {
                g gVar3 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
                if (gVar3 == null) {
                    try {
                        g gVar4 = new g();
                        try {
                            fragmentManager.beginTransaction().add(gVar4, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                            gVar2 = gVar4;
                        } catch (Exception e9) {
                            e = e9;
                            gVar2 = gVar4;
                            try {
                                Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
                            } catch (ClassCastException e10) {
                                e = e10;
                                gVar2 = gVar3;
                                Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                    }
                } else {
                    gVar2 = gVar3;
                }
                f14676b.put(activity, new WeakReference<>(gVar2));
            } catch (ClassCastException e12) {
                e = e12;
            }
            gVar = gVar2;
        } else {
            gVar = weakReference.get();
        }
        if (gVar != null) {
            gVar.a(executeResult);
        }
    }
}
