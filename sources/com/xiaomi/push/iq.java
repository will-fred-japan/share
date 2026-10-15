package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class iq implements jf<iq, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hu f731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ih f732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f735a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f738b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f730a = new ju("XmPushActionContainer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17940a = new jm("", (byte) 8, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17941b = new jm("", (byte) 2, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17942c = new jm("", (byte) 2, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17943d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17944e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17945f = new jm("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17946g = new jm("", (byte) 12, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17947h = new jm("", (byte) 12, 8);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f736a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f737a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f739b = true;

    public hu a() {
        return this.f731a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m560b() {
        return this.f737a;
    }

    public boolean c() {
        return this.f736a.get(0);
    }

    public boolean d() {
        return this.f736a.get(1);
    }

    public boolean e() {
        return this.f735a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m557a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f734a != null;
    }

    public boolean g() {
        return this.f738b != null;
    }

    public boolean h() {
        return this.f733a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f732a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(action:");
        hu huVar = this.f731a;
        if (huVar == null) {
            sb.append("null");
        } else {
            sb.append(huVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f737a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f739b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f734a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f738b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        ij ijVar = this.f733a;
        if (ijVar == null) {
            sb.append("null");
        } else {
            sb.append(ijVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            ih ihVar = this.f732a;
            if (ihVar == null) {
                sb.append("null");
            } else {
                sb.append(ihVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public iq a(hu huVar) {
        this.f731a = huVar;
        return this;
    }

    public iq b(boolean z8) {
        this.f739b = z8;
        m559b(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m556a() {
        return this.f731a != null;
    }

    public iq a(boolean z8) {
        this.f737a = z8;
        m555a(true);
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m559b(boolean z8) {
        this.f736a.set(1, z8);
    }

    public String b() {
        return this.f738b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m555a(boolean z8) {
        this.f736a.set(0, z8);
    }

    public iq b(String str) {
        this.f738b = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m558a() {
        a(jg.a(this.f735a));
        return this.f735a.array();
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m554a();
        jpVar.a(f730a);
        if (this.f731a != null) {
            jpVar.a(f17940a);
            jpVar.mo642a(this.f731a.a());
            jpVar.b();
        }
        jpVar.a(f17941b);
        jpVar.a(this.f737a);
        jpVar.b();
        jpVar.a(f17942c);
        jpVar.a(this.f739b);
        jpVar.b();
        if (this.f735a != null) {
            jpVar.a(f17943d);
            jpVar.a(this.f735a);
            jpVar.b();
        }
        if (this.f734a != null && f()) {
            jpVar.a(f17944e);
            jpVar.a(this.f734a);
            jpVar.b();
        }
        if (this.f738b != null && g()) {
            jpVar.a(f17945f);
            jpVar.a(this.f738b);
            jpVar.b();
        }
        if (this.f733a != null) {
            jpVar.a(f17946g);
            this.f733a.b(jpVar);
            jpVar.b();
        }
        if (this.f732a != null && i()) {
            jpVar.a(f17947h);
            this.f732a.b(jpVar);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public iq a(ByteBuffer byteBuffer) {
        this.f735a = byteBuffer;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m553a() {
        return this.f734a;
    }

    public iq a(String str) {
        this.f734a = str;
        return this;
    }

    public iq a(ij ijVar) {
        this.f733a = ijVar;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ih m552a() {
        return this.f732a;
    }

    public iq a(ih ihVar) {
        this.f732a = ihVar;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m557a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean zM556a = m556a();
        boolean zM556a2 = iqVar.m556a();
        if (((zM556a || zM556a2) && (!zM556a || !zM556a2 || !this.f731a.equals(iqVar.f731a))) || this.f737a != iqVar.f737a || this.f739b != iqVar.f739b) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = iqVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f735a.equals(iqVar.f735a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = iqVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f734a.equals(iqVar.f734a))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = iqVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f738b.equals(iqVar.f738b))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = iqVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f733a.m530a(iqVar.f733a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = iqVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f732a.m522a(iqVar.f732a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iq iqVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(iqVar.getClass())) {
            return getClass().getName().compareTo(iqVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m556a()).compareTo(Boolean.valueOf(iqVar.m556a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m556a() && (iA8 = jg.a(this.f731a, iqVar.f731a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (c() && (iA7 = jg.a(this.f737a, iqVar.f737a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (d() && (iA6 = jg.a(this.f739b, iqVar.f739b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (e() && (iA5 = jg.a(this.f735a, iqVar.f735a)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (f() && (iA4 = jg.a(this.f734a, iqVar.f734a)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (g() && (iA3 = jg.a(this.f738b, iqVar.f738b)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (h() && (iA2 = jg.a(this.f733a, iqVar.f733a)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iqVar.i()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!i() || (iA = jg.a(this.f732a, iqVar.f732a)) == 0) {
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
                if (c()) {
                    if (d()) {
                        m554a();
                        return;
                    }
                    throw new jq("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                throw new jq("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 8) {
                        this.f731a = hu.a(jpVar.mo631a());
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 2) {
                        this.f737a = jpVar.mo643a();
                        m555a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 2) {
                        this.f739b = jpVar.mo643a();
                        m559b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f735a = jpVar.mo639a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f734a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 11) {
                        this.f738b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f733a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 12) {
                        ih ihVar = new ih();
                        this.f732a = ihVar;
                        ihVar.a(jpVar);
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
    public void m554a() throws jq {
        if (this.f731a != null) {
            if (this.f735a != null) {
                if (this.f733a != null) {
                    return;
                }
                throw new jq("Required field 'target' was not present! Struct: " + toString());
            }
            throw new jq("Required field 'pushAction' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'action' was not present! Struct: " + toString());
    }
}
