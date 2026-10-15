package S7;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<N> f4290a = new ThreadLocal<>();

    public static N a() {
        ThreadLocal<N> threadLocal = f4290a;
        N n8 = threadLocal.get();
        if (n8 != null) {
            return n8;
        }
        C0392d c0392d = new C0392d(Thread.currentThread());
        threadLocal.set(c0392d);
        return c0392d;
    }
}
