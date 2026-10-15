package Z7;

import X7.u;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f5658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f5661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f5662f;

    static {
        String property;
        int i9 = u.f5171a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f5657a = property;
        f5658b = X7.g.b("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i10 = u.f5171a;
        if (i10 < 2) {
            i10 = 2;
        }
        f5659c = X7.g.c(i10, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f5660d = X7.g.c(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        f5661e = TimeUnit.SECONDS.toNanos(X7.g.b("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f5662f = e.f5652b;
    }
}
