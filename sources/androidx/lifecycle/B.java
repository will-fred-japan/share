package androidx.lifecycle;

/* JADX INFO: compiled from: SavedStateHandleController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class B implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f7689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7690c;

    public B(String str, z zVar) {
        this.f7688a = str;
        this.f7689b = zVar;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        if (aVar == AbstractC0544j.a.ON_DESTROY) {
            this.f7690c = false;
            interfaceC0548n.getLifecycle().c(this);
        }
    }

    public final void h(AbstractC0544j lifecycle, p131r0.b registry) {
        kotlin.jvm.internal.k.e(registry, "registry");
        kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
        if (this.f7690c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f7690c = true;
        lifecycle.a(this);
        registry.c(this.f7688a, this.f7689b.f7787e);
    }
}
