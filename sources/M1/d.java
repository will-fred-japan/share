package M1;

import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;

/* JADX INFO: compiled from: MainThreadMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f2881b;

    public d(f fVar, long j) {
        this.f2881b = fVar;
        this.f2880a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.f2881b;
        Iterator it = fVar.f2887c.iterator();
        while (it.hasNext()) {
            ((K1.a) it.next()).b(ActivityLifeObserver.getInstance().getTopActivityClassName(), fVar.f2897n, this.f2880a);
        }
    }
}
