package cn.jiguang.s;

import android.text.TextUtils;
import com.starburst.sdk.core.tts.EventType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10768a = cn.jiguang.t.a.b(new byte[]{120, 122, EventType.ERROR, 87, 73, 119, 65, 114});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10769b = cn.jiguang.t.a.b(new byte[]{97, 92, 85, 126, 97, 120, 95, 81, 77, 124});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10770c = cn.jiguang.t.a.b(new byte[]{111, 109, EventType.ERROR, 98, 89, 79, 119});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10771d = cn.jiguang.t.a.b(new byte[]{70, 69, 107, 123, 127, 126, 94, 110, 120, 101, 115});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10772e = cn.jiguang.t.a.b(new byte[]{123, 117, 5});

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10773f = cn.jiguang.t.a.b(new byte[]{84, 79, 110, 102, 122, 126, 81, 68, 76, 122, 122});

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10774g = cn.jiguang.t.a.b(new byte[]{110, 127, 125, 85, 110, 120, 101, 115});

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10775h = cn.jiguang.t.a.b(new byte[]{110, 127, 125, 85, 115, 112, 114, 115});

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10776i = cn.jiguang.t.a.b(new byte[]{117, 85, 83, 122});
    public static final String j = cn.jiguang.t.a.b(new byte[]{83, 109, 105, 98, EventType.ERROR, 67});

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10777k = cn.jiguang.t.a.b(new byte[]{82, 124, 120, 121, 99, 68, 115, 110, 97, 98, 114, 88});

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10778l = cn.jiguang.t.a.b(new byte[]{93, 85, 117, 124, 111, 66, 71, 73, 109, 107, 126});

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10782o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10785r;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10789w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f10791y;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10780m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f10781n = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f10783p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10784q = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f10786s = "";
    public String t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f10787u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f10788v = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f10790x = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10792z = false;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f10779A = false;

    public c(String str) {
        this.f10791y = str;
    }

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.u.b.e("pif", "p i is empty.");
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.matches("\\d+\\.\\d+\\.\\d+");
    }

    public static int c(String str) {
        try {
            if (!b(str)) {
                return 0;
            }
            int i9 = 0;
            for (String str2 : str.split("\\.")) {
                i9 = (i9 * 100) + Integer.parseInt(str2);
            }
            return i9;
        } catch (Throwable th) {
            cn.jiguang.u.b.e("pif", "dot version to code failed:" + th.getMessage());
            return 0;
        }
    }

    public String toString() {
        return "P{pid=" + this.f10780m + ", pName='" + this.f10781n + "', vcode=" + this.f10782o + ", version='" + this.f10783p + "', vname='" + this.f10784q + "', status=" + this.f10785r + ", dU='" + this.f10786s + "', m='" + this.t + "', desc='" + this.f10787u + "', fileName='" + this.f10788v + "', fileSize=" + this.f10789w + ", pkgname='" + this.f10790x + "', reportSwitch='" + this.f10792z + "', multySwitch='" + this.f10779A + "'}";
    }

    public static c a(JSONObject jSONObject) {
        int iOptInt;
        if (jSONObject == null) {
            cn.jiguang.u.b.g("pif", "p j i is empty.");
            return null;
        }
        c cVar = new c(jSONObject.toString());
        cVar.f10780m = jSONObject.optInt(f10768a);
        cVar.f10781n = jSONObject.optString(f10769b);
        cVar.f10788v = jSONObject.optString(f10774g);
        cVar.t = jSONObject.optString(f10772e);
        String str = f10770c;
        String strOptString = jSONObject.optString(str, "");
        if (TextUtils.isEmpty(strOptString)) {
            iOptInt = jSONObject.optInt(str, 0);
        } else if (b(strOptString)) {
            cVar.f10783p = strOptString;
            iOptInt = c(strOptString);
        } else {
            if (!strOptString.matches("\\d+")) {
                cn.jiguang.u.b.e("pif", "version is invalid:".concat(strOptString));
                return null;
            }
            cVar.f10783p = strOptString;
            iOptInt = jSONObject.optInt(str, 0);
        }
        cVar.f10782o = iOptInt;
        cVar.f10784q = jSONObject.optString(f10771d, "");
        cVar.f10785r = jSONObject.optInt(j);
        cVar.f10786s = jSONObject.optString(f10773f);
        cVar.f10787u = jSONObject.optString(f10776i);
        cVar.f10789w = jSONObject.optInt(f10775h);
        cVar.f10792z = jSONObject.optBoolean(f10777k);
        cVar.f10779A = jSONObject.optBoolean(f10778l);
        return cVar;
    }
}
