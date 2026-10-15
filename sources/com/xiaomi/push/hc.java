package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class hc extends hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17583b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f17585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f17588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f17589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f17590i;
    private String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f17591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f17592l;

    public hc() {
        this.f17583b = null;
        this.f17584c = null;
        this.f17582a = false;
        this.f17590i = "";
        this.j = "";
        this.f17591k = "";
        this.f17592l = "";
        this.f542b = false;
    }

    public void a(boolean z8) {
        this.f17582a = z8;
    }

    public String b() {
        return this.f17583b;
    }

    public String c() {
        return this.f17589h;
    }

    public String d() {
        return this.f17590i;
    }

    public String e() {
        return this.j;
    }

    @Override // com.xiaomi.push.hd
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            hc hcVar = (hc) obj;
            if (!super.equals(hcVar)) {
                return false;
            }
            String str = this.f17587f;
            if (str == null ? hcVar.f17587f != null : !str.equals(hcVar.f17587f)) {
                return false;
            }
            String str2 = this.f17585d;
            if (str2 == null ? hcVar.f17585d != null : !str2.equals(hcVar.f17585d)) {
                return false;
            }
            String str3 = this.f17586e;
            if (str3 == null ? hcVar.f17586e != null : !str3.equals(hcVar.f17586e)) {
                return false;
            }
            String str4 = this.f17584c;
            if (str4 == null ? hcVar.f17584c != null : !str4.equals(hcVar.f17584c)) {
                return false;
            }
            if (this.f17583b == hcVar.f17583b) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f17591k;
    }

    public String g() {
        return this.f17592l;
    }

    public void h(String str) {
        this.f17587f = str;
    }

    @Override // com.xiaomi.push.hd
    public int hashCode() {
        String str = this.f17583b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f17587f;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f17584c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f17585d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f17586e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.f17584c = str;
    }

    public void j(String str) {
        this.f17585d = str;
    }

    public void a(String str) {
        this.f17589h = str;
    }

    public void b(String str) {
        this.f17590i = str;
    }

    public void c(String str) {
        this.j = str;
    }

    public void d(String str) {
        this.f17591k = str;
    }

    public void e(String str) {
        this.f17592l = str;
    }

    public void f(String str) {
        this.f17583b = str;
    }

    public void g(String str) {
        this.f17586e = str;
    }

    public String h() {
        return this.f17585d;
    }

    public void a(String str, String str2) {
        this.f17587f = str;
        this.f17588g = str2;
    }

    public void b(boolean z8) {
        this.f542b = z8;
    }

    @Override // com.xiaomi.push.hd
    public Bundle a() {
        Bundle bundleA = super.a();
        if (!TextUtils.isEmpty(this.f17583b)) {
            bundleA.putString("ext_msg_type", this.f17583b);
        }
        String str = this.f17585d;
        if (str != null) {
            bundleA.putString("ext_msg_lang", str);
        }
        String str2 = this.f17586e;
        if (str2 != null) {
            bundleA.putString("ext_msg_sub", str2);
        }
        String str3 = this.f17587f;
        if (str3 != null) {
            bundleA.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f17588g)) {
            bundleA.putString("ext_body_encode", this.f17588g);
        }
        String str4 = this.f17584c;
        if (str4 != null) {
            bundleA.putString("ext_msg_thread", str4);
        }
        String str5 = this.f17589h;
        if (str5 != null) {
            bundleA.putString("ext_msg_appid", str5);
        }
        if (this.f17582a) {
            bundleA.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f17590i)) {
            bundleA.putString("ext_msg_seq", this.f17590i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            bundleA.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.f17591k)) {
            bundleA.putString("ext_msg_fseq", this.f17591k);
        }
        if (this.f542b) {
            bundleA.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f17592l)) {
            bundleA.putString("ext_msg_status", this.f17592l);
        }
        return bundleA;
    }

    public hc(Bundle bundle) {
        super(bundle);
        this.f17583b = null;
        this.f17584c = null;
        this.f17582a = false;
        this.f17590i = "";
        this.j = "";
        this.f17591k = "";
        this.f17592l = "";
        this.f542b = false;
        this.f17583b = bundle.getString("ext_msg_type");
        this.f17585d = bundle.getString("ext_msg_lang");
        this.f17584c = bundle.getString("ext_msg_thread");
        this.f17586e = bundle.getString("ext_msg_sub");
        this.f17587f = bundle.getString("ext_msg_body");
        this.f17588g = bundle.getString("ext_body_encode");
        this.f17589h = bundle.getString("ext_msg_appid");
        this.f17582a = bundle.getBoolean("ext_msg_trans", false);
        this.f542b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f17590i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.f17591k = bundle.getString("ext_msg_fseq");
        this.f17592l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.hd
    /* JADX INFO: renamed from: a */
    public String mo463a() {
        hh hhVarM464a;
        StringBuilder sb = new StringBuilder("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.f17585d != null) {
            sb.append(" xml:lang=\"");
            sb.append(h());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(hm.a(l()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(hm.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(hm.a(k()));
            sb.append("\"");
        }
        if (this.f17582a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f17589h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f17583b)) {
            sb.append(" type=\"");
            sb.append(this.f17583b);
            sb.append("\"");
        }
        if (this.f542b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f17586e != null) {
            sb.append("<subject>");
            sb.append(hm.a(this.f17586e));
            sb.append("</subject>");
        }
        if (this.f17587f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f17588g)) {
                sb.append(" encode=\"");
                sb.append(this.f17588g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(hm.a(this.f17587f));
            sb.append("</body>");
        }
        if (this.f17584c != null) {
            sb.append("<thread>");
            sb.append(this.f17584c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f17583b) && (hhVarM464a = m464a()) != null) {
            sb.append(hhVarM464a.m467a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }
}
