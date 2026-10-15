package Z;

/* JADX INFO: compiled from: StorageConnection.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", l = {74}, m = "invokeSuspend")
public final class h0 extends D7.i implements K7.q<W<Object>, Boolean, B7.e<Object>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ W f5392c;

    @Override // K7.q
    public final Object b(W<Object> w8, Boolean bool, B7.e<Object> eVar) {
        bool.getClass();
        h0 h0Var = new h0(3, eVar);
        h0Var.f5392c = w8;
        return h0Var.invokeSuspend(p188x7.k.f22364a);
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        C7.a aVar = C7.a.f1806a;
        int i9 = this.f5391b;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p188x7.g.b(obj);
            return obj;
        }
        p188x7.g.b(obj);
        W w8 = this.f5392c;
        this.f5391b = 1;
        Object objB = w8.b(this);
        return objB == aVar ? aVar : objB;
    }
}
