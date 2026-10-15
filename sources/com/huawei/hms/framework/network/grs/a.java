package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15000e = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f15001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f15002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f15003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f15004d;

    /* JADX INFO: renamed from: com.huawei.hms.framework.network.grs.a$a, reason: collision with other inner class name */
    public static class C0166a implements com.huawei.hms.framework.network.grs.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, String> f15006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        IQueryUrlsCallBack f15007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Context f15008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        GrsBaseInfo f15009e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f15010f;

        public C0166a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f15005a = str;
            this.f15006b = map;
            this.f15007c = iQueryUrlsCallBack;
            this.f15008d = context;
            this.f15009e = grsBaseInfo;
            this.f15010f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.f15006b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f15005a, StringUtils.anonymizeMessage(new JSONObject(this.f15006b).toString()));
                this.f15007c.onCallBackSuccess(this.f15006b);
                return;
            }
            if (this.f15006b != null) {
                Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f15005a);
                this.f15007c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> mapA = com.huawei.hms.framework.network.grs.f.b.a(this.f15008d.getPackageName()).a(this.f15008d, this.f15010f, this.f15009e, this.f15005a, true);
            if (mapA == null || mapA.isEmpty()) {
                Logger.e(a.f15000e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f15005a);
            }
            if (mapA == null) {
                mapA = new ConcurrentHashMap<>();
            }
            Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f15005a, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            this.f15007c.onCallBackSuccess(mapA);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            String strJ = dVar.j();
            Map<String, String> mapA = a.a(strJ, this.f15005a);
            if (!mapA.isEmpty()) {
                Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f15005a, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
                this.f15007c.onCallBackSuccess(mapA);
                return;
            }
            Map<String, String> map = this.f15006b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f15005a, StringUtils.anonymizeMessage(new JSONObject(this.f15006b).toString()));
                this.f15007c.onCallBackSuccess(this.f15006b);
                return;
            }
            if (this.f15006b != null) {
                Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f15005a);
                this.f15007c.onCallBackFail(-5);
                return;
            }
            if (!TextUtils.isEmpty(strJ)) {
                Logger.e(a.f15000e, "The serviceName[%s] is not configured on the GRS server.", this.f15005a);
            }
            Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> mapA2 = com.huawei.hms.framework.network.grs.f.b.a(this.f15008d.getPackageName()).a(this.f15008d, this.f15010f, this.f15009e, this.f15005a, true);
            if (mapA2 == null || mapA2.isEmpty()) {
                Logger.e(a.f15000e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f15005a);
            }
            if (mapA2 == null) {
                mapA2 = new ConcurrentHashMap<>();
            }
            Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f15005a, StringUtils.anonymizeMessage(new JSONObject(mapA2).toString()));
            this.f15007c.onCallBackSuccess(mapA2);
        }
    }

    public static class b implements com.huawei.hms.framework.network.grs.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        IQueryUrlCallBack f15013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Context f15015e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        GrsBaseInfo f15016f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f15017g;

        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f15011a = str;
            this.f15012b = str2;
            this.f15013c = iQueryUrlCallBack;
            this.f15014d = str3;
            this.f15015e = context;
            this.f15016f = grsBaseInfo;
            this.f15017g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.f15014d)) {
                Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f15011a, this.f15012b, StringUtils.anonymizeMessage(this.f15014d));
                this.f15013c.onCallBackSuccess(this.f15014d);
                return;
            }
            if (!TextUtils.isEmpty(this.f15014d)) {
                Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f15011a, this.f15012b);
                this.f15013c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String strA = com.huawei.hms.framework.network.grs.f.b.a(this.f15015e.getPackageName()).a(this.f15015e, this.f15017g, this.f15016f, this.f15011a, this.f15012b, true);
            if (strA == null || strA.isEmpty()) {
                Logger.e(a.f15000e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f15011a, this.f15012b);
            }
            Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f15011a, this.f15012b, StringUtils.anonymizeMessage(strA));
            this.f15013c.onCallBackSuccess(strA);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            String strJ = dVar.j();
            Map<String, String> mapA = a.a(strJ, this.f15011a);
            if (mapA.containsKey(this.f15012b)) {
                String str = a.f15000e;
                String str2 = this.f15011a;
                String str3 = this.f15012b;
                Logger.i(str, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str2, str3, StringUtils.anonymizeMessage(mapA.get(str3)));
                this.f15013c.onCallBackSuccess(mapA.get(this.f15012b));
                return;
            }
            if (!TextUtils.isEmpty(this.f15014d)) {
                String str4 = a.f15000e;
                String str5 = this.f15011a;
                String str6 = this.f15012b;
                Logger.i(str4, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", str5, str6, StringUtils.anonymizeMessage(mapA.get(str6)));
                this.f15013c.onCallBackSuccess(this.f15014d);
                return;
            }
            if (!TextUtils.isEmpty(this.f15014d)) {
                Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f15011a, this.f15012b);
                this.f15013c.onCallBackFail(-5);
                return;
            }
            if (!TextUtils.isEmpty(strJ)) {
                Logger.e(a.f15000e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f15011a, this.f15012b);
            }
            Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String strA = com.huawei.hms.framework.network.grs.f.b.a(this.f15015e.getPackageName()).a(this.f15015e, this.f15017g, this.f15016f, this.f15011a, this.f15012b, true);
            if (strA == null || strA.isEmpty()) {
                Logger.e(a.f15000e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f15011a, this.f15012b);
            }
            Logger.i(a.f15000e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f15011a, this.f15012b, StringUtils.anonymizeMessage(strA));
            this.f15013c.onCallBackSuccess(strA);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, g gVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.f15001a = grsBaseInfo;
        this.f15002b = aVar;
        this.f15003c = gVar;
        this.f15004d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z8) {
        return new CountryCodeBean(context, z8);
    }

    public String a(Context context, String str, int i9) {
        com.huawei.hms.framework.network.grs.g.d dVarA = this.f15003c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f15001a, context), str, this.f15004d, i9);
        if (dVarA == null) {
            return "";
        }
        return dVarA.m() ? this.f15002b.a().a(this.f15001a.getGrsParasKey(true, true, context), "") : dVarA.j();
    }

    public String a(String str, String str2, Context context, int i9) {
        String str3;
        String str4;
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String strA = a(str, bVar, context).get(str2);
        if (bVar.a() && !TextUtils.isEmpty(strA)) {
            Logger.i(f15000e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(strA));
            return strA;
        }
        String strA2 = a(context, str, i9);
        String str5 = a(strA2, str).get(str2);
        if (!TextUtils.isEmpty(str5)) {
            Logger.i(f15000e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str5));
            return str5;
        }
        if (TextUtils.isEmpty(strA)) {
            if (!TextUtils.isEmpty(strA2)) {
                Logger.e(f15000e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            String str6 = f15000e;
            Logger.i(str6, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            str3 = str;
            str4 = str2;
            strA = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f15002b, this.f15001a, str3, str4, true);
            if (strA == null || strA.isEmpty()) {
                Logger.e(str6, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str3, str4);
            }
        } else {
            str3 = str;
            str4 = str2;
        }
        Logger.i(f15000e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(strA));
        return strA;
    }

    public static Map<String, Map<String, String>> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f15000e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e9) {
            Logger.w(f15000e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e9.getMessage()));
            return concurrentHashMap;
        }
    }

    public Map<String, String> a(String str, Context context, int i9) {
        String str2;
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> mapA = a(str, bVar, context);
        if (bVar.a() && !mapA.isEmpty()) {
            Logger.i(f15000e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            return mapA;
        }
        String strA = a(context, str, i9);
        Map<String, String> mapA2 = a(strA, str);
        if (!mapA2.isEmpty()) {
            Logger.i(f15000e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA2).toString()));
            return mapA2;
        }
        if (mapA.isEmpty()) {
            if (!TextUtils.isEmpty(strA)) {
                Logger.e(f15000e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            String str3 = f15000e;
            Logger.i(str3, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            str2 = str;
            mapA = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f15002b, this.f15001a, str2, true);
            if (mapA == null || mapA.isEmpty()) {
                Logger.e(str3, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str2);
            }
        } else {
            str2 = str;
        }
        Logger.i(f15000e, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", str2, StringUtils.anonymizeMessage(mapA != null ? new JSONObject(mapA).toString() : ""));
        return mapA;
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> mapA = this.f15002b.a(this.f15001a, str, bVar, context);
        if (mapA != null && !mapA.isEmpty()) {
            Logger.i(f15000e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return mapA;
        }
        Map<String, String> mapA2 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f15002b, this.f15001a, str, false);
        Logger.i(f15000e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return mapA2 != null ? mapA2 : new HashMap();
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f15000e, "isSpExpire jsonValue from server is null.");
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f15000e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return map;
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject2.get(next).toString());
            }
            return map;
        } catch (JSONException e9) {
            Logger.w(f15000e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e9.getMessage()));
            return map;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                    concurrentHashMap.put(next, string);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e9) {
            Logger.w(f15000e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e9.getMessage()));
            return concurrentHashMap;
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i9) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> mapA = a(str, bVar, context);
        if (!bVar.a()) {
            this.f15003c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f15001a, context), new C0166a(str, mapA, iQueryUrlsCallBack, context, this.f15001a, this.f15002b), str, this.f15004d, i9);
        } else if (mapA.isEmpty()) {
            Logger.i(f15000e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            String str2 = f15000e;
            Logger.i(str2, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            Logger.i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(mapA);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i9) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (!bVar.a()) {
            this.f15003c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f15001a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f15001a, this.f15002b), str, this.f15004d, i9);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.i(f15000e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.i(f15000e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
