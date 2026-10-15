package S7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class W extends b0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4249f = AtomicIntegerFieldUpdater.newUpdater(W.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f4250e;

    public W(a0 a0Var) {
        this.f4250e = a0Var;
    }

    @Override // S7.b0
    public final boolean j() {
        return true;
    }

    @Override // S7.b0
    public final void k(Throwable th) {
        if (f4249f.compareAndSet(this, 0, 1)) {
            this.f4250e.invoke(th);
        }
    }
}
