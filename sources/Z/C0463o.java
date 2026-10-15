package Z;

/* JADX INFO: renamed from: Z.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3", f = "DataStoreImpl.kt", l = {416}, m = "invokeSuspend")
public final class C0463o extends D7.i implements K7.l<B7.e<Object>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0472y f5457c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0463o(C0472y c0472y, B7.e eVar) {
        super(1, eVar);
        this.f5457c = c0472y;
    }

    @Override // D7.a
    public final B7.e<p188x7.k> create(B7.e<?> eVar) {
        return new C0463o(this.f5457c, eVar);
    }

    @Override // K7.l
    public final Object invoke(B7.e<Object> eVar) {
        return ((C0463o) create(eVar)).invokeSuspend(p188x7.k.f22364a);
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        C7.a aVar = C7.a.f1806a;
        int i9 = this.f5456b;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p188x7.g.b(obj);
            return obj;
        }
        p188x7.g.b(obj);
        this.f5456b = 1;
        Object objInvoke = this.f5457c.invoke(this);
        return objInvoke == aVar ? aVar : objInvoke;
    }
}
