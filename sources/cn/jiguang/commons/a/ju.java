package cn.jiguang.commons.a;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class ju implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f10324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f10326c = new AtomicBoolean(false);

    public ju(Runnable runnable, String str) {
        this.f10324a = runnable;
        this.f10325b = str;
    }

    public final void a() {
        this.f10326c.set(true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        try {
            if (!this.f10326c.get() && (runnable = this.f10324a) != null) {
                runnable.run();
            }
        } catch (Throwable unused) {
        }
        js.f10322c.remove(this.f10325b, this);
    }
}
