package cn.jiguang.q;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.aw.j;
import cn.jiguang.aw.p;
import cn.jiguang.aw.x;
import cn.jiguang.w.m;
import cn.jpush.android.service.WakedResultReceiver;
import com.huawei.hms.framework.common.BundleUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f10717a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WakedResultReceiver f10718b;

    public static JSONArray a(Context context) {
        JSONObject jSONObjectA;
        synchronized ("waked_cache_v2.json") {
            jSONObjectA = j.a("waked_cache_v2.json");
        }
        if (jSONObjectA == null) {
            jSONObjectA = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            return a(context, jSONArrayOptJSONArray);
        }
        cn.jiguang.x.f.c("JWakedHelper", "no save data");
        return null;
    }

    public static void b(Context context) {
        j.d("waked_cache_v2.json");
    }

    private static WakedResultReceiver c(Context context) {
        WakedResultReceiver wakedResultReceiver = f10718b;
        if (wakedResultReceiver != null) {
            return wakedResultReceiver;
        }
        try {
            PackageInfo packageInfoA = p.a(context, 0);
            if (packageInfoA == null) {
                return null;
            }
            for (ActivityInfo activityInfo : packageInfoA.receivers) {
                try {
                    if (WakedResultReceiver.class.isAssignableFrom(Class.forName(activityInfo.name, false, WakedResultReceiver.class.getClassLoader()))) {
                        return (WakedResultReceiver) Class.forName(activityInfo.name).newInstance();
                    }
                    continue;
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("find waked receiver throwable:"), "JWakedHelper");
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x017e  */
    public static JSONArray a(Context context, JSONArray jSONArray) {
        JSONArray jSONArray2;
        String str;
        HashMap map;
        int i9;
        Map map2;
        HashMap map3;
        Integer numValueOf;
        Map map4;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    HashMap map5 = new HashMap();
                    int i10 = 0;
                    while (true) {
                        str = "dead";
                        if (i10 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        String strOptString = jSONObject.optString("type");
                        long jOptLong = jSONObject.optLong("itime");
                        Iterator it = map5.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                map = map5;
                                i9 = i10;
                                map2 = null;
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            long jLongValue = ((Long) entry.getKey()).longValue();
                            i9 = i10;
                            map = map5;
                            jSONArray2 = null;
                            try {
                                if (x.a(jOptLong * 1000, jLongValue * 1000)) {
                                    map2 = (Map) entry.getValue();
                                    jOptLong = jLongValue;
                                    break;
                                }
                                i10 = i9;
                                map5 = map;
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                        if (map2 == null) {
                            map2 = new HashMap();
                        }
                        if ("android_awake_target2".equals(strOptString) || "aat3".equals(strOptString)) {
                            String strOptString2 = jSONObject.optString("package");
                            str = jSONObject.optBoolean("app_alive") ? "active" : "dead";
                            int iOptInt = jSONObject.optInt("wake_type");
                            if (map2.containsKey(strOptString2)) {
                                Map map6 = (Map) map2.get(strOptString2);
                                if (map6.containsKey(Integer.valueOf(iOptInt))) {
                                    Map map7 = (Map) map6.get(Integer.valueOf(iOptInt));
                                    map7.put(str, map7.containsKey(str) ? Integer.valueOf(((Integer) map7.get(str)).intValue() + 1) : 1);
                                    numValueOf = Integer.valueOf(iOptInt);
                                    map4 = map7;
                                } else {
                                    HashMap map8 = new HashMap();
                                    map8.put(str, 1);
                                    numValueOf = Integer.valueOf(iOptInt);
                                    map4 = map8;
                                }
                                map6.put(numValueOf, map4);
                                map2.put(strOptString2, map6);
                            } else {
                                HashMap map9 = new HashMap();
                                map9.put(str, 1);
                                HashMap map10 = new HashMap();
                                map10.put(Integer.valueOf(iOptInt), map9);
                                map2.put(strOptString2, map10);
                            }
                            map3 = map;
                            map3.put(Long.valueOf(jOptLong), map2);
                            String strOptString3 = jSONObject.optString("jg_extras");
                            cn.jiguang.x.f.c("JWakedHelper", "jg_extras is :" + strOptString3);
                            if (!TextUtils.isEmpty(strOptString3)) {
                                String strOptString4 = new JSONObject(strOptString3).optString("di");
                                if (!TextUtils.isEmpty(strOptString4)) {
                                    a(context, strOptString4);
                                }
                            }
                        } else {
                            cn.jiguang.x.f.i("JWakedHelper", "unkown type :" + strOptString);
                            map3 = map;
                        }
                        i10 = i9 + 1;
                        map5 = map3;
                        th = th;
                    }
                    jSONArray2 = null;
                    JSONArray jSONArray3 = new JSONArray();
                    Iterator it2 = map5.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it2.next();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray4 = new JSONArray();
                        Iterator it3 = ((Map) entry2.getValue()).entrySet().iterator();
                        while (it3.hasNext()) {
                            Map.Entry entry3 = (Map.Entry) it3.next();
                            JSONObject jSONObject3 = new JSONObject();
                            Iterator it4 = it2;
                            jSONObject3.put("p", entry3.getKey());
                            cn.jiguang.x.f.c("JWakedHelper", "pkg:" + ((String) entry3.getKey()));
                            Iterator it5 = ((Map) entry3.getValue()).entrySet().iterator();
                            JSONArray jSONArray5 = new JSONArray();
                            while (it5.hasNext()) {
                                Map.Entry entry4 = (Map.Entry) it5.next();
                                Iterator it6 = it5;
                                int iIntValue = ((Integer) entry4.getKey()).intValue();
                                Map.Entry entry5 = entry2;
                                StringBuilder sb = new StringBuilder();
                                Iterator it7 = it3;
                                sb.append("type:");
                                sb.append(iIntValue);
                                cn.jiguang.x.f.c("JWakedHelper", sb.toString());
                                Map map11 = (Map) entry4.getValue();
                                cn.jiguang.x.f.c("JWakedHelper", "value:" + map11);
                                int iIntValue2 = map11.containsKey("active") ? ((Integer) map11.get("active")).intValue() : 0;
                                int iIntValue3 = map11.containsKey(str) ? ((Integer) map11.get(str)).intValue() : 0;
                                jSONArray5.put(iIntValue + BundleUtil.UNDERLINE_TAG + (iIntValue2 + iIntValue3) + BundleUtil.UNDERLINE_TAG + iIntValue2 + BundleUtil.UNDERLINE_TAG + iIntValue3);
                                entry2 = entry5;
                                it5 = it6;
                                it3 = it7;
                                str = str;
                            }
                            jSONObject3.put("d", jSONArray5);
                            jSONArray4.put(jSONObject3);
                            it2 = it4;
                            entry2 = entry2;
                            it3 = it3;
                            str = str;
                        }
                        Iterator it8 = it2;
                        Map.Entry entry6 = entry2;
                        String str2 = str;
                        if (jSONArray4.length() > 0) {
                            jSONObject2.put("f", jSONArray4);
                            jSONObject2.put("itime", ((Long) entry6.getKey()).longValue());
                            jSONObject2.put("type", "aat3");
                            jSONArray3.put(jSONObject2);
                        }
                        it2 = it8;
                        str = str2;
                    }
                    return jSONArray3.length() > 0 ? jSONArray3 : jSONArray;
                }
            } catch (Throwable th2) {
                th = th2;
                jSONArray2 = null;
            }
            cn.jiguang.x.f.j("JWakedHelper", "merge waked json failed:" + th.getMessage());
            return jSONArray2;
        }
        return jSONArray;
    }

    private static JSONObject a(String str, int i9, boolean z8) {
        if (str == null) {
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wake_type", i9);
            jSONObject.put("package", str);
            jSONObject.put("app_alive", z8);
            return jSONObject;
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("packageWakedJson error:"), "JWakedHelper");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context, Bundle bundle, int i9) {
        String string;
        String str;
        if (bundle == null) {
            str = "bundle is null,give up save";
        } else {
            if (b.b(context).f10660x) {
                try {
                    string = bundle.getString("from_package");
                } catch (Throwable unused) {
                    string = null;
                }
                if (string == null) {
                    string = "";
                }
                JSONObject jSONObjectA = a(string, i9, f10717a);
                f10717a = true;
                if (jSONObjectA == null) {
                    return false;
                }
                try {
                    String string2 = bundle.getString("jg_extras");
                    if (!TextUtils.isEmpty(string2)) {
                        jSONObjectA.put("jg_extras", string2);
                    }
                } catch (Throwable th) {
                    W5.e.t(th, new StringBuilder("save waked extras error:"), "JWakedHelper");
                }
                return a(context, jSONObjectA);
            }
            str = "server set do not report waked data,give up save";
        }
        cn.jiguang.x.f.i("JWakedHelper", str);
        return false;
    }

    private static void a(Context context, int i9) {
        if (context == null) {
            cn.jiguang.x.f.i("JWakedHelper", "context is null,can not notify waked");
            return;
        }
        WakedResultReceiver wakedResultReceiverC = c(context);
        f10718b = wakedResultReceiverC;
        if (wakedResultReceiverC == null) {
            cn.jiguang.x.f.i("JWakedHelper", "waked receiver is null");
            return;
        }
        HashMap map = new HashMap(2);
        map.put("1", context);
        map.put(WakedResultReceiver.WAKE_TYPE_KEY, Integer.valueOf(i9));
        f10718b.onWakeMap(map);
    }

    public static void a(final Context context, final Bundle bundle, final int i9) {
        try {
            cn.jiguang.x.f.c("JWakedHelper", "executeWakedAction.");
            a(context, i9);
            cn.jiguang.aa.b.a(new cn.jiguang.av.b() { // from class: cn.jiguang.q.g.1
                @Override // cn.jiguang.av.b
                public void a() {
                    if (g.c(context, bundle, i9)) {
                        f.a().a(context);
                    }
                }
            });
            m.a(context);
            cn.jiguang.h.a.a(context, 2);
        } catch (Throwable th) {
            cn.jiguang.x.f.c("JWakedHelper", "executeWakedAction failed:" + th.getLocalizedMessage());
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("di", str);
            synchronized ("di.json") {
                try {
                    JSONObject jSONObjectA = j.a("di.json");
                    if (jSONObjectA == null) {
                        jSONObjectA = new JSONObject();
                    }
                    JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(jSONObject);
                    jSONObjectA.put("content", jSONArrayOptJSONArray);
                    j.a("di.json", jSONObjectA);
                    cn.jiguang.x.f.c("JWakedHelper", "save di is: " + str + ", success!");
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            W5.e.t(th2, new StringBuilder("saveDId failed:"), "JWakedHelper");
        }
    }

    private static boolean a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            jSONObject.put("itime", cn.jiguang.d.b.b(context));
            jSONObject.put("type", "aat3");
            synchronized ("waked_cache_v2.json") {
                try {
                    JSONObject jSONObjectA = j.a("waked_cache_v2.json");
                    if (jSONObjectA == null) {
                        jSONObjectA = new JSONObject();
                    }
                    JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(jSONObject);
                    jSONObjectA.put("content", jSONArrayOptJSONArray);
                    j.a("waked_cache_v2.json", jSONObjectA);
                    cn.jiguang.x.f.c("JWakedHelper", "save waked data : " + jSONObjectA.toString());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } catch (Throwable th2) {
            W5.e.t(th2, new StringBuilder("saveWakedData failed:"), "JWakedHelper");
            return false;
        }
    }
}
