package com.vivo.push;

import android.os.SystemClock;

/* JADX INFO: compiled from: RequestFrequencyControl.java */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f16916a = -1;

    public final synchronized boolean a() {
        boolean z8;
        long j = this.f16916a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        z8 = j != -1 && jElapsedRealtime > j && jElapsedRealtime < j + 2000;
        this.f16916a = SystemClock.elapsedRealtime();
        return z8;
    }
}
