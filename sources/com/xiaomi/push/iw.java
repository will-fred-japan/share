package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class iw implements jf<iw, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f820a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f821b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f822c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f823d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f824e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f816a = new ju("XmPushActionSendFeedbackResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f18011a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f18012b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f18013c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f18014d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f18015e = new jm("", (byte) 10, 6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f18016f = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f18017g = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m589a() {
        return this.f819a != null;
    }

    public boolean b() {
        return this.f818a != null;
    }

    public boolean c() {
        return this.f821b != null;
    }

    public boolean d() {
        return this.f822c != null;
    }

    public boolean e() {
        return this.f820a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iw)) {
            return m590a((iw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f823d != null;
    }

    public boolean g() {
        return this.f824e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z9 = false;
        if (m589a()) {
            sb.append("debug:");
            String str = this.f819a;
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
            ij ijVar = this.f818a;
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
        String str2 = this.f821b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f822c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f817a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f823d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f824e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z8) {
        this.f820a.set(0, z8);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        a();
        jpVar.a(f816a);
        if (this.f819a != null && m589a()) {
            jpVar.a(f18011a);
            jpVar.a(this.f819a);
            jpVar.b();
        }
        if (this.f818a != null && b()) {
            jpVar.a(f18012b);
            this.f818a.b(jpVar);
            jpVar.b();
        }
        if (this.f821b != null) {
            jpVar.a(f18013c);
            jpVar.a(this.f821b);
            jpVar.b();
        }
        if (this.f822c != null) {
            jpVar.a(f18014d);
            jpVar.a(this.f822c);
            jpVar.b();
        }
        jpVar.a(f18015e);
        jpVar.a(this.f817a);
        jpVar.b();
        if (this.f823d != null && f()) {
            jpVar.a(f18016f);
            jpVar.a(this.f823d);
            jpVar.b();
        }
        if (this.f824e != null && g()) {
            jpVar.a(f18017g);
            jpVar.a(this.f824e);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m590a(iw iwVar) {
        if (iwVar == null) {
            return false;
        }
        boolean zM589a = m589a();
        boolean zM589a2 = iwVar.m589a();
        if ((zM589a || zM589a2) && !(zM589a && zM589a2 && this.f819a.equals(iwVar.f819a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = iwVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f818a.m530a(iwVar.f818a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = iwVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f821b.equals(iwVar.f821b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = iwVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f822c.equals(iwVar.f822c))) || this.f817a != iwVar.f817a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = iwVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f823d.equals(iwVar.f823d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = iwVar.g();
        if (zG || zG2) {
            return zG && zG2 && this.f824e.equals(iwVar.f824e);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iw iwVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        if (!getClass().equals(iwVar.getClass())) {
            return getClass().getName().compareTo(iwVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m589a()).compareTo(Boolean.valueOf(iwVar.m589a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m589a() && (iA7 = jg.a(this.f819a, iwVar.f819a)) != 0) {
            return iA7;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iwVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA6 = jg.a(this.f818a, iwVar.f818a)) != 0) {
            return iA6;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iwVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA5 = jg.a(this.f821b, iwVar.f821b)) != 0) {
            return iA5;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iwVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA4 = jg.a(this.f822c, iwVar.f822c)) != 0) {
            return iA4;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iwVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA3 = jg.a(this.f817a, iwVar.f817a)) != 0) {
            return iA3;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iwVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA2 = jg.a(this.f823d, iwVar.f823d)) != 0) {
            return iA2;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iwVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (!g() || (iA = jg.a(this.f824e, iwVar.f824e)) == 0) {
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
                    a();
                    return;
                }
                throw new jq("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f819a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f818a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f821b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f822c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                default:
                    js.a(jpVar, b9);
                    break;
                case 6:
                    if (b9 == 10) {
                        this.f817a = jpVar.mo632a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f823d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f824e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
            }
            jpVar.g();
        }
    }

    public void a() throws jq {
        if (this.f821b != null) {
            if (this.f822c != null) {
                return;
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
