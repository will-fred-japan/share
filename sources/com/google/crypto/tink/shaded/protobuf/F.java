package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: ListFieldSchemaLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class F implements E {
    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final void a(long j, Object obj) {
        ((C0585y.c) n0.f14131c.i(j, obj)).b();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final C0585y.c b(long j, Object obj) {
        C0585y.c cVar = (C0585y.c) n0.f14131c.i(j, obj);
        if (cVar.e()) {
            return cVar;
        }
        int size = cVar.size();
        C0585y.c cVarC = cVar.c(size == 0 ? 10 : size * 2);
        n0.p(j, obj, cVarC);
        return cVarC;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final void c(long j, Object obj, Object obj2) {
        n0.e eVar = n0.f14131c;
        C0585y.c cVarC = (C0585y.c) eVar.i(j, obj);
        C0585y.c cVar = (C0585y.c) eVar.i(j, obj2);
        int size = cVarC.size();
        int size2 = cVar.size();
        if (size > 0 && size2 > 0) {
            if (!cVarC.e()) {
                cVarC = cVarC.c(size2 + size);
            }
            cVarC.addAll(cVar);
        }
        if (size > 0) {
            cVar = cVarC;
        }
        n0.p(j, obj, cVar);
    }
}
