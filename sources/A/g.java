package A;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ConstraintWidget.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final e f1227D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final e f1228E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final e f1229F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final e f1230G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final e f1231H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final e f1232I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final e f1233J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final e f1234K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final e[] f1235L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final ArrayList<e> f1236M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final boolean[] f1237N;
    public final a[] O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public g f1238P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f1239Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f1240R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public float f1241S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f1242T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public int f1243U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public int f1244V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public int f1245W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public int f1246X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public int f1247Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public float f1248Z;
    public float a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public B.c f1250b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public View f1251b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public B.c f1252c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f1253c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public String f1255d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f1257e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f1259f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final float[] f1261g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final g[] f1263h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final g[] f1265i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f1266j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f1268k0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1282z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1249a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public B.l f1254d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public B.n f1256e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f1258f = {true, true};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1260g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1262h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1264i = false;
    public int j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1267k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1269l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1270m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f1271n = new int[2];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1272o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1273p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f1274q = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1275r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1276s = 0;
    public float t = 1.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1277u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f1278v = 1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int[] f1279w = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f1280x = 0.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1281y = false;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f1224A = false;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f1225B = 0;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f1226C = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ConstraintWidget.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f1285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f1286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f1287e;

        static {
            a aVar = new a("FIXED", 0);
            f1283a = aVar;
            a aVar2 = new a("WRAP_CONTENT", 1);
            f1284b = aVar2;
            a aVar3 = new a("MATCH_CONSTRAINT", 2);
            f1285c = aVar3;
            a aVar4 = new a("MATCH_PARENT", 3);
            f1286d = aVar4;
            f1287e = new a[]{aVar, aVar2, aVar3, aVar4};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f1287e.clone();
        }
    }

    public g() {
        e eVar = new e(this, e.a.f1214a);
        this.f1227D = eVar;
        e eVar2 = new e(this, e.a.f1215b);
        this.f1228E = eVar2;
        e eVar3 = new e(this, e.a.f1216c);
        this.f1229F = eVar3;
        e eVar4 = new e(this, e.a.f1217d);
        this.f1230G = eVar4;
        e eVar5 = new e(this, e.a.f1218e);
        this.f1231H = eVar5;
        e eVar6 = new e(this, e.a.f1220g);
        this.f1232I = eVar6;
        e eVar7 = new e(this, e.a.f1221h);
        this.f1233J = eVar7;
        e eVar8 = new e(this, e.a.f1219f);
        this.f1234K = eVar8;
        this.f1235L = new e[]{eVar, eVar3, eVar2, eVar4, eVar5, eVar8};
        ArrayList<e> arrayList = new ArrayList<>();
        this.f1236M = arrayList;
        this.f1237N = new boolean[2];
        a aVar = a.f1283a;
        this.O = new a[]{aVar, aVar};
        this.f1238P = null;
        this.f1239Q = 0;
        this.f1240R = 0;
        this.f1241S = 0.0f;
        this.f1242T = -1;
        this.f1243U = 0;
        this.f1244V = 0;
        this.f1245W = 0;
        this.f1248Z = 0.5f;
        this.a0 = 0.5f;
        this.f1253c0 = 0;
        this.f1255d0 = null;
        this.f1257e0 = 0;
        this.f1259f0 = 0;
        this.f1261g0 = new float[]{-1.0f, -1.0f};
        this.f1263h0 = new g[]{null, null};
        this.f1265i0 = new g[]{null, null};
        this.f1266j0 = -1;
        this.f1268k0 = -1;
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        arrayList.add(eVar8);
        arrayList.add(eVar5);
    }

    public void A(p049g6.f fVar) {
        this.f1227D.k();
        this.f1228E.k();
        this.f1229F.k();
        this.f1230G.k();
        this.f1231H.k();
        this.f1234K.k();
        this.f1232I.k();
        this.f1233J.k();
    }

    public final void B(int i9) {
        this.f1245W = i9;
        this.f1281y = i9 > 0;
    }

    public final void C(int i9, int i10) {
        this.f1227D.l(i9);
        this.f1229F.l(i10);
        this.f1243U = i9;
        this.f1239Q = i10 - i9;
        this.f1262h = true;
    }

    public final void D(int i9, int i10) {
        this.f1228E.l(i9);
        this.f1230G.l(i10);
        this.f1244V = i9;
        this.f1240R = i10 - i9;
        if (this.f1281y) {
            this.f1231H.l(i9 + this.f1245W);
        }
        this.f1264i = true;
    }

    public final void E(int i9) {
        this.f1240R = i9;
        int i10 = this.f1247Y;
        if (i9 < i10) {
            this.f1240R = i10;
        }
    }

    public final void F(a aVar) {
        this.O[0] = aVar;
    }

    public final void G(a aVar) {
        this.O[1] = aVar;
    }

    public final void H(int i9) {
        this.f1239Q = i9;
        int i10 = this.f1246X;
        if (i9 < i10) {
            this.f1239Q = i10;
        }
    }

    public void I(boolean z8, boolean z9) {
        int i9;
        int i10;
        B.l lVar = this.f1254d;
        boolean z10 = z8 & lVar.f1592g;
        B.n nVar = this.f1256e;
        boolean z11 = z9 & nVar.f1592g;
        int i11 = lVar.f1593h.f1559g;
        int i12 = nVar.f1593h.f1559g;
        int i13 = lVar.f1594i.f1559g;
        int i14 = nVar.f1594i.f1559g;
        int i15 = i14 - i12;
        if (i13 - i11 < 0 || i15 < 0 || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE) {
            i13 = 0;
            i14 = 0;
            i11 = 0;
            i12 = 0;
        }
        int i16 = i13 - i11;
        int i17 = i14 - i12;
        if (z10) {
            this.f1243U = i11;
        }
        if (z11) {
            this.f1244V = i12;
        }
        if (this.f1253c0 == 8) {
            this.f1239Q = 0;
            this.f1240R = 0;
            return;
        }
        a aVar = a.f1283a;
        a[] aVarArr = this.O;
        if (z10) {
            if (aVarArr[0] == aVar && i16 < (i10 = this.f1239Q)) {
                i16 = i10;
            }
            this.f1239Q = i16;
            int i18 = this.f1246X;
            if (i16 < i18) {
                this.f1239Q = i18;
            }
        }
        if (z11) {
            if (aVarArr[1] == aVar && i17 < (i9 = this.f1240R)) {
                i17 = i9;
            }
            this.f1240R = i17;
            int i19 = this.f1247Y;
            if (i17 < i19) {
                this.f1240R = i19;
            }
        }
    }

    public void J(p197z.c cVar, boolean z8) {
        int i9;
        int i10;
        B.n nVar;
        B.l lVar;
        e eVar = this.f1227D;
        cVar.getClass();
        int iN = p197z.c.n(eVar);
        int iN2 = p197z.c.n(this.f1228E);
        int iN3 = p197z.c.n(this.f1229F);
        int iN4 = p197z.c.n(this.f1230G);
        if (z8 && (lVar = this.f1254d) != null) {
            B.f fVar = lVar.f1593h;
            if (fVar.j) {
                B.f fVar2 = lVar.f1594i;
                if (fVar2.j) {
                    iN = fVar.f1559g;
                    iN3 = fVar2.f1559g;
                }
            }
        }
        if (z8 && (nVar = this.f1256e) != null) {
            B.f fVar3 = nVar.f1593h;
            if (fVar3.j) {
                B.f fVar4 = nVar.f1594i;
                if (fVar4.j) {
                    iN2 = fVar3.f1559g;
                    iN4 = fVar4.f1559g;
                }
            }
        }
        int i11 = iN4 - iN2;
        if (iN3 - iN < 0 || i11 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i12 = iN3 - iN;
        int i13 = iN4 - iN2;
        this.f1243U = iN;
        this.f1244V = iN2;
        if (this.f1253c0 == 8) {
            this.f1239Q = 0;
            this.f1240R = 0;
            return;
        }
        a[] aVarArr = this.O;
        a aVar = aVarArr[0];
        a aVar2 = a.f1283a;
        if (aVar == aVar2 && i12 < (i10 = this.f1239Q)) {
            i12 = i10;
        }
        if (aVarArr[1] == aVar2 && i13 < (i9 = this.f1240R)) {
            i13 = i9;
        }
        this.f1239Q = i12;
        this.f1240R = i13;
        int i14 = this.f1247Y;
        if (i13 < i14) {
            this.f1240R = i14;
        }
        int i15 = this.f1246X;
        if (i12 < i15) {
            this.f1239Q = i15;
        }
    }

    public final void a(h hVar, p197z.c cVar, HashSet<g> hashSet, int i9, boolean z8) {
        if (z8) {
            if (!hashSet.contains(this)) {
                return;
            }
            l.a(hVar, cVar, this);
            hashSet.remove(this);
            b(cVar, hVar.Q(64));
        }
        if (i9 == 0) {
            HashSet<e> hashSet2 = this.f1227D.f1205a;
            if (hashSet2 != null) {
                Iterator<e> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().f1208d.a(hVar, cVar, hashSet, i9, true);
                }
            }
            HashSet<e> hashSet3 = this.f1229F.f1205a;
            if (hashSet3 != null) {
                Iterator<e> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().f1208d.a(hVar, cVar, hashSet, i9, true);
                }
                return;
            }
            return;
        }
        HashSet<e> hashSet4 = this.f1228E.f1205a;
        if (hashSet4 != null) {
            Iterator<e> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().f1208d.a(hVar, cVar, hashSet, i9, true);
            }
        }
        HashSet<e> hashSet5 = this.f1230G.f1205a;
        if (hashSet5 != null) {
            Iterator<e> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().f1208d.a(hVar, cVar, hashSet, i9, true);
            }
        }
        HashSet<e> hashSet6 = this.f1231H.f1205a;
        if (hashSet6 != null) {
            Iterator<e> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().f1208d.a(hVar, cVar, hashSet, i9, true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:244:0x0399  */
    /* JADX WARN: Code duplicated, block: B:246:0x039e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:248:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:251:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:256:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:259:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:262:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:264:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:267:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:303:0x04d7  */
    /* JADX WARN: Code duplicated, block: B:305:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:321:0x0541  */
    /* JADX WARN: Code duplicated, block: B:324:0x0553  */
    /* JADX WARN: Code duplicated, block: B:325:0x0555  */
    /* JADX WARN: Code duplicated, block: B:327:0x0558  */
    /* JADX WARN: Code duplicated, block: B:364:0x060c  */
    /* JADX WARN: Code duplicated, block: B:366:0x0612  */
    /* JADX WARN: Code duplicated, block: B:368:0x0619  */
    /* JADX WARN: Code duplicated, block: B:369:0x0642  */
    /* JADX WARN: Code duplicated, block: B:372:0x0670  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r20v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r60v0, types: [A.g] */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v18 */
    public void b(p197z.c cVar, boolean z8) {
        char c5;
        boolean z9;
        boolean z10;
        int i9;
        boolean z11;
        g gVar;
        g gVar2;
        e eVar;
        e eVar2;
        boolean zU;
        ?? r19;
        e eVar3;
        p197z.e eVar4;
        int i10;
        int i11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        boolean z14;
        e eVar5;
        int i14;
        e eVar6;
        a[] aVarArr;
        boolean z15;
        p197z.e eVar7;
        p197z.e eVar8;
        p197z.e eVar9;
        int i15;
        int i16;
        char c9;
        int i17;
        int i18;
        p197z.e eVar10;
        ?? r27;
        B.n nVar;
        e eVar11;
        B.l lVar;
        int i19;
        int i20;
        char c10;
        ?? T8;
        B.l lVar2;
        B.n nVar2;
        boolean z16;
        p197z.c cVar2 = cVar;
        e eVar12 = this.f1227D;
        p197z.e eVarK = cVar2.k(eVar12);
        e eVar13 = this.f1229F;
        p197z.e eVarK2 = cVar2.k(eVar13);
        e eVar14 = this.f1228E;
        p197z.e eVarK3 = cVar2.k(eVar14);
        e eVar15 = this.f1230G;
        p197z.e eVarK4 = cVar2.k(eVar15);
        e eVar16 = this.f1231H;
        p197z.e eVarK5 = cVar2.k(eVar16);
        g gVar3 = this.f1238P;
        a aVar = a.f1284b;
        if (gVar3 != null) {
            a[] aVarArr2 = gVar3.O;
            c5 = 1;
            z10 = aVarArr2[0] == aVar;
            z9 = aVarArr2[1] == aVar;
            i9 = 0;
        } else {
            c5 = 1;
            z9 = false;
            z10 = false;
            i9 = 0;
        }
        int i21 = this.f1253c0;
        boolean z17 = z9;
        boolean[] zArr = this.f1237N;
        if (i21 == 8) {
            ArrayList<e> arrayList = this.f1236M;
            int size = arrayList.size();
            z11 = z10;
            int i22 = i9;
            while (true) {
                if (i22 >= size) {
                    if (zArr[i9] || zArr[c5]) {
                        break;
                        break;
                    }
                    return;
                }
                int i23 = size;
                HashSet<e> hashSet = arrayList.get(i22).f1205a;
                if (hashSet != null && hashSet.size() > 0) {
                    break;
                }
                i22++;
                size = i23;
            }
        } else {
            z11 = z10;
        }
        boolean z18 = this.f1262h;
        if (z18 || this.f1264i) {
            if (z18) {
                cVar2.d(eVarK, this.f1243U);
                cVar2.d(eVarK2, this.f1243U + this.f1239Q);
                if (z11 && (gVar2 = this.f1238P) != null) {
                    h hVar = (h) gVar2;
                    hVar.N(eVar12);
                    WeakReference<e> weakReference = hVar.f1291D0;
                    if (weakReference == null || weakReference.get() == null || eVar13.d() > hVar.f1291D0.get().d()) {
                        hVar.f1291D0 = new WeakReference<>(eVar13);
                    }
                }
            }
            if (this.f1264i) {
                cVar2.d(eVarK3, this.f1244V);
                cVar2.d(eVarK4, this.f1244V + this.f1240R);
                HashSet<e> hashSet2 = eVar16.f1205a;
                if (hashSet2 != null && hashSet2.size() > 0) {
                    cVar2.d(eVarK5, this.f1244V + this.f1245W);
                }
                if (z17 && (gVar = this.f1238P) != null) {
                    h hVar2 = (h) gVar;
                    hVar2.N(eVar14);
                    WeakReference<e> weakReference2 = hVar2.f1290C0;
                    if (weakReference2 == null || weakReference2.get() == null || eVar15.d() > hVar2.f1290C0.get().d()) {
                        hVar2.f1290C0 = new WeakReference<>(eVar15);
                    }
                }
            }
            if (this.f1262h && this.f1264i) {
                ?? r12 = i9;
                this.f1262h = r12;
                this.f1264i = r12;
                return;
            }
        }
        boolean[] zArr2 = this.f1258f;
        if (!z8 || (lVar2 = this.f1254d) == null || (nVar2 = this.f1256e) == null) {
            eVar = eVar14;
            eVar2 = eVar15;
        } else {
            eVar = eVar14;
            B.f fVar = lVar2.f1593h;
            eVar2 = eVar15;
            if (fVar.j && lVar2.f1594i.j && nVar2.f1593h.j && nVar2.f1594i.j) {
                cVar2.d(eVarK, fVar.f1559g);
                cVar2.d(eVarK2, this.f1254d.f1594i.f1559g);
                cVar2.d(eVarK3, this.f1256e.f1593h.f1559g);
                cVar2.d(eVarK4, this.f1256e.f1594i.f1559g);
                cVar2.d(eVarK5, this.f1256e.f1578k.f1559g);
                if (this.f1238P == null) {
                    z16 = false;
                } else {
                    if (z11 && zArr2[0] && !t()) {
                        cVar2.f(cVar2.k(this.f1238P.f1229F), eVarK2, 0, 8);
                    }
                    if (z17 && zArr2[c5] && !u()) {
                        z16 = false;
                        cVar2.f(cVar2.k(this.f1238P.f1230G), eVarK4, 0, 8);
                    } else {
                        z16 = false;
                    }
                }
                this.f1262h = z16;
                this.f1264i = z16;
                return;
            }
        }
        if (this.f1238P != null) {
            if (s(0)) {
                ((h) this.f1238P).L(this, 0);
                char c11 = c5;
                c10 = c11 == true ? 1 : 0;
                T8 = c11;
            } else {
                c10 = c5;
                T8 = t();
            }
            if (s(c10)) {
                ((h) this.f1238P).L(this, c10);
                zU = true;
            } else {
                zU = u();
            }
            if (T8 == 0 && z11 && this.f1253c0 != 8 && eVar12.f1210f == null && eVar13.f1210f == null) {
                cVar2.f(cVar2.k(this.f1238P.f1229F), eVarK2, 0, 1);
            }
            r19 = T8;
        } else {
            eVar12 = eVar12;
            zU = false;
            r19 = 0;
        }
        int i24 = this.f1239Q;
        int i25 = this.f1246X;
        if (i24 >= i25) {
            i25 = i24;
        }
        int i26 = this.f1240R;
        int i27 = this.f1247Y;
        int i28 = i26 < i27 ? i27 : i26;
        a[] aVarArr3 = this.O;
        a aVar2 = aVarArr3[0];
        a aVar3 = a.f1285c;
        boolean z19 = aVar2 != aVar3;
        a aVar4 = aVarArr3[1];
        boolean z20 = aVar4 != aVar3;
        boolean z21 = zU;
        int i29 = this.f1242T;
        this.f1277u = i29;
        float f6 = this.f1241S;
        this.f1278v = f6;
        int i30 = this.f1269l;
        int i31 = this.f1270m;
        if (f6 > 0.0f) {
            eVar3 = eVar16;
            if (this.f1253c0 != 8) {
                int i32 = (aVar2 == aVar3 && i30 == 0) ? 3 : i30;
                int i33 = (aVar4 == aVar3 && i31 == 0) ? 3 : i31;
                if (aVar2 == aVar3 && aVar4 == aVar3 && i32 == 3) {
                    eVar4 = eVarK5;
                    i20 = i33;
                    if (i20 == 3) {
                        if (i29 == -1) {
                            if (z19 && !z20) {
                                this.f1277u = 0;
                            } else if (!z19 && z20) {
                                this.f1277u = 1;
                                if (i29 == -1) {
                                    this.f1278v = 1.0f / f6;
                                }
                            }
                        }
                        if (this.f1277u == 0 && (!eVar.h() || !eVar2.h())) {
                            this.f1277u = 1;
                        } else if (this.f1277u == 1 && (!eVar12.h() || !eVar13.h())) {
                            this.f1277u = 0;
                        }
                        if (this.f1277u == -1 && (!eVar.h() || !eVar2.h() || !eVar12.h() || !eVar13.h())) {
                            if (eVar.h() && eVar2.h()) {
                                this.f1277u = 0;
                            } else if (eVar12.h() && eVar13.h()) {
                                this.f1278v = 1.0f / this.f1278v;
                                this.f1277u = 1;
                            }
                        }
                        if (this.f1277u == -1) {
                            int i34 = this.f1272o;
                            if (i34 > 0 && this.f1275r == 0) {
                                this.f1277u = 0;
                            } else if (i34 == 0 && this.f1275r > 0) {
                                this.f1278v = 1.0f / this.f1278v;
                                this.f1277u = 1;
                            }
                        }
                    }
                    i11 = i32;
                    i12 = i20;
                    i10 = i28;
                    z12 = true;
                    int[] iArr = this.f1271n;
                    iArr[0] = i11;
                    iArr[1] = i12;
                    if (z12) {
                        int i35 = this.f1277u;
                        i13 = -1;
                        boolean z22 = i35 != 0 || i35 == -1;
                        if (z12 || !((i19 = this.f1277u) == 1 || i19 == i13)) {
                            z13 = false;
                        } else {
                            z13 = true;
                        }
                        if (aVarArr3[0] == aVar || !(this instanceof h)) {
                            z14 = false;
                        } else {
                            z14 = true;
                        }
                        if (z14) {
                            i25 = 0;
                        }
                        eVar5 = this.f1234K;
                        boolean z23 = !eVar5.h();
                        boolean z24 = z11;
                        boolean z25 = zArr[0];
                        boolean z26 = zArr[1];
                        i14 = this.j;
                        int[] iArr2 = this.f1279w;
                        boolean z27 = z22;
                        if (i14 == 2 && !this.f1262h) {
                            if (z8 && (lVar = this.f1254d) != null) {
                                B.f fVar2 = lVar.f1593h;
                                eVar11 = eVar2;
                                if (fVar2.j && lVar.f1594i.j) {
                                    if (z8) {
                                        cVar2.d(eVarK, fVar2.f1559g);
                                        cVar2.d(eVarK2, this.f1254d.f1594i.f1559g);
                                        if (this.f1238P != null && z24 && zArr2[0] && !t()) {
                                            cVar2.f(cVar2.k(this.f1238P.f1229F), eVarK2, 0, 8);
                                        }
                                    }
                                    eVar6 = eVar11;
                                }
                                if (z8 || (nVar = this.f1256e) == null) {
                                    eVar7 = r30;
                                    eVar8 = r33;
                                    eVar9 = eVar4;
                                    i15 = 0;
                                    i16 = 8;
                                    c9 = 1;
                                    i17 = 1;
                                } else {
                                    B.f fVar3 = nVar.f1593h;
                                    if (fVar3.j && nVar.f1594i.j) {
                                        int i36 = fVar3.f1559g;
                                        eVar7 = eVarK3;
                                        cVar2.d(eVar7, i36);
                                        eVar8 = eVarK4;
                                        cVar2.d(eVar8, this.f1256e.f1594i.f1559g);
                                        eVar9 = eVar4;
                                        cVar2.d(eVar9, this.f1256e.f1578k.f1559g);
                                        g gVar4 = this.f1238P;
                                        if (gVar4 == null || z21 || z17 == 0) {
                                            i15 = 0;
                                            i16 = 8;
                                            c9 = 1;
                                        } else {
                                            c9 = 1;
                                            if (zArr2[1]) {
                                                i15 = 0;
                                                i16 = 8;
                                                cVar2.f(cVar2.k(gVar4.f1230G), eVar8, 0, 8);
                                            } else {
                                                i15 = 0;
                                                i16 = 8;
                                            }
                                        }
                                        i17 = i15;
                                    } else {
                                        eVar7 = r30;
                                        eVar8 = r33;
                                        eVar9 = eVar4;
                                        i15 = 0;
                                        i16 = 8;
                                        c9 = 1;
                                        i17 = 1;
                                    }
                                }
                                if (this.f1267k == 2) {
                                    i18 = i15;
                                } else {
                                    i18 = i17;
                                }
                                if (i18 != 0 || this.f1264i) {
                                    eVar10 = eVar7;
                                } else {
                                    ?? r9 = (aVarArr[c9] == aVar && (this instanceof h)) ? c9 : i15;
                                    int i37 = r9 != 0 ? i15 : i10;
                                    g gVar5 = this.f1238P;
                                    p197z.e eVarK6 = gVar5 != null ? cVar2.k(gVar5.f1230G) : null;
                                    g gVar6 = this.f1238P;
                                    p197z.e eVarK7 = gVar6 != null ? cVar2.k(gVar6.f1228E) : null;
                                    int i38 = this.f1245W;
                                    if (i38 > 0 || this.f1253c0 == i16) {
                                        r27 = z15;
                                        e eVar17 = eVar3;
                                        if (eVar17.f1210f != null) {
                                            cVar2.e(eVar9, eVar7, i38, i16);
                                            cVar2.e(eVar9, cVar2.k(eVar17.f1210f), i15, i16);
                                            if (z17 != 0) {
                                                cVar2.f(eVarK6, cVar2.k(eVar6), i15, 5);
                                            }
                                            r27 = i15;
                                        } else if (this.f1253c0 == i16) {
                                            cVar2.e(eVar9, eVar7, i15, i16);
                                            r27 = z15;
                                        } else {
                                            cVar2.e(eVar9, eVar7, i38, i16);
                                            r27 = z15;
                                        }
                                    }
                                    r27 = z15;
                                    int i39 = i15;
                                    eVar10 = eVar7;
                                    cVar2 = cVar;
                                    d(cVar2, false, z17, z24, zArr2[c9], eVarK7, eVarK6, aVarArr[c9], r9, this.f1228E, this.f1230G, this.f1244V, i37, this.f1247Y, iArr2[c9], this.a0, z13, aVarArr[i39] == aVar3 ? c9 : i39, z21, r19, z26, i12, i11, this.f1275r, this.f1276s, this.t, r27);
                                }
                                if (z12) {
                                    if (this.f1277u == 1) {
                                        float f9 = this.f1278v;
                                        p197z.b bVarL = cVar2.l();
                                        bVarL.f22423d.b(eVar8, -1.0f);
                                        bVarL.f22423d.b(eVar10, 1.0f);
                                        bVarL.f22423d.b(eVarK2, f9);
                                        bVarL.f22423d.b(eVarK, -f9);
                                        cVar2.c(bVarL);
                                    } else {
                                        float f10 = this.f1278v;
                                        p197z.b bVarL2 = cVar2.l();
                                        bVarL2.f22423d.b(eVarK2, -1.0f);
                                        bVarL2.f22423d.b(eVarK, 1.0f);
                                        bVarL2.f22423d.b(eVar8, f10);
                                        bVarL2.f22423d.b(eVar10, -f10);
                                        cVar2.c(bVarL2);
                                    }
                                }
                                if (eVar5.h()) {
                                    e eVar18 = eVar5;
                                    g gVar7 = eVar18.f1210f.f1208d;
                                    float radians = (float) Math.toRadians(this.f1280x + 90.0f);
                                    int iE = eVar18.e();
                                    e.a aVar5 = e.a.f1214a;
                                    p197z.e eVarK8 = cVar2.k(i(aVar5));
                                    e.a aVar6 = e.a.f1215b;
                                    p197z.e eVarK9 = cVar2.k(i(aVar6));
                                    e.a aVar7 = e.a.f1216c;
                                    p197z.e eVarK10 = cVar2.k(i(aVar7));
                                    e.a aVar8 = e.a.f1217d;
                                    p197z.e eVarK11 = cVar2.k(i(aVar8));
                                    p197z.e eVarK12 = cVar2.k(gVar7.i(aVar5));
                                    p197z.e eVarK13 = cVar2.k(gVar7.i(aVar6));
                                    p197z.e eVarK14 = cVar2.k(gVar7.i(aVar7));
                                    p197z.e eVarK15 = cVar2.k(gVar7.i(aVar8));
                                    p197z.b bVarL3 = cVar2.l();
                                    double d9 = radians;
                                    double dSin = Math.sin(d9);
                                    double d10 = iE;
                                    bVarL3.f22423d.b(eVarK13, 0.5f);
                                    bVarL3.f22423d.b(eVarK15, 0.5f);
                                    bVarL3.f22423d.b(eVarK9, -0.5f);
                                    bVarL3.f22423d.b(eVarK11, -0.5f);
                                    bVarL3.f22421b = -((float) (dSin * d10));
                                    cVar2.c(bVarL3);
                                    p197z.b bVarL4 = cVar2.l();
                                    float fCos = (float) (Math.cos(d9) * d10);
                                    bVarL4.f22423d.b(eVarK12, 0.5f);
                                    bVarL4.f22423d.b(eVarK14, 0.5f);
                                    bVarL4.f22423d.b(eVarK8, -0.5f);
                                    bVarL4.f22423d.b(eVarK10, -0.5f);
                                    bVarL4.f22421b = -fCos;
                                    cVar2.c(bVarL4);
                                }
                                this.f1262h = false;
                                this.f1264i = false;
                            }
                            eVar11 = eVar2;
                            g gVar8 = this.f1238P;
                            p197z.e eVarK16 = gVar8 != null ? cVar2.k(gVar8.f1229F) : null;
                            g gVar9 = this.f1238P;
                            p197z.e eVarK17 = gVar9 != null ? cVar2.k(gVar9.f1227D) : null;
                            aVarArr = aVarArr3;
                            boolean z28 = z23;
                            zArr2 = zArr2;
                            z24 = z24;
                            iArr2 = iArr2;
                            eVar5 = eVar5;
                            eVarK2 = eVarK2;
                            eVar6 = eVar11;
                            aVar = aVar;
                            eVarK = eVarK;
                            aVar3 = aVar3;
                            cVar2 = cVar;
                            d(cVar2, true, z24, z17, zArr2[0], eVarK17, eVarK16, aVarArr[0], z14, this.f1227D, this.f1229F, this.f1243U, i25, this.f1246X, iArr2[0], this.f1248Z, z27, aVarArr[1] == aVar3, r19, z21, z25, i11, i12, this.f1272o, this.f1273p, this.f1274q, z28);
                            z15 = z28;
                            if (z8) {
                                eVar7 = r30;
                                eVar8 = r33;
                                eVar9 = eVar4;
                                i15 = 0;
                                i16 = 8;
                                c9 = 1;
                                i17 = 1;
                            } else {
                                eVar7 = r30;
                                eVar8 = r33;
                                eVar9 = eVar4;
                                i15 = 0;
                                i16 = 8;
                                c9 = 1;
                                i17 = 1;
                            }
                            if (this.f1267k == 2) {
                                i18 = i15;
                            } else {
                                i18 = i17;
                            }
                            if (i18 != 0) {
                                eVar10 = eVar7;
                            } else {
                                eVar10 = eVar7;
                            }
                            if (z12) {
                                if (this.f1277u == 1) {
                                    float f11 = this.f1278v;
                                    p197z.b bVarL5 = cVar2.l();
                                    bVarL5.f22423d.b(eVar8, -1.0f);
                                    bVarL5.f22423d.b(eVar10, 1.0f);
                                    bVarL5.f22423d.b(eVarK2, f11);
                                    bVarL5.f22423d.b(eVarK, -f11);
                                    cVar2.c(bVarL5);
                                } else {
                                    float f12 = this.f1278v;
                                    p197z.b bVarL6 = cVar2.l();
                                    bVarL6.f22423d.b(eVarK2, -1.0f);
                                    bVarL6.f22423d.b(eVarK, 1.0f);
                                    bVarL6.f22423d.b(eVar8, f12);
                                    bVarL6.f22423d.b(eVar10, -f12);
                                    cVar2.c(bVarL6);
                                }
                            }
                            if (eVar5.h()) {
                                e eVar19 = eVar5;
                                g gVar10 = eVar19.f1210f.f1208d;
                                float radians2 = (float) Math.toRadians(this.f1280x + 90.0f);
                                int iE2 = eVar19.e();
                                e.a aVar9 = e.a.f1214a;
                                p197z.e eVarK18 = cVar2.k(i(aVar9));
                                e.a aVar10 = e.a.f1215b;
                                p197z.e eVarK19 = cVar2.k(i(aVar10));
                                e.a aVar11 = e.a.f1216c;
                                p197z.e eVarK110 = cVar2.k(i(aVar11));
                                e.a aVar12 = e.a.f1217d;
                                p197z.e eVarK111 = cVar2.k(i(aVar12));
                                p197z.e eVarK112 = cVar2.k(gVar10.i(aVar9));
                                p197z.e eVarK113 = cVar2.k(gVar10.i(aVar10));
                                p197z.e eVarK114 = cVar2.k(gVar10.i(aVar11));
                                p197z.e eVarK115 = cVar2.k(gVar10.i(aVar12));
                                p197z.b bVarL7 = cVar2.l();
                                double d11 = radians2;
                                double dSin2 = Math.sin(d11);
                                double d12 = iE2;
                                bVarL7.f22423d.b(eVarK113, 0.5f);
                                bVarL7.f22423d.b(eVarK115, 0.5f);
                                bVarL7.f22423d.b(eVarK19, -0.5f);
                                bVarL7.f22423d.b(eVarK111, -0.5f);
                                bVarL7.f22421b = -((float) (dSin2 * d12));
                                cVar2.c(bVarL7);
                                p197z.b bVarL8 = cVar2.l();
                                float fCos2 = (float) (Math.cos(d11) * d12);
                                bVarL8.f22423d.b(eVarK112, 0.5f);
                                bVarL8.f22423d.b(eVarK114, 0.5f);
                                bVarL8.f22423d.b(eVarK18, -0.5f);
                                bVarL8.f22423d.b(eVarK110, -0.5f);
                                bVarL8.f22421b = -fCos2;
                                cVar2.c(bVarL8);
                            }
                            this.f1262h = false;
                            this.f1264i = false;
                        }
                        eVar6 = eVar2;
                        aVarArr = aVarArr3;
                        z15 = z23;
                        if (z8) {
                            eVar7 = r30;
                            eVar8 = r33;
                            eVar9 = eVar4;
                            i15 = 0;
                            i16 = 8;
                            c9 = 1;
                            i17 = 1;
                        } else {
                            eVar7 = r30;
                            eVar8 = r33;
                            eVar9 = eVar4;
                            i15 = 0;
                            i16 = 8;
                            c9 = 1;
                            i17 = 1;
                        }
                        if (this.f1267k == 2) {
                            i18 = i15;
                        } else {
                            i18 = i17;
                        }
                        if (i18 != 0) {
                            eVar10 = eVar7;
                        } else {
                            eVar10 = eVar7;
                        }
                        if (z12) {
                            if (this.f1277u == 1) {
                                float f13 = this.f1278v;
                                p197z.b bVarL9 = cVar2.l();
                                bVarL9.f22423d.b(eVar8, -1.0f);
                                bVarL9.f22423d.b(eVar10, 1.0f);
                                bVarL9.f22423d.b(eVarK2, f13);
                                bVarL9.f22423d.b(eVarK, -f13);
                                cVar2.c(bVarL9);
                            } else {
                                float f14 = this.f1278v;
                                p197z.b bVarL10 = cVar2.l();
                                bVarL10.f22423d.b(eVarK2, -1.0f);
                                bVarL10.f22423d.b(eVarK, 1.0f);
                                bVarL10.f22423d.b(eVar8, f14);
                                bVarL10.f22423d.b(eVar10, -f14);
                                cVar2.c(bVarL10);
                            }
                        }
                        if (eVar5.h()) {
                            e eVar110 = eVar5;
                            g gVar11 = eVar110.f1210f.f1208d;
                            float radians3 = (float) Math.toRadians(this.f1280x + 90.0f);
                            int iE3 = eVar110.e();
                            e.a aVar13 = e.a.f1214a;
                            p197z.e eVarK116 = cVar2.k(i(aVar13));
                            e.a aVar14 = e.a.f1215b;
                            p197z.e eVarK117 = cVar2.k(i(aVar14));
                            e.a aVar15 = e.a.f1216c;
                            p197z.e eVarK118 = cVar2.k(i(aVar15));
                            e.a aVar16 = e.a.f1217d;
                            p197z.e eVarK119 = cVar2.k(i(aVar16));
                            p197z.e eVarK1110 = cVar2.k(gVar11.i(aVar13));
                            p197z.e eVarK1111 = cVar2.k(gVar11.i(aVar14));
                            p197z.e eVarK1112 = cVar2.k(gVar11.i(aVar15));
                            p197z.e eVarK1113 = cVar2.k(gVar11.i(aVar16));
                            p197z.b bVarL11 = cVar2.l();
                            double d13 = radians3;
                            double dSin3 = Math.sin(d13);
                            double d14 = iE3;
                            bVarL11.f22423d.b(eVarK1111, 0.5f);
                            bVarL11.f22423d.b(eVarK1113, 0.5f);
                            bVarL11.f22423d.b(eVarK117, -0.5f);
                            bVarL11.f22423d.b(eVarK119, -0.5f);
                            bVarL11.f22421b = -((float) (dSin3 * d14));
                            cVar2.c(bVarL11);
                            p197z.b bVarL12 = cVar2.l();
                            float fCos3 = (float) (Math.cos(d13) * d14);
                            bVarL12.f22423d.b(eVarK1110, 0.5f);
                            bVarL12.f22423d.b(eVarK1112, 0.5f);
                            bVarL12.f22423d.b(eVarK116, -0.5f);
                            bVarL12.f22423d.b(eVarK118, -0.5f);
                            bVarL12.f22421b = -fCos3;
                            cVar2.c(bVarL12);
                        }
                        this.f1262h = false;
                        this.f1264i = false;
                    }
                    i13 = -1;
                    if (z12) {
                        z13 = false;
                    } else {
                        z13 = false;
                    }
                    if (aVarArr3[0] == aVar) {
                        z14 = false;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        i25 = 0;
                    }
                    eVar5 = this.f1234K;
                    boolean z29 = !eVar5.h();
                    boolean z210 = z11;
                    boolean z211 = zArr[0];
                    boolean z212 = zArr[1];
                    i14 = this.j;
                    int[] iArr3 = this.f1279w;
                    boolean z213 = z22;
                    if (i14 == 2) {
                        eVar6 = eVar2;
                        aVarArr = aVarArr3;
                        z15 = z29;
                    } else {
                        eVar6 = eVar2;
                        aVarArr = aVarArr3;
                        z15 = z29;
                    }
                    if (z8) {
                        eVar7 = r30;
                        eVar8 = r33;
                        eVar9 = eVar4;
                        i15 = 0;
                        i16 = 8;
                        c9 = 1;
                        i17 = 1;
                    } else {
                        eVar7 = r30;
                        eVar8 = r33;
                        eVar9 = eVar4;
                        i15 = 0;
                        i16 = 8;
                        c9 = 1;
                        i17 = 1;
                    }
                    if (this.f1267k == 2) {
                        i18 = i15;
                    } else {
                        i18 = i17;
                    }
                    if (i18 != 0) {
                        eVar10 = eVar7;
                    } else {
                        eVar10 = eVar7;
                    }
                    if (z12) {
                        if (this.f1277u == 1) {
                            float f15 = this.f1278v;
                            p197z.b bVarL13 = cVar2.l();
                            bVarL13.f22423d.b(eVar8, -1.0f);
                            bVarL13.f22423d.b(eVar10, 1.0f);
                            bVarL13.f22423d.b(eVarK2, f15);
                            bVarL13.f22423d.b(eVarK, -f15);
                            cVar2.c(bVarL13);
                        } else {
                            float f16 = this.f1278v;
                            p197z.b bVarL14 = cVar2.l();
                            bVarL14.f22423d.b(eVarK2, -1.0f);
                            bVarL14.f22423d.b(eVarK, 1.0f);
                            bVarL14.f22423d.b(eVar8, f16);
                            bVarL14.f22423d.b(eVar10, -f16);
                            cVar2.c(bVarL14);
                        }
                    }
                    if (eVar5.h()) {
                        e eVar111 = eVar5;
                        g gVar12 = eVar111.f1210f.f1208d;
                        float radians4 = (float) Math.toRadians(this.f1280x + 90.0f);
                        int iE4 = eVar111.e();
                        e.a aVar17 = e.a.f1214a;
                        p197z.e eVarK1114 = cVar2.k(i(aVar17));
                        e.a aVar18 = e.a.f1215b;
                        p197z.e eVarK1115 = cVar2.k(i(aVar18));
                        e.a aVar19 = e.a.f1216c;
                        p197z.e eVarK1116 = cVar2.k(i(aVar19));
                        e.a aVar110 = e.a.f1217d;
                        p197z.e eVarK1117 = cVar2.k(i(aVar110));
                        p197z.e eVarK1118 = cVar2.k(gVar12.i(aVar17));
                        p197z.e eVarK1119 = cVar2.k(gVar12.i(aVar18));
                        p197z.e eVarK11110 = cVar2.k(gVar12.i(aVar19));
                        p197z.e eVarK11111 = cVar2.k(gVar12.i(aVar110));
                        p197z.b bVarL15 = cVar2.l();
                        double d15 = radians4;
                        double dSin4 = Math.sin(d15);
                        double d16 = iE4;
                        bVarL15.f22423d.b(eVarK1119, 0.5f);
                        bVarL15.f22423d.b(eVarK11111, 0.5f);
                        bVarL15.f22423d.b(eVarK1115, -0.5f);
                        bVarL15.f22423d.b(eVarK1117, -0.5f);
                        bVarL15.f22421b = -((float) (dSin4 * d16));
                        cVar2.c(bVarL15);
                        p197z.b bVarL16 = cVar2.l();
                        float fCos4 = (float) (Math.cos(d15) * d16);
                        bVarL16.f22423d.b(eVarK1118, 0.5f);
                        bVarL16.f22423d.b(eVarK11110, 0.5f);
                        bVarL16.f22423d.b(eVarK1114, -0.5f);
                        bVarL16.f22423d.b(eVarK1116, -0.5f);
                        bVarL16.f22421b = -fCos4;
                        cVar2.c(bVarL16);
                    }
                    this.f1262h = false;
                    this.f1264i = false;
                }
                eVar4 = eVarK5;
                i20 = i33;
                if (aVar2 == aVar3 && i32 == 3) {
                    this.f1277u = 0;
                    i25 = (int) (f6 * i26);
                    if (aVar4 != aVar3) {
                        i12 = i20;
                        i10 = i28;
                        i11 = 4;
                    }
                    i11 = i32;
                    i12 = i20;
                    i10 = i28;
                    z12 = true;
                } else {
                    if (aVar4 == aVar3 && i20 == 3) {
                        this.f1277u = 1;
                        if (i29 == -1) {
                            this.f1278v = 1.0f / f6;
                        }
                        i10 = (int) (this.f1278v * i24);
                        i11 = i32;
                        if (aVar2 != aVar3) {
                            i12 = 4;
                        } else {
                            i12 = i20;
                        }
                    } else {
                        i11 = i32;
                        i12 = i20;
                        i10 = i28;
                    }
                    z12 = true;
                }
                int[] iArr4 = this.f1271n;
                iArr4[0] = i11;
                iArr4[1] = i12;
                if (z12) {
                    int i310 = this.f1277u;
                    i13 = -1;
                    if (i310 != 0) {
                    }
                    if (z12) {
                        z13 = false;
                    } else {
                        z13 = false;
                    }
                    if (aVarArr3[0] == aVar) {
                        z14 = false;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        i25 = 0;
                    }
                    eVar5 = this.f1234K;
                    boolean z214 = !eVar5.h();
                    boolean z215 = z11;
                    boolean z216 = zArr[0];
                    boolean z217 = zArr[1];
                    i14 = this.j;
                    int[] iArr5 = this.f1279w;
                    boolean z218 = z22;
                    if (i14 == 2) {
                        eVar6 = eVar2;
                        aVarArr = aVarArr3;
                        z15 = z214;
                    } else {
                        eVar6 = eVar2;
                        aVarArr = aVarArr3;
                        z15 = z214;
                    }
                    if (z8) {
                        eVar7 = r30;
                        eVar8 = r33;
                        eVar9 = eVar4;
                        i15 = 0;
                        i16 = 8;
                        c9 = 1;
                        i17 = 1;
                    } else {
                        eVar7 = r30;
                        eVar8 = r33;
                        eVar9 = eVar4;
                        i15 = 0;
                        i16 = 8;
                        c9 = 1;
                        i17 = 1;
                    }
                    if (this.f1267k == 2) {
                        i18 = i15;
                    } else {
                        i18 = i17;
                    }
                    if (i18 != 0) {
                        eVar10 = eVar7;
                    } else {
                        eVar10 = eVar7;
                    }
                    if (z12) {
                        if (this.f1277u == 1) {
                            float f17 = this.f1278v;
                            p197z.b bVarL17 = cVar2.l();
                            bVarL17.f22423d.b(eVar8, -1.0f);
                            bVarL17.f22423d.b(eVar10, 1.0f);
                            bVarL17.f22423d.b(eVarK2, f17);
                            bVarL17.f22423d.b(eVarK, -f17);
                            cVar2.c(bVarL17);
                        } else {
                            float f18 = this.f1278v;
                            p197z.b bVarL18 = cVar2.l();
                            bVarL18.f22423d.b(eVarK2, -1.0f);
                            bVarL18.f22423d.b(eVarK, 1.0f);
                            bVarL18.f22423d.b(eVar8, f18);
                            bVarL18.f22423d.b(eVar10, -f18);
                            cVar2.c(bVarL18);
                        }
                    }
                    if (eVar5.h()) {
                        e eVar112 = eVar5;
                        g gVar13 = eVar112.f1210f.f1208d;
                        float radians5 = (float) Math.toRadians(this.f1280x + 90.0f);
                        int iE5 = eVar112.e();
                        e.a aVar111 = e.a.f1214a;
                        p197z.e eVarK11112 = cVar2.k(i(aVar111));
                        e.a aVar112 = e.a.f1215b;
                        p197z.e eVarK11113 = cVar2.k(i(aVar112));
                        e.a aVar113 = e.a.f1216c;
                        p197z.e eVarK11114 = cVar2.k(i(aVar113));
                        e.a aVar114 = e.a.f1217d;
                        p197z.e eVarK11115 = cVar2.k(i(aVar114));
                        p197z.e eVarK11116 = cVar2.k(gVar13.i(aVar111));
                        p197z.e eVarK11117 = cVar2.k(gVar13.i(aVar112));
                        p197z.e eVarK11118 = cVar2.k(gVar13.i(aVar113));
                        p197z.e eVarK11119 = cVar2.k(gVar13.i(aVar114));
                        p197z.b bVarL19 = cVar2.l();
                        double d17 = radians5;
                        double dSin5 = Math.sin(d17);
                        double d18 = iE5;
                        bVarL19.f22423d.b(eVarK11117, 0.5f);
                        bVarL19.f22423d.b(eVarK11119, 0.5f);
                        bVarL19.f22423d.b(eVarK11113, -0.5f);
                        bVarL19.f22423d.b(eVarK11115, -0.5f);
                        bVarL19.f22421b = -((float) (dSin5 * d18));
                        cVar2.c(bVarL19);
                        p197z.b bVarL110 = cVar2.l();
                        float fCos5 = (float) (Math.cos(d17) * d18);
                        bVarL110.f22423d.b(eVarK11116, 0.5f);
                        bVarL110.f22423d.b(eVarK11118, 0.5f);
                        bVarL110.f22423d.b(eVarK11112, -0.5f);
                        bVarL110.f22423d.b(eVarK11114, -0.5f);
                        bVarL110.f22421b = -fCos5;
                        cVar2.c(bVarL110);
                    }
                    this.f1262h = false;
                    this.f1264i = false;
                }
                i13 = -1;
                if (z12) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if (aVarArr3[0] == aVar) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                if (z14) {
                    i25 = 0;
                }
                eVar5 = this.f1234K;
                boolean z219 = !eVar5.h();
                boolean z2110 = z11;
                boolean z2111 = zArr[0];
                boolean z2112 = zArr[1];
                i14 = this.j;
                int[] iArr6 = this.f1279w;
                boolean z2113 = z22;
                if (i14 == 2) {
                    eVar6 = eVar2;
                    aVarArr = aVarArr3;
                    z15 = z219;
                } else {
                    eVar6 = eVar2;
                    aVarArr = aVarArr3;
                    z15 = z219;
                }
                if (z8) {
                    eVar7 = r30;
                    eVar8 = r33;
                    eVar9 = eVar4;
                    i15 = 0;
                    i16 = 8;
                    c9 = 1;
                    i17 = 1;
                } else {
                    eVar7 = r30;
                    eVar8 = r33;
                    eVar9 = eVar4;
                    i15 = 0;
                    i16 = 8;
                    c9 = 1;
                    i17 = 1;
                }
                if (this.f1267k == 2) {
                    i18 = i15;
                } else {
                    i18 = i17;
                }
                if (i18 != 0) {
                    eVar10 = eVar7;
                } else {
                    eVar10 = eVar7;
                }
                if (z12) {
                    if (this.f1277u == 1) {
                        float f19 = this.f1278v;
                        p197z.b bVarL111 = cVar2.l();
                        bVarL111.f22423d.b(eVar8, -1.0f);
                        bVarL111.f22423d.b(eVar10, 1.0f);
                        bVarL111.f22423d.b(eVarK2, f19);
                        bVarL111.f22423d.b(eVarK, -f19);
                        cVar2.c(bVarL111);
                    } else {
                        float f110 = this.f1278v;
                        p197z.b bVarL112 = cVar2.l();
                        bVarL112.f22423d.b(eVarK2, -1.0f);
                        bVarL112.f22423d.b(eVarK, 1.0f);
                        bVarL112.f22423d.b(eVar8, f110);
                        bVarL112.f22423d.b(eVar10, -f110);
                        cVar2.c(bVarL112);
                    }
                }
                if (eVar5.h()) {
                    e eVar113 = eVar5;
                    g gVar14 = eVar113.f1210f.f1208d;
                    float radians6 = (float) Math.toRadians(this.f1280x + 90.0f);
                    int iE6 = eVar113.e();
                    e.a aVar115 = e.a.f1214a;
                    p197z.e eVarK111110 = cVar2.k(i(aVar115));
                    e.a aVar116 = e.a.f1215b;
                    p197z.e eVarK111111 = cVar2.k(i(aVar116));
                    e.a aVar117 = e.a.f1216c;
                    p197z.e eVarK111112 = cVar2.k(i(aVar117));
                    e.a aVar118 = e.a.f1217d;
                    p197z.e eVarK111113 = cVar2.k(i(aVar118));
                    p197z.e eVarK111114 = cVar2.k(gVar14.i(aVar115));
                    p197z.e eVarK111115 = cVar2.k(gVar14.i(aVar116));
                    p197z.e eVarK111116 = cVar2.k(gVar14.i(aVar117));
                    p197z.e eVarK111117 = cVar2.k(gVar14.i(aVar118));
                    p197z.b bVarL113 = cVar2.l();
                    double d19 = radians6;
                    double dSin6 = Math.sin(d19);
                    double d110 = iE6;
                    bVarL113.f22423d.b(eVarK111115, 0.5f);
                    bVarL113.f22423d.b(eVarK111117, 0.5f);
                    bVarL113.f22423d.b(eVarK111111, -0.5f);
                    bVarL113.f22423d.b(eVarK111113, -0.5f);
                    bVarL113.f22421b = -((float) (dSin6 * d110));
                    cVar2.c(bVarL113);
                    p197z.b bVarL114 = cVar2.l();
                    float fCos6 = (float) (Math.cos(d19) * d110);
                    bVarL114.f22423d.b(eVarK111114, 0.5f);
                    bVarL114.f22423d.b(eVarK111116, 0.5f);
                    bVarL114.f22423d.b(eVarK111110, -0.5f);
                    bVarL114.f22423d.b(eVarK111112, -0.5f);
                    bVarL114.f22421b = -fCos6;
                    cVar2.c(bVarL114);
                }
                this.f1262h = false;
                this.f1264i = false;
            }
            z12 = false;
            int[] iArr7 = this.f1271n;
            iArr7[0] = i11;
            iArr7[1] = i12;
            if (z12) {
                int i311 = this.f1277u;
                i13 = -1;
                if (i311 != 0) {
                }
                if (z12) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if (aVarArr3[0] == aVar) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                if (z14) {
                    i25 = 0;
                }
                eVar5 = this.f1234K;
                boolean z2114 = !eVar5.h();
                boolean z2115 = z11;
                boolean z2116 = zArr[0];
                boolean z2117 = zArr[1];
                i14 = this.j;
                int[] iArr8 = this.f1279w;
                boolean z2118 = z22;
                if (i14 == 2) {
                    eVar6 = eVar2;
                    aVarArr = aVarArr3;
                    z15 = z2114;
                } else {
                    eVar6 = eVar2;
                    aVarArr = aVarArr3;
                    z15 = z2114;
                }
                if (z8) {
                    eVar7 = r30;
                    eVar8 = r33;
                    eVar9 = eVar4;
                    i15 = 0;
                    i16 = 8;
                    c9 = 1;
                    i17 = 1;
                } else {
                    eVar7 = r30;
                    eVar8 = r33;
                    eVar9 = eVar4;
                    i15 = 0;
                    i16 = 8;
                    c9 = 1;
                    i17 = 1;
                }
                if (this.f1267k == 2) {
                    i18 = i15;
                } else {
                    i18 = i17;
                }
                if (i18 != 0) {
                    eVar10 = eVar7;
                } else {
                    eVar10 = eVar7;
                }
                if (z12) {
                    if (this.f1277u == 1) {
                        float f111 = this.f1278v;
                        p197z.b bVarL115 = cVar2.l();
                        bVarL115.f22423d.b(eVar8, -1.0f);
                        bVarL115.f22423d.b(eVar10, 1.0f);
                        bVarL115.f22423d.b(eVarK2, f111);
                        bVarL115.f22423d.b(eVarK, -f111);
                        cVar2.c(bVarL115);
                    } else {
                        float f112 = this.f1278v;
                        p197z.b bVarL116 = cVar2.l();
                        bVarL116.f22423d.b(eVarK2, -1.0f);
                        bVarL116.f22423d.b(eVarK, 1.0f);
                        bVarL116.f22423d.b(eVar8, f112);
                        bVarL116.f22423d.b(eVar10, -f112);
                        cVar2.c(bVarL116);
                    }
                }
                if (eVar5.h()) {
                    e eVar114 = eVar5;
                    g gVar15 = eVar114.f1210f.f1208d;
                    float radians7 = (float) Math.toRadians(this.f1280x + 90.0f);
                    int iE7 = eVar114.e();
                    e.a aVar119 = e.a.f1214a;
                    p197z.e eVarK111118 = cVar2.k(i(aVar119));
                    e.a aVar1110 = e.a.f1215b;
                    p197z.e eVarK111119 = cVar2.k(i(aVar1110));
                    e.a aVar1111 = e.a.f1216c;
                    p197z.e eVarK1111110 = cVar2.k(i(aVar1111));
                    e.a aVar1112 = e.a.f1217d;
                    p197z.e eVarK1111111 = cVar2.k(i(aVar1112));
                    p197z.e eVarK1111112 = cVar2.k(gVar15.i(aVar119));
                    p197z.e eVarK1111113 = cVar2.k(gVar15.i(aVar1110));
                    p197z.e eVarK1111114 = cVar2.k(gVar15.i(aVar1111));
                    p197z.e eVarK1111115 = cVar2.k(gVar15.i(aVar1112));
                    p197z.b bVarL117 = cVar2.l();
                    double d111 = radians7;
                    double dSin7 = Math.sin(d111);
                    double d112 = iE7;
                    bVarL117.f22423d.b(eVarK1111113, 0.5f);
                    bVarL117.f22423d.b(eVarK1111115, 0.5f);
                    bVarL117.f22423d.b(eVarK111119, -0.5f);
                    bVarL117.f22423d.b(eVarK1111111, -0.5f);
                    bVarL117.f22421b = -((float) (dSin7 * d112));
                    cVar2.c(bVarL117);
                    p197z.b bVarL118 = cVar2.l();
                    float fCos7 = (float) (Math.cos(d111) * d112);
                    bVarL118.f22423d.b(eVarK1111112, 0.5f);
                    bVarL118.f22423d.b(eVarK1111114, 0.5f);
                    bVarL118.f22423d.b(eVarK111118, -0.5f);
                    bVarL118.f22423d.b(eVarK1111110, -0.5f);
                    bVarL118.f22421b = -fCos7;
                    cVar2.c(bVarL118);
                }
                this.f1262h = false;
                this.f1264i = false;
            }
            i13 = -1;
            if (z12) {
                z13 = false;
            } else {
                z13 = false;
            }
            if (aVarArr3[0] == aVar) {
                z14 = false;
            } else {
                z14 = false;
            }
            if (z14) {
                i25 = 0;
            }
            eVar5 = this.f1234K;
            boolean z2119 = !eVar5.h();
            boolean z21110 = z11;
            boolean z21111 = zArr[0];
            boolean z21112 = zArr[1];
            i14 = this.j;
            int[] iArr9 = this.f1279w;
            boolean z21113 = z22;
            if (i14 == 2) {
                eVar6 = eVar2;
                aVarArr = aVarArr3;
                z15 = z2119;
            } else {
                eVar6 = eVar2;
                aVarArr = aVarArr3;
                z15 = z2119;
            }
            if (z8) {
                eVar7 = r30;
                eVar8 = r33;
                eVar9 = eVar4;
                i15 = 0;
                i16 = 8;
                c9 = 1;
                i17 = 1;
            } else {
                eVar7 = r30;
                eVar8 = r33;
                eVar9 = eVar4;
                i15 = 0;
                i16 = 8;
                c9 = 1;
                i17 = 1;
            }
            if (this.f1267k == 2) {
                i18 = i15;
            } else {
                i18 = i17;
            }
            if (i18 != 0) {
                eVar10 = eVar7;
            } else {
                eVar10 = eVar7;
            }
            if (z12) {
                if (this.f1277u == 1) {
                    float f113 = this.f1278v;
                    p197z.b bVarL119 = cVar2.l();
                    bVarL119.f22423d.b(eVar8, -1.0f);
                    bVarL119.f22423d.b(eVar10, 1.0f);
                    bVarL119.f22423d.b(eVarK2, f113);
                    bVarL119.f22423d.b(eVarK, -f113);
                    cVar2.c(bVarL119);
                } else {
                    float f114 = this.f1278v;
                    p197z.b bVarL1110 = cVar2.l();
                    bVarL1110.f22423d.b(eVarK2, -1.0f);
                    bVarL1110.f22423d.b(eVarK, 1.0f);
                    bVarL1110.f22423d.b(eVar8, f114);
                    bVarL1110.f22423d.b(eVar10, -f114);
                    cVar2.c(bVarL1110);
                }
            }
            if (eVar5.h()) {
                e eVar115 = eVar5;
                g gVar16 = eVar115.f1210f.f1208d;
                float radians8 = (float) Math.toRadians(this.f1280x + 90.0f);
                int iE8 = eVar115.e();
                e.a aVar1113 = e.a.f1214a;
                p197z.e eVarK1111116 = cVar2.k(i(aVar1113));
                e.a aVar1114 = e.a.f1215b;
                p197z.e eVarK1111117 = cVar2.k(i(aVar1114));
                e.a aVar1115 = e.a.f1216c;
                p197z.e eVarK1111118 = cVar2.k(i(aVar1115));
                e.a aVar1116 = e.a.f1217d;
                p197z.e eVarK1111119 = cVar2.k(i(aVar1116));
                p197z.e eVarK11111110 = cVar2.k(gVar16.i(aVar1113));
                p197z.e eVarK11111111 = cVar2.k(gVar16.i(aVar1114));
                p197z.e eVarK11111112 = cVar2.k(gVar16.i(aVar1115));
                p197z.e eVarK11111113 = cVar2.k(gVar16.i(aVar1116));
                p197z.b bVarL1111 = cVar2.l();
                double d113 = radians8;
                double dSin8 = Math.sin(d113);
                double d114 = iE8;
                bVarL1111.f22423d.b(eVarK11111111, 0.5f);
                bVarL1111.f22423d.b(eVarK11111113, 0.5f);
                bVarL1111.f22423d.b(eVarK1111117, -0.5f);
                bVarL1111.f22423d.b(eVarK1111119, -0.5f);
                bVarL1111.f22421b = -((float) (dSin8 * d114));
                cVar2.c(bVarL1111);
                p197z.b bVarL1112 = cVar2.l();
                float fCos8 = (float) (Math.cos(d113) * d114);
                bVarL1112.f22423d.b(eVarK11111110, 0.5f);
                bVarL1112.f22423d.b(eVarK11111112, 0.5f);
                bVarL1112.f22423d.b(eVarK1111116, -0.5f);
                bVarL1112.f22423d.b(eVarK1111118, -0.5f);
                bVarL1112.f22421b = -fCos8;
                cVar2.c(bVarL1112);
            }
            this.f1262h = false;
            this.f1264i = false;
        }
        eVar3 = eVar16;
        eVar4 = eVarK5;
        i10 = i28;
        i11 = i30;
        i12 = i31;
        z12 = false;
        int[] iArr10 = this.f1271n;
        iArr10[0] = i11;
        iArr10[1] = i12;
        if (z12) {
            int i312 = this.f1277u;
            i13 = -1;
            if (i312 != 0) {
            }
            if (z12) {
                z13 = false;
            } else {
                z13 = false;
            }
            if (aVarArr3[0] == aVar) {
                z14 = false;
            } else {
                z14 = false;
            }
            if (z14) {
                i25 = 0;
            }
            eVar5 = this.f1234K;
            boolean z21114 = !eVar5.h();
            boolean z21115 = z11;
            boolean z21116 = zArr[0];
            boolean z21117 = zArr[1];
            i14 = this.j;
            int[] iArr11 = this.f1279w;
            boolean z21118 = z22;
            if (i14 == 2) {
                eVar6 = eVar2;
                aVarArr = aVarArr3;
                z15 = z21114;
            } else {
                eVar6 = eVar2;
                aVarArr = aVarArr3;
                z15 = z21114;
            }
            if (z8) {
                eVar7 = r30;
                eVar8 = r33;
                eVar9 = eVar4;
                i15 = 0;
                i16 = 8;
                c9 = 1;
                i17 = 1;
            } else {
                eVar7 = r30;
                eVar8 = r33;
                eVar9 = eVar4;
                i15 = 0;
                i16 = 8;
                c9 = 1;
                i17 = 1;
            }
            if (this.f1267k == 2) {
                i18 = i15;
            } else {
                i18 = i17;
            }
            if (i18 != 0) {
                eVar10 = eVar7;
            } else {
                eVar10 = eVar7;
            }
            if (z12) {
                if (this.f1277u == 1) {
                    float f115 = this.f1278v;
                    p197z.b bVarL1113 = cVar2.l();
                    bVarL1113.f22423d.b(eVar8, -1.0f);
                    bVarL1113.f22423d.b(eVar10, 1.0f);
                    bVarL1113.f22423d.b(eVarK2, f115);
                    bVarL1113.f22423d.b(eVarK, -f115);
                    cVar2.c(bVarL1113);
                } else {
                    float f116 = this.f1278v;
                    p197z.b bVarL1114 = cVar2.l();
                    bVarL1114.f22423d.b(eVarK2, -1.0f);
                    bVarL1114.f22423d.b(eVarK, 1.0f);
                    bVarL1114.f22423d.b(eVar8, f116);
                    bVarL1114.f22423d.b(eVar10, -f116);
                    cVar2.c(bVarL1114);
                }
            }
            if (eVar5.h()) {
                e eVar116 = eVar5;
                g gVar17 = eVar116.f1210f.f1208d;
                float radians9 = (float) Math.toRadians(this.f1280x + 90.0f);
                int iE9 = eVar116.e();
                e.a aVar1117 = e.a.f1214a;
                p197z.e eVarK11111114 = cVar2.k(i(aVar1117));
                e.a aVar1118 = e.a.f1215b;
                p197z.e eVarK11111115 = cVar2.k(i(aVar1118));
                e.a aVar1119 = e.a.f1216c;
                p197z.e eVarK11111116 = cVar2.k(i(aVar1119));
                e.a aVar11110 = e.a.f1217d;
                p197z.e eVarK11111117 = cVar2.k(i(aVar11110));
                p197z.e eVarK11111118 = cVar2.k(gVar17.i(aVar1117));
                p197z.e eVarK11111119 = cVar2.k(gVar17.i(aVar1118));
                p197z.e eVarK111111110 = cVar2.k(gVar17.i(aVar1119));
                p197z.e eVarK111111111 = cVar2.k(gVar17.i(aVar11110));
                p197z.b bVarL1115 = cVar2.l();
                double d115 = radians9;
                double dSin9 = Math.sin(d115);
                double d116 = iE9;
                bVarL1115.f22423d.b(eVarK11111119, 0.5f);
                bVarL1115.f22423d.b(eVarK111111111, 0.5f);
                bVarL1115.f22423d.b(eVarK11111115, -0.5f);
                bVarL1115.f22423d.b(eVarK11111117, -0.5f);
                bVarL1115.f22421b = -((float) (dSin9 * d116));
                cVar2.c(bVarL1115);
                p197z.b bVarL1116 = cVar2.l();
                float fCos9 = (float) (Math.cos(d115) * d116);
                bVarL1116.f22423d.b(eVarK11111118, 0.5f);
                bVarL1116.f22423d.b(eVarK111111110, 0.5f);
                bVarL1116.f22423d.b(eVarK11111114, -0.5f);
                bVarL1116.f22423d.b(eVarK11111116, -0.5f);
                bVarL1116.f22421b = -fCos9;
                cVar2.c(bVarL1116);
            }
            this.f1262h = false;
            this.f1264i = false;
        }
        i13 = -1;
        if (z12) {
            z13 = false;
        } else {
            z13 = false;
        }
        if (aVarArr3[0] == aVar) {
            z14 = false;
        } else {
            z14 = false;
        }
        if (z14) {
            i25 = 0;
        }
        eVar5 = this.f1234K;
        boolean z21119 = !eVar5.h();
        boolean z211110 = z11;
        boolean z211111 = zArr[0];
        boolean z211112 = zArr[1];
        i14 = this.j;
        int[] iArr12 = this.f1279w;
        boolean z211113 = z22;
        if (i14 == 2) {
            eVar6 = eVar2;
            aVarArr = aVarArr3;
            z15 = z21119;
        } else {
            eVar6 = eVar2;
            aVarArr = aVarArr3;
            z15 = z21119;
        }
        if (z8) {
            eVar7 = r30;
            eVar8 = r33;
            eVar9 = eVar4;
            i15 = 0;
            i16 = 8;
            c9 = 1;
            i17 = 1;
        } else {
            eVar7 = r30;
            eVar8 = r33;
            eVar9 = eVar4;
            i15 = 0;
            i16 = 8;
            c9 = 1;
            i17 = 1;
        }
        if (this.f1267k == 2) {
            i18 = i15;
        } else {
            i18 = i17;
        }
        if (i18 != 0) {
            eVar10 = eVar7;
        } else {
            eVar10 = eVar7;
        }
        if (z12) {
            if (this.f1277u == 1) {
                float f117 = this.f1278v;
                p197z.b bVarL1117 = cVar2.l();
                bVarL1117.f22423d.b(eVar8, -1.0f);
                bVarL1117.f22423d.b(eVar10, 1.0f);
                bVarL1117.f22423d.b(eVarK2, f117);
                bVarL1117.f22423d.b(eVarK, -f117);
                cVar2.c(bVarL1117);
            } else {
                float f118 = this.f1278v;
                p197z.b bVarL1118 = cVar2.l();
                bVarL1118.f22423d.b(eVarK2, -1.0f);
                bVarL1118.f22423d.b(eVarK, 1.0f);
                bVarL1118.f22423d.b(eVar8, f118);
                bVarL1118.f22423d.b(eVar10, -f118);
                cVar2.c(bVarL1118);
            }
        }
        if (eVar5.h()) {
            e eVar117 = eVar5;
            g gVar18 = eVar117.f1210f.f1208d;
            float radians10 = (float) Math.toRadians(this.f1280x + 90.0f);
            int iE10 = eVar117.e();
            e.a aVar11111 = e.a.f1214a;
            p197z.e eVarK111111112 = cVar2.k(i(aVar11111));
            e.a aVar11112 = e.a.f1215b;
            p197z.e eVarK111111113 = cVar2.k(i(aVar11112));
            e.a aVar11113 = e.a.f1216c;
            p197z.e eVarK111111114 = cVar2.k(i(aVar11113));
            e.a aVar11114 = e.a.f1217d;
            p197z.e eVarK111111115 = cVar2.k(i(aVar11114));
            p197z.e eVarK111111116 = cVar2.k(gVar18.i(aVar11111));
            p197z.e eVarK111111117 = cVar2.k(gVar18.i(aVar11112));
            p197z.e eVarK111111118 = cVar2.k(gVar18.i(aVar11113));
            p197z.e eVarK111111119 = cVar2.k(gVar18.i(aVar11114));
            p197z.b bVarL1119 = cVar2.l();
            double d117 = radians10;
            double dSin10 = Math.sin(d117);
            double d118 = iE10;
            bVarL1119.f22423d.b(eVarK111111117, 0.5f);
            bVarL1119.f22423d.b(eVarK111111119, 0.5f);
            bVarL1119.f22423d.b(eVarK111111113, -0.5f);
            bVarL1119.f22423d.b(eVarK111111115, -0.5f);
            bVarL1119.f22421b = -((float) (dSin10 * d118));
            cVar2.c(bVarL1119);
            p197z.b bVarL11110 = cVar2.l();
            float fCos10 = (float) (Math.cos(d117) * d118);
            bVarL11110.f22423d.b(eVarK111111116, 0.5f);
            bVarL11110.f22423d.b(eVarK111111118, 0.5f);
            bVarL11110.f22423d.b(eVarK111111112, -0.5f);
            bVarL11110.f22423d.b(eVarK111111114, -0.5f);
            bVarL11110.f22421b = -fCos10;
            cVar2.c(bVarL11110);
        }
        this.f1262h = false;
        this.f1264i = false;
    }

    public boolean c() {
        return this.f1253c0 != 8;
    }

    /* JADX WARN: Code duplicated, block: B:189:0x034e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:192:0x0357  */
    /* JADX WARN: Code duplicated, block: B:194:0x035b  */
    /* JADX WARN: Code duplicated, block: B:195:0x035d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:201:0x036f  */
    /* JADX WARN: Code duplicated, block: B:203:0x038e  */
    /* JADX WARN: Code duplicated, block: B:206:0x039f  */
    /* JADX WARN: Code duplicated, block: B:212:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:213:0x03af A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:220:0x03be  */
    /* JADX WARN: Code duplicated, block: B:223:0x03d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:229:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:231:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:232:0x03eb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:235:0x03f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:240:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:242:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:245:0x0404  */
    /* JADX WARN: Code duplicated, block: B:247:0x0408  */
    /* JADX WARN: Code duplicated, block: B:249:0x040c  */
    /* JADX WARN: Code duplicated, block: B:250:0x040e  */
    /* JADX WARN: Code duplicated, block: B:253:0x0416  */
    /* JADX WARN: Code duplicated, block: B:255:0x041c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:259:0x0424 A[PHI: r3
  0x0424: PHI (r3v21 int) = (r3v20 int), (r3v25 int), (r3v25 int), (r3v25 int) binds: [B:252:0x0414, B:254:0x041a, B:255:0x041c, B:257:0x0420] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:262:0x0436 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:263:0x0438  */
    /* JADX WARN: Code duplicated, block: B:264:0x043d  */
    /* JADX WARN: Code duplicated, block: B:266:0x0440  */
    /* JADX WARN: Code duplicated, block: B:268:0x0446 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:272:0x044e  */
    /* JADX WARN: Code duplicated, block: B:275:0x0458  */
    /* JADX WARN: Code duplicated, block: B:288:0x047a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:307:0x04af  */
    /* JADX WARN: Code duplicated, block: B:318:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0178 A[ADDED_TO_REGION] */
    public final void d(p197z.c cVar, boolean z8, boolean z9, boolean z10, boolean z11, p197z.e eVar, p197z.e eVar2, a aVar, boolean z12, e eVar3, e eVar4, int i9, int i10, int i11, int i12, float f6, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, int i13, int i14, int i15, int i16, float f9, boolean z18) {
        int iMin;
        int i17;
        int i18;
        p197z.e eVarK;
        p197z.e eVarK2;
        e eVar5;
        p197z.e eVar6;
        boolean z19;
        boolean z20;
        boolean z21;
        int i19;
        int i20;
        boolean z22;
        g gVar;
        int i21;
        boolean z23;
        int iMin2;
        int i22;
        int iE;
        int i23;
        int i24;
        int i25;
        HashSet<e> hashSet;
        int i26;
        int i27;
        boolean z24;
        boolean z25;
        cVar = cVar;
        int i28 = i15;
        int i29 = i16;
        p197z.e eVarK3 = cVar.k(eVar3);
        p197z.e eVarK4 = cVar.k(eVar4);
        p197z.e eVarK5 = cVar.k(eVar3.f1210f);
        p197z.e eVarK6 = cVar.k(eVar4.f1210f);
        boolean zH = eVar3.h();
        boolean zH2 = eVar4.h();
        boolean zH3 = this.f1234K.h();
        int i30 = zH2 ? (zH ? 1 : 0) + 1 : zH ? 1 : 0;
        if (zH3) {
            i30++;
        }
        int i31 = i30;
        int i32 = z13 ? 3 : i13;
        int iOrdinal = aVar.ordinal();
        boolean z26 = (iOrdinal == 0 || iOrdinal == 1 || iOrdinal != 2 || i32 == 4) ? false : true;
        if (this.f1253c0 == 8) {
            iMin = 0;
            z26 = false;
        } else {
            iMin = i10;
        }
        if (z18) {
            if (!zH && !zH2 && !zH3) {
                cVar.d(eVarK3, i9);
            } else if (zH && !zH2) {
                i17 = 8;
                cVar.e(eVarK3, eVarK5, eVar3.e(), 8);
            }
            i17 = 8;
        } else {
            i17 = 8;
        }
        if (z26) {
            if (i31 == 2 || z13 || !(i32 == 1 || i32 == 0)) {
                if (i28 == -2) {
                    i28 = iMin;
                }
                if (i29 == -2) {
                    i29 = iMin;
                }
                if (iMin > 0 && i32 != 1) {
                    iMin = 0;
                }
                if (i28 > 0) {
                    cVar.f(eVarK4, eVarK3, i28, 8);
                    iMin = Math.max(iMin, i28);
                }
                if (i29 > 0) {
                    if (!z9 || i32 != 1) {
                        cVar.g(eVarK4, eVarK3, i29, 8);
                    }
                    iMin = Math.min(iMin, i29);
                }
                if (i32 == 1) {
                    if (z9) {
                        cVar.e(eVarK4, eVarK3, iMin, 8);
                    } else if (z15) {
                        cVar.e(eVarK4, eVarK3, iMin, 5);
                        cVar.g(eVarK4, eVarK3, iMin, 8);
                    } else {
                        cVar.e(eVarK4, eVarK3, iMin, 5);
                        cVar.g(eVarK4, eVarK3, iMin, 8);
                    }
                } else if (i32 == 2) {
                    e.a aVar2 = e.a.f1215b;
                    e.a aVar3 = e.a.f1217d;
                    e.a aVar4 = eVar3.f1209e;
                    if (aVar4 == aVar2 || aVar4 == aVar3) {
                        eVarK = cVar.k(this.f1238P.i(aVar2));
                        eVarK2 = cVar.k(this.f1238P.i(aVar3));
                    } else {
                        eVarK = cVar.k(this.f1238P.i(e.a.f1214a));
                        eVarK2 = cVar.k(this.f1238P.i(e.a.f1216c));
                    }
                    p197z.b bVarL = cVar.l();
                    bVarL.f22423d.b(eVarK4, -1.0f);
                    bVarL.f22423d.b(eVarK3, 1.0f);
                    bVarL.f22423d.b(eVarK2, f9);
                    bVarL.f22423d.b(eVarK, -f9);
                    cVar.c(bVarL);
                    i18 = i28;
                } else {
                    i18 = i28;
                    z11 = true;
                }
                if (z18 || z15) {
                    boolean z27 = z11;
                    if (i31 >= 2 && z9 && z27) {
                        cVar.f(eVarK3, eVar, 0, 8);
                        e eVar7 = this.f1231H;
                        boolean z28 = z8 || eVar7.f1210f == null;
                        if (!z8 && (eVar5 = eVar7.f1210f) != null) {
                            g gVar2 = eVar5.f1208d;
                            if (gVar2.f1241S != 0.0f) {
                                a[] aVarArr = gVar2.O;
                                a aVar5 = aVarArr[0];
                                a aVar6 = a.f1285c;
                                if (aVar5 == aVar6) {
                                    z28 = true;
                                    if (aVarArr[1] != aVar6) {
                                        z28 = false;
                                    }
                                } else {
                                    z28 = false;
                                }
                            } else {
                                z28 = false;
                            }
                        }
                        if (z28) {
                            cVar.f(eVar2, eVarK4, 0, 8);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ((!zH && !zH2 && !zH3) || (zH && !zH2)) {
                    eVar6 = eVarK6;
                } else {
                    if (zH || !zH2) {
                        eVar6 = eVarK6;
                        if (zH && zH2) {
                            g gVar3 = eVar3.f1210f.f1208d;
                            g gVar4 = eVar4.f1210f.f1208d;
                            z11 = z11;
                            g gVar5 = this.f1238P;
                            int i33 = 6;
                            if (z26) {
                                if (i32 == 0) {
                                    if (i29 != 0 || i18 != 0) {
                                        z24 = true;
                                        z25 = false;
                                        z20 = true;
                                        i20 = 5;
                                        i19 = 5;
                                    } else if (eVarK5.f22452f && eVar6.f22452f) {
                                        cVar.e(eVarK3, eVarK5, eVar3.e(), 8);
                                        cVar.e(eVarK4, eVar6, -eVar4.e(), 8);
                                        return;
                                    } else {
                                        z24 = false;
                                        z25 = true;
                                        z20 = false;
                                        i20 = 8;
                                        i19 = 8;
                                    }
                                    if ((gVar3 instanceof b) || (gVar4 instanceof b)) {
                                        i19 = 4;
                                    }
                                    z19 = z24;
                                    z21 = z25;
                                    i32 = i32;
                                } else if (i32 == 1) {
                                    cVar = cVar;
                                    i32 = i32;
                                    eVarK3 = eVarK3;
                                    eVarK4 = eVarK4;
                                    z19 = true;
                                    z20 = true;
                                    z21 = false;
                                    i19 = 4;
                                    i20 = 8;
                                } else {
                                    if (i32 == 3) {
                                        i32 = i32;
                                        if (this.f1277u == -1) {
                                            if (z16) {
                                                cVar = cVar;
                                                eVar2 = eVar2;
                                                eVarK3 = eVarK3;
                                                eVarK4 = eVarK4;
                                                eVarK5 = eVarK5;
                                                z19 = true;
                                                i33 = z9 ? 5 : 4;
                                            } else {
                                                cVar = cVar;
                                                eVar2 = eVar2;
                                                eVarK3 = eVarK3;
                                                eVarK4 = eVarK4;
                                                eVarK5 = eVarK5;
                                                z19 = true;
                                                i33 = 8;
                                            }
                                            z20 = true;
                                            z21 = true;
                                            i19 = 5;
                                            i20 = 8;
                                        } else if (z13) {
                                            if (i14 == 2 || i14 == 1) {
                                                i26 = 5;
                                                i27 = 4;
                                            } else {
                                                i26 = 8;
                                                i27 = 5;
                                            }
                                            i20 = i26;
                                            i19 = i27;
                                            eVarK3 = eVarK3;
                                            eVarK4 = eVarK4;
                                            z19 = true;
                                            z20 = true;
                                            z21 = true;
                                            cVar = cVar;
                                        } else {
                                            if (i29 > 0) {
                                                cVar = cVar;
                                                eVar2 = eVar2;
                                                eVarK3 = eVarK3;
                                                eVarK4 = eVarK4;
                                                eVarK5 = eVarK5;
                                                i33 = 6;
                                                z19 = true;
                                                z20 = true;
                                                z21 = true;
                                                i19 = 5;
                                            } else if (i29 != 0 || i18 != 0) {
                                                cVar = cVar;
                                                eVar2 = eVar2;
                                                eVarK3 = eVarK3;
                                                eVarK4 = eVarK4;
                                                eVarK5 = eVarK5;
                                                i33 = 6;
                                                z19 = true;
                                                z20 = true;
                                                z21 = true;
                                                i19 = 4;
                                            } else if (z16) {
                                                eVar2 = eVar2;
                                                i20 = (gVar3 == gVar5 || gVar4 == gVar5) ? 5 : 4;
                                                eVarK3 = eVarK3;
                                                eVarK4 = eVarK4;
                                                eVarK5 = eVarK5;
                                                i33 = 6;
                                                z19 = true;
                                                z20 = true;
                                                z21 = true;
                                                i19 = 4;
                                                cVar = cVar;
                                            } else {
                                                cVar = cVar;
                                                eVar2 = eVar2;
                                                eVarK3 = eVarK3;
                                                eVarK4 = eVarK4;
                                                eVarK5 = eVarK5;
                                                i33 = 6;
                                                z19 = true;
                                                z20 = true;
                                                z21 = true;
                                                i19 = 8;
                                            }
                                            i20 = 5;
                                        }
                                    } else {
                                        z19 = false;
                                        z20 = false;
                                    }
                                    if (z20 || eVarK5 != eVar6 || gVar3 == gVar5) {
                                        z22 = true;
                                    } else {
                                        z20 = false;
                                        z22 = false;
                                    }
                                    if (z19) {
                                        if (z26 && !z14 && !z16 && eVarK5 == eVar && eVar6 == eVar2) {
                                            i33 = 8;
                                            z23 = false;
                                            z22 = false;
                                            i21 = 8;
                                        } else {
                                            i21 = i20;
                                            z23 = z9;
                                        }
                                        p197z.e eVar8 = eVarK5;
                                        gVar = gVar4;
                                        cVar.b(eVarK3, eVar8, eVar3.e(), f6, eVar6, eVarK4, eVar4.e(), i33);
                                        eVarK5 = eVar8;
                                    } else {
                                        gVar = gVar4;
                                        i21 = i20;
                                        z23 = z9;
                                    }
                                    if (this.f1253c0 != 8 && ((hashSet = eVar4.f1205a) == null || hashSet.size() <= 0)) {
                                        return;
                                    }
                                    if (z20) {
                                        if (z23 || eVarK5 == eVar6 || z26 || !((gVar3 instanceof b) || (gVar instanceof b))) {
                                            i25 = i21;
                                        } else {
                                            i25 = 6;
                                        }
                                        cVar.f(eVarK3, eVarK5, eVar3.e(), i25);
                                        cVar.g(eVarK4, eVar6, -eVar4.e(), i25);
                                        i21 = i25;
                                    }
                                    if (z23 || !z17 || (gVar3 instanceof b) || (gVar instanceof b)) {
                                        iMin2 = i19;
                                        i22 = i21;
                                    } else {
                                        iMin2 = 6;
                                        i22 = 6;
                                        z22 = true;
                                    }
                                    if (z22) {
                                        if (z21 && (!z16 || z10)) {
                                            if (gVar3 != gVar5 && gVar != gVar5) {
                                                i33 = iMin2;
                                            }
                                            if ((gVar3 instanceof j) || (gVar instanceof j)) {
                                                i33 = 5;
                                            }
                                            if ((gVar3 instanceof b) || (gVar instanceof b)) {
                                                i33 = 5;
                                            }
                                            if (z16) {
                                                i24 = 5;
                                            } else {
                                                i24 = i33;
                                            }
                                            iMin2 = Math.max(i24, iMin2);
                                        }
                                        if (z23) {
                                            iMin2 = Math.min(i22, iMin2);
                                            if (z13 || z16 || !(gVar3 == gVar5 || gVar == gVar5)) {
                                                i23 = iMin2;
                                            } else {
                                                i23 = 4;
                                            }
                                        } else {
                                            i23 = iMin2;
                                        }
                                        cVar.e(eVarK3, eVarK5, eVar3.e(), i23);
                                        cVar.e(eVarK4, eVar6, -eVar4.e(), i23);
                                    }
                                    if (z23) {
                                        if (eVar == eVarK5) {
                                            iE = eVar3.e();
                                        } else {
                                            iE = 0;
                                        }
                                        if (eVarK5 != eVar) {
                                            cVar.f(eVarK3, eVar, iE, 5);
                                        }
                                    }
                                    if (z23 && z26 && i11 == 0 && i18 == 0) {
                                        if (z26 || i32 != 3) {
                                            cVar.f(eVarK4, eVarK3, 0, 5);
                                        } else {
                                            cVar.f(eVarK4, eVarK3, 0, 8);
                                        }
                                    }
                                }
                                eVar2 = eVar2;
                                if (z20) {
                                    z22 = true;
                                } else {
                                    z22 = true;
                                }
                                if (z19) {
                                    if (z26) {
                                        i21 = i20;
                                        z23 = z9;
                                    } else {
                                        i21 = i20;
                                        z23 = z9;
                                    }
                                    p197z.e eVar9 = eVarK5;
                                    gVar = gVar4;
                                    cVar.b(eVarK3, eVar9, eVar3.e(), f6, eVar6, eVarK4, eVar4.e(), i33);
                                    eVarK5 = eVar9;
                                } else {
                                    gVar = gVar4;
                                    i21 = i20;
                                    z23 = z9;
                                }
                                if (this.f1253c0 != 8) {
                                }
                                if (z20) {
                                    if (z23) {
                                        i25 = i21;
                                    } else {
                                        i25 = i21;
                                    }
                                    cVar.f(eVarK3, eVarK5, eVar3.e(), i25);
                                    cVar.g(eVarK4, eVar6, -eVar4.e(), i25);
                                    i21 = i25;
                                }
                                if (z23) {
                                    iMin2 = i19;
                                    i22 = i21;
                                } else {
                                    iMin2 = i19;
                                    i22 = i21;
                                }
                                if (z22) {
                                    if (z21) {
                                        if (gVar3 != gVar5) {
                                            i33 = iMin2;
                                        }
                                        if (gVar3 instanceof j) {
                                            i33 = 5;
                                        } else {
                                            i33 = 5;
                                        }
                                        if (gVar3 instanceof b) {
                                            i33 = 5;
                                        } else {
                                            i33 = 5;
                                        }
                                        if (z16) {
                                            i24 = 5;
                                        } else {
                                            i24 = i33;
                                        }
                                        iMin2 = Math.max(i24, iMin2);
                                    }
                                    if (z23) {
                                        iMin2 = Math.min(i22, iMin2);
                                        if (z13) {
                                            i23 = iMin2;
                                        } else {
                                            i23 = iMin2;
                                        }
                                    } else {
                                        i23 = iMin2;
                                    }
                                    cVar.e(eVarK3, eVarK5, eVar3.e(), i23);
                                    cVar.e(eVarK4, eVar6, -eVar4.e(), i23);
                                }
                                if (z23) {
                                    if (eVar == eVarK5) {
                                        iE = eVar3.e();
                                    } else {
                                        iE = 0;
                                    }
                                    if (eVarK5 != eVar) {
                                        cVar.f(eVarK3, eVar, iE, 5);
                                    }
                                }
                                if (z23) {
                                    if (z26) {
                                        cVar.f(eVarK4, eVarK3, 0, 5);
                                    } else {
                                        cVar.f(eVarK4, eVarK3, 0, 5);
                                    }
                                }
                            } else {
                                if (eVarK5.f22452f && eVar6.f22452f) {
                                    cVar.b(eVarK3, eVarK5, eVar3.e(), f6, eVar6, eVarK4, eVar4.e(), 8);
                                    if (z9 && z11) {
                                        int iE2 = eVar4.f1210f != null ? eVar4.e() : 0;
                                        if (eVar6 != eVar2) {
                                            cVar.f(eVar2, eVarK4, iE2, 5);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                z19 = true;
                                z20 = true;
                            }
                            z21 = false;
                            i19 = 4;
                            i20 = 5;
                            if (z20) {
                                z22 = true;
                            } else {
                                z22 = true;
                            }
                            if (z19) {
                                if (z26) {
                                    i21 = i20;
                                    z23 = z9;
                                } else {
                                    i21 = i20;
                                    z23 = z9;
                                }
                                p197z.e eVar10 = eVarK5;
                                gVar = gVar4;
                                cVar.b(eVarK3, eVar10, eVar3.e(), f6, eVar6, eVarK4, eVar4.e(), i33);
                                eVarK5 = eVar10;
                            } else {
                                gVar = gVar4;
                                i21 = i20;
                                z23 = z9;
                            }
                            if (this.f1253c0 != 8) {
                            }
                            if (z20) {
                                if (z23) {
                                    i25 = i21;
                                } else {
                                    i25 = i21;
                                }
                                cVar.f(eVarK3, eVarK5, eVar3.e(), i25);
                                cVar.g(eVarK4, eVar6, -eVar4.e(), i25);
                                i21 = i25;
                            }
                            if (z23) {
                                iMin2 = i19;
                                i22 = i21;
                            } else {
                                iMin2 = i19;
                                i22 = i21;
                            }
                            if (z22) {
                                if (z21) {
                                    if (gVar3 != gVar5) {
                                        i33 = iMin2;
                                    }
                                    if (gVar3 instanceof j) {
                                        i33 = 5;
                                    } else {
                                        i33 = 5;
                                    }
                                    if (gVar3 instanceof b) {
                                        i33 = 5;
                                    } else {
                                        i33 = 5;
                                    }
                                    if (z16) {
                                        i24 = 5;
                                    } else {
                                        i24 = i33;
                                    }
                                    iMin2 = Math.max(i24, iMin2);
                                }
                                if (z23) {
                                    iMin2 = Math.min(i22, iMin2);
                                    if (z13) {
                                        i23 = iMin2;
                                    } else {
                                        i23 = iMin2;
                                    }
                                } else {
                                    i23 = iMin2;
                                }
                                cVar.e(eVarK3, eVarK5, eVar3.e(), i23);
                                cVar.e(eVarK4, eVar6, -eVar4.e(), i23);
                            }
                            if (z23) {
                                if (eVar == eVarK5) {
                                    iE = eVar3.e();
                                } else {
                                    iE = 0;
                                }
                                if (eVarK5 != eVar) {
                                    cVar.f(eVarK3, eVar, iE, 5);
                                }
                            }
                            if (z23) {
                                if (z26) {
                                    cVar.f(eVarK4, eVarK3, 0, 5);
                                } else {
                                    cVar.f(eVarK4, eVarK3, 0, 5);
                                }
                            }
                        }
                        if (z23 || !z11) {
                            return;
                        }
                        int iE3 = eVar4.f1210f != null ? eVar4.e() : 0;
                        if (eVar6 != eVar2) {
                            cVar.f(eVar2, eVarK4, iE3, 5);
                            return;
                        }
                        return;
                    }
                    eVar6 = eVarK6;
                    cVar.e(eVarK4, eVar6, -eVar4.e(), 8);
                    if (z9) {
                        cVar.f(eVarK3, eVar, 0, 5);
                    }
                }
                z23 = z9;
                if (z23) {
                    return;
                } else {
                    return;
                }
            }
            int iMax = Math.max(i28, iMin);
            if (i29 > 0) {
                iMax = Math.min(i29, iMax);
            }
            cVar.e(eVarK4, eVarK3, iMax, 8);
            i18 = i28;
            z26 = false;
            if (z18) {
            }
            boolean z29 = z11;
            if (i31 >= 2) {
            }
        }
        if (z12) {
            cVar.e(eVarK4, eVarK3, 0, 3);
            if (i11 > 0) {
                cVar.f(eVarK4, eVarK3, i11, i17);
            }
            if (i12 < Integer.MAX_VALUE) {
                cVar.g(eVarK4, eVarK3, i12, i17);
            }
        } else {
            cVar.e(eVarK4, eVarK3, iMin, i17);
        }
        z11 = z11;
        i18 = i28;
        if (z18) {
        }
        boolean z210 = z11;
        if (i31 >= 2) {
        }
    }

    public final void e(e.a aVar, g gVar, e.a aVar2, int i9) {
        boolean z8;
        e.a aVar3 = e.a.f1219f;
        e.a aVar4 = e.a.f1221h;
        e.a aVar5 = e.a.f1220g;
        e.a aVar6 = e.a.f1214a;
        e.a aVar7 = e.a.f1215b;
        e.a aVar8 = e.a.f1216c;
        e.a aVar9 = e.a.f1217d;
        if (aVar == aVar3) {
            if (aVar2 != aVar3) {
                if (aVar2 == aVar6 || aVar2 == aVar8) {
                    e(aVar6, gVar, aVar2, 0);
                    e(aVar8, gVar, aVar2, 0);
                    i(aVar3).a(gVar.i(aVar2), 0);
                    return;
                } else {
                    if (aVar2 == aVar7 || aVar2 == aVar9) {
                        e(aVar7, gVar, aVar2, 0);
                        e(aVar9, gVar, aVar2, 0);
                        i(aVar3).a(gVar.i(aVar2), 0);
                        return;
                    }
                    return;
                }
            }
            e eVarI = i(aVar6);
            e eVarI2 = i(aVar8);
            e eVarI3 = i(aVar7);
            e eVarI4 = i(aVar9);
            boolean z9 = true;
            if ((eVarI == null || !eVarI.h()) && (eVarI2 == null || !eVarI2.h())) {
                e(aVar6, gVar, aVar6, 0);
                e(aVar8, gVar, aVar8, 0);
                z8 = true;
            } else {
                z8 = false;
            }
            if ((eVarI3 == null || !eVarI3.h()) && (eVarI4 == null || !eVarI4.h())) {
                e(aVar7, gVar, aVar7, 0);
                e(aVar9, gVar, aVar9, 0);
            } else {
                z9 = false;
            }
            if (z8 && z9) {
                i(aVar3).a(gVar.i(aVar3), 0);
                return;
            } else if (z8) {
                i(aVar5).a(gVar.i(aVar5), 0);
                return;
            } else {
                if (z9) {
                    i(aVar4).a(gVar.i(aVar4), 0);
                    return;
                }
                return;
            }
        }
        if (aVar == aVar5 && (aVar2 == aVar6 || aVar2 == aVar8)) {
            e eVarI5 = i(aVar6);
            e eVarI6 = gVar.i(aVar2);
            e eVarI7 = i(aVar8);
            eVarI5.a(eVarI6, 0);
            eVarI7.a(eVarI6, 0);
            i(aVar5).a(eVarI6, 0);
            return;
        }
        if (aVar == aVar4 && (aVar2 == aVar7 || aVar2 == aVar9)) {
            e eVarI8 = gVar.i(aVar2);
            i(aVar7).a(eVarI8, 0);
            i(aVar9).a(eVarI8, 0);
            i(aVar4).a(eVarI8, 0);
            return;
        }
        if (aVar == aVar5 && aVar2 == aVar5) {
            i(aVar6).a(gVar.i(aVar6), 0);
            i(aVar8).a(gVar.i(aVar8), 0);
            i(aVar5).a(gVar.i(aVar2), 0);
            return;
        }
        if (aVar == aVar4 && aVar2 == aVar4) {
            i(aVar7).a(gVar.i(aVar7), 0);
            i(aVar9).a(gVar.i(aVar9), 0);
            i(aVar4).a(gVar.i(aVar2), 0);
            return;
        }
        e eVarI9 = i(aVar);
        e eVarI10 = gVar.i(aVar2);
        if (eVarI9.i(eVarI10)) {
            e.a aVar10 = e.a.f1218e;
            if (aVar == aVar10) {
                e eVarI11 = i(aVar7);
                e eVarI12 = i(aVar9);
                if (eVarI11 != null) {
                    eVarI11.j();
                }
                if (eVarI12 != null) {
                    eVarI12.j();
                }
                i9 = 0;
            } else if (aVar == aVar7 || aVar == aVar9) {
                e eVarI13 = i(aVar10);
                if (eVarI13 != null) {
                    eVarI13.j();
                }
                e eVarI14 = i(aVar3);
                if (eVarI14.f1210f != eVarI10) {
                    eVarI14.j();
                }
                e eVarF = i(aVar).f();
                e eVarI15 = i(aVar4);
                if (eVarI15.h()) {
                    eVarF.j();
                    eVarI15.j();
                }
            } else if (aVar == aVar6 || aVar == aVar8) {
                e eVarI16 = i(aVar3);
                if (eVarI16.f1210f != eVarI10) {
                    eVarI16.j();
                }
                e eVarF2 = i(aVar).f();
                e eVarI17 = i(aVar5);
                if (eVarI17.h()) {
                    eVarF2.j();
                    eVarI17.j();
                }
            }
            eVarI9.a(eVarI10, i9);
        }
    }

    public final void f(e eVar, e eVar2, int i9) {
        if (eVar.f1208d == this) {
            e(eVar.f1209e, eVar2.f1208d, eVar2.f1209e, i9);
        }
    }

    public final void g(p197z.c cVar) {
        cVar.k(this.f1227D);
        cVar.k(this.f1228E);
        cVar.k(this.f1229F);
        cVar.k(this.f1230G);
        if (this.f1245W > 0) {
            cVar.k(this.f1231H);
        }
    }

    public final void h() {
        if (this.f1254d == null) {
            B.l lVar = new B.l(this);
            lVar.f1593h.f1557e = B.f.a.f1567d;
            lVar.f1594i.f1557e = B.f.a.f1568e;
            lVar.f1591f = 0;
            this.f1254d = lVar;
        }
        if (this.f1256e == null) {
            B.n nVar = new B.n(this);
            B.f fVar = new B.f(nVar);
            nVar.f1578k = fVar;
            nVar.f1579l = null;
            nVar.f1593h.f1557e = B.f.a.f1569f;
            nVar.f1594i.f1557e = B.f.a.f1570g;
            fVar.f1557e = B.f.a.f1571h;
            nVar.f1591f = 1;
            this.f1256e = nVar;
        }
    }

    public e i(e.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.f1227D;
            case 2:
                return this.f1228E;
            case 3:
                return this.f1229F;
            case 4:
                return this.f1230G;
            case 5:
                return this.f1231H;
            case 6:
                return this.f1234K;
            case 7:
                return this.f1232I;
            case 8:
                return this.f1233J;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public final a j(int i9) {
        a[] aVarArr = this.O;
        if (i9 == 0) {
            return aVarArr[0];
        }
        if (i9 == 1) {
            return aVarArr[1];
        }
        return null;
    }

    public final int k() {
        if (this.f1253c0 == 8) {
            return 0;
        }
        return this.f1240R;
    }

    public final g l(int i9) {
        e eVar;
        e eVar2;
        if (i9 != 0) {
            if (i9 == 1 && (eVar2 = (eVar = this.f1230G).f1210f) != null && eVar2.f1210f == eVar) {
                return eVar2.f1208d;
            }
            return null;
        }
        e eVar3 = this.f1229F;
        e eVar4 = eVar3.f1210f;
        if (eVar4 == null || eVar4.f1210f != eVar3) {
            return null;
        }
        return eVar4.f1208d;
    }

    public final g m(int i9) {
        e eVar;
        e eVar2;
        if (i9 != 0) {
            if (i9 == 1 && (eVar2 = (eVar = this.f1228E).f1210f) != null && eVar2.f1210f == eVar) {
                return eVar2.f1208d;
            }
            return null;
        }
        e eVar3 = this.f1227D;
        e eVar4 = eVar3.f1210f;
        if (eVar4 == null || eVar4.f1210f != eVar3) {
            return null;
        }
        return eVar4.f1208d;
    }

    public final int n() {
        if (this.f1253c0 == 8) {
            return 0;
        }
        return this.f1239Q;
    }

    public final int o() {
        g gVar = this.f1238P;
        return (gVar == null || !(gVar instanceof h)) ? this.f1243U : ((h) gVar).f1298r0 + this.f1243U;
    }

    public final int p() {
        g gVar = this.f1238P;
        return (gVar == null || !(gVar instanceof h)) ? this.f1244V : ((h) gVar).f1299s0 + this.f1244V;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x003b A[RETURN] */
    public final boolean q(int i9) {
        if (i9 == 0) {
            if ((this.f1227D.f1210f != null ? 1 : 0) + (this.f1229F.f1210f != null ? 1 : 0) < 2) {
                return true;
            }
            return false;
        }
        if ((this.f1228E.f1210f != null ? 1 : 0) + (this.f1230G.f1210f != null ? 1 : 0) + (this.f1231H.f1210f != null ? 1 : 0) < 2) {
            return true;
        }
        return false;
    }

    public final void r(e.a aVar, g gVar, e.a aVar2, int i9, int i10) {
        i(aVar).b(gVar.i(aVar2), i9, i10, true);
    }

    public final boolean s(int i9) {
        e eVar;
        e eVar2;
        int i10 = i9 * 2;
        e[] eVarArr = this.f1235L;
        e eVar3 = eVarArr[i10];
        e eVar4 = eVar3.f1210f;
        return (eVar4 == null || eVar4.f1210f == eVar3 || (eVar2 = (eVar = eVarArr[i10 + 1]).f1210f) == null || eVar2.f1210f != eVar) ? false : true;
    }

    public final boolean t() {
        e eVar = this.f1227D;
        e eVar2 = eVar.f1210f;
        if (eVar2 != null && eVar2.f1210f == eVar) {
            return true;
        }
        e eVar3 = this.f1229F;
        e eVar4 = eVar3.f1210f;
        return eVar4 != null && eVar4.f1210f == eVar3;
    }

    public String toString() {
        StringBuilder sbB = p171w.a.b("");
        sbB.append(this.f1255d0 != null ? A.a.j(new StringBuilder("id: "), this.f1255d0, " ") : "");
        sbB.append("(");
        sbB.append(this.f1243U);
        sbB.append(", ");
        sbB.append(this.f1244V);
        sbB.append(") - (");
        sbB.append(this.f1239Q);
        sbB.append(" x ");
        return f.i(sbB, this.f1240R, ")");
    }

    public final boolean u() {
        e eVar = this.f1228E;
        e eVar2 = eVar.f1210f;
        if (eVar2 != null && eVar2.f1210f == eVar) {
            return true;
        }
        e eVar3 = this.f1230G;
        e eVar4 = eVar3.f1210f;
        return eVar4 != null && eVar4.f1210f == eVar3;
    }

    public final boolean v() {
        return this.f1260g && this.f1253c0 != 8;
    }

    public boolean w() {
        if (this.f1262h) {
            return true;
        }
        return this.f1227D.f1207c && this.f1229F.f1207c;
    }

    public boolean x() {
        if (this.f1264i) {
            return true;
        }
        return this.f1228E.f1207c && this.f1230G.f1207c;
    }

    public void y() {
        this.f1227D.j();
        this.f1228E.j();
        this.f1229F.j();
        this.f1230G.j();
        this.f1231H.j();
        this.f1232I.j();
        this.f1233J.j();
        this.f1234K.j();
        this.f1238P = null;
        this.f1280x = 0.0f;
        this.f1239Q = 0;
        this.f1240R = 0;
        this.f1241S = 0.0f;
        this.f1242T = -1;
        this.f1243U = 0;
        this.f1244V = 0;
        this.f1245W = 0;
        this.f1246X = 0;
        this.f1247Y = 0;
        this.f1248Z = 0.5f;
        this.a0 = 0.5f;
        a aVar = a.f1283a;
        a[] aVarArr = this.O;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.f1251b0 = null;
        this.f1253c0 = 0;
        this.f1257e0 = 0;
        this.f1259f0 = 0;
        float[] fArr = this.f1261g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.j = -1;
        this.f1267k = -1;
        int[] iArr = this.f1279w;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f1269l = 0;
        this.f1270m = 0;
        this.f1274q = 1.0f;
        this.t = 1.0f;
        this.f1273p = Integer.MAX_VALUE;
        this.f1276s = Integer.MAX_VALUE;
        this.f1272o = 0;
        this.f1275r = 0;
        this.f1277u = -1;
        this.f1278v = 1.0f;
        boolean[] zArr = this.f1258f;
        zArr[0] = true;
        zArr[1] = true;
        this.f1224A = false;
        boolean[] zArr2 = this.f1237N;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1260g = true;
    }

    public final void z() {
        g gVar = this.f1238P;
        if (gVar != null && (gVar instanceof h)) {
            ((h) gVar).getClass();
        }
        ArrayList<e> arrayList = this.f1236M;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.get(i9).j();
        }
    }
}
