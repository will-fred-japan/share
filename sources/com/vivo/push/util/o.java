package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Device.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f16891f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f16886a = ak.b("ro.vivo.product.overseas", "no").equals("yes");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f16887b = b("rom_1.0");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f16888c = b("rom_2.0");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f16889d = b("rom_2.5");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f16890e = b("rom_3.0");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f16892g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f16893h = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e9) {
            e9.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String strB = ak.b("ro.vivo.rom", "");
        String strB2 = ak.b("ro.vivo.rom.version", "");
        w.d("Device", "ro.vivo.rom = " + strB + " ; ro.vivo.rom.version = " + strB2);
        if (strB == null || !strB.contains(str)) {
            return strB2 != null && strB2.contains(str);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x007f A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:17:0x0081 A[Catch: all -> 0x004b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0008, B:8:0x000c, B:12:0x004d, B:13:0x0054, B:17:0x0081), top: B:27:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x008d A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:21:0x008f A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:15:0x007f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x008d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x008f, please report this as an issue */
    public static synchronized String a() {
        String strA;
        String strA2;
        if (f16892g == null && f16893h == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                f16891f = declaredMethod;
                declaredMethod.setAccessible(true);
                f16892g = (String) f16891f.invoke(null, "ro.vivo.rom", "@><@");
                f16893h = (String) f16891f.invoke(null, "ro.vivo.rom.version", "@><@");
            } catch (Exception unused) {
                w.b("Device", "getRomCode error");
            }
            w.d("Device", "sRomProperty1 : " + f16892g + " ; sRomProperty2 : " + f16893h);
            strA = a(f16892g);
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
            strA2 = a(f16893h);
            if (TextUtils.isEmpty(strA2)) {
                return null;
            }
            return strA2;
        }
        w.d("Device", "sRomProperty1 : " + f16892g + " ; sRomProperty2 : " + f16893h);
        strA = a(f16892g);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        strA2 = a(f16893h);
        if (TextUtils.isEmpty(strA2)) {
            return strA2;
        }
        return null;
        throw th;
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            w.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        w.d("Device", "Build.MANUFACTURER is " + str);
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith(MTPushConstants.Manufacturer.VIVO);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matcher.group(1));
        sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb.toString();
    }
}
