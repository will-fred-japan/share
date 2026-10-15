package G2;

import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: ApmCpuManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f2283b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f2284a = new CopyOnWriteArraySet<>();

    public static a a() {
        if (f2283b == null) {
            synchronized (a.class) {
                try {
                    if (f2283b == null) {
                        f2283b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f2283b;
    }
}
