package V7;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes2.dex */
@D7.e(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {418, 422}, m = "onSubscription")
public final class v extends D7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f4979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public W7.n f4980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w<Object> f4982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4983e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, D7.c cVar) {
        super(cVar);
        this.f4982d = wVar;
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        this.f4981c = obj;
        this.f4983e |= Integer.MIN_VALUE;
        return this.f4982d.b(this);
    }
}
