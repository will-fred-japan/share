package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ir implements jf<ir, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Cif> f741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f740a = new ju("XmPushActionCustomConfig");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17948a = new jm("", (byte) 15, 1);

    public List<Cif> a() {
        return this.f741a;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m561a();
        jpVar.a(f740a);
        if (this.f741a != null) {
            jpVar.a(f17948a);
            jpVar.a(new jn((byte) 12, this.f741a.size()));
            Iterator<Cif> it = this.f741a.iterator();
            while (it.hasNext()) {
                it.next().b(jpVar);
            }
            jpVar.e();
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m563a((ir) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(customConfigs:");
        List<Cif> list = this.f741a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m562a() {
        return this.f741a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m563a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean zM562a = m562a();
        boolean zM562a2 = irVar.m562a();
        if (zM562a || zM562a2) {
            return zM562a && zM562a2 && this.f741a.equals(irVar.f741a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ir irVar) {
        int iA;
        if (!getClass().equals(irVar.getClass())) {
            return getClass().getName().compareTo(irVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m562a()).compareTo(Boolean.valueOf(irVar.m562a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m562a() || (iA = jg.a(this.f741a, irVar.f741a)) == 0) {
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
                m561a();
                return;
            }
            if (jmVarMo633a.f916a != 1) {
                js.a(jpVar, b9);
            } else if (b9 == 15) {
                jn jnVarMo634a = jpVar.mo634a();
                this.f741a = new ArrayList(jnVarMo634a.f917a);
                for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                    Cif cif = new Cif();
                    cif.a(jpVar);
                    this.f741a.add(cif);
                }
                jpVar.i();
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m561a() throws jq {
        if (this.f741a != null) {
            return;
        }
        throw new jq("Required field 'customConfigs' was not present! Struct: " + toString());
    }
}
