package V0;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: EventObserverHolder.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f4811b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<Object> f4812a = new CopyOnWriteArraySet<>();

    public static d a() {
        if (f4811b == null) {
            synchronized (d.class) {
                try {
                    if (f4811b == null) {
                        f4811b = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4811b;
    }

    public final void b() {
        Iterator<Object> it = this.f4812a.iterator();
        while (it.hasNext()) {
            ((d) it.next()).b();
        }
    }

    public final void c() {
        Iterator<Object> it = this.f4812a.iterator();
        while (it.hasNext()) {
            ((d) it.next()).c();
        }
    }
}
