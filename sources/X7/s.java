package X7;

import S7.g0;
import X7.s;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s<S extends s<S>> extends b<S> implements g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5168d = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5169c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public s(long j, S s8, int i9) {
        super(s8);
        this.f5169c = j;
        this.cleanedAndPointers$volatile = i9 << 16;
    }

    @Override // X7.b
    public final boolean d() {
        return f5168d.get(this) == g() && b() != null;
    }

    public final boolean f() {
        return f5168d.addAndGet(this, -65536) == g() && b() != null;
    }

    public abstract int g();

    public abstract void h(int i9, B7.h hVar);

    public final void i() {
        if (f5168d.incrementAndGet(this) == g()) {
            e();
        }
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i9;
        do {
            atomicIntegerFieldUpdater = f5168d;
            i9 = atomicIntegerFieldUpdater.get(this);
            if (i9 == g() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, 65536 + i9));
        return true;
    }
}
