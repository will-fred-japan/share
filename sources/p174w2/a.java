package p174w2;

import A1.b;
import O6.l;
import R2.c;

/* JADX INFO: compiled from: CommonEventDeliverer.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f22104a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f22105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f22106c;

    /* JADX INFO: renamed from: w2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CommonEventDeliverer.java */
    public static class C0278a {
    }

    static {
        l lVar = new l(1000, 1);
        f22105b = lVar;
        f22106c = true;
        lVar.f3534c = new C0278a();
    }

    public static void a(p192y2.a aVar) {
        p183x2.a aVar2;
        f22105b.d(aVar);
        if (b.f1393A) {
            p010b3.b.a("APM-CommonEvent", "cached CommonEvent:" + aVar);
        }
        synchronized (a.class) {
            if (!f22104a && (aVar2 = (p183x2.a) c.a(p183x2.a.class)) != null) {
                aVar2.a();
                synchronized (a.class) {
                    f22104a = true;
                }
            }
        }
    }

    public static void b(p192y2.c cVar) {
        if (b.f1393A) {
            p010b3.b.a("APM-CommonEvent", "trace_data:" + cVar.b());
        }
        p150t2.a.a(cVar);
    }
}
