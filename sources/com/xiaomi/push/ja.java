package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class ja implements jf<ja, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f865a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f866a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f867b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f868c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f869d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f870e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f871f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f872g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f873h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f874i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f861a = new ju("XmPushActionUnRegistration");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f18052a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f18053b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f18054c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f18055d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f18056e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f18057f = new jm("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f18058g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f18059h = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f18060i = new jm("", (byte) 11, 9);
    private static final jm j = new jm("", (byte) 11, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f18061k = new jm("", (byte) 2, 11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final jm f18062l = new jm("", (byte) 10, 12);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m614a() {
        return this.f864a != null;
    }

    public boolean b() {
        return this.f863a != null;
    }

    public boolean c() {
        return this.f867b != null;
    }

    public boolean d() {
        return this.f868c != null;
    }

    public boolean e() {
        return this.f869d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ja)) {
            return m615a((ja) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f870e != null;
    }

    public boolean g() {
        return this.f871f != null;
    }

    public boolean h() {
        return this.f872g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f873h != null;
    }

    public boolean j() {
        return this.f874i != null;
    }

    public boolean k() {
        return this.f865a.get(0);
    }

    public boolean l() {
        return this.f865a.get(1);
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z9 = false;
        if (m614a()) {
            sb.append("debug:");
            String str = this.f864a;
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
            ij ijVar = this.f863a;
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
        String str2 = this.f867b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f868c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f869d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f870e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f871f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f872g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f873h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f874i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f866a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f862a);
        }
        sb.append(")");
        return sb.toString();
    }

    public ja a(String str) {
        this.f867b = str;
        return this;
    }

    public ja b(String str) {
        this.f868c = str;
        return this;
    }

    public ja c(String str) {
        this.f869d = str;
        return this;
    }

    public ja d(String str) {
        this.f871f = str;
        return this;
    }

    public ja e(String str) {
        this.f872g = str;
        return this;
    }

    public void a(boolean z8) {
        this.f865a.set(0, z8);
    }

    public void b(boolean z8) {
        this.f865a.set(1, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m615a(ja jaVar) {
        if (jaVar == null) {
            return false;
        }
        boolean zM614a = m614a();
        boolean zM614a2 = jaVar.m614a();
        if ((zM614a || zM614a2) && !(zM614a && zM614a2 && this.f864a.equals(jaVar.f864a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = jaVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f863a.m530a(jaVar.f863a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = jaVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f867b.equals(jaVar.f867b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = jaVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f868c.equals(jaVar.f868c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = jaVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f869d.equals(jaVar.f869d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = jaVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f870e.equals(jaVar.f870e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = jaVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f871f.equals(jaVar.f871f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = jaVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f872g.equals(jaVar.f872g))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = jaVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f873h.equals(jaVar.f873h))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = jaVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f874i.equals(jaVar.f874i))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = jaVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f866a == jaVar.f866a)) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = jaVar.l();
        if (zL || zL2) {
            return zL && zL2 && this.f862a == jaVar.f862a;
        }
        return true;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        a();
        jpVar.a(f861a);
        if (this.f864a != null && m614a()) {
            jpVar.a(f18052a);
            jpVar.a(this.f864a);
            jpVar.b();
        }
        if (this.f863a != null && b()) {
            jpVar.a(f18053b);
            this.f863a.b(jpVar);
            jpVar.b();
        }
        if (this.f867b != null) {
            jpVar.a(f18054c);
            jpVar.a(this.f867b);
            jpVar.b();
        }
        if (this.f868c != null) {
            jpVar.a(f18055d);
            jpVar.a(this.f868c);
            jpVar.b();
        }
        if (this.f869d != null && e()) {
            jpVar.a(f18056e);
            jpVar.a(this.f869d);
            jpVar.b();
        }
        if (this.f870e != null && f()) {
            jpVar.a(f18057f);
            jpVar.a(this.f870e);
            jpVar.b();
        }
        if (this.f871f != null && g()) {
            jpVar.a(f18058g);
            jpVar.a(this.f871f);
            jpVar.b();
        }
        if (this.f872g != null && h()) {
            jpVar.a(f18059h);
            jpVar.a(this.f872g);
            jpVar.b();
        }
        if (this.f873h != null && i()) {
            jpVar.a(f18060i);
            jpVar.a(this.f873h);
            jpVar.b();
        }
        if (this.f874i != null && j()) {
            jpVar.a(j);
            jpVar.a(this.f874i);
            jpVar.b();
        }
        if (k()) {
            jpVar.a(f18061k);
            jpVar.a(this.f866a);
            jpVar.b();
        }
        if (l()) {
            jpVar.a(f18062l);
            jpVar.a(this.f862a);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ja jaVar) {
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
        if (!getClass().equals(jaVar.getClass())) {
            return getClass().getName().compareTo(jaVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m614a()).compareTo(Boolean.valueOf(jaVar.m614a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m614a() && (iA12 = jg.a(this.f864a, jaVar.f864a)) != 0) {
            return iA12;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(jaVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA11 = jg.a(this.f863a, jaVar.f863a)) != 0) {
            return iA11;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(jaVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA10 = jg.a(this.f867b, jaVar.f867b)) != 0) {
            return iA10;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(jaVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA9 = jg.a(this.f868c, jaVar.f868c)) != 0) {
            return iA9;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(jaVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA8 = jg.a(this.f869d, jaVar.f869d)) != 0) {
            return iA8;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(jaVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA7 = jg.a(this.f870e, jaVar.f870e)) != 0) {
            return iA7;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(jaVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA6 = jg.a(this.f871f, jaVar.f871f)) != 0) {
            return iA6;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(jaVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA5 = jg.a(this.f872g, jaVar.f872g)) != 0) {
            return iA5;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(jaVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA4 = jg.a(this.f873h, jaVar.f873h)) != 0) {
            return iA4;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(jaVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA3 = jg.a(this.f874i, jaVar.f874i)) != 0) {
            return iA3;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(jaVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA2 = jg.a(this.f866a, jaVar.f866a)) != 0) {
            return iA2;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(jaVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (!l() || (iA = jg.a(this.f862a, jaVar.f862a)) == 0) {
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
                a();
                return;
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f864a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f863a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f867b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f868c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f869d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 11) {
                        this.f870e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f871f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f872g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f873h = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 11) {
                        this.f874i = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 2) {
                        this.f866a = jpVar.mo643a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 12:
                    if (b9 == 10) {
                        this.f862a = jpVar.mo632a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                default:
                    js.a(jpVar, b9);
                    break;
            }
            jpVar.g();
        }
    }

    public void a() throws jq {
        if (this.f867b != null) {
            if (this.f868c != null) {
                return;
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
