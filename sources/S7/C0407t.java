package S7;

/* JADX INFO: renamed from: S7.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0407t implements K7.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4304a;

    @Override // K7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4304a) {
            case 0:
                B7.h hVar = (B7.h) obj;
                B7.h.a aVar = (B7.h.a) obj2;
                return aVar instanceof r ? hVar.r(((r) aVar).h()) : hVar.r(aVar);
            default:
                B7.h.a aVar2 = (B7.h.a) obj2;
                if (!(aVar2 instanceof l0)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? aVar2 : Integer.valueOf(iIntValue + 1);
        }
    }
}
