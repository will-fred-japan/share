package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class hb extends hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f17576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, String> f540a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17577a = new a("get");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f17578b = new a("set");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f17579c = new a("result");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f17580d = new a("error");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f17581e = new a(com.heytap.mcssdk.constant.b.f14306y);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f541a;

        private a(String str) {
            this.f541a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = f17577a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = f17578b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = f17580d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = f17579c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = f17581e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f541a;
        }
    }

    public hb() {
        this.f17576a = a.f17577a;
        this.f540a = new HashMap();
    }

    public synchronized void a(Map<String, String> map) {
        this.f540a.putAll(map);
    }

    public String b() {
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m462a() {
        return this.f17576a;
    }

    public hb(Bundle bundle) {
        super(bundle);
        this.f17576a = a.f17577a;
        this.f540a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f17576a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f17576a = a.f17577a;
        } else {
            this.f17576a = aVar;
        }
    }

    @Override // com.xiaomi.push.hd
    public Bundle a() {
        Bundle bundleA = super.a();
        a aVar = this.f17576a;
        if (aVar != null) {
            bundleA.putString("ext_iq_type", aVar.toString());
        }
        return bundleA;
    }

    @Override // com.xiaomi.push.hd
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo463a() {
        StringBuilder sb = new StringBuilder("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(hm.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(hm.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(hm.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f540a.entrySet()) {
            sb.append(hm.a(entry.getKey()));
            sb.append("=\"");
            sb.append(hm.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.f17576a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(m462a());
            sb.append("\">");
        }
        String strB = b();
        if (strB != null) {
            sb.append(strB);
        }
        sb.append(o());
        hh hhVarM464a = m464a();
        if (hhVarM464a != null) {
            sb.append(hhVarM464a.m467a());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
