package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class fj implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ fi f10062a;

    public fj(fi fiVar) {
        this.f10062a = fiVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        ee.b("SdkThreadPoolManager", "t uncaught:" + thread.getName(), th);
    }
}
