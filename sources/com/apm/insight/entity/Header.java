package com.apm.insight.entity;

import A4.c;
import A4.d;
import Y3.a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import com.apm.insight.ICommonParams;
import com.apm.insight.f;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.starburst.sdk.api.GuiControlConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import p142s2.j;
import p144s4.b;
import p144s4.g;
import p152t4.p;

/* JADX INFO: loaded from: classes.dex */
public final class Header {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f11847b = {"version_code", "manifest_version_code", "aid", "update_version_code"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f11848c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f11849d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f11850e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f11851a = new JSONObject();

    public static Header a() {
        Header header = new Header();
        JSONObject jSONObject = header.f11851a;
        try {
            jSONObject.put(HianalyticsBaseData.SDK_VERSION, 1052190);
            jSONObject.put("sdk_version_name", "1.5.21");
        } catch (Exception unused) {
        }
        return header;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0059 A[Catch: all -> 0x006b, TryCatch #3 {all -> 0x006b, blocks: (B:5:0x000a, B:8:0x0012, B:24:0x004e, B:26:0x0059, B:27:0x0062, B:9:0x0016, B:11:0x0020, B:18:0x0033, B:20:0x003d, B:21:0x0042, B:23:0x0048), top: B:107:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:30:0x007b  */
    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0082  */
    /* JADX WARN: Code duplicated, block: B:34:0x0085  */
    /* JADX WARN: Code duplicated, block: B:36:0x0089  */
    /* JADX WARN: Code duplicated, block: B:37:0x008c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0090  */
    /* JADX WARN: Code duplicated, block: B:40:0x0094  */
    /* JADX WARN: Code duplicated, block: B:42:0x0098  */
    /* JADX WARN: Code duplicated, block: B:43:0x009c  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ad A[Catch: Exception -> 0x00cb, TRY_LEAVE, TryCatch #2 {Exception -> 0x00cb, blocks: (B:28:0x006b, B:44:0x009f, B:46:0x00ad), top: B:105:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e8 A[Catch: Exception -> 0x011c, TryCatch #1 {Exception -> 0x011c, blocks: (B:50:0x00d2, B:52:0x00e8, B:53:0x00ed, B:55:0x00fb, B:56:0x0100, B:62:0x0116), top: B:103:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00fb A[Catch: Exception -> 0x011c, TryCatch #1 {Exception -> 0x011c, blocks: (B:50:0x00d2, B:52:0x00e8, B:53:0x00ed, B:55:0x00fb, B:56:0x0100, B:62:0x0116), top: B:103:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0110  */
    /* JADX WARN: Code duplicated, block: B:61:0x0115  */
    /* JADX WARN: Code duplicated, block: B:65:0x0134 A[Catch: all -> 0x01d2, TryCatch #0 {all -> 0x01d2, blocks: (B:63:0x011c, B:65:0x0134, B:69:0x0147, B:68:0x0141, B:70:0x0151, B:72:0x0155, B:79:0x017b, B:76:0x0161, B:78:0x0167, B:80:0x017e, B:82:0x01a8, B:85:0x01ae, B:86:0x01b2, B:87:0x01b6, B:88:0x01c1, B:93:0x01ce), top: B:101:0x011c }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0140  */
    /* JADX WARN: Code duplicated, block: B:68:0x0141 A[Catch: all -> 0x01d2, TryCatch #0 {all -> 0x01d2, blocks: (B:63:0x011c, B:65:0x0134, B:69:0x0147, B:68:0x0141, B:70:0x0151, B:72:0x0155, B:79:0x017b, B:76:0x0161, B:78:0x0167, B:80:0x017e, B:82:0x01a8, B:85:0x01ae, B:86:0x01b2, B:87:0x01b6, B:88:0x01c1, B:93:0x01ce), top: B:101:0x011c }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0155 A[Catch: all -> 0x01d2, TryCatch #0 {all -> 0x01d2, blocks: (B:63:0x011c, B:65:0x0134, B:69:0x0147, B:68:0x0141, B:70:0x0151, B:72:0x0155, B:79:0x017b, B:76:0x0161, B:78:0x0167, B:80:0x017e, B:82:0x01a8, B:85:0x01ae, B:86:0x01b2, B:87:0x01b6, B:88:0x01c1, B:93:0x01ce), top: B:101:0x011c }] */
    /* JADX WARN: Code duplicated, block: B:74:0x015d  */
    /* JADX WARN: Code duplicated, block: B:75:0x015f  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a8 A[Catch: all -> 0x01d2, TRY_LEAVE, TryCatch #0 {all -> 0x01d2, blocks: (B:63:0x011c, B:65:0x0134, B:69:0x0147, B:68:0x0141, B:70:0x0151, B:72:0x0155, B:79:0x017b, B:76:0x0161, B:78:0x0167, B:80:0x017e, B:82:0x01a8, B:85:0x01ae, B:86:0x01b2, B:87:0x01b6, B:88:0x01c1, B:93:0x01ce), top: B:101:0x011c }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01ae A[Catch: all -> 0x01d2, TRY_ENTER, TryCatch #0 {all -> 0x01d2, blocks: (B:63:0x011c, B:65:0x0134, B:69:0x0147, B:68:0x0141, B:70:0x0151, B:72:0x0155, B:79:0x017b, B:76:0x0161, B:78:0x0167, B:80:0x017e, B:82:0x01a8, B:85:0x01ae, B:86:0x01b2, B:87:0x01b6, B:88:0x01c1, B:93:0x01ce), top: B:101:0x011c }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01b6 A[Catch: all -> 0x01d2, TryCatch #0 {all -> 0x01d2, blocks: (B:63:0x011c, B:65:0x0134, B:69:0x0147, B:68:0x0141, B:70:0x0151, B:72:0x0155, B:79:0x017b, B:76:0x0161, B:78:0x0167, B:80:0x017e, B:82:0x01a8, B:85:0x01ae, B:86:0x01b2, B:87:0x01b6, B:88:0x01c1, B:93:0x01ce), top: B:101:0x011c }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:92:0x01cc  */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x00ad, please report this as an issue */
    @Keep
    public static void addOtherHeader(JSONObject jSONObject) {
        String language;
        String country;
        int rawOffset;
        Context context;
        PackageInfo packageInfoB;
        ApplicationInfo applicationInfo;
        Object obj;
        int i9;
        Object applicationLabel;
        String str;
        String str2;
        String strConcat;
        DisplayMetrics displayMetrics;
        int i10;
        Object obj2;
        String str3;
        if (jSONObject == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                try {
                    if (b.d()) {
                        str3 = "MIUI-";
                    } else {
                        if (!(Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme"))) {
                            String strA = b.a();
                            if (b.b(strA)) {
                                sb.append("EMUI-");
                            }
                            if (!TextUtils.isEmpty(strA)) {
                                sb.append(strA);
                                str3 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
                            }
                            sb.append(Build.VERSION.INCREMENTAL);
                            if (sb.length() > 0) {
                                jSONObject.put("rom", sb.toString());
                            }
                            jSONObject.put("rom_version", g.a());
                            displayMetrics = f.f11853a.getResources().getDisplayMetrics();
                            i10 = displayMetrics.densityDpi;
                            if (i10 < 160) {
                                obj2 = "ldpi";
                            } else if (i10 < 240) {
                                obj2 = "mdpi";
                            } else if (i10 < 320) {
                                obj2 = "hdpi";
                            } else if (i10 < 480) {
                                obj2 = "xhdpi";
                            } else if (i10 < 640) {
                                obj2 = "xxhdpi";
                            } else {
                                obj2 = "xxxhdpi";
                            }
                            jSONObject.put("density_dpi", i10);
                            jSONObject.put("display_density", obj2);
                            if (a.f5233o) {
                                jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
                            }
                            Context context2 = f.f11853a;
                            if (a.f5236r) {
                                try {
                                    language = f.f11853a.getResources().getConfiguration().locale.getLanguage();
                                    if (!TextUtils.isEmpty(language)) {
                                        jSONObject.put("language", language);
                                    }
                                    country = Locale.getDefault().getCountry();
                                    if (!TextUtils.isEmpty(country)) {
                                        jSONObject.put("region", country);
                                    }
                                    rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
                                    if (rawOffset < -12) {
                                        rawOffset = -12;
                                    }
                                    if (rawOffset > 12) {
                                        rawOffset = 12;
                                    }
                                    jSONObject.put("timezone", rawOffset);
                                } catch (Exception unused) {
                                }
                            }
                            jSONObject.put("os", "Android");
                            jSONObject.put("device_id", f.e().a());
                            if (a.f5235q) {
                                strConcat = Build.VERSION.RELEASE;
                                if (strConcat.contains(".")) {
                                    strConcat = strConcat.concat(".0");
                                }
                                jSONObject.put("os_version", strConcat);
                                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                            }
                            if (a.f5232n) {
                                str = Build.MODEL;
                                str2 = Build.BRAND;
                                if (str == null) {
                                    str = str2;
                                } else if (str2 != null && !str.contains(str2)) {
                                    str = str2 + ' ' + str;
                                }
                                jSONObject.put("device_model", str);
                            }
                            jSONObject.put("device_brand", Build.BRAND);
                            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                            jSONObject.put("cpu_abi", l());
                            context = f.f11853a;
                            String packageName = context.getPackageName();
                            jSONObject.put("package", packageName);
                            packageInfoB = c.b(0, packageName, context);
                            applicationInfo = packageInfoB.applicationInfo;
                            if (applicationInfo != null) {
                                i9 = applicationInfo.labelRes;
                                if (i9 > 0) {
                                    applicationLabel = context.getString(i9);
                                } else {
                                    applicationLabel = context.getPackageManager().getApplicationLabel(packageInfoB.applicationInfo);
                                }
                                jSONObject.put("display_name", applicationLabel);
                            }
                            if (d.b()) {
                                obj = "1";
                            } else {
                                obj = "0";
                            }
                            jSONObject.put("is_harmony_os", obj);
                            return;
                        }
                        str3 = "FLYME-";
                    }
                    sb.append(str3);
                    sb.append(Build.VERSION.INCREMENTAL);
                    if (sb.length() > 0) {
                        jSONObject.put("rom", sb.toString());
                    }
                    jSONObject.put("rom_version", g.a());
                } catch (Throwable unused2) {
                }
                displayMetrics = f.f11853a.getResources().getDisplayMetrics();
                i10 = displayMetrics.densityDpi;
                if (i10 < 160) {
                    obj2 = "ldpi";
                } else if (i10 < 240) {
                    obj2 = "mdpi";
                } else if (i10 < 320) {
                    obj2 = "hdpi";
                } else if (i10 < 480) {
                    obj2 = "xhdpi";
                } else if (i10 < 640) {
                    obj2 = "xxhdpi";
                } else {
                    obj2 = "xxxhdpi";
                }
                jSONObject.put("density_dpi", i10);
                jSONObject.put("display_density", obj2);
                if (a.f5233o) {
                    jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
                }
            } catch (Exception unused3) {
            }
            jSONObject.put("os", "Android");
            jSONObject.put("device_id", f.e().a());
            if (a.f5235q) {
                strConcat = Build.VERSION.RELEASE;
                if (strConcat.contains(".")) {
                    strConcat = strConcat.concat(".0");
                }
                jSONObject.put("os_version", strConcat);
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
            }
            if (a.f5232n) {
                str = Build.MODEL;
                str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null) {
                    str = str2 + ' ' + str;
                }
                jSONObject.put("device_model", str);
            }
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", l());
            context = f.f11853a;
            String packageName2 = context.getPackageName();
            jSONObject.put("package", packageName2);
            packageInfoB = c.b(0, packageName2, context);
            applicationInfo = packageInfoB.applicationInfo;
            if (applicationInfo != null) {
                i9 = applicationInfo.labelRes;
                if (i9 > 0) {
                    applicationLabel = context.getString(i9);
                } else {
                    applicationLabel = context.getPackageManager().getApplicationLabel(packageInfoB.applicationInfo);
                }
                jSONObject.put("display_name", applicationLabel);
            }
            if (d.b()) {
                obj = "1";
            } else {
                obj = "0";
            }
            jSONObject.put("is_harmony_os", obj);
            return;
        } catch (Throwable th) {
            th.printStackTrace();
            return;
        }
        Context context3 = f.f11853a;
        if (a.f5236r) {
            language = f.f11853a.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        }
    }

    public static void addRuntimeHeader(JSONObject jSONObject) {
        try {
            jSONObject.put("access", A4.b.a(A4.b.b(f.f11853a)));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f.f11853a.getSystemService(GuiControlConfig.DEVICE_PHONE);
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static Header b(long j) {
        Header headerA;
        p pVarB = p.b();
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        JSONObject jSONObjectA = pVarB.a(j);
        if (jSONObjectA == null || jSONObjectA.length() == 0) {
            Context context = f.f11853a;
            headerA = a();
            headerA.i();
            try {
                headerA.f11851a.put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            try {
                if (!jSONObjectA.has("aid")) {
                    jSONObjectA.put("aid", 4444);
                }
            } catch (Exception unused2) {
            }
            Context context2 = f.f11853a;
            headerA = new Header();
        }
        f(headerA);
        headerA.d(jSONObjectA);
        return headerA;
    }

    public static boolean e() {
        if (f11849d == -1) {
            f11849d = l().contains("64") ? 1 : 0;
        }
        return f11849d == 1;
    }

    public static void f(Header header) {
        if (header == null) {
            return;
        }
        addOtherHeader(header.f11851a);
    }

    public static boolean g() {
        if (f11850e == -1) {
            f11850e = l().contains("86") ? 1 : 0;
        }
        return f11850e == 1;
    }

    public static boolean h(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return true;
        }
        return (jSONObject.opt(Constants.EXTRA_KEY_APP_VERSION) == null && jSONObject.opt("version_name") == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static String l() {
        if (f11848c == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    int i9 = 0;
                    while (true) {
                        String[] strArr = Build.SUPPORTED_ABIS;
                        if (i9 >= strArr.length) {
                            break;
                        }
                        sb.append(strArr[i9]);
                        if (i9 != strArr.length - 1) {
                            sb.append(", ");
                        }
                        i9++;
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    f11848c = "unknown";
                }
                f11848c = sb.toString();
            } catch (Exception e9) {
                j.m(e9);
                f11848c = "unknown";
            }
        }
        return f11848c;
    }

    public final JSONObject c(Map<String, Object> map) {
        JSONObject jSONObject = this.f11851a;
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!jSONObject.has(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            String[] strArr = f11847b;
            for (int i9 = 0; i9 < 4; i9++) {
                String str = strArr[i9];
                if (map.containsKey(str)) {
                    try {
                        jSONObject.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                    } catch (Throwable unused) {
                        jSONObject.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                try {
                    jSONObject.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
                } catch (Throwable unused2) {
                }
            }
            if (map.containsKey("iid")) {
                jSONObject.put("udid", map.get("iid"));
                jSONObject.remove("iid");
            }
            if (map.containsKey("version_name")) {
                jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, map.get("version_name"));
                jSONObject.remove("version_name");
            }
        } catch (Throwable unused3) {
        }
        return jSONObject;
    }

    public final void d(JSONObject jSONObject) {
        JSONObject jSONObject2 = this.f11851a;
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
        }
    }

    public final void i() {
        c(f.a().b());
    }

    public final void j() {
        try {
            this.f11851a.put("device_id", f.e().a());
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
    }

    public final void k() {
        long userId;
        JSONObject jSONObject = this.f11851a;
        try {
            p049g6.f fVarA = f.a();
            fVarA.getClass();
            try {
                userId = ((ICommonParams) fVarA.f18914b).getUserId();
            } catch (Throwable unused) {
                userId = 0;
            }
            if (userId > 0) {
                jSONObject.put(MTCoreConstants.Register.KEY_USER_ID, userId);
            }
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
    }
}
