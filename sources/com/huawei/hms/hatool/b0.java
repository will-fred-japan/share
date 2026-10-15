package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b0 f15155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b0 f15156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b0 f15157d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f15158a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Runnable f15159a;

        public a(Runnable runnable) {
            this.f15159a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f15159a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f15160d = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadGroup f15161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f15162b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15163c;

        public b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f15161a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f15163c = "FormalHASDK-base-" + f15160d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f15161a, runnable, this.f15163c + this.f15162b.getAndIncrement(), 0L);
        }
    }

    static {
        new b0();
        new b0();
        f15155b = new b0();
        f15156c = new b0();
        f15157d = new b0();
    }

    private b0() {
    }

    public static b0 a() {
        return f15157d;
    }

    public static b0 b() {
        return f15156c;
    }

    public static b0 c() {
        return f15155b;
    }

    public void a(g gVar) {
        try {
            this.f15158a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
