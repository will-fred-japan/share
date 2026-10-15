package cn.jiguang.aw;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q {
    public static List<String> a(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!a(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            PackageInfo packageInfoA = p.a(context, 4096);
            if (packageInfoA != null) {
                for (String str2 : packageInfoA.requestedPermissions) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.x.f.j("PermissionUtils", "hasPermissionDefined error:" + th.getMessage());
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 23) {
                return context.checkSelfPermission(str) == 0;
            }
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            return strPermissionToOp == null || ((AppOpsManager) context.getSystemService("appops")).noteProxyOpNoThrow(strPermissionToOp, context.getPackageName()) == 0;
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("checkPermission error:"), "PermissionUtils");
            return false;
        }
    }
}
