package N6;

/* JADX INFO: renamed from: N6.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0342m implements K7.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3354b;

    public /* synthetic */ C0342m(int i9, Object obj) {
        this.f3353a = i9;
        this.f3354b = obj;
    }

    @Override // K7.l
    public final Object invoke(Object obj) {
        switch (this.f3353a) {
            case 0:
                return ((C0344o) this.f3354b).o(obj, null);
            case 1:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                h8.n nVar = (h8.n) this.f3354b;
                if (zBooleanValue) {
                    h8.i iVar = nVar.f19162e;
                    if (iVar != null) {
                        iVar.pause();
                    }
                } else {
                    nVar.d();
                }
                return p188x7.k.f22364a;
            default:
                return y7.a.toString$lambda$2((y7.a) this.f3354b, obj);
        }
    }
}
