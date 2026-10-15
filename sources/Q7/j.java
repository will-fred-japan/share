package Q7;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements K7.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3885b;

    public /* synthetic */ j(int i9, Object obj) {
        this.f3884a = i9;
        this.f3885b = obj;
    }

    @Override // K7.l
    public final Object invoke(Object it) {
        switch (this.f3884a) {
            case 0:
                kotlin.jvm.internal.k.e(it, "it");
                return ((G6.a) this.f3885b).invoke();
            default:
                ((p096m7.k) this.f3885b).success((String) it);
                return p188x7.k.f22364a;
        }
    }
}
