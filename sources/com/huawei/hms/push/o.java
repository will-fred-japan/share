package com.huawei.hms.push;

import android.text.TextUtils;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PushSelfShowMessage.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int f15437B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private String f15439D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15445d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f15452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f15453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f15454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f15455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f15456p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f15458r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f15459s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f15465z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15442a = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15446e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15447f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f15448g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f15449h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f15450i = "";
    private String j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f15451k = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f15457q = "";
    private int t = k.STYLE_DEFAULT.ordinal();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f15460u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f15461v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f15462w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f15463x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f15464y = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private String f15436A = "";

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private String f15438C = "";

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private String f15440E = "";

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private String f15441F = "";

    public o(byte[] bArr, byte[] bArr2) {
        Charset charset = m.f15432a;
        this.f15458r = new String(bArr, charset);
        this.f15459s = new String(bArr2, charset);
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.f15442a);
        jSONObject2.put("tag", this.f15436A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f15463x);
        jSONObject2.put(RemoteMessageConst.Notification.VISIBILITY, this.f15464y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.f15465z);
        return jSONObject2;
    }

    private JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(MTCoreConstants.Protocol.KEY_CMD, this.f15448g);
        jSONObject2.put("content", this.f15449h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f15450i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.j);
        jSONObject2.put("notifySummary", this.f15451k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(string) || string.length() >= 48) {
                this.f15445d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i9 = 0; i9 < length; i9++) {
                sb.append("0");
            }
            sb.append(string);
            this.f15445d = sb.toString();
        }
    }

    private boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f15453m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f15444c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f15452l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    private boolean e(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(RemoteMessageConst.MSGID)) {
            HMSLog.i("PushSelfShowLog", "msgId == null");
            return false;
        }
        Object obj = jSONObject.get(RemoteMessageConst.MSGID);
        if (obj instanceof String) {
            this.f15446e = (String) obj;
            return true;
        }
        if (!(obj instanceof Integer)) {
            return true;
        }
        this.f15446e = String.valueOf(((Integer) obj).intValue());
        return true;
    }

    private boolean f(JSONObject jSONObject) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.t = jSONObject2.getInt("style");
            }
            this.f15460u = jSONObject2.optString("bigTitle");
            this.f15461v = jSONObject2.optString("bigContent");
            this.f15440E = jSONObject2.optString(RemoteMessageConst.Notification.ICON);
            return true;
        } catch (JSONException e9) {
            HMSLog.i("PushSelfShowLog", e9.toString());
            return false;
        }
    }

    private void g(JSONObject jSONObject) {
        this.f15442a = jSONObject.optString("group");
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f15442a);
        this.f15463x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.f15463x);
        this.f15464y = jSONObject.optInt(RemoteMessageConst.Notification.VISIBILITY, 0);
        this.f15465z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.f15436A = jSONObject.optString("tag");
    }

    private boolean h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.f15443b = jSONObject2.getInt("autoClear");
            } else {
                this.f15443b = 0;
            }
            if (!"app".equals(this.f15448g) && !"cosa".equals(this.f15448g)) {
                if (RemoteMessageConst.Notification.URL.equals(this.f15448g)) {
                    k(jSONObject2);
                    return true;
                }
                if (!"rp".equals(this.f15448g)) {
                    return true;
                }
                j(jSONObject2);
                return true;
            }
            d(jSONObject2);
            return true;
        } catch (Exception e9) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", e9);
            return false;
        }
    }

    private boolean i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f15448g = jSONObject2.getString(MTCoreConstants.Protocol.KEY_CMD);
            this.f15449h = jSONObject2.optString("content");
            this.f15450i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f15451k = jSONObject2.optString("notifySummary");
            this.f15439D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return h(jSONObject2);
            }
        }
        return false;
    }

    private boolean j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f15452l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.f15455o = jSONObject.getString("rpl");
        this.f15456p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f15457q = jSONObject.getString("rpct");
        return true;
    }

    private boolean k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        if (!jSONObject.has(RemoteMessageConst.Notification.URL)) {
            HMSLog.d("PushSelfShowLog", "url is null");
            return false;
        }
        this.f15454n = jSONObject.getString(RemoteMessageConst.Notification.URL);
        if (jSONObject.has("appPackageName")) {
            this.f15452l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            return true;
        }
        this.f15455o = jSONObject.getString("rpl");
        this.f15456p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f15457q = jSONObject.getString("rpct");
        return true;
    }

    private JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.t);
        jSONObject.put("bigTitle", this.f15460u);
        jSONObject.put("bigContent", this.f15461v);
        jSONObject.put("bigPic", this.f15462w);
        return jSONObject;
    }

    private JSONObject u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f15443b);
        jSONObject.put(RemoteMessageConst.Notification.URL, this.f15454n);
        jSONObject.put("rpl", this.f15455o);
        jSONObject.put("rpt", this.f15456p);
        jSONObject.put("rpct", this.f15457q);
        jSONObject.put("appPackageName", this.f15452l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f15453m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f15444c);
        return jSONObject;
    }

    public String l() {
        return this.f15440E;
    }

    public String m() {
        return this.f15444c;
    }

    public byte[] n() {
        try {
            return a(a(b(u()), q())).toString().getBytes(m.f15432a);
        } catch (JSONException e9) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e9);
            return new byte[0];
        }
    }

    public String o() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.f15446e);
        return this.f15446e;
    }

    public String p() {
        return this.f15436A;
    }

    public int r() {
        return this.f15437B;
    }

    public String s() {
        return this.f15451k;
    }

    public String t() {
        return this.j;
    }

    public int v() {
        return this.t;
    }

    public String w() {
        return this.f15439D;
    }

    public byte[] x() {
        return this.f15459s.getBytes(m.f15432a);
    }

    public boolean y() {
        try {
            if (TextUtils.isEmpty(this.f15458r)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f15458r);
            g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!e(jSONObject2)) {
                return false;
            }
            this.f15447f = jSONObject2.optString("dispPkgName");
            c(jSONObject2);
            this.f15437B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.f15438C = jSONObject2.optString("data");
            this.f15441F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e9) {
            HMSLog.d("PushSelfShowLog", e9.toString());
            return false;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f15447f);
        jSONObject3.put(RemoteMessageConst.MSGID, this.f15446e);
        jSONObject3.put("ap", this.f15445d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.f15437B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.f15439D);
        jSONObject3.put("data", this.f15438C);
        return jSONObject3;
    }

    public String b() {
        return this.f15441F;
    }

    public int d() {
        return this.f15463x;
    }

    public String g() {
        return this.f15460u;
    }

    public int e() {
        return this.f15443b;
    }

    public String f() {
        return this.f15461v;
    }

    public String j() {
        return this.f15447f;
    }

    public String c() {
        return this.f15452l;
    }

    public String k() {
        return this.f15442a;
    }

    public String h() {
        return this.f15448g;
    }

    public String i() {
        return this.f15449h;
    }

    public String a() {
        return this.f15453m;
    }

    public void a(int i9) {
        this.f15437B = i9;
    }
}
