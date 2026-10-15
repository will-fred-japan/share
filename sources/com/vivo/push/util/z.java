package com.vivo.push.util;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MultiWindowUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 34) {
            return activity.isInMultiWindowMode() || b(activity);
        }
        return activity.isInMultiWindowMode();
    }

    private static boolean b(Activity activity) {
        Window window = activity.getWindow();
        try {
            Class<?> cls = window.getClass();
            Method method = null;
            if (cls.getSuperclass() != null) {
                for (Method method2 : cls.getSuperclass().getDeclaredMethods()) {
                    if (method2 != null && "getWindowControllerCallback".equals(method2.getName())) {
                        method = method2;
                    }
                }
            }
            if (method != null) {
                Object objInvoke = method.invoke(window, new Object[0]);
                if (objInvoke != null) {
                    for (Method method3 : objInvoke.getClass().getDeclaredMethods()) {
                        if (method3 != null && "isInVivoFreeformMode".equals(method3.getName())) {
                            method = method3;
                        }
                    }
                    return ((Boolean) method.invoke(objInvoke, new Object[0])).booleanValue();
                }
            } else {
                w.a("MultiWindowUtils", "<isWindowModeFreeForm> registerActivityObserver not implement in IActivityManager");
            }
        } catch (Exception e9) {
            w.a("MultiWindowUtils", "<isWindowModeFreeForm> registerActivityObserver-e = ", e9);
        }
        return false;
    }
}
