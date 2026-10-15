package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class ij implements jf<ij, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f660a;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f665d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f658a = new ju("Target");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17886a = new jm("", (byte) 10, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17887b = new jm("", (byte) 11, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17888c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17889d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17890e = new jm("", (byte) 2, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17891f = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f661a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f659a = 5;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f663b = "xiaomi.com";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f664c = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f662a = false;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m529a() {
        return this.f661a.get(0);
    }

    public boolean b() {
        return this.f660a != null;
    }

    public boolean c() {
        return this.f663b != null;
    }

    public boolean d() {
        return this.f664c != null;
    }

    public boolean e() {
        return this.f661a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m530a((ij) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f665d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(channelId:");
        sb.append(this.f659a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f660a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f663b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f664c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f662a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f665d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z8) {
        this.f661a.set(0, z8);
    }

    public void b(boolean z8) {
        this.f661a.set(1, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m530a(ij ijVar) {
        if (ijVar == null || this.f659a != ijVar.f659a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = ijVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f660a.equals(ijVar.f660a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = ijVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f663b.equals(ijVar.f663b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ijVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f664c.equals(ijVar.f664c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ijVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f662a == ijVar.f662a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ijVar.f();
        if (zF || zF2) {
            return zF && zF2 && this.f665d.equals(ijVar.f665d);
        }
        return true;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) {
        a();
        jpVar.a(f658a);
        jpVar.a(f17886a);
        jpVar.a(this.f659a);
        jpVar.b();
        if (this.f660a != null) {
            jpVar.a(f17887b);
            jpVar.a(this.f660a);
            jpVar.b();
        }
        if (this.f663b != null && c()) {
            jpVar.a(f17888c);
            jpVar.a(this.f663b);
            jpVar.b();
        }
        if (this.f664c != null && d()) {
            jpVar.a(f17889d);
            jpVar.a(this.f664c);
            jpVar.b();
        }
        if (e()) {
            jpVar.a(f17890e);
            jpVar.a(this.f662a);
            jpVar.b();
        }
        if (this.f665d != null && f()) {
            jpVar.a(f17891f);
            jpVar.a(this.f665d);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ij ijVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        if (!getClass().equals(ijVar.getClass())) {
            return getClass().getName().compareTo(ijVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m529a()).compareTo(Boolean.valueOf(ijVar.m529a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m529a() && (iA6 = jg.a(this.f659a, ijVar.f659a)) != 0) {
            return iA6;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ijVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA5 = jg.a(this.f660a, ijVar.f660a)) != 0) {
            return iA5;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ijVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA4 = jg.a(this.f663b, ijVar.f663b)) != 0) {
            return iA4;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA3 = jg.a(this.f664c, ijVar.f664c)) != 0) {
            return iA3;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA2 = jg.a(this.f662a, ijVar.f662a)) != 0) {
            return iA2;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (!f() || (iA = jg.a(this.f665d, ijVar.f665d)) == 0) {
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
                break;
            }
            short s8 = jmVarMo633a.f916a;
            if (s8 != 1) {
                if (s8 != 2) {
                    if (s8 != 3) {
                        if (s8 != 4) {
                            if (s8 != 5) {
                                if (s8 != 7) {
                                    js.a(jpVar, b9);
                                } else if (b9 == 11) {
                                    this.f665d = jpVar.mo638a();
                                } else {
                                    js.a(jpVar, b9);
                                }
                            } else if (b9 == 2) {
                                this.f662a = jpVar.mo643a();
                                b(true);
                            } else {
                                js.a(jpVar, b9);
                            }
                        } else if (b9 == 11) {
                            this.f664c = jpVar.mo638a();
                        } else {
                            js.a(jpVar, b9);
                        }
                    } else if (b9 == 11) {
                        this.f663b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                } else if (b9 == 11) {
                    this.f660a = jpVar.mo638a();
                } else {
                    js.a(jpVar, b9);
                }
            } else if (b9 == 10) {
                this.f659a = jpVar.mo632a();
                a(true);
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
        jpVar.f();
        if (m529a()) {
            a();
        } else {
            throw new jq("Required field 'channelId' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a() throws jq {
        if (this.f660a != null) {
            return;
        }
        throw new jq("Required field 'userId' was not present! Struct: " + toString());
    }
}
