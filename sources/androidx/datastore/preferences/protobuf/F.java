package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: ListFieldSchemaLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class F implements E {
    @Override // androidx.datastore.preferences.protobuf.E
    public final void a(long j, Object obj) {
        ((C0530y.c) p0.f7294c.h(j, obj)).b();
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public final C0530y.c b(long j, Object obj) {
        C0530y.c cVar = (C0530y.c) p0.f7294c.h(j, obj);
        if (cVar.e()) {
            return cVar;
        }
        int size = cVar.size();
        C0530y.c cVarC = cVar.c(size == 0 ? 10 : size * 2);
        p0.o(j, obj, cVarC);
        return cVarC;
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public final void c(long j, Object obj, Object obj2) {
        p0.e eVar = p0.f7294c;
        C0530y.c cVarC = (C0530y.c) eVar.h(j, obj);
        C0530y.c cVar = (C0530y.c) eVar.h(j, obj2);
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
        p0.o(j, obj, cVar);
    }
}
