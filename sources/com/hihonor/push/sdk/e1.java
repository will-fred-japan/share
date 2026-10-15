package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class e1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e1 f14482d = new e1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Executor f14483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile ExecutorService f14484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14485c = new Object();

    public static Executor a() {
        e1 e1Var = f14482d;
        if (e1Var.f14483a == null) {
            synchronized (e1Var.f14485c) {
                try {
                    if (e1Var.f14483a == null) {
                        e1Var.f14483a = new s0(new Handler(Looper.getMainLooper()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e1Var.f14483a;
    }

    public static Executor b() {
        e1 e1Var = f14482d;
        if (e1Var.f14484b == null) {
            synchronized (e1Var.f14485c) {
                try {
                    if (e1Var.f14484b == null) {
                        e1Var.f14484b = e1Var.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e1Var.f14484b;
    }

    public static ExecutorService d() {
        return f14482d.c();
    }

    public final ExecutorService c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
