package Z;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.core.RunOnce", f = "DataStoreImpl.kt", l = {544, 497}, m = "runIfNeeded")
public final class X extends D7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Y f5342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b8.a f5343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f5344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Y f5345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5346e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(Y y8, D7.c cVar) {
        super(cVar);
        this.f5345d = y8;
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        this.f5344c = obj;
        this.f5346e |= Integer.MIN_VALUE;
        return this.f5345d.b(this);
    }
}
