package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class hy implements jf<hy, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f584a = new BitSet(3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f586a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f587b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f588b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f589c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f590d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f591e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f592f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f593g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f581a = new ju("ClientUploadDataItem");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17724a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17725b = new jm("", (byte) 11, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17726c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17727d = new jm("", (byte) 10, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17728e = new jm("", (byte) 10, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17729f = new jm("", (byte) 2, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17730g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17731h = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17732i = new jm("", (byte) 11, 9);
    private static final jm j = new jm("", (byte) 13, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f17733k = new jm("", (byte) 11, 11);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m488a() {
    }

    public hy b(String str) {
        this.f588b = str;
        return this;
    }

    public hy c(String str) {
        this.f589c = str;
        return this;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m494d() {
        return this.f584a.get(0);
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m495e() {
        return this.f584a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m491a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f584a.get(2);
    }

    public boolean g() {
        return this.f590d != null;
    }

    public boolean h() {
        return this.f591e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f592f != null;
    }

    public boolean j() {
        return this.f585a != null;
    }

    public boolean k() {
        return this.f593g != null;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z9 = false;
        if (m490a()) {
            sb.append("channel:");
            String str = this.f583a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (m492b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f588b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z8 = false;
        }
        if (m493c()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f589c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z8 = false;
        }
        if (m494d()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f582a);
            z8 = false;
        }
        if (m495e()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f587b);
            z8 = false;
        }
        if (f()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f586a);
            z8 = false;
        }
        if (g()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f590d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z8 = false;
        }
        if (h()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f591e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z8 = false;
        }
        if (i()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f592f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z8 = false;
        }
        if (j()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f585a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        } else {
            z9 = z8;
        }
        if (k()) {
            if (!z9) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f593g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m486a() {
        return this.f583a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m492b() {
        return this.f588b != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m493c() {
        return this.f589c != null;
    }

    public hy d(String str) {
        this.f590d = str;
        return this;
    }

    public hy e(String str) {
        this.f591e = str;
        return this;
    }

    public hy f(String str) {
        this.f592f = str;
        return this;
    }

    public hy g(String str) {
        this.f593g = str;
        return this;
    }

    public hy a(String str) {
        this.f583a = str;
        return this;
    }

    public String b() {
        return this.f589c;
    }

    public void c(boolean z8) {
        this.f584a.set(2, z8);
    }

    public String d() {
        return this.f592f;
    }

    public String e() {
        return this.f593g;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m490a() {
        return this.f583a != null;
    }

    public hy b(long j8) {
        this.f587b = j8;
        b(true);
        return this;
    }

    public String c() {
        return this.f591e;
    }

    public hy a(long j8) {
        this.f582a = j8;
        m489a(true);
        return this;
    }

    public void b(boolean z8) {
        this.f584a.set(1, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m489a(boolean z8) {
        this.f584a.set(0, z8);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) {
        m488a();
        jpVar.a(f581a);
        if (this.f583a != null && m490a()) {
            jpVar.a(f17724a);
            jpVar.a(this.f583a);
            jpVar.b();
        }
        if (this.f588b != null && m492b()) {
            jpVar.a(f17725b);
            jpVar.a(this.f588b);
            jpVar.b();
        }
        if (this.f589c != null && m493c()) {
            jpVar.a(f17726c);
            jpVar.a(this.f589c);
            jpVar.b();
        }
        if (m494d()) {
            jpVar.a(f17727d);
            jpVar.a(this.f582a);
            jpVar.b();
        }
        if (m495e()) {
            jpVar.a(f17728e);
            jpVar.a(this.f587b);
            jpVar.b();
        }
        if (f()) {
            jpVar.a(f17729f);
            jpVar.a(this.f586a);
            jpVar.b();
        }
        if (this.f590d != null && g()) {
            jpVar.a(f17730g);
            jpVar.a(this.f590d);
            jpVar.b();
        }
        if (this.f591e != null && h()) {
            jpVar.a(f17731h);
            jpVar.a(this.f591e);
            jpVar.b();
        }
        if (this.f592f != null && i()) {
            jpVar.a(f17732i);
            jpVar.a(this.f592f);
            jpVar.b();
        }
        if (this.f585a != null && j()) {
            jpVar.a(j);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f585a.size()));
            for (Map.Entry<String, String> entry : this.f585a.entrySet()) {
                jpVar.a(entry.getKey());
                jpVar.a(entry.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        if (this.f593g != null && k()) {
            jpVar.a(f17733k);
            jpVar.a(this.f593g);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public long a() {
        return this.f587b;
    }

    public hy a(boolean z8) {
        this.f586a = z8;
        c(true);
        return this;
    }

    public void a(String str, String str2) {
        if (this.f585a == null) {
            this.f585a = new HashMap();
        }
        this.f585a.put(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m487a() {
        return this.f585a;
    }

    public hy a(Map<String, String> map) {
        this.f585a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m491a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean zM490a = m490a();
        boolean zM490a2 = hyVar.m490a();
        if ((zM490a || zM490a2) && !(zM490a && zM490a2 && this.f583a.equals(hyVar.f583a))) {
            return false;
        }
        boolean zM492b = m492b();
        boolean zM492b2 = hyVar.m492b();
        if ((zM492b || zM492b2) && !(zM492b && zM492b2 && this.f588b.equals(hyVar.f588b))) {
            return false;
        }
        boolean zM493c = m493c();
        boolean zM493c2 = hyVar.m493c();
        if ((zM493c || zM493c2) && !(zM493c && zM493c2 && this.f589c.equals(hyVar.f589c))) {
            return false;
        }
        boolean zM494d = m494d();
        boolean zM494d2 = hyVar.m494d();
        if ((zM494d || zM494d2) && !(zM494d && zM494d2 && this.f582a == hyVar.f582a)) {
            return false;
        }
        boolean zM495e = m495e();
        boolean zM495e2 = hyVar.m495e();
        if ((zM495e || zM495e2) && !(zM495e && zM495e2 && this.f587b == hyVar.f587b)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hyVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f586a == hyVar.f586a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hyVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f590d.equals(hyVar.f590d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hyVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f591e.equals(hyVar.f591e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hyVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f592f.equals(hyVar.f592f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hyVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f585a.equals(hyVar.f585a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hyVar.k();
        if (zK || zK2) {
            return zK && zK2 && this.f593g.equals(hyVar.f593g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hy hyVar) {
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
        if (!getClass().equals(hyVar.getClass())) {
            return getClass().getName().compareTo(hyVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m490a()).compareTo(Boolean.valueOf(hyVar.m490a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m490a() && (iA11 = jg.a(this.f583a, hyVar.f583a)) != 0) {
            return iA11;
        }
        int iCompareTo2 = Boolean.valueOf(m492b()).compareTo(Boolean.valueOf(hyVar.m492b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m492b() && (iA10 = jg.a(this.f588b, hyVar.f588b)) != 0) {
            return iA10;
        }
        int iCompareTo3 = Boolean.valueOf(m493c()).compareTo(Boolean.valueOf(hyVar.m493c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m493c() && (iA9 = jg.a(this.f589c, hyVar.f589c)) != 0) {
            return iA9;
        }
        int iCompareTo4 = Boolean.valueOf(m494d()).compareTo(Boolean.valueOf(hyVar.m494d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m494d() && (iA8 = jg.a(this.f582a, hyVar.f582a)) != 0) {
            return iA8;
        }
        int iCompareTo5 = Boolean.valueOf(m495e()).compareTo(Boolean.valueOf(hyVar.m495e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m495e() && (iA7 = jg.a(this.f587b, hyVar.f587b)) != 0) {
            return iA7;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA6 = jg.a(this.f586a, hyVar.f586a)) != 0) {
            return iA6;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hyVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA5 = jg.a(this.f590d, hyVar.f590d)) != 0) {
            return iA5;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA4 = jg.a(this.f591e, hyVar.f591e)) != 0) {
            return iA4;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA3 = jg.a(this.f592f, hyVar.f592f)) != 0) {
            return iA3;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hyVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA2 = jg.a(this.f585a, hyVar.f585a)) != 0) {
            return iA2;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hyVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (!k() || (iA = jg.a(this.f593g, hyVar.f593g)) == 0) {
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
                m488a();
                return;
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f583a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 11) {
                        this.f588b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f589c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 10) {
                        this.f582a = jpVar.mo632a();
                        m489a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 10) {
                        this.f587b = jpVar.mo632a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 2) {
                        this.f586a = jpVar.mo643a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f590d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f591e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f592f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 13) {
                        jo joVarMo635a = jpVar.mo635a();
                        this.f585a = new HashMap(joVarMo635a.f918a * 2);
                        for (int i9 = 0; i9 < joVarMo635a.f918a; i9++) {
                            this.f585a.put(jpVar.mo638a(), jpVar.mo638a());
                        }
                        jpVar.h();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 11) {
                        this.f593g = jpVar.mo638a();
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
