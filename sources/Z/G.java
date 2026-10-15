package Z;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.core.DataStoreImpl$writeData$2", f = "DataStoreImpl.kt", l = {352, 353}, m = "invokeSuspend")
public final class G extends D7.i implements K7.p<m0<Object>, B7.e<? super p188x7.k>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kotlin.jvm.internal.w f5291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f5293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.w f5294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0460l<Object> f5295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f5297h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(kotlin.jvm.internal.w wVar, C0460l<Object> c0460l, Object obj, boolean z8, B7.e<? super G> eVar) {
        super(2, eVar);
        this.f5294e = wVar;
        this.f5295f = c0460l;
        this.f5296g = obj;
        this.f5297h = z8;
    }

    @Override // D7.a
    public final B7.e<p188x7.k> create(Object obj, B7.e<?> eVar) {
        G g4 = new G(this.f5294e, this.f5295f, this.f5296g, this.f5297h, eVar);
        g4.f5293d = obj;
        return g4;
    }

    @Override // K7.p
    public final Object invoke(m0<Object> m0Var, B7.e<? super p188x7.k> eVar) {
        return ((G) create(m0Var, eVar)).invokeSuspend(p188x7.k.f22364a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        if (r6.c(r3, r7) == r0) goto L16;
     */
    @Override // D7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            C7.a r0 = C7.a.f1806a
            int r1 = r7.f5292c
            kotlin.jvm.internal.w r2 = r7.f5294e
            java.lang.Object r3 = r7.f5296g
            Z.l<java.lang.Object> r4 = r7.f5295f
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L28
            if (r1 == r6) goto L1e
            if (r1 != r5) goto L16
            p188x7.g.b(r8)
            goto L59
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            kotlin.jvm.internal.w r1 = r7.f5291b
            java.lang.Object r6 = r7.f5293d
            Z.m0 r6 = (Z.m0) r6
            p188x7.g.b(r8)
            goto L43
        L28:
            p188x7.g.b(r8)
            java.lang.Object r8 = r7.f5293d
            Z.m0 r8 = (Z.m0) r8
            Z.T r1 = r4.g()
            r7.f5293d = r8
            r7.f5291b = r2
            r7.f5292c = r6
            java.lang.Integer r1 = r1.b()
            if (r1 != r0) goto L40
            goto L58
        L40:
            r6 = r8
            r8 = r1
            r1 = r2
        L43:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r1.f20006a = r8
            r8 = 0
            r7.f5293d = r8
            r7.f5291b = r8
            r7.f5292c = r5
            java.lang.Object r8 = r6.c(r3, r7)
            if (r8 != r0) goto L59
        L58:
            return r0
        L59:
            boolean r8 = r7.f5297h
            if (r8 == 0) goto L71
            B0.N r8 = r4.f5427h
            Z.c r0 = new Z.c
            if (r3 == 0) goto L68
            int r1 = r3.hashCode()
            goto L69
        L68:
            r1 = 0
        L69:
            int r2 = r2.f20006a
            r0.<init>(r3, r1, r2)
            r8.f(r0)
        L71:
            x7.k r8 = p188x7.k.f22364a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: Z.G.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
