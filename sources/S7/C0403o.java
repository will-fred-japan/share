package S7;

/* JADX INFO: renamed from: S7.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CompletableDeferred.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C0403o<T> extends c0 implements InterfaceC0402n<T> {
    public final Object g0(D7.i iVar) throws Throwable {
        Object obj;
        Object objB;
        do {
            obj = c0.f4259a.get(this);
            if (!(obj instanceof U)) {
                if (obj instanceof C0405q) {
                    throw ((C0405q) obj).f4300a;
                }
                objB = d0.b(obj);
            }
            C7.a aVar = C7.a.f1806a;
            return objB;
        } while (c0(obj) < 0);
        c0.a aVar2 = new c0.a(p142s2.j.v(iVar), this);
        aVar2.r();
        aVar2.t(new L(S(true, new i0(aVar2))));
        objB = aVar2.q();
        C7.a aVar3 = C7.a.f1806a;
        C7.a aVar4 = C7.a.f1806a;
        return objB;
    }

    @Override // S7.InterfaceC0402n
    public final boolean k(Throwable th) {
        return U(new C0405q(th, false));
    }
}
