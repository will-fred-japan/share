package G;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: NavUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static Intent a(androidx.appcompat.app.f fVar) {
        Intent parentActivityIntent = fVar.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String strC = c(fVar, fVar.getComponentName());
            if (strC == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(fVar, strC);
            try {
                return c(fVar, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strC + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public static Intent b(androidx.appcompat.app.f fVar, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strC = c(fVar, componentName);
        if (strC == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strC);
        return c(fVar, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String c(Activity activity, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return activity.getPackageName() + string;
    }
}
