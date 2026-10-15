package com.heytap.mcssdk.utils;

import android.os.Binder;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14401a = "PushService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f14402b = 100000;

    public static int a() {
        try {
            UserHandle callingUserHandle = Binder.getCallingUserHandle();
            Method declaredMethod = callingUserHandle.getClass().getDeclaredMethod("getIdentifier", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(callingUserHandle, new Object[0])).intValue();
        } catch (Exception e9) {
            e.b(f14401a, "get userId exception," + e9);
            return 0;
        }
    }

    public static int a(int i9, int i10) {
        return (i9 % f14402b) + (i10 * f14402b);
    }
}
