package A4;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ToolUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f1478b = -1;

    public static String a() {
        String processName;
        String str;
        BufferedReader bufferedReader;
        if (!TextUtils.isEmpty(f1477a)) {
            return f1477a;
        }
        String string = null;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                processName = Application.getProcessName();
            } catch (Throwable th) {
                th.printStackTrace();
                processName = null;
            }
        } else {
            processName = null;
        }
        f1477a = processName;
        if (!TextUtils.isEmpty(processName)) {
            return f1477a;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            str = (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th2) {
            th2.printStackTrace();
            str = null;
        }
        f1477a = str;
        if (!TextUtils.isEmpty(str)) {
            return f1477a;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i9 = bufferedReader.read();
                    if (i9 <= 0) {
                        break;
                    }
                    sb.append((char) i9);
                }
                string = sb.toString();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        p027d5.a.o(bufferedReader);
        f1477a = string;
        return string;
    }

    public static boolean b() {
        int i9 = f1478b;
        if (i9 != -1) {
            return i9 == 1;
        }
        try {
            Class.forName("ohos.utils.system.SystemCapability");
            f1478b = 1;
        } catch (Throwable unused) {
            f1478b = 0;
        }
        return f1478b == 1;
    }
}
