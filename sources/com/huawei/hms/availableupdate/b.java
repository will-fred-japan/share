package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: NotInstalledHmsResolveMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f14860b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f14861c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Activity> f14862a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f14861c) {
            try {
                for (Activity activity2 : this.f14862a) {
                    if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                        activity2.finish();
                    }
                }
                this.f14862a.add(activity);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Activity activity) {
        synchronized (f14861c) {
            this.f14862a.remove(activity);
        }
    }
}
