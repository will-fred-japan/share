package com.engagelab.privates.common;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f12176a;

    public b() {
        this(Looper.getMainLooper());
    }

    @Override // com.engagelab.privates.common.a
    public void a(Runnable runnable) {
        this.f12176a.post(runnable);
    }

    public b(Looper looper) {
        this.f12176a = new Handler(looper);
    }

    @Override // com.engagelab.privates.common.a
    public Thread a() {
        return this.f12176a.getLooper().getThread();
    }
}
