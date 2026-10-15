package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<ha> f554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f17621d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17622a = new a("internal-server-error");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f17623b = new a("forbidden");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f17624c = new a("bad-request");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f17625d = new a("conflict");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f17626e = new a("feature-not-implemented");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f17627f = new a("gone");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f17628g = new a("item-not-found");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f17629h = new a("jid-malformed");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f17630i = new a("not-acceptable");
        public static final a j = new a("not-allowed");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f17631k = new a("not-authorized");

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f17632l = new a("payment-required");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f17633m = new a("recipient-unavailable");

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f17634n = new a("redirect");

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f17635o = new a("registration-required");

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f17636p = new a("remote-server-error");

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f17637q = new a("remote-server-not-found");

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f17638r = new a("remote-server-timeout");

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f17639s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f17640u = new a("subscription-required");

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f17641v = new a("undefined-condition");

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f17642w = new a("unexpected-request");

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f17643x = new a("request-timeout");

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f555a;

        public a(String str) {
            this.f555a = str;
        }

        public String toString() {
            return this.f555a;
        }
    }

    public hh(a aVar) {
        this.f554a = null;
        a(aVar);
        this.f17621d = null;
    }

    private void a(a aVar) {
        this.f17619b = aVar.f555a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f17619b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f17618a);
        sb.append(")");
        if (this.f17621d != null) {
            sb.append(" ");
            sb.append(this.f17621d);
        }
        return sb.toString();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f553a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f17618a);
        String str2 = this.f17620c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f17619b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f17621d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<ha> list = this.f554a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<ha> it = this.f554a.iterator();
            int i9 = 0;
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i9] = bundleA;
                    i9++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public hh(int i9, String str, String str2, String str3, String str4, List<ha> list) {
        this.f17618a = i9;
        this.f553a = str;
        this.f17620c = str2;
        this.f17619b = str3;
        this.f17621d = str4;
        this.f554a = list;
    }

    public hh(Bundle bundle) {
        this.f554a = null;
        this.f17618a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f553a = bundle.getString("ext_err_type");
        }
        this.f17619b = bundle.getString("ext_err_cond");
        this.f17620c = bundle.getString("ext_err_reason");
        this.f17621d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f554a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                ha haVarA = ha.a((Bundle) parcelable);
                if (haVarA != null) {
                    this.f554a.add(haVarA);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m467a() {
        StringBuilder sb = new StringBuilder("<error code=\"");
        sb.append(this.f17618a);
        sb.append("\"");
        if (this.f553a != null) {
            sb.append(" type=\"");
            sb.append(this.f553a);
            sb.append("\"");
        }
        if (this.f17620c != null) {
            sb.append(" reason=\"");
            sb.append(this.f17620c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f17619b != null) {
            sb.append("<");
            sb.append(this.f17619b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f17621d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f17621d);
            sb.append("</text>");
        }
        Iterator<ha> it = m468a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized List<ha> m468a() {
        List<ha> list = this.f554a;
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return Collections.unmodifiableList(list);
    }
}
