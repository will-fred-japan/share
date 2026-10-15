package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class fy implements jf<fy, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte f441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f444a = new BitSet(6);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f445b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f446b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f447c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f448c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f449d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f450d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f451e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f440a = new ju("StatsEvent");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17491a = new jm("", (byte) 3, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17492b = new jm("", (byte) 8, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17493c = new jm("", (byte) 8, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17494d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17495e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17496f = new jm("", (byte) 8, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17497g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17498h = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17499i = new jm("", (byte) 8, 9);
    private static final jm j = new jm("", (byte) 8, 10);

    public fy a(byte b9) {
        this.f441a = b9;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f444a.get(1);
    }

    public boolean c() {
        return this.f444a.get(2);
    }

    public boolean d() {
        return this.f443a != null;
    }

    public boolean e() {
        return this.f446b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fy)) {
            return m394a((fy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f444a.get(3);
    }

    public boolean g() {
        return this.f448c != null;
    }

    public boolean h() {
        return this.f450d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f444a.get(4);
    }

    public boolean j() {
        return this.f444a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(chid:");
        sb.append((int) this.f441a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f442a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f445b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f443a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f446b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f447c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f448c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f450d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f449d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f451e);
        }
        sb.append(")");
        return sb.toString();
    }

    public void b(boolean z8) {
        this.f444a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f444a.set(2, z8);
    }

    public void d(boolean z8) {
        this.f444a.set(3, z8);
    }

    public void e(boolean z8) {
        this.f444a.set(4, z8);
    }

    public void f(boolean z8) {
        this.f444a.set(5, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m393a() {
        return this.f444a.get(0);
    }

    public fy b(int i9) {
        this.f445b = i9;
        c(true);
        return this;
    }

    public fy c(int i9) {
        this.f447c = i9;
        d(true);
        return this;
    }

    public fy d(String str) {
        this.f450d = str;
        return this;
    }

    public void a(boolean z8) {
        this.f444a.set(0, z8);
    }

    public fy d(int i9) {
        this.f449d = i9;
        e(true);
        return this;
    }

    public fy a(int i9) {
        this.f442a = i9;
        b(true);
        return this;
    }

    public fy b(String str) {
        this.f446b = str;
        return this;
    }

    public fy c(String str) {
        this.f448c = str;
        return this;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        a();
        jpVar.a(f440a);
        jpVar.a(f17491a);
        jpVar.a(this.f441a);
        jpVar.b();
        jpVar.a(f17492b);
        jpVar.mo642a(this.f442a);
        jpVar.b();
        jpVar.a(f17493c);
        jpVar.mo642a(this.f445b);
        jpVar.b();
        if (this.f443a != null) {
            jpVar.a(f17494d);
            jpVar.a(this.f443a);
            jpVar.b();
        }
        if (this.f446b != null && e()) {
            jpVar.a(f17495e);
            jpVar.a(this.f446b);
            jpVar.b();
        }
        if (f()) {
            jpVar.a(f17496f);
            jpVar.mo642a(this.f447c);
            jpVar.b();
        }
        if (this.f448c != null && g()) {
            jpVar.a(f17497g);
            jpVar.a(this.f448c);
            jpVar.b();
        }
        if (this.f450d != null && h()) {
            jpVar.a(f17498h);
            jpVar.a(this.f450d);
            jpVar.b();
        }
        if (i()) {
            jpVar.a(f17499i);
            jpVar.mo642a(this.f449d);
            jpVar.b();
        }
        if (j()) {
            jpVar.a(j);
            jpVar.mo642a(this.f451e);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public fy a(String str) {
        this.f443a = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m394a(fy fyVar) {
        if (fyVar == null || this.f441a != fyVar.f441a || this.f442a != fyVar.f442a || this.f445b != fyVar.f445b) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = fyVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f443a.equals(fyVar.f443a))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = fyVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f446b.equals(fyVar.f446b))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = fyVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f447c == fyVar.f447c)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = fyVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f448c.equals(fyVar.f448c))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = fyVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f450d.equals(fyVar.f450d))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = fyVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f449d == fyVar.f449d)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = fyVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f451e == fyVar.f451e;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(fy fyVar) {
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
        if (!getClass().equals(fyVar.getClass())) {
            return getClass().getName().compareTo(fyVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m393a()).compareTo(Boolean.valueOf(fyVar.m393a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m393a() && (iA10 = jg.a(this.f441a, fyVar.f441a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fyVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA9 = jg.a(this.f442a, fyVar.f442a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fyVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = jg.a(this.f445b, fyVar.f445b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fyVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = jg.a(this.f443a, fyVar.f443a)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fyVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = jg.a(this.f446b, fyVar.f446b)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fyVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = jg.a(this.f447c, fyVar.f447c)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fyVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = jg.a(this.f448c, fyVar.f448c)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fyVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = jg.a(this.f450d, fyVar.f450d)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fyVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = jg.a(this.f449d, fyVar.f449d)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fyVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = jg.a(this.f451e, fyVar.f451e)) == 0) {
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
                if (m393a()) {
                    if (b()) {
                        if (c()) {
                            a();
                            return;
                        }
                        throw new jq("Required field 'value' was not found in serialized data! Struct: " + toString());
                    }
                    throw new jq("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                throw new jq("Required field 'chid' was not found in serialized data! Struct: " + toString());
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 3) {
                        this.f441a = jpVar.a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 8) {
                        this.f442a = jpVar.mo631a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 8) {
                        this.f445b = jpVar.mo631a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f443a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f446b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 8) {
                        this.f447c = jpVar.mo631a();
                        d(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f448c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f450d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 8) {
                        this.f449d = jpVar.mo631a();
                        e(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 8) {
                        this.f451e = jpVar.mo631a();
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

    public void a() throws jq {
        if (this.f443a != null) {
            return;
        }
        throw new jq("Required field 'connpt' was not present! Struct: " + toString());
    }
}
