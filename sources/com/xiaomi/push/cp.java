package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.xiaomi.mipush.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cp {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f191a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f17152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f17153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f17154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f17155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f17156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f17157i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<cw> f192a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f17149a = 0.1d;
    private String j = "s.mi1.cc";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f17150b = 86400000;

    public cp(String str) {
        this.f191a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f190a = System.currentTimeMillis();
        this.f192a.add(new cw(str, -1));
        this.f191a = ct.m170a();
        this.f193b = str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m164a() {
        return TextUtils.equals(this.f191a, ct.m170a());
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f190a < this.f17150b;
    }

    public boolean c() {
        long j = this.f17150b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j8 = this.f190a;
        if (jCurrentTimeMillis - j8 <= j) {
            return jCurrentTimeMillis - j8 > this.f17150b && this.f191a.startsWith("WIFI-");
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f191a);
        sb.append("\n");
        sb.append(a());
        for (cw cwVar : this.f192a) {
            sb.append("\n");
            sb.append(cwVar.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    public boolean a(cp cpVar) {
        return TextUtils.equals(this.f191a, cpVar.f191a);
    }

    public void b(String str, long j, long j8) {
        a(str, 0, j, j8, null);
    }

    public void a(long j) {
        if (j > 0) {
            this.f17150b = j;
            return;
        }
        throw new IllegalArgumentException(defpackage.f.d(j, "the duration is invalid "));
    }

    public void b(String str, long j, long j8, Exception exc) {
        a(str, -1, j, j8, exc);
    }

    public void b(String str) {
        this.j = str;
    }

    private synchronized void c(String str) {
        Iterator<cw> it = this.f192a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f209a, str)) {
                it.remove();
            }
        }
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f193b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    cr crVarA = cr.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), crVarA.m169a(), crVarA.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public void a(String str, long j, long j8) {
        try {
            b(new URL(str).getHost(), j, j8);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j, long j8, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j8, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, int i9, long j, long j8, Exception exc) {
        a(str, new co(i9, j, j8, exc));
    }

    public synchronized void a(String str, co coVar) {
        for (cw cwVar : this.f192a) {
            if (TextUtils.equals(str, cwVar.f209a)) {
                cwVar.a(coVar);
                break;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<String> m161a() {
        return a(false);
    }

    public synchronized ArrayList<String> a(boolean z8) {
        ArrayList<String> arrayList;
        try {
            int size = this.f192a.size();
            cw[] cwVarArr = new cw[size];
            this.f192a.toArray(cwVarArr);
            Arrays.sort(cwVarArr);
            arrayList = new ArrayList<>();
            for (int i9 = 0; i9 < size; i9++) {
                cw cwVar = cwVarArr[i9];
                if (z8) {
                    arrayList.add(cwVar.f209a);
                } else {
                    int iIndexOf = cwVar.f209a.indexOf(Constants.COLON_SEPARATOR);
                    if (iIndexOf != -1) {
                        arrayList.add(cwVar.f209a.substring(0, iIndexOf));
                    } else {
                        arrayList.add(cwVar.f209a);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m163a(String str) {
        a(new cw(str));
    }

    public synchronized void a(cw cwVar) {
        c(cwVar.f209a);
        this.f192a.add(cwVar);
    }

    public synchronized void a(String[] strArr) {
        int i9;
        try {
            int size = this.f192a.size() - 1;
            while (true) {
                i9 = 0;
                if (size < 0) {
                    break;
                }
                int length = strArr.length;
                while (i9 < length) {
                    if (TextUtils.equals(this.f192a.get(size).f209a, strArr[i9])) {
                        this.f192a.remove(size);
                        break;
                    }
                    i9++;
                }
                size--;
            }
            Iterator<cw> it = this.f192a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                int i11 = it.next().f17168a;
                if (i11 > i10) {
                    i10 = i11;
                }
            }
            while (i9 < strArr.length) {
                a(new cw(strArr[i9], (strArr.length + i10) - i9));
                i9++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.f17157i)) {
            return this.f17157i;
        }
        if (TextUtils.isEmpty(this.f17153e)) {
            return "hardcode_isp";
        }
        String strA = bm.a(new String[]{this.f17153e, this.f17151c, this.f17152d, this.f17155g, this.f17154f}, BundleUtil.UNDERLINE_TAG);
        this.f17157i = strA;
        return strA;
    }

    public void a(double d9) {
        this.f17149a = d9;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m162a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("net", this.f191a);
            jSONObject.put(RemoteMessageConst.TTL, this.f17150b);
            jSONObject.put("pct", this.f17149a);
            jSONObject.put("ts", this.f190a);
            jSONObject.put("city", this.f17152d);
            jSONObject.put("prv", this.f17151c);
            jSONObject.put("cty", this.f17155g);
            jSONObject.put("isp", this.f17153e);
            jSONObject.put("ip", this.f17154f);
            jSONObject.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, this.f193b);
            jSONObject.put("xf", this.f17156h);
            JSONArray jSONArray = new JSONArray();
            Iterator<cw> it = this.f192a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
            jSONObject.put("fbs", jSONArray);
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public synchronized cp a(JSONObject jSONObject) {
        this.f191a = jSONObject.optString("net");
        this.f17150b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.f17149a = jSONObject.getDouble("pct");
        this.f190a = jSONObject.getLong("ts");
        this.f17152d = jSONObject.optString("city");
        this.f17151c = jSONObject.optString("prv");
        this.f17155g = jSONObject.optString("cty");
        this.f17153e = jSONObject.optString("isp");
        this.f17154f = jSONObject.optString("ip");
        this.f193b = jSONObject.optString(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        this.f17156h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i9 = 0; i9 < jSONArray.length(); i9++) {
            a(new cw().a(jSONArray.getJSONObject(i9)));
        }
        return this;
    }
}
