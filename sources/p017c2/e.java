package p017c2;

/* JADX INFO: compiled from: PerfDataCenter.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f8712a;

    public static e a() {
        if (f8712a == null) {
            synchronized (e.class) {
                try {
                    if (f8712a == null) {
                        f8712a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8712a;
    }
}
