package A;

import java.util.ArrayList;

/* JADX INFO: compiled from: WidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends g {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public ArrayList<g> f1366l0 = new ArrayList<>();

    @Override // A.g
    public final void A(p049g6.f fVar) {
        super.A(fVar);
        int size = this.f1366l0.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f1366l0.get(i9).A(fVar);
        }
    }

    public void K() {
        ArrayList<g> arrayList = this.f1366l0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            g gVar = this.f1366l0.get(i9);
            if (gVar instanceof n) {
                ((n) gVar).K();
            }
        }
    }

    @Override // A.g
    public void y() {
        this.f1366l0.clear();
        super.y();
    }
}
