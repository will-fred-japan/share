package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class jd implements jf<jd, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f899a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f900b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f901c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f902d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f903e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f904f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f905g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f895a = new ju("XmPushActionUnSubscriptionResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f18080a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f18081b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f18082c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f18083d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f18084e = new jm("", (byte) 10, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f18085f = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f18086g = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f18087h = new jm("", (byte) 11, 9);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f18088i = new jm("", (byte) 11, 10);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m622a() {
        return this.f898a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m624b() {
        return this.f897a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m625c() {
        return this.f900b != null;
    }

    public boolean d() {
        return this.f901c != null;
    }

    public boolean e() {
        return this.f899a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof jd)) {
            return m623a((jd) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f902d != null;
    }

    public boolean g() {
        return this.f903e != null;
    }

    public boolean h() {
        return this.f904f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f905g != null;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z9 = false;
        if (m622a()) {
            sb.append("debug:");
            String str = this.f898a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (m624b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("target:");
            ij ijVar = this.f897a;
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
        String str2 = this.f900b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f901c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f896a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f902d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f903e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f904f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f905g;
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
        return this.f900b;
    }

    public String b() {
        return this.f903e;
    }

    public String c() {
        return this.f905g;
    }

    public void a(boolean z8) {
        this.f899a.set(0, z8);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m621a();
        jpVar.a(f895a);
        if (this.f898a != null && m622a()) {
            jpVar.a(f18080a);
            jpVar.a(this.f898a);
            jpVar.b();
        }
        if (this.f897a != null && m624b()) {
            jpVar.a(f18081b);
            this.f897a.b(jpVar);
            jpVar.b();
        }
        if (this.f900b != null) {
            jpVar.a(f18082c);
            jpVar.a(this.f900b);
            jpVar.b();
        }
        if (this.f901c != null && d()) {
            jpVar.a(f18083d);
            jpVar.a(this.f901c);
            jpVar.b();
        }
        if (e()) {
            jpVar.a(f18084e);
            jpVar.a(this.f896a);
            jpVar.b();
        }
        if (this.f902d != null && f()) {
            jpVar.a(f18085f);
            jpVar.a(this.f902d);
            jpVar.b();
        }
        if (this.f903e != null && g()) {
            jpVar.a(f18086g);
            jpVar.a(this.f903e);
            jpVar.b();
        }
        if (this.f904f != null && h()) {
            jpVar.a(f18087h);
            jpVar.a(this.f904f);
            jpVar.b();
        }
        if (this.f905g != null && i()) {
            jpVar.a(f18088i);
            jpVar.a(this.f905g);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m623a(jd jdVar) {
        if (jdVar == null) {
            return false;
        }
        boolean zM622a = m622a();
        boolean zM622a2 = jdVar.m622a();
        if ((zM622a || zM622a2) && !(zM622a && zM622a2 && this.f898a.equals(jdVar.f898a))) {
            return false;
        }
        boolean zM624b = m624b();
        boolean zM624b2 = jdVar.m624b();
        if ((zM624b || zM624b2) && !(zM624b && zM624b2 && this.f897a.m530a(jdVar.f897a))) {
            return false;
        }
        boolean zM625c = m625c();
        boolean zM625c2 = jdVar.m625c();
        if ((zM625c || zM625c2) && !(zM625c && zM625c2 && this.f900b.equals(jdVar.f900b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = jdVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f901c.equals(jdVar.f901c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = jdVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f896a == jdVar.f896a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = jdVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f902d.equals(jdVar.f902d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = jdVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f903e.equals(jdVar.f903e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = jdVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f904f.equals(jdVar.f904f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = jdVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f905g.equals(jdVar.f905g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(jd jdVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(jdVar.getClass())) {
            return getClass().getName().compareTo(jdVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m622a()).compareTo(Boolean.valueOf(jdVar.m622a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m622a() && (iA9 = jg.a(this.f898a, jdVar.f898a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(m624b()).compareTo(Boolean.valueOf(jdVar.m624b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m624b() && (iA8 = jg.a(this.f897a, jdVar.f897a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(m625c()).compareTo(Boolean.valueOf(jdVar.m625c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m625c() && (iA7 = jg.a(this.f900b, jdVar.f900b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(jdVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = jg.a(this.f901c, jdVar.f901c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(jdVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = jg.a(this.f896a, jdVar.f896a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(jdVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = jg.a(this.f902d, jdVar.f902d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(jdVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = jg.a(this.f903e, jdVar.f903e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(jdVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = jg.a(this.f904f, jdVar.f904f)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(jdVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = jg.a(this.f905g, jdVar.f905g)) == 0) {
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
                m621a();
                return;
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f898a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f897a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f900b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f901c = jpVar.mo638a();
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
                        this.f896a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f902d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f903e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f904f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 11) {
                        this.f905g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m621a() throws jq {
        if (this.f900b != null) {
            return;
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
