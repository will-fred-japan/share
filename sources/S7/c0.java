package S7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
public class c0 implements X, h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4259a = AtomicReferenceFieldUpdater.newUpdater(c0.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4260b = AtomicReferenceFieldUpdater.newUpdater(c0.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: compiled from: JobSupport.kt */
    public static final class a<T> extends C0396h<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final C0403o f4261i;

        public a(B7.e eVar, C0403o c0403o) {
            super(1, eVar);
            this.f4261i = c0403o;
        }

        @Override // S7.C0396h
        public final Throwable o(c0 c0Var) {
            Throwable thD;
            C0403o c0403o = this.f4261i;
            c0403o.getClass();
            Object obj = c0.f4259a.get(c0403o);
            if (!(obj instanceof c) || (thD = ((c) obj).d()) == null) {
                return obj instanceof C0405q ? ((C0405q) obj).f4300a : c0Var.q();
            }
            return thD;
        }

        @Override // S7.C0396h
        public final String w() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    public static final class b extends b0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c0 f4262e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f4263f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final C0401m f4264g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f4265h;

        public b(c0 c0Var, c cVar, C0401m c0401m, Object obj) {
            this.f4262e = c0Var;
            this.f4263f = cVar;
            this.f4264g = c0401m;
            this.f4265h = obj;
        }

        @Override // S7.b0
        public final boolean j() {
            return false;
        }

        @Override // S7.b0
        public final void k(Throwable th) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c0.f4259a;
            c0 c0Var = this.f4262e;
            c0Var.getClass();
            C0401m c0401m = this.f4264g;
            C0401m c0401mW = c0.W(c0401m);
            c cVar = this.f4263f;
            Object obj = this.f4265h;
            if (c0401mW == null || !c0Var.f0(cVar, c0401mW, obj)) {
                cVar.f4269a.d(new X7.i(2), 2);
                C0401m c0401mW2 = c0.W(c0401m);
                if (c0401mW2 == null || !c0Var.f0(cVar, c0401mW2, obj)) {
                    c0Var.C(c0Var.L(cVar, obj));
                }
            }
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    public static final class c implements U {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f4266b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f4267c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f4268d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile = 0;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f4269a;

        public c(e0 e0Var, Throwable th) {
            this.f4269a = e0Var;
            this._rootCause$volatile = th;
        }

        @Override // S7.U
        public final boolean a() {
            return d() == null;
        }

        @Override // S7.U
        public final e0 b() {
            return this.f4269a;
        }

        public final void c(Throwable th) {
            Throwable thD = d();
            if (thD == null) {
                f4267c.set(this, th);
                return;
            }
            if (th == thD) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4268d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                    return;
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
            if (th == obj) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(th);
            atomicReferenceFieldUpdater.set(this, arrayList);
        }

        public final Throwable d() {
            return (Throwable) f4267c.get(this);
        }

        public final boolean e() {
            return d() != null;
        }

        public final ArrayList f(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4268d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayList = (ArrayList) obj;
            }
            Throwable thD = d();
            if (thD != null) {
                arrayList.add(0, thD);
            }
            if (th != null && !th.equals(thD)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, d0.f4274e);
            return arrayList;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Finishing[cancelling=");
            sb.append(e());
            sb.append(", completing=");
            sb.append(f4266b.get(this) != 0);
            sb.append(", rootCause=");
            sb.append(d());
            sb.append(", exceptions=");
            sb.append(f4268d.get(this));
            sb.append(", list=");
            sb.append(this.f4269a);
            sb.append(']');
            return sb.toString();
        }
    }

    public c0(boolean z8) {
        this._state$volatile = z8 ? d0.f4276g : d0.f4275f;
    }

    public static C0401m W(X7.k kVar) {
        while (kVar.h()) {
            X7.k kVarE = kVar.e();
            if (kVarE == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X7.k.f5154b;
                Object obj = atomicReferenceFieldUpdater.get(kVar);
                while (true) {
                    kVar = (X7.k) obj;
                    if (!kVar.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVar);
                }
            } else {
                kVar = kVarE;
            }
        }
        while (true) {
            kVar = kVar.g();
            if (!kVar.h()) {
                if (kVar instanceof C0401m) {
                    return (C0401m) kVar;
                }
                if (kVar instanceof e0) {
                    return null;
                }
            }
        }
    }

    public static String d0(Object obj) {
        if (!(obj instanceof c)) {
            if (obj instanceof U) {
                return ((U) obj).a() ? "Active" : "New";
            }
            return obj instanceof C0405q ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        if (cVar.e()) {
            return "Cancelling";
        }
        return c.f4266b.get(cVar) != 0 ? "Completing" : "Active";
    }

    @Override // B7.h
    public final <R> R A(R r8, K7.p<? super R, ? super B7.h.a, ? extends R> pVar) {
        return pVar.invoke(r8, this);
    }

    public void D(Object obj) {
        C(obj);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[LOOP:2: B:59:0x00bf->B:101:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0041 A[PHI: r0
  0x0041: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v13 java.lang.Object) binds: [B:3:0x0008, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    /* JADX WARN: Code duplicated, block: B:29:0x0067 A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #0 {all -> 0x007f, blocks: (B:24:0x0052, B:29:0x0067, B:32:0x006d, B:40:0x0087, B:36:0x007a, B:39:0x0081), top: B:84:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x006d A[Catch: all -> 0x007f, TRY_ENTER, TryCatch #0 {all -> 0x007f, blocks: (B:24:0x0052, B:29:0x0067, B:32:0x006d, B:40:0x0087, B:36:0x007a, B:39:0x0081), top: B:84:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0078 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x007a A[Catch: all -> 0x007f, TryCatch #0 {all -> 0x007f, blocks: (B:24:0x0052, B:29:0x0067, B:32:0x006d, B:40:0x0087, B:36:0x007a, B:39:0x0081), top: B:84:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0090  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:81:0x0112 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0113  */
    /* JADX WARN: Code duplicated, block: B:84:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x0045, please report this as an issue */
    public final boolean E(Object obj) {
        Throwable thK;
        Object obj2;
        c cVar;
        boolean z8;
        Throwable thD;
        B0.N n8;
        U u8;
        e0 e0VarO;
        c cVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object objE0;
        Object objE1 = d0.f4270a;
        if (N()) {
            do {
                Object obj3 = f4259a.get(this);
                if (obj3 instanceof U) {
                    if (obj3 instanceof c) {
                        c cVar3 = (c) obj3;
                        cVar3.getClass();
                        if (c.f4266b.get(cVar3) != 0) {
                        }
                    }
                    objE1 = e0(obj3, new C0405q(K(obj), false));
                }
                objE1 = d0.f4270a;
                break;
            } while (objE1 == d0.f4272c);
            if (objE1 != d0.f4271b) {
                if (objE1 == d0.f4270a) {
                    thK = null;
                    loop1: while (true) {
                        obj2 = f4259a.get(this);
                        if (obj2 instanceof c) {
                            synchronized (obj2) {
                                try {
                                    cVar = (c) obj2;
                                    cVar.getClass();
                                    if (c.f4268d.get(cVar) == d0.f4274e) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    if (z8) {
                                        n8 = d0.f4273d;
                                    } else {
                                        boolean zE = ((c) obj2).e();
                                        if (obj == null || !zE) {
                                            if (thK == null) {
                                                thK = K(obj);
                                            }
                                            ((c) obj2).c(thK);
                                        }
                                        thD = zE ? null : ((c) obj2).d();
                                        if (thD != null) {
                                            X(((c) obj2).f4269a, thD);
                                        }
                                        n8 = d0.f4270a;
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } else if (obj2 instanceof U) {
                            if (thK == null) {
                                thK = K(obj);
                            }
                            u8 = (U) obj2;
                            if (u8.a()) {
                                e0VarO = O(u8);
                                if (e0VarO == null) {
                                    continue;
                                } else {
                                    cVar2 = new c(e0VarO, thK);
                                    while (true) {
                                        atomicReferenceFieldUpdater = f4259a;
                                        if (atomicReferenceFieldUpdater.compareAndSet(this, u8, cVar2)) {
                                            X(e0VarO, thK);
                                            n8 = d0.f4270a;
                                        } else if (atomicReferenceFieldUpdater.get(this) != u8) {
                                        }
                                    }
                                }
                            } else {
                                objE0 = e0(obj2, new C0405q(thK, false));
                                if (objE0 != d0.f4270a) {
                                    throw new IllegalStateException(("Cannot happen in " + obj2).toString());
                                }
                                if (objE0 != d0.f4272c) {
                                    objE1 = objE0;
                                    break;
                                }
                            }
                        } else {
                            n8 = d0.f4273d;
                        }
                        objE1 = n8;
                        break;
                    }
                }
                if (objE1 != d0.f4270a && objE1 != d0.f4271b) {
                    if (objE1 == d0.f4273d) {
                        return false;
                    }
                    C(objE1);
                    return true;
                }
            }
        } else {
            if (objE1 == d0.f4270a) {
                thK = null;
                loop1: while (true) {
                    obj2 = f4259a.get(this);
                    if (obj2 instanceof c) {
                        synchronized (obj2) {
                            cVar = (c) obj2;
                            cVar.getClass();
                            if (c.f4268d.get(cVar) == d0.f4274e) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (z8) {
                                n8 = d0.f4273d;
                            } else {
                                boolean zE2 = ((c) obj2).e();
                                if (obj == null) {
                                    if (thK == null) {
                                        thK = K(obj);
                                    }
                                    ((c) obj2).c(thK);
                                } else {
                                    if (thK == null) {
                                        thK = K(obj);
                                    }
                                    ((c) obj2).c(thK);
                                }
                                if (zE2) {
                                }
                                if (thD != null) {
                                    X(((c) obj2).f4269a, thD);
                                }
                                n8 = d0.f4270a;
                            }
                        }
                    } else if (obj2 instanceof U) {
                        if (thK == null) {
                            thK = K(obj);
                        }
                        u8 = (U) obj2;
                        if (u8.a()) {
                            e0VarO = O(u8);
                            if (e0VarO == null) {
                                continue;
                            } else {
                                cVar2 = new c(e0VarO, thK);
                                while (true) {
                                    atomicReferenceFieldUpdater = f4259a;
                                    if (atomicReferenceFieldUpdater.compareAndSet(this, u8, cVar2)) {
                                        X(e0VarO, thK);
                                        n8 = d0.f4270a;
                                    } else if (atomicReferenceFieldUpdater.get(this) != u8) {
                                    }
                                }
                            }
                        } else {
                            objE0 = e0(obj2, new C0405q(thK, false));
                            if (objE0 != d0.f4270a) {
                                throw new IllegalStateException(("Cannot happen in " + obj2).toString());
                            }
                            if (objE0 != d0.f4272c) {
                                objE1 = objE0;
                                break;
                            }
                        }
                    } else {
                        n8 = d0.f4273d;
                    }
                    objE1 = n8;
                    break;
                }
            }
            if (objE1 != d0.f4270a) {
                if (objE1 == d0.f4273d) {
                    return false;
                }
                C(objE1);
                return true;
            }
        }
        return true;
    }

    public void F(CancellationException cancellationException) {
        E(cancellationException);
    }

    public final boolean G(Throwable th) {
        if (!T()) {
            boolean z8 = th instanceof CancellationException;
            InterfaceC0400l interfaceC0400l = (InterfaceC0400l) f4260b.get(this);
            if (interfaceC0400l == null || interfaceC0400l == f0.f4277a) {
                return z8;
            }
            return interfaceC0400l.c(th) || z8;
        }
        return true;
    }

    public String H() {
        return "Job was cancelled";
    }

    public boolean I(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return E(th) && M();
    }

    public final void J(U u8, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4260b;
        InterfaceC0400l interfaceC0400l = (InterfaceC0400l) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0400l != null) {
            interfaceC0400l.dispose();
            atomicReferenceFieldUpdater.set(this, f0.f4277a);
        }
        L4.b bVar = null;
        C0405q c0405q = obj instanceof C0405q ? (C0405q) obj : null;
        Throwable th = c0405q != null ? c0405q.f4300a : null;
        if (u8 instanceof b0) {
            try {
                ((b0) u8).k(th);
                return;
            } catch (Throwable th2) {
                Q(new L4.b("Exception in completion handler " + u8 + " for " + this, th2));
                return;
            }
        }
        e0 e0VarB = u8.b();
        if (e0VarB != null) {
            e0VarB.d(new X7.i(1), 1);
            Object obj2 = X7.k.f5153a.get(e0VarB);
            kotlin.jvm.internal.k.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (X7.k kVarG = (X7.k) obj2; !kVarG.equals(e0VarB); kVarG = kVarG.g()) {
                if (kVarG instanceof b0) {
                    try {
                        ((b0) kVarG).k(th);
                    } catch (Throwable th3) {
                        if (bVar != null) {
                            p188x7.j.a(bVar, th3);
                        } else {
                            bVar = new L4.b("Exception in completion handler " + kVarG + " for " + this, th3);
                            p188x7.k kVar = p188x7.k.f22364a;
                        }
                    }
                }
            }
            if (bVar != null) {
                Q(bVar);
            }
        }
    }

    public final Throwable K(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new Y(H(), null, this) : th;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((h0) obj).o();
    }

    public final Object L(c cVar, Object obj) {
        Object obj2 = null;
        Throwable y8 = null;
        C0405q c0405q = obj instanceof C0405q ? (C0405q) obj : null;
        Throwable th = c0405q != null ? c0405q.f4300a : null;
        synchronized (cVar) {
            cVar.e();
            ArrayList<Throwable> arrayListF = cVar.f(th);
            if (!arrayListF.isEmpty()) {
                for (Object obj3 : arrayListF) {
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                y8 = (Throwable) obj2;
                if (y8 == null) {
                    y8 = (Throwable) arrayListF.get(0);
                }
            } else if (cVar.e()) {
                y8 = new Y(H(), null, this);
            }
            if (y8 != null && arrayListF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                for (Throwable th2 : arrayListF) {
                    if (th2 != y8 && th2 != y8 && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        p188x7.j.a(y8, th2);
                    }
                }
            }
        }
        if (y8 != null && y8 != th) {
            obj = new C0405q(y8, false);
        }
        if (y8 != null && (G(y8) || P(y8))) {
            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0405q.f4299b.compareAndSet((C0405q) obj, 0, 1);
        }
        Y(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4259a;
        Object v5 = obj instanceof U ? new V((U) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, cVar, v5) && atomicReferenceFieldUpdater.get(this) == cVar) {
        }
        J(cVar, obj);
        return obj;
    }

    public boolean M() {
        return true;
    }

    public boolean N() {
        return this instanceof C0403o;
    }

    public final e0 O(U u8) {
        e0 e0VarB = u8.b();
        if (e0VarB != null) {
            return e0VarB;
        }
        if (u8 instanceof M) {
            return new e0();
        }
        if (u8 instanceof b0) {
            b0((b0) u8);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + u8).toString());
    }

    public boolean P(Throwable th) {
        return false;
    }

    public final void R(X x8) {
        f0 f0Var = f0.f4277a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4260b;
        if (x8 == null) {
            atomicReferenceFieldUpdater.set(this, f0Var);
            return;
        }
        x8.start();
        InterfaceC0400l interfaceC0400lU = x8.u(this);
        atomicReferenceFieldUpdater.set(this, interfaceC0400lU);
        if (f4259a.get(this) instanceof U) {
            return;
        }
        interfaceC0400lU.dispose();
        atomicReferenceFieldUpdater.set(this, f0Var);
    }

    public final K S(boolean z8, b0 b0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z9;
        boolean zD;
        b0Var.f4256d = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f4259a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z10 = obj instanceof M;
            f0 f0Var = f0.f4277a;
            z9 = true;
            if (!z10) {
                if (!(obj instanceof U)) {
                    z9 = false;
                    break;
                }
                U u8 = (U) obj;
                e0 e0VarB = u8.b();
                if (e0VarB == null) {
                    kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    b0((b0) obj);
                } else {
                    if (b0Var.j()) {
                        c cVar = u8 instanceof c ? (c) u8 : null;
                        Throwable thD = cVar != null ? cVar.d() : null;
                        if (thD == null) {
                            zD = e0VarB.d(b0Var, 5);
                        } else if (z8) {
                            b0Var.k(thD);
                            return f0Var;
                        }
                    } else {
                        zD = e0VarB.d(b0Var, 1);
                    }
                    if (zD) {
                        break;
                    }
                }
            } else {
                M m8 = (M) obj;
                if (m8.f4235a) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, b0Var)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                } else {
                    a0(m8);
                }
            }
            return f0Var;
        }
        if (z9) {
            return b0Var;
        }
        if (z8) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            C0405q c0405q = obj2 instanceof C0405q ? (C0405q) obj2 : null;
            b0Var.k(c0405q != null ? c0405q.f4300a : null);
        }
        return f0Var;
    }

    public boolean T() {
        return this instanceof C0391c;
    }

    public final boolean U(Object obj) {
        Object objE0;
        do {
            objE0 = e0(f4259a.get(this), obj);
            if (objE0 == d0.f4270a) {
                return false;
            }
            if (objE0 == d0.f4271b) {
                return true;
            }
        } while (objE0 == d0.f4272c);
        C(objE0);
        return true;
    }

    public final Object V(Object obj) {
        Object objE0;
        do {
            objE0 = e0(f4259a.get(this), obj);
            if (objE0 == d0.f4270a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                C0405q c0405q = obj instanceof C0405q ? (C0405q) obj : null;
                throw new IllegalStateException(str, c0405q != null ? c0405q.f4300a : null);
            }
        } while (objE0 == d0.f4272c);
        return objE0;
    }

    public final void X(e0 e0Var, Throwable th) {
        e0Var.d(new X7.i(4), 4);
        Object obj = X7.k.f5153a.get(e0Var);
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        L4.b bVar = null;
        for (X7.k kVarG = (X7.k) obj; !kVarG.equals(e0Var); kVarG = kVarG.g()) {
            if ((kVarG instanceof b0) && ((b0) kVarG).j()) {
                try {
                    ((b0) kVarG).k(th);
                } catch (Throwable th2) {
                    if (bVar != null) {
                        p188x7.j.a(bVar, th2);
                    } else {
                        bVar = new L4.b("Exception in completion handler " + kVarG + " for " + this, th2);
                        p188x7.k kVar = p188x7.k.f22364a;
                    }
                }
            }
        }
        if (bVar != null) {
            Q(bVar);
        }
        G(th);
    }

    @Override // S7.X
    public boolean a() {
        Object obj = f4259a.get(this);
        return (obj instanceof U) && ((U) obj).a();
    }

    public final void a0(M m8) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e0 e0Var = new e0();
        Object t = e0Var;
        if (!m8.f4235a) {
            t = new T(e0Var);
        }
        do {
            atomicReferenceFieldUpdater = f4259a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, m8, t)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == m8);
    }

    @Override // S7.X
    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new Y(H(), null, this);
        }
        F(cancellationException);
    }

    public final void b0(b0 b0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e0 e0Var = new e0();
        b0Var.getClass();
        X7.k.f5154b.set(e0Var, b0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = X7.k.f5153a;
        atomicReferenceFieldUpdater2.set(e0Var, b0Var);
        loop0: while (atomicReferenceFieldUpdater2.get(b0Var) == b0Var) {
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(b0Var, b0Var, e0Var)) {
                    e0Var.f(b0Var);
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(b0Var) == b0Var);
        }
        X7.k kVarG = b0Var.g();
        do {
            atomicReferenceFieldUpdater = f4259a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, b0Var, kVarG)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == b0Var);
    }

    public final int c0(Object obj) {
        boolean z8 = obj instanceof M;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4259a;
        if (z8) {
            if (((M) obj).f4235a) {
                return 0;
            }
            M m8 = d0.f4276g;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, m8)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(obj instanceof T)) {
            return 0;
        }
        e0 e0Var = ((T) obj).f4247a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, e0Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        return 1;
    }

    @Override // B7.h
    public final B7.h d(B7.h.b<?> bVar) {
        return B7.h.a.C0007a.b(this, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final Object e0(Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof U)) {
            return d0.f4270a;
        }
        if (((obj instanceof M) || (obj instanceof b0)) && !(obj instanceof C0401m) && !(obj2 instanceof C0405q)) {
            U u8 = (U) obj;
            Object v5 = obj2 instanceof U ? new V((U) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = f4259a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, u8, v5)) {
                    Y(obj2);
                    J(u8, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == u8);
            return d0.f4272c;
        }
        U u9 = (U) obj;
        e0 e0VarO = O(u9);
        if (e0VarO == null) {
            return d0.f4272c;
        }
        c cVar = u9 instanceof c ? (c) u9 : null;
        if (cVar == null) {
            cVar = new c(e0VarO, null);
        }
        kotlin.jvm.internal.y yVar = new kotlin.jvm.internal.y();
        synchronized (cVar) {
            try {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c.f4266b;
                if (atomicIntegerFieldUpdater.get(cVar) != 0) {
                    return d0.f4270a;
                }
                atomicIntegerFieldUpdater.set(cVar, 1);
                if (cVar != u9) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4259a;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, u9, cVar)) {
                        if (atomicReferenceFieldUpdater2.get(this) != u9) {
                            return d0.f4272c;
                        }
                    }
                }
                boolean zE = cVar.e();
                C0405q c0405q = obj2 instanceof C0405q ? (C0405q) obj2 : null;
                if (c0405q != null) {
                    cVar.c(c0405q.f4300a);
                }
                ?? D8 = zE ? 0 : cVar.d();
                yVar.f20008a = D8;
                p188x7.k kVar = p188x7.k.f22364a;
                if (D8 != 0) {
                    X(e0VarO, D8);
                }
                C0401m c0401mW = W(e0VarO);
                if (c0401mW != null && f0(cVar, c0401mW, obj2)) {
                    return d0.f4271b;
                }
                e0VarO.d(new X7.i(2), 2);
                C0401m c0401mW2 = W(e0VarO);
                return (c0401mW2 == null || !f0(cVar, c0401mW2, obj2)) ? L(cVar, obj2) : d0.f4271b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean f0(c cVar, C0401m c0401m, Object obj) {
        do {
            b bVar = new b(this, cVar, c0401m, obj);
            c0 c0Var = c0401m.f4289e;
            if ((c0Var != null ? c0Var.S(false, bVar) : c0Var.m(false, false, new a0(1, bVar, b0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0))) != f0.f4277a) {
                return true;
            }
            c0401m = W(c0401m);
        } while (c0401m != null);
        return false;
    }

    @Override // B7.h.a
    public final B7.h.b<?> getKey() {
        return X.a.f4251a;
    }

    @Override // B7.h
    public final <E extends B7.h.a> E i(B7.h.b<E> bVar) {
        return (E) B7.h.a.C0007a.a(this, bVar);
    }

    public boolean l(Object obj) {
        return U(obj);
    }

    @Override // S7.X
    public final K m(boolean z8, boolean z9, a0 a0Var) {
        return S(z9, z8 ? new W(a0Var) : new C0399k(1, a0Var));
    }

    @Override // S7.h0
    public final CancellationException o() {
        Throwable thD;
        Object obj = f4259a.get(this);
        if (obj instanceof c) {
            thD = ((c) obj).d();
        } else if (obj instanceof C0405q) {
            thD = ((C0405q) obj).f4300a;
        } else {
            if (obj instanceof U) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj).toString());
            }
            thD = null;
        }
        CancellationException cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        return cancellationException == null ? new Y("Parent job is ".concat(d0(obj)), thD, this) : cancellationException;
    }

    @Override // S7.X
    public final CancellationException q() {
        CancellationException y8;
        Object obj = f4259a.get(this);
        if (!(obj instanceof c)) {
            if (obj instanceof U) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(obj instanceof C0405q)) {
                return new Y(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((C0405q) obj).f4300a;
            y8 = th instanceof CancellationException ? (CancellationException) th : null;
            return y8 == null ? new Y(H(), th, this) : y8;
        }
        Throwable thD = ((c) obj).d();
        if (thD == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        y8 = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (y8 == null) {
            if (strConcat == null) {
                strConcat = H();
            }
            y8 = new Y(strConcat, thD, this);
        }
        return y8;
    }

    @Override // B7.h
    public final B7.h r(B7.h context) {
        kotlin.jvm.internal.k.e(context, "context");
        return context == B7.i.f1761a ? this : (B7.h) context.A(this, new B7.g(0));
    }

    @Override // S7.X
    public final boolean start() {
        int iC0;
        do {
            iC0 = c0(f4259a.get(this));
            if (iC0 == 0) {
                return false;
            }
        } while (iC0 != 1);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + d0(f4259a.get(this)) + '}');
        sb.append('@');
        sb.append(C.a(this));
        return sb.toString();
    }

    @Override // S7.X
    public final InterfaceC0400l u(c0 c0Var) {
        C0401m c0401m = new C0401m(c0Var);
        c0401m.f4256d = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4259a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof M) {
                M m8 = (M) obj;
                if (m8.f4235a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0401m)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                        }
                    }
                    break loop0;
                }
                a0(m8);
            } else {
                boolean z8 = obj instanceof U;
                f0 f0Var = f0.f4277a;
                Throwable thD = null;
                if (!z8) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    C0405q c0405q = obj2 instanceof C0405q ? (C0405q) obj2 : null;
                    c0401m.k(c0405q != null ? c0405q.f4300a : null);
                    return f0Var;
                }
                e0 e0VarB = ((U) obj).b();
                if (e0VarB != null) {
                    if (e0VarB.d(c0401m, 7)) {
                        break;
                    }
                    boolean zD = e0VarB.d(c0401m, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof c) {
                        thD = ((c) obj3).d();
                    } else {
                        C0405q c0405q2 = obj3 instanceof C0405q ? (C0405q) obj3 : null;
                        if (c0405q2 != null) {
                            thD = c0405q2.f4300a;
                        }
                    }
                    c0401m.k(thD);
                    if (zD) {
                        break;
                    }
                    return f0Var;
                }
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                b0((b0) obj);
            }
        }
        return c0401m;
    }

    @Override // S7.X
    public final K x(K7.l<? super Throwable, p188x7.k> lVar) {
        return S(true, new C0399k(1, lVar));
    }

    public void Z() {
    }

    public void C(Object obj) {
    }

    public void Q(L4.b bVar) {
        throw bVar;
    }

    public void Y(Object obj) {
    }
}
