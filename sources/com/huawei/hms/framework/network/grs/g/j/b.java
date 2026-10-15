package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f15113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15114b = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.f15113a = future;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f15113a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.f15114b <= 300000;
    }
}
