package W7;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
@D7.e(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {56}, m = "invokeSuspend")
public final class e extends D7.i implements K7.p<U7.r<Object>, B7.e<? super p188x7.k>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f5085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f<Object> f5086d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f<Object> fVar, B7.e<? super e> eVar) {
        super(2, eVar);
        this.f5086d = fVar;
    }

    @Override // D7.a
    public final B7.e<p188x7.k> create(Object obj, B7.e<?> eVar) {
        e eVar2 = new e(this.f5086d, eVar);
        eVar2.f5085c = obj;
        return eVar2;
    }

    @Override // K7.p
    public final Object invoke(U7.r<Object> rVar, B7.e<? super p188x7.k> eVar) {
        return ((e) create(rVar, eVar)).invokeSuspend(p188x7.k.f22364a);
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        C7.a aVar = C7.a.f1806a;
        int i9 = this.f5084b;
        if (i9 == 0) {
            p188x7.g.b(obj);
            U7.r<? super Object> rVar = (U7.r) this.f5085c;
            this.f5084b = 1;
            if (this.f5086d.a(rVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p188x7.g.b(obj);
        }
        return p188x7.k.f22364a;
    }
}
