package cn.jiguang.commons.a;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
final class fb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ey f10036a;

    public fb(ey eyVar) {
        this.f10036a = eyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f10036a.f10022k) {
            ey.a(this.f10036a, (ScheduledFuture) null);
        }
        if (this.f10036a.f10023l.compareAndSet(false, true)) {
            fe.a().a(this.f10036a.f10026p, fl.DEVICE_INFO);
        }
    }
}
