package com.vivo.push.util;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: PushPackageUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f16824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f16825b;

    public static com.vivo.push.model.a a(Context context, com.vivo.push.restructure.b.b bVar) {
        com.vivo.push.model.a aVarE;
        com.vivo.push.model.a aVarE2;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.a aVarC = c(applicationContext);
        if (aVarC != null) {
            w.d("PushPackageUtils", "get system push info :".concat(String.valueOf(aVarC)));
            return aVarC;
        }
        List<String> listA = bVar.a(applicationContext);
        com.vivo.push.model.a aVarE3 = e(applicationContext, applicationContext.getPackageName());
        if (listA == null || listA.size() <= 0) {
            if (aVarE3 != null && aVarE3.d()) {
                aVarC = aVarE3;
            }
            w.a("PushPackageUtils", "findAllPushPackages error: find no package!");
            aVarE3 = aVarC;
        } else {
            com.vivo.push.model.a aVar = null;
            String strA = ai.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(strA) || !a(applicationContext, strA, "com.vivo.pushservice.action.METHOD") || (aVarE = e(applicationContext, strA)) == null || !aVarE.d()) {
                aVarE = null;
            }
            if (aVarE3 == null || !aVarE3.d()) {
                aVarE3 = null;
            }
            if (aVarE == null) {
                aVarE = null;
            }
            if (aVarE3 == null || (aVarE != null && (!aVarE3.c() ? !(aVarE.c() || aVarE3.b() > aVarE.b()) : !(aVarE.c() && aVarE3.b() > aVarE.b())))) {
                aVarE3 = aVarE;
            }
            HashMap map = new HashMap();
            if (aVarE3 == null) {
                aVarE3 = null;
            } else if (aVarE3.c()) {
                aVar = aVarE3;
                aVarE3 = null;
            }
            int size = listA.size();
            for (int i9 = 0; i9 < size; i9++) {
                String str = listA.get(i9);
                if (!TextUtils.isEmpty(str) && (aVarE2 = e(applicationContext, str)) != null) {
                    map.put(str, aVarE2);
                    if (aVarE2.d()) {
                        if (aVarE2.c()) {
                            if (aVar == null || aVarE2.b() > aVar.b()) {
                                aVar = aVarE2;
                            }
                        } else if (aVarE3 == null || aVarE2.b() > aVarE3.b()) {
                            aVarE3 = aVarE2;
                        }
                    }
                }
            }
            if (aVarE3 == null) {
                w.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                aVarE3 = aVar;
            }
        }
        if (aVarE3 == null) {
            w.b("查找最优包为空!");
            w.d("PushPackageUtils", "finSuitablePushPackage is null");
            return aVarE3;
        }
        if (aVarE3.c()) {
            w.a("查找最优包为:" + aVarE3.a() + "(" + aVarE3.b() + ", Black)");
            w.d("PushPackageUtils", "finSuitablePushPackage" + aVarE3.a() + "(" + aVarE3.b() + ", Black)");
            return aVarE3;
        }
        w.a("查找最优包为:" + aVarE3.a() + "(" + aVarE3.b() + ")");
        w.d("PushPackageUtils", "finSuitablePushPackage" + aVarE3.a() + "(" + aVarE3.b() + ")");
        return aVarE3;
    }

    public static boolean b(Context context) {
        ProviderInfo providerInfoResolveContentProvider;
        Boolean bool = f16824a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = providerInfoResolveContentProvider.packageName;
        }
        boolean zEquals = "BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(f(context, str));
        f16824a = Boolean.valueOf(zEquals);
        return zEquals;
    }

    private static com.vivo.push.model.a c(Context context) {
        String strA = a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        com.vivo.push.model.a aVar = new com.vivo.push.model.a(strA);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strA, 128);
            if (packageInfo != null) {
                aVar.a(packageInfo.versionCode);
                aVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                aVar.a(ak.a(context, strA));
            }
            aVar.a(a(context, strA));
            return aVar;
        } catch (Exception e9) {
            e9.printStackTrace();
            w.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e9);
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    private static com.vivo.push.model.a e(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str) && (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE"))) {
            com.vivo.push.model.a aVar = new com.vivo.push.model.a(str);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                if (packageInfo != null) {
                    aVar.a(packageInfo.versionCode);
                    aVar.a(packageInfo.versionName);
                    applicationInfo = packageInfo.applicationInfo;
                } else {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    aVar.a(ak.a(context, str));
                }
                aVar.a(a(context, str));
                return aVar;
            } catch (Exception e9) {
                w.a("PushPackageUtils", "getPushPackageInfo exception: ", e9);
            }
        }
        return null;
    }

    private static String f(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b9 : bArrDigest) {
                    String upperCase = Integer.toHexString(b9 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e9) {
                w.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e9)));
            }
        }
        return null;
    }

    public static int b(Context context, String str) {
        int i9 = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i9;
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    /* JADX WARN: Code duplicated, block: B:102:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0056 A[Catch: all -> 0x0049, Exception -> 0x004e, TRY_LEAVE, TryCatch #1 {Exception -> 0x004e, blocks: (B:18:0x003c, B:25:0x0056), top: B:93:0x003c }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0064 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0066 A[Catch: Exception -> 0x0061, TRY_LEAVE, TryCatch #12 {Exception -> 0x0061, blocks: (B:27:0x005d, B:31:0x0066), top: B:104:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0076 A[Catch: all -> 0x0049, Exception -> 0x0092, TRY_LEAVE, TryCatch #4 {all -> 0x0049, blocks: (B:18:0x003c, B:25:0x0056, B:36:0x0070, B:38:0x0076, B:41:0x0089, B:44:0x0095, B:46:0x00a5, B:47:0x00b2), top: B:93:0x003c }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00bf A[Catch: Exception -> 0x00c3, TRY_LEAVE, TryCatch #11 {Exception -> 0x00c3, blocks: (B:49:0x00ba, B:51:0x00bf), top: B:102:0x00ba }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d0 A[Catch: Exception -> 0x00d4, TRY_LEAVE, TryCatch #6 {Exception -> 0x00d4, blocks: (B:57:0x00cb, B:59:0x00d0), top: B:97:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00da A[Catch: Exception -> 0x00e3, TRY_ENTER, TryCatch #10 {Exception -> 0x00e3, blocks: (B:64:0x00da, B:66:0x00df, B:76:0x00f8, B:78:0x00fd), top: B:101:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00df A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #10 {Exception -> 0x00e3, blocks: (B:64:0x00da, B:66:0x00df, B:76:0x00f8, B:78:0x00fd), top: B:101:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x00f8 A[Catch: Exception -> 0x00e3, TRY_ENTER, TryCatch #10 {Exception -> 0x00e3, blocks: (B:64:0x00da, B:66:0x00df, B:76:0x00f8, B:78:0x00fd), top: B:101:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x00fd A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #10 {Exception -> 0x00e3, blocks: (B:64:0x00da, B:66:0x00df, B:76:0x00f8, B:78:0x00fd), top: B:101:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x010e A[Catch: Exception -> 0x010a, TRY_LEAVE, TryCatch #3 {Exception -> 0x010a, blocks: (B:83:0x0106, B:87:0x010e), top: B:95:0x0106 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(Context context) {
        Throwable th;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Exception exc;
        String string;
        Throwable th2;
        Cursor cursorQuery;
        boolean z8;
        if (!TextUtils.isEmpty(f16825b)) {
            return f16825b;
        }
        Cursor cursor = null;
        try {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = com.vivo.push.y.f16910a;
                contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        w.a("PushPackageUtils", "client is null");
                        cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, null, null);
                    } catch (Exception e9) {
                        contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        exc = e9;
                        string = null;
                        try {
                            w.a("PushPackageUtils", "getSystemPush", exc);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                            return string;
                        } catch (Throwable th3) {
                            th2 = th3;
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e10) {
                                    w.a("PushPackageUtils", "close", e10);
                                    throw th;
                                }
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    cursorQuery = null;
                }
                if (cursorQuery == null) {
                    try {
                        try {
                            cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                            if (cursorQuery == null) {
                                w.a("PushPackageUtils", "cursor is null");
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                        if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                            contentProviderClientAcquireUnstableContentProviderClient.close();
                                        }
                                    } catch (Exception e11) {
                                        w.a("PushPackageUtils", "close", e11);
                                    }
                                } else if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                    contentProviderClientAcquireUnstableContentProviderClient.close();
                                }
                                return null;
                            }
                            z8 = false;
                            string = null;
                            while (cursorQuery.moveToNext()) {
                                try {
                                    if ("pushPkgName".equals(cursorQuery.getString(cursorQuery.getColumnIndex(MTCommonConstants.Network.KEY_NAME)))) {
                                        string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                                    } else if ("pushEnable".equals(cursorQuery.getString(cursorQuery.getColumnIndex(MTCommonConstants.Network.KEY_NAME)))) {
                                        z8 = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex("value")));
                                    }
                                } catch (Exception e12) {
                                    exc = e12;
                                    cursor = cursorQuery;
                                    w.a("PushPackageUtils", "getSystemPush", exc);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                        contentProviderClientAcquireUnstableContentProviderClient.close();
                                    }
                                }
                            }
                            f16825b = string;
                            if (TextUtils.isEmpty(string)) {
                                try {
                                    cursorQuery.close();
                                    if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                        contentProviderClientAcquireUnstableContentProviderClient.close();
                                    }
                                } catch (Exception e13) {
                                    w.a("PushPackageUtils", "close", e13);
                                }
                                return null;
                            }
                            if (!z8) {
                                try {
                                    cursorQuery.close();
                                    if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                        contentProviderClientAcquireUnstableContentProviderClient.close();
                                    }
                                } catch (Exception e14) {
                                    w.a("PushPackageUtils", "close", e14);
                                }
                                return null;
                            }
                            cursorQuery.close();
                            if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                        } catch (Exception e15) {
                            exc = e15;
                            string = null;
                            cursor = cursorQuery;
                            w.a("PushPackageUtils", "getSystemPush", exc);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                            return string;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    if (cursorQuery == null) {
                        w.a("PushPackageUtils", "cursor is null");
                        if (cursorQuery != null) {
                            cursorQuery.close();
                            if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                        } else if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                        return null;
                    }
                    z8 = false;
                    string = null;
                    while (cursorQuery.moveToNext()) {
                        if ("pushPkgName".equals(cursorQuery.getString(cursorQuery.getColumnIndex(MTCommonConstants.Network.KEY_NAME)))) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        } else if ("pushEnable".equals(cursorQuery.getString(cursorQuery.getColumnIndex(MTCommonConstants.Network.KEY_NAME)))) {
                            z8 = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex("value")));
                        }
                    }
                    f16825b = string;
                    if (TextUtils.isEmpty(string)) {
                        cursorQuery.close();
                        if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                        return null;
                    }
                    if (!z8) {
                        cursorQuery.close();
                        if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                        return null;
                    }
                    cursorQuery.close();
                    if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                }
            } catch (Exception e16) {
                w.a("PushPackageUtils", "close", e16);
            }
        } catch (Exception e17) {
            exc = e17;
            string = null;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th6) {
            th = th6;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
        return string;
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                int size = listQueryIntentServices.size();
                boolean z8 = false;
                for (int i9 = 0; i9 < size; i9++) {
                    ResolveInfo resolveInfo = listQueryIntentServices.get(i9);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z9 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z9) {
                            boolean z10 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z8 = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z10);
                        }
                    }
                }
                return z8;
            }
            w.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            listQueryBroadcastReceivers = null;
        }
        return listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0;
    }
}
