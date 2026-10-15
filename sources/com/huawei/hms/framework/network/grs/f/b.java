package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f15051b = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f15052c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f15053a;

    public b() {
        this.f15053a = new d(true, true);
    }

    public static b a(String str) {
        return f15051b.get(str);
    }

    public Set<String> b() {
        return this.f15053a.c();
    }

    public b(Context context, boolean z8) {
        a(context, z8);
        f15051b.put(context.getPackageName(), this);
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f15053a.b();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z8) {
        String strA;
        synchronized (f15052c) {
            strA = this.f15053a.a(context, aVar, grsBaseInfo, str, str2, z8);
        }
        return strA;
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z8) {
        Map<String, String> mapA;
        synchronized (f15052c) {
            mapA = this.f15053a.a(context, aVar, grsBaseInfo, str, z8);
        }
        return mapA;
    }

    private void a(Context context, boolean z8) {
        String[] strArrSplit;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = com.huawei.hms.framework.network.grs.h.c.a("grs_route_config_files_list.txt", context);
        Logger.i("LocalManagerProxy", "initLocalManager configFileListContent TimeCost:%d  Content:%s", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), strA);
        if (TextUtils.isEmpty(strA)) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            strArrSplit = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            Logger.i("LocalManagerProxy", "list by AssetsManager, timeCost:" + (System.currentTimeMillis() - jCurrentTimeMillis2));
        } else {
            strArrSplit = strA.split("#");
        }
        List<String> arrayList = strArrSplit == null ? new ArrayList<>() : Arrays.asList(strArrSplit);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.f15053a = new d(false, z8);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f15053a = new d(context, appConfigName, z8);
        }
        if (!this.f15053a.d() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f15053a = new c(context, z8);
        }
        this.f15053a.a(context, arrayList);
        StringBuilder sb = new StringBuilder("on initLocalManager finish, check appGrs: ");
        sb.append(this.f15053a.f15046a == null);
        Logger.i("LocalManagerProxy", sb.toString());
    }

    public void a(String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        String str2;
        try {
            cVar.b(str + "#localConfig", this.f15053a.a().toString());
        } catch (JSONException unused) {
            str2 = "save local config encounter JSONException.";
            Logger.w("LocalManagerProxy", str2);
        } catch (Throwable th) {
            str2 = "save local config encounter Throwable:" + StringUtils.anonymizeMessage(th.getMessage());
            Logger.w("LocalManagerProxy", str2);
        }
    }

    public boolean a(Context context, String str) {
        boolean zD = this.f15053a.d(str);
        f15051b.put(context.getPackageName(), this);
        return zD;
    }
}
