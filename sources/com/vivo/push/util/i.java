package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ConcurrentUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f16872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f16873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f16874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ExecutorService f16875d;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f16872a = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f16873b = iMax;
        int i9 = (iAvailableProcessors * 2) + 1;
        f16874c = i9;
        f16875d = new ThreadPoolExecutor(iMax, i9, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new j("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService a() {
        return f16875d;
    }
}
