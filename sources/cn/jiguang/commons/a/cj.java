package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class cj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f9818a;

    public cj(ch chVar) {
        this.f9818a = chVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f9818a.f9809l != null) {
                if (this.f9818a.f9810m) {
                    this.f9818a.f9806h.a(this.f9818a.f9814q);
                } else {
                    this.f9818a.f9803e.obtainMessage(4, new co("started")).sendToTarget();
                }
            }
            ee.a("PeriodicTaskScheduler", "triggering first task immediately");
            ch.a(this.f9818a);
        } catch (Throwable th) {
            ee.b("PeriodicTaskScheduler", "err in startTaskInternal", th);
            this.f9818a.f9807i.set(false);
        }
    }
}
