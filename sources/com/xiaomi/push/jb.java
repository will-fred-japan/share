package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class jb implements jf<jb, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f879a = new BitSet(3);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f880b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f881b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f882c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f883c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f884d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f885e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f875a = new ju("XmPushActionUnRegistrationResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f18063a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f18064b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f18065c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f18066d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f18067e = new jm("", (byte) 10, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f18068f = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f18069g = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f18070h = new jm("", (byte) 10, 9);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f18071i = new jm("", (byte) 10, 10);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m617a() {
        return this.f878a != null;
    }

    public boolean b() {
        return this.f877a != null;
    }

    public boolean c() {
        return this.f881b != null;
    }

    public boolean d() {
        return this.f883c != null;
    }

    public boolean e() {
        return this.f879a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof jb)) {
            return m618a((jb) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f884d != null;
    }

    public boolean g() {
        return this.f885e != null;
    }

    public boolean h() {
        return this.f879a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f879a.get(2);
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z9 = false;
        if (m617a()) {
            sb.append("debug:");
            String str = this.f878a;
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
            ij ijVar = this.f877a;
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
        String str2 = this.f881b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f883c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f876a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f884d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f885e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f880b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f882c);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z8) {
        this.f879a.set(0, z8);
    }

    public void b(boolean z8) {
        this.f879a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f879a.set(2, z8);
    }

    public String a() {
        return this.f885e;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m616a();
        jpVar.a(f875a);
        if (this.f878a != null && m617a()) {
            jpVar.a(f18063a);
            jpVar.a(this.f878a);
            jpVar.b();
        }
        if (this.f877a != null && b()) {
            jpVar.a(f18064b);
            this.f877a.b(jpVar);
            jpVar.b();
        }
        if (this.f881b != null) {
            jpVar.a(f18065c);
            jpVar.a(this.f881b);
            jpVar.b();
        }
        if (this.f883c != null) {
            jpVar.a(f18066d);
            jpVar.a(this.f883c);
            jpVar.b();
        }
        jpVar.a(f18067e);
        jpVar.a(this.f876a);
        jpVar.b();
        if (this.f884d != null && f()) {
            jpVar.a(f18068f);
            jpVar.a(this.f884d);
            jpVar.b();
        }
        if (this.f885e != null && g()) {
            jpVar.a(f18069g);
            jpVar.a(this.f885e);
            jpVar.b();
        }
        if (h()) {
            jpVar.a(f18070h);
            jpVar.a(this.f880b);
            jpVar.b();
        }
        if (i()) {
            jpVar.a(f18071i);
            jpVar.a(this.f882c);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m618a(jb jbVar) {
        if (jbVar == null) {
            return false;
        }
        boolean zM617a = m617a();
        boolean zM617a2 = jbVar.m617a();
        if ((zM617a || zM617a2) && !(zM617a && zM617a2 && this.f878a.equals(jbVar.f878a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = jbVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f877a.m530a(jbVar.f877a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = jbVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f881b.equals(jbVar.f881b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = jbVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f883c.equals(jbVar.f883c))) || this.f876a != jbVar.f876a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = jbVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f884d.equals(jbVar.f884d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = jbVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f885e.equals(jbVar.f885e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = jbVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f880b == jbVar.f880b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = jbVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f882c == jbVar.f882c;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(jb jbVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(jbVar.getClass())) {
            return getClass().getName().compareTo(jbVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m617a()).compareTo(Boolean.valueOf(jbVar.m617a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m617a() && (iA9 = jg.a(this.f878a, jbVar.f878a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(jbVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA8 = jg.a(this.f877a, jbVar.f877a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(jbVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA7 = jg.a(this.f881b, jbVar.f881b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(jbVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = jg.a(this.f883c, jbVar.f883c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(jbVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = jg.a(this.f876a, jbVar.f876a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(jbVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = jg.a(this.f884d, jbVar.f884d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(jbVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = jg.a(this.f885e, jbVar.f885e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(jbVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = jg.a(this.f880b, jbVar.f880b)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(jbVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = jg.a(this.f882c, jbVar.f882c)) == 0) {
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
                    m616a();
                    return;
                }
                throw new jq("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f878a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f877a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f881b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f883c = jpVar.mo638a();
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
                        this.f876a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f884d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f885e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 10) {
                        this.f880b = jpVar.mo632a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 10) {
                        this.f882c = jpVar.mo632a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m616a() throws jq {
        if (this.f881b != null) {
            if (this.f883c != null) {
                return;
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
