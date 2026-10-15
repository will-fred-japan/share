package X7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public class l<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5156a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new m(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5156a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            int iA = mVar.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                m<E> mVarC = mVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, mVarC) && atomicReferenceFieldUpdater.get(this) == mVar) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5156a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar.b()) {
                return;
            }
            m<E> mVarC = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, mVarC) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }

    public final int c() {
        m mVar = (m) f5156a.get(this);
        mVar.getClass();
        long j = m.f5158f.get(mVar);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final E d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5156a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            E e9 = (E) mVar.d();
            if (e9 != m.f5159g) {
                return e9;
            }
            m<E> mVarC = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, mVarC) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }
}
