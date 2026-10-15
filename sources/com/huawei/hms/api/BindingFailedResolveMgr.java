package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class BindingFailedResolveMgr {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final BindingFailedResolveMgr f14804b = new BindingFailedResolveMgr();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f14805c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<Activity> f14806a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f14805c) {
            try {
                for (Activity activity2 : this.f14806a) {
                    if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                        activity2.finish();
                    }
                }
                this.f14806a.add(activity);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Activity activity) {
        synchronized (f14805c) {
            this.f14806a.remove(activity);
        }
    }
}
