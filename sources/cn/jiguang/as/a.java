package cn.jiguang.as;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static boolean a(long j) {
        return Looper.getMainLooper().getThread().getId() == j;
    }

    public static boolean a(Thread thread) {
        return a(thread.getId());
    }
}
