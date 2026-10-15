package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements AGConnectOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AGCRoutePolicy f14582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConfigReader f14583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f14584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, String> f14585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<Service> f14586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, String> f14587i = new HashMap();

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f14580b = context;
        str = str == null ? context.getPackageName() : str;
        this.f14581c = str;
        if (inputStream != null) {
            this.f14583e = new i(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f14583e = new m(context, str);
        }
        this.f14584f = new e(this.f14583e);
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy != aGCRoutePolicy2 && "1.0".equals(this.f14583e.getString("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f14582d = (aGCRoutePolicy == null || aGCRoutePolicy == aGCRoutePolicy2) ? Utils.getRoutePolicyFromJson(this.f14583e.getString("/region", null), this.f14583e.getString("/agcgw/url", null)) : aGCRoutePolicy;
        this.f14585g = Utils.fixKeyPathMap(map);
        this.f14586h = list;
        this.f14579a = str2 == null ? b() : str2;
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.f14587i.containsKey(str)) {
            return this.f14587i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String strProcessOption = jsonProcessor.processOption(this);
        this.f14587i.put(str, strProcessOption);
        return strProcessOption;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f14581c + "', routePolicy=" + this.f14582d + ", reader=" + this.f14583e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f14585g).toString().hashCode() + '}').hashCode());
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.f14580b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.f14579a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f14581c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f14582d;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    public List<Service> a() {
        return this.f14586h;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str, boolean z8) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z8)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str, int i9) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i9)));
        } catch (NumberFormatException unused) {
            return i9;
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String strFixPath = Utils.fixPath(str);
        String str3 = this.f14585g.get(strFixPath);
        if (str3 != null) {
            return str3;
        }
        String strA = a(strFixPath);
        if (strA != null) {
            return strA;
        }
        String string = this.f14583e.getString(strFixPath, str2);
        return e.a(string) ? this.f14584f.decrypt(string, str2) : string;
    }
}
