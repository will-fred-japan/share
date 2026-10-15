package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AppSpoofResolveMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14856c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f14857d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f14858a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Activity> f14859b = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f14857d) {
            try {
                for (Activity activity2 : this.f14859b) {
                    if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                        activity2.finish();
                    }
                }
                this.f14859b.add(activity);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Activity activity) {
        synchronized (f14857d) {
            this.f14859b.remove(activity);
        }
    }

    public void a(boolean z8) {
        this.f14858a.set(z8);
    }

    public AtomicBoolean a() {
        return this.f14858a;
    }
}
