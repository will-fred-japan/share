package Z;

import java.io.Serializable;

/* JADX INFO: renamed from: Z.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", l = {387, 388, 390}, m = "invokeSuspend")
public final class C0472y extends D7.i implements K7.l<B7.e<? super p188x7.k>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Serializable f5505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.y<Object> f5507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0460l<Object> f5508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.w f5509f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0472y(kotlin.jvm.internal.y<Object> yVar, C0460l<Object> c0460l, kotlin.jvm.internal.w wVar, B7.e<? super C0472y> eVar) {
        super(1, eVar);
        this.f5507d = yVar;
        this.f5508e = c0460l;
        this.f5509f = wVar;
    }

    @Override // D7.a
    public final B7.e<p188x7.k> create(B7.e<?> eVar) {
        return new C0472y(this.f5507d, this.f5508e, this.f5509f, eVar);
    }

    @Override // K7.l
    public final Object invoke(B7.e<? super p188x7.k> eVar) {
        return ((C0472y) create(eVar)).invokeSuspend(p188x7.k.f22364a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        if (r9 == r0) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // D7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            C7.a r0 = C7.a.f1806a
            int r1 = r8.f5506c
            kotlin.jvm.internal.w r2 = r8.f5509f
            kotlin.jvm.internal.y<java.lang.Object> r3 = r8.f5507d
            r4 = 3
            r5 = 2
            Z.l<java.lang.Object> r6 = r8.f5508e
            r7 = 1
            if (r1 == 0) goto L36
            if (r1 == r7) goto L2e
            if (r1 == r5) goto L26
            if (r1 != r4) goto L1e
            java.io.Serializable r0 = r8.f5505b
            r2 = r0
            kotlin.jvm.internal.w r2 = (kotlin.jvm.internal.w) r2
            p188x7.g.b(r9)
            goto L6d
        L1e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L26:
            java.io.Serializable r1 = r8.f5505b
            kotlin.jvm.internal.w r1 = (kotlin.jvm.internal.w) r1
            p188x7.g.b(r9)     // Catch: Z.C0450b -> L60
            goto L57
        L2e:
            java.io.Serializable r1 = r8.f5505b
            kotlin.jvm.internal.y r1 = (kotlin.jvm.internal.y) r1
            p188x7.g.b(r9)     // Catch: Z.C0450b -> L60
            goto L45
        L36:
            p188x7.g.b(r9)
            r8.f5505b = r3     // Catch: Z.C0450b -> L60
            r8.f5506c = r7     // Catch: Z.C0450b -> L60
            java.lang.Object r9 = r6.i(r8)     // Catch: Z.C0450b -> L60
            if (r9 != r0) goto L44
            goto L6c
        L44:
            r1 = r3
        L45:
            r1.f20008a = r9     // Catch: Z.C0450b -> L60
            Z.T r9 = r6.g()     // Catch: Z.C0450b -> L60
            r8.f5505b = r2     // Catch: Z.C0450b -> L60
            r8.f5506c = r5     // Catch: Z.C0450b -> L60
            java.lang.Integer r9 = r9.e()     // Catch: Z.C0450b -> L60
            if (r9 != r0) goto L56
            goto L6c
        L56:
            r1 = r2
        L57:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch: Z.C0450b -> L60
            int r9 = r9.intValue()     // Catch: Z.C0450b -> L60
            r1.f20006a = r9     // Catch: Z.C0450b -> L60
            goto L75
        L60:
            T r9 = r3.f20008a
            r8.f5505b = r2
            r8.f5506c = r4
            java.lang.Object r9 = r6.j(r9, r7, r8)
            if (r9 != r0) goto L6d
        L6c:
            return r0
        L6d:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r2.f20006a = r9
        L75:
            x7.k r9 = p188x7.k.f22364a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: Z.C0472y.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
