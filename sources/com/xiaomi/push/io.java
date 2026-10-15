package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class io implements jf<io, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f712a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f713b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f714b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f715c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f716d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f717e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f706a = new ju("XmPushActionCommand");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17922a = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17923b = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17924c = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17925d = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17926e = new jm("", (byte) 15, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17927f = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17928g = new jm("", (byte) 11, 9);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17929h = new jm("", (byte) 2, 10);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17930i = new jm("", (byte) 2, 11);
    private static final jm j = new jm("", (byte) 10, 12);

    public io() {
        this.f710a = new BitSet(3);
        this.f712a = false;
        this.f714b = true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m544a() {
        return this.f708a != null;
    }

    public boolean b() {
        return this.f709a != null;
    }

    public boolean c() {
        return this.f713b != null;
    }

    public boolean d() {
        return this.f715c != null;
    }

    public boolean e() {
        return this.f711a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m545a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f716d != null;
    }

    public boolean g() {
        return this.f717e != null;
    }

    public boolean h() {
        return this.f710a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f710a.get(1);
    }

    public boolean j() {
        return this.f710a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m544a()) {
            sb.append("target:");
            ij ijVar = this.f708a;
            if (ijVar == null) {
                sb.append("null");
            } else {
                sb.append(ijVar);
            }
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f709a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f713b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f715c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f711a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f716d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f717e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f712a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f714b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f707a);
        }
        sb.append(")");
        return sb.toString();
    }

    public io a(String str) {
        this.f709a = str;
        return this;
    }

    public io b(String str) {
        this.f713b = str;
        return this;
    }

    public io c(String str) {
        this.f715c = str;
        return this;
    }

    public io d(String str) {
        this.f716d = str;
        return this;
    }

    public io e(String str) {
        this.f717e = str;
        return this;
    }

    public String a() {
        return this.f715c;
    }

    public void b(boolean z8) {
        this.f710a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f710a.set(2, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m543a(String str) {
        if (this.f711a == null) {
            this.f711a = new ArrayList();
        }
        this.f711a.add(str);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m542a();
        jpVar.a(f706a);
        if (this.f708a != null && m544a()) {
            jpVar.a(f17922a);
            this.f708a.b(jpVar);
            jpVar.b();
        }
        if (this.f709a != null) {
            jpVar.a(f17923b);
            jpVar.a(this.f709a);
            jpVar.b();
        }
        if (this.f713b != null) {
            jpVar.a(f17924c);
            jpVar.a(this.f713b);
            jpVar.b();
        }
        if (this.f715c != null) {
            jpVar.a(f17925d);
            jpVar.a(this.f715c);
            jpVar.b();
        }
        if (this.f711a != null && e()) {
            jpVar.a(f17926e);
            jpVar.a(new jn((byte) 11, this.f711a.size()));
            Iterator<String> it = this.f711a.iterator();
            while (it.hasNext()) {
                jpVar.a(it.next());
            }
            jpVar.e();
            jpVar.b();
        }
        if (this.f716d != null && f()) {
            jpVar.a(f17927f);
            jpVar.a(this.f716d);
            jpVar.b();
        }
        if (this.f717e != null && g()) {
            jpVar.a(f17928g);
            jpVar.a(this.f717e);
            jpVar.b();
        }
        if (h()) {
            jpVar.a(f17929h);
            jpVar.a(this.f712a);
            jpVar.b();
        }
        if (i()) {
            jpVar.a(f17930i);
            jpVar.a(this.f714b);
            jpVar.b();
        }
        if (j()) {
            jpVar.a(j);
            jpVar.a(this.f707a);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public io(String str, String str2, String str3) {
        this();
        this.f709a = str;
        this.f713b = str2;
        this.f715c = str3;
    }

    public void a(boolean z8) {
        this.f710a.set(0, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m545a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean zM544a = m544a();
        boolean zM544a2 = ioVar.m544a();
        if ((zM544a || zM544a2) && !(zM544a && zM544a2 && this.f708a.m530a(ioVar.f708a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = ioVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f709a.equals(ioVar.f709a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = ioVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f713b.equals(ioVar.f713b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ioVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f715c.equals(ioVar.f715c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ioVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f711a.equals(ioVar.f711a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ioVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f716d.equals(ioVar.f716d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ioVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f717e.equals(ioVar.f717e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ioVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f712a == ioVar.f712a)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ioVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f714b == ioVar.f714b)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ioVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f707a == ioVar.f707a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(io ioVar) {
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
        if (!getClass().equals(ioVar.getClass())) {
            return getClass().getName().compareTo(ioVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m544a()).compareTo(Boolean.valueOf(ioVar.m544a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m544a() && (iA10 = jg.a(this.f708a, ioVar.f708a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA9 = jg.a(this.f709a, ioVar.f709a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = jg.a(this.f713b, ioVar.f713b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = jg.a(this.f715c, ioVar.f715c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = jg.a(this.f711a, ioVar.f711a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = jg.a(this.f716d, ioVar.f716d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = jg.a(this.f717e, ioVar.f717e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = jg.a(this.f712a, ioVar.f712a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ioVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = jg.a(this.f714b, ioVar.f714b)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ioVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = jg.a(this.f707a, ioVar.f707a)) == 0) {
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
                m542a();
                return;
            }
            switch (jmVarMo633a.f916a) {
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f708a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f709a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f713b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f715c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 15) {
                        jn jnVarMo634a = jpVar.mo634a();
                        this.f711a = new ArrayList(jnVarMo634a.f917a);
                        for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                            this.f711a.add(jpVar.mo638a());
                        }
                        jpVar.i();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f716d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                default:
                    js.a(jpVar, b9);
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f717e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 2) {
                        this.f712a = jpVar.mo643a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 2) {
                        this.f714b = jpVar.mo643a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 12:
                    if (b9 == 10) {
                        this.f707a = jpVar.mo632a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m542a() throws jq {
        if (this.f709a != null) {
            if (this.f713b != null) {
                if (this.f715c != null) {
                    return;
                }
                throw new jq("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
