package p152t4;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile q f21442a;

    public static q a() {
        if (f21442a == null) {
            if (f21442a == null) {
                synchronized (l.class) {
                    try {
                        if (f21442a == null) {
                            f21442a = new q("default_npth_thread");
                            f21442a.f21465a.start();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            q.e eVar = f21442a.f21465a;
        }
        return f21442a;
    }
}
