package H6;

import p096m7.k;
import p188x7.e;
import y7.t;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f2524c;

    public /* synthetic */ c(Object obj, boolean z8, int i9) {
        this.f2522a = i9;
        this.f2523b = obj;
        this.f2524c = z8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2522a) {
            case 0:
                ((k) this.f2523b).success(Boolean.valueOf(this.f2524c));
                break;
            case 1:
                ((k) this.f2523b).success(Boolean.valueOf(this.f2524c));
                break;
            case 2:
                ((k) this.f2523b).success(Boolean.valueOf(this.f2524c));
                break;
            default:
                p080k6.c cVar = (p080k6.c) this.f2523b;
                boolean z8 = this.f2524c;
                cVar.f19992m = z8;
                cVar.i("rcspInit", cVar.f19987g, t.B(new e("ready", Boolean.valueOf(z8))));
                if (z8) {
                    G6.d dVar = cVar.f19993n;
                    cVar.f19993n = null;
                    if (dVar != null) {
                        dVar.run();
                    }
                }
                break;
        }
    }
}
