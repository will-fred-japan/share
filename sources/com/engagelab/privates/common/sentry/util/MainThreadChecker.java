package com.engagelab.privates.common.sentry.util;

import android.os.Looper;
import com.engagelab.privates.common.sentry.entity.SentryThread;

/* JADX INFO: loaded from: classes.dex */
public final class MainThreadChecker {
    private MainThreadChecker() {
    }

    public static boolean isMainThread(Thread thread) {
        return isMainThread(thread.getId());
    }

    public static boolean isMainThread() {
        return isMainThread(Thread.currentThread());
    }

    public static boolean isMainThread(SentryThread sentryThread) {
        return isMainThread(sentryThread.getId().longValue());
    }

    private static boolean isMainThread(long j) {
        return Looper.getMainLooper().getThread().getId() == j;
    }
}
