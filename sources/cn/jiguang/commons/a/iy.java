package cn.jiguang.commons.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes.dex */
public final class iy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f10238b;

    private static Intent a(String str, int i9) throws URISyntaxException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent uri = Intent.parseUri(str, i9);
        Intent intent = new Intent(uri);
        uri.addCategory("android.intent.category.BROWSABLE");
        uri.setComponent(null);
        uri.setSelector(null);
        return intent;
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                byte[] bArr = new byte[256];
                while (true) {
                    int i9 = fileInputStream.read(bArr);
                    if (i9 <= 0) {
                        fileInputStream.close();
                        return sb.toString();
                    }
                    for (int i10 = 0; i10 < i9; i10++) {
                        byte b9 = bArr[i10];
                        if (b9 == 0) {
                            break;
                        }
                        sb.append((char) b9);
                    }
                    return "";
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return "";
        }
    }

    public static boolean c(String str) {
        Intent intent;
        PackageManager packageManager = jg.a().getPackageManager();
        try {
            if (packageManager.checkPermission("android.permission.INTERNET", str) == 0) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.INFO");
            intent2.setPackage(str);
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent2, 0);
            if (resolveInfoResolveActivity == null) {
                intent2.removeCategory("android.intent.category.INFO");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setPackage(str);
                resolveInfoResolveActivity = packageManager.resolveActivity(intent2, 0);
            }
            if (resolveInfoResolveActivity == null) {
                intent = null;
            } else {
                intent = new Intent(intent2);
                intent.setFlags(268435456);
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            return intent != null;
        } catch (Throwable unused2) {
        }
    }

    private static String a() {
        if (!TextUtils.isEmpty(f10237a)) {
            return f10237a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                f10237a = processName;
                if (!TextUtils.isEmpty(processName)) {
                    return f10237a;
                }
            }
            f10237a = b();
        } catch (Throwable unused) {
        }
        return f10237a;
    }

    public static boolean b(String str) {
        try {
            PackageManager packageManager = jg.a().getPackageManager();
            String[] strArrSplit = str.split("\\|");
            if (strArrSplit.length <= 1) {
                return false;
            }
            Intent intentA = a(strArrSplit[1], 4);
            intentA.setPackage(strArrSplit[0]);
            if (packageManager.resolveActivity(intentA, 0) != null) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Context context) {
        if (f10238b == null) {
            f10238b = Boolean.valueOf(context.getPackageName().equals(a()));
        }
        return f10238b.booleanValue();
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = jg.a().getPackageManager();
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
                if (launchIntentForPackage != null && packageManager.resolveActivity(launchIntentForPackage, 65536) != null) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
