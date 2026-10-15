package S7;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: S7.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public class C0396h<T> extends H<T> implements InterfaceC0394f<T>, D7.d, q0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4279f = AtomicIntegerFieldUpdater.newUpdater(C0396h.class, "_decisionAndIndex$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4280g = AtomicReferenceFieldUpdater.newUpdater(C0396h.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4281h = AtomicReferenceFieldUpdater.newUpdater(C0396h.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final B7.e<T> f4282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final B7.h f4283e;

    public C0396h(int i9, B7.e eVar) {
        super(i9);
        this.f4282d = eVar;
        this.f4283e = eVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C0390b.f4255a;
    }

    public static Object A(g0 g0Var, Object obj, int i9, K7.q qVar) {
        if (obj instanceof C0405q) {
            return obj;
        }
        if (i9 != 1 && i9 != 2) {
            return obj;
        }
        if (qVar != null || (g0Var instanceof InterfaceC0393e)) {
            return new C0404p(obj, g0Var instanceof InterfaceC0393e ? (InterfaceC0393e) g0Var : null, qVar, (CancellationException) null, 16);
        }
        return obj;
    }

    public static void v(g0 g0Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + g0Var + ", already has " + obj).toString());
    }

    @Override // S7.H
    public final void a(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4280g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof g0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof C0405q) {
                return;
            }
            if (!(obj instanceof C0404p)) {
                cancellationException2 = cancellationException;
                C0404p c0404p = new C0404p(obj, (InterfaceC0393e) null, (K7.q) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0404p)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            C0404p c0404p2 = (C0404p) obj;
            if (c0404p2.f4297e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            C0404p c0404pA = C0404p.a(c0404p2, null, cancellationException, 15);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c0404pA)) {
                    InterfaceC0393e interfaceC0393e = c0404p2.f4294b;
                    if (interfaceC0393e != null) {
                        i(interfaceC0393e, cancellationException);
                    }
                    K7.q<Throwable, R, B7.h, p188x7.k> qVar = c0404p2.f4295c;
                    if (qVar != 0) {
                        j(qVar, cancellationException, c0404p2.f4293a);
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
            cancellationException2 = cancellationException;
            cancellationException = cancellationException2;
        }
    }

    @Override // S7.q0
    public final void b(X7.s<?> sVar, int i9) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f4279f;
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, ((i10 >> 29) << 29) + i9));
        t(sVar);
    }

    @Override // S7.InterfaceC0394f
    public final B0.N c(Object obj, K7.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4280g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z8 = obj2 instanceof g0;
            B0.N n8 = C0397i.f4284a;
            if (!z8) {
                boolean z9 = obj2 instanceof C0404p;
                return null;
            }
            Object objA = A((g0) obj2, obj, this.f4232c, qVar);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, objA)) {
                    if (!u()) {
                        m();
                    }
                    return n8;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }

    @Override // S7.H
    public final B7.e<T> d() {
        return this.f4282d;
    }

    @Override // S7.H
    public final Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // S7.H
    public final <T> T f(Object obj) {
        return obj instanceof C0404p ? (T) ((C0404p) obj).f4293a : obj;
    }

    @Override // D7.d
    public final D7.d getCallerFrame() {
        B7.e<T> eVar = this.f4282d;
        if (eVar instanceof D7.d) {
            return (D7.d) eVar;
        }
        return null;
    }

    @Override // B7.e
    public final B7.h getContext() {
        return this.f4283e;
    }

    @Override // S7.H
    public final Object h() {
        return f4280g.get(this);
    }

    public final void i(InterfaceC0393e interfaceC0393e, Throwable th) {
        try {
            interfaceC0393e.c();
        } catch (Throwable th2) {
            C0412y.a(this.f4283e, new L4.b("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> void j(K7.q<? super Throwable, ? super R, ? super B7.h, p188x7.k> qVar, Throwable th, R r8) {
        B7.h hVar = this.f4283e;
        try {
            qVar.b(th, r8, hVar);
        } catch (Throwable th2) {
            C0412y.a(hVar, new L4.b("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void k(X7.s<?> sVar, Throwable th) {
        B7.h hVar = this.f4283e;
        int i9 = f4279f.get(this) & 536870911;
        if (i9 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            sVar.h(i9, hVar);
        } catch (Throwable th2) {
            C0412y.a(hVar, new L4.b("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void l(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4280g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof g0)) {
                return;
            }
            C0398j c0398j = new C0398j(this, th, (obj instanceof InterfaceC0393e) || (obj instanceof X7.s));
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c0398j)) {
                    g0 g0Var = (g0) obj;
                    if (g0Var instanceof InterfaceC0393e) {
                        i((InterfaceC0393e) obj, th);
                    } else if (g0Var instanceof X7.s) {
                        k((X7.s) obj, th);
                    }
                    if (!u()) {
                        m();
                    }
                    n(this.f4232c);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    public final void m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4281h;
        K k7 = (K) atomicReferenceFieldUpdater.get(this);
        if (k7 == null) {
            return;
        }
        k7.dispose();
        atomicReferenceFieldUpdater.set(this, f0.f4277a);
    }

    public final void n(int i9) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f4279f;
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z8 = i9 == 4;
                B7.e<T> eVar = this.f4282d;
                if (!z8 && (eVar instanceof X7.f)) {
                    boolean z9 = i9 == 1 || i9 == 2;
                    int i12 = this.f4232c;
                    if (z9 == (i12 == 1 || i12 == 2)) {
                        X7.f fVar = (X7.f) eVar;
                        AbstractC0410w abstractC0410w = fVar.f5138d;
                        B7.h context = fVar.f5139e.getContext();
                        if (abstractC0410w.p(context)) {
                            abstractC0410w.g(context, this);
                            return;
                        }
                        N nA = m0.a();
                        if (nA.f4237c >= 4294967296L) {
                            y7.e<H<?>> eVar2 = nA.f4239e;
                            if (eVar2 == null) {
                                eVar2 = new y7.e<>();
                                nA.f4239e = eVar2;
                            }
                            eVar2.addLast(this);
                            return;
                        }
                        nA.z(true);
                        try {
                            d0.a(this, eVar, true);
                            do {
                            } while (nA.C());
                        } catch (Throwable th) {
                            try {
                                g(th);
                            } finally {
                                nA.w(true);
                            }
                        }
                        return;
                    }
                }
                d0.a(this, eVar, z8);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
    }

    public Throwable o(c0 c0Var) {
        return c0Var.q();
    }

    @Override // S7.InterfaceC0394f
    public final <R extends T> void p(R r8, K7.q<? super Throwable, ? super R, ? super B7.h, p188x7.k> qVar) {
        y(r8, this.f4232c, qVar);
    }

    public final Object q() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i9;
        boolean zU = u();
        do {
            atomicIntegerFieldUpdater = f4279f;
            i9 = atomicIntegerFieldUpdater.get(this);
            int i10 = i9 >> 29;
            if (i10 != 0) {
                if (i10 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zU) {
                    x();
                }
                Object obj = f4280g.get(this);
                if (obj instanceof C0405q) {
                    throw ((C0405q) obj).f4300a;
                }
                int i11 = this.f4232c;
                if (i11 == 1 || i11 == 2) {
                    X x8 = (X) this.f4283e.i(X.a.f4251a);
                    if (x8 != null && !x8.a()) {
                        CancellationException cancellationExceptionQ = x8.q();
                        a(cancellationExceptionQ);
                        throw cancellationExceptionQ;
                    }
                }
                return f(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, 536870912 + (536870911 & i9)));
        if (((K) f4281h.get(this)) == null) {
            s();
        }
        if (zU) {
            x();
        }
        return C7.a.f1806a;
    }

    public final void r() {
        K kS = s();
        if (kS == null || (f4280g.get(this) instanceof g0)) {
            return;
        }
        kS.dispose();
        f4281h.set(this, f0.f4277a);
    }

    @Override // B7.e
    public final void resumeWith(Object obj) {
        Throwable thA = p188x7.f.a(obj);
        if (thA != null) {
            obj = new C0405q(thA, false);
        }
        y(obj, this.f4232c, null);
    }

    public final K s() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        X x8 = (X) this.f4283e.i(X.a.f4251a);
        if (x8 == null) {
            return null;
        }
        C0399k c0399k = new C0399k(0, this);
        K kS = x8 instanceof c0 ? ((c0) x8).S(true, c0399k) : x8.m(true, true, new a0(1, c0399k, b0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0));
        do {
            atomicReferenceFieldUpdater = f4281h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, kS)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return kS;
    }

    public final void t(g0 g0Var) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4280g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C0390b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, g0Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            if ((obj instanceof InterfaceC0393e) || (obj instanceof X7.s)) {
                v(g0Var, obj);
                throw null;
            }
            if (obj instanceof C0405q) {
                C0405q c0405q = (C0405q) obj;
                c0405q.getClass();
                if (!C0405q.f4299b.compareAndSet(c0405q, 0, 1)) {
                    v(g0Var, obj);
                    throw null;
                }
                if (obj instanceof C0398j) {
                    if (obj == null) {
                        c0405q = null;
                    }
                    Throwable th = c0405q != null ? c0405q.f4300a : null;
                    if (g0Var instanceof InterfaceC0393e) {
                        i((InterfaceC0393e) g0Var, th);
                        return;
                    } else {
                        k((X7.s) g0Var, th);
                        return;
                    }
                }
                return;
            }
            if (!(obj instanceof C0404p)) {
                if (g0Var instanceof X7.s) {
                    return;
                }
                C0404p c0404p = new C0404p(obj, (InterfaceC0393e) g0Var, (K7.q) null, (CancellationException) null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0404p)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            C0404p c0404p2 = (C0404p) obj;
            if (c0404p2.f4294b != null) {
                v(g0Var, obj);
                throw null;
            }
            if (g0Var instanceof X7.s) {
                return;
            }
            InterfaceC0393e interfaceC0393e = (InterfaceC0393e) g0Var;
            Throwable th2 = c0404p2.f4297e;
            if (th2 != null) {
                i(interfaceC0393e, th2);
                return;
            }
            C0404p c0404pA = C0404p.a(c0404p2, interfaceC0393e, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0404pA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                }
            }
            return;
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(w());
        sb.append('(');
        sb.append(C.f(this.f4282d));
        sb.append("){");
        Object obj = f4280g.get(this);
        if (obj instanceof g0) {
            str = "Active";
        } else {
            str = obj instanceof C0398j ? "Cancelled" : "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(C.a(this));
        return sb.toString();
    }

    public final boolean u() {
        if (this.f4232c != 2) {
            return false;
        }
        B7.e<T> eVar = this.f4282d;
        kotlin.jvm.internal.k.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return X7.f.f5137h.get((X7.f) eVar) != null;
    }

    public String w() {
        return "CancellableContinuation";
    }

    public final void x() {
        B7.e<T> eVar = this.f4282d;
        Throwable th = null;
        X7.f fVar = eVar instanceof X7.f ? (X7.f) eVar : null;
        if (fVar != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X7.f.f5137h;
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                B0.N n8 = X7.g.f5143b;
                if (obj != n8) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(fVar, n8, this)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(fVar) == n8);
            }
            if (th == null) {
                return;
            }
            m();
            l(th);
        }
    }

    public final <R> void y(R r8, int i9, K7.q<? super Throwable, ? super R, ? super B7.h, p188x7.k> qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4280g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof g0)) {
                if (obj instanceof C0398j) {
                    C0398j c0398j = (C0398j) obj;
                    c0398j.getClass();
                    if (C0398j.f4286c.compareAndSet(c0398j, 0, 1)) {
                        if (qVar != null) {
                            j(qVar, c0398j.f4300a, r8);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + r8).toString());
            }
            Object objA = A((g0) obj, r8, i9, qVar);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, objA)) {
                    if (!u()) {
                        m();
                    }
                    n(i9);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    @Override // S7.InterfaceC0394f
    public final void z(Object obj) {
        n(this.f4232c);
    }
}
