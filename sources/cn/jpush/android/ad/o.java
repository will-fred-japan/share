package cn.jpush.android.ad;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f11183a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static int a() {
        return f11183a.getAndIncrement();
    }
}
