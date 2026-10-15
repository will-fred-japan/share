package V0;

import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static String a() {
        Throwable th;
        String str;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.emui").getInputStream()), 1024);
            try {
                line = bufferedReader2.readLine();
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return line;
            } catch (Throwable th2) {
                str = line;
                bufferedReader = bufferedReader2;
                th = th2;
                try {
                    m.b(th);
                    return str;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop ".concat(str));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return line;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return line;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static boolean c() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(MTPushConstants.Manufacturer.OPPO);
    }

    public static boolean d() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean e() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith(MTPushConstants.Manufacturer.HONOR)) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith(MTPushConstants.Manufacturer.HONOR);
    }

    public static boolean f() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
        }
    }
}
