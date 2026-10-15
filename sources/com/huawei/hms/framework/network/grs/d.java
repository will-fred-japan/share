package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, c> f15034a = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f15035b = new Object();

    public static c a(GrsBaseInfo grsBaseInfo, Context context) {
        c cVar;
        synchronized (f15035b) {
            try {
                int iUniqueCode = grsBaseInfo.uniqueCode();
                Map<String, c> map = f15034a;
                cVar = map.get(context.getPackageName() + iUniqueCode);
                if (cVar == null) {
                    Logger.i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");
                    cVar = new c(context, grsBaseInfo);
                    map.put(context.getPackageName() + iUniqueCode, cVar);
                } else if (!cVar.a((Object) new c(grsBaseInfo))) {
                    Logger.i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");
                    cVar = new c(context, grsBaseInfo);
                    map.put(context.getPackageName() + iUniqueCode, cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }
}
