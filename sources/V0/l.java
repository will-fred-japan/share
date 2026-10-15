package V0;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SessionObserverHolder.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile l f4819b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<Object> f4820a = new CopyOnWriteArraySet<>();

    public static l a() {
        if (f4819b == null) {
            synchronized (l.class) {
                f4819b = new l();
            }
        }
        return f4819b;
    }

    public final void b() {
        Iterator<Object> it = this.f4820a.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b();
        }
    }

    public final void c() {
        Iterator<Object> it = this.f4820a.iterator();
        while (it.hasNext()) {
            ((l) it.next()).c();
        }
    }
}
