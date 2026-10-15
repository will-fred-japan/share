package D7;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a {
    private final B7.h _context;
    private transient B7.e<Object> intercepted;

    public c(B7.e<Object> eVar, B7.h hVar) {
        super(eVar);
        this._context = hVar;
    }

    @Override // B7.e
    public B7.h getContext() {
        B7.h hVar = this._context;
        k.b(hVar);
        return hVar;
    }

    public final B7.e<Object> intercepted() {
        B7.e<Object> eVarJ = this.intercepted;
        if (eVarJ == null) {
            B7.f fVar = (B7.f) getContext().i(B7.f.a.f1759a);
            eVarJ = fVar != null ? fVar.j(this) : this;
            this.intercepted = eVarJ;
        }
        return eVarJ;
    }

    @Override // D7.a
    public void releaseIntercepted() {
        B7.e<?> eVar = this.intercepted;
        if (eVar != null && eVar != this) {
            B7.h.a aVarI = getContext().i(B7.f.a.f1759a);
            k.b(aVarI);
            ((B7.f) aVarI).f(eVar);
        }
        this.intercepted = b.f1938a;
    }

    public c(B7.e<Object> eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }
}
