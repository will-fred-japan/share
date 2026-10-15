package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f9768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ fl f9769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractC0552a f9770c;

    public c(AbstractC0552a abstractC0552a, Runnable runnable, fl flVar) {
        this.f9770c = abstractC0552a;
        this.f9768a = runnable;
        this.f9769b = flVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        fe.a().a(this.f9768a, this.f9769b);
    }
}
