package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class is implements jf<is, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<id> f743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f742a = new ju("XmPushActionNormalConfig");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17949a = new jm("", (byte) 15, 1);

    public List<id> a() {
        return this.f743a;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m564a();
        jpVar.a(f742a);
        if (this.f743a != null) {
            jpVar.a(f17949a);
            jpVar.a(new jn((byte) 12, this.f743a.size()));
            Iterator<id> it = this.f743a.iterator();
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
        if (obj != null && (obj instanceof is)) {
            return m566a((is) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(normalConfigs:");
        List<id> list = this.f743a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m565a() {
        return this.f743a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m566a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean zM565a = m565a();
        boolean zM565a2 = isVar.m565a();
        if (zM565a || zM565a2) {
            return zM565a && zM565a2 && this.f743a.equals(isVar.f743a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(is isVar) {
        int iA;
        if (!getClass().equals(isVar.getClass())) {
            return getClass().getName().compareTo(isVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m565a()).compareTo(Boolean.valueOf(isVar.m565a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m565a() || (iA = jg.a(this.f743a, isVar.f743a)) == 0) {
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
                m564a();
                return;
            }
            if (jmVarMo633a.f916a != 1) {
                js.a(jpVar, b9);
            } else if (b9 == 15) {
                jn jnVarMo634a = jpVar.mo634a();
                this.f743a = new ArrayList(jnVarMo634a.f917a);
                for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                    id idVar = new id();
                    idVar.a(jpVar);
                    this.f743a.add(idVar);
                }
                jpVar.i();
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m564a() throws jq {
        if (this.f743a != null) {
            return;
        }
        throw new jq("Required field 'normalConfigs' was not present! Struct: " + toString());
    }
}
