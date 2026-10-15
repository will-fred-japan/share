package cn.jpush.android.b;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable {
    private static final long serialVersionUID = 2310616383854860780L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f11244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f11245f = 200.0d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f11246g = 200.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11247h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11248i;
    public String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f11249k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11250l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11251m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11252n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f11253o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f11254p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11255q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f11256r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11257s;
    public cn.jpush.android.d.d t;

    public static b a(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.f11249k = jSONObject.optString("op");
            bVar.f11240a = jSONObject.optString("geofenceid");
            bVar.j = jSONObject.optString(MTCommonConstants.Network.KEY_NAME);
            bVar.f11241b = jSONObject.optLong("radius");
            bVar.f11242c = jSONObject.optString("status");
            bVar.f11243d = jSONObject.optBoolean("repeat");
            bVar.f11250l = jSONObject.optInt("repeat_week_num");
            bVar.f11251m = jSONObject.optInt("repeat_day_num");
            bVar.f11252n = jSONObject.optInt("repeat_time");
            bVar.f11244e = jSONObject.optLong("expiration");
            bVar.f11248i = jSONObject.optInt("type", 1);
            bVar.f11245f = jSONObject.optDouble("lon", 200.0d);
            bVar.f11246g = jSONObject.optDouble("lat", 200.0d);
            bVar.f11253o = jSONObject.optLong("lastTime");
            bVar.f11254p = jSONObject.optString("lastTimeWeek");
            bVar.f11255q = jSONObject.optInt("weekNum");
            bVar.f11256r = jSONObject.optString("lastTimeDay");
            bVar.f11257s = jSONObject.optInt("dayNum");
            bVar.f11247h = jSONObject.optString("lastGeoStatus");
            String strOptString = jSONObject.optString("entity");
            if (!TextUtils.isEmpty(strOptString)) {
                bVar.t = cn.jpush.android.d.d.a(strOptString, context.getPackageName(), JCoreHelper.getAppKey(context), 0L);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void b(JSONObject jSONObject) {
        try {
            if (jSONObject.has(MTCommonConstants.Network.KEY_NAME)) {
                this.j = jSONObject.optString(MTCommonConstants.Network.KEY_NAME);
            }
            long jOptLong = jSONObject.optLong("radius", -1L);
            if (jOptLong > 0) {
                this.f11241b = jOptLong;
            }
            if (jSONObject.has("status")) {
                this.f11242c = jSONObject.optString("status");
            }
            if (jSONObject.has("repeat")) {
                boolean zOptBoolean = jSONObject.optBoolean("repeat");
                this.f11243d = zOptBoolean;
                if (zOptBoolean) {
                    if (jSONObject.has("repeat_week_num")) {
                        this.f11250l = jSONObject.optInt("repeat_week_num");
                    }
                    if (jSONObject.has("repeat_day_num")) {
                        this.f11251m = jSONObject.optInt("repeat_day_num");
                    }
                    if (jSONObject.has("repeat_time")) {
                        this.f11252n = jSONObject.optInt("repeat_time");
                    }
                }
            }
            if (jSONObject.has("expiration")) {
                this.f11244e = jSONObject.optLong("expiration");
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("center");
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble = jSONObjectOptJSONObject.optDouble("lon", 200.0d);
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("lat", 200.0d);
                if (dOptDouble >= -180.0d && dOptDouble <= 180.0d && dOptDouble2 >= -90.0d && dOptDouble2 <= 90.0d) {
                    this.f11245f = dOptDouble;
                    this.f11246g = dOptDouble2;
                    return;
                }
                Logger.w("Geofence", "update center failed because value invalid, [" + dOptDouble2 + Constants.ACCEPT_TIME_SEPARATOR_SP + dOptDouble + "]");
            }
        } catch (Throwable unused) {
        }
    }

    public static b a(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.f11249k = jSONObject.optString("op");
            bVar.f11240a = jSONObject.optString("geofenceid");
            bVar.j = jSONObject.optString(MTCommonConstants.Network.KEY_NAME);
            bVar.f11241b = jSONObject.optLong("radius");
            bVar.f11242c = jSONObject.optString("status");
            bVar.f11243d = jSONObject.optBoolean("repeat");
            bVar.f11250l = jSONObject.optInt("repeat_week_num");
            bVar.f11251m = jSONObject.optInt("repeat_day_num");
            bVar.f11252n = jSONObject.optInt("repeat_time");
            bVar.f11244e = jSONObject.optLong("expiration");
            bVar.f11248i = jSONObject.optInt("type", 1);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("center");
            if (jSONObjectOptJSONObject != null) {
                bVar.f11245f = jSONObjectOptJSONObject.optDouble("lon", 200.0d);
                bVar.f11246g = jSONObjectOptJSONObject.optDouble("lat", 200.0d);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", this.f11249k);
            jSONObject.put("geofenceid", this.f11240a);
            jSONObject.put(MTCommonConstants.Network.KEY_NAME, this.j);
            jSONObject.put("radius", this.f11241b);
            jSONObject.put("status", this.f11242c);
            jSONObject.put("repeat", this.f11243d);
            jSONObject.put("repeat_week_num", this.f11250l);
            jSONObject.put("repeat_day_num", this.f11251m);
            jSONObject.put("repeat_time", this.f11252n);
            jSONObject.put("expiration", this.f11244e);
            jSONObject.put("type", this.f11248i);
            jSONObject.put("lon", this.f11245f);
            jSONObject.put("lat", this.f11246g);
            jSONObject.put("lastTime", this.f11253o);
            jSONObject.put("lastTimeWeek", this.f11254p);
            jSONObject.put("weekNum", this.f11255q);
            jSONObject.put("lastTimeDay", this.f11256r);
            jSONObject.put("dayNum", this.f11257s);
            jSONObject.put("lastGeoStatus", this.f11247h);
            cn.jpush.android.d.d dVar = this.t;
            if (dVar != null) {
                jSONObject.put("entity", dVar.f11325i);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(b bVar) {
        this.f11247h = bVar.f11247h;
        this.f11253o = bVar.f11253o;
        this.f11254p = bVar.f11254p;
        this.f11256r = bVar.f11256r;
        this.f11255q = bVar.f11255q;
        this.f11257s = bVar.f11257s;
    }
}
