package cn.jiguang.v;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.JCommonService;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f10816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10817c;

    private static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i9;
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.u.b.e("JDyAndroidUtils", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            if (Service.class.isAssignableFrom(cls)) {
                i9 = 4;
            } else if (BroadcastReceiver.class.isAssignableFrom(cls)) {
                i9 = 2;
            } else if (Activity.class.isAssignableFrom(cls)) {
                i9 = 1;
            } else {
                i9 = ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            }
            PackageInfo packageInfoA = f.a(context, str, Integer.valueOf(i9));
            if (packageInfoA == null) {
                return null;
            }
            if (i9 == 1) {
                componentInfoArr = packageInfoA.activities;
            } else if (i9 == 2) {
                componentInfoArr = packageInfoA.receivers;
            } else if (i9 != 4) {
                componentInfoArr = i9 != 8 ? null : packageInfoA.providers;
            } else {
                componentInfoArr = packageInfoA.services;
            }
            if (componentInfoArr == null) {
                return null;
            }
            for (ComponentInfo componentInfo : componentInfoArr) {
                try {
                    if (cls.isAssignableFrom(Class.forName(componentInfo.name))) {
                        return componentInfo;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            cn.jiguang.u.b.f("JDyAndroidUtils", "hasComponent error:" + th);
        }
        return null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return strA.equals(c(context));
    }

    public static String c(Context context) {
        StringBuilder sb;
        String str = f10817c;
        if (str != null) {
            return str;
        }
        String strD = d(context);
        if (TextUtils.isEmpty(strD)) {
            f10817c = context.getPackageName();
            sb = new StringBuilder("user serviceProcess is curProcessName:");
        } else {
            f10817c = a(context, strD);
            sb = new StringBuilder("user serviceProcess is:");
        }
        sb.append(f10817c);
        cn.jiguang.u.b.b("JDyAndroidUtils", sb.toString());
        return f10817c;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009b  */
    private static String d(Context context) {
        Class<JCommonService> cls;
        Object th;
        ComponentInfo componentInfoA;
        try {
            String str = f10816b;
            if (str != null) {
                return str;
            }
            cls = JCommonService.class;
            int i9 = JCommonService.f11554a;
            try {
                Intent intent = new Intent();
                intent.setAction(JConstants.USER_SERVICE_ACTION);
                intent.setPackage(context.getPackageName());
                String strA = a(context, intent, "");
                if (!TextUtils.isEmpty(strA) && cls.isAssignableFrom(Class.forName(strA))) {
                    f10816b = strA;
                    cn.jiguang.u.b.d("JDyAndroidUtils", "found userServiceClass :" + f10816b + " by getCommonServiceNames");
                }
            } catch (Throwable th2) {
                th = th2;
                cn.jiguang.u.b.b("JDyAndroidUtils", "getUserServiceClass failed:" + th);
            }
            if (TextUtils.isEmpty(f10816b) && (componentInfoA = a(context, context.getPackageName(), cls)) != null) {
                f10816b = componentInfoA.name;
                cn.jiguang.u.b.d("JDyAndroidUtils", "found userServiceClass :" + f10816b + " by getComponentInfo");
            }
            if (TextUtils.isEmpty(f10816b)) {
                f10816b = "";
            }
            return f10816b;
        } catch (Throwable th3) {
            cls = null;
            th = th3;
        }
        cn.jiguang.u.b.b("JDyAndroidUtils", "getUserServiceClass failed:" + th);
        if (TextUtils.isEmpty(f10816b)) {
            f10816b = componentInfoA.name;
            cn.jiguang.u.b.d("JDyAndroidUtils", "found userServiceClass :" + f10816b + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(f10816b)) {
            f10816b = "";
        }
        return f10816b;
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                byte[] bArr = new byte[256];
                while (true) {
                    int i9 = fileInputStream.read(bArr);
                    if (i9 <= 0) {
                        fileInputStream.close();
                        return sb.toString();
                    }
                    for (int i10 = 0; i10 < i9; i10++) {
                        byte b9 = bArr[i10];
                        if (b9 == 0) {
                            break;
                        }
                        sb.append((char) b9);
                    }
                    return "";
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f10815a)) {
            return f10815a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                f10815a = processName;
                if (!TextUtils.isEmpty(processName)) {
                    return f10815a;
                }
            }
            f10815a = a();
        } catch (Throwable th) {
            cn.jiguang.u.b.f("JDyAndroidUtils", "#unexcepted - getCurProcessName failed:" + th.getMessage());
        }
        return f10815a;
    }

    private static String a(Context context, Intent intent, String str) {
        try {
            ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            ServiceInfo serviceInfo = resolveInfoResolveService.serviceInfo;
            if (serviceInfo == null) {
                return "";
            }
            String str2 = serviceInfo.name;
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            return (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfoResolveService.activityInfo.packageName) == 0) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }
}
