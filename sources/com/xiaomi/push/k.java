package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f18120a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, o> f923a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f18121b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m648a() {
        return a() == 1;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m653b() {
        return a() == 2;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m654c() {
        if (f18121b < 0) {
            f18121b = !m658g() ? 1 : 0;
        }
        return f18121b > 0;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public static boolean m655d() {
        try {
            return TextUtils.equals("com.xiaomi.xmsf", (CharSequence) bh.a("android.app.ActivityThread", "currentPackageName", new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public static boolean m656e() {
        return !o.China.name().equalsIgnoreCase(a(m651b()).name());
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public static boolean m657f() {
        return a(1);
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    public static boolean m658g() {
        String strA;
        String strA2 = "";
        try {
            strA = C0593r.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
            strA = "";
        }
        if (TextUtils.isEmpty(strA)) {
            try {
                strA2 = C0593r.a("ro.mi.os.version.code", "");
            } catch (Exception unused2) {
            }
        } else {
            strA2 = strA;
        }
        return !TextUtils.isEmpty(strA2);
    }

    public static String h() {
        return m646a("ro.product.manufacturer");
    }

    public static int a() {
        if (f18120a == 0) {
            try {
                f18120a = (TextUtils.isEmpty(m646a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m646a("ro.miui.ui.version.name")) && TextUtils.isEmpty(m646a("ro.mi.os.version.code")) && TextUtils.isEmpty(m646a("ro.mi.os.version.name"))) ? 2 : 1;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.c.a("get isMIUI failed", th);
                f18120a = 0;
            }
            com.xiaomi.channel.commonutils.logger.c.b("isMIUI's value is: " + f18120a);
        }
        return f18120a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static String m651b() {
        String strA = C0593r.a("ro.miui.region", "");
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = m652b(C0593r.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = C0593r.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("get region from system, region = " + strA);
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String country = Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.c.m9a("locale.default.country = " + country);
        return country;
    }

    public static String d() {
        return m646a("ro.mi.os.version.incremental");
    }

    public static String e() {
        return m657f() ? d() : Build.VERSION.INCREMENTAL;
    }

    public static String f() {
        return m646a("ro.miui.ui.version.name");
    }

    public static String c() {
        return m646a("ro.mi.os.version.name");
    }

    public static String g() {
        return m646a(com.heytap.mcssdk.utils.d.f14376d);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m645a() {
        int iA = t.a();
        if (!m648a() || iA <= 0) {
            return "";
        }
        if (iA < 2) {
            return "alpha";
        }
        if (iA < 3) {
            return "development";
        }
        return "stable";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m646a(String str) {
        try {
            try {
                return (String) bh.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.d("fail to get property. " + e9);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m649a(Context context) {
        return context != null && m650a(context.getPackageName());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m650a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static o a(String str) {
        o oVarB = b(str);
        return oVarB == null ? o.Global : oVarB;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m647a() {
        if (f923a != null) {
            return;
        }
        HashMap map = new HashMap();
        f923a = map;
        map.put("CN", o.China);
        Map<String, o> map2 = f923a;
        o oVar = o.Europe;
        map2.put("FI", oVar);
        f923a.put("SE", oVar);
        f923a.put("NO", oVar);
        f923a.put("FO", oVar);
        f923a.put("EE", oVar);
        f923a.put("LV", oVar);
        f923a.put("LT", oVar);
        f923a.put("BY", oVar);
        f923a.put("MD", oVar);
        f923a.put("UA", oVar);
        f923a.put("PL", oVar);
        f923a.put("CZ", oVar);
        f923a.put("SK", oVar);
        f923a.put("HU", oVar);
        f923a.put("DE", oVar);
        f923a.put("AT", oVar);
        f923a.put("CH", oVar);
        f923a.put("LI", oVar);
        f923a.put("GB", oVar);
        f923a.put("IE", oVar);
        f923a.put("NL", oVar);
        f923a.put("BE", oVar);
        f923a.put("LU", oVar);
        f923a.put("FR", oVar);
        f923a.put("RO", oVar);
        f923a.put("BG", oVar);
        f923a.put("RS", oVar);
        f923a.put("MK", oVar);
        f923a.put("AL", oVar);
        f923a.put("GR", oVar);
        f923a.put("SI", oVar);
        f923a.put("HR", oVar);
        f923a.put("IT", oVar);
        f923a.put("SM", oVar);
        f923a.put("MT", oVar);
        f923a.put("ES", oVar);
        f923a.put("PT", oVar);
        f923a.put("AD", oVar);
        f923a.put("CY", oVar);
        f923a.put("DK", oVar);
        f923a.put("IS", oVar);
        f923a.put("UK", oVar);
        f923a.put("EL", oVar);
        f923a.put("RU", o.Russia);
        f923a.put("IN", o.India);
    }

    private static o b(String str) {
        m647a();
        return f923a.get(str.toUpperCase());
    }

    public static int b() {
        String strM646a = m646a("ro.mi.os.version.code");
        if (TextUtils.isEmpty(strM646a) || !TextUtils.isDigitsOnly(strM646a)) {
            return 0;
        }
        return Integer.parseInt(strM646a);
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static String m652b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return strArrSplit.length > 0 ? strArrSplit[0] : str;
    }

    public static int a(Context context) {
        String strM646a = m646a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(strM646a) || !TextUtils.isDigitsOnly(strM646a)) {
            return 0;
        }
        return Integer.parseInt(strM646a);
    }

    public static boolean a(int i9) {
        String strM646a = m646a("ro.mi.os.version.code");
        return !TextUtils.isEmpty(strM646a) && TextUtils.isDigitsOnly(strM646a) && Integer.parseInt(strM646a) >= i9;
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z8 = true;
            for (String str : bundle.keySet()) {
                if (!z8) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb.append(a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z8 = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
