package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class in implements jf<in, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<ic> f705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f704a = new ju("XmPushActionCollectData");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17921a = new jm("", (byte) 15, 1);

    public in a(List<ic> list) {
        this.f705a = list;
        return this;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        a();
        jpVar.a(f704a);
        if (this.f705a != null) {
            jpVar.a(f17921a);
            jpVar.a(new jn((byte) 12, this.f705a.size()));
            Iterator<ic> it = this.f705a.iterator();
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
        if (obj != null && (obj instanceof in)) {
            return m541a((in) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(dataCollectionItems:");
        List<ic> list = this.f705a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m540a() {
        return this.f705a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m541a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean zM540a = m540a();
        boolean zM540a2 = inVar.m540a();
        if (zM540a || zM540a2) {
            return zM540a && zM540a2 && this.f705a.equals(inVar.f705a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(in inVar) {
        int iA;
        if (!getClass().equals(inVar.getClass())) {
            return getClass().getName().compareTo(inVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m540a()).compareTo(Boolean.valueOf(inVar.m540a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m540a() || (iA = jg.a(this.f705a, inVar.f705a)) == 0) {
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
            if (jmVarMo633a.f916a != 1) {
                js.a(jpVar, b9);
            } else if (b9 == 15) {
                jn jnVarMo634a = jpVar.mo634a();
                this.f705a = new ArrayList(jnVarMo634a.f917a);
                for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                    ic icVar = new ic();
                    icVar.a(jpVar);
                    this.f705a.add(icVar);
                }
                jpVar.i();
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
    }

    public void a() throws jq {
        if (this.f705a != null) {
            return;
        }
        throw new jq("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }
}
