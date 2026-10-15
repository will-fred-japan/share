package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class cl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f9820a;

    public cl(ch chVar) {
        this.f9820a = chVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f9820a.f9809l != null) {
                this.f9820a.f9809l.b();
            }
        } catch (Throwable th) {
            ee.b("PeriodicTaskScheduler", "err in started callback", th);
        }
    }
}
