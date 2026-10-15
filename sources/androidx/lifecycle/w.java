package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: ReflectiveGenericLifecycleObserver.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class w implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0547m f7777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0536b.a f7778b;

    public w(InterfaceC0547m interfaceC0547m) {
        this.f7777a = interfaceC0547m;
        C0536b c0536b = C0536b.f7720c;
        Class<?> cls = interfaceC0547m.getClass();
        C0536b.a aVar = (C0536b.a) c0536b.f7721a.get(cls);
        this.f7778b = aVar == null ? c0536b.a(cls, null) : aVar;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        HashMap map = this.f7778b.f7723a;
        List list = (List) map.get(aVar);
        InterfaceC0547m interfaceC0547m = this.f7777a;
        C0536b.a.a(list, interfaceC0548n, aVar, interfaceC0547m);
        C0536b.a.a((List) map.get(AbstractC0544j.a.ON_ANY), interfaceC0548n, aVar, interfaceC0547m);
    }
}
