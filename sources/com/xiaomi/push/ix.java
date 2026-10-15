package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ix implements jf<ix, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ig f826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f830a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f832b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f833c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f834d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f835e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f836f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f837g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f838h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f825a = new ju("XmPushActionSendMessage");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f18018a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f18019b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f18020c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f18021d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f18022e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f18023f = new jm("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f18024g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f18025h = new jm("", (byte) 12, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f18026i = new jm("", (byte) 2, 9);
    private static final jm j = new jm("", (byte) 13, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f18027k = new jm("", (byte) 11, 11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final jm f18028l = new jm("", (byte) 11, 12);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f829a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f831a = true;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m593a() {
        return this.f828a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m595b() {
        return this.f827a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m596c() {
        return this.f832b != null;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m597d() {
        return this.f833c != null;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m598e() {
        return this.f834d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ix)) {
            return m594a((ix) obj);
        }
        return false;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public boolean m599f() {
        return this.f835e != null;
    }

    public boolean g() {
        return this.f836f != null;
    }

    public boolean h() {
        return this.f826a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f829a.get(0);
    }

    public boolean j() {
        return this.f830a != null;
    }

    public boolean k() {
        return this.f837g != null;
    }

    public boolean l() {
        return this.f838h != null;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z9 = false;
        if (m593a()) {
            sb.append("debug:");
            String str = this.f828a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (m595b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("target:");
            ij ijVar = this.f827a;
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
        String str2 = this.f832b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f833c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m598e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f834d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m599f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f835e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f836f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            ig igVar = this.f826a;
            if (igVar == null) {
                sb.append("null");
            } else {
                sb.append(igVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f831a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f830a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f837g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f838h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m591a() {
        return this.f832b;
    }

    public String b() {
        return this.f833c;
    }

    public String c() {
        return this.f835e;
    }

    public String d() {
        return this.f836f;
    }

    public String e() {
        return this.f837g;
    }

    public String f() {
        return this.f838h;
    }

    public ig a() {
        return this.f826a;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m592a();
        jpVar.a(f825a);
        if (this.f828a != null && m593a()) {
            jpVar.a(f18018a);
            jpVar.a(this.f828a);
            jpVar.b();
        }
        if (this.f827a != null && m595b()) {
            jpVar.a(f18019b);
            this.f827a.b(jpVar);
            jpVar.b();
        }
        if (this.f832b != null) {
            jpVar.a(f18020c);
            jpVar.a(this.f832b);
            jpVar.b();
        }
        if (this.f833c != null) {
            jpVar.a(f18021d);
            jpVar.a(this.f833c);
            jpVar.b();
        }
        if (this.f834d != null && m598e()) {
            jpVar.a(f18022e);
            jpVar.a(this.f834d);
            jpVar.b();
        }
        if (this.f835e != null && m599f()) {
            jpVar.a(f18023f);
            jpVar.a(this.f835e);
            jpVar.b();
        }
        if (this.f836f != null && g()) {
            jpVar.a(f18024g);
            jpVar.a(this.f836f);
            jpVar.b();
        }
        if (this.f826a != null && h()) {
            jpVar.a(f18025h);
            this.f826a.b(jpVar);
            jpVar.b();
        }
        if (i()) {
            jpVar.a(f18026i);
            jpVar.a(this.f831a);
            jpVar.b();
        }
        if (this.f830a != null && j()) {
            jpVar.a(j);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f830a.size()));
            for (Map.Entry<String, String> entry : this.f830a.entrySet()) {
                jpVar.a(entry.getKey());
                jpVar.a(entry.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        if (this.f837g != null && k()) {
            jpVar.a(f18027k);
            jpVar.a(this.f837g);
            jpVar.b();
        }
        if (this.f838h != null && l()) {
            jpVar.a(f18028l);
            jpVar.a(this.f838h);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public void a(boolean z8) {
        this.f829a.set(0, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m594a(ix ixVar) {
        if (ixVar == null) {
            return false;
        }
        boolean zM593a = m593a();
        boolean zM593a2 = ixVar.m593a();
        if ((zM593a || zM593a2) && !(zM593a && zM593a2 && this.f828a.equals(ixVar.f828a))) {
            return false;
        }
        boolean zM595b = m595b();
        boolean zM595b2 = ixVar.m595b();
        if ((zM595b || zM595b2) && !(zM595b && zM595b2 && this.f827a.m530a(ixVar.f827a))) {
            return false;
        }
        boolean zM596c = m596c();
        boolean zM596c2 = ixVar.m596c();
        if ((zM596c || zM596c2) && !(zM596c && zM596c2 && this.f832b.equals(ixVar.f832b))) {
            return false;
        }
        boolean zM597d = m597d();
        boolean zM597d2 = ixVar.m597d();
        if ((zM597d || zM597d2) && !(zM597d && zM597d2 && this.f833c.equals(ixVar.f833c))) {
            return false;
        }
        boolean zM598e = m598e();
        boolean zM598e2 = ixVar.m598e();
        if ((zM598e || zM598e2) && !(zM598e && zM598e2 && this.f834d.equals(ixVar.f834d))) {
            return false;
        }
        boolean zM599f = m599f();
        boolean zM599f2 = ixVar.m599f();
        if ((zM599f || zM599f2) && !(zM599f && zM599f2 && this.f835e.equals(ixVar.f835e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ixVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f836f.equals(ixVar.f836f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ixVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f826a.m513a(ixVar.f826a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ixVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f831a == ixVar.f831a)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ixVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f830a.equals(ixVar.f830a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = ixVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f837g.equals(ixVar.f837g))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = ixVar.l();
        if (zL || zL2) {
            return zL && zL2 && this.f838h.equals(ixVar.f838h);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ix ixVar) {
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
        if (!getClass().equals(ixVar.getClass())) {
            return getClass().getName().compareTo(ixVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m593a()).compareTo(Boolean.valueOf(ixVar.m593a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m593a() && (iA12 = jg.a(this.f828a, ixVar.f828a)) != 0) {
            return iA12;
        }
        int iCompareTo2 = Boolean.valueOf(m595b()).compareTo(Boolean.valueOf(ixVar.m595b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m595b() && (iA11 = jg.a(this.f827a, ixVar.f827a)) != 0) {
            return iA11;
        }
        int iCompareTo3 = Boolean.valueOf(m596c()).compareTo(Boolean.valueOf(ixVar.m596c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m596c() && (iA10 = jg.a(this.f832b, ixVar.f832b)) != 0) {
            return iA10;
        }
        int iCompareTo4 = Boolean.valueOf(m597d()).compareTo(Boolean.valueOf(ixVar.m597d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m597d() && (iA9 = jg.a(this.f833c, ixVar.f833c)) != 0) {
            return iA9;
        }
        int iCompareTo5 = Boolean.valueOf(m598e()).compareTo(Boolean.valueOf(ixVar.m598e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m598e() && (iA8 = jg.a(this.f834d, ixVar.f834d)) != 0) {
            return iA8;
        }
        int iCompareTo6 = Boolean.valueOf(m599f()).compareTo(Boolean.valueOf(ixVar.m599f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (m599f() && (iA7 = jg.a(this.f835e, ixVar.f835e)) != 0) {
            return iA7;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ixVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA6 = jg.a(this.f836f, ixVar.f836f)) != 0) {
            return iA6;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ixVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA5 = jg.a(this.f826a, ixVar.f826a)) != 0) {
            return iA5;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ixVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA4 = jg.a(this.f831a, ixVar.f831a)) != 0) {
            return iA4;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ixVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA3 = jg.a(this.f830a, ixVar.f830a)) != 0) {
            return iA3;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ixVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA2 = jg.a(this.f837g, ixVar.f837g)) != 0) {
            return iA2;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ixVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (!l() || (iA = jg.a(this.f838h, ixVar.f838h)) == 0) {
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
                m592a();
                return;
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f828a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f827a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f832b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f833c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f834d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 11) {
                        this.f835e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f836f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 12) {
                        ig igVar = new ig();
                        this.f826a = igVar;
                        igVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 2) {
                        this.f831a = jpVar.mo643a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 13) {
                        jo joVarMo635a = jpVar.mo635a();
                        this.f830a = new HashMap(joVarMo635a.f918a * 2);
                        for (int i9 = 0; i9 < joVarMo635a.f918a; i9++) {
                            this.f830a.put(jpVar.mo638a(), jpVar.mo638a());
                        }
                        jpVar.h();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 11) {
                        this.f837g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 12:
                    if (b9 == 11) {
                        this.f838h = jpVar.mo638a();
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m592a() throws jq {
        if (this.f832b != null) {
            if (this.f833c != null) {
                return;
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
