package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14648b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f14649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14651e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f14652a = new b();

    public static class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f14649c = iAvailableProcessors;
        f14650d = iAvailableProcessors + 1;
        f14651e = (iAvailableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f14650d, f14651e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f14648b.f14652a;
    }
}
