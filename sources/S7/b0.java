package S7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends X7.k implements K, U {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0 f4256d;

    @Override // S7.U
    public final boolean a() {
        return true;
    }

    @Override // S7.U
    public final e0 b() {
        return null;
    }

    @Override // S7.K
    public final void dispose() {
        c0 c0VarI = i();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c0.f4259a;
            Object obj = atomicReferenceFieldUpdater.get(c0VarI);
            if (obj instanceof b0) {
                if (obj != this) {
                    return;
                }
                M m8 = d0.f4276g;
                while (!atomicReferenceFieldUpdater.compareAndSet(c0VarI, obj, m8)) {
                    if (atomicReferenceFieldUpdater.get(c0VarI) != obj) {
                    }
                }
                return;
            }
            if (!(obj instanceof U) || ((U) obj).b() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = X7.k.f5153a;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof X7.p) {
                    X7.k kVar = ((X7.p) obj2).f5166a;
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                kotlin.jvm.internal.k.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                X7.k kVar2 = (X7.k) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = X7.k.f5155c;
                X7.p pVar = (X7.p) atomicReferenceFieldUpdater3.get(kVar2);
                if (pVar == null) {
                    pVar = new X7.p(kVar2);
                    atomicReferenceFieldUpdater3.set(kVar2, pVar);
                }
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj2, pVar)) {
                        kVar2.e();
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(this) == obj2);
            }
        }
    }

    public X getParent() {
        return i();
    }

    public final c0 i() {
        c0 c0Var = this.f4256d;
        if (c0Var != null) {
            return c0Var;
        }
        kotlin.jvm.internal.k.i("job");
        throw null;
    }

    public abstract boolean j();

    public abstract void k(Throwable th);

    @Override // X7.k
    public final String toString() {
        return getClass().getSimpleName() + '@' + C.a(this) + "[job@" + C.a(i()) + ']';
    }
}
