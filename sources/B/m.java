package B;

import java.util.ArrayList;

/* JADX INFO: compiled from: RunGroup.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f1576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<p> f1577b;

    public static long a(f fVar, long j) {
        p pVar = fVar.f1556d;
        if (pVar instanceof k) {
            return j;
        }
        ArrayList arrayList = fVar.f1562k;
        int size = arrayList.size();
        long jMin = j;
        for (int i9 = 0; i9 < size; i9++) {
            d dVar = (d) arrayList.get(i9);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1556d != pVar) {
                    jMin = Math.min(jMin, a(fVar2, ((long) fVar2.f1558f) + j));
                }
            }
        }
        if (fVar != pVar.f1594i) {
            return jMin;
        }
        long j8 = pVar.j();
        f fVar3 = pVar.f1593h;
        long j9 = j - j8;
        return Math.min(Math.min(jMin, a(fVar3, j9)), j9 - ((long) fVar3.f1558f));
    }

    public static long b(f fVar, long j) {
        p pVar = fVar.f1556d;
        if (pVar instanceof k) {
            return j;
        }
        ArrayList arrayList = fVar.f1562k;
        int size = arrayList.size();
        long jMax = j;
        for (int i9 = 0; i9 < size; i9++) {
            d dVar = (d) arrayList.get(i9);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1556d != pVar) {
                    jMax = Math.max(jMax, b(fVar2, ((long) fVar2.f1558f) + j));
                }
            }
        }
        if (fVar != pVar.f1593h) {
            return jMax;
        }
        long j8 = pVar.j();
        f fVar3 = pVar.f1594i;
        long j9 = j + j8;
        return Math.max(Math.max(jMax, b(fVar3, j9)), j9 - ((long) fVar3.f1558f));
    }
}
