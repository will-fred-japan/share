package A;

import B.o;
import java.util.ArrayList;

/* JADX INFO: compiled from: HelperWidget.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends g {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public g[] f1352l0 = new g[4];

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f1353m0 = 0;

    public final void K(int i9, o oVar, ArrayList arrayList) {
        for (int i10 = 0; i10 < this.f1353m0; i10++) {
            g gVar = this.f1352l0[i10];
            ArrayList<g> arrayList2 = oVar.f1581a;
            if (!arrayList2.contains(gVar)) {
                arrayList2.add(gVar);
            }
        }
        for (int i11 = 0; i11 < this.f1353m0; i11++) {
            B.i.a(this.f1352l0[i11], i9, arrayList, oVar);
        }
    }

    public void L() {
    }
}
