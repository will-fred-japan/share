package B;

/* JADX INFO: compiled from: DimensionDependency.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1573m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f1557e = f.a.f1565b;
        } else {
            this.f1557e = f.a.f1566c;
        }
    }

    @Override // B.f
    public final void d(int i9) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.f1559g = i9;
        for (d dVar : this.f1562k) {
            dVar.a(dVar);
        }
    }
}
