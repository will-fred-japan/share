package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class iu implements jf<iu, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ii f764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij f765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f768a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f770b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f771b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f772b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f774c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f775c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f777d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f778d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f779e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f780e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f781f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f782g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f783h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f784i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f785j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f786k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f787l;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public String f788m;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public String f789n;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public String f790o;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public String f791p;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    public String f792q;

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    public String f793r;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ju f761a = new ju("XmPushActionRegistration");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final jm f17969a = new jm("", (byte) 11, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final jm f17970b = new jm("", (byte) 12, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final jm f17971c = new jm("", (byte) 11, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final jm f17972d = new jm("", (byte) 11, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final jm f17973e = new jm("", (byte) 11, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final jm f17974f = new jm("", (byte) 11, 6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final jm f17975g = new jm("", (byte) 11, 7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final jm f17976h = new jm("", (byte) 11, 8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final jm f17977i = new jm("", (byte) 11, 9);
    private static final jm j = new jm("", (byte) 11, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final jm f17978k = new jm("", (byte) 11, 11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final jm f17979l = new jm("", (byte) 11, 12);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final jm f17980m = new jm("", (byte) 8, 13);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final jm f17981n = new jm("", (byte) 8, 14);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final jm f17982o = new jm("", (byte) 11, 15);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final jm f17983p = new jm("", (byte) 11, 16);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final jm f17984q = new jm("", (byte) 11, 17);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final jm f17985r = new jm("", (byte) 11, 18);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final jm f17986s = new jm("", (byte) 8, 19);
    private static final jm t = new jm("", (byte) 8, 20);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final jm f17987u = new jm("", (byte) 2, 21);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final jm f17988v = new jm("", (byte) 10, 22);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final jm f17989w = new jm("", (byte) 10, 23);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final jm f17990x = new jm("", (byte) 11, 24);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final jm f17991y = new jm("", (byte) 11, 25);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final jm f17992z = new jm("", (byte) 2, 26);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final jm f17964A = new jm("", (byte) 13, 100);

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final jm f17965B = new jm("", (byte) 2, 101);

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final jm f17966C = new jm("", (byte) 11, 102);

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final jm f17967D = new jm("", (byte) 8, 103);

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final jm f17968E = new jm("", (byte) 8, 104);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f767a = new BitSet(10);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f769a = true;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f776c = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f773b = false;

    public boolean A() {
        return this.f768a != null;
    }

    public boolean B() {
        return this.f767a.get(7);
    }

    public boolean C() {
        return this.f793r != null;
    }

    public boolean D() {
        return this.f767a.get(8);
    }

    public boolean E() {
        return this.f767a.get(9);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m578a() {
        return this.f766a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m580b() {
        return this.f765a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m581c() {
        return this.f772b != null;
    }

    public boolean d() {
        return this.f775c != null;
    }

    public boolean e() {
        return this.f778d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iu)) {
            return m579a((iu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f780e != null;
    }

    public boolean g() {
        return this.f781f != null;
    }

    public boolean h() {
        return this.f782g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f783h != null;
    }

    public boolean j() {
        return this.f784i != null;
    }

    public boolean k() {
        return this.f785j != null;
    }

    public boolean l() {
        return this.f786k != null;
    }

    public boolean m() {
        return this.f767a.get(0);
    }

    public boolean n() {
        return this.f767a.get(1);
    }

    public boolean o() {
        return this.f787l != null;
    }

    public boolean p() {
        return this.f788m != null;
    }

    public boolean q() {
        return this.f789n != null;
    }

    public boolean r() {
        return this.f790o != null;
    }

    public boolean s() {
        return this.f767a.get(2);
    }

    public boolean t() {
        return this.f764a != null;
    }

    public String toString() {
        boolean z8;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z9 = false;
        if (m578a()) {
            sb.append("debug:");
            String str = this.f766a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z8 = false;
        } else {
            z8 = true;
        }
        if (m580b()) {
            if (!z8) {
                sb.append(", ");
            }
            sb.append("target:");
            ij ijVar = this.f765a;
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
        String str2 = this.f772b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.as.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f775c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f778d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f780e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f781f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f782g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f783h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f784i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f785j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f786k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f762a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f770b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f787l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f788m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f789n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f790o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f774c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            ii iiVar = this.f764a;
            if (iiVar == null) {
                sb.append("null");
            } else {
                sb.append(iiVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f769a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f763a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f771b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f791p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f792q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f773b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f768a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f776c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f793r;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        if (D()) {
            sb.append(", ");
            sb.append("xmsfHostVersionCode:");
            sb.append(this.f777d);
        }
        if (E()) {
            sb.append(", ");
            sb.append("pushBundleVersionCode:");
            sb.append(this.f779e);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f767a.get(3);
    }

    public boolean v() {
        return this.f767a.get(4);
    }

    public boolean w() {
        return this.f767a.get(5);
    }

    public boolean x() {
        return this.f791p != null;
    }

    public boolean y() {
        return this.f792q != null;
    }

    public boolean z() {
        return this.f767a.get(6);
    }

    public String a() {
        return this.f772b;
    }

    public String b() {
        return this.f775c;
    }

    public iu c(String str) {
        this.f778d = str;
        return this;
    }

    public iu d(String str) {
        this.f780e = str;
        return this;
    }

    public iu e(String str) {
        this.f781f = str;
        return this;
    }

    public iu f(String str) {
        this.f782g = str;
        return this;
    }

    public iu g(String str) {
        this.f783h = str;
        return this;
    }

    public iu h(String str) {
        this.f786k = str;
        return this;
    }

    public iu i(String str) {
        this.f790o = str;
        return this;
    }

    public void j(boolean z8) {
        this.f767a.set(9, z8);
    }

    public iu a(String str) {
        this.f772b = str;
        return this;
    }

    public iu b(String str) {
        this.f775c = str;
        return this;
    }

    public String c() {
        return this.f781f;
    }

    public void d(boolean z8) {
        this.f767a.set(3, z8);
    }

    public void e(boolean z8) {
        this.f767a.set(4, z8);
    }

    public void f(boolean z8) {
        this.f767a.set(5, z8);
    }

    public void g(boolean z8) {
        this.f767a.set(6, z8);
    }

    public void h(boolean z8) {
        this.f767a.set(7, z8);
    }

    public void i(boolean z8) {
        this.f767a.set(8, z8);
    }

    public iu a(int i9) {
        this.f762a = i9;
        a(true);
        return this;
    }

    public iu b(int i9) {
        this.f770b = i9;
        b(true);
        return this;
    }

    public iu c(int i9) {
        this.f774c = i9;
        c(true);
        return this;
    }

    public iu d(int i9) {
        this.f779e = i9;
        j(true);
        return this;
    }

    public void a(boolean z8) {
        this.f767a.set(0, z8);
    }

    public void b(boolean z8) {
        this.f767a.set(1, z8);
    }

    public void c(boolean z8) {
        this.f767a.set(2, z8);
    }

    public iu a(ii iiVar) {
        this.f764a = iiVar;
        return this;
    }

    @Override // com.xiaomi.push.jf
    public void b(jp jpVar) throws jq {
        m577a();
        jpVar.a(f761a);
        if (this.f766a != null && m578a()) {
            jpVar.a(f17969a);
            jpVar.a(this.f766a);
            jpVar.b();
        }
        if (this.f765a != null && m580b()) {
            jpVar.a(f17970b);
            this.f765a.b(jpVar);
            jpVar.b();
        }
        if (this.f772b != null) {
            jpVar.a(f17971c);
            jpVar.a(this.f772b);
            jpVar.b();
        }
        if (this.f775c != null) {
            jpVar.a(f17972d);
            jpVar.a(this.f775c);
            jpVar.b();
        }
        if (this.f778d != null && e()) {
            jpVar.a(f17973e);
            jpVar.a(this.f778d);
            jpVar.b();
        }
        if (this.f780e != null && f()) {
            jpVar.a(f17974f);
            jpVar.a(this.f780e);
            jpVar.b();
        }
        if (this.f781f != null) {
            jpVar.a(f17975g);
            jpVar.a(this.f781f);
            jpVar.b();
        }
        if (this.f782g != null && h()) {
            jpVar.a(f17976h);
            jpVar.a(this.f782g);
            jpVar.b();
        }
        if (this.f783h != null && i()) {
            jpVar.a(f17977i);
            jpVar.a(this.f783h);
            jpVar.b();
        }
        if (this.f784i != null && j()) {
            jpVar.a(j);
            jpVar.a(this.f784i);
            jpVar.b();
        }
        if (this.f785j != null && k()) {
            jpVar.a(f17978k);
            jpVar.a(this.f785j);
            jpVar.b();
        }
        if (this.f786k != null && l()) {
            jpVar.a(f17979l);
            jpVar.a(this.f786k);
            jpVar.b();
        }
        if (m()) {
            jpVar.a(f17980m);
            jpVar.mo642a(this.f762a);
            jpVar.b();
        }
        if (n()) {
            jpVar.a(f17981n);
            jpVar.mo642a(this.f770b);
            jpVar.b();
        }
        if (this.f787l != null && o()) {
            jpVar.a(f17982o);
            jpVar.a(this.f787l);
            jpVar.b();
        }
        if (this.f788m != null && p()) {
            jpVar.a(f17983p);
            jpVar.a(this.f788m);
            jpVar.b();
        }
        if (this.f789n != null && q()) {
            jpVar.a(f17984q);
            jpVar.a(this.f789n);
            jpVar.b();
        }
        if (this.f790o != null && r()) {
            jpVar.a(f17985r);
            jpVar.a(this.f790o);
            jpVar.b();
        }
        if (s()) {
            jpVar.a(f17986s);
            jpVar.mo642a(this.f774c);
            jpVar.b();
        }
        if (this.f764a != null && t()) {
            jpVar.a(t);
            jpVar.mo642a(this.f764a.a());
            jpVar.b();
        }
        if (u()) {
            jpVar.a(f17987u);
            jpVar.a(this.f769a);
            jpVar.b();
        }
        if (v()) {
            jpVar.a(f17988v);
            jpVar.a(this.f763a);
            jpVar.b();
        }
        if (w()) {
            jpVar.a(f17989w);
            jpVar.a(this.f771b);
            jpVar.b();
        }
        if (this.f791p != null && x()) {
            jpVar.a(f17990x);
            jpVar.a(this.f791p);
            jpVar.b();
        }
        if (this.f792q != null && y()) {
            jpVar.a(f17991y);
            jpVar.a(this.f792q);
            jpVar.b();
        }
        if (z()) {
            jpVar.a(f17992z);
            jpVar.a(this.f773b);
            jpVar.b();
        }
        if (this.f768a != null && A()) {
            jpVar.a(f17964A);
            jpVar.a(new jo((byte) 11, (byte) 11, this.f768a.size()));
            for (Map.Entry<String, String> entry : this.f768a.entrySet()) {
                jpVar.a(entry.getKey());
                jpVar.a(entry.getValue());
            }
            jpVar.d();
            jpVar.b();
        }
        if (B()) {
            jpVar.a(f17965B);
            jpVar.a(this.f776c);
            jpVar.b();
        }
        if (this.f793r != null && C()) {
            jpVar.a(f17966C);
            jpVar.a(this.f793r);
            jpVar.b();
        }
        if (D()) {
            jpVar.a(f17967D);
            jpVar.mo642a(this.f777d);
            jpVar.b();
        }
        if (E()) {
            jpVar.a(f17968E);
            jpVar.mo642a(this.f779e);
            jpVar.b();
        }
        jpVar.c();
        jpVar.mo641a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m579a(iu iuVar) {
        if (iuVar == null) {
            return false;
        }
        boolean zM578a = m578a();
        boolean zM578a2 = iuVar.m578a();
        if ((zM578a || zM578a2) && !(zM578a && zM578a2 && this.f766a.equals(iuVar.f766a))) {
            return false;
        }
        boolean zM580b = m580b();
        boolean zM580b2 = iuVar.m580b();
        if ((zM580b || zM580b2) && !(zM580b && zM580b2 && this.f765a.m530a(iuVar.f765a))) {
            return false;
        }
        boolean zM581c = m581c();
        boolean zM581c2 = iuVar.m581c();
        if ((zM581c || zM581c2) && !(zM581c && zM581c2 && this.f772b.equals(iuVar.f772b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = iuVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f775c.equals(iuVar.f775c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = iuVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f778d.equals(iuVar.f778d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = iuVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f780e.equals(iuVar.f780e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = iuVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f781f.equals(iuVar.f781f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = iuVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f782g.equals(iuVar.f782g))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = iuVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f783h.equals(iuVar.f783h))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = iuVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f784i.equals(iuVar.f784i))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = iuVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f785j.equals(iuVar.f785j))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = iuVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f786k.equals(iuVar.f786k))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = iuVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f762a == iuVar.f762a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = iuVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f770b == iuVar.f770b)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = iuVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f787l.equals(iuVar.f787l))) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = iuVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f788m.equals(iuVar.f788m))) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = iuVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f789n.equals(iuVar.f789n))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = iuVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f790o.equals(iuVar.f790o))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = iuVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f774c == iuVar.f774c)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = iuVar.t();
        if ((zT || zT2) && !(zT && zT2 && this.f764a.equals(iuVar.f764a))) {
            return false;
        }
        boolean zU = u();
        boolean zU2 = iuVar.u();
        if ((zU || zU2) && !(zU && zU2 && this.f769a == iuVar.f769a)) {
            return false;
        }
        boolean zV = v();
        boolean zV2 = iuVar.v();
        if ((zV || zV2) && !(zV && zV2 && this.f763a == iuVar.f763a)) {
            return false;
        }
        boolean zW = w();
        boolean zW2 = iuVar.w();
        if ((zW || zW2) && !(zW && zW2 && this.f771b == iuVar.f771b)) {
            return false;
        }
        boolean zX = x();
        boolean zX2 = iuVar.x();
        if ((zX || zX2) && !(zX && zX2 && this.f791p.equals(iuVar.f791p))) {
            return false;
        }
        boolean zY = y();
        boolean zY2 = iuVar.y();
        if ((zY || zY2) && !(zY && zY2 && this.f792q.equals(iuVar.f792q))) {
            return false;
        }
        boolean z8 = z();
        boolean z9 = iuVar.z();
        if ((z8 || z9) && !(z8 && z9 && this.f773b == iuVar.f773b)) {
            return false;
        }
        boolean zA = A();
        boolean zA2 = iuVar.A();
        if ((zA || zA2) && !(zA && zA2 && this.f768a.equals(iuVar.f768a))) {
            return false;
        }
        boolean zB = B();
        boolean zB2 = iuVar.B();
        if ((zB || zB2) && !(zB && zB2 && this.f776c == iuVar.f776c)) {
            return false;
        }
        boolean zC = C();
        boolean zC2 = iuVar.C();
        if ((zC || zC2) && !(zC && zC2 && this.f793r.equals(iuVar.f793r))) {
            return false;
        }
        boolean zD3 = D();
        boolean zD4 = iuVar.D();
        if ((zD3 || zD4) && !(zD3 && zD4 && this.f777d == iuVar.f777d)) {
            return false;
        }
        boolean zE3 = E();
        boolean zE4 = iuVar.E();
        if (zE3 || zE4) {
            return zE3 && zE4 && this.f779e == iuVar.f779e;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iu iuVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iA13;
        int iA14;
        int iA15;
        int iA16;
        int iA17;
        int iA18;
        int iA19;
        int iA20;
        int iA21;
        int iA22;
        int iA23;
        int iA24;
        int iA25;
        int iA26;
        int iA27;
        int iA28;
        int iA29;
        int iA30;
        int iA31;
        if (!getClass().equals(iuVar.getClass())) {
            return getClass().getName().compareTo(iuVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m578a()).compareTo(Boolean.valueOf(iuVar.m578a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m578a() && (iA31 = jg.a(this.f766a, iuVar.f766a)) != 0) {
            return iA31;
        }
        int iCompareTo2 = Boolean.valueOf(m580b()).compareTo(Boolean.valueOf(iuVar.m580b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m580b() && (iA30 = jg.a(this.f765a, iuVar.f765a)) != 0) {
            return iA30;
        }
        int iCompareTo3 = Boolean.valueOf(m581c()).compareTo(Boolean.valueOf(iuVar.m581c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m581c() && (iA29 = jg.a(this.f772b, iuVar.f772b)) != 0) {
            return iA29;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iuVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA28 = jg.a(this.f775c, iuVar.f775c)) != 0) {
            return iA28;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iuVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA27 = jg.a(this.f778d, iuVar.f778d)) != 0) {
            return iA27;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iuVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA26 = jg.a(this.f780e, iuVar.f780e)) != 0) {
            return iA26;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iuVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA25 = jg.a(this.f781f, iuVar.f781f)) != 0) {
            return iA25;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iuVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA24 = jg.a(this.f782g, iuVar.f782g)) != 0) {
            return iA24;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iuVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA23 = jg.a(this.f783h, iuVar.f783h)) != 0) {
            return iA23;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iuVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA22 = jg.a(this.f784i, iuVar.f784i)) != 0) {
            return iA22;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iuVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA21 = jg.a(this.f785j, iuVar.f785j)) != 0) {
            return iA21;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iuVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA20 = jg.a(this.f786k, iuVar.f786k)) != 0) {
            return iA20;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(iuVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA19 = jg.a(this.f762a, iuVar.f762a)) != 0) {
            return iA19;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(iuVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA18 = jg.a(this.f770b, iuVar.f770b)) != 0) {
            return iA18;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(iuVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA17 = jg.a(this.f787l, iuVar.f787l)) != 0) {
            return iA17;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(iuVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA16 = jg.a(this.f788m, iuVar.f788m)) != 0) {
            return iA16;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(iuVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA15 = jg.a(this.f789n, iuVar.f789n)) != 0) {
            return iA15;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(iuVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA14 = jg.a(this.f790o, iuVar.f790o)) != 0) {
            return iA14;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(iuVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA13 = jg.a(this.f774c, iuVar.f774c)) != 0) {
            return iA13;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(iuVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (t() && (iA12 = jg.a(this.f764a, iuVar.f764a)) != 0) {
            return iA12;
        }
        int iCompareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(iuVar.u()));
        if (iCompareTo21 != 0) {
            return iCompareTo21;
        }
        if (u() && (iA11 = jg.a(this.f769a, iuVar.f769a)) != 0) {
            return iA11;
        }
        int iCompareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(iuVar.v()));
        if (iCompareTo22 != 0) {
            return iCompareTo22;
        }
        if (v() && (iA10 = jg.a(this.f763a, iuVar.f763a)) != 0) {
            return iA10;
        }
        int iCompareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(iuVar.w()));
        if (iCompareTo23 != 0) {
            return iCompareTo23;
        }
        if (w() && (iA9 = jg.a(this.f771b, iuVar.f771b)) != 0) {
            return iA9;
        }
        int iCompareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(iuVar.x()));
        if (iCompareTo24 != 0) {
            return iCompareTo24;
        }
        if (x() && (iA8 = jg.a(this.f791p, iuVar.f791p)) != 0) {
            return iA8;
        }
        int iCompareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(iuVar.y()));
        if (iCompareTo25 != 0) {
            return iCompareTo25;
        }
        if (y() && (iA7 = jg.a(this.f792q, iuVar.f792q)) != 0) {
            return iA7;
        }
        int iCompareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(iuVar.z()));
        if (iCompareTo26 != 0) {
            return iCompareTo26;
        }
        if (z() && (iA6 = jg.a(this.f773b, iuVar.f773b)) != 0) {
            return iA6;
        }
        int iCompareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(iuVar.A()));
        if (iCompareTo27 != 0) {
            return iCompareTo27;
        }
        if (A() && (iA5 = jg.a(this.f768a, iuVar.f768a)) != 0) {
            return iA5;
        }
        int iCompareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(iuVar.B()));
        if (iCompareTo28 != 0) {
            return iCompareTo28;
        }
        if (B() && (iA4 = jg.a(this.f776c, iuVar.f776c)) != 0) {
            return iA4;
        }
        int iCompareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(iuVar.C()));
        if (iCompareTo29 != 0) {
            return iCompareTo29;
        }
        if (C() && (iA3 = jg.a(this.f793r, iuVar.f793r)) != 0) {
            return iA3;
        }
        int iCompareTo30 = Boolean.valueOf(D()).compareTo(Boolean.valueOf(iuVar.D()));
        if (iCompareTo30 != 0) {
            return iCompareTo30;
        }
        if (D() && (iA2 = jg.a(this.f777d, iuVar.f777d)) != 0) {
            return iA2;
        }
        int iCompareTo31 = Boolean.valueOf(E()).compareTo(Boolean.valueOf(iuVar.E()));
        if (iCompareTo31 != 0) {
            return iCompareTo31;
        }
        if (!E() || (iA = jg.a(this.f779e, iuVar.f779e)) == 0) {
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
                m577a();
                return;
            }
            short s8 = jmVarMo633a.f916a;
            switch (s8) {
                case 1:
                    if (b9 == 11) {
                        this.f766a = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 2:
                    if (b9 == 12) {
                        ij ijVar = new ij();
                        this.f765a = ijVar;
                        ijVar.a(jpVar);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 3:
                    if (b9 == 11) {
                        this.f772b = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 4:
                    if (b9 == 11) {
                        this.f775c = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 5:
                    if (b9 == 11) {
                        this.f778d = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 6:
                    if (b9 == 11) {
                        this.f780e = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 7:
                    if (b9 == 11) {
                        this.f781f = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 8:
                    if (b9 == 11) {
                        this.f782g = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 9:
                    if (b9 == 11) {
                        this.f783h = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 10:
                    if (b9 == 11) {
                        this.f784i = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 11:
                    if (b9 == 11) {
                        this.f785j = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 12:
                    if (b9 == 11) {
                        this.f786k = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 13:
                    if (b9 == 8) {
                        this.f762a = jpVar.mo631a();
                        a(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 14:
                    if (b9 == 8) {
                        this.f770b = jpVar.mo631a();
                        b(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 15:
                    if (b9 == 11) {
                        this.f787l = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 16:
                    if (b9 == 11) {
                        this.f788m = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 17:
                    if (b9 == 11) {
                        this.f789n = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 18:
                    if (b9 == 11) {
                        this.f790o = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 19:
                    if (b9 == 8) {
                        this.f774c = jpVar.mo631a();
                        c(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 20:
                    if (b9 == 8) {
                        this.f764a = ii.a(jpVar.mo631a());
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 21:
                    if (b9 == 2) {
                        this.f769a = jpVar.mo643a();
                        d(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 22:
                    if (b9 == 10) {
                        this.f763a = jpVar.mo632a();
                        e(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 23:
                    if (b9 == 10) {
                        this.f771b = jpVar.mo632a();
                        f(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 24:
                    if (b9 == 11) {
                        this.f791p = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 25:
                    if (b9 == 11) {
                        this.f792q = jpVar.mo638a();
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                case 26:
                    if (b9 == 2) {
                        this.f773b = jpVar.mo643a();
                        g(true);
                    } else {
                        js.a(jpVar, b9);
                    }
                    break;
                default:
                    switch (s8) {
                        case 100:
                            if (b9 == 13) {
                                jo joVarMo635a = jpVar.mo635a();
                                this.f768a = new HashMap(joVarMo635a.f918a * 2);
                                for (int i9 = 0; i9 < joVarMo635a.f918a; i9++) {
                                    this.f768a.put(jpVar.mo638a(), jpVar.mo638a());
                                }
                                jpVar.h();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 101:
                            if (b9 == 2) {
                                this.f776c = jpVar.mo643a();
                                h(true);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 102:
                            if (b9 == 11) {
                                this.f793r = jpVar.mo638a();
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 103:
                            if (b9 == 8) {
                                this.f777d = jpVar.mo631a();
                                i(true);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        case 104:
                            if (b9 == 8) {
                                this.f779e = jpVar.mo631a();
                                j(true);
                            } else {
                                js.a(jpVar, b9);
                            }
                            break;
                        default:
                            js.a(jpVar, b9);
                            break;
                    }
                    break;
            }
            jpVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m577a() throws jq {
        if (this.f772b != null) {
            if (this.f775c != null) {
                if (this.f781f != null) {
                    return;
                }
                throw new jq("Required field 'token' was not present! Struct: " + toString());
            }
            throw new jq("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new jq("Required field 'id' was not present! Struct: " + toString());
    }
}
