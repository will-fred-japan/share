package cn.jiguang.commons.a;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.BundleUtil;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class kg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Object f10354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, PackageInfo> f10355b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f10356c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f10357d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReference<Integer> f10358e = new AtomicReference<>(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f10359f = "";

    private static int a(ApplicationInfo applicationInfo, boolean z8) {
        if (applicationInfo == null) {
            return -1;
        }
        try {
            int i9 = applicationInfo.flags;
            if ((i9 & 1) != 0) {
                return (i9 & 128) != 0 ? 2 : 1;
            }
            String str = z8 ? applicationInfo.sourceDir : null;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return (str.startsWith("/system/") || str.startsWith("/vendor/") || str.startsWith("/product/") || !str.contains(applicationInfo.packageName)) ? 3 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int b(String str, boolean z8) {
        if (!z8) {
            return 0;
        }
        try {
            PackageManager packageManager = jg.a().getPackageManager();
            Intent intent = new Intent();
            intent.setClassName(str, d.f9861c);
            int i9 = packageManager.resolveService(intent, 0) != null ? 2 : 0;
            try {
                Intent intent2 = new Intent();
                intent2.setClassName(str, d.f9862d);
                if (packageManager.resolveService(intent2, 0) != null) {
                    i9++;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(str, d.f9863e);
                return packageManager.resolveService(intent3, 0) != null ? i9 + 4 : i9;
            } catch (Throwable unused) {
                return i9;
            }
        } catch (Throwable unused2) {
            return 0;
        }
    }

    private static PackageInfo c(String str, int i9) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (f10354a == null) {
                synchronized (kg.class) {
                    try {
                        if (f10354a == null) {
                            f10354a = Class.forName(new String(Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new String(Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new Class[0]).invoke(null, new Object[0]);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            IBinder iBinderAsBinder = ((IInterface) f10354a).asBinder();
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(iBinderAsBinder.getInterfaceDescriptor());
                parcelObtain.writeString(str);
                parcelObtain.writeLong(i9);
                parcelObtain.writeInt(0);
                iBinderAsBinder.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0 ? (PackageInfo) PackageInfo.CREATOR.createFromParcel(parcelObtain2) : null;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        } catch (Throwable th2) {
            defpackage.f.n(th2, defpackage.f.i("b method failed: ", str, ", error: "), "PackageUtils");
            return null;
        }
    }

    private static int d() {
        return Build.VERSION.SDK_INT >= 28 ? 134217792 : 64;
    }

    public static String e(PackageInfo packageInfo, boolean z8) {
        return !z8 ? "" : a(packageInfo, d.f9864f);
    }

    public static String f(PackageInfo packageInfo, boolean z8) {
        return !z8 ? "" : a(packageInfo, d.f9865g);
    }

    public static String g(PackageInfo packageInfo, boolean z8) {
        return !z8 ? "" : a(packageInfo, d.f9866h);
    }

    public static int a(boolean z8) {
        return a(false, z8, 0, false);
    }

    public static long b(PackageInfo packageInfo, boolean z8) {
        if (z8 && packageInfo != null) {
            return packageInfo.lastUpdateTime;
        }
        return 0L;
    }

    public static int d(PackageInfo packageInfo, boolean z8) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return -1;
        }
        return a(applicationInfo, z8);
    }

    private static void e() {
        ConcurrentHashMap<String, PackageInfo> concurrentHashMap = f10355b;
        if (concurrentHashMap.size() < 100) {
            return;
        }
        String str = jg.a().getPackageName() + BundleUtil.UNDERLINE_TAG;
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            if (!it.next().startsWith(str)) {
                it.remove();
            }
        }
        ee.a("PackageUtils", "Cache full, cleared non-current app entries");
    }

    private static void f() {
        ConcurrentHashMap<String, String> concurrentHashMap = f10357d;
        if (concurrentHashMap.size() < 100) {
            return;
        }
        String strJ = A.a.j(new StringBuilder(), c(), BundleUtil.UNDERLINE_TAG);
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            if (!it.next().startsWith(strJ)) {
                it.remove();
            }
        }
    }

    private static int a(boolean z8, boolean z9, int i9, boolean z10) {
        if (z8) {
            return z10 ? i9 : d() | 4239 | i9;
        }
        bq bqVarA = bq.a();
        boolean zA = bqVarA.a(MTPushConstants.Message.CODE_MESSAGE_DELETED, z9);
        boolean zA2 = bqVarA.a(1300, z9);
        int iD = zA ? 4 | d() : 4;
        if (zA2) {
            iD |= 4096;
        }
        if (i9 == 0) {
            return iD;
        }
        if (!zA) {
            i9 = Build.VERSION.SDK_INT >= 28 ? i9 & (-134217793) : i9 & (-65);
        }
        if (!zA2) {
            i9 &= -4097;
        }
        return iD | i9;
    }

    private static PackageInfo b(String str, int i9) {
        try {
            PackageInfo packageInfo = jg.a().getPackageManager().getPackageInfo(str, i9);
            if (packageInfo != null) {
                return packageInfo;
            }
        } catch (Throwable unused) {
        }
        try {
            PackageInfo packageInfoC = c(str, i9);
            if (packageInfoC == null || TextUtils.isEmpty(packageInfoC.packageName)) {
                return null;
            }
            return packageInfoC;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static long a(PackageInfo packageInfo, boolean z8) {
        if (z8 && packageInfo != null) {
            return packageInfo.firstInstallTime;
        }
        return 0L;
    }

    public static String b() {
        return a(a());
    }

    public static PackageInfo a() {
        return a(jg.a().getPackageName(), false, 0, false);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strReplaceAll = Pattern.compile("\n|\r|\r\n|\n\r|\t").matcher(str).replaceAll("");
        try {
            byte[] bytes = str.getBytes();
            return bytes.length > 30 ? strReplaceAll.substring(0, new String(bytes, 0, 30, "UTF-8").length()) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static PackageInfo a(String str, boolean z8) {
        return a(str, false, 0, false);
    }

    public static boolean b(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return false;
        }
        return a(a(packageInfo.applicationInfo, bq.a().a(1033, false)));
    }

    public static PackageInfo a(String str, boolean z8, int i9) {
        return a(str, z8, i9, false);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0073  */
    public static PackageInfo a(String str, boolean z8, int i9, boolean z9) {
        PackageInfo packageInfoB;
        int iD;
        boolean z10;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean zEquals = TextUtils.equals(str, c());
            if (zEquals) {
                if (i9 == 0) {
                    AtomicReference<Integer> atomicReference = f10358e;
                    Integer num = atomicReference.get();
                    if (num == null) {
                        iD = d() | 4239;
                        Integer numValueOf = Integer.valueOf(iD);
                        while (true) {
                            if (atomicReference.compareAndSet(null, numValueOf)) {
                                z10 = true;
                                break;
                            }
                            if (atomicReference.get() != null) {
                                z10 = false;
                                break;
                            }
                        }
                        if (!z10) {
                            iD = f10358e.get().intValue();
                        }
                    } else {
                        iD = num.intValue();
                    }
                } else {
                    iD = d() | 4239 | i9;
                }
                String strA = a(str, iD);
                ConcurrentHashMap<String, PackageInfo> concurrentHashMap = f10355b;
                packageInfoB = concurrentHashMap.get(strA);
                if (packageInfoB == null) {
                    packageInfoB = b(str, iD);
                    if (packageInfoB != null) {
                        e();
                        concurrentHashMap.put(strA, packageInfoB);
                    } else {
                        packageInfoB = null;
                    }
                }
            } else {
                packageInfoB = null;
            }
            if (packageInfoB != null) {
                return packageInfoB;
            }
            if (!z9 || i9 == 0) {
                i9 = a(zEquals, z8, i9, true);
            }
            String strA2 = a(str, i9);
            ConcurrentHashMap<String, PackageInfo> concurrentHashMap2 = f10355b;
            PackageInfo packageInfo = concurrentHashMap2.get(strA2);
            if (packageInfo != null) {
                return packageInfo;
            }
            PackageInfo packageInfoB2 = b(str, i9);
            if (packageInfoB2 != null) {
                e();
                concurrentHashMap2.put(strA2, packageInfoB2);
            }
            return packageInfoB2;
        } catch (Throwable th) {
            ee.b("PackageUtils", "get package info error: " + str, th);
            return null;
        }
    }

    public static String a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        String str = packageInfo.packageName;
        if (packageInfo.applicationInfo == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = f10357d.get(str);
        if (str2 != null) {
            return str2;
        }
        try {
            String strB = b(packageInfo.applicationInfo.loadLabel(jg.a().getPackageManager()).toString());
            if (!TextUtils.isEmpty(strB)) {
                a(str, strB);
                return strB;
            }
        } catch (Throwable unused) {
        }
        String strB2 = b(str);
        a(str, strB2);
        return strB2;
    }

    private static String a(PackageInfo packageInfo, String str) {
        Signature[] apkContentsSigners;
        if (packageInfo == null) {
            return "";
        }
        String strK = W5.f.k(new StringBuilder(), packageInfo.packageName, BundleUtil.UNDERLINE_TAG, str);
        ConcurrentHashMap<String, String> concurrentHashMap = f10356c;
        String str2 = concurrentHashMap.get(strK);
        if (str2 != null) {
            return str2;
        }
        byte[] bArrE = null;
        if (Build.VERSION.SDK_INT < 28) {
            apkContentsSigners = packageInfo.signatures;
        } else if (packageInfo.signingInfo != null) {
            boolean zHasMultipleSigners = packageInfo.signingInfo.hasMultipleSigners();
            SigningInfo signingInfo = packageInfo.signingInfo;
            apkContentsSigners = zHasMultipleSigners ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
        } else {
            apkContentsSigners = null;
        }
        if (apkContentsSigners == null || apkContentsSigners.length == 0) {
            return "";
        }
        try {
            byte[] byteArray = apkContentsSigners[0].toByteArray();
            if (TextUtils.equals(str, d.f9864f)) {
                bArrE = jk.a(byteArray);
            } else if (TextUtils.equals(str, d.f9865g)) {
                bArrE = jk.c(byteArray);
            } else if (TextUtils.equals(str, d.f9866h)) {
                bArrE = jk.e(byteArray);
            }
            if (bArrE == null) {
                return "";
            }
            String strA = jk.a(bArrE, ':');
            concurrentHashMap.put(strK, strA);
            return strA;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String c() {
        if (!TextUtils.isEmpty(f10359f)) {
            return f10359f;
        }
        String packageName = jg.a().getPackageName();
        f10359f = packageName;
        return packageName;
    }

    public static String[] c(PackageInfo packageInfo) {
        if (packageInfo != null) {
            try {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                if (serviceInfoArr != null && serviceInfoArr.length != 0) {
                    String[] strArr = new String[serviceInfoArr.length];
                    if (serviceInfoArr.length > 0) {
                        for (int i9 = 0; i9 < serviceInfoArr.length; i9++) {
                            strArr[i9] = serviceInfoArr[i9].name;
                        }
                    }
                    return strArr;
                }
            } catch (Throwable unused) {
                return new String[0];
            }
        }
        return new String[0];
    }

    public static String[] c(PackageInfo packageInfo, boolean z8) {
        if (z8 && packageInfo != null) {
            return packageInfo.requestedPermissions;
        }
        return null;
    }

    private static String a(String str, int i9) {
        return str + BundleUtil.UNDERLINE_TAG + i9;
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f();
        f10357d.put(str, str2);
    }

    public static boolean a(int i9) {
        return i9 == 1 || i9 == 2 || i9 == 3;
    }

    public static boolean a(String str) {
        return TextUtils.equals(str, c());
    }
}
