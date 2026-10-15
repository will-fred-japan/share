package com.vivo.push.restructure.b;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.vivo.push.util.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PushSystemRelyImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements b {
    @Override // com.vivo.push.util.q
    public final List<String> a(Context context) {
        if (w.b() && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("DebugUtil", "Operation: findAllCoreClientPush in main thread!", new Throwable());
        }
        List<ResolveInfo> listQueryIntentServices = null;
        if (!com.vivo.push.restructure.a.a().e().m().isAgreePrivacyStatement()) {
            w.d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (Exception unused) {
        }
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
            int size = listQueryIntentServices.size();
            for (int i9 = 0; i9 < size; i9++) {
                ResolveInfo resolveInfo = listQueryIntentServices.get(i9);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            w.d("PushSystemRelyImpl", "get all push packages is null");
        }
        return arrayList;
    }

    @Override // com.vivo.push.util.q
    public final boolean b(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled();
        } catch (Exception e9) {
            w.a("PushSystemRelyImpl", "isNotifySwitchOpen error", e9);
            return true;
        }
    }
}
