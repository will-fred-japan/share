package cn.jiguang.commons.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.data.JPushCollectControl;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.starburst.sdk.core.tts.EventType;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class it {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10216a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10217b = jr.a(new byte[]{88, 99, 23, 33, 91, 70, 122, 67, 18, 113, 127, 85, 75, 114, 108, 120});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10218c = jr.a(new byte[]{65, 8, 65, 72, 109, 123, 93, 64, 118, 122, 88, 68, 82, 67, 76, 43});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10221f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static LinkedList<String> f10222l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final iw f10223m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f10224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f10226i;
    private long j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f10227k;

    static {
        String strA = jr.a(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57});
        f10219d = strA;
        String strA2 = jr.a(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 37, 127, 97, 70, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 55, 98, 102, EventType.ERROR, 67, 72, 55, 107, 120, 62, 71, 73, 54});
        f10220e = strA2;
        f10221f = strA;
        f10222l = new LinkedList<>();
        f10223m = new iw((byte) 0);
        f10222l.clear();
        f10222l.add(strA);
        f10222l.add(strA2);
    }

    private it() {
        StringBuilder sb = new StringBuilder();
        String str = f10221f;
        sb.append(str);
        sb.append(jr.a(new byte[]{82, 120, 56, 117, 117, 85}));
        this.f10224g = sb.toString();
        StringBuilder sbB = p171w.a.b(str);
        sbB.append(jr.a(new byte[]{66, 125, 56, EventType.ERROR, 32, 65}));
        this.f10225h = sbB.toString();
        this.j = 0L;
        this.f10227k = 86400000L;
    }

    private ei a(Network network, String str, String str2, JSONObject jSONObject, String str3) {
        eh ehVar = new eh(str2);
        ehVar.b(str);
        ca caVarA = ca.a();
        String strI = ca.i();
        long jE = caVarA.e();
        if (jE > 0) {
            ehVar.a("X-UDD", ca.a(jE));
        }
        if (!TextUtils.isEmpty(strI)) {
            ehVar.a("X-App-Key", strI);
        }
        if (network != null) {
            ehVar.a(network);
        }
        str.getClass();
        switch (str) {
            case "GET":
                return ej.b(ehVar);
            case "PUT":
            case "POST":
                a(ehVar, jSONObject);
                ehVar.a(str3);
                return ej.b(ehVar);
            default:
                ey.b().a(Integer.valueOf(MTPushConstants.Message.CODE_MESSAGE_DELETED));
                return null;
        }
    }

    private static String b(String str) {
        try {
            return Base64.encodeToString(km.a(str.getBytes("UTF-8"), f10218c, f10217b, true), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static ConnectivityManager d() {
        ey eyVarB;
        int i9;
        Context contextA = jg.a();
        if (contextA == null) {
            eyVarB = ey.b();
            i9 = 1001;
        } else {
            if (kh.a("android.permission.ACCESS_NETWORK_STATE")) {
                return (ConnectivityManager) contextA.getSystemService("connectivity");
            }
            eyVarB = ey.b();
            i9 = 1002;
        }
        eyVarB.a(Integer.valueOf(i9));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        ey.b().a((Object) 1029);
    }

    private JSONObject f() {
        try {
            JSONObject jSONObjectG = g();
            if (jSONObjectG == null) {
                ey.b().a((Object) 1035);
                return null;
            }
            ca.a();
            jSONObjectG.put("core_sdk_ver", ca.f());
            ee.a("JUaidManager", "req url internal, jlen=" + jSONObjectG.length());
            return a(this.f10225h, jSONObjectG, true);
        } catch (Throwable unused) {
            ey.b().a(Integer.valueOf(MTCommonConstants.MainWhat.ON_FRAGMENT_RESUMED));
            return null;
        }
    }

    private static JSONObject g() {
        ey eyVarB;
        int iValueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            ca caVarA = ca.a();
            String strI = ca.i();
            long jE = caVarA.e();
            if (a(strI, jE, ca.h())) {
                jSONObject.put("appkey", strI);
                jSONObject.put("uid", jE);
                jSONObject.put("os_ver", bu.a().b(MTCommonConstants.MainWhat.ON_ACTIVITY_PAUSED, false));
                jSONObject.put("platform", "a");
                return jSONObject;
            }
            if (TextUtils.isEmpty(strI)) {
                ee.d("JUaidManager", "appKey is null, no need req");
                eyVarB = ey.b();
                iValueOf = 1013;
            } else {
                if (jE > 0) {
                    ee.d("JUaidManager", "registration credentials unavailable, no need req");
                    return null;
                }
                ee.d("JUaidManager", "uid is invalid, no need req");
                eyVarB = ey.b();
                iValueOf = Integer.valueOf(MTCommonConstants.MainWhat.ON_ACTIVITY_PAUSED);
            }
            eyVarB.a(iValueOf);
            return null;
        } catch (Throwable unused) {
        }
    }

    public static it a() {
        return ix.f10236a;
    }

    public final void b() {
        ey eyVarB;
        Object obj;
        ey eyVarB2;
        int iValueOf;
        ey eyVarB3;
        int i9;
        try {
            if (this.f10227k == 86400000) {
                eyVarB = ey.b();
                obj = 1056;
            } else {
                eyVarB = ey.b();
                obj = "stime" + this.f10227k;
            }
            eyVarB.a(obj);
            boolean zB = kh.b("android.permission.CHANGE_NETWORK_STATE");
            ey.b().a(Integer.valueOf(zB ? 1045 : 1046));
            ConnectivityManager connectivityManagerD = d();
            if (connectivityManagerD == null) {
                ey.b().a(Integer.valueOf(MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED));
                ee.a("JUaidManager", "no connectivityManager hadChangePermission= " + zB);
                a(zB);
                return;
            }
            Network activeNetwork = connectivityManagerD.getActiveNetwork();
            if (activeNetwork == null) {
                eyVarB3 = ey.b();
                i9 = 1004;
            } else {
                NetworkCapabilities networkCapabilities = connectivityManagerD.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    boolean z8 = false;
                    boolean zHasTransport = networkCapabilities.hasTransport(0);
                    try {
                        boolean zHasTransport2 = networkCapabilities.hasTransport(1);
                        StringBuilder sb = new StringBuilder("n");
                        if (zHasTransport2) {
                            sb.append(1);
                            ey.b().a((Object) 1043);
                        }
                        if (zHasTransport) {
                            sb.append(0);
                            ey.b().a((Object) 1042);
                        }
                        if (networkCapabilities.hasTransport(3)) {
                            sb.append(3);
                        }
                        if (networkCapabilities.hasTransport(2)) {
                            sb.append(2);
                        }
                        if (networkCapabilities.hasTransport(4)) {
                            sb.append(4);
                        }
                        if (networkCapabilities.hasTransport(5)) {
                            sb.append(5);
                        }
                        if (networkCapabilities.hasTransport(6)) {
                            sb.append(6);
                        }
                        ey.b().a(sb.toString());
                    } catch (Throwable unused) {
                        ey.b().a((Object) 1044);
                    }
                    boolean zHasCapability = networkCapabilities.hasCapability(12);
                    boolean zHasCapability2 = networkCapabilities.hasCapability(16);
                    if (!zHasCapability) {
                        eyVarB2 = ey.b();
                        iValueOf = 1006;
                    } else {
                        if (zHasCapability2) {
                            ey.b().a((Object) 1048);
                            ee.a("JUaidManager", "new network, hadChangePermission= " + zB + " hasTransportCell=" + zHasTransport);
                            if (zB && !zHasTransport) {
                                z8 = true;
                            }
                            a(z8);
                            return;
                        }
                        eyVarB2 = ey.b();
                        iValueOf = Integer.valueOf(MTCommonConstants.MainWhat.ON_NETWORK_CHANGED);
                    }
                    eyVarB2.a(iValueOf);
                    a(connectivityManagerD, zB);
                    return;
                }
                eyVarB3 = ey.b();
                i9 = 1005;
            }
            eyVarB3.a(i9);
            a(connectivityManagerD, zB);
        } catch (Throwable unused2) {
            ey.b().a((Object) 1044);
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(km.a(Base64.decode(str, 2), f10218c, f10217b, false));
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void b(Context context) {
        if (context == null) {
            ee.d("JUaidManager", "updateImmediately failed: context is null");
            return;
        }
        boolean zA = em.a("JUaidManager", this.j, this.f10227k);
        ee.a("JUaidManager", "updateImmediately: businessCondition=" + zA);
        if (!zA) {
            ee.a("JUaidManager", "Reset request time and continue update");
            a(0L, this.f10227k);
        }
        a(context);
    }

    private JSONObject a(String str, JSONObject jSONObject, boolean z8) {
        JSONObject jSONObject2;
        ey eyVarB;
        int i9;
        JSONObject jSONObject3 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            String strOptString = jSONObject.optString("appkey");
            long jOptLong = jSONObject.optLong("uid", 0L);
            ca caVarA = ca.a();
            String strI = ca.i();
            long jE = caVarA.e();
            String strH = ca.h();
            try {
                if (!a(strI, jE, strH) || !ca.a(strI, jE, strOptString, jOptLong)) {
                    ee.d("JUaidManager", "registration credentials changed, skip uaid request");
                    return null;
                }
                String strValueOf = String.valueOf(jE);
                String upperCase = jk.a(strValueOf + jk.a(strH).toUpperCase()).toUpperCase();
                if (TextUtils.isEmpty(upperCase)) {
                    return null;
                }
                String strEncodeToString = Base64.encodeToString((strValueOf + Constants.COLON_SEPARATOR + upperCase).getBytes(), 10);
                if (TextUtils.isEmpty(strEncodeToString)) {
                    return null;
                }
                String strReplace = str;
                int i10 = 0;
                boolean z9 = false;
                while (i10 < f10222l.size()) {
                    if (z9) {
                        strReplace = (z9 || i10 != f10222l.size() - 1) ? str : str.replace(f10219d, f10220e);
                    } else {
                        strReplace = strReplace.replace(f10219d, f10220e);
                        z9 = true;
                    }
                    ee.a("JUaidManager", "url req, plen=" + jSONObject.length());
                    eh ehVar = new eh(strReplace);
                    ehVar.a("Content-Type", "application/json");
                    ehVar.a("Accept", "application/json");
                    ehVar.a("X-Http-Platform", "android");
                    ehVar.a("X-Http-Appkey", jSONObject.optString("appkey"));
                    JSONObject jSONObject4 = jSONObject3;
                    ehVar.a("Authorization", "Basic " + strEncodeToString);
                    ehVar.a("Charset", "UTF-8");
                    ehVar.a("X-UDD", ca.a(jE));
                    ehVar.a(b(jSONObject.toString()));
                    ei eiVarA = ej.a(ehVar);
                    int iC = eiVarA.c();
                    ee.a("JUaidManager", "responseCode:" + iC);
                    String strA = eiVarA.a();
                    StringBuilder sb = new StringBuilder("rsp len=");
                    sb.append(TextUtils.isEmpty(strA) ? 0 : strA.length());
                    ee.a("JUaidManager", sb.toString());
                    if (200 != iC) {
                        eyVarB = ey.b();
                        i9 = z8 ? MTCommonConstants.MainWhat.ON_ACTIVITY_DESTROYED : 1018;
                    } else if (TextUtils.isEmpty(strA)) {
                        eyVarB = ey.b();
                        i9 = z8 ? MTCommonConstants.MainWhat.ON_UPDATE_LOG_CACHE_CONFIG : 1032;
                    } else {
                        String strA2 = a(strA);
                        StringBuilder sb2 = new StringBuilder("req ok, body len=");
                        sb2.append(TextUtils.isEmpty(strA2) ? 0 : strA2.length());
                        ee.a("JUaidManager", sb2.toString());
                        JSONObject jSONObject5 = new JSONObject(strA2);
                        if (2000 == jSONObject5.optInt("code")) {
                            return jSONObject5;
                        }
                        eyVarB = ey.b();
                        i9 = z8 ? 1020 : 1033;
                    }
                    eyVarB.a(Integer.valueOf(i9));
                    i10++;
                    jSONObject3 = jSONObject4;
                }
                return jSONObject3;
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2 = jSONObject3;
        }
        ey.b().a(Integer.valueOf(z8 ? 1036 : 1037));
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, JSONObject jSONObject, String str3, String str4) {
        a((Network) null, str, str2, jSONObject, str3, str4);
    }

    private static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    key = TextUtils.isEmpty(value) ? "空key" : value;
                }
                jSONObject.put(key, value);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public /* synthetic */ it(byte b9) {
        this();
    }

    private void a(long j) {
        a(System.currentTimeMillis(), j);
    }

    private void a(long j, long j8) {
        this.j = j;
        if (j8 <= 0) {
            j8 = 86400000;
        }
        SharedPreferences sharedPreferences = this.f10226i.getSharedPreferences("cn.jiguang.common", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("uaid_last_time", this.j).putLong("uaid_internal_time", j8).apply();
        }
        this.f10227k = j8;
        ee.a("JUaidManager", "save reqTime requestTime=" + this.j + " next_time=" + this.f10227k);
    }

    public final void a(Context context) {
        SharedPreferences sharedPreferences;
        if (this.f10226i == null) {
            this.f10226i = context;
        }
        if ((this.j <= 0 || this.f10227k <= 0) && (sharedPreferences = this.f10226i.getSharedPreferences("cn.jiguang.common", 0)) != null) {
            this.j = sharedPreferences.getLong("uaid_last_time", 0L);
            this.f10227k = sharedPreferences.getLong("uaid_internal_time", 86400000L);
        }
        ee.a("JUaidManager", "getUaidAsyn");
        ey.b().a((Object) 999);
        if (!bn.a().a(2201)) {
            ey.b().a((Object) 1026);
            return;
        }
        ey.b().a((Object) 1025);
        if (!em.a("JUaidManager", this.j, this.f10227k)) {
            ey.b().a((Object) 1012);
        } else {
            if (em.a("JUaidManager", this.j, this.f10227k, new iu(this))) {
                return;
            }
            fe.a().a(f10223m, fl.DEVICE_INFO);
        }
    }

    private void a(ConnectivityManager connectivityManager, boolean z8) {
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                ey.b().a((Object) 1009);
                ee.a("JUaidManager", "old network no activeNetworkInfo, hadChangePermission= " + z8);
                a(z8);
                return;
            }
            int type = activeNetworkInfo.getType();
            boolean zA = a(type);
            boolean z9 = false;
            boolean z10 = 1 == type;
            if (zA) {
                try {
                    ey.b().a((Object) 1040);
                } catch (Throwable unused) {
                    ey.b().a((Object) 1044);
                }
            }
            if (z10) {
                ey.b().a((Object) 1041);
            }
            ey.b().a("o" + type);
            if (!activeNetworkInfo.isConnected()) {
                ey.b().a(Integer.valueOf(JPushCollectControl.IMSI));
                return;
            }
            ey.b().a((Object) 1048);
            ee.a("JUaidManager", "old net ok, hadChangePermission= " + z8 + " mobileNetworkType=" + zA);
            if (z8 && !zA) {
                z9 = true;
            }
            a(z9);
        } catch (Throwable unused2) {
            ey.b().a((Object) 1044);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Network network, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        ei eiVarA = a(network, str, str2, jSONObject, str3);
        StringBuilder sb = new StringBuilder("performRequest code=");
        sb.append(eiVarA != null ? eiVarA.c() : -1);
        ee.a("JUaidManager", sb.toString());
        a(eiVarA, str4);
    }

    private static void a(eh ehVar, JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                ehVar.a(next, jSONObject.getString(next));
            }
        } catch (Throwable unused) {
        }
    }

    private void a(ei eiVar, String str) {
        ey eyVarB;
        int iValueOf;
        try {
            if (eiVar != null) {
                int iC = eiVar.c();
                String strA = eiVar.a();
                ee.a("JUaidManager", "token code:" + iC);
                StringBuilder sb = new StringBuilder("token resp len=");
                sb.append(TextUtils.isEmpty(strA) ? 0 : strA.length());
                ee.a("JUaidManager", sb.toString());
                if (200 != iC) {
                    eyVarB = ey.b();
                    iValueOf = 1030;
                } else if (TextUtils.isEmpty(strA)) {
                    eyVarB = ey.b();
                    iValueOf = 1031;
                } else {
                    JSONObject jSONObjectG = g();
                    if (jSONObjectG == null) {
                        eyVarB = ey.b();
                        iValueOf = Integer.valueOf(MTCommonConstants.MainWhat.ON_ACTIVITY_STOPPED);
                    } else {
                        jSONObjectG.put(RemoteMessageConst.Notification.CHANNEL_ID, str);
                        ca.a();
                        jSONObjectG.put("core_sdk_ver", ca.f());
                        jSONObjectG.put("respBody", strA);
                        jSONObjectG.put("respHeader", a(eiVar.d()));
                        ee.a("JUaidManager", "rpt token start, jlen=" + jSONObjectG.length());
                        JSONObject jSONObjectA = a(this.f10224g, jSONObjectG, false);
                        StringBuilder sb2 = new StringBuilder("rpt token rsp code=");
                        sb2.append(jSONObjectA != null ? jSONObjectA.optInt("code") : -1);
                        ee.a("JUaidManager", sb2.toString());
                        if (jSONObjectA == null) {
                            eyVarB = ey.b();
                            iValueOf = 1032;
                        } else if (jSONObjectA.optInt("code") == 2000) {
                            ee.a("JUaidManager", "reportToken success");
                            eyVarB = ey.b();
                            iValueOf = 1000;
                        } else {
                            ee.a("JUaidManager", "reportToken fail");
                            eyVarB = ey.b();
                            iValueOf = 1033;
                        }
                    }
                }
            } else {
                eyVarB = ey.b();
                iValueOf = Integer.valueOf(MTPushConstants.Message.CODE_MESSAGE_OPENED);
            }
            eyVarB.a(iValueOf);
        } catch (Throwable unused) {
            ey.b().a((Object) 1034);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, String str3, String str4) {
        try {
            ConnectivityManager connectivityManagerD = d();
            if (connectivityManagerD == null) {
                ee.a("JUaidManager", "No connectivity manager available");
                b(str, str2, jSONObject, str3, str4);
                return;
            }
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            connectivityManagerD.requestNetwork(builder.build(), new iv(this, str, str2, jSONObject, str3, str4, connectivityManagerD), 15000);
        } catch (Throwable unused) {
            e();
        }
    }

    private void a(JSONObject jSONObject, boolean z8) {
        ey eyVarB;
        int i9;
        ey eyVarB2;
        int i10;
        try {
            boolean zA = bq.a().a(1037, false);
            boolean z9 = zA && z8;
            ee.a("JUaidManager", "first enable=" + z8 + " server enable=" + zA + " final enable=" + z9);
            StringBuilder sb = new StringBuilder("req token from operator, data=");
            sb.append(jSONObject != null ? "json(" + jSONObject.length() + ")" : "null");
            ee.a("JUaidManager", sb.toString());
            if (jSONObject == null) {
                eyVarB2 = ey.b();
                i10 = 1023;
            } else {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("list");
                if (jSONArrayOptJSONArray != null) {
                    for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i11);
                        String strOptString = jSONObject2.optString(RemoteMessageConst.Notification.CHANNEL_ID);
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("headers");
                        String strOptString2 = jSONObject2.optString("method");
                        String strOptString3 = jSONObject2.optString("requestBody");
                        String strOptString4 = jSONObject2.optString(RemoteMessageConst.Notification.URL);
                        String upperCase = strOptString2.toUpperCase();
                        ey.b().a((Object) 1055);
                        if (z9) {
                            a(upperCase, strOptString4, jSONObjectOptJSONObject, strOptString3, strOptString);
                            eyVarB = ey.b();
                            i9 = 1051;
                        } else {
                            b(upperCase, strOptString4, jSONObjectOptJSONObject, strOptString3, strOptString);
                            eyVarB = ey.b();
                            i9 = 1052;
                        }
                        eyVarB.a(i9);
                    }
                    return;
                }
                eyVarB2 = ey.b();
                i10 = 1027;
            }
            eyVarB2.a(i10);
        } catch (Throwable unused) {
            ey.b().a((Object) 1029);
        }
    }

    private void a(boolean z8) {
        ey eyVarB;
        int i9;
        try {
            JSONObject jSONObjectF = f();
            if (jSONObjectF == null) {
                eyVarB = ey.b();
                i9 = 1022;
            } else {
                JSONObject jSONObjectOptJSONObject = jSONObjectF.optJSONObject("data");
                if (jSONObjectOptJSONObject != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("token_switch");
                    long jOptLong = jSONObjectOptJSONObject.optLong("next_time") * 1000;
                    ee.a("JUaidManager", "mSwitch=" + zOptBoolean + " internalTime=" + jOptLong);
                    a(jOptLong);
                    em.a("JUaidManager");
                    if (zOptBoolean) {
                        ey.b().a((Object) 1053);
                        a(jSONObjectOptJSONObject, z8);
                        return;
                    } else {
                        eyVarB = ey.b();
                        i9 = 1021;
                    }
                } else {
                    a(this.f10227k);
                    eyVarB = ey.b();
                    i9 = 1023;
                }
            }
            eyVarB.a(i9);
        } catch (Throwable th) {
            ey.b().a((Object) 1024);
            defpackage.f.n(th, new StringBuilder("startReq err:"), "JUaidManager");
        }
    }

    private static boolean a(int i9) {
        return i9 == 0 || i9 == 4 || i9 == 5 || i9 == 2 || i9 == 6 || i9 == 3;
    }

    private static boolean a(String str, long j, String str2) {
        return (TextUtils.isEmpty(str) || j <= 0 || TextUtils.isEmpty(str2)) ? false : true;
    }
}
