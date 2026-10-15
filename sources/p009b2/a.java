package p009b2;

import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: LogObserver.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f8495b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<Y1.a> f8496a = new CopyOnWriteArraySet<>();

    public static a a() {
        if (f8495b == null) {
            synchronized (a.class) {
                try {
                    if (f8495b == null) {
                        f8495b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8495b;
    }
}
