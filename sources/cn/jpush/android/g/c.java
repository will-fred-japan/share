package cn.jpush.android.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static boolean a(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 4);
            String str2 = packageInfo.sharedUserId;
            if (!str2.equals("android.uid.system")) {
                cn.jpush.android.i.b.e("ConnectionFactory", str + " is not system app,sharedUserId:" + str2);
                return false;
            }
            serviceInfoArr = packageInfo.services;
            if (serviceInfoArr == null) {
                cn.jpush.android.i.b.a("ConnectionFactory", "not found service by:" + str);
                return false;
            }
            for (int i9 = 0; i9 < serviceInfoArr.length; i9++) {
                cn.jpush.android.i.b.a("ConnectionFactory", "serviceInfos:" + serviceInfoArr[i9].name);
                if ("cn.jpush.android.service.PushManagerService".equalsIgnoreCase(serviceInfoArr[i9].name)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            serviceInfoArr = null;
        }
    }
}
