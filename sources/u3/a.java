package u3;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: MemoryChecker.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f21671f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f21672a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f21673b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f21674c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p108o3.a.C0239a f21675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScheduledFuture<?> f21676e;

    public static a a() {
        if (f21671f == null) {
            synchronized (a.class) {
                try {
                    if (f21671f == null) {
                        f21671f = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21671f;
    }
}
