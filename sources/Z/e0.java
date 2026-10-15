package Z;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SingleProcessCoordinator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b8.d f5374a = new b8.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B0.T f5375b = new B0.T();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V7.q f5376c = new V7.q(new a(2, null));

    /* JADX INFO: compiled from: SingleProcessCoordinator.kt */
    @D7.e(c = "androidx.datastore.core.SingleProcessCoordinator$updateNotifications$1", f = "SingleProcessCoordinator.kt", l = {}, m = "invokeSuspend")
    public static final class a extends D7.i implements K7.p<V7.e<? super p188x7.k>, B7.e<? super p188x7.k>, Object> {
        public a() {
            throw null;
        }

        @Override // D7.a
        public final B7.e<p188x7.k> create(Object obj, B7.e<?> eVar) {
            return new a(2, eVar);
        }

        @Override // K7.p
        public final Object invoke(V7.e<? super p188x7.k> eVar, B7.e<? super p188x7.k> eVar2) {
            return ((a) create(eVar, eVar2)).invokeSuspend(p188x7.k.f22364a);
        }

        @Override // D7.a
        public final Object invokeSuspend(Object obj) {
            C7.a aVar = C7.a.f1806a;
            p188x7.g.b(obj);
            return p188x7.k.f22364a;
        }
    }

    public e0(String str) {
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // Z.T
    public final Object a(K7.p pVar, D7.c cVar) throws Throwable {
        d0 d0Var;
        b8.d dVar;
        Throwable th;
        boolean z8;
        if (cVar instanceof d0) {
            d0Var = (d0) cVar;
            int i9 = d0Var.f5370e;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                d0Var.f5370e = i9 - Integer.MIN_VALUE;
            } else {
                d0Var = new d0(this, cVar);
            }
        } else {
            d0Var = new d0(this, cVar);
        }
        Object obj = d0Var.f5368c;
        C7.a aVar = C7.a.f1806a;
        int i10 = d0Var.f5370e;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z8 = d0Var.f5367b;
            dVar = d0Var.f5366a;
            try {
                p188x7.g.b(obj);
                if (z8) {
                    dVar.a(null);
                }
                return obj;
            } catch (Throwable th2) {
                th = th2;
                if (z8) {
                    dVar.a(null);
                }
                throw th;
            }
        }
        p188x7.g.b(obj);
        b8.d dVar2 = this.f5374a;
        boolean zE = dVar2.e();
        try {
            Boolean boolValueOf = Boolean.valueOf(zE);
            d0Var.f5366a = dVar2;
            d0Var.f5367b = zE;
            d0Var.f5370e = 1;
            Object objInvoke = pVar.invoke(boolValueOf, d0Var);
            if (objInvoke == aVar) {
                return aVar;
            }
            dVar = dVar2;
            obj = objInvoke;
            z8 = zE;
            if (z8) {
                dVar.a(null);
            }
            return obj;
        } catch (Throwable th3) {
            dVar = dVar2;
            th = th3;
            z8 = zE;
            if (z8) {
                dVar.a(null);
            }
            throw th;
        }
    }

    @Override // Z.T
    public final Integer b() {
        return new Integer(((AtomicInteger) this.f5375b.f1668b).incrementAndGet());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // Z.T
    public final Object c(K7.l lVar, D7.c cVar) throws Throwable {
        c0 c0Var;
        b8.d dVar;
        Throwable th;
        b8.a aVar;
        if (cVar instanceof c0) {
            c0Var = (c0) cVar;
            int i9 = c0Var.f5365e;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                c0Var.f5365e = i9 - Integer.MIN_VALUE;
            } else {
                c0Var = new c0(this, cVar);
            }
        } else {
            c0Var = new c0(this, cVar);
        }
        Object obj = c0Var.f5363c;
        C7.a aVar2 = C7.a.f1806a;
        int i10 = c0Var.f5365e;
        try {
            if (i10 == 0) {
                p188x7.g.b(obj);
                c0Var.f5361a = lVar;
                dVar = this.f5374a;
                c0Var.f5362b = dVar;
                c0Var.f5365e = 1;
                if (dVar.b(c0Var) != aVar2) {
                }
                return aVar2;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (b8.a) c0Var.f5361a;
                try {
                    p188x7.g.b(obj);
                    aVar.a(null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    aVar.a(null);
                    throw th;
                }
            }
            b8.d dVar2 = c0Var.f5362b;
            K7.l lVar2 = (K7.l) c0Var.f5361a;
            p188x7.g.b(obj);
            dVar = dVar2;
            lVar = lVar2;
            c0Var.f5361a = dVar;
            c0Var.f5362b = null;
            c0Var.f5365e = 2;
            Object objInvoke = lVar.invoke(c0Var);
            if (objInvoke != aVar2) {
                b8.d dVar3 = dVar;
                obj = objInvoke;
                aVar = dVar3;
                aVar.a(null);
                return obj;
            }
            return aVar2;
        } catch (Throwable th3) {
            b8.d dVar4 = dVar;
            th = th3;
            aVar = dVar4;
            aVar.a(null);
            throw th;
        }
    }

    @Override // Z.T
    public final V7.q d() {
        return this.f5376c;
    }

    @Override // Z.T
    public final Integer e() {
        return new Integer(((AtomicInteger) this.f5375b.f1668b).get());
    }
}
