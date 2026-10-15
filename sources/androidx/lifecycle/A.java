package androidx.lifecycle;

/* JADX INFO: compiled from: SavedStateHandleSupport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class A implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D f7687a;

    public A(D d9) {
        this.f7687a = d9;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        if (aVar == AbstractC0544j.a.ON_CREATE) {
            interfaceC0548n.getLifecycle().c(this);
            this.f7687a.b();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
        }
    }
}
