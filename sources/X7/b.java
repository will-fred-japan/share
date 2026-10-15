package X7;

import X7.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<N extends b<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5132a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5133b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(s sVar) {
        this._prev$volatile = sVar;
    }

    public final void a() {
        f5133b.set(this, null);
    }

    public final N b() {
        Object obj = f5132a.get(this);
        if (obj == a.f5131a) {
            return null;
        }
        return (N) obj;
    }

    public abstract boolean d();

    public final void e() {
        b bVarB;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5133b;
            b bVar = (b) atomicReferenceFieldUpdater.get(this);
            while (bVar != null && bVar.d()) {
                bVar = (b) atomicReferenceFieldUpdater.get(bVar);
            }
            b bVarB2 = b();
            kotlin.jvm.internal.k.b(bVarB2);
            while (bVarB2.d() && (bVarB = bVarB2.b()) != null) {
                bVarB2 = bVarB;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(bVarB2);
                b bVar2 = ((b) obj) == null ? null : bVar;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(bVarB2, obj, bVar2)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(bVarB2) != obj) {
                    }
                }
            }
            if (bVar != null) {
                f5132a.set(bVar, bVarB2);
            }
            if (!bVarB2.d() || bVarB2.b() == null) {
                if (bVar == null || !bVar.d()) {
                    return;
                }
            }
        }
    }
}
