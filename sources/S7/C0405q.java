package S7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: S7.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes2.dex */
public class C0405q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4299b = AtomicIntegerFieldUpdater.newUpdater(C0405q.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f4300a;

    public C0405q(Throwable th, boolean z8) {
        this.f4300a = th;
        this._handled$volatile = z8 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f4300a + ']';
    }
}
