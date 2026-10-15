package V0;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: DataObserverHolder.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Y3.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, b> f4803b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<Y3.b> f4804a = new CopyOnWriteArraySet<>();

    public static b c(String str) {
        b bVar;
        b bVar2 = f4803b.get(str);
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            bVar = new b();
            f4803b.put(str, bVar);
        }
        return bVar;
    }

    @Override // Y3.b
    public final void a(String str, String str2, String str3) {
        Iterator<Y3.b> it = this.f4804a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, str3);
        }
    }

    @Override // Y3.b
    public final void b(boolean z8, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<Y3.b> it = this.f4804a.iterator();
        while (it.hasNext()) {
            it.next().b(z8, str, str2, str3, str4, str5, str6);
        }
    }
}
