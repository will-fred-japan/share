package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class il implements jf<il, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f693a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f694b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f695c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f696d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f697e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f698f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f699g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f688a = new ju("XmPushActionAckNotification");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17910a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17911b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17912c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17913d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17914e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17915f = new jm("", (byte) 10, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17916g = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17917h = new jm("", (byte) 13, 9);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17918i = new jm("", (byte) 11, 10);
    private static final jm j = new jm("", (byte) 11, 11);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f692a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f689a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m535a() {
        return this.f691a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m537b() {
        return this.f690a != null;
    }

    public boolean c() {
        return this.f694b != null;
    }

    public boolean d() {
        return this.f695c != null;
    }

    public boolean e() {
        return this.f696d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m536a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f692a.get(0);
    }

    public boolean g() {
        return this.f697e != null;
    }

    public boolean h() {
        return this.f693a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f698f != null;
    }

    public boolean j() {
        return this.f699g != null;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z9 = false;
        if (m535a()) {
            sb.append("debug:");
            String str = this.f691a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (m537b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("target:");
            ij ijVar = this.f690a;
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
        String str2 = this.f694b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f695c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f696d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f689a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f697e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f693a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f698f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f699g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public il a(ij ijVar) {
        this.f690a = ijVar;
        return this;
    }

    public il b(String str) {
        this.f695c = str;
        return this;
    }

    public il c(String str) {
        this.f696d = str;
        return this;
    }

    public il d(String str) {
        this.f697e = str;
        return this;
    }

    public il e(String str) {
        this.f698f = str;
        return this;
    }

    public String a() {
        return this.f694b;
    }

    public String b() {
        return this.f696d;
    }

    public il a(String str) {
        this.f694b = str;
        return this;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m534a();
        jpVar.a(f688a);
        if (this.f691a != null && m535a()) {
            jpVar.a(f17910a);
            jpVar.a(this.f691a);
            jpVar.b();
        }
        if (this.f690a != null && m537b()) {
            jpVar.a(f17911b);
            this.f690a.b(jpVar);
            jpVar.b();
        }
        if (this.f694b != null) {
            jpVar.a(f17912c);
            jpVar.a(this.f694b);
            jpVar.b();
        }
        if (this.f695c != null && d()) {
            jpVar.a(f17913d);
            jpVar.a(this.f695c);
            jpVar.b();
        }
        if (this.f696d != null && e()) {
            jpVar.a(f17914e);
            jpVar.a(this.f696d);
            jpVar.b();
        }
        if (f()) {
            jpVar.a(f17915f);
            jpVar.a(this.f689a);
            jpVar.b();
        }
        if (this.f697e != null && g()) {
            jpVar.a(f17916g);
            jpVar.a(this.f697e);
            jpVar.b();
        }
        if (this.f693a != null && h()) {
            jpVar.a(f17917h);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f693a.size()));
            for (Map.Entry<String, String> entry : this.f693a.entrySet()) {
                jpVar.a(entry.getKey());
                jpVar.a(entry.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        if (this.f698f != null && i()) {
            jpVar.a(f17918i);
            jpVar.a(this.f698f);
            jpVar.b();
        }
        if (this.f699g != null && j()) {
            jpVar.a(j);
            jpVar.a(this.f699g);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public il a(long j8) {
        this.f689a = j8;
        a(true);
        return this;
    }

    public void a(boolean z8) {
        this.f692a.set(0, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m533a() {
        return this.f693a;
    }

    public il a(Map<String, String> map) {
        this.f693a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m536a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean zM535a = m535a();
        boolean zM535a2 = ilVar.m535a();
        if ((zM535a || zM535a2) && !(zM535a && zM535a2 && this.f691a.equals(ilVar.f691a))) {
            return false;
        }
        boolean zM537b = m537b();
        boolean zM537b2 = ilVar.m537b();
        if ((zM537b || zM537b2) && !(zM537b && zM537b2 && this.f690a.m530a(ilVar.f690a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = ilVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f694b.equals(ilVar.f694b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ilVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f695c.equals(ilVar.f695c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ilVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f696d.equals(ilVar.f696d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ilVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f689a == ilVar.f689a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ilVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f697e.equals(ilVar.f697e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ilVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f693a.equals(ilVar.f693a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ilVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f698f.equals(ilVar.f698f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ilVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f699g.equals(ilVar.f699g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(il ilVar) {
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
        if (!getClass().equals(ilVar.getClass())) {
            return getClass().getName().compareTo(ilVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m535a()).compareTo(Boolean.valueOf(ilVar.m535a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m535a() && (iA10 = jg.a(this.f691a, ilVar.f691a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m537b()).compareTo(Boolean.valueOf(ilVar.m537b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m537b() && (iA9 = jg.a(this.f690a, ilVar.f690a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = jg.a(this.f694b, ilVar.f694b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = jg.a(this.f695c, ilVar.f695c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = jg.a(this.f696d, ilVar.f696d)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = jg.a(this.f689a, ilVar.f689a)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = jg.a(this.f697e, ilVar.f697e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = jg.a(this.f693a, ilVar.f693a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = jg.a(this.f698f, ilVar.f698f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = jg.a(this.f699g, ilVar.f699g)) == 0) {
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
                m534a();
                return;
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f691a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f690a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f694b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f695c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f696d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                default:
                    js.a(jpVar, b9);
                    break;
                case 7:
                    if (b9 == 10) {
                        this.f689a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f697e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 13) {
                        jo joVarMo635a = jpVar.mo635a();
                        this.f693a = new HashMap(joVarMo635a.f918a * 2);
                        for (int i9 = 0; i9 < joVarMo635a.f918a; i9++) {
                            this.f693a.put(jpVar.mo638a(), jpVar.mo638a());
                        }
                        jpVar.h();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 11) {
                        this.f698f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 11) {
                        this.f699g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m534a() throws jq {
        if (this.f694b != null) {
            return;
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
