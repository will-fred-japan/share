package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class id implements jf<id, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ia f607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f608a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Cif> f609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f605a = new ju("NormalConfig");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17795a = new jm("", (byte) 8, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17796b = new jm("", (byte) 15, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17797c = new jm("", (byte) 8, 3);

    public int a() {
        return this.f606a;
    }

    public boolean b() {
        return this.f609a != null;
    }

    public boolean c() {
        return this.f607a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m502a((id) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(version:");
        sb.append(this.f606a);
        sb.append(", ");
        sb.append("configItems:");
        List<Cif> list = this.f609a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            ia iaVar = this.f607a;
            if (iaVar == null) {
                sb.append("null");
            } else {
                sb.append(iaVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m501a() {
        return this.f608a.get(0);
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m500a();
        jpVar.a(f605a);
        jpVar.a(f17795a);
        jpVar.mo642a(this.f606a);
        jpVar.b();
        if (this.f609a != null) {
            jpVar.a(f17796b);
            jpVar.a(new jn((byte) 12, this.f609a.size()));
            Iterator<Cif> it = this.f609a.iterator();
            while (it.hasNext()) {
                it.next().b(jpVar);
            }
            jpVar.e();
            jpVar.b();
        }
        if (this.f607a != null && c()) {
            jpVar.a(f17797c);
            jpVar.mo642a(this.f607a.a());
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public void a(boolean z8) {
        this.f608a.set(0, z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ia m499a() {
        return this.f607a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m502a(id idVar) {
        if (idVar == null || this.f606a != idVar.f606a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = idVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f609a.equals(idVar.f609a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = idVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f607a.equals(idVar.f607a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(id idVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(idVar.getClass())) {
            return getClass().getName().compareTo(idVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m501a()).compareTo(Boolean.valueOf(idVar.m501a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m501a() && (iA3 = jg.a(this.f606a, idVar.f606a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = jg.a(this.f609a, idVar.f609a)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = jg.a(this.f607a, idVar.f607a)) == 0) {
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
                    } else if (b9 == 8) {
                        this.f607a = ia.a(jpVar.mo631a());
                    } else {
                        js.a(jpVar, b9);
                    }
                } else if (b9 == 15) {
                    jn jnVarMo634a = jpVar.mo634a();
                    this.f609a = new ArrayList(jnVarMo634a.f917a);
                    for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                        Cif cif = new Cif();
                        cif.a(jpVar);
                        this.f609a.add(cif);
                    }
                    jpVar.i();
                } else {
                    js.a(jpVar, b9);
                }
            } else if (b9 == 8) {
                this.f606a = jpVar.mo631a();
                a(true);
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
        jpVar.f();
        if (m501a()) {
            m500a();
        } else {
            throw new jq("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m500a() throws jq {
        if (this.f609a != null) {
            return;
        }
        throw new jq("Required field 'configItems' was not present! Struct: " + toString());
    }
}
