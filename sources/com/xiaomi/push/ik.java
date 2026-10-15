package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ik implements jf<ik, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ix f670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public short f674a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f676b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public short f677b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f678c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f679d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f680e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f681f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f682g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f683h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f684i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f685j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f686k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f687l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f666a = new ju("XmPushActionAckMessage");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17892a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17893b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17894c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17895d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17896e = new jm("", (byte) 10, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17897f = new jm("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17898g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17899h = new jm("", (byte) 12, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17900i = new jm("", (byte) 11, 9);
    private static final jm j = new jm("", (byte) 11, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f17901k = new jm("", (byte) 2, 11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final jm f17902l = new jm("", (byte) 11, 12);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final jm f17903m = new jm("", (byte) 11, 13);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final jm f17904n = new jm("", (byte) 11, 14);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final jm f17905o = new jm("", (byte) 6, 15);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final jm f17906p = new jm("", (byte) 6, 16);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final jm f17907q = new jm("", (byte) 11, 20);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final jm f17908r = new jm("", (byte) 11, 21);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final jm f17909s = new jm("", (byte) 8, 22);
    private static final jm t = new jm("", (byte) 13, 23);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f672a = new BitSet(5);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f675a = false;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m531a() {
        return this.f671a != null;
    }

    public boolean b() {
        return this.f669a != null;
    }

    public boolean c() {
        return this.f676b != null;
    }

    public boolean d() {
        return this.f678c != null;
    }

    public boolean e() {
        return this.f672a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m532a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f679d != null;
    }

    public boolean g() {
        return this.f680e != null;
    }

    public boolean h() {
        return this.f670a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f681f != null;
    }

    public boolean j() {
        return this.f682g != null;
    }

    public boolean k() {
        return this.f672a.get(1);
    }

    public boolean l() {
        return this.f683h != null;
    }

    public boolean m() {
        return this.f684i != null;
    }

    public boolean n() {
        return this.f685j != null;
    }

    public boolean o() {
        return this.f672a.get(2);
    }

    public boolean p() {
        return this.f672a.get(3);
    }

    public boolean q() {
        return this.f686k != null;
    }

    public boolean r() {
        return this.f687l != null;
    }

    public boolean s() {
        return this.f672a.get(4);
    }

    public boolean t() {
        return this.f673a != null;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z9 = false;
        if (m531a()) {
            sb.append("debug:");
            String str = this.f671a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("target:");
            ij ijVar = this.f669a;
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
        String str2 = this.f676b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f678c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f668a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f679d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f680e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            ix ixVar = this.f670a;
            if (ixVar == null) {
                sb.append("null");
            } else {
                sb.append(ixVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f681f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f682g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f675a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f683h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f684i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f685j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f674a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f677b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f686k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f687l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f667a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f673a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public ik a(String str) {
        this.f676b = str;
        return this;
    }

    public ik b(String str) {
        this.f678c = str;
        return this;
    }

    public ik c(String str) {
        this.f679d = str;
        return this;
    }

    public ik d(String str) {
        this.f680e = str;
        return this;
    }

    public void e(boolean z8) {
        this.f672a.set(4, z8);
    }

    public ik a(long j8) {
        this.f668a = j8;
        a(true);
        return this;
    }

    public void b(boolean z8) {
        this.f672a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f672a.set(2, z8);
    }

    public void d(boolean z8) {
        this.f672a.set(3, z8);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        a();
        jpVar.a(f666a);
        if (this.f671a != null && m531a()) {
            jpVar.a(f17892a);
            jpVar.a(this.f671a);
            jpVar.b();
        }
        if (this.f669a != null && b()) {
            jpVar.a(f17893b);
            this.f669a.b(jpVar);
            jpVar.b();
        }
        if (this.f676b != null) {
            jpVar.a(f17894c);
            jpVar.a(this.f676b);
            jpVar.b();
        }
        if (this.f678c != null) {
            jpVar.a(f17895d);
            jpVar.a(this.f678c);
            jpVar.b();
        }
        jpVar.a(f17896e);
        jpVar.a(this.f668a);
        jpVar.b();
        if (this.f679d != null && f()) {
            jpVar.a(f17897f);
            jpVar.a(this.f679d);
            jpVar.b();
        }
        if (this.f680e != null && g()) {
            jpVar.a(f17898g);
            jpVar.a(this.f680e);
            jpVar.b();
        }
        if (this.f670a != null && h()) {
            jpVar.a(f17899h);
            this.f670a.b(jpVar);
            jpVar.b();
        }
        if (this.f681f != null && i()) {
            jpVar.a(f17900i);
            jpVar.a(this.f681f);
            jpVar.b();
        }
        if (this.f682g != null && j()) {
            jpVar.a(j);
            jpVar.a(this.f682g);
            jpVar.b();
        }
        if (k()) {
            jpVar.a(f17901k);
            jpVar.a(this.f675a);
            jpVar.b();
        }
        if (this.f683h != null && l()) {
            jpVar.a(f17902l);
            jpVar.a(this.f683h);
            jpVar.b();
        }
        if (this.f684i != null && m()) {
            jpVar.a(f17903m);
            jpVar.a(this.f684i);
            jpVar.b();
        }
        if (this.f685j != null && n()) {
            jpVar.a(f17904n);
            jpVar.a(this.f685j);
            jpVar.b();
        }
        if (o()) {
            jpVar.a(f17905o);
            jpVar.a(this.f674a);
            jpVar.b();
        }
        if (p()) {
            jpVar.a(f17906p);
            jpVar.a(this.f677b);
            jpVar.b();
        }
        if (this.f686k != null && q()) {
            jpVar.a(f17907q);
            jpVar.a(this.f686k);
            jpVar.b();
        }
        if (this.f687l != null && r()) {
            jpVar.a(f17908r);
            jpVar.a(this.f687l);
            jpVar.b();
        }
        if (s()) {
            jpVar.a(f17909s);
            jpVar.mo642a(this.f667a);
            jpVar.b();
        }
        if (this.f673a != null && t()) {
            jpVar.a(t);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f673a.size()));
            for (Map.Entry<String, String> entry : this.f673a.entrySet()) {
                jpVar.a(entry.getKey());
                jpVar.a(entry.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public void a(boolean z8) {
        this.f672a.set(0, z8);
    }

    public ik a(short s8) {
        this.f674a = s8;
        c(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m532a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean zM531a = m531a();
        boolean zM531a2 = ikVar.m531a();
        if ((zM531a || zM531a2) && !(zM531a && zM531a2 && this.f671a.equals(ikVar.f671a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = ikVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f669a.m530a(ikVar.f669a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = ikVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f676b.equals(ikVar.f676b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ikVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f678c.equals(ikVar.f678c))) || this.f668a != ikVar.f668a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ikVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f679d.equals(ikVar.f679d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ikVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f680e.equals(ikVar.f680e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ikVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f670a.m594a(ikVar.f670a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ikVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f681f.equals(ikVar.f681f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ikVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f682g.equals(ikVar.f682g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = ikVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f675a == ikVar.f675a)) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = ikVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f683h.equals(ikVar.f683h))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = ikVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f684i.equals(ikVar.f684i))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = ikVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f685j.equals(ikVar.f685j))) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = ikVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f674a == ikVar.f674a)) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = ikVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f677b == ikVar.f677b)) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = ikVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f686k.equals(ikVar.f686k))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = ikVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f687l.equals(ikVar.f687l))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = ikVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f667a == ikVar.f667a)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = ikVar.t();
        if (zT || zT2) {
            return zT && zT2 && this.f673a.equals(ikVar.f673a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ik ikVar) {
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
        if (!getClass().equals(ikVar.getClass())) {
            return getClass().getName().compareTo(ikVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m531a()).compareTo(Boolean.valueOf(ikVar.m531a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m531a() && (iA20 = jg.a(this.f671a, ikVar.f671a)) != 0) {
            return iA20;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA19 = jg.a(this.f669a, ikVar.f669a)) != 0) {
            return iA19;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA18 = jg.a(this.f676b, ikVar.f676b)) != 0) {
            return iA18;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA17 = jg.a(this.f678c, ikVar.f678c)) != 0) {
            return iA17;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA16 = jg.a(this.f668a, ikVar.f668a)) != 0) {
            return iA16;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA15 = jg.a(this.f679d, ikVar.f679d)) != 0) {
            return iA15;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA14 = jg.a(this.f680e, ikVar.f680e)) != 0) {
            return iA14;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA13 = jg.a(this.f670a, ikVar.f670a)) != 0) {
            return iA13;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA12 = jg.a(this.f681f, ikVar.f681f)) != 0) {
            return iA12;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ikVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA11 = jg.a(this.f682g, ikVar.f682g)) != 0) {
            return iA11;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ikVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA10 = jg.a(this.f675a, ikVar.f675a)) != 0) {
            return iA10;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ikVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA9 = jg.a(this.f683h, ikVar.f683h)) != 0) {
            return iA9;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ikVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA8 = jg.a(this.f684i, ikVar.f684i)) != 0) {
            return iA8;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ikVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA7 = jg.a(this.f685j, ikVar.f685j)) != 0) {
            return iA7;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ikVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA6 = jg.a(this.f674a, ikVar.f674a)) != 0) {
            return iA6;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ikVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA5 = jg.a(this.f677b, ikVar.f677b)) != 0) {
            return iA5;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ikVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA4 = jg.a(this.f686k, ikVar.f686k)) != 0) {
            return iA4;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ikVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA3 = jg.a(this.f687l, ikVar.f687l)) != 0) {
            return iA3;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ikVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA2 = jg.a(this.f667a, ikVar.f667a)) != 0) {
            return iA2;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ikVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (!t() || (iA = jg.a(this.f673a, ikVar.f673a)) == 0) {
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
                    a();
                    return;
                }
                throw new jq("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f671a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f669a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f676b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f678c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 10) {
                        this.f668a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 11) {
                        this.f679d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f680e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 12) {
                        ix ixVar = new ix();
                        this.f670a = ixVar;
                        ixVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f681f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 11) {
                        this.f682g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 2) {
                        this.f675a = jpVar.mo643a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 12:
                    if (b9 == 11) {
                        this.f683h = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 13:
                    if (b9 == 11) {
                        this.f684i = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 14:
                    if (b9 == 11) {
                        this.f685j = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 15:
                    if (b9 == 6) {
                        this.f674a = jpVar.mo640a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 16:
                    if (b9 == 6) {
                        this.f677b = jpVar.mo640a();
                        d(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 17:
                case 18:
                case 19:
                default:
                    js.a(jpVar, b9);
                    break;
                case 20:
                    if (b9 == 11) {
                        this.f686k = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 21:
                    if (b9 == 11) {
                        this.f687l = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 22:
                    if (b9 == 8) {
                        this.f667a = jpVar.mo631a();
                        e(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 23:
                    if (b9 == 13) {
                        jo joVarMo635a = jpVar.mo635a();
                        this.f673a = new HashMap(joVarMo635a.f918a * 2);
                        for (int i9 = 0; i9 < joVarMo635a.f918a; i9++) {
                            this.f673a.put(jpVar.mo638a(), jpVar.mo638a());
                        }
                        jpVar.h();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    public void a() throws jq {
        if (this.f676b != null) {
            if (this.f678c != null) {
                return;
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
