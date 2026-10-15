package com.heytap.mcssdk.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f14399a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f14400b = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        f14399a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        f14400b.post(runnable);
    }
}
