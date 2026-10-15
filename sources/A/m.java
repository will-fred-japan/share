package A;

import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: VirtualLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends k {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f1355n0 = 0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f1356o0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f1357p0 = 0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f1358q0 = 0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f1359r0 = 0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f1360s0 = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f1361t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f1362u0 = 0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f1363v0 = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final B.b.a f1364w0 = new B.b.a();

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public B.b.InterfaceC0002b f1365x0 = null;

    @Override // A.k
    public final void L() {
        for (int i9 = 0; i9 < this.f1353m0; i9++) {
            g gVar = this.f1352l0[i9];
            if (gVar != null) {
                gVar.f1224A = true;
            }
        }
    }

    public final void N(g gVar, g.a aVar, int i9, g.a aVar2, int i10) {
        B.b.InterfaceC0002b interfaceC0002b;
        g gVar2;
        while (true) {
            interfaceC0002b = this.f1365x0;
            if (interfaceC0002b != null || (gVar2 = this.f1238P) == null) {
                break;
            } else {
                this.f1365x0 = ((h) gVar2).f1295o0;
            }
        }
        B.b.a aVar3 = this.f1364w0;
        aVar3.f1534a = aVar;
        aVar3.f1535b = aVar2;
        aVar3.f1536c = i9;
        aVar3.f1537d = i10;
        ((ConstraintLayout.b) interfaceC0002b).b(gVar, aVar3);
        gVar.H(aVar3.f1538e);
        gVar.E(aVar3.f1539f);
        gVar.f1281y = aVar3.f1541h;
        gVar.B(aVar3.f1540g);
    }

    public void M(int i9, int i10, int i11, int i12) {
    }
}
