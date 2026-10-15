package cn.jiguang.al;

/* JADX INFO: loaded from: classes.dex */
public final class a extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f9244a;

    public a(String str, Thread thread) {
        super(str);
        this.f9244a = thread;
        setStackTrace(thread.getStackTrace());
    }

    public Thread a() {
        return this.f9244a;
    }
}
