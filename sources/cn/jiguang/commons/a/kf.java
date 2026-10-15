package cn.jiguang.commons.a;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class kf {
    public static boolean a(Context context) {
        return b(context);
    }

    @TargetApi(24)
    private static boolean b(Context context) {
        try {
            return ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled();
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("invoke areNotificationsEnabled method failed, error:"), "NotificationUtils");
            return true;
        }
    }

    private static boolean c(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i9 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i9), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("getNotificationStateCommon failed, other error:"), "NotificationUtils");
            return true;
        }
    }
}
