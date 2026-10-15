package A;

import B.o;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ConstraintAnchor.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f1208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f1209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f1210f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p197z.e f1213i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<e> f1205a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1211g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1212h = -1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ConstraintAnchor.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f1216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f1217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f1218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f1219f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f1220g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f1221h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ a[] f1222i;

        /* JADX INFO: Fake field, exist only in values array */
        a EF0;

        static {
            a aVar = new a("NONE", 0);
            a aVar2 = new a("LEFT", 1);
            f1214a = aVar2;
            a aVar3 = new a("TOP", 2);
            f1215b = aVar3;
            a aVar4 = new a("RIGHT", 3);
            f1216c = aVar4;
            a aVar5 = new a("BOTTOM", 4);
            f1217d = aVar5;
            a aVar6 = new a("BASELINE", 5);
            f1218e = aVar6;
            a aVar7 = new a("CENTER", 6);
            f1219f = aVar7;
            a aVar8 = new a("CENTER_X", 7);
            f1220g = aVar8;
            a aVar9 = new a("CENTER_Y", 8);
            f1221h = aVar9;
            f1222i = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f1222i.clone();
        }
    }

    public e(g gVar, a aVar) {
        this.f1208d = gVar;
        this.f1209e = aVar;
    }

    public final void a(e eVar, int i9) {
        b(eVar, i9, -1, false);
    }

    public final boolean b(e eVar, int i9, int i10, boolean z8) {
        if (eVar == null) {
            j();
            return true;
        }
        if (!z8 && !i(eVar)) {
            return false;
        }
        this.f1210f = eVar;
        if (eVar.f1205a == null) {
            eVar.f1205a = new HashSet<>();
        }
        HashSet<e> hashSet = this.f1210f.f1205a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        if (i9 > 0) {
            this.f1211g = i9;
        } else {
            this.f1211g = 0;
        }
        this.f1212h = i10;
        return true;
    }

    public final void c(int i9, o oVar, ArrayList arrayList) {
        HashSet<e> hashSet = this.f1205a;
        if (hashSet != null) {
            Iterator<e> it = hashSet.iterator();
            while (it.hasNext()) {
                B.i.a(it.next().f1208d, i9, arrayList, oVar);
            }
        }
    }

    public final int d() {
        if (this.f1207c) {
            return this.f1206b;
        }
        return 0;
    }

    public final int e() {
        e eVar;
        if (this.f1208d.f1253c0 == 8) {
            return 0;
        }
        int i9 = this.f1212h;
        return (i9 <= -1 || (eVar = this.f1210f) == null || eVar.f1208d.f1253c0 != 8) ? this.f1211g : i9;
    }

    public final e f() {
        a aVar = this.f1209e;
        int iOrdinal = aVar.ordinal();
        g gVar = this.f1208d;
        switch (iOrdinal) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return gVar.f1229F;
            case 2:
                return gVar.f1230G;
            case 3:
                return gVar.f1227D;
            case 4:
                return gVar.f1228E;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public final boolean g() {
        HashSet<e> hashSet = this.f1205a;
        if (hashSet == null) {
            return false;
        }
        Iterator<e> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f1210f != null;
    }

    public final boolean i(e eVar) {
        if (eVar == null) {
            return false;
        }
        a aVar = a.f1218e;
        a aVar2 = this.f1209e;
        g gVar = eVar.f1208d;
        a aVar3 = eVar.f1209e;
        if (aVar3 == aVar2) {
            return aVar2 != aVar || (gVar.f1281y && this.f1208d.f1281y);
        }
        int iOrdinal = aVar2.ordinal();
        a aVar4 = a.f1220g;
        a aVar5 = a.f1221h;
        switch (iOrdinal) {
            case 0:
            case 5:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z8 = aVar3 == a.f1214a || aVar3 == a.f1216c;
                if (gVar instanceof j) {
                    return z8 || aVar3 == aVar4;
                }
                return z8;
            case 2:
            case 4:
                boolean z9 = aVar3 == a.f1215b || aVar3 == a.f1217d;
                if (gVar instanceof j) {
                    return z9 || aVar3 == aVar5;
                }
                return z9;
            case 6:
                return (aVar3 == aVar || aVar3 == aVar4 || aVar3 == aVar5) ? false : true;
            default:
                throw new AssertionError(aVar2.name());
        }
    }

    public final void j() {
        HashSet<e> hashSet;
        e eVar = this.f1210f;
        if (eVar != null && (hashSet = eVar.f1205a) != null) {
            hashSet.remove(this);
            if (this.f1210f.f1205a.size() == 0) {
                this.f1210f.f1205a = null;
            }
        }
        this.f1205a = null;
        this.f1210f = null;
        this.f1211g = 0;
        this.f1212h = -1;
        this.f1207c = false;
        this.f1206b = 0;
    }

    public final void k() {
        p197z.e eVar = this.f1213i;
        if (eVar == null) {
            this.f1213i = new p197z.e(z.e.a.f22458a);
        } else {
            eVar.c();
        }
    }

    public final void l(int i9) {
        this.f1206b = i9;
        this.f1207c = true;
    }

    public final String toString() {
        return this.f1208d.f1255d0 + Constants.COLON_SEPARATOR + this.f1209e.toString();
    }
}
