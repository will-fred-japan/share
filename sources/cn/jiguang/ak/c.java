package cn.jiguang.ak;

/* JADX INFO: loaded from: classes.dex */
public final class c extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cn.jiguang.al.c f9207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Throwable f9208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Thread f9209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9210d;

    public c(cn.jiguang.al.c cVar, Throwable th, Thread thread) {
        this(cVar, th, thread, false);
    }

    public cn.jiguang.al.c a() {
        return this.f9207a;
    }

    public Throwable b() {
        return this.f9208b;
    }

    public Thread c() {
        return this.f9209c;
    }

    public boolean d() {
        return this.f9210d;
    }

    public c(cn.jiguang.al.c cVar, Throwable th, Thread thread, boolean z8) {
        this.f9207a = cVar;
        this.f9208b = th;
        this.f9209c = thread;
        this.f9210d = z8;
    }
}
