package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class ck implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f9819a;

    public ck(ch chVar) {
        this.f9819a = chVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f9819a.f9809l != null) {
                if (this.f9819a.f9810m) {
                    this.f9819a.f9806h.a(this.f9819a.f9815r);
                } else {
                    this.f9819a.f9803e.obtainMessage(4, new co("stopped")).sendToTarget();
                }
            }
            this.f9819a.f9804f.removeCallbacksAndMessages(null);
        } catch (Throwable th) {
            ee.b("PeriodicTaskScheduler", "err in stopTaskInternal", th);
        }
    }
}
