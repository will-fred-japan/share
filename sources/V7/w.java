package V7;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w<T> implements e<T> {
    @Override // V7.e
    public final Object a(T t, B7.e<? super p188x7.k> eVar) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v1, types: [D7.c, int] */
    public final p188x7.k b(D7.c cVar) {
        v vVar;
        if (cVar instanceof v) {
            vVar = (v) cVar;
            int i9 = vVar.f4983e;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                vVar.f4983e = i9 - Integer.MIN_VALUE;
            } else {
                vVar = new v(this, cVar);
            }
        } else {
            vVar = new v(this, cVar);
        }
        Object obj = vVar.f4981c;
        C7.a aVar = C7.a.f1806a;
        ?? r8 = vVar.f4983e;
        try {
            if (r8 == 0) {
                p188x7.g.b(obj);
                W7.n nVar = new W7.n(null, vVar.getContext());
                vVar.f4979a = this;
                vVar.f4980b = nVar;
                vVar.f4983e = 1;
                throw null;
            }
            if (r8 != 1) {
                if (r8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p188x7.g.b(obj);
                return p188x7.k.f22364a;
            }
            W7.n nVar2 = vVar.f4980b;
            w wVar = vVar.f4979a;
            p188x7.g.b(obj);
            nVar2.releaseIntercepted();
            wVar.getClass();
            return p188x7.k.f22364a;
        } catch (Throwable th) {
            r8.releaseIntercepted();
            throw th;
        }
    }
}
