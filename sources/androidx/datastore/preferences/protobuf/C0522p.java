package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ExtensionSchemaLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0522p extends AbstractC0521o<AbstractC0528w.d> {
    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final void a(Map.Entry entry) {
        ((AbstractC0528w.d) entry.getKey()).getClass();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final AbstractC0528w.e b(C0520n c0520n, Q q8, int i9) {
        c0520n.getClass();
        return c0520n.f7283a.get(new C0520n.a(i9, q8));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final r<AbstractC0528w.d> c(Object obj) {
        return ((AbstractC0528w.c) obj).extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final r<AbstractC0528w.d> d(Object obj) {
        AbstractC0528w.c cVar = (AbstractC0528w.c) obj;
        r<AbstractC0528w.d> rVar = cVar.extensions;
        if (rVar.f7305b) {
            cVar.extensions = rVar.clone();
        }
        return cVar.extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final boolean e(Q q8) {
        return q8 instanceof AbstractC0528w.c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final void f(Object obj) {
        ((AbstractC0528w.c) obj).extensions.h();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final Object g(Object obj) {
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final void h(Object obj) {
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final void i(Object obj) {
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0521o
    public final void j(Map.Entry entry) {
        ((AbstractC0528w.d) entry.getKey()).getClass();
        throw null;
    }
}
