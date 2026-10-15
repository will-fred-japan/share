package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class iz implements jf<iz, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f852a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f853b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f854c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f855d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f856e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f857f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f858g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f848a = new ju("XmPushActionSubscriptionResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f18037a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f18038b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f18039c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f18040d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f18041e = new jm("", (byte) 10, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f18042f = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f18043g = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f18044h = new jm("", (byte) 11, 9);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f18045i = new jm("", (byte) 11, 10);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m603a() {
        return this.f851a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m605b() {
        return this.f850a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m606c() {
        return this.f853b != null;
    }

    public boolean d() {
        return this.f854c != null;
    }

    public boolean e() {
        return this.f852a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iz)) {
            return m604a((iz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f855d != null;
    }

    public boolean g() {
        return this.f856e != null;
    }

    public boolean h() {
        return this.f857f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f858g != null;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z9 = false;
        if (m603a()) {
            sb.append("debug:");
            String str = this.f851a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (m605b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("target:");
            ij ijVar = this.f850a;
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
        String str2 = this.f853b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f854c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f849a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f855d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f856e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f857f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f858g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f853b;
    }

    public String b() {
        return this.f856e;
    }

    public String c() {
        return this.f858g;
    }

    public void a(boolean z8) {
        this.f852a.set(0, z8);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m602a();
        jpVar.a(f848a);
        if (this.f851a != null && m603a()) {
            jpVar.a(f18037a);
            jpVar.a(this.f851a);
            jpVar.b();
        }
        if (this.f850a != null && m605b()) {
            jpVar.a(f18038b);
            this.f850a.b(jpVar);
            jpVar.b();
        }
        if (this.f853b != null) {
            jpVar.a(f18039c);
            jpVar.a(this.f853b);
            jpVar.b();
        }
        if (this.f854c != null && d()) {
            jpVar.a(f18040d);
            jpVar.a(this.f854c);
            jpVar.b();
        }
        if (e()) {
            jpVar.a(f18041e);
            jpVar.a(this.f849a);
            jpVar.b();
        }
        if (this.f855d != null && f()) {
            jpVar.a(f18042f);
            jpVar.a(this.f855d);
            jpVar.b();
        }
        if (this.f856e != null && g()) {
            jpVar.a(f18043g);
            jpVar.a(this.f856e);
            jpVar.b();
        }
        if (this.f857f != null && h()) {
            jpVar.a(f18044h);
            jpVar.a(this.f857f);
            jpVar.b();
        }
        if (this.f858g != null && i()) {
            jpVar.a(f18045i);
            jpVar.a(this.f858g);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m604a(iz izVar) {
        if (izVar == null) {
            return false;
        }
        boolean zM603a = m603a();
        boolean zM603a2 = izVar.m603a();
        if ((zM603a || zM603a2) && !(zM603a && zM603a2 && this.f851a.equals(izVar.f851a))) {
            return false;
        }
        boolean zM605b = m605b();
        boolean zM605b2 = izVar.m605b();
        if ((zM605b || zM605b2) && !(zM605b && zM605b2 && this.f850a.m530a(izVar.f850a))) {
            return false;
        }
        boolean zM606c = m606c();
        boolean zM606c2 = izVar.m606c();
        if ((zM606c || zM606c2) && !(zM606c && zM606c2 && this.f853b.equals(izVar.f853b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = izVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f854c.equals(izVar.f854c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = izVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f849a == izVar.f849a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = izVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f855d.equals(izVar.f855d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = izVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f856e.equals(izVar.f856e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = izVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f857f.equals(izVar.f857f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = izVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f858g.equals(izVar.f858g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iz izVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(izVar.getClass())) {
            return getClass().getName().compareTo(izVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m603a()).compareTo(Boolean.valueOf(izVar.m603a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m603a() && (iA9 = jg.a(this.f851a, izVar.f851a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(m605b()).compareTo(Boolean.valueOf(izVar.m605b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m605b() && (iA8 = jg.a(this.f850a, izVar.f850a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(m606c()).compareTo(Boolean.valueOf(izVar.m606c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m606c() && (iA7 = jg.a(this.f853b, izVar.f853b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(izVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = jg.a(this.f854c, izVar.f854c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(izVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = jg.a(this.f849a, izVar.f849a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(izVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = jg.a(this.f855d, izVar.f855d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(izVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = jg.a(this.f856e, izVar.f856e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(izVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = jg.a(this.f857f, izVar.f857f)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(izVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = jg.a(this.f858g, izVar.f858g)) == 0) {
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
                m602a();
                return;
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f851a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f850a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f853b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f854c = jpVar.mo638a();
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
                        this.f849a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f855d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f856e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f857f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 11) {
                        this.f858g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m602a() throws jq {
        if (this.f853b != null) {
            return;
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
