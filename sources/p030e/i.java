package p030e;

import K7.a;
import e.o.a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18564b;

    public /* synthetic */ i(int i9, Object obj) {
        this.f18563a = i9;
        this.f18564b = obj;
    }

    @Override // K7.a
    public final Object invoke() {
        switch (this.f18563a) {
            case 0:
                p106o0.a aVar = new p106o0.a();
                ((k) this.f18564b).getOnBackPressedDispatcher().a().f18584c.a(aVar);
                return aVar;
            default:
                return ((o) this.f18564b).new a();
        }
    }
}
