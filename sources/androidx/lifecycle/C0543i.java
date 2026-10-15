package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LegacySavedStateHandleController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0543i implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0544j f7731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p131r0.b f7732b;

    public C0543i(AbstractC0544j abstractC0544j, p131r0.b bVar) {
        this.f7731a = abstractC0544j;
        this.f7732b = bVar;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        if (aVar == AbstractC0544j.a.ON_START) {
            this.f7731a.c(this);
            this.f7732b.d();
        }
    }
}
