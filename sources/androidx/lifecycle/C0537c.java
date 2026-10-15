package androidx.lifecycle;

import java.util.HashMap;

/* JADX INFO: renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CompositeGeneratedAdaptersObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0537c implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0540f[] f7727a;

    public C0537c(InterfaceC0540f[] interfaceC0540fArr) {
        this.f7727a = interfaceC0540fArr;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        new HashMap();
        InterfaceC0540f[] interfaceC0540fArr = this.f7727a;
        for (InterfaceC0540f interfaceC0540f : interfaceC0540fArr) {
            interfaceC0540f.a();
        }
        for (InterfaceC0540f interfaceC0540f2 : interfaceC0540fArr) {
            interfaceC0540f2.a();
        }
    }
}
