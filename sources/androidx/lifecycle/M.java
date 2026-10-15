package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: ViewModelStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f7719a = new LinkedHashMap();

    public final void a() {
        for (I i9 : this.f7719a.values()) {
            i9.f7710c = true;
            HashMap map = i9.f7708a;
            if (map != null) {
                synchronized (map) {
                    try {
                        Iterator it = i9.f7708a.values().iterator();
                        while (it.hasNext()) {
                            I.a(it.next());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            LinkedHashSet linkedHashSet = i9.f7709b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = i9.f7709b.iterator();
                        while (it2.hasNext()) {
                            I.a((Closeable) it2.next());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                i9.f7709b.clear();
            }
            i9.b();
        }
        this.f7719a.clear();
    }
}
