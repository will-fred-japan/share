package cn.jiguang.commons.a;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
final class fh implements RejectedExecutionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ fe f10058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10059b;

    public fh(fe feVar, boolean z8) {
        this.f10058a = feVar;
        this.f10059b = z8;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        String simpleName = runnable == null ? "null" : runnable.getClass().getSimpleName();
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            throw new RejectedExecutionException("pool shutdown:".concat(simpleName));
        }
        if (!this.f10059b) {
            throw new RejectedExecutionException("task rejected:".concat(simpleName));
        }
        try {
            this.f10058a.c().execute(runnable);
        } catch (RejectedExecutionException e9) {
            throw e9;
        } catch (Throwable th) {
            throw new RejectedExecutionException("fallback failed:".concat(simpleName), th);
        }
    }
}
