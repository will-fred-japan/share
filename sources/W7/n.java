package W7;

import S7.X;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n<T> extends D7.c implements V7.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V7.e<T> f5098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B7.h f5099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public B7.h f5101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public B7.e<? super p188x7.k> f5102e;

    /* JADX WARN: Multi-variable type inference failed */
    public n(V7.e<? super T> eVar, B7.h hVar) {
        super(l.f5096a, B7.i.f1761a);
        this.f5098a = eVar;
        this.f5099b = hVar;
        this.f5100c = ((Number) hVar.A(0, new B7.c(2))).intValue();
    }

    @Override // V7.e
    public final Object a(T t, B7.e<? super p188x7.k> eVar) {
        try {
            Object objD = d(eVar, t);
            return objD == C7.a.f1806a ? objD : p188x7.k.f22364a;
        } catch (Throwable th) {
            this.f5101d = new j(eVar.getContext(), th);
            throw th;
        }
    }

    public final Object d(B7.e<? super p188x7.k> eVar, T t) {
        B7.h context = eVar.getContext();
        X x8 = (X) context.i(X.a.f4251a);
        if (x8 != null && !x8.a()) {
            throw x8.q();
        }
        B7.h hVar = this.f5101d;
        if (hVar != context) {
            if (hVar instanceof j) {
                throw new IllegalStateException(R7.e.B("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((j) hVar).f5095b + ", but then emission attempt of value '" + t + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.A(0, new R7.k(1, this))).intValue() != this.f5100c) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f5099b + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.f5101d = context;
        }
        this.f5102e = eVar;
        o.a aVar = o.f5103a;
        V7.e<T> eVar2 = this.f5098a;
        kotlin.jvm.internal.k.c(eVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        aVar.getClass();
        Object objA = eVar2.a(t, this);
        if (!kotlin.jvm.internal.k.a(objA, C7.a.f1806a)) {
            this.f5102e = null;
        }
        return objA;
    }

    @Override // D7.a, D7.d
    public final D7.d getCallerFrame() {
        B7.e<? super p188x7.k> eVar = this.f5102e;
        if (eVar instanceof D7.d) {
            return (D7.d) eVar;
        }
        return null;
    }

    @Override // D7.c, B7.e
    public final B7.h getContext() {
        B7.h hVar = this.f5101d;
        return hVar == null ? B7.i.f1761a : hVar;
    }

    @Override // D7.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        Throwable thA = p188x7.f.a(obj);
        if (thA != null) {
            this.f5101d = new j(getContext(), thA);
        }
        B7.e<? super p188x7.k> eVar = this.f5102e;
        if (eVar != null) {
            eVar.resumeWith(obj);
        }
        return C7.a.f1806a;
    }
}
