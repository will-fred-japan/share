package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class jc implements jf<jc, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f889a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f890b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f891c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f892d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f893e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f894f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f886a = new ju("XmPushActionUnSubscription");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f18072a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f18073b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f18074c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f18075d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f18076e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f18077f = new jm("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f18078g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f18079h = new jm("", (byte) 15, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m619a() {
        return this.f888a != null;
    }

    public boolean b() {
        return this.f887a != null;
    }

    public boolean c() {
        return this.f890b != null;
    }

    public boolean d() {
        return this.f891c != null;
    }

    public boolean e() {
        return this.f892d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof jc)) {
            return m620a((jc) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f893e != null;
    }

    public boolean g() {
        return this.f894f != null;
    }

    public boolean h() {
        return this.f889a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z9 = false;
        if (m619a()) {
            sb.append("debug:");
            String str = this.f888a;
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
            ij ijVar = this.f887a;
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
        String str2 = this.f890b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f891c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f892d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f893e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f894f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f889a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public jc a(String str) {
        this.f890b = str;
        return this;
    }

    public jc b(String str) {
        this.f891c = str;
        return this;
    }

    public jc c(String str) {
        this.f892d = str;
        return this;
    }

    public jc d(String str) {
        this.f893e = str;
        return this;
    }

    public jc e(String str) {
        this.f894f = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m620a(jc jcVar) {
        if (jcVar == null) {
            return false;
        }
        boolean zM619a = m619a();
        boolean zM619a2 = jcVar.m619a();
        if ((zM619a || zM619a2) && !(zM619a && zM619a2 && this.f888a.equals(jcVar.f888a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = jcVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f887a.m530a(jcVar.f887a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = jcVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f890b.equals(jcVar.f890b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = jcVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f891c.equals(jcVar.f891c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = jcVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f892d.equals(jcVar.f892d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = jcVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f893e.equals(jcVar.f893e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = jcVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f894f.equals(jcVar.f894f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = jcVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f889a.equals(jcVar.f889a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        a();
        jpVar.a(f886a);
        if (this.f888a != null && m619a()) {
            jpVar.a(f18072a);
            jpVar.a(this.f888a);
            jpVar.b();
        }
        if (this.f887a != null && b()) {
            jpVar.a(f18073b);
            this.f887a.b(jpVar);
            jpVar.b();
        }
        if (this.f890b != null) {
            jpVar.a(f18074c);
            jpVar.a(this.f890b);
            jpVar.b();
        }
        if (this.f891c != null) {
            jpVar.a(f18075d);
            jpVar.a(this.f891c);
            jpVar.b();
        }
        if (this.f892d != null) {
            jpVar.a(f18076e);
            jpVar.a(this.f892d);
            jpVar.b();
        }
        if (this.f893e != null && f()) {
            jpVar.a(f18077f);
            jpVar.a(this.f893e);
            jpVar.b();
        }
        if (this.f894f != null && g()) {
            jpVar.a(f18078g);
            jpVar.a(this.f894f);
            jpVar.b();
        }
        if (this.f889a != null && h()) {
            jpVar.a(f18079h);
            jpVar.a(new jn((byte) 11, this.f889a.size()));
            Iterator<String> it = this.f889a.iterator();
            while (it.hasNext()) {
                jpVar.a(it.next());
            }
            jpVar.e();
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(jc jcVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(jcVar.getClass())) {
            return getClass().getName().compareTo(jcVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m619a()).compareTo(Boolean.valueOf(jcVar.m619a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m619a() && (iA8 = jg.a(this.f888a, jcVar.f888a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(jcVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = jg.a(this.f887a, jcVar.f887a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(jcVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = jg.a(this.f890b, jcVar.f890b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(jcVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = jg.a(this.f891c, jcVar.f891c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(jcVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = jg.a(this.f892d, jcVar.f892d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(jcVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = jg.a(this.f893e, jcVar.f893e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(jcVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = jg.a(this.f894f, jcVar.f894f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(jcVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = jg.a(this.f889a, jcVar.f889a)) == 0) {
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
                        this.f888a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f887a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f890b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f891c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f892d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 11) {
                        this.f893e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f894f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 15) {
                        jn jnVarMo634a = jpVar.mo634a();
                        this.f889a = new ArrayList(jnVarMo634a.f917a);
                        for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                            this.f889a.add(jpVar.mo638a());
                        }
                        jpVar.i();
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
        if (this.f890b != null) {
            if (this.f891c != null) {
                if (this.f892d != null) {
                    return;
                }
                throw new jq("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
