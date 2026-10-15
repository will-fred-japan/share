package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ip implements jf<ip, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f723a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f725b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f726c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f727d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f728e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f729f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f718a = new ju("XmPushActionCommandResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17931a = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17932b = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17933c = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17934d = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17935e = new jm("", (byte) 10, 7);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17936f = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17937g = new jm("", (byte) 11, 9);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17938h = new jm("", (byte) 15, 10);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17939i = new jm("", (byte) 11, 12);
    private static final jm j = new jm("", (byte) 2, 13);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f722a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f724a = true;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m548a() {
        return this.f720a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m550b() {
        return this.f721a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m551c() {
        return this.f725b != null;
    }

    public boolean d() {
        return this.f726c != null;
    }

    public boolean e() {
        return this.f722a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m549a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f727d != null;
    }

    public boolean g() {
        return this.f728e != null;
    }

    public boolean h() {
        return this.f723a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f729f != null;
    }

    public boolean j() {
        return this.f722a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m548a()) {
            sb.append("target:");
            ij ijVar = this.f720a;
            if (ijVar == null) {
                sb.append("null");
            } else {
                sb.append(ijVar);
            }
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f721a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f725b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f726c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f719a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f727d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f728e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f723a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f729f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f724a);
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f721a;
    }

    public String b() {
        return this.f726c;
    }

    public String c() {
        return this.f729f;
    }

    public void a(boolean z8) {
        this.f722a.set(0, z8);
    }

    public void b(boolean z8) {
        this.f722a.set(1, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<String> m546a() {
        return this.f723a;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m547a();
        jpVar.a(f718a);
        if (this.f720a != null && m548a()) {
            jpVar.a(f17931a);
            this.f720a.b(jpVar);
            jpVar.b();
        }
        if (this.f721a != null) {
            jpVar.a(f17932b);
            jpVar.a(this.f721a);
            jpVar.b();
        }
        if (this.f725b != null) {
            jpVar.a(f17933c);
            jpVar.a(this.f725b);
            jpVar.b();
        }
        if (this.f726c != null) {
            jpVar.a(f17934d);
            jpVar.a(this.f726c);
            jpVar.b();
        }
        jpVar.a(f17935e);
        jpVar.a(this.f719a);
        jpVar.b();
        if (this.f727d != null && f()) {
            jpVar.a(f17936f);
            jpVar.a(this.f727d);
            jpVar.b();
        }
        if (this.f728e != null && g()) {
            jpVar.a(f17937g);
            jpVar.a(this.f728e);
            jpVar.b();
        }
        if (this.f723a != null && h()) {
            jpVar.a(f17938h);
            jpVar.a(new jn((byte) 11, this.f723a.size()));
            Iterator<String> it = this.f723a.iterator();
            while (it.hasNext()) {
                jpVar.a(it.next());
            }
            jpVar.e();
            jpVar.b();
        }
        if (this.f729f != null && i()) {
            jpVar.a(f17939i);
            jpVar.a(this.f729f);
            jpVar.b();
        }
        if (j()) {
            jpVar.a(j);
            jpVar.a(this.f724a);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m549a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean zM548a = m548a();
        boolean zM548a2 = ipVar.m548a();
        if ((zM548a || zM548a2) && !(zM548a && zM548a2 && this.f720a.m530a(ipVar.f720a))) {
            return false;
        }
        boolean zM550b = m550b();
        boolean zM550b2 = ipVar.m550b();
        if ((zM550b || zM550b2) && !(zM550b && zM550b2 && this.f721a.equals(ipVar.f721a))) {
            return false;
        }
        boolean zM551c = m551c();
        boolean zM551c2 = ipVar.m551c();
        if ((zM551c || zM551c2) && !(zM551c && zM551c2 && this.f725b.equals(ipVar.f725b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ipVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f726c.equals(ipVar.f726c))) || this.f719a != ipVar.f719a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ipVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f727d.equals(ipVar.f727d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ipVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f728e.equals(ipVar.f728e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ipVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f723a.equals(ipVar.f723a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ipVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f729f.equals(ipVar.f729f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ipVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f724a == ipVar.f724a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ip ipVar) {
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
        if (!getClass().equals(ipVar.getClass())) {
            return getClass().getName().compareTo(ipVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m548a()).compareTo(Boolean.valueOf(ipVar.m548a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m548a() && (iA10 = jg.a(this.f720a, ipVar.f720a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m550b()).compareTo(Boolean.valueOf(ipVar.m550b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m550b() && (iA9 = jg.a(this.f721a, ipVar.f721a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(m551c()).compareTo(Boolean.valueOf(ipVar.m551c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m551c() && (iA8 = jg.a(this.f725b, ipVar.f725b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = jg.a(this.f726c, ipVar.f726c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = jg.a(this.f719a, ipVar.f719a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = jg.a(this.f727d, ipVar.f727d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = jg.a(this.f728e, ipVar.f728e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = jg.a(this.f723a, ipVar.f723a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = jg.a(this.f729f, ipVar.f729f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = jg.a(this.f724a, ipVar.f724a)) == 0) {
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
                    m547a();
                    return;
                }
                throw new jq("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (jmVarMo633a.f916a) {
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f720a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f721a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f725b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f726c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                case 11:
                default:
                    js.a(jpVar, b9);
                    break;
                case 7:
                    if (b9 == 10) {
                        this.f719a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f727d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f728e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 15) {
                        jn jnVarMo634a = jpVar.mo634a();
                        this.f723a = new ArrayList(jnVarMo634a.f917a);
                        for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                            this.f723a.add(jpVar.mo638a());
                        }
                        jpVar.i();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 12:
                    if (b9 == 11) {
                        this.f729f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 13:
                    if (b9 == 2) {
                        this.f724a = jpVar.mo643a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m547a() throws jq {
        if (this.f721a != null) {
            if (this.f725b != null) {
                if (this.f726c != null) {
                    return;
                }
                throw new jq("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
