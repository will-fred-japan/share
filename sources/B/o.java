package B;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: WidgetGroup.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f1580f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<A.g> f1581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<a> f1584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1585e;

    /* JADX INFO: compiled from: WidgetGroup.java */
    public class a {
    }

    public final void a(ArrayList<o> arrayList) {
        int size = this.f1581a.size();
        if (this.f1585e != -1 && size > 0) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                o oVar = arrayList.get(i9);
                if (this.f1585e == oVar.f1582b) {
                    c(this.f1583c, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(p197z.c cVar, int i9) {
        int iN;
        int iN2;
        ArrayList<A.g> arrayList = this.f1581a;
        if (arrayList.size() == 0) {
            return 0;
        }
        A.h hVar = (A.h) arrayList.get(0).f1238P;
        cVar.t();
        hVar.b(cVar, false);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList.get(i10).b(cVar, false);
        }
        if (i9 == 0 && hVar.f1300t0 > 0) {
            A.c.a(hVar, cVar, arrayList, 0);
        }
        if (i9 == 1 && hVar.f1301u0 > 0) {
            A.c.a(hVar, cVar, arrayList, 1);
        }
        try {
            cVar.p();
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        this.f1584d = new ArrayList<>();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            A.g gVar = arrayList.get(i11);
            a aVar = new a();
            new WeakReference(gVar);
            p197z.c.n(gVar.f1227D);
            p197z.c.n(gVar.f1228E);
            p197z.c.n(gVar.f1229F);
            p197z.c.n(gVar.f1230G);
            p197z.c.n(gVar.f1231H);
            this.f1584d.add(aVar);
        }
        if (i9 == 0) {
            iN = p197z.c.n(hVar.f1227D);
            iN2 = p197z.c.n(hVar.f1229F);
            cVar.t();
        } else {
            iN = p197z.c.n(hVar.f1228E);
            iN2 = p197z.c.n(hVar.f1230G);
            cVar.t();
        }
        return iN2 - iN;
    }

    public final void c(int i9, o oVar) {
        for (A.g gVar : this.f1581a) {
            ArrayList<A.g> arrayList = oVar.f1581a;
            if (!arrayList.contains(gVar)) {
                arrayList.add(gVar);
            }
            int i10 = oVar.f1582b;
            if (i9 == 0) {
                gVar.f1266j0 = i10;
            } else {
                gVar.f1268k0 = i10;
            }
        }
        this.f1585e = oVar.f1582b;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        int i9 = this.f1583c;
        if (i9 == 0) {
            str = "Horizontal";
        } else if (i9 == 1) {
            str = "Vertical";
        } else {
            str = i9 == 2 ? "Both" : "Unknown";
        }
        sb.append(str);
        sb.append(" [");
        String strI = A.f.i(sb, this.f1582b, "] <");
        for (A.g gVar : this.f1581a) {
            StringBuilder sbC = p171w.a.c(strI, " ");
            sbC.append(gVar.f1255d0);
            strI = sbC.toString();
        }
        return W5.e.u(strI, " >");
    }
}
