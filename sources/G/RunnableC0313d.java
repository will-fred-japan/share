package G;

import android.app.Application;

/* JADX INFO: renamed from: G.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0313d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f2071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0314e.a f2072b;

    public RunnableC0313d(Application application, C0314e.a aVar) {
        this.f2071a = application;
        this.f2072b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2071a.unregisterActivityLifecycleCallbacks(this.f2072b);
    }
}
