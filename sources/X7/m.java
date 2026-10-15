package X7;

import B0.N;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5157e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5158f = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final N f5159g = new N(7, "REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f5163d;

    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5164a;

        public a(int i9) {
            this.f5164a = i9;
        }
    }

    public m(int i9, boolean z8) {
        this.f5160a = i9;
        this.f5161b = z8;
        int i10 = i9 - 1;
        this.f5162c = i10;
        this.f5163d = new AtomicReferenceArray(i9);
        if (i10 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i9 & i10) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f5158f;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i9 = (int) (1073741823 & j);
            int i10 = (int) ((1152921503533105152L & j) >> 30);
            int i11 = this.f5162c;
            if (((i10 + 2) & i11) == (i9 & i11)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f5163d;
            if (!this.f5161b && atomicReferenceArray.get(i10 & i11) != null) {
                int i12 = this.f5160a;
                if (i12 < 1024 || ((i10 - i9) & 1073741823) > (i12 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i10 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i10 & i11, runnable);
                m<E> mVarC = this;
                while ((atomicLongFieldUpdater.get(mVarC) & 1152921504606846976L) != 0) {
                    mVarC = mVarC.c();
                    AtomicReferenceArray atomicReferenceArray2 = mVarC.f5163d;
                    int i13 = mVarC.f5162c & i10;
                    Object obj = atomicReferenceArray2.get(i13);
                    if ((obj instanceof a) && ((a) obj).f5164a == i10) {
                        atomicReferenceArray2.set(i13, runnable);
                    } else {
                        mVarC = null;
                    }
                    if (mVarC == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = f5158f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<E> c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        m<E> mVar;
        while (true) {
            atomicLongFieldUpdater = f5158f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                mVar = this;
                break;
            }
            long j8 = 1152921504606846976L | j;
            mVar = this;
            if (atomicLongFieldUpdater.compareAndSet(mVar, j, j8)) {
                j = j8;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5157e;
            m<E> mVar2 = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar2 != null) {
                return mVar2;
            }
            m mVar3 = new m(mVar.f5160a * 2, mVar.f5161b);
            int i9 = (int) (1073741823 & j);
            int i10 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i11 = mVar.f5162c;
                int i12 = i9 & i11;
                if (i12 == (i11 & i10)) {
                    break;
                }
                Object aVar = mVar.f5163d.get(i12);
                if (aVar == null) {
                    aVar = new a(i9);
                }
                mVar3.f5163d.set(mVar3.f5162c & i9, aVar);
                i9++;
            }
            atomicLongFieldUpdater.set(mVar3, (-1152921504606846977L) & j);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, mVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        m<E> mVarC = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f5158f;
            long j = atomicLongFieldUpdater.get(mVarC);
            if ((j & 1152921504606846976L) != 0) {
                return f5159g;
            }
            int i9 = (int) (j & 1073741823);
            int i10 = mVarC.f5162c;
            int i11 = ((int) ((1152921503533105152L & j) >> 30)) & i10;
            int i12 = i10 & i9;
            if (i11 != i12) {
                AtomicReferenceArray atomicReferenceArray = mVarC.f5163d;
                Object obj = atomicReferenceArray.get(i12);
                boolean z8 = mVarC.f5161b;
                if (obj == null) {
                    if (z8) {
                    }
                } else if (!(obj instanceof a)) {
                    long j8 = (i9 + 1) & 1073741823;
                    if (atomicLongFieldUpdater.compareAndSet(mVarC, j, (j & (-1073741824)) | j8)) {
                        atomicReferenceArray.set(i12, null);
                        return obj;
                    }
                    mVarC = this;
                    if (z8) {
                        while (true) {
                            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f5158f;
                            long j9 = atomicLongFieldUpdater2.get(mVarC);
                            int i13 = (int) (j9 & 1073741823);
                            if ((j9 & 1152921504606846976L) != 0) {
                                mVarC = mVarC.c();
                            } else {
                                m<E> mVar = mVarC;
                                mVarC = mVar;
                                if (atomicLongFieldUpdater2.compareAndSet(mVar, j9, (j9 & (-1073741824)) | j8)) {
                                    mVarC.f5163d.set(mVarC.f5162c & i13, null);
                                    mVarC = null;
                                } else {
                                    continue;
                                }
                            }
                            if (mVarC == null) {
                                return obj;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
}
