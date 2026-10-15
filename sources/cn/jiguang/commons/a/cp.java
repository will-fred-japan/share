package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class cp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f9826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9827b;

    private cp(ch chVar) {
        this.f9826a = chVar;
    }

    public final void a(String str) {
        this.f9827b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f9826a.f9809l != null) {
                this.f9826a.f9809l.a(this.f9827b);
            }
        } catch (Throwable th) {
            ee.b("PeriodicTaskScheduler", "err in async error callback", th);
        }
    }

    public /* synthetic */ cp(ch chVar, byte b9) {
        this(chVar);
    }
}
