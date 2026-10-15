package b5;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.apps.common.proguard.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f8585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f8586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f8587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f8588d;

    @SideEffectFree
    @TargetApi(20)
    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f8585a == null) {
            f8585a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f8585a.booleanValue();
    }

    @TargetApi(26)
    public static boolean b(Context context) {
        a(context);
        if (f8586b == null) {
            f8586b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f8586b.booleanValue() && Build.VERSION.SDK_INT >= 30;
    }
}
