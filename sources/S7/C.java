package S7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: DebugStrings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B0.N f4227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B0.N f4228b;

    static {
        int i9 = 7;
        f4227a = new B0.N(i9, "REMOVED_TASK");
        f4228b = new B0.N(i9, "CLOSED_EMPTY");
    }

    public static final String a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final C0396h b(B7.e eVar) {
        C0396h c0396h;
        C0396h c0396h2;
        if (!(eVar instanceof X7.f)) {
            return new C0396h(1, eVar);
        }
        X7.f fVar = (X7.f) eVar;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X7.f.f5137h;
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            B0.N n8 = X7.g.f5143b;
            c0396h = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, n8);
                c0396h2 = null;
                break;
            }
            if (obj instanceof C0396h) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(fVar, obj, n8)) {
                        c0396h2 = (C0396h) obj;
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(fVar) == obj);
            } else if (obj != n8 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c0396h2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0396h.f4280g;
            Object obj2 = atomicReferenceFieldUpdater2.get(c0396h2);
            if (!(obj2 instanceof C0404p) || ((C0404p) obj2).f4296d == null) {
                C0396h.f4279f.set(c0396h2, 536870911);
                atomicReferenceFieldUpdater2.set(c0396h2, C0390b.f4255a);
                c0396h = c0396h2;
            } else {
                c0396h2.m();
            }
            if (c0396h != null) {
                return c0396h;
            }
        }
        return new C0396h(2, eVar);
    }

    public static j0 c(InterfaceC0413z interfaceC0413z, AbstractC0410w abstractC0410w, K7.p pVar, int i9) {
        B7.h hVar = abstractC0410w;
        if ((i9 & 1) != 0) {
            hVar = B7.i.f1761a;
        }
        B b9 = B.f4224a;
        B7.h hVarA = C0408u.a(interfaceC0413z.g(), hVar, true);
        Z7.c cVar = J.f4233a;
        if (hVarA != cVar && hVarA.i(B7.f.a.f1759a) == null) {
            hVarA = hVarA.r(cVar);
        }
        B b10 = B.f4224a;
        j0 j0Var = new j0(hVarA, true);
        j0Var.i0(b9, j0Var, pVar);
        return j0Var;
    }

    public static final Object d(Object obj) {
        return obj instanceof C0405q ? p188x7.g.a(((C0405q) obj).f4300a) : obj;
    }

    public static Object e(K7.p pVar) throws Throwable {
        B7.i iVar = B7.i.f1761a;
        Thread threadCurrentThread = Thread.currentThread();
        B7.f.a aVar = B7.f.a.f1759a;
        N nA = m0.a();
        B7.h hVarA = C0408u.a(iVar, nA, true);
        Z7.c cVar = J.f4233a;
        if (hVarA != cVar && hVarA.i(aVar) == null) {
            hVarA = hVarA.r(cVar);
        }
        C0391c c0391c = new C0391c(hVarA, threadCurrentThread, nA);
        c0391c.i0(B.f4224a, c0391c, pVar);
        N n8 = c0391c.f4258e;
        if (n8 != null) {
            int i9 = N.f4236f;
            n8.z(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jB = n8 != null ? n8.B() : Long.MAX_VALUE;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c0.f4259a;
                if (!(atomicReferenceFieldUpdater.get(c0391c) instanceof U)) {
                    if (n8 != null) {
                        int i10 = N.f4236f;
                        n8.w(false);
                    }
                    Object objB = d0.b(atomicReferenceFieldUpdater.get(c0391c));
                    C0405q c0405q = objB instanceof C0405q ? (C0405q) objB : null;
                    if (c0405q == null) {
                        return objB;
                    }
                    throw c0405q.f4300a;
                }
                LockSupport.parkNanos(c0391c, jB);
            } catch (Throwable th) {
                if (n8 != null) {
                    int i11 = N.f4236f;
                    n8.w(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c0391c.E(interruptedException);
        throw interruptedException;
    }

    public static final String f(B7.e eVar) {
        Object objA;
        if (eVar instanceof X7.f) {
            return ((X7.f) eVar).toString();
        }
        try {
            objA = eVar + '@' + a(eVar);
        } catch (Throwable th) {
            objA = p188x7.g.a(th);
        }
        if (p188x7.f.a(objA) != null) {
            objA = eVar.getClass().getName() + '@' + a(eVar);
        }
        return (String) objA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object g(B7.h hVar, K7.p pVar, D7.i iVar) throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        Object objB;
        B7.h context = iVar.getContext();
        B7.h hVarR = !((Boolean) hVar.A(Boolean.FALSE, new B7.c(1))).booleanValue() ? context.r(hVar) : C0408u.a(context, hVar, false);
        X x8 = (X) hVarR.i(X.a.f4251a);
        if (x8 != null && !x8.a()) {
            throw x8.q();
        }
        if (hVarR == context) {
            X7.r rVar = new X7.r(iVar, hVarR);
            objB = p027d5.a.A(rVar, rVar, pVar);
        } else {
            B7.f.a aVar = B7.f.a.f1759a;
            if (kotlin.jvm.internal.k.a(hVarR.i(aVar), context.i(aVar))) {
                o0 o0Var = new o0(hVarR, iVar);
                B7.h hVar2 = o0Var.f4254c;
                Object objC = X7.v.c(hVar2, null);
                try {
                    Object objA = p027d5.a.A(o0Var, o0Var, pVar);
                    X7.v.a(hVar2, objC);
                    objB = objA;
                } catch (Throwable th) {
                    X7.v.a(hVar2, objC);
                    throw th;
                }
            } else {
                G g4 = new G(iVar, hVarR);
                try {
                    X7.g.a(p142s2.j.v(((D7.a) pVar).create(g4, g4)), p188x7.k.f22364a);
                    do {
                        atomicIntegerFieldUpdater = G.f4231e;
                        int i9 = atomicIntegerFieldUpdater.get(g4);
                        if (i9 != 0) {
                            if (i9 != 2) {
                                throw new IllegalStateException("Already suspended");
                            }
                            objB = d0.b(c0.f4259a.get(g4));
                            if (objB instanceof C0405q) {
                                throw ((C0405q) objB).f4300a;
                            }
                        }
                    } while (!atomicIntegerFieldUpdater.compareAndSet(g4, 0, 1));
                    objB = C7.a.f1806a;
                } catch (Throwable th2) {
                    g4.resumeWith(p188x7.g.a(th2));
                    throw th2;
                }
            }
        }
        C7.a aVar2 = C7.a.f1806a;
        return objB;
    }
}
