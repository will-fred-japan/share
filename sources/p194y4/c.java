package p194y4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: compiled from: PermissionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static boolean a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            String[] strArr = (Build.VERSION.SDK_INT < 33 ? packageManager.getPackageInfo(packageName, 4096) : packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(4096L))).requestedPermissions;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (str2.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        return false;
    }
}
