package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class iy implements jf<iy, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f842a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f843b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f844c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f845d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f846e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f847f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f839a = new ju("XmPushActionSubscription");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f18029a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f18030b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f18031c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f18032d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f18033e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f18034f = new jm("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f18035g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f18036h = new jm("", (byte) 15, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m600a() {
        return this.f841a != null;
    }

    public boolean b() {
        return this.f840a != null;
    }

    public boolean c() {
        return this.f843b != null;
    }

    public boolean d() {
        return this.f844c != null;
    }

    public boolean e() {
        return this.f845d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iy)) {
            return m601a((iy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f846e != null;
    }

    public boolean g() {
        return this.f847f != null;
    }

    public boolean h() {
        return this.f842a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z9 = false;
        if (m600a()) {
            sb.append("debug:");
            String str = this.f841a;
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
            ij ijVar = this.f840a;
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
        String str2 = this.f843b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f844c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f845d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f846e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f847f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f842a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public iy a(String str) {
        this.f843b = str;
        return this;
    }

    public iy b(String str) {
        this.f844c = str;
        return this;
    }

    public iy c(String str) {
        this.f845d = str;
        return this;
    }

    public iy d(String str) {
        this.f846e = str;
        return this;
    }

    public iy e(String str) {
        this.f847f = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m601a(iy iyVar) {
        if (iyVar == null) {
            return false;
        }
        boolean zM600a = m600a();
        boolean zM600a2 = iyVar.m600a();
        if ((zM600a || zM600a2) && !(zM600a && zM600a2 && this.f841a.equals(iyVar.f841a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = iyVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f840a.m530a(iyVar.f840a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = iyVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f843b.equals(iyVar.f843b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = iyVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f844c.equals(iyVar.f844c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = iyVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f845d.equals(iyVar.f845d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = iyVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f846e.equals(iyVar.f846e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = iyVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f847f.equals(iyVar.f847f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = iyVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f842a.equals(iyVar.f842a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        a();
        jpVar.a(f839a);
        if (this.f841a != null && m600a()) {
            jpVar.a(f18029a);
            jpVar.a(this.f841a);
            jpVar.b();
        }
        if (this.f840a != null && b()) {
            jpVar.a(f18030b);
            this.f840a.b(jpVar);
            jpVar.b();
        }
        if (this.f843b != null) {
            jpVar.a(f18031c);
            jpVar.a(this.f843b);
            jpVar.b();
        }
        if (this.f844c != null) {
            jpVar.a(f18032d);
            jpVar.a(this.f844c);
            jpVar.b();
        }
        if (this.f845d != null) {
            jpVar.a(f18033e);
            jpVar.a(this.f845d);
            jpVar.b();
        }
        if (this.f846e != null && f()) {
            jpVar.a(f18034f);
            jpVar.a(this.f846e);
            jpVar.b();
        }
        if (this.f847f != null && g()) {
            jpVar.a(f18035g);
            jpVar.a(this.f847f);
            jpVar.b();
        }
        if (this.f842a != null && h()) {
            jpVar.a(f18036h);
            jpVar.a(new jn((byte) 11, this.f842a.size()));
            Iterator<String> it = this.f842a.iterator();
            while (it.hasNext()) {
                jpVar.a(it.next());
            }
            jpVar.e();
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iy iyVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(iyVar.getClass())) {
            return getClass().getName().compareTo(iyVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m600a()).compareTo(Boolean.valueOf(iyVar.m600a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m600a() && (iA8 = jg.a(this.f841a, iyVar.f841a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iyVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = jg.a(this.f840a, iyVar.f840a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iyVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = jg.a(this.f843b, iyVar.f843b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iyVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = jg.a(this.f844c, iyVar.f844c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iyVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = jg.a(this.f845d, iyVar.f845d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iyVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = jg.a(this.f846e, iyVar.f846e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iyVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = jg.a(this.f847f, iyVar.f847f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iyVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = jg.a(this.f842a, iyVar.f842a)) == 0) {
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
            switch (jmVarMo633a.f916a) {
                case 1:
                    if (b9 == 11) {
                        this.f841a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f840a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f843b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f844c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f845d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 11) {
                        this.f846e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f847f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 15) {
                        jn jnVarMo634a = jpVar.mo634a();
                        this.f842a = new ArrayList(jnVarMo634a.f917a);
                        for (int i9 = 0; i9 < jnVarMo634a.f917a; i9++) {
                            this.f842a.add(jpVar.mo638a());
                        }
                        jpVar.i();
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

    public void a() throws jq {
        if (this.f843b != null) {
            if (this.f844c != null) {
                if (this.f845d != null) {
                    return;
                }
                throw new jq("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
