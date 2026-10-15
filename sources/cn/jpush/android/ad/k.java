package cn.jpush.android.ad;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11174a;

    private static String a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    private static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("getCurrentProcessNameByActivityThread failed, "), "ProcessUtil");
        }
        return null;
    }

    private static String c() {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream("/proc/self/cmdline");
                try {
                    byte[] bArr = new byte[256];
                    int i9 = 0;
                    while (true) {
                        int i10 = fileInputStream2.read();
                        if (i10 <= 0 || i9 >= 256) {
                            break;
                        }
                        bArr[i9] = (byte) i10;
                        i9++;
                    }
                    if (i9 > 0) {
                        String str = new String(bArr, 0, i9, "UTF-8");
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused) {
                        }
                        return str;
                    }
                    fileInputStream2.close();
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                        return "";
                    }
                    fileInputStream.close();
                }
            } catch (Throwable unused3) {
            }
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f11174a)) {
            return f11174a;
        }
        String strA = a();
        f11174a = strA;
        if (!TextUtils.isEmpty(strA)) {
            return f11174a;
        }
        String strB = b();
        f11174a = strB;
        if (!TextUtils.isEmpty(strB)) {
            return f11174a;
        }
        String strC = c();
        f11174a = strC;
        String str = !TextUtils.isEmpty(strC) ? f11174a : "";
        f11174a = str;
        return str;
    }
}
