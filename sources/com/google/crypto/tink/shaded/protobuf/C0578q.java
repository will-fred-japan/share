package com.google.crypto.tink.shaded.protobuf;

import java.util.Map;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ExtensionSchemaLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0578q extends AbstractC0577p<AbstractC0583w.d> {
    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final void a(Map.Entry entry) {
        ((AbstractC0583w.d) entry.getKey()).getClass();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final AbstractC0583w.e b(C0576o c0576o, Q q8, int i9) {
        c0576o.getClass();
        return c0576o.f14139a.get(new C0576o.a(q8, i9));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final C0579s<AbstractC0583w.d> c(Object obj) {
        return ((AbstractC0583w.c) obj).extensions;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final C0579s<AbstractC0583w.d> d(Object obj) {
        AbstractC0583w.c cVar = (AbstractC0583w.c) obj;
        C0579s<AbstractC0583w.d> c0579s = cVar.extensions;
        if (c0579s.f14159b) {
            cVar.extensions = c0579s.clone();
        }
        return cVar.extensions;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final boolean e(Q q8) {
        return q8 instanceof AbstractC0583w.c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final void f(Object obj) {
        ((AbstractC0583w.c) obj).extensions.g();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final Object g(Object obj) {
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final void h(Object obj) {
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final void i(Object obj) {
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0577p
    public final void j(Map.Entry entry) {
        ((AbstractC0583w.d) entry.getKey()).getClass();
        throw null;
    }
}
