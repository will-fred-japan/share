package X7;

import S7.C;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5153a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5154b = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5155c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public /* synthetic */ class a extends kotlin.jvm.internal.r {
        @Override // P7.j
        public final Object get() {
            return this.receiver.getClass().getSimpleName();
        }
    }

    public final boolean d(k kVar, int i9) {
        while (true) {
            k kVarE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5154b;
            if (kVarE == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    kVarE = (k) obj;
                    if (!kVarE.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVarE);
                }
            }
            if (kVarE instanceof i) {
                return (((i) kVarE).f5152d & i9) == 0 && kVarE.d(kVar, i9);
            }
            atomicReferenceFieldUpdater.set(kVar, kVarE);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f5153a;
            atomicReferenceFieldUpdater2.set(kVar, this);
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(kVarE, this, kVar)) {
                    kVar.f(this);
                    return true;
                }
            } while (atomicReferenceFieldUpdater2.get(kVarE) == this);
        }
    }

    public final k e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f5154b;
            k kVar = (k) atomicReferenceFieldUpdater2.get(this);
            k kVar2 = kVar;
            while (true) {
                k kVar3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = f5153a;
                    obj = atomicReferenceFieldUpdater.get(kVar2);
                    if (obj == this) {
                        if (kVar == kVar2) {
                            return kVar2;
                        }
                        while (!atomicReferenceFieldUpdater2.compareAndSet(this, kVar, kVar2)) {
                            if (atomicReferenceFieldUpdater2.get(this) != kVar) {
                                break;
                            }
                        }
                        return kVar2;
                    }
                    if (h()) {
                        return null;
                    }
                    if (!(obj instanceof p)) {
                        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                        kVar3 = kVar2;
                        kVar2 = (k) obj;
                    } else {
                        if (kVar3 != null) {
                            break;
                        }
                        kVar2 = (k) atomicReferenceFieldUpdater2.get(kVar2);
                    }
                }
                k kVar4 = ((p) obj).f5166a;
                while (!atomicReferenceFieldUpdater.compareAndSet(kVar3, kVar2, kVar4)) {
                    if (atomicReferenceFieldUpdater.get(kVar3) != kVar2) {
                        break;
                    }
                }
                kVar2 = kVar3;
            }
        }
    }

    public final void f(k kVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5154b;
            k kVar2 = (k) atomicReferenceFieldUpdater.get(kVar);
            if (f5153a.get(this) != kVar) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(kVar, kVar2, this)) {
                    if (h()) {
                        kVar.e();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(kVar) == kVar2);
        }
    }

    public final k g() {
        k kVar;
        Object obj = f5153a.get(this);
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar != null && (kVar = pVar.f5166a) != null) {
            return kVar;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (k) obj;
    }

    public boolean h() {
        return f5153a.get(this) instanceof p;
    }

    public String toString() {
        return new a(this, C.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + C.a(this);
    }
}
