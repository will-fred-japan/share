package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hx implements jf<hx, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<hy> f580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f579a = new ju("ClientUploadData");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17723a = new jm("", (byte) 15, 1);

    public int a() {
        List<hy> list = this.f580a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m483a();
        jpVar.a(f579a);
        if (this.f580a != null) {
            jpVar.a(f17723a);
            jpVar.a(new jn((byte) 12, this.f580a.size()));
            Iterator<hy> it = this.f580a.iterator();
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
        if (obj != null && (obj instanceof hx)) {
            return m485a((hx) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(uploadDataItems:");
        List<hy> list = this.f580a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(hy hyVar) {
        if (this.f580a == null) {
            this.f580a = new ArrayList();
        }
        this.f580a.add(hyVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m484a() {
        return this.f580a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m485a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean zM484a = m484a();
        boolean zM484a2 = hxVar.m484a();
        if (zM484a || zM484a2) {
            return zM484a && zM484a2 && this.f580a.equals(hxVar.f580a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hx hxVar) {
        int iA;
        if (!getClass().equals(hxVar.getClass())) {
            return getClass().getName().compareTo(hxVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m484a()).compareTo(Boolean.valueOf(hxVar.m484a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m484a() || (iA = jg.a(this.f580a, hxVar.f580a)) == 0) {
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
                m483a();
                return;
            }
            if (jmVarMo633a.f916a != 1) {
                js.a(jpVar, b9);
            } else if (b9 == 15) {
                jn jnVarMo634a = jpVar.mo634a();
                this.f580a = new ArrayList(jnVarMo634a.f917a);
                for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                    hy hyVar = new hy();
                    hyVar.a(jpVar);
                    this.f580a.add(hyVar);
                }
                jpVar.i();
            } else {
                js.a(jpVar, b9);
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m483a() throws jq {
        if (this.f580a != null) {
            return;
        }
        throw new jq("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }
}
