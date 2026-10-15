package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class cm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f9821a;

    public cm(ch chVar) {
        this.f9821a = chVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f9821a.f9809l != null) {
                this.f9821a.f9809l.c();
            }
        } catch (Throwable th) {
            ee.b("PeriodicTaskScheduler", "err in stopped callback", th);
        }
    }
}
