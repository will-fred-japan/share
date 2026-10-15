package X7;

import B0.N;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final N f5131a = new N(7, "CLOSED");

    public static final void a(int i9) {
        if (i9 < 1) {
            throw new IllegalArgumentException(W5.e.i(i9, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(s sVar, long j, K7.p pVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            if (sVar.f5169c >= j && !sVar.d()) {
                return sVar;
            }
            Object obj = b.f5132a.get(sVar);
            N n8 = f5131a;
            if (obj == n8) {
                return n8;
            }
            s sVar2 = (s) ((b) obj);
            if (sVar2 == null) {
                sVar2 = (s) pVar.invoke(Long.valueOf(sVar.f5169c + 1), sVar);
                do {
                    atomicReferenceFieldUpdater = b.f5132a;
                    if (atomicReferenceFieldUpdater.compareAndSet(sVar, null, sVar2)) {
                        if (sVar.d()) {
                            sVar.e();
                        }
                    }
                } while (atomicReferenceFieldUpdater.get(sVar) == null);
            }
            sVar = sVar2;
        }
    }
}
