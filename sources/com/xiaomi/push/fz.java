package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class fz implements jf<fz, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<fy> f454a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f455b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f452a = new ju("StatsEvents");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17500a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17501b = new jm("", (byte) 11, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17502c = new jm("", (byte) 15, 3);

    public fz() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m395a() {
        return this.f453a != null;
    }

    public boolean b() {
        return this.f455b != null;
    }

    public boolean c() {
        return this.f454a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fz)) {
            return m396a((fz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(uuid:");
        String str = this.f453a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f455b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<fy> list = this.f454a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public fz(String str, List<fy> list) {
        this();
        this.f453a = str;
        this.f454a = list;
    }

    public fz a(String str) {
        this.f455b = str;
        return this;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        a();
        jpVar.a(f452a);
        if (this.f453a != null) {
            jpVar.a(f17500a);
            jpVar.a(this.f453a);
            jpVar.b();
        }
        if (this.f455b != null && b()) {
            jpVar.a(f17501b);
            jpVar.a(this.f455b);
            jpVar.b();
        }
        if (this.f454a != null) {
            jpVar.a(f17502c);
            jpVar.a(new jn((byte) 12, this.f454a.size()));
            Iterator<fy> it = this.f454a.iterator();
            while (it.hasNext()) {
                it.next().b(jpVar);
            }
            jpVar.e();
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m396a(fz fzVar) {
        if (fzVar == null) {
            return false;
        }
        boolean zM395a = m395a();
        boolean zM395a2 = fzVar.m395a();
        if ((zM395a || zM395a2) && !(zM395a && zM395a2 && this.f453a.equals(fzVar.f453a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = fzVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f455b.equals(fzVar.f455b))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = fzVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f454a.equals(fzVar.f454a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(fz fzVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(fzVar.getClass())) {
            return getClass().getName().compareTo(fzVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m395a()).compareTo(Boolean.valueOf(fzVar.m395a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m395a() && (iA3 = jg.a(this.f453a, fzVar.f453a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fzVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = jg.a(this.f455b, fzVar.f455b)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fzVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = jg.a(this.f454a, fzVar.f454a)) == 0) {
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
                a();
                return;
            }
            short s8 = jmVarMo633a.f916a;
            if (s8 != 1) {
                if (s8 != 2) {
                    if (s8 != 3) {
                        js.a(jpVar, b9);
                    } else if (b9 == 15) {
                        jn jnVarMo634a = jpVar.mo634a();
                        this.f454a = new ArrayList(jnVarMo634a.f917a);
                        for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                            fy fyVar = new fy();
                            fyVar.a(jpVar);
                            this.f454a.add(fyVar);
                        }
                        jpVar.i();
                    } else {
                        js.a(jpVar, b9);
                    }
                } else if (b9 == 11) {
                    this.f455b = jpVar.mo638a();
                } else {
                    js.a(jpVar, b9);
                }
            } else if (b9 == 11) {
                this.f453a = jpVar.mo638a();
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
    }

    public void a() throws jq {
        if (this.f453a != null) {
            if (this.f454a != null) {
                return;
            }
            throw new jq("Required field 'events' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'uuid' was not present! Struct: " + toString());
    }
}
