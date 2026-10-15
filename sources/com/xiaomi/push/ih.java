package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ih implements jf<ih, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f647a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f648b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f649b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Map<String, String> f650b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f651c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f652c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Map<String, String> f653c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f654d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f655e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f641a = new ju("PushMetaInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17871a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17872b = new jm("", (byte) 10, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17873c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17874d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17875e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17876f = new jm("", (byte) 8, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17877g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17878h = new jm("", (byte) 8, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17879i = new jm("", (byte) 8, 9);
    private static final jm j = new jm("", (byte) 13, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f17880k = new jm("", (byte) 13, 11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final jm f17881l = new jm("", (byte) 2, 12);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final jm f17882m = new jm("", (byte) 13, 13);

    public ih() {
        this.f645a = new BitSet(5);
        this.f647a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ih m517a() {
        return new ih(this);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m525b() {
        return this.f645a.get(0);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m527c() {
        return this.f649b != null;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m528d() {
        return this.f652c != null;
    }

    public boolean e() {
        return this.f654d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m522a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f645a.get(1);
    }

    public boolean g() {
        return this.f655e != null;
    }

    public boolean h() {
        return this.f645a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f645a.get(3);
    }

    public boolean j() {
        return this.f646a != null;
    }

    public boolean k() {
        return this.f650b != null;
    }

    public boolean l() {
        return this.f647a;
    }

    public boolean m() {
        return this.f645a.get(4);
    }

    public boolean n() {
        return this.f653c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(id:");
        String str = this.f644a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.as.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f643a);
        if (m527c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f649b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m528d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f652c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f654d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f642a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f655e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f648b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f651c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f646a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f650b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f647a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f653c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m518a() {
        return this.f644a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m523b() {
        return this.f649b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m526c() {
        return this.f652c;
    }

    public String d() {
        return this.f654d;
    }

    public void e(boolean z8) {
        this.f645a.set(4, z8);
    }

    public ih a(String str) {
        this.f644a = str;
        return this;
    }

    public ih b(String str) {
        this.f649b = str;
        return this;
    }

    public ih c(String str) {
        this.f652c = str;
        return this;
    }

    public ih d(String str) {
        this.f654d = str;
        return this;
    }

    public ih(ih ihVar) {
        BitSet bitSet = new BitSet(5);
        this.f645a = bitSet;
        bitSet.clear();
        this.f645a.or(ihVar.f645a);
        if (ihVar.m521a()) {
            this.f644a = ihVar.f644a;
        }
        this.f643a = ihVar.f643a;
        if (ihVar.m527c()) {
            this.f649b = ihVar.f649b;
        }
        if (ihVar.m528d()) {
            this.f652c = ihVar.f652c;
        }
        if (ihVar.e()) {
            this.f654d = ihVar.f654d;
        }
        this.f642a = ihVar.f642a;
        if (ihVar.g()) {
            this.f655e = ihVar.f655e;
        }
        this.f648b = ihVar.f648b;
        this.f651c = ihVar.f651c;
        if (ihVar.j()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, String> entry : ihVar.f646a.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            this.f646a = map;
        }
        if (ihVar.k()) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, String> entry2 : ihVar.f650b.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue());
            }
            this.f650b = map2;
        }
        this.f647a = ihVar.f647a;
        if (ihVar.n()) {
            HashMap map3 = new HashMap();
            for (Map.Entry<String, String> entry3 : ihVar.f653c.entrySet()) {
                map3.put(entry3.getKey(), entry3.getValue());
            }
            this.f653c = map3;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m521a() {
        return this.f644a != null;
    }

    public void b(boolean z8) {
        this.f645a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f645a.set(2, z8);
    }

    public void d(boolean z8) {
        this.f645a.set(3, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m516a() {
        return this.f643a;
    }

    public int b() {
        return this.f648b;
    }

    public int c() {
        return this.f651c;
    }

    public void a(boolean z8) {
        this.f645a.set(0, z8);
    }

    public ih b(int i9) {
        this.f648b = i9;
        c(true);
        return this;
    }

    public ih c(int i9) {
        this.f651c = i9;
        d(true);
        return this;
    }

    public int a() {
        return this.f642a;
    }

    public ih a(int i9) {
        this.f642a = i9;
        b(true);
        return this;
    }

    public void b(String str, String str2) {
        if (this.f650b == null) {
            this.f650b = new HashMap();
        }
        this.f650b.put(str, str2);
    }

    public void a(String str, String str2) {
        if (this.f646a == null) {
            this.f646a = new HashMap();
        }
        this.f646a.put(str, str2);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public Map<String, String> m524b() {
        return this.f650b;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m520a();
        jpVar.a(f641a);
        if (this.f644a != null) {
            jpVar.a(f17871a);
            jpVar.a(this.f644a);
            jpVar.b();
        }
        jpVar.a(f17872b);
        jpVar.a(this.f643a);
        jpVar.b();
        if (this.f649b != null && m527c()) {
            jpVar.a(f17873c);
            jpVar.a(this.f649b);
            jpVar.b();
        }
        if (this.f652c != null && m528d()) {
            jpVar.a(f17874d);
            jpVar.a(this.f652c);
            jpVar.b();
        }
        if (this.f654d != null && e()) {
            jpVar.a(f17875e);
            jpVar.a(this.f654d);
            jpVar.b();
        }
        if (f()) {
            jpVar.a(f17876f);
            jpVar.mo642a(this.f642a);
            jpVar.b();
        }
        if (this.f655e != null && g()) {
            jpVar.a(f17877g);
            jpVar.a(this.f655e);
            jpVar.b();
        }
        if (h()) {
            jpVar.a(f17878h);
            jpVar.mo642a(this.f648b);
            jpVar.b();
        }
        if (i()) {
            jpVar.a(f17879i);
            jpVar.mo642a(this.f651c);
            jpVar.b();
        }
        if (this.f646a != null && j()) {
            jpVar.a(j);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f646a.size()));
            for (Map.Entry<String, String> entry : this.f646a.entrySet()) {
                jpVar.a(entry.getKey());
                jpVar.a(entry.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        if (this.f650b != null && k()) {
            jpVar.a(f17880k);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f650b.size()));
            for (Map.Entry<String, String> entry2 : this.f650b.entrySet()) {
                jpVar.a(entry2.getKey());
                jpVar.a(entry2.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        if (m()) {
            jpVar.a(f17881l);
            jpVar.a(this.f647a);
            jpVar.b();
        }
        if (this.f653c != null && n()) {
            jpVar.a(f17882m);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f653c.size()));
            for (Map.Entry<String, String> entry3 : this.f653c.entrySet()) {
                jpVar.a(entry3.getKey());
                jpVar.a(entry3.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m519a() {
        return this.f646a;
    }

    public ih a(Map<String, String> map) {
        this.f646a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m522a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean zM521a = m521a();
        boolean zM521a2 = ihVar.m521a();
        if (((zM521a || zM521a2) && !(zM521a && zM521a2 && this.f644a.equals(ihVar.f644a))) || this.f643a != ihVar.f643a) {
            return false;
        }
        boolean zM527c = m527c();
        boolean zM527c2 = ihVar.m527c();
        if ((zM527c || zM527c2) && !(zM527c && zM527c2 && this.f649b.equals(ihVar.f649b))) {
            return false;
        }
        boolean zM528d = m528d();
        boolean zM528d2 = ihVar.m528d();
        if ((zM528d || zM528d2) && !(zM528d && zM528d2 && this.f652c.equals(ihVar.f652c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ihVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f654d.equals(ihVar.f654d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ihVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f642a == ihVar.f642a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ihVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f655e.equals(ihVar.f655e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ihVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f648b == ihVar.f648b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ihVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f651c == ihVar.f651c)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ihVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f646a.equals(ihVar.f646a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = ihVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f650b.equals(ihVar.f650b))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = ihVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f647a == ihVar.f647a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = ihVar.n();
        if (zN || zN2) {
            return zN && zN2 && this.f653c.equals(ihVar.f653c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ih ihVar) {
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
        if (!getClass().equals(ihVar.getClass())) {
            return getClass().getName().compareTo(ihVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m521a()).compareTo(Boolean.valueOf(ihVar.m521a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m521a() && (iA13 = jg.a(this.f644a, ihVar.f644a)) != 0) {
            return iA13;
        }
        int iCompareTo2 = Boolean.valueOf(m525b()).compareTo(Boolean.valueOf(ihVar.m525b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m525b() && (iA12 = jg.a(this.f643a, ihVar.f643a)) != 0) {
            return iA12;
        }
        int iCompareTo3 = Boolean.valueOf(m527c()).compareTo(Boolean.valueOf(ihVar.m527c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m527c() && (iA11 = jg.a(this.f649b, ihVar.f649b)) != 0) {
            return iA11;
        }
        int iCompareTo4 = Boolean.valueOf(m528d()).compareTo(Boolean.valueOf(ihVar.m528d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m528d() && (iA10 = jg.a(this.f652c, ihVar.f652c)) != 0) {
            return iA10;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA9 = jg.a(this.f654d, ihVar.f654d)) != 0) {
            return iA9;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA8 = jg.a(this.f642a, ihVar.f642a)) != 0) {
            return iA8;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA7 = jg.a(this.f655e, ihVar.f655e)) != 0) {
            return iA7;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA6 = jg.a(this.f648b, ihVar.f648b)) != 0) {
            return iA6;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA5 = jg.a(this.f651c, ihVar.f651c)) != 0) {
            return iA5;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA4 = jg.a(this.f646a, ihVar.f646a)) != 0) {
            return iA4;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ihVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA3 = jg.a(this.f650b, ihVar.f650b)) != 0) {
            return iA3;
        }
        int iCompareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ihVar.m()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (m() && (iA2 = jg.a(this.f647a, ihVar.f647a)) != 0) {
            return iA2;
        }
        int iCompareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ihVar.n()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (!n() || (iA = jg.a(this.f653c, ihVar.f653c)) == 0) {
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
                if (m525b()) {
                    m520a();
                    return;
                }
                throw new jq("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i9 = 0;
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f644a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 10) {
                        this.f643a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f649b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f652c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f654d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 8) {
                        this.f642a = jpVar.mo631a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f655e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 8) {
                        this.f648b = jpVar.mo631a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 8) {
                        this.f651c = jpVar.mo631a();
                        d(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 13) {
                        jo joVarMo635a = jpVar.mo635a();
                        this.f646a = new HashMap(joVarMo635a.f918a * 2);
                        while (i9 < joVarMo635a.f918a) {
                            this.f646a.put(jpVar.mo638a(), jpVar.mo638a());
                            i9++;
                        }
                        jpVar.h();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 13) {
                        jo joVarMo635a2 = jpVar.mo635a();
                        this.f650b = new HashMap(joVarMo635a2.f918a * 2);
                        while (i9 < joVarMo635a2.f918a) {
                            this.f650b.put(jpVar.mo638a(), jpVar.mo638a());
                            i9++;
                        }
                        jpVar.h();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 12:
                    if (b9 == 2) {
                        this.f647a = jpVar.mo643a();
                        e(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 13:
                    if (b9 == 13) {
                        jo joVarMo635a3 = jpVar.mo635a();
                        this.f653c = new HashMap(joVarMo635a3.f918a * 2);
                        while (i9 < joVarMo635a3.f918a) {
                            this.f653c.put(jpVar.mo638a(), jpVar.mo638a());
                            i9++;
                        }
                        jpVar.h();
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
    public void m520a() throws jq {
        if (this.f644a != null) {
            return;
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
