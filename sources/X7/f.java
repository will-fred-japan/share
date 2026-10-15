package X7;

import S7.AbstractC0410w;
import S7.C;
import S7.C0405q;
import S7.H;
import S7.N;
import S7.m0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends H<T> implements D7.d, B7.e<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5137h = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0410w f5138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final D7.c f5139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f5140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f5141g;

    public f(AbstractC0410w abstractC0410w, D7.c cVar) {
        super(-1);
        this.f5138d = abstractC0410w;
        this.f5139e = cVar;
        this.f5140f = g.f5142a;
        this.f5141g = v.b(cVar.getContext());
    }

    @Override // D7.d
    public final D7.d getCallerFrame() {
        D7.c cVar = this.f5139e;
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    @Override // B7.e
    public final B7.h getContext() {
        return this.f5139e.getContext();
    }

    @Override // S7.H
    public final Object h() {
        Object obj = this.f5140f;
        this.f5140f = g.f5142a;
        return obj;
    }

    @Override // B7.e
    public final void resumeWith(Object obj) {
        Throwable thA = p188x7.f.a(obj);
        Object c0405q = thA == null ? obj : new C0405q(thA, false);
        D7.c cVar = this.f5139e;
        B7.h context = cVar.getContext();
        AbstractC0410w abstractC0410w = this.f5138d;
        if (abstractC0410w.p(context)) {
            this.f5140f = c0405q;
            this.f4232c = 0;
            abstractC0410w.g(cVar.getContext(), this);
            return;
        }
        N nA = m0.a();
        if (nA.f4237c >= 4294967296L) {
            this.f5140f = c0405q;
            this.f4232c = 0;
            y7.e<H<?>> eVar = nA.f4239e;
            if (eVar == null) {
                eVar = new y7.e<>();
                nA.f4239e = eVar;
            }
            eVar.addLast(this);
            return;
        }
        nA.z(true);
        try {
            B7.h context2 = cVar.getContext();
            Object objC = v.c(context2, this.f5141g);
            try {
                cVar.resumeWith(obj);
                p188x7.k kVar = p188x7.k.f22364a;
                v.a(context2, objC);
                while (nA.C()) {
                }
            } catch (Throwable th) {
                v.a(context2, objC);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                g(th2);
            } finally {
                nA.w(true);
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f5138d + ", " + C.f(this.f5139e) + ']';
    }

    @Override // S7.H
    public final B7.e<T> d() {
        return this;
    }
}
