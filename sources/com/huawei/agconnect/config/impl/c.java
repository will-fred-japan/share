package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends AGConnectServicesConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LazyInputStream f14590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ConfigReader f14591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f14592e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AGCRoutePolicy f14593f = AGCRoutePolicy.UNKNOWN;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, String> f14594g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile e f14595h;

    public c(Context context, String str) {
        this.f14588a = context;
        this.f14589b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) { // from class: com.huawei.agconnect.config.impl.c.1
            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context2) {
                return inputStream;
            }
        };
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.f14588a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f14589b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        Log.d("AGC_ConfigImpl", "getRoutePolicy");
        if (this.f14593f == null) {
            this.f14593f = AGCRoutePolicy.UNKNOWN;
        }
        AGCRoutePolicy aGCRoutePolicy = this.f14593f;
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 && this.f14591d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy3 = this.f14593f;
        return aGCRoutePolicy3 == null ? aGCRoutePolicy2 : aGCRoutePolicy3;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f14590c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(String str, String str2) {
        this.f14594g.put(Utils.fixPath(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f14593f = aGCRoutePolicy;
    }

    private static String a(String str) {
        int i9 = 0;
        if (str.length() > 0) {
            while (str.charAt(i9) == '/') {
                i9++;
            }
        }
        return "/" + str.substring(i9);
    }

    private void b() {
        if (this.f14593f == AGCRoutePolicy.UNKNOWN) {
            if (this.f14591d != null) {
                this.f14593f = Utils.getRoutePolicyFromJson(this.f14591d.getString("/region", null), this.f14591d.getString("/agcgw/url", null));
            } else {
                Log.w("AGConnectServiceConfig", "get route fail , config not ready");
            }
        }
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
            throw new NullPointerException("path must not be null.");
        }
        if (this.f14591d == null) {
            a();
        }
        String strA = a(str);
        String str3 = this.f14594g.get(strA);
        if (str3 != null) {
            return str3;
        }
        String strB = b(strA);
        if (strB != null) {
            return strB;
        }
        String string = this.f14591d.getString(strA, str2);
        return e.a(string) ? this.f14595h.decrypt(string, str2) : string;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.f14588a, inputStream));
    }

    private void a() {
        Log.d("AGC_ConfigImpl", "initConfigReader");
        if (this.f14591d == null) {
            synchronized (this.f14592e) {
                try {
                    if (this.f14591d == null) {
                        LazyInputStream lazyInputStream = this.f14590c;
                        if (lazyInputStream != null) {
                            this.f14591d = new i(lazyInputStream.loadInputStream(), "UTF-8");
                            this.f14590c.close();
                            this.f14590c = null;
                        } else {
                            this.f14591d = new m(this.f14588a, this.f14589b);
                        }
                        this.f14595h = new e(this.f14591d);
                    }
                    b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
