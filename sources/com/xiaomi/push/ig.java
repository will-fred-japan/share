package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class ig implements jf<ig, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ih f623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f626a = new BitSet(4);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f627a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f628b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f629b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f630c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f631c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f632d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f633e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f634f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f635g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f636h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f637i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f638j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f639k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f640l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f621a = new ju("PushMessage");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17854a = new jm("", (byte) 12, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17855b = new jm("", (byte) 11, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17856c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17857d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17858e = new jm("", (byte) 10, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17859f = new jm("", (byte) 10, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17860g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17861h = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17862i = new jm("", (byte) 11, 9);
    private static final jm j = new jm("", (byte) 11, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f17863k = new jm("", (byte) 11, 11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final jm f17864l = new jm("", (byte) 12, 12);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final jm f17865m = new jm("", (byte) 11, 13);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final jm f17866n = new jm("", (byte) 2, 14);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final jm f17867o = new jm("", (byte) 11, 15);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final jm f17868p = new jm("", (byte) 10, 16);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final jm f17869q = new jm("", (byte) 11, 20);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final jm f17870r = new jm("", (byte) 11, 21);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m512a() {
        return this.f624a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m514b() {
        return this.f625a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m515c() {
        return this.f629b != null;
    }

    public boolean d() {
        return this.f631c != null;
    }

    public boolean e() {
        return this.f626a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m513a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f626a.get(1);
    }

    public boolean g() {
        return this.f632d != null;
    }

    public boolean h() {
        return this.f633e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f634f != null;
    }

    public boolean j() {
        return this.f635g != null;
    }

    public boolean k() {
        return this.f636h != null;
    }

    public boolean l() {
        return this.f623a != null;
    }

    public boolean m() {
        return this.f637i != null;
    }

    public boolean n() {
        return this.f626a.get(2);
    }

    public boolean o() {
        return this.f638j != null;
    }

    public boolean p() {
        return this.f626a.get(3);
    }

    public boolean q() {
        return this.f639k != null;
    }

    public boolean r() {
        return this.f640l != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m512a()) {
            sb.append("to:");
            ij ijVar = this.f624a;
            if (ijVar == null) {
                sb.append("null");
            } else {
                sb.append(ijVar);
            }
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f625a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f629b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f631c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f622a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f628b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f632d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f633e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f634f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f635g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f636h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            ih ihVar = this.f623a;
            if (ihVar == null) {
                sb.append("null");
            } else {
                sb.append(ihVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f637i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f627a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f638j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f630c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f639k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f640l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m510a() {
        return this.f625a;
    }

    public String b() {
        return this.f629b;
    }

    public String c() {
        return this.f631c;
    }

    public void d(boolean z8) {
        this.f626a.set(3, z8);
    }

    public long a() {
        return this.f622a;
    }

    public void b(boolean z8) {
        this.f626a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f626a.set(2, z8);
    }

    public void a(boolean z8) {
        this.f626a.set(0, z8);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m511a();
        jpVar.a(f621a);
        if (this.f624a != null && m512a()) {
            jpVar.a(f17854a);
            this.f624a.b(jpVar);
            jpVar.b();
        }
        if (this.f625a != null) {
            jpVar.a(f17855b);
            jpVar.a(this.f625a);
            jpVar.b();
        }
        if (this.f629b != null) {
            jpVar.a(f17856c);
            jpVar.a(this.f629b);
            jpVar.b();
        }
        if (this.f631c != null) {
            jpVar.a(f17857d);
            jpVar.a(this.f631c);
            jpVar.b();
        }
        if (e()) {
            jpVar.a(f17858e);
            jpVar.a(this.f622a);
            jpVar.b();
        }
        if (f()) {
            jpVar.a(f17859f);
            jpVar.a(this.f628b);
            jpVar.b();
        }
        if (this.f632d != null && g()) {
            jpVar.a(f17860g);
            jpVar.a(this.f632d);
            jpVar.b();
        }
        if (this.f633e != null && h()) {
            jpVar.a(f17861h);
            jpVar.a(this.f633e);
            jpVar.b();
        }
        if (this.f634f != null && i()) {
            jpVar.a(f17862i);
            jpVar.a(this.f634f);
            jpVar.b();
        }
        if (this.f635g != null && j()) {
            jpVar.a(j);
            jpVar.a(this.f635g);
            jpVar.b();
        }
        if (this.f636h != null && k()) {
            jpVar.a(f17863k);
            jpVar.a(this.f636h);
            jpVar.b();
        }
        if (this.f623a != null && l()) {
            jpVar.a(f17864l);
            this.f623a.b(jpVar);
            jpVar.b();
        }
        if (this.f637i != null && m()) {
            jpVar.a(f17865m);
            jpVar.a(this.f637i);
            jpVar.b();
        }
        if (n()) {
            jpVar.a(f17866n);
            jpVar.a(this.f627a);
            jpVar.b();
        }
        if (this.f638j != null && o()) {
            jpVar.a(f17867o);
            jpVar.a(this.f638j);
            jpVar.b();
        }
        if (p()) {
            jpVar.a(f17868p);
            jpVar.a(this.f630c);
            jpVar.b();
        }
        if (this.f639k != null && q()) {
            jpVar.a(f17869q);
            jpVar.a(this.f639k);
            jpVar.b();
        }
        if (this.f640l != null && r()) {
            jpVar.a(f17870r);
            jpVar.a(this.f640l);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m513a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean zM512a = m512a();
        boolean zM512a2 = igVar.m512a();
        if ((zM512a || zM512a2) && !(zM512a && zM512a2 && this.f624a.m530a(igVar.f624a))) {
            return false;
        }
        boolean zM514b = m514b();
        boolean zM514b2 = igVar.m514b();
        if ((zM514b || zM514b2) && !(zM514b && zM514b2 && this.f625a.equals(igVar.f625a))) {
            return false;
        }
        boolean zM515c = m515c();
        boolean zM515c2 = igVar.m515c();
        if ((zM515c || zM515c2) && !(zM515c && zM515c2 && this.f629b.equals(igVar.f629b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = igVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f631c.equals(igVar.f631c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = igVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f622a == igVar.f622a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = igVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f628b == igVar.f628b)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = igVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f632d.equals(igVar.f632d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = igVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f633e.equals(igVar.f633e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = igVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f634f.equals(igVar.f634f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = igVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f635g.equals(igVar.f635g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = igVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f636h.equals(igVar.f636h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = igVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f623a.m522a(igVar.f623a))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = igVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f637i.equals(igVar.f637i))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = igVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f627a == igVar.f627a)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = igVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f638j.equals(igVar.f638j))) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = igVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f630c == igVar.f630c)) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = igVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f639k.equals(igVar.f639k))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = igVar.r();
        if (zR || zR2) {
            return zR && zR2 && this.f640l.equals(igVar.f640l);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ig igVar) {
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
        if (!getClass().equals(igVar.getClass())) {
            return getClass().getName().compareTo(igVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m512a()).compareTo(Boolean.valueOf(igVar.m512a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m512a() && (iA18 = jg.a(this.f624a, igVar.f624a)) != 0) {
            return iA18;
        }
        int iCompareTo2 = Boolean.valueOf(m514b()).compareTo(Boolean.valueOf(igVar.m514b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m514b() && (iA17 = jg.a(this.f625a, igVar.f625a)) != 0) {
            return iA17;
        }
        int iCompareTo3 = Boolean.valueOf(m515c()).compareTo(Boolean.valueOf(igVar.m515c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m515c() && (iA16 = jg.a(this.f629b, igVar.f629b)) != 0) {
            return iA16;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA15 = jg.a(this.f631c, igVar.f631c)) != 0) {
            return iA15;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA14 = jg.a(this.f622a, igVar.f622a)) != 0) {
            return iA14;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA13 = jg.a(this.f628b, igVar.f628b)) != 0) {
            return iA13;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA12 = jg.a(this.f632d, igVar.f632d)) != 0) {
            return iA12;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA11 = jg.a(this.f633e, igVar.f633e)) != 0) {
            return iA11;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA10 = jg.a(this.f634f, igVar.f634f)) != 0) {
            return iA10;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA9 = jg.a(this.f635g, igVar.f635g)) != 0) {
            return iA9;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA8 = jg.a(this.f636h, igVar.f636h)) != 0) {
            return iA8;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA7 = jg.a(this.f623a, igVar.f623a)) != 0) {
            return iA7;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA6 = jg.a(this.f637i, igVar.f637i)) != 0) {
            return iA6;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA5 = jg.a(this.f627a, igVar.f627a)) != 0) {
            return iA5;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA4 = jg.a(this.f638j, igVar.f638j)) != 0) {
            return iA4;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA3 = jg.a(this.f630c, igVar.f630c)) != 0) {
            return iA3;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA2 = jg.a(this.f639k, igVar.f639k)) != 0) {
            return iA2;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (!r() || (iA = jg.a(this.f640l, igVar.f640l)) == 0) {
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
                m511a();
                return;
            }
            short s8 = jmVarMo633a.f916a;
            if (s8 != 20) {
                if (s8 != 21) {
                    switch (s8) {
                        case 1:
                            if (b9 == 12) {
                                ij ijVar = new ij();
                                this.f624a = ijVar;
                                ijVar.a(jpVar);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 2:
                            if (b9 == 11) {
                                this.f625a = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 3:
                            if (b9 == 11) {
                                this.f629b = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 4:
                            if (b9 == 11) {
                                this.f631c = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 5:
                            if (b9 == 10) {
                                this.f622a = jpVar.mo632a();
                                a(true);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 6:
                            if (b9 == 10) {
                                this.f628b = jpVar.mo632a();
                                b(true);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 7:
                            if (b9 == 11) {
                                this.f632d = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 8:
                            if (b9 == 11) {
                                this.f633e = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 9:
                            if (b9 == 11) {
                                this.f634f = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 10:
                            if (b9 == 11) {
                                this.f635g = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 11:
                            if (b9 == 11) {
                                this.f636h = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 12:
                            if (b9 == 12) {
                                ih ihVar = new ih();
                                this.f623a = ihVar;
                                ihVar.a(jpVar);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 13:
                            if (b9 == 11) {
                                this.f637i = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 14:
                            if (b9 == 2) {
                                this.f627a = jpVar.mo643a();
                                c(true);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 15:
                            if (b9 == 11) {
                                this.f638j = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 16:
                            if (b9 == 10) {
                                this.f630c = jpVar.mo632a();
                                d(true);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        default:
                            js.a(jpVar, b9);
                            break;
                    }
                } else if (b9 == 11) {
                    this.f640l = jpVar.mo638a();
                } else {
                    js.a(jpVar, b9);
                }
            } else if (b9 == 11) {
                this.f639k = jpVar.mo638a();
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m511a() throws jq {
        if (this.f625a != null) {
            if (this.f629b != null) {
                if (this.f631c != null) {
                    return;
                }
                throw new jq("Required field 'payload' was not present! Struct: " + toString());
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
