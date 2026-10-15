package B;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: DependencyNode.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f1556d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1559g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f1553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1554b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1555c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f1557e = a.f1564a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1560h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f1561i = null;
    public boolean j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f1562k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f1563l = new ArrayList();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: DependencyNode.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f1566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f1567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f1568e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f1569f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f1570g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f1571h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ a[] f1572i;

        static {
            a aVar = new a(GrsBaseInfo.CountryCodeSource.UNKNOWN, 0);
            f1564a = aVar;
            a aVar2 = new a("HORIZONTAL_DIMENSION", 1);
            f1565b = aVar2;
            a aVar3 = new a("VERTICAL_DIMENSION", 2);
            f1566c = aVar3;
            a aVar4 = new a("LEFT", 3);
            f1567d = aVar4;
            a aVar5 = new a("RIGHT", 4);
            f1568e = aVar5;
            a aVar6 = new a("TOP", 5);
            f1569f = aVar6;
            a aVar7 = new a("BOTTOM", 6);
            f1570g = aVar7;
            a aVar8 = new a("BASELINE", 7);
            f1571h = aVar8;
            f1572i = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f1572i.clone();
        }
    }

    public f(p pVar) {
        this.f1556d = pVar;
    }

    @Override // B.d
    public final void a(d dVar) {
        ArrayList<f> arrayList = this.f1563l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).j) {
                return;
            }
        }
        this.f1555c = true;
        p pVar = this.f1553a;
        if (pVar != null) {
            pVar.a(this);
        }
        if (this.f1554b) {
            this.f1556d.a(this);
            return;
        }
        f fVar = null;
        int i9 = 0;
        for (f fVar2 : arrayList) {
            if (!(fVar2 instanceof g)) {
                i9++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i9 == 1 && fVar.j) {
            g gVar = this.f1561i;
            if (gVar != null) {
                if (!gVar.j) {
                    return;
                } else {
                    this.f1558f = this.f1560h * gVar.f1559g;
                }
            }
            d(fVar.f1559g + this.f1558f);
        }
        p pVar2 = this.f1553a;
        if (pVar2 != null) {
            pVar2.a(this);
        }
    }

    public final void b(p pVar) {
        this.f1562k.add(pVar);
        if (this.j) {
            pVar.a(pVar);
        }
    }

    public final void c() {
        this.f1563l.clear();
        this.f1562k.clear();
        this.j = false;
        this.f1559g = 0;
        this.f1555c = false;
        this.f1554b = false;
    }

    public void d(int i9) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.f1559g = i9;
        for (d dVar : this.f1562k) {
            dVar.a(dVar);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1556d.f1587b.f1255d0);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f1557e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.f1559g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1563l.size());
        sb.append(":d=");
        sb.append(this.f1562k.size());
        sb.append(">");
        return sb.toString();
    }
}
