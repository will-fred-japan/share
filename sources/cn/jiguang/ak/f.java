package cn.jiguang.ak;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9212a;

    public f() {
        this(Looper.getMainLooper());
    }

    @Override // cn.jiguang.ak.e
    public Thread a() {
        return this.f9212a.getLooper().getThread();
    }

    public f(Looper looper) {
        this.f9212a = new Handler(looper);
    }

    @Override // cn.jiguang.ak.e
    public void a(Runnable runnable) {
        this.f9212a.post(runnable);
    }
}
