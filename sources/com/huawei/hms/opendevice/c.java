package com.huawei.hms.opendevice;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: AsyncThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadGroup f15339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15340b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15341c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f15339a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f15341c = W5.e.u(str, "-pool-");
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            this.f15340b++;
        }
        Thread thread = new Thread(this.f15339a, runnable, this.f15341c + this.f15340b, 0L);
        thread.setUncaughtExceptionHandler(null);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
