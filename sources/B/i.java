package B;

import java.util.ArrayList;

/* JADX INFO: compiled from: Grouping.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static o a(A.g gVar, int i9, ArrayList<o> arrayList, o oVar) {
        int i10;
        int i11 = i9 == 0 ? gVar.f1266j0 : gVar.f1268k0;
        if (i11 != -1 && (oVar == null || i11 != oVar.f1582b)) {
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                o oVar2 = arrayList.get(i12);
                if (oVar2.f1582b == i11) {
                    if (oVar != null) {
                        oVar.c(i9, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                    break;
                }
            }
        } else if (i11 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if (gVar instanceof A.k) {
                A.k kVar = (A.k) gVar;
                int i13 = 0;
                while (true) {
                    if (i13 >= kVar.f1353m0) {
                        i10 = -1;
                        break;
                    }
                    A.g gVar2 = kVar.f1352l0[i13];
                    if ((i9 == 0 && (i10 = gVar2.f1266j0) != -1) || (i9 == 1 && (i10 = gVar2.f1268k0) != -1)) {
                        break;
                    }
                    i13++;
                }
                if (i10 != -1) {
                    for (int i14 = 0; i14 < arrayList.size(); i14++) {
                        o oVar3 = arrayList.get(i14);
                        if (oVar3.f1582b == i10) {
                            oVar = oVar3;
                            break;
                        }
                    }
                }
            }
            if (oVar == null) {
                oVar = new o();
                oVar.f1581a = new ArrayList<>();
                oVar.f1584d = null;
                oVar.f1585e = -1;
                int i15 = o.f1580f;
                o.f1580f = i15 + 1;
                oVar.f1582b = i15;
                oVar.f1583c = i9;
            }
            arrayList.add(oVar);
        }
        ArrayList<A.g> arrayList2 = oVar.f1581a;
        if (arrayList2.contains(gVar)) {
            return oVar;
        }
        arrayList2.add(gVar);
        if (gVar instanceof A.j) {
            A.j jVar = (A.j) gVar;
            jVar.f1349o0.c(jVar.f1350p0 == 0 ? 1 : 0, oVar, arrayList);
        }
        int i16 = oVar.f1582b;
        if (i9 == 0) {
            gVar.f1266j0 = i16;
            gVar.f1227D.c(i9, oVar, arrayList);
            gVar.f1229F.c(i9, oVar, arrayList);
        } else {
            gVar.f1268k0 = i16;
            gVar.f1228E.c(i9, oVar, arrayList);
            gVar.f1231H.c(i9, oVar, arrayList);
            gVar.f1230G.c(i9, oVar, arrayList);
        }
        gVar.f1234K.c(i9, oVar, arrayList);
        return oVar;
    }

    public static boolean b(A.g.a aVar, A.g.a aVar2, A.g.a aVar3, A.g.a aVar4) {
        A.g.a aVar5 = A.g.a.f1283a;
        A.g.a aVar6 = A.g.a.f1286d;
        A.g.a aVar7 = A.g.a.f1284b;
        return (aVar3 == aVar5 || aVar3 == aVar7 || (aVar3 == aVar6 && aVar != aVar7)) || (aVar4 == aVar5 || aVar4 == aVar7 || (aVar4 == aVar6 && aVar2 != aVar7));
    }
}
