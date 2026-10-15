package S7;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class L implements InterfaceC0393e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f4234a;

    public L(K k7) {
        this.f4234a = k7;
    }

    @Override // S7.InterfaceC0393e
    public final void c() {
        this.f4234a.dispose();
    }

    public final String toString() {
        return "DisposeOnCancel[" + this.f4234a + ']';
    }
}
