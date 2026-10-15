package com.huawei.hms.utils;

import W5.f;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class HMSPackageManager {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static HMSPackageManager f15616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Object f15617p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Object f15618q = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Object f15619r = new Object();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Map<String, String> f15620s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageManagerHelper f15622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f15627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f15628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f15629i;
    private int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f15630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f15631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f15632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f15633n;

    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f15634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f15635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f15636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f15637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f15638e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f15639f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j) {
            this.f15634a = str;
            this.f15635b = str2;
            this.f15636c = str3;
            this.f15637d = str4;
            this.f15638e = str5;
            this.f15639f = Long.valueOf(j);
        }

        @Override // java.lang.Comparable
        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            return TextUtils.equals(this.f15638e, packagePriorityInfo.f15638e) ? this.f15639f.compareTo(packagePriorityInfo.f15639f) : this.f15638e.compareTo(packagePriorityInfo.f15638e);
        }
    }

    public class a implements Comparator<ResolveInfo> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            String str2 = resolveInfo2.serviceInfo.applicationInfo.packageName;
            if (HMSPackageManager.f15620s.containsKey(str) && HMSPackageManager.f15620s.containsKey(str2)) {
                return str.compareTo(str2);
            }
            if (HMSPackageManager.f15620s.containsKey(str)) {
                return -1;
            }
            return HMSPackageManager.f15620s.containsKey(str2) ? 1 : 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> listQueryIntentServices = HMSPackageManager.this.f15621a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
                    HMSLog.w("HMSPackageManager", "resolveInfoList is empty.");
                    return;
                }
                Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
                while (it.hasNext()) {
                    if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                        HMSPackageManager.this.d();
                    }
                }
                HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            } catch (Exception e9) {
                f.l(e9, new StringBuilder("asyncOnceCheckMDMState query hms action failed. "), "HMSPackageManager");
            }
        }
    }

    static {
        HashMap map = new HashMap();
        f15620s = map;
        map.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        map.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private HMSPackageManager(Context context) {
        this.f15621a = context;
        this.f15622b = new PackageManagerHelper(context);
    }

    private boolean c(String str, String str2) {
        return Objects.equals(str2, this.f15622b.getPackageSigningCertificate(str)) || Objects.equals(str2, this.f15622b.getPackageSignature(str));
    }

    private Pair<String, String> d(String str, String str2) {
        if (!f15620s.containsKey(str) || !PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(str2)) {
            return null;
        }
        this.f15633n = 3;
        return new Pair<>(str, str2);
    }

    private void e(String str) {
        if (SystemUtils.isHuawei() || SystemUtils.isSystemApp(this.f15621a, str) || Build.VERSION.SDK_INT < 28 || b(str)) {
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        }
    }

    private void f() {
        synchronized (f15618q) {
            this.f15623c = null;
            this.f15624d = null;
            this.f15625e = 0;
        }
    }

    private String g() {
        String str;
        HMSLog.i("HMSPackageManager", "Enter getAvailableHMSPackageNameForMultiService.");
        String str2 = this.f15626f;
        if (str2 != null) {
            c(str2);
            if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f15622b.getPackageStates(this.f15626f)) && (str = this.f15626f) != null) {
                return str;
            }
        }
        HMSLog.i("HMSPackageManager", " return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f15617p) {
            try {
                if (f15616o == null && context != null) {
                    if (context.getApplicationContext() != null) {
                        f15616o = new HMSPackageManager(context.getApplicationContext());
                    } else {
                        f15616o = new HMSPackageManager(context);
                    }
                    f15616o.l();
                    f15616o.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f15616o;
    }

    private Pair<String, String> h() {
        try {
            List<ResolveInfo> listQueryIntentServices = this.f15621a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
                HMSLog.e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
                return null;
            }
            a(listQueryIntentServices);
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                String packageSigningCertificate = this.f15622b.getPackageSigningCertificate(str);
                String packageSignature = this.f15622b.getPackageSignature(str);
                Pair<String, String> pairD = d(str, packageSigningCertificate);
                if (pairD != null) {
                    HMSLog.i("HMSPackageManager", "signature V3 check success");
                    return pairD;
                }
                Pair<String, String> pairA = a(resolveInfo.serviceInfo.metaData, str, packageSigningCertificate, packageSignature);
                if (pairA != null) {
                    HMSLog.i("HMSPackageManager", "DSS signature check success");
                    return pairA;
                }
                Pair<String, String> pairA2 = a(str, packageSignature);
                if (pairA2 != null) {
                    HMSLog.i("HMSPackageManager", "signature V2 check success");
                    return pairA2;
                }
            }
            return null;
        } catch (Exception e9) {
            f.l(e9, new StringBuilder("getHmsPackageName query hms action failed. "), "HMSPackageManager");
            return null;
        }
    }

    private Pair<String, String> i() {
        Pair<String, String> pairH = h();
        if (pairH != null) {
            HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) pairH.first));
            this.f15628h = "com.huawei.hms.core.aidlservice";
            this.f15629i = null;
            return pairH;
        }
        ArrayList<PackagePriorityInfo> arrayListJ = j();
        if (arrayListJ == null) {
            HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        for (PackagePriorityInfo packagePriorityInfo : arrayListJ) {
            String str = packagePriorityInfo.f15634a;
            String str2 = packagePriorityInfo.f15635b;
            String str3 = packagePriorityInfo.f15636c;
            String str4 = packagePriorityInfo.f15637d;
            String packageSignature = this.f15622b.getPackageSignature(str);
            if (a(str + ContainerUtils.FIELD_DELIMITER + packageSignature + ContainerUtils.FIELD_DELIMITER + str2, str3, str4)) {
                StringBuilder sbJ = A.f.j("result: ", str, ", ", str2, ", ");
                sbJ.append(packagePriorityInfo.f15639f);
                HMSLog.i("HMSPackageManager", sbJ.toString());
                this.f15628h = PackageConstants.GENERAL_SERVICES_ACTION;
                d(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    private ArrayList<PackagePriorityInfo> j() {
        try {
            List<ResolveInfo> listQueryIntentServices = this.f15621a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                HMSLog.e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
                return null;
            }
            ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                long packageFirstInstallTime = this.f15622b.getPackageFirstInstallTime(str);
                Bundle bundle = resolveInfo.serviceInfo.metaData;
                if (bundle == null) {
                    HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
                } else {
                    String strA = a(bundle, "hms_app_checker_config");
                    String strA2 = a(strA);
                    if (TextUtils.isEmpty(strA2)) {
                        HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + strA);
                    } else {
                        String strA3 = a(bundle, "hms_app_signer_v2");
                        if (TextUtils.isEmpty(strA3)) {
                            HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                        } else {
                            String strA4 = a(bundle, "hms_app_cert_chain");
                            if (TextUtils.isEmpty(strA4)) {
                                HMSLog.i("HMSPackageManager", "get certChain fail.");
                            } else {
                                StringBuilder sbJ = A.f.j("add: ", str, ", ", strA, ", ");
                                sbJ.append(packageFirstInstallTime);
                                HMSLog.i("HMSPackageManager", sbJ.toString());
                                arrayList.add(new PackagePriorityInfo(str, strA, strA3, strA4, strA2, packageFirstInstallTime));
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (Exception e9) {
            f.l(e9, new StringBuilder("query aglite action failed. "), "HMSPackageManager");
            return null;
        }
    }

    private void k() {
        synchronized (f15618q) {
            try {
                Pair<String, String> pairH = h();
                if (pairH == null) {
                    HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                    f();
                    return;
                }
                String str = (String) pairH.first;
                this.f15623c = str;
                this.f15624d = (String) pairH.second;
                this.f15625e = this.f15622b.getPackageVersionCode(str);
                HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f15623c + " version: " + this.f15625e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void l() {
        synchronized (f15618q) {
            try {
                Pair<String, String> pairI = i();
                if (pairI == null) {
                    HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                    e();
                    AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                    return;
                }
                this.f15626f = (String) pairI.first;
                this.f15627g = (String) pairI.second;
                this.j = this.f15622b.getPackageVersionCode(g());
                e(this.f15626f);
                HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f15626f + " version: " + this.j);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean m() {
        Bundle bundle;
        PackageManager packageManager = this.f15621a.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
            if (TextUtils.isEmpty(this.f15628h) || (!this.f15628h.equals(PackageConstants.GENERAL_SERVICES_ACTION) && !this.f15628h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
                    HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
                    return false;
                }
                return true;
            }
            HMSLog.i("HMSPackageManager", "action = " + this.f15628h + " exist");
            return false;
        } catch (AndroidException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e9) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e9);
        }
    }

    public String getHMSFingerprint() {
        String str = this.f15624d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f15623c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f15622b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                k();
            }
            String str2 = this.f15623c;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f15626f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f15622b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                l();
            }
            String str2 = this.f15626f;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (f15617p) {
            try {
                refresh();
                PackageManagerHelper.PackageStates packageStates = this.f15622b.getPackageStates(this.f15623c);
                PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
                if (packageStates == packageStates2) {
                    f();
                    return packageStates2;
                }
                if ("com.huawei.hwid".equals(this.f15623c) && d() == 1) {
                    return PackageManagerHelper.PackageStates.SPOOF;
                }
                return (packageStates != PackageManagerHelper.PackageStates.ENABLED || c(this.f15623c, this.f15624d)) ? packageStates : packageStates2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (f15617p) {
            try {
                refreshForMultiService();
                PackageManagerHelper.PackageStates packageStates = this.f15622b.getPackageStates(this.f15626f);
                PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
                if (packageStates == packageStates2) {
                    e();
                    return packageStates2;
                }
                if ("com.huawei.hwid".equals(this.f15626f) && d() == 1) {
                    return PackageManagerHelper.PackageStates.SPOOF;
                }
                return (packageStates != PackageManagerHelper.PackageStates.ENABLED || c(this.f15626f, this.f15627g)) ? packageStates : packageStates2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.f15622b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f15622b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.f15628h) ? this.f15628h : "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i9) {
        if (this.f15625e >= i9 || !m()) {
            return true;
        }
        int packageVersionCode = this.f15622b.getPackageVersionCode(getHMSPackageName());
        this.f15625e = packageVersionCode;
        return packageVersionCode >= i9;
    }

    public boolean isApkNeedUpdate(int i9) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i9);
        return hmsVersionCode < i9;
    }

    public boolean isApkUpdateNecessary(int i9) {
        if (isUpdateHmsForThirdPartyDevice()) {
            return true;
        }
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i9);
        return m() && hmsVersionCode < i9;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        return "com.huawei.hwid".equals(this.f15626f) && AgHmsUpdateState.getInstance().isUpdateHms();
    }

    public boolean isUseOldCertificate() {
        return this.f15632m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f15623c) || TextUtils.isEmpty(this.f15624d)) {
            k();
        }
        c(this.f15623c);
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f15626f) || TextUtils.isEmpty(this.f15627g)) {
            l();
        }
        c(this.f15626f);
    }

    public void resetMultiServiceState() {
        e();
    }

    public void setUseOldCertificate(boolean z8) {
        this.f15632m = z8;
    }

    private boolean b(String str) {
        return !"com.huawei.hwid".equals(str) || this.f15633n == 3;
    }

    private void a(List<ResolveInfo> list) {
        if (list.size() <= 1) {
            return;
        }
        Collections.sort(list, new a());
    }

    private boolean b(String str, String str2) {
        Map<String, String> map = f15620s;
        return map.containsKey(str) && map.get(str).equalsIgnoreCase(str2);
    }

    private void c(String str) {
        if ("com.huawei.hwid".equals(str) && AgHmsUpdateState.getInstance().isUpdateHms() && this.f15622b.getPackageVersionCode(str) >= AgHmsUpdateState.getInstance().getTargetVersionCode()) {
            AgHmsUpdateState.getInstance().resetUpdateState();
            HMSLog.i("HMSPackageManager", "refresh update state for HMS V3");
        }
    }

    private Pair<String, String> a(Bundle bundle, String str, String str2, String str3) {
        String str4;
        if (bundle == null) {
            HMSLog.e("HMSPackageManager", "DSS check: " + str + " for metadata is null");
            return null;
        }
        this.f15633n = 2;
        if (a(bundle, str, str2)) {
            HMSLog.i("HMSPackageManager", "support DSS V3 check");
            str3 = str2;
            str4 = "hms_app_signer_v3";
        } else {
            str4 = "hms_app_signer";
        }
        if (!bundle.containsKey(str4)) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no " + str4);
            return null;
        }
        if (bundle.containsKey("hms_app_cert_chain")) {
            if (!a(p171w.a.a(str, ContainerUtils.FIELD_DELIMITER, str3), bundle.getString(str4), bundle.getString("hms_app_cert_chain"))) {
                HMSLog.e("HMSPackageManager", "checkSigner failed");
                return null;
            }
            if (str4.equals("hms_app_signer_v3")) {
                this.f15633n = 3;
            }
            return new Pair<>(str, str3);
        }
        HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
        return null;
    }

    private void b() {
        new Thread(new b(), "Thread-asyncOnceCheckMDMState").start();
    }

    private void d(String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.f15629i = strA.substring(9);
    }

    private void e() {
        synchronized (f15618q) {
            this.f15626f = null;
            this.f15627g = null;
            this.f15628h = null;
            this.f15629i = null;
            this.j = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        synchronized (f15619r) {
            try {
                HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");
                long packageFirstInstallTime = this.f15622b.getPackageFirstInstallTime("com.huawei.hwid");
                if (this.f15630k != 3 && this.f15631l == packageFirstInstallTime) {
                    HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + a(this.f15630k));
                    return this.f15630k;
                }
                this.f15630k = c() ? 2 : 1;
                this.f15631l = this.f15622b.getPackageFirstInstallTime("com.huawei.hwid");
                HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof state: " + a(this.f15630k));
                return this.f15630k;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean c() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f15621a);
        if (hmsPath == null) {
            HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    private Pair<String, String> a(String str, String str2) {
        if (b(str, str2)) {
            return new Pair<>(str, str2);
        }
        HMSLog.w("HMSPackageManager", "check sign fail: " + str + BundleUtil.UNDERLINE_TAG + str2);
        return null;
    }

    private boolean a(Bundle bundle, String str, String str2) {
        return bundle.containsKey("hms_app_signer_v3") && !b(str, str2) && Build.VERSION.SDK_INT >= 28;
    }

    private String a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("priority=");
        if (iIndexOf == -1) {
            HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int iIndexOf2 = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        return str.substring(iIndexOf, iIndexOf2);
    }

    private boolean a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> listB = com.huawei.hms.device.a.b(str3);
            if (listB.size() == 0) {
                HMSLog.e("HMSPackageManager", "certChain is empty");
                return false;
            }
            if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.f15621a), listB)) {
                HMSLog.e("HMSPackageManager", "failed to verify cert chain");
                return false;
            }
            if (!a(listB, Arrays.asList("Huawei CBG Application Integration CA", "Huawei CBG HMS"), Arrays.asList("Huawei CBG", "Huawei CBG Cloud Security Signer"))) {
                HMSLog.i("HMSPackageManager", "failed to verify cert chain.");
                return false;
            }
            if (com.huawei.hms.device.a.a(listB.get(listB.size() - 1), str, str2)) {
                return true;
            }
            HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
            return false;
        }
        HMSLog.e("HMSPackageManager", "args is invalid");
        return false;
    }

    private boolean a(List<X509Certificate> list, List<String> list2, List<String> list3) {
        if (list != null && list2 != null && list3 != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                X509Certificate x509Certificate = list.get(size);
                if (size >= list2.size()) {
                    HMSLog.e("HMSPackageManager", "CN is invalid, Array length mismatch.");
                    return false;
                }
                if (!com.huawei.hms.device.a.a(x509Certificate, list2.get(size))) {
                    HMSLog.e("HMSPackageManager", "CN is invalid");
                    return false;
                }
                if (size >= list3.size()) {
                    HMSLog.e("HMSPackageManager", "OU is invalid, Array length mismatch.");
                    return false;
                }
                if (!com.huawei.hms.device.a.b(x509Certificate, list3.get(size))) {
                    HMSLog.e("HMSPackageManager", "OU is invalid");
                    return false;
                }
            }
            return true;
        }
        HMSLog.e("HMSPackageManager", "checkSubjects, params is null.");
        return false;
    }

    private static String a(int i9) {
        if (i9 == 1) {
            return "SPOOFED";
        }
        if (i9 == 2) {
            return "SUCCESS";
        }
        if (i9 == 3) {
            return "UNCHECKED";
        }
        HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i9);
        return "";
    }
}
