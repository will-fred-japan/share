package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class it implements jf<it, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f751a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f752b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f753b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f754c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f755d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f756e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f757f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f758g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f759h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f760i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f744a = new ju("XmPushActionNotification");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17950a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17951b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17952c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17953d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17954e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17955f = new jm("", (byte) 2, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17956g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17957h = new jm("", (byte) 13, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17958i = new jm("", (byte) 11, 9);
    private static final jm j = new jm("", (byte) 11, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f17959k = new jm("", (byte) 11, 12);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final jm f17960l = new jm("", (byte) 11, 13);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final jm f17961m = new jm("", (byte) 11, 14);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final jm f17962n = new jm("", (byte) 10, 15);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final jm f17963o = new jm("", (byte) 2, 20);

    public it() {
        this.f749a = new BitSet(3);
        this.f751a = true;
        this.f753b = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m571a() {
        return this.f747a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m574b() {
        return this.f746a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m575c() {
        return this.f752b != null;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m576d() {
        return this.f754c != null;
    }

    public boolean e() {
        return this.f755d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m572a((it) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f749a.get(0);
    }

    public boolean g() {
        return this.f756e != null;
    }

    public boolean h() {
        return this.f750a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f757f != null;
    }

    public boolean j() {
        return this.f758g != null;
    }

    public boolean k() {
        return this.f759h != null;
    }

    public boolean l() {
        return this.f760i != null;
    }

    public boolean m() {
        return this.f748a != null;
    }

    public boolean n() {
        return this.f749a.get(1);
    }

    public boolean o() {
        return this.f749a.get(2);
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z9 = false;
        if (m571a()) {
            sb.append("debug:");
            String str = this.f747a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (m574b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("target:");
            ij ijVar = this.f746a;
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
        String str2 = this.f752b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (m576d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f754c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f755d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f751a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f756e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f750a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f757f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f758g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f759h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f760i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f748a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                jg.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f745a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f753b);
        }
        sb.append(")");
        return sb.toString();
    }

    public ij a() {
        return this.f746a;
    }

    public String b() {
        return this.f754c;
    }

    public String c() {
        return this.f755d;
    }

    public String d() {
        return this.f757f;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m567a() {
        return this.f752b;
    }

    public it b(String str) {
        this.f754c = str;
        return this;
    }

    public it c(String str) {
        this.f755d = str;
        return this;
    }

    public it d(String str) {
        this.f757f = str;
        return this;
    }

    public it a(String str) {
        this.f752b = str;
        return this;
    }

    public void b(boolean z8) {
        this.f749a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f749a.set(2, z8);
    }

    public it(String str, boolean z8) {
        this();
        this.f752b = str;
        this.f751a = z8;
        m570a(true);
    }

    public it a(boolean z8) {
        this.f751a = z8;
        m570a(true);
        return this;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m569a();
        jpVar.a(f744a);
        if (this.f747a != null && m571a()) {
            jpVar.a(f17950a);
            jpVar.a(this.f747a);
            jpVar.b();
        }
        if (this.f746a != null && m574b()) {
            jpVar.a(f17951b);
            this.f746a.b(jpVar);
            jpVar.b();
        }
        if (this.f752b != null) {
            jpVar.a(f17952c);
            jpVar.a(this.f752b);
            jpVar.b();
        }
        if (this.f754c != null && m576d()) {
            jpVar.a(f17953d);
            jpVar.a(this.f754c);
            jpVar.b();
        }
        if (this.f755d != null && e()) {
            jpVar.a(f17954e);
            jpVar.a(this.f755d);
            jpVar.b();
        }
        jpVar.a(f17955f);
        jpVar.a(this.f751a);
        jpVar.b();
        if (this.f756e != null && g()) {
            jpVar.a(f17956g);
            jpVar.a(this.f756e);
            jpVar.b();
        }
        if (this.f750a != null && h()) {
            jpVar.a(f17957h);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f750a.size()));
            for (Map.Entry<String, String> entry : this.f750a.entrySet()) {
                jpVar.a(entry.getKey());
                jpVar.a(entry.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        if (this.f757f != null && i()) {
            jpVar.a(f17958i);
            jpVar.a(this.f757f);
            jpVar.b();
        }
        if (this.f758g != null && j()) {
            jpVar.a(j);
            jpVar.a(this.f758g);
            jpVar.b();
        }
        if (this.f759h != null && k()) {
            jpVar.a(f17959k);
            jpVar.a(this.f759h);
            jpVar.b();
        }
        if (this.f760i != null && l()) {
            jpVar.a(f17960l);
            jpVar.a(this.f760i);
            jpVar.b();
        }
        if (this.f748a != null && m()) {
            jpVar.a(f17961m);
            jpVar.a(this.f748a);
            jpVar.b();
        }
        if (n()) {
            jpVar.a(f17962n);
            jpVar.a(this.f745a);
            jpVar.b();
        }
        if (o()) {
            jpVar.a(f17963o);
            jpVar.a(this.f753b);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m570a(boolean z8) {
        this.f749a.set(0, z8);
    }

    public void a(String str, String str2) {
        if (this.f750a == null) {
            this.f750a = new HashMap();
        }
        this.f750a.put(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m568a() {
        return this.f750a;
    }

    public it a(Map<String, String> map) {
        this.f750a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m573a() {
        a(jg.a(this.f748a));
        return this.f748a.array();
    }

    public it a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public it a(ByteBuffer byteBuffer) {
        this.f748a = byteBuffer;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m572a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean zM571a = m571a();
        boolean zM571a2 = itVar.m571a();
        if ((zM571a || zM571a2) && !(zM571a && zM571a2 && this.f747a.equals(itVar.f747a))) {
            return false;
        }
        boolean zM574b = m574b();
        boolean zM574b2 = itVar.m574b();
        if ((zM574b || zM574b2) && !(zM574b && zM574b2 && this.f746a.m530a(itVar.f746a))) {
            return false;
        }
        boolean zM575c = m575c();
        boolean zM575c2 = itVar.m575c();
        if ((zM575c || zM575c2) && !(zM575c && zM575c2 && this.f752b.equals(itVar.f752b))) {
            return false;
        }
        boolean zM576d = m576d();
        boolean zM576d2 = itVar.m576d();
        if ((zM576d || zM576d2) && !(zM576d && zM576d2 && this.f754c.equals(itVar.f754c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = itVar.e();
        if (((zE || zE2) && !(zE && zE2 && this.f755d.equals(itVar.f755d))) || this.f751a != itVar.f751a) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = itVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f756e.equals(itVar.f756e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = itVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f750a.equals(itVar.f750a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = itVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f757f.equals(itVar.f757f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = itVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f758g.equals(itVar.f758g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = itVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f759h.equals(itVar.f759h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = itVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f760i.equals(itVar.f760i))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = itVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f748a.equals(itVar.f748a))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = itVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f745a == itVar.f745a)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = itVar.o();
        if (zO || zO2) {
            return zO && zO2 && this.f753b == itVar.f753b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(it itVar) {
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
        int iA13;
        int iA14;
        int iA15;
        if (!getClass().equals(itVar.getClass())) {
            return getClass().getName().compareTo(itVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m571a()).compareTo(Boolean.valueOf(itVar.m571a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m571a() && (iA15 = jg.a(this.f747a, itVar.f747a)) != 0) {
            return iA15;
        }
        int iCompareTo2 = Boolean.valueOf(m574b()).compareTo(Boolean.valueOf(itVar.m574b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m574b() && (iA14 = jg.a(this.f746a, itVar.f746a)) != 0) {
            return iA14;
        }
        int iCompareTo3 = Boolean.valueOf(m575c()).compareTo(Boolean.valueOf(itVar.m575c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m575c() && (iA13 = jg.a(this.f752b, itVar.f752b)) != 0) {
            return iA13;
        }
        int iCompareTo4 = Boolean.valueOf(m576d()).compareTo(Boolean.valueOf(itVar.m576d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m576d() && (iA12 = jg.a(this.f754c, itVar.f754c)) != 0) {
            return iA12;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(itVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA11 = jg.a(this.f755d, itVar.f755d)) != 0) {
            return iA11;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(itVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA10 = jg.a(this.f751a, itVar.f751a)) != 0) {
            return iA10;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA9 = jg.a(this.f756e, itVar.f756e)) != 0) {
            return iA9;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA8 = jg.a(this.f750a, itVar.f750a)) != 0) {
            return iA8;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA7 = jg.a(this.f757f, itVar.f757f)) != 0) {
            return iA7;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(itVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA6 = jg.a(this.f758g, itVar.f758g)) != 0) {
            return iA6;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(itVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA5 = jg.a(this.f759h, itVar.f759h)) != 0) {
            return iA5;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(itVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA4 = jg.a(this.f760i, itVar.f760i)) != 0) {
            return iA4;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(itVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA3 = jg.a(this.f748a, itVar.f748a)) != 0) {
            return iA3;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(itVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA2 = jg.a(this.f745a, itVar.f745a)) != 0) {
            return iA2;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(itVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (!o() || (iA = jg.a(this.f753b, itVar.f753b)) == 0) {
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
                if (f()) {
                    m569a();
                    return;
                }
                throw new jq("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f747a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f746a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f752b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f754c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f755d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 2) {
                        this.f751a = jpVar.mo643a();
                        m570a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f756e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 13) {
                        jo joVarMo635a = jpVar.mo635a();
                        this.f750a = new HashMap(joVarMo635a.f918a * 2);
                        for (int i9 = 0; i9 < joVarMo635a.f918a; i9++) {
                            this.f750a.put(jpVar.mo638a(), jpVar.mo638a());
                        }
                        jpVar.h();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f757f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 11) {
                        this.f758g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    js.a(jpVar, b9);
                    break;
                case 12:
                    if (b9 == 11) {
                        this.f759h = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 13:
                    if (b9 == 11) {
                        this.f760i = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 14:
                    if (b9 == 11) {
                        this.f748a = jpVar.mo639a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 15:
                    if (b9 == 10) {
                        this.f745a = jpVar.mo632a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 20:
                    if (b9 == 2) {
                        this.f753b = jpVar.mo643a();
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
    public void m569a() throws jq {
        if (this.f752b != null) {
            return;
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
