package S7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class O extends P implements F {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4240g = AtomicReferenceFieldUpdater.newUpdater(O.class, Object.class, "_queue$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4241h = AtomicReferenceFieldUpdater.newUpdater(O.class, Object.class, "_delayed$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4242i = AtomicIntegerFieldUpdater.newUpdater(O.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static abstract class a implements Runnable, Comparable<a>, K, X7.x {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f4243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4244b;

        @Override // X7.x
        public final void a(int i9) {
            this.f4244b = i9;
        }

        @Override // X7.x
        public final void b(b bVar) {
            if (this._heap == C.f4227a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = bVar;
        }

        @Override // java.lang.Comparable
        public final int compareTo(a aVar) {
            long j = this.f4243a - aVar.f4243a;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final int d(long j, b bVar, D d9) {
            synchronized (this) {
                if (this._heap == C.f4227a) {
                    return 2;
                }
                synchronized (bVar) {
                    try {
                        Object[] objArr = bVar.f5177a;
                        a aVar = (a) (objArr != null ? objArr[0] : null);
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = O.f4240g;
                        d9.getClass();
                        if (O.f4242i.get(d9) != 0) {
                            return 1;
                        }
                        if (aVar == null) {
                            bVar.f4245c = j;
                        } else {
                            long j8 = aVar.f4243a;
                            if (j8 - j < 0) {
                                j = j8;
                            }
                            if (j - bVar.f4245c > 0) {
                                bVar.f4245c = j;
                            }
                        }
                        long j9 = this.f4243a;
                        long j10 = bVar.f4245c;
                        if (j9 - j10 < 0) {
                            this.f4243a = j10;
                        }
                        bVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // S7.K
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    B0.N n8 = C.f4227a;
                    if (obj == n8) {
                        return;
                    }
                    b bVar = obj instanceof b ? (b) obj : null;
                    if (bVar != null) {
                        synchronized (bVar) {
                            Object obj2 = this._heap;
                            if ((obj2 instanceof X7.w ? (X7.w) obj2 : null) != null) {
                                bVar.b(this.f4244b);
                            }
                        }
                    }
                    this._heap = n8;
                    p188x7.k kVar = p188x7.k.f22364a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final String toString() {
            return "Delayed[nanos=" + this.f4243a + ']';
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class b extends X7.w<a> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f4245c;
    }

    @Override // S7.N
    public final long B() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        B0.N n8;
        Runnable runnable;
        Object obj;
        if (!C()) {
            G();
            loop0: while (true) {
                atomicReferenceFieldUpdater = f4240g;
                Object obj2 = atomicReferenceFieldUpdater.get(this);
                n8 = C.f4228b;
                if (obj2 != null) {
                    if (obj2 instanceof X7.m) {
                        X7.m mVar = (X7.m) obj2;
                        Object objD = mVar.d();
                        if (objD != X7.m.f5159g) {
                            runnable = (Runnable) objD;
                            break;
                        }
                        X7.m mVarC = mVar.c();
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, mVarC) && atomicReferenceFieldUpdater.get(this) == obj2) {
                        }
                    } else if (obj2 != n8) {
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, null)) {
                                runnable = (Runnable) obj2;
                                break loop0;
                            }
                        } while (atomicReferenceFieldUpdater.get(this) == obj2);
                    }
                }
                runnable = null;
                break;
            }
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            y7.e<H<?>> eVar = this.f4239e;
            if (((eVar == null || eVar.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
                Object obj3 = atomicReferenceFieldUpdater.get(this);
                if (obj3 != null) {
                    if (obj3 instanceof X7.m) {
                        long j = X7.m.f5158f.get((X7.m) obj3);
                        if (((int) (1073741823 & j)) != ((int) ((j & 1152921503533105152L) >> 30))) {
                            return 0L;
                        }
                    } else if (obj3 == n8) {
                        return Long.MAX_VALUE;
                    }
                }
                b bVar = (b) f4241h.get(this);
                if (bVar != null) {
                    synchronized (bVar) {
                        Object[] objArr = bVar.f5177a;
                        obj = objArr != null ? objArr[0] : null;
                    }
                    a aVar = (a) obj;
                    if (aVar != null) {
                        long jNanoTime = aVar.f4243a - System.nanoTime();
                        if (jNanoTime >= 0) {
                            return jNanoTime;
                        }
                    }
                }
                return Long.MAX_VALUE;
            }
        }
        return 0L;
    }

    public void F(Runnable runnable) {
        G();
        if (!H(runnable)) {
            D.j.F(runnable);
            return;
        }
        Thread threadD = D();
        if (Thread.currentThread() != threadD) {
            LockSupport.unpark(threadD);
        }
    }

    public final void G() {
        a aVarB;
        b bVar = (b) f4241h.get(this);
        if (bVar == null || X7.w.f5176b.get(bVar) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (bVar) {
                try {
                    Object[] objArr = bVar.f5177a;
                    aVarB = null;
                    Object obj = objArr != null ? objArr[0] : null;
                    if (obj != null) {
                        a aVar = (a) obj;
                        aVarB = ((jNanoTime - aVar.f4243a) > 0L ? 1 : ((jNanoTime - aVar.f4243a) == 0L ? 0 : -1)) >= 0 ? H(aVar) : false ? bVar.b(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (aVarB != null);
    }

    public final boolean H(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4240g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f4242i.get(this) != 0) {
                break;
            }
            if (obj == null) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                    }
                }
                return true;
            }
            if (!(obj instanceof X7.m)) {
                if (obj == C.f4228b) {
                    break;
                }
                X7.m mVar = new X7.m(8, true);
                mVar.a((Runnable) obj);
                mVar.a(runnable);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return true;
            }
            X7.m mVar2 = (X7.m) obj;
            int iA = mVar2.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                X7.m mVarC = mVar2.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVarC) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            } else if (iA == 2) {
                break;
            }
        }
        return false;
    }

    public final boolean I() {
        b bVar;
        y7.e<H<?>> eVar = this.f4239e;
        if (!(eVar != null ? eVar.isEmpty() : true) || ((bVar = (b) f4241h.get(this)) != null && X7.w.f5176b.get(bVar) != 0)) {
            return false;
        }
        Object obj = f4240g.get(this);
        if (obj != null) {
            if (obj instanceof X7.m) {
                long j = X7.m.f5158f.get((X7.m) obj);
                return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
            }
            if (obj != C.f4228b) {
                return false;
            }
        }
        return true;
    }

    @Override // S7.AbstractC0410w
    public final void g(B7.h hVar, Runnable runnable) {
        F(runnable);
    }

    @Override // S7.N
    public void shutdown() {
        a aVarB;
        m0.f4290a.set(null);
        f4242i.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4240g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            B0.N n8 = C.f4228b;
            if (obj == null) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, n8)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == null);
            } else if (obj instanceof X7.m) {
                ((X7.m) obj).b();
                break;
            } else {
                if (obj == n8) {
                    break;
                }
                X7.m mVar = new X7.m(8, true);
                mVar.a((Runnable) obj);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        while (B() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) f4241h.get(this);
            if (bVar == null) {
                return;
            }
            synchronized (bVar) {
                aVarB = X7.w.f5176b.get(bVar) > 0 ? bVar.b(0) : null;
            }
            a aVar = aVarB;
            if (aVar == null) {
                return;
            } else {
                E(jNanoTime, aVar);
            }
        }
    }
}
