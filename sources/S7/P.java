package S7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: EventLoop.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class P extends N {
    public abstract Thread D();

    public void E(long j, O.a aVar) {
        int iD;
        Thread threadD;
        D d9 = D.j;
        d9.getClass();
        boolean z8 = O.f4242i.get(d9) != 0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = O.f4241h;
        X7.x xVar = null;
        if (z8) {
            iD = 1;
        } else {
            O.b bVar = (O.b) atomicReferenceFieldUpdater.get(d9);
            if (bVar == null) {
                O.b bVar2 = new O.b();
                bVar2.f4245c = j;
                while (!atomicReferenceFieldUpdater.compareAndSet(d9, null, bVar2) && atomicReferenceFieldUpdater.get(d9) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(d9);
                kotlin.jvm.internal.k.b(obj);
                bVar = (O.b) obj;
            }
            iD = aVar.d(j, bVar, d9);
        }
        if (iD != 0) {
            if (iD == 1) {
                d9.E(j, aVar);
                throw null;
            }
            if (iD != 2) {
                throw new IllegalStateException("unexpected result");
            }
            return;
        }
        O.b bVar3 = (O.b) atomicReferenceFieldUpdater.get(d9);
        if (bVar3 != null) {
            synchronized (bVar3) {
                X7.x[] xVarArr = bVar3.f5177a;
                xVar = xVarArr != null ? xVarArr[0] : null;
            }
            xVar = (O.a) xVar;
        }
        if (xVar != aVar || Thread.currentThread() == (threadD = d9.D())) {
            return;
        }
        LockSupport.unpark(threadD);
    }
}
