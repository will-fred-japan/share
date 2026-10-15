package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class iv implements jf<iv, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f798a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f800a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f802b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f803b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f804b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f805c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f806c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f807d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f808e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f809f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f810g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f811h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f812i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f813j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f814k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f815l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f794a = new ju("XmPushActionRegistrationResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17993a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17994b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17995c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17996d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17997e = new jm("", (byte) 10, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17998f = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17999g = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f18000h = new jm("", (byte) 11, 9);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f18001i = new jm("", (byte) 11, 10);
    private static final jm j = new jm("", (byte) 10, 11);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f18002k = new jm("", (byte) 11, 12);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final jm f18003l = new jm("", (byte) 11, 13);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final jm f18004m = new jm("", (byte) 10, 14);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final jm f18005n = new jm("", (byte) 11, 15);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final jm f18006o = new jm("", (byte) 8, 16);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final jm f18007p = new jm("", (byte) 11, 17);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final jm f18008q = new jm("", (byte) 8, 18);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final jm f18009r = new jm("", (byte) 11, 19);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final jm f18010s = new jm("", (byte) 2, 20);
    private static final jm t = new jm("", (byte) 15, 21);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f799a = new BitSet(6);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f801a = false;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m585a() {
        return this.f798a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m587b() {
        return this.f797a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m588c() {
        return this.f804b != null;
    }

    public boolean d() {
        return this.f806c != null;
    }

    public boolean e() {
        return this.f799a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m586a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f807d != null;
    }

    public boolean g() {
        return this.f808e != null;
    }

    public boolean h() {
        return this.f809f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f810g != null;
    }

    public boolean j() {
        return this.f799a.get(1);
    }

    public boolean k() {
        return this.f811h != null;
    }

    public boolean l() {
        return this.f812i != null;
    }

    public boolean m() {
        return this.f799a.get(2);
    }

    public boolean n() {
        return this.f813j != null;
    }

    public boolean o() {
        return this.f799a.get(3);
    }

    public boolean p() {
        return this.f814k != null;
    }

    public boolean q() {
        return this.f799a.get(4);
    }

    public boolean r() {
        return this.f815l != null;
    }

    public boolean s() {
        return this.f799a.get(5);
    }

    public boolean t() {
        return this.f800a != null;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z9 = false;
        if (m585a()) {
            sb.append("debug:");
            String str = this.f798a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (m587b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("target:");
            ij ijVar = this.f797a;
            if (ijVar == null) {
                sb.append("null");
            } else {
                sb.append(ijVar);
            }
        } else {
            z9 = z8;
        }
        if (!z9) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f804b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.as.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f806c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f796a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f807d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f808e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f810g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f803b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f811h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f812i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f805c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f813j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f795a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f814k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f802b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f815l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f801a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f800a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m582a() {
        return this.f804b;
    }

    public String b() {
        return this.f809f;
    }

    public String c() {
        return this.f810g;
    }

    public void d(boolean z8) {
        this.f799a.set(3, z8);
    }

    public void e(boolean z8) {
        this.f799a.set(4, z8);
    }

    public void f(boolean z8) {
        this.f799a.set(5, z8);
    }

    public long a() {
        return this.f796a;
    }

    public void b(boolean z8) {
        this.f799a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f799a.set(2, z8);
    }

    public void a(boolean z8) {
        this.f799a.set(0, z8);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m584a();
        jpVar.a(f794a);
        if (this.f798a != null && m585a()) {
            jpVar.a(f17993a);
            jpVar.a(this.f798a);
            jpVar.b();
        }
        if (this.f797a != null && m587b()) {
            jpVar.a(f17994b);
            this.f797a.b(jpVar);
            jpVar.b();
        }
        if (this.f804b != null) {
            jpVar.a(f17995c);
            jpVar.a(this.f804b);
            jpVar.b();
        }
        if (this.f806c != null) {
            jpVar.a(f17996d);
            jpVar.a(this.f806c);
            jpVar.b();
        }
        jpVar.a(f17997e);
        jpVar.a(this.f796a);
        jpVar.b();
        if (this.f807d != null && f()) {
            jpVar.a(f17998f);
            jpVar.a(this.f807d);
            jpVar.b();
        }
        if (this.f808e != null && g()) {
            jpVar.a(f17999g);
            jpVar.a(this.f808e);
            jpVar.b();
        }
        if (this.f809f != null && h()) {
            jpVar.a(f18000h);
            jpVar.a(this.f809f);
            jpVar.b();
        }
        if (this.f810g != null && i()) {
            jpVar.a(f18001i);
            jpVar.a(this.f810g);
            jpVar.b();
        }
        if (j()) {
            jpVar.a(j);
            jpVar.a(this.f803b);
            jpVar.b();
        }
        if (this.f811h != null && k()) {
            jpVar.a(f18002k);
            jpVar.a(this.f811h);
            jpVar.b();
        }
        if (this.f812i != null && l()) {
            jpVar.a(f18003l);
            jpVar.a(this.f812i);
            jpVar.b();
        }
        if (m()) {
            jpVar.a(f18004m);
            jpVar.a(this.f805c);
            jpVar.b();
        }
        if (this.f813j != null && n()) {
            jpVar.a(f18005n);
            jpVar.a(this.f813j);
            jpVar.b();
        }
        if (o()) {
            jpVar.a(f18006o);
            jpVar.mo642a(this.f795a);
            jpVar.b();
        }
        if (this.f814k != null && p()) {
            jpVar.a(f18007p);
            jpVar.a(this.f814k);
            jpVar.b();
        }
        if (q()) {
            jpVar.a(f18008q);
            jpVar.mo642a(this.f802b);
            jpVar.b();
        }
        if (this.f815l != null && r()) {
            jpVar.a(f18009r);
            jpVar.a(this.f815l);
            jpVar.b();
        }
        if (s()) {
            jpVar.a(f18010s);
            jpVar.a(this.f801a);
            jpVar.b();
        }
        if (this.f800a != null && t()) {
            jpVar.a(t);
            jpVar.a(new jn((byte) 11, this.f800a.size()));
            Iterator<String> it = this.f800a.iterator();
            while (it.hasNext()) {
                jpVar.a(it.next());
            }
            jpVar.e();
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<String> m583a() {
        return this.f800a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m586a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean zM585a = m585a();
        boolean zM585a2 = ivVar.m585a();
        if ((zM585a || zM585a2) && !(zM585a && zM585a2 && this.f798a.equals(ivVar.f798a))) {
            return false;
        }
        boolean zM587b = m587b();
        boolean zM587b2 = ivVar.m587b();
        if ((zM587b || zM587b2) && !(zM587b && zM587b2 && this.f797a.m530a(ivVar.f797a))) {
            return false;
        }
        boolean zM588c = m588c();
        boolean zM588c2 = ivVar.m588c();
        if ((zM588c || zM588c2) && !(zM588c && zM588c2 && this.f804b.equals(ivVar.f804b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ivVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f806c.equals(ivVar.f806c))) || this.f796a != ivVar.f796a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ivVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f807d.equals(ivVar.f807d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ivVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f808e.equals(ivVar.f808e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ivVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f809f.equals(ivVar.f809f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ivVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f810g.equals(ivVar.f810g))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ivVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f803b == ivVar.f803b)) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = ivVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f811h.equals(ivVar.f811h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = ivVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f812i.equals(ivVar.f812i))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = ivVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f805c == ivVar.f805c)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = ivVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f813j.equals(ivVar.f813j))) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = ivVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f795a == ivVar.f795a)) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = ivVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f814k.equals(ivVar.f814k))) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = ivVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f802b == ivVar.f802b)) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = ivVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f815l.equals(ivVar.f815l))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = ivVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f801a == ivVar.f801a)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = ivVar.t();
        if (zT || zT2) {
            return zT && zT2 && this.f800a.equals(ivVar.f800a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iv ivVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iA13;
        int iA14;
        int iA15;
        int iA16;
        int iA17;
        int iA18;
        int iA19;
        int iA20;
        if (!getClass().equals(ivVar.getClass())) {
            return getClass().getName().compareTo(ivVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m585a()).compareTo(Boolean.valueOf(ivVar.m585a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m585a() && (iA20 = jg.a(this.f798a, ivVar.f798a)) != 0) {
            return iA20;
        }
        int iCompareTo2 = Boolean.valueOf(m587b()).compareTo(Boolean.valueOf(ivVar.m587b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m587b() && (iA19 = jg.a(this.f797a, ivVar.f797a)) != 0) {
            return iA19;
        }
        int iCompareTo3 = Boolean.valueOf(m588c()).compareTo(Boolean.valueOf(ivVar.m588c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m588c() && (iA18 = jg.a(this.f804b, ivVar.f804b)) != 0) {
            return iA18;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA17 = jg.a(this.f806c, ivVar.f806c)) != 0) {
            return iA17;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA16 = jg.a(this.f796a, ivVar.f796a)) != 0) {
            return iA16;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA15 = jg.a(this.f807d, ivVar.f807d)) != 0) {
            return iA15;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA14 = jg.a(this.f808e, ivVar.f808e)) != 0) {
            return iA14;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA13 = jg.a(this.f809f, ivVar.f809f)) != 0) {
            return iA13;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA12 = jg.a(this.f810g, ivVar.f810g)) != 0) {
            return iA12;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ivVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA11 = jg.a(this.f803b, ivVar.f803b)) != 0) {
            return iA11;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ivVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA10 = jg.a(this.f811h, ivVar.f811h)) != 0) {
            return iA10;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ivVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA9 = jg.a(this.f812i, ivVar.f812i)) != 0) {
            return iA9;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ivVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA8 = jg.a(this.f805c, ivVar.f805c)) != 0) {
            return iA8;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ivVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA7 = jg.a(this.f813j, ivVar.f813j)) != 0) {
            return iA7;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ivVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA6 = jg.a(this.f795a, ivVar.f795a)) != 0) {
            return iA6;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ivVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA5 = jg.a(this.f814k, ivVar.f814k)) != 0) {
            return iA5;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ivVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA4 = jg.a(this.f802b, ivVar.f802b)) != 0) {
            return iA4;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ivVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA3 = jg.a(this.f815l, ivVar.f815l)) != 0) {
            return iA3;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ivVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA2 = jg.a(this.f801a, ivVar.f801a)) != 0) {
            return iA2;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ivVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (!t() || (iA = jg.a(this.f800a, ivVar.f800a)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.jf
    public void a(jp jpVar) throws jq {
        jpVar.mo637a();
        while (true) {
            jm jmVarMo633a = jpVar.mo633a();
            byte b9 = jmVarMo633a.f18102a;
            if (b9 == 0) {
                jpVar.f();
                if (e()) {
                    m584a();
                    return;
                }
                throw new jq("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f798a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f797a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f804b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f806c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                default:
                    js.a(jpVar, b9);
                    break;
                case 6:
                    if (b9 == 10) {
                        this.f796a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f807d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f808e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f809f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 11) {
                        this.f810g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 10) {
                        this.f803b = jpVar.mo632a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 12:
                    if (b9 == 11) {
                        this.f811h = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 13:
                    if (b9 == 11) {
                        this.f812i = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 14:
                    if (b9 == 10) {
                        this.f805c = jpVar.mo632a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 15:
                    if (b9 == 11) {
                        this.f813j = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 16:
                    if (b9 == 8) {
                        this.f795a = jpVar.mo631a();
                        d(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 17:
                    if (b9 == 11) {
                        this.f814k = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 18:
                    if (b9 == 8) {
                        this.f802b = jpVar.mo631a();
                        e(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 19:
                    if (b9 == 11) {
                        this.f815l = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 20:
                    if (b9 == 2) {
                        this.f801a = jpVar.mo643a();
                        f(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 21:
                    if (b9 == 15) {
                        jn jnVarMo634a = jpVar.mo634a();
                        this.f800a = new ArrayList(jnVarMo634a.f917a);
                        for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                            this.f800a.add(jpVar.mo638a());
                        }
                        jpVar.i();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m584a() throws jq {
        if (this.f804b != null) {
            if (this.f806c != null) {
                return;
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
