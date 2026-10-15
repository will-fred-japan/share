package cn.jiguang.aw;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import cn.jpush.android.service.PushReceiver;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f9475b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f9476c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Boolean f9477d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f9478e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile CertificateFactory f9479f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f9480g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f9481h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f9482i = "";
    private final int j = 600000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f9483k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f9484l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f9485m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f9486n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f9487o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f9488p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Boolean f9489q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Boolean f9490r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f9491s = "";
    private String t = "";

    private a() {
    }

    private static Intent a(PackageManager packageManager, String str) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.INFO");
        intent.setPackage(str);
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveInfoResolveActivity == null) {
            intent.removeCategory("android.intent.category.INFO");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        }
        if (resolveInfoResolveActivity == null) {
            return null;
        }
        Intent intent2 = new Intent(intent);
        intent2.setFlags(268435456);
        ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        return intent2;
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int c(Context context) {
        return cn.jiguang.g.b.y();
    }

    public static String e() {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            cn.jiguang.x.f.c("AndroidUtil", "Cannot read /proc/version, returning default version.");
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                return line;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e9) {
            cn.jiguang.x.f.a("AndroidUtil", "Exception while attempting to read kernel information", e9);
            return property;
        }
    }

    private static CertificateFactory f() {
        if (f9479f == null) {
            synchronized (f9478e) {
                if (f9479f == null) {
                    try {
                        f9479f = CertificateFactory.getInstance("X.509");
                    } catch (Exception e9) {
                        cn.jiguang.x.f.i("AndroidUtil", "Failed to create CertificateFactory: " + e9.getMessage());
                    }
                }
            }
        }
        return f9479f;
    }

    public static String g(Context context) {
        String strK = k(context);
        return !TextUtils.isEmpty(strK) ? W5.e.u(strK, "/data/") : strK;
    }

    public static String h(Context context) {
        Object objInvoke;
        String str = null;
        int iIntValue = -1;
        if (context != null) {
            try {
                Object systemService = context.getApplicationContext().getSystemService("country_detector");
                if (systemService != null) {
                    Method declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0]);
                    if (declaredMethod != null && (objInvoke = declaredMethod.invoke(systemService, new Object[0])) != null) {
                        String str2 = (String) objInvoke.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(objInvoke, new Object[0]);
                        try {
                            iIntValue = ((Integer) objInvoke.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(objInvoke, new Object[0])).intValue();
                            str = str2;
                        } catch (Throwable th) {
                            th = th;
                            str = str2;
                            W5.f.m("getCountryCode failed, error :", "AndroidUtil", th);
                        }
                    }
                } else {
                    cn.jiguang.x.f.c("AndroidUtil", "country_detector is null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        cn.jiguang.x.f.c("AndroidUtil", "get CountCode = " + str + " source = " + iIntValue);
        return (iIntValue == 0 || iIntValue == 1) ? str : "";
    }

    public static String i(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i9 = applicationInfo.labelRes;
            if (i9 != 0) {
                return context.getString(i9);
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            return charSequence != null ? charSequence.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Exception e9) {
            cn.jiguang.x.f.a("AndroidUtil", "Error getting application name.", e9);
            return null;
        }
    }

    @TargetApi(19)
    public static String k(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(f9482i) && !k.a("getExternalSdPath", 30000L)) {
                File externalFilesDir = d.a(context).getExternalFilesDir(null);
                Objects.requireNonNull(externalFilesDir);
                File fileA = a(externalFilesDir);
                if (fileA != null) {
                    f9482i = fileA.getAbsolutePath();
                }
                cn.jiguang.x.f.c("AndroidUtil", "get sd ex path: " + f9482i);
            }
        } catch (Throwable unused) {
        }
        return TextUtils.isEmpty(f9482i) ? "/storage/emulated/0" : f9482i;
    }

    public static String y(Context context) {
        try {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        } catch (Throwable unused) {
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public synchronized String d(Context context, String str) {
        return cn.jiguang.g.b.b(str);
    }

    public String j(Context context) {
        return cn.jiguang.g.b.g();
    }

    public String l(Context context) {
        return c(context, false);
    }

    public boolean m(Context context) {
        return cn.jiguang.g.b.k();
    }

    public String n(Context context) {
        return cn.jiguang.g.b.i();
    }

    public String o(Context context) {
        return cn.jiguang.g.b.h();
    }

    public String p(Context context) {
        return cn.jiguang.g.b.r();
    }

    public String q(Context context) {
        return cn.jiguang.g.b.c();
    }

    public String r(Context context) {
        return cn.jiguang.g.b.b();
    }

    public String s(Context context) {
        return cn.jiguang.g.b.t();
    }

    public String t(Context context) {
        return cn.jiguang.g.b.s();
    }

    public String u(Context context) {
        return cn.jiguang.g.b.q();
    }

    public String v(Context context) {
        return cn.jiguang.g.b.p();
    }

    public String w(Context context) {
        return cn.jiguang.g.b.o();
    }

    public String x(Context context) {
        return cn.jiguang.g.b.n();
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i9;
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.x.f.i("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
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
            PackageInfo packageInfoA = p.a(context, str, i9);
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
                    if (cls.isAssignableFrom(Class.forName(componentInfo.name, false, cls.getClassLoader()))) {
                        return componentInfo;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            cn.jiguang.x.f.j("AndroidUtil", "hasComponent error:" + th);
        }
        return null;
    }

    public static String c() {
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

    public static boolean d() {
        String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    public static boolean e(Context context) {
        String name;
        if (f9477d != null) {
            return f9477d.booleanValue();
        }
        synchronized (f9478e) {
            if (f9477d != null) {
                return f9477d.booleanValue();
            }
            boolean z8 = false;
            try {
                cn.jiguang.x.f.c("AndroidUtil", "isDebug:" + ((context.getApplicationInfo().flags & 2) != 0));
                X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
                String[] strArr = {"CN=Android Debug", "O=Android", "C=US"};
                PackageInfo packageInfoA = p.a(context, 64);
                if (packageInfoA != null) {
                    Signature[] signatureArr = packageInfoA.signatures;
                    CertificateFactory certificateFactoryF = f();
                    if (certificateFactoryF != null) {
                        int length = signatureArr.length;
                        int i9 = 0;
                        boolean zEquals = false;
                        while (true) {
                            if (i9 < length) {
                                try {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signatureArr[i9].toByteArray());
                                    X509Certificate x509Certificate = (X509Certificate) certificateFactoryF.generateCertificate(byteArrayInputStream);
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (Exception unused) {
                                    }
                                    zEquals = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                                    cn.jiguang.x.f.c("AndroidUtil", "debuggable :" + zEquals);
                                    if (!zEquals) {
                                        try {
                                            name = x509Certificate.getSubjectX500Principal().getName();
                                        } catch (Exception unused2) {
                                            name = null;
                                        }
                                        cn.jiguang.x.f.c("AndroidUtil", "certName:" + name);
                                        if (name != null && name.contains(strArr[0]) && name.contains(strArr[1]) && name.contains(strArr[2])) {
                                            z8 = true;
                                            break;
                                        }
                                        i9++;
                                    }
                                } catch (Throwable unused3) {
                                }
                            }
                            z8 = zEquals;
                            break;
                        }
                    } else {
                        f9477d = Boolean.FALSE;
                        return false;
                    }
                }
            } catch (Throwable unused4) {
            }
            f9477d = Boolean.valueOf(z8);
            return z8;
        }
    }

    public static void f(Context context) {
        try {
            if (f9480g != 0) {
                ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(f9480g);
            }
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("[canclePermanentNotification] failed:"), "AndroidUtil");
        }
    }

    public synchronized String b(Context context, boolean z8) {
        return cn.jiguang.g.b.f();
    }

    public static ProviderInfo a(Context context, String str, String str2) {
        ProviderInfo[] providerInfoArr;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                PackageInfo packageInfoA = p.a(context, str, 8);
                if (packageInfoA != null && (providerInfoArr = packageInfoA.providers) != null && providerInfoArr.length != 0) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (str2.equals(providerInfo.authority)) {
                            return providerInfo;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    String str2 = activityInfo.name;
                    if (!TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) == 0)) {
                        arrayList.add(str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static boolean d(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        if (v.a(str)) {
            cn.jiguang.x.f.l("AndroidUtil", "Unexpected: cannot get pk installed path");
            return false;
        }
        cn.jiguang.x.f.c("AndroidUtil", "Current pk installed path: " + str);
        if (str.startsWith("/system/app/")) {
            return true;
        }
        if (str.startsWith("/data/app/")) {
            return false;
        }
        cn.jiguang.x.f.f("AndroidUtil", "NOTE: the pk does not installed in system/data. ");
        return false;
    }

    public static boolean e(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.checkPermission("android.permission.INTERNET", str) == 0) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            if (packageManager.getApplicationInfo(str, 0) != null) {
                return true;
            }
        } catch (Throwable unused2) {
        }
        try {
            return a(packageManager, str) != null;
        } catch (Throwable unused3) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public synchronized String c(Context context, String str) {
        return cn.jiguang.g.b.c(str);
    }

    public static a a() {
        if (f9475b == null) {
            synchronized (a.class) {
                try {
                    if (f9475b == null) {
                        f9475b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9475b;
    }

    public static synchronized void b() {
        f9475b = null;
        a();
    }

    public String c(Context context, boolean z8) {
        return cn.jiguang.g.b.l();
    }

    private static File a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            return !parentFile.getName().equals("0") ? a(parentFile) : parentFile;
        }
        return null;
    }

    public static void b(Context context, Intent intent) {
        try {
            List<String> listB = b(context, intent, (String) null);
            if (listB == null || listB.isEmpty()) {
                cn.jiguang.x.f.j("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str : listB) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str));
                    context.sendBroadcast(intent2);
                } catch (Exception e9) {
                    cn.jiguang.x.f.j("AndroidUtil", "sendBroadcast failed again:" + e9.getMessage() + ", action:" + intent.getAction());
                }
            }
        } catch (Throwable th) {
            cn.jiguang.x.f.j("AndroidUtil", "tryAgainSendBrocast failed:" + th.getMessage());
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f9474a)) {
            return f9474a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                f9474a = processName;
                if (!TextUtils.isEmpty(processName)) {
                    return f9474a;
                }
            }
            f9474a = c();
        } catch (Throwable th) {
            cn.jiguang.x.f.j("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
        }
        return f9474a;
    }

    public static void b(Context context, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) PushReceiver.class);
            intent.setAction(str);
            Bundle bundle = new Bundle();
            bundle.putString("data", str2);
            intent.putExtras(bundle);
            intent.setPackage(context.getPackageName());
            cn.jiguang.x.f.c("AndroidUtil", "send config  intent=" + intent);
            context.sendBroadcast(intent, context.getPackageName() + cn.jiguang.a.a.f8803a);
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, Intent intent, String str) {
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

    public static boolean b(Context context) {
        if (f9476c == null) {
            f9476c = Boolean.valueOf(context.getPackageName().equals(a(context)));
        }
        return f9476c.booleanValue();
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public String a(Context context, String str, boolean z8) {
        return cn.jiguang.g.b.j();
    }

    public synchronized String a(Context context, boolean z8) {
        return cn.jiguang.g.b.e();
    }

    public static void a(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jiguang.x.f.j("AndroidUtil", "send broadcast failed: " + th.getMessage());
            b(context, intent);
        }
    }

    public static void a(Context context, String str, int i9) {
        int i10;
        if (!e(context)) {
            cn.jiguang.x.f.c("AndroidUtil", "not debuggable");
            return;
        }
        cn.jiguang.x.f.c("AndroidUtil", "action:showPermanentNotification");
        Intent intent = new Intent(context, (Class<?>) PushReceiver.class);
        intent.setAction("noti_open_proxy");
        intent.addCategory(context.getPackageName());
        intent.putExtra("debug_notification", true);
        intent.putExtra("toastText", str);
        intent.putExtra("type", i9);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 201326592);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        try {
            i10 = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0).icon;
        } catch (Throwable th) {
            cn.jiguang.x.f.e("AndroidUtil", "failed to get application info and icon.", th);
            i10 = R.drawable.ic_menu_share;
        }
        Notification.Builder when = new Notification.Builder(context.getApplicationContext()).setContentTitle("Jiguang提示：包名和AppKey不匹配").setContentText("请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段").setContentIntent(broadcast).setSmallIcon(i10).setTicker(str).setWhen(System.currentTimeMillis());
        if (notificationManager.getNotificationChannel("JPush_Notification") == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("JPush_Notification", "JPush_Notification", 3));
        }
        when.setChannelId("JPush_Notification");
        Notification notification = when.getNotification();
        notification.flags = 34;
        f9480g = 10000;
        notificationManager.notify(10000, notification);
    }
}
