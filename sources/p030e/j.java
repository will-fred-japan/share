package p030e;

import G.RunnableC0310a;
import K7.a;
import h8.i;
import h8.n;
import p188x7.k;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18566b;

    public /* synthetic */ j(int i9, Object obj) {
        this.f18565a = i9;
        this.f18566b = obj;
    }

    @Override // K7.a
    public final Object invoke() {
        i iVar;
        switch (this.f18565a) {
            case 0:
                return new o(new RunnableC0310a(10, (k) this.f18566b));
            default:
                n nVar = (n) this.f18566b;
                if (nVar.f19170n && (iVar = nVar.f19162e) != null) {
                    iVar.start();
                }
                return k.f22364a;
        }
    }
}
