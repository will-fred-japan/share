package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class cq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f9828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9829b;

    private cq(ch chVar) {
        this.f9828a = chVar;
        this.f9829b = 0L;
    }

    public final void a(long j) {
        this.f9829b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ee.a("PeriodicTaskScheduler", "executing async task callback");
            this.f9828a.f9809l.a();
            ee.a("PeriodicTaskScheduler", "async task callback completed");
        } catch (Throwable th) {
            ee.b("PeriodicTaskScheduler", "err in async callback", th);
            this.f9828a.f9802d.incrementAndGet();
            if (this.f9828a.f9809l != null) {
                this.f9828a.f9809l.a("async callback err: " + th.getMessage());
            }
        }
    }

    public /* synthetic */ cq(ch chVar, byte b9) {
        this(chVar);
    }
}
