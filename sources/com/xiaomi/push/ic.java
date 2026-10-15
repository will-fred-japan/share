package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class ic implements jf<ic, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hw f602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f604a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f600a = new ju("DataCollectionItem");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17792a = new jm("", (byte) 10, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17793b = new jm("", (byte) 8, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17794c = new jm("", (byte) 11, 3);

    public ic a(long j) {
        this.f601a = j;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f602a != null;
    }

    public boolean c() {
        return this.f603a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m498a((ic) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(collectedAt:");
        sb.append(this.f601a);
        sb.append(", ");
        sb.append("collectionType:");
        hw hwVar = this.f602a;
        if (hwVar == null) {
            sb.append("null");
        } else {
            sb.append(hwVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f603a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m496a();
        jpVar.a(f600a);
        jpVar.a(f17792a);
        jpVar.a(this.f601a);
        jpVar.b();
        if (this.f602a != null) {
            jpVar.a(f17793b);
            jpVar.mo642a(this.f602a.a());
            jpVar.b();
        }
        if (this.f603a != null) {
            jpVar.a(f17794c);
            jpVar.a(this.f603a);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m497a() {
        return this.f604a.get(0);
    }

    public void a(boolean z8) {
        this.f604a.set(0, z8);
    }

    public ic a(hw hwVar) {
        this.f602a = hwVar;
        return this;
    }

    public String a() {
        return this.f603a;
    }

    public ic a(String str) {
        this.f603a = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m498a(ic icVar) {
        if (icVar == null || this.f601a != icVar.f601a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = icVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f602a.equals(icVar.f602a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = icVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f603a.equals(icVar.f603a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ic icVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(icVar.getClass())) {
            return getClass().getName().compareTo(icVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m497a()).compareTo(Boolean.valueOf(icVar.m497a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m497a() && (iA3 = jg.a(this.f601a, icVar.f601a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(icVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = jg.a(this.f602a, icVar.f602a)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = jg.a(this.f603a, icVar.f603a)) == 0) {
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
                break;
            }
            short s8 = jmVarMo633a.f916a;
            if (s8 != 1) {
                if (s8 != 2) {
                    if (s8 != 3) {
                        js.a(jpVar, b9);
                    } else if (b9 == 11) {
                        this.f603a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                } else if (b9 == 8) {
                    this.f602a = hw.a(jpVar.mo631a());
                } else {
                    js.a(jpVar, b9);
                }
            } else if (b9 == 10) {
                this.f601a = jpVar.mo632a();
                a(true);
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
        jpVar.f();
        if (m497a()) {
            m496a();
        } else {
            throw new jq("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m496a() throws jq {
        if (this.f602a != null) {
            if (this.f603a != null) {
                return;
            }
            throw new jq("Required field 'content' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'collectionType' was not present! Struct: " + toString());
    }
}
