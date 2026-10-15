package com.hihonor.push.sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class s0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f14555a;

    public s0(Handler handler) {
        this.f14555a = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f14555a.post(runnable);
    }
}
