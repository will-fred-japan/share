package com.xiaomi.push;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class hf extends hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17603b;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public hf(b bVar) {
        this.f550a = b.available;
        this.f17603b = null;
        this.f17602a = Integer.MIN_VALUE;
        this.f549a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.hd
    public Bundle a() {
        Bundle bundleA = super.a();
        b bVar = this.f550a;
        if (bVar != null) {
            bundleA.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f17603b;
        if (str != null) {
            bundleA.putString("ext_pres_status", str);
        }
        int i9 = this.f17602a;
        if (i9 != Integer.MIN_VALUE) {
            bundleA.putInt("ext_pres_prio", i9);
        }
        a aVar = this.f549a;
        if (aVar != null && aVar != a.available) {
            bundleA.putString("ext_pres_mode", aVar.toString());
        }
        return bundleA;
    }

    public hf(Bundle bundle) {
        super(bundle);
        this.f550a = b.available;
        this.f17603b = null;
        this.f17602a = Integer.MIN_VALUE;
        this.f549a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f550a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f17603b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f17602a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f549a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f550a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public void a(String str) {
        this.f17603b = str;
    }

    public void a(int i9) {
        if (i9 >= -128 && i9 <= 128) {
            this.f17602a = i9;
            return;
        }
        throw new IllegalArgumentException(defpackage.f.b(i9, "Priority value ", " is not valid. Valid range is -128 through 128."));
    }

    public void a(a aVar) {
        this.f549a = aVar;
    }

    @Override // com.xiaomi.push.hd
    /* JADX INFO: renamed from: a */
    public String mo463a() {
        StringBuilder sb = new StringBuilder("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
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
        if (this.f550a != null) {
            sb.append(" type=\"");
            sb.append(this.f550a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f17603b != null) {
            sb.append("<status>");
            sb.append(hm.a(this.f17603b));
            sb.append("</status>");
        }
        if (this.f17602a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f17602a);
            sb.append("</priority>");
        }
        a aVar = this.f549a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f549a);
            sb.append("</show>");
        }
        sb.append(o());
        hh hhVarM464a = m464a();
        if (hhVarM464a != null) {
            sb.append(hhVarM464a.m467a());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
