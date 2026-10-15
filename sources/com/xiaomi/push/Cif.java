package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: renamed from: com.xiaomi.push.if, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public class Cif implements jf<Cif, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f616a = new BitSet(6);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f617a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f618b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f619b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f620c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f612a = new ju("OnlineConfigItem");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17847a = new jm("", (byte) 8, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17848b = new jm("", (byte) 8, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17849c = new jm("", (byte) 2, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17850d = new jm("", (byte) 8, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17851e = new jm("", (byte) 10, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17852f = new jm("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17853g = new jm("", (byte) 2, 7);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m505a() {
    }

    public int b() {
        return this.f618b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m509c() {
        return this.f616a.get(2);
    }

    public boolean d() {
        return this.f616a.get(3);
    }

    public boolean e() {
        return this.f616a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m507a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f615a != null;
    }

    public boolean g() {
        return this.f619b;
    }

    public boolean h() {
        return this.f616a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z9 = false;
        if (m506a()) {
            sb.append("key:");
            sb.append(this.f613a);
            z8 = false;
        } else {
            z8 = true;
        }
        if (m508b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f618b);
            z8 = false;
        }
        if (m509c()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f617a);
            z8 = false;
        }
        if (d()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f620c);
            z8 = false;
        }
        if (e()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f614a);
            z8 = false;
        }
        if (f()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f615a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        } else {
            z9 = z8;
        }
        if (h()) {
            if (!z9) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f619b);
        }
        sb.append(")");
        return sb.toString();
    }

    public int a() {
        return this.f613a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m508b() {
        return this.f616a.get(1);
    }

    public void c(boolean z8) {
        this.f616a.set(2, z8);
    }

    public void d(boolean z8) {
        this.f616a.set(3, z8);
    }

    public void e(boolean z8) {
        this.f616a.set(4, z8);
    }

    public void f(boolean z8) {
        this.f616a.set(5, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m506a() {
        return this.f616a.get(0);
    }

    public void b(boolean z8) {
        this.f616a.set(1, z8);
    }

    public int c() {
        return this.f620c;
    }

    public void a(boolean z8) {
        this.f616a.set(0, z8);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) {
        m505a();
        jpVar.a(f612a);
        if (m506a()) {
            jpVar.a(f17847a);
            jpVar.mo642a(this.f613a);
            jpVar.b();
        }
        if (m508b()) {
            jpVar.a(f17848b);
            jpVar.mo642a(this.f618b);
            jpVar.b();
        }
        if (m509c()) {
            jpVar.a(f17849c);
            jpVar.a(this.f617a);
            jpVar.b();
        }
        if (d()) {
            jpVar.a(f17850d);
            jpVar.mo642a(this.f620c);
            jpVar.b();
        }
        if (e()) {
            jpVar.a(f17851e);
            jpVar.a(this.f614a);
            jpVar.b();
        }
        if (this.f615a != null && f()) {
            jpVar.a(f17852f);
            jpVar.a(this.f615a);
            jpVar.b();
        }
        if (h()) {
            jpVar.a(f17853g);
            jpVar.a(this.f619b);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m503a() {
        return this.f614a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m504a() {
        return this.f615a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m507a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean zM506a = m506a();
        boolean zM506a2 = cif.m506a();
        if ((zM506a || zM506a2) && !(zM506a && zM506a2 && this.f613a == cif.f613a)) {
            return false;
        }
        boolean zM508b = m508b();
        boolean zM508b2 = cif.m508b();
        if ((zM508b || zM508b2) && !(zM508b && zM508b2 && this.f618b == cif.f618b)) {
            return false;
        }
        boolean zM509c = m509c();
        boolean zM509c2 = cif.m509c();
        if ((zM509c || zM509c2) && !(zM509c && zM509c2 && this.f617a == cif.f617a)) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = cif.d();
        if ((zD || zD2) && !(zD && zD2 && this.f620c == cif.f620c)) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = cif.e();
        if ((zE || zE2) && !(zE && zE2 && this.f614a == cif.f614a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = cif.f();
        if ((zF || zF2) && !(zF && zF2 && this.f615a.equals(cif.f615a))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = cif.h();
        if (zH || zH2) {
            return zH && zH2 && this.f619b == cif.f619b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Cif cif) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        if (!getClass().equals(cif.getClass())) {
            return getClass().getName().compareTo(cif.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m506a()).compareTo(Boolean.valueOf(cif.m506a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m506a() && (iA7 = jg.a(this.f613a, cif.f613a)) != 0) {
            return iA7;
        }
        int iCompareTo2 = Boolean.valueOf(m508b()).compareTo(Boolean.valueOf(cif.m508b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m508b() && (iA6 = jg.a(this.f618b, cif.f618b)) != 0) {
            return iA6;
        }
        int iCompareTo3 = Boolean.valueOf(m509c()).compareTo(Boolean.valueOf(cif.m509c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m509c() && (iA5 = jg.a(this.f617a, cif.f617a)) != 0) {
            return iA5;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA4 = jg.a(this.f620c, cif.f620c)) != 0) {
            return iA4;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA3 = jg.a(this.f614a, cif.f614a)) != 0) {
            return iA3;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA2 = jg.a(this.f615a, cif.f615a)) != 0) {
            return iA2;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (!h() || (iA = jg.a(this.f619b, cif.f619b)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.jf
    public void a(jp jpVar) {
        jpVar.mo637a();
        while (true) {
            jm jmVarMo633a = jpVar.mo633a();
            byte b9 = jmVarMo633a.f18102a;
            if (b9 == 0) {
                jpVar.f();
                m505a();
                return;
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 8) {
                        this.f613a = jpVar.mo631a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 8) {
                        this.f618b = jpVar.mo631a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 2) {
                        this.f617a = jpVar.mo643a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 8) {
                        this.f620c = jpVar.mo631a();
                        d(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 10) {
                        this.f614a = jpVar.mo632a();
                        e(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 11) {
                        this.f615a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 2) {
                        this.f619b = jpVar.mo643a();
                        f(true);
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
}
