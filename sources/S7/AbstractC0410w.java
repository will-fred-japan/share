package S7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: S7.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0410w extends B7.a implements B7.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4306b = new a(B7.f.a.f1759a, new C0409v(0));

    /* JADX INFO: renamed from: S7.w$a */
    /* JADX INFO: compiled from: CoroutineDispatcher.kt */
    public static final class a extends B7.b<B7.f, AbstractC0410w> {
    }

    public AbstractC0410w() {
        super(B7.f.a.f1759a);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to S7.w for r3v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // B7.a, B7.h
    public final B7.h d(B7.h.b<?> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.k.e(r4, r0)
            boolean r0 = r4 instanceof B7.b
            B7.i r1 = B7.i.f1761a
            if (r0 == 0) goto L22
            B7.b r4 = (B7.b) r4
            B7.h$b<?> r0 = r3.f1753a
            if (r0 == r4) goto L17
            B7.h$b<?> r2 = r4.f1755b
            if (r2 != r0) goto L16
            goto L17
        L16:
            return r3
        L17:
            K7.l<B7.h$a, E extends B> r4 = r4.f1754a
            java.lang.Object r4 = r4.invoke(r3)
            B7.h$a r4 = (B7.h.a) r4
            if (r4 == 0) goto L27
            goto L26
        L22:
            B7.f$a r0 = B7.f.a.f1759a
            if (r0 != r4) goto L27
        L26:
            return r1
        L27:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: S7.AbstractC0410w.d(B7.h$b):B7.h");
    }

    @Override // B7.f
    public final void f(B7.e<?> eVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        kotlin.jvm.internal.k.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        X7.f fVar = (X7.f) eVar;
        do {
            atomicReferenceFieldUpdater = X7.f.f5137h;
        } while (atomicReferenceFieldUpdater.get(fVar) == X7.g.f5143b);
        Object obj = atomicReferenceFieldUpdater.get(fVar);
        C0396h c0396h = obj instanceof C0396h ? (C0396h) obj : null;
        if (c0396h != null) {
            c0396h.m();
        }
    }

    public abstract void g(B7.h hVar, Runnable runnable);

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to S7.w for r2v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // B7.a, B7.h
    public final <E extends B7.h.a> E i(B7.h.b<E> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.k.e(r3, r0)
            boolean r0 = r3 instanceof B7.b
            if (r0 == 0) goto L1e
            B7.b r3 = (B7.b) r3
            B7.h$b<?> r0 = r2.f1753a
            if (r0 == r3) goto L13
            B7.h$b<?> r1 = r3.f1755b
            if (r1 != r0) goto L23
        L13:
            K7.l<B7.h$a, E extends B> r3 = r3.f1754a
            java.lang.Object r3 = r3.invoke(r2)
            B7.h$a r3 = (B7.h.a) r3
            if (r3 == 0) goto L23
            return r3
        L1e:
            B7.f$a r0 = B7.f.a.f1759a
            if (r0 != r3) goto L23
            return r2
        L23:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: S7.AbstractC0410w.i(B7.h$b):B7.h$a");
    }

    @Override // B7.f
    public final X7.f j(D7.c cVar) {
        return new X7.f(this, cVar);
    }

    public boolean p(B7.h hVar) {
        return !(this instanceof n0);
    }

    public AbstractC0410w s(int i9) {
        X7.a.a(i9);
        return new X7.h(this, i9);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + C.a(this);
    }
}
