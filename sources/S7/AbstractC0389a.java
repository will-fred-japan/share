package S7;

/* JADX INFO: renamed from: S7.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractCoroutine.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0389a<T> extends c0 implements B7.e<T>, InterfaceC0413z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B7.h f4254c;

    public AbstractC0389a(B7.h hVar, boolean z8) {
        super(z8);
        R((X) hVar.i(X.a.f4251a));
        this.f4254c = hVar.r(this);
    }

    @Override // S7.c0
    public final String H() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // S7.c0
    public final void Q(L4.b bVar) {
        C0412y.a(this.f4254c, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // S7.c0
    public final void Y(Object obj) {
        if (!(obj instanceof C0405q)) {
            h0(obj);
        } else {
            C0405q c0405q = (C0405q) obj;
            g0(c0405q.f4300a, C0405q.f4299b.get(c0405q) != 0);
        }
    }

    @Override // S7.InterfaceC0413z
    public final B7.h g() {
        return this.f4254c;
    }

    @Override // B7.e
    public final B7.h getContext() {
        return this.f4254c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i0(B b9, AbstractC0389a abstractC0389a, K7.p pVar) {
        int iOrdinal = b9.ordinal();
        if (iOrdinal == 0) {
            try {
                X7.g.a(p142s2.j.v(((D7.a) pVar).create(abstractC0389a, this)), p188x7.k.f22364a);
                return;
            } catch (Throwable th) {
                resumeWith(p188x7.g.a(th));
                throw th;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                p142s2.j.v(((D7.a) pVar).create(abstractC0389a, this)).resumeWith(p188x7.k.f22364a);
                return;
            }
            if (iOrdinal != 3) {
                throw new L4.b();
            }
            try {
                B7.h hVar = this.f4254c;
                Object objC = X7.v.c(hVar, null);
                try {
                    kotlin.jvm.internal.B.b(2, pVar);
                    Object objInvoke = pVar.invoke(abstractC0389a, this);
                    X7.v.a(hVar, objC);
                    if (objInvoke != C7.a.f1806a) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th2) {
                    X7.v.a(hVar, objC);
                    throw th2;
                }
            } catch (Throwable th3) {
                resumeWith(p188x7.g.a(th3));
            }
        }
    }

    @Override // B7.e
    public final void resumeWith(Object obj) {
        Throwable thA = p188x7.f.a(obj);
        if (thA != null) {
            obj = new C0405q(thA, false);
        }
        Object objV = V(obj);
        if (objV == d0.f4271b) {
            return;
        }
        D(objV);
    }

    public void h0(T t) {
    }

    public void g0(Throwable th, boolean z8) {
    }
}
