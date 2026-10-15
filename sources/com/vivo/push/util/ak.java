package com.vivo.push.util;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.push.AttributionReporter;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Utility.java */
/* JADX INFO: loaded from: classes.dex */
public final class ak {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f16842b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f16841a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String[] f16843c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String[] f16844d = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f16845e = new String[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, Bundle> f16846f = new ConcurrentHashMap();

    public static long a(Context context) {
        String strA = ad.a(context);
        if (!TextUtils.isEmpty(strA)) {
            return a(context, strA);
        }
        w.a("Utility", "systemPushPkgName is null");
        return -1L;
    }

    public static String b(Context context, String str) {
        Object objA = a(context, str, "verification_status");
        return objA != null ? objA.toString() : "";
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004d A[Catch: Exception -> 0x0050, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:23:0x0048, B:25:0x004d), top: B:61:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a4 A[Catch: Exception -> 0x00ac, TRY_ENTER, TryCatch #3 {Exception -> 0x00ac, blocks: (B:36:0x008e, B:38:0x0093, B:46:0x00a4, B:48:0x00a9), top: B:65:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9 A[Catch: Exception -> 0x00ac, TRY_LEAVE, TryCatch #3 {Exception -> 0x00ac, blocks: (B:36:0x008e, B:38:0x0093, B:46:0x00a4, B:48:0x00a9), top: B:65:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00b8 A[Catch: Exception -> 0x00bb, TRY_LEAVE, TryCatch #4 {Exception -> 0x00bb, blocks: (B:53:0x00b3, B:55:0x00b8), top: B:66:0x00b3 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[SYNTHETIC] */
    public static PublicKey c(Context context) throws Throwable {
        Throwable th;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Exception exc;
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = com.vivo.push.y.f16910a;
                contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        w.a("Utility", "client is null");
                        cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, null, null);
                    } catch (Exception e9) {
                        exc = e9;
                        cursorQuery = null;
                        try {
                            exc.printStackTrace();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                                throw th;
                            }
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        th = th3;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                            throw th;
                        }
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                        throw th;
                    }
                } else {
                    cursorQuery = null;
                }
                if (cursorQuery == null) {
                    try {
                        cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                    } catch (Exception e10) {
                        exc = e10;
                        contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        exc.printStackTrace();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                            throw th;
                        }
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                        throw th;
                    }
                }
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                            if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                        } catch (Exception unused2) {
                        }
                    } else if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return null;
                }
                while (cursorQuery.moveToNext()) {
                    if ("pushkey".equals(cursorQuery.getString(cursorQuery.getColumnIndex(MTCommonConstants.Network.KEY_NAME)))) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        w.d("Utility", "result key : ".concat(String.valueOf(string)));
                        PublicKey publicKeyA = ae.a(string);
                        try {
                            cursorQuery.close();
                            if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                        } catch (Exception unused3) {
                        }
                        return publicKeyA;
                    }
                }
                cursorQuery.close();
                if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                return null;
            } catch (Exception unused4) {
            }
        } catch (Exception e11) {
            exc = e11;
            contentProviderClientAcquireUnstableContentProviderClient = null;
            cursorQuery = null;
        } catch (Throwable th5) {
            th = th5;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0084 A[Catch: Exception -> 0x007f, TRY_LEAVE, TryCatch #2 {Exception -> 0x007f, blocks: (B:31:0x007b, B:35:0x0084), top: B:73:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00c5 A[Catch: Exception -> 0x00b8, TRY_ENTER, TryCatch #4 {Exception -> 0x00b8, blocks: (B:51:0x00af, B:53:0x00b4, B:59:0x00c5, B:61:0x00ca), top: B:77:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ca A[Catch: Exception -> 0x00b8, TRY_LEAVE, TryCatch #4 {Exception -> 0x00b8, blocks: (B:51:0x00af, B:53:0x00b4, B:59:0x00c5, B:61:0x00ca), top: B:77:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d8 A[Catch: Exception -> 0x00d4, TRY_LEAVE, TryCatch #6 {Exception -> 0x00d4, blocks: (B:64:0x00d0, B:68:0x00d8), top: B:78:0x00d0 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:? A[SYNTHETIC] */
    public static boolean d(Context context) throws Throwable {
        Throwable th;
        ContentProviderClient contentProviderClient;
        Exception exc;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Cursor cursorQuery = null;
        try {
            try {
                try {
                    if (context == null) {
                        w.a("Utility", "context is null");
                        return false;
                    }
                    String packageName = context.getPackageName();
                    int i9 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uri = com.vivo.push.y.f16911b;
                    contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            w.a("Utility", "client is null");
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"363", packageName, String.valueOf(i9)}, null);
                        } catch (Exception e9) {
                            e = e9;
                            contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                            exc = e;
                            w.a("Utility", "isSupport", exc);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                            th = th;
                            if (0 != 0) {
                                try {
                                    cursorQuery.close();
                                } catch (Exception e10) {
                                    w.a("Utility", "close", e10);
                                    throw th;
                                }
                            }
                            if (contentProviderClient != null) {
                                throw th;
                            }
                            contentProviderClient.close();
                            throw th;
                        }
                    }
                    if (cursorQuery == null) {
                        try {
                            cursorQuery = context.getContentResolver().query(uri, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"363", packageName, String.valueOf(i9)}, null);
                        } catch (Exception e11) {
                            e = e11;
                            exc = e;
                            w.a("Utility", "isSupport", exc);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                        }
                    }
                    if (cursorQuery == null) {
                        w.a("Utility", "cursor is null");
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                                if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                    contentProviderClientAcquireUnstableContentProviderClient.close();
                                }
                            } catch (Exception e12) {
                                w.a("Utility", "close", e12);
                            }
                        } else if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                        return false;
                    }
                    if (!cursorQuery.moveToFirst() || (cursorQuery.getInt(cursorQuery.getColumnIndex(AttributionReporter.SYSTEM_PERMISSION)) & 1) == 0) {
                        cursorQuery.close();
                        if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                        return false;
                    }
                    try {
                        cursorQuery.close();
                        if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                    } catch (Exception e13) {
                        w.a("Utility", "close", e13);
                    }
                    return true;
                } catch (Exception e14) {
                    w.a("Utility", "close", e14);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e15) {
            exc = e15;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th4) {
            th = th4;
            contentProviderClient = null;
            if (0 != 0) {
                cursorQuery.close();
            }
            if (contentProviderClient != null) {
                throw th;
            }
            contentProviderClient.close();
            throw th;
        }
    }

    public static void b(Context context) throws VivoPushException {
        String string;
        int i9;
        w.d("Utility", "check PushService AndroidManifest declearation !");
        String strA = ad.a(context);
        boolean zD = ad.d(context, context.getPackageName());
        boolean zC = ad.c(context, context.getPackageName());
        if (!zC && !zD) {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        }
        if (zC) {
            f16843c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
        } else {
            f16843c = new String[]{"com.vivo.push.sdk.service.CommandService"};
        }
        f16844d = new String[0];
        f16841a = new String[0];
        if (zD) {
            f16842b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
        } else {
            f16842b = new String[]{"android.permission.INTERNET"};
        }
        if (zD) {
            long jA = a(context, context.getPackageName());
            long j = context.getPackageName().equals(strA) ? 1363L : 363L;
            if (jA == -1) {
                throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
            }
            if (jA != j) {
                throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:".concat(String.valueOf(j)));
            }
        }
        String[] strArr = f16842b;
        if (strArr != null && strArr.length > 0) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    String[] strArr2 = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                    if (strArr2 == null) {
                        throw new VivoPushException("Permissions is null!");
                    }
                    for (String str : strArr) {
                        int length = strArr2.length;
                        while (true) {
                            if (i9 < length) {
                                i9 = str.equals(strArr2[i9]) ? 0 : i9 + 1;
                            } else {
                                throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr2));
                            }
                        }
                    }
                } else {
                    throw new VivoPushException("localPackageManager is null");
                }
            } catch (Exception e9) {
                throw new VivoPushException(e9.getMessage());
            }
        } else {
            w.c("Utility", "checkPermissions sPermissions is empty");
        }
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
                if (activityInfoArr != null) {
                    for (String str2 : f16844d) {
                        a(str2, activityInfoArr, strA);
                    }
                    try {
                        if (context.getPackageManager() != null) {
                            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                            if (serviceInfoArr != null) {
                                for (String str3 : f16843c) {
                                    a(str3, serviceInfoArr, strA);
                                }
                                if (f16845e.length > 0) {
                                    try {
                                        if (context.getPackageManager() != null) {
                                            ActivityInfo[] activityInfoArr2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                                            if (activityInfoArr2 != null) {
                                                for (String str4 : f16845e) {
                                                    a(str4, activityInfoArr2, strA);
                                                }
                                            } else {
                                                throw new VivoPushException("activityInfos is null");
                                            }
                                        } else {
                                            throw new VivoPushException("localPackageManager is null");
                                        }
                                    } catch (Exception e10) {
                                        throw new VivoPushException(A.f.h(e10, new StringBuilder("error ")));
                                    }
                                }
                                try {
                                    if (a(context, context.getPackageName(), "local_iv") != null) {
                                        String packageName = context.getPackageName();
                                        Object objA = a(context, packageName, "com.vivo.push.api_key");
                                        String string2 = "";
                                        if (objA != null) {
                                            string = objA.toString();
                                        } else {
                                            Object objA2 = a(context, packageName, "api_key");
                                            if (objA2 == null) {
                                                string = "";
                                            } else {
                                                string = objA2.toString();
                                            }
                                        }
                                        if (!TextUtils.isEmpty(string)) {
                                            String packageName2 = context.getPackageName();
                                            Object objA3 = a(context, packageName2, "com.vivo.push.app_id");
                                            if (objA3 != null) {
                                                string2 = objA3.toString();
                                            } else {
                                                Object objA4 = a(context, packageName2, "app_id");
                                                if (objA4 != null) {
                                                    string2 = objA4.toString();
                                                }
                                            }
                                            if (TextUtils.isEmpty(string2)) {
                                                throw new VivoPushException("com.vivo.push.app_id is null");
                                            }
                                            if (zD && a(context, context.getPackageName()) == -1) {
                                                throw new VivoPushException("sdkversion is null");
                                            }
                                            return;
                                        }
                                        throw new VivoPushException("com.vivo.push.api_key is null");
                                    }
                                    throw new VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
                                } catch (Exception e11) {
                                    throw new VivoPushException(A.f.h(e11, new StringBuilder("getMetaValue error ")));
                                }
                            }
                            throw new VivoPushException("serviceInfos is null");
                        }
                        throw new VivoPushException("localPackageManager is null");
                    } catch (Exception e12) {
                        throw new VivoPushException(A.f.h(e12, new StringBuilder("error ")));
                    }
                }
                throw new VivoPushException("receivers is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e13) {
            throw new VivoPushException(e13.getMessage());
        }
    }

    public static long a(Context context, String str) {
        Object objA = a(context, str, "com.vivo.push.sdk_version");
        if (objA == null) {
            objA = a(context, str, HianalyticsBaseData.SDK_VERSION);
        }
        if (objA == null) {
            w.a("Utility", "getSdkVersionCode sdk version is null");
            return -1L;
        }
        try {
            return Long.parseLong(objA.toString());
        } catch (Exception e9) {
            e9.printStackTrace();
            w.a("Utility", "getSdkVersionCode error ", e9);
            return -1L;
        }
    }

    public static Object a(Context context, String str, String str2) {
        Bundle bundle;
        Bundle bundle2 = null;
        if (context != null && str2 != null && !TextUtils.isEmpty(str)) {
            try {
                Map<String, Bundle> map = f16846f;
                Object obj = (map == null || map.size() <= 0 || (bundle = f16846f.get(str)) == null) ? null : bundle.get(str2);
                if (obj != null) {
                    return obj;
                }
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                    bundle2 = applicationInfo != null ? applicationInfo.metaData : null;
                    Object obj2 = bundle2 != null ? bundle2.get(str2) : obj;
                    try {
                        if (f16846f.size() > 300) {
                            return obj2;
                        }
                        f16846f.put(str, bundle2);
                        return obj2;
                    } catch (Exception e9) {
                        bundle2 = obj2;
                        e = e9;
                        w.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                        return bundle2;
                    }
                } catch (Exception e10) {
                    e = e10;
                    bundle2 = obj;
                }
            } catch (Exception e11) {
                e = e11;
            }
        }
        return bundle2;
    }

    public static Object a(String str, String str2) throws ClassNotFoundException {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    public static int c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int iA = (int) a(context, str);
            return iA <= 0 ? d(context, str) : iA;
        }
        w.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(A.a.j(new StringBuilder(), componentInfo.name, " module Push-SDK need is illegitmacy !"));
            }
        }
        throw new VivoPushException(W5.e.u(str, " module Push-SDK need is not exist"));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static int d(Context context, String str) {
        String string;
        int iIntValue;
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            w.a("Utility", "getClientSdkVersion() error, context is null or pkgName is empty");
            return 0;
        }
        Object objA = a(context, str, "sdk_version_vivo");
        if (objA instanceof String) {
            string = (String) objA;
        } else {
            if (!(objA instanceof Integer)) {
                if (objA != null) {
                    string = objA.toString();
                }
                return 0;
            }
            iIntValue = ((Integer) objA).intValue();
            str2 = "";
            if (iIntValue > 0) {
                return iIntValue;
            }
            try {
                return Integer.parseInt(str2);
            } catch (Exception e9) {
                w.a("Utility", "getClientSdkVersion: ".concat(String.valueOf(e9)));
            }
        }
        str2 = string;
        iIntValue = 0;
        if (iIntValue > 0) {
            return iIntValue;
        }
        return Integer.parseInt(str2);
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f16841a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                StringBuilder sb = new StringBuilder("module : ");
                sb.append(componentInfo.name);
                sb.append(" process :");
                throw new VivoPushException(A.a.j(sb, componentInfo.processName, "  check process fail"));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0074 A[Catch: Exception -> 0x006f, TRY_LEAVE, TryCatch #2 {Exception -> 0x006f, blocks: (B:30:0x006b, B:34:0x0074), top: B:70:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b5 A[Catch: Exception -> 0x00a8, TRY_ENTER, TryCatch #4 {Exception -> 0x00a8, blocks: (B:48:0x009f, B:50:0x00a4, B:56:0x00b5, B:58:0x00ba), top: B:74:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ba A[Catch: Exception -> 0x00a8, TRY_LEAVE, TryCatch #4 {Exception -> 0x00a8, blocks: (B:48:0x009f, B:50:0x00a4, B:56:0x00b5, B:58:0x00ba), top: B:74:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00c9 A[Catch: Exception -> 0x00c4, TRY_LEAVE, TryCatch #6 {Exception -> 0x00c4, blocks: (B:61:0x00c0, B:65:0x00c9), top: B:75:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:? A[SYNTHETIC] */
    public static boolean a(Context context, String str, String str2, long j) throws Throwable {
        Throwable th;
        ContentProviderClient contentProviderClient;
        Exception exc;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Cursor cursorQuery = null;
        try {
            try {
                try {
                    if (context == null) {
                        w.a("Utility", "context is null");
                        return false;
                    }
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uri = com.vivo.push.y.f16912c;
                    contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            w.a("Utility", "client is null");
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j)}, null);
                        } catch (Exception e9) {
                            e = e9;
                            contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                            exc = e;
                            w.a("Utility", "isOverdue", exc);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                            th = th;
                            if (0 != 0) {
                                try {
                                    cursorQuery.close();
                                } catch (Exception e10) {
                                    w.a("Utility", "close", e10);
                                    throw th;
                                }
                            }
                            if (contentProviderClient != null) {
                                contentProviderClient.close();
                                throw th;
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery == null) {
                        try {
                            cursorQuery = context.getContentResolver().query(uri, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j)}, null);
                        } catch (Exception e11) {
                            e = e11;
                            exc = e;
                            w.a("Utility", "isOverdue", exc);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                        }
                    }
                    if (cursorQuery == null) {
                        w.a("Utility", "cursor is null");
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                                if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                    contentProviderClientAcquireUnstableContentProviderClient.close();
                                }
                            } catch (Exception e12) {
                                w.a("Utility", "close", e12);
                            }
                        } else if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                        return false;
                    }
                    if (cursorQuery.moveToFirst()) {
                        boolean z8 = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex("clientState")));
                        try {
                            cursorQuery.close();
                            if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                                return z8;
                            }
                        } catch (Exception e13) {
                            w.a("Utility", "close", e13);
                        }
                        return z8;
                    }
                    cursorQuery.close();
                    if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return false;
                } catch (Exception e14) {
                    w.a("Utility", "close", e14);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e15) {
            exc = e15;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th4) {
            th = th4;
            contentProviderClient = null;
            if (0 != 0) {
                cursorQuery.close();
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
                throw th;
            }
            throw th;
        }
    }

    public static boolean a(Context context, String str, boolean z8) {
        Cursor cursor = null;
        try {
            try {
                try {
                    Cursor cursorA = a(com.vivo.push.y.f16914e, "appPkgName = ? and agreePrivacyStatement = ? ", new String[]{str, z8 ? "1" : "0"}, context);
                    if (cursorA == null) {
                        w.a("Utility", "cursor is null");
                        if (cursorA != null) {
                            try {
                                cursorA.close();
                            } catch (Exception e9) {
                                w.a("Utility", "close", e9);
                            }
                        }
                        return false;
                    }
                    if (cursorA.moveToFirst()) {
                        boolean z9 = Boolean.parseBoolean(cursorA.getString(cursorA.getColumnIndex("agreePrivacyStatement")));
                        try {
                            cursorA.close();
                            return z9;
                        } catch (Exception e10) {
                            w.a("Utility", "close", e10);
                            return z9;
                        }
                    }
                    cursorA.close();
                    return false;
                } catch (Exception e11) {
                    w.a("Utility", "close", e11);
                }
            } catch (Exception e12) {
                w.a("Utility", "syncAgreePrivacyStatement", e12);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e13) {
                    w.a("Utility", "close", e13);
                }
            }
            throw th;
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e9) {
            e9.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:? A[SYNTHETIC] */
    private static Cursor a(Uri uri, String str, String[] strArr, Context context) throws Throwable {
        Throwable th;
        Exception exc;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Uri uri2;
        String str2;
        String[] strArr2;
        Cursor cursorQuery;
        ContentProviderClient contentProviderClient = null;
        try {
            if (context == null) {
                w.a("Utility", "context is null");
                return null;
            }
            contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    try {
                        w.a("Utility", "client is null");
                        uri2 = uri;
                        str2 = str;
                        strArr2 = strArr;
                        cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri2, null, str2, strArr2, null);
                    } catch (Exception e9) {
                        exc = e9;
                        w.a("Utility", "queryContentResolver", exc);
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            try {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            } catch (Exception e10) {
                                w.a("Utility", "close", e10);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    if (contentProviderClient != null) {
                        try {
                            contentProviderClient.close();
                            throw th;
                        } catch (Exception e11) {
                            w.a("Utility", "close", e11);
                            throw th;
                        }
                    }
                    throw th;
                }
            } else {
                uri2 = uri;
                str2 = str;
                strArr2 = strArr;
                cursorQuery = null;
            }
            if (cursorQuery == null) {
                cursorQuery = context.getContentResolver().query(uri2, null, str2, strArr2, null);
            }
            if (cursorQuery == null) {
                w.a("Utility", "cursor is null");
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } catch (Exception e12) {
                        w.a("Utility", "close", e12);
                    }
                }
                return null;
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                    return cursorQuery;
                } catch (Exception e13) {
                    w.a("Utility", "close", e13);
                }
            }
            return cursorQuery;
        } catch (Exception e14) {
            exc = e14;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            if (contentProviderClient != null) {
                contentProviderClient.close();
                throw th;
            }
            throw th;
        }
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }
}
