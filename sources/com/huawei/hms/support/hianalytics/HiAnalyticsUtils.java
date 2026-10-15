package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.HiAnalyticsOfCpUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HiAnalyticsUtils {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f15534c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f15535d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HiAnalyticsUtils f15536e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15537a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15538b = HianalyticsExist.isHianalyticsExist();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f15541c;

        public a(Context context, String str, Map map) {
            this.f15539a = context;
            this.f15540b = str;
            this.f15541c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent(this.f15539a, this.f15540b, this.f15541c);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15545c;

        public b(Context context, String str, String str2) {
            this.f15543a = context;
            this.f15544b = str;
            this.f15545c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent2(this.f15543a, this.f15544b, this.f15545c);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f15549c;

        public c(Context context, String str, Map map) {
            this.f15547a = context;
            this.f15548b = str;
            this.f15549c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f15547a, this.f15548b, this.f15549c);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f15553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f15554d;

        public d(Context context, String str, Map map, int i9) {
            this.f15551a = context;
            this.f15552b = str;
            this.f15553c = map;
            this.f15554d = i9;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f15551a, this.f15552b, this.f15553c, this.f15554d);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f15558c;

        public e(Context context, String str, Map map) {
            this.f15556a = context;
            this.f15557b = str;
            this.f15558c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f15556a, this.f15557b, this.f15558c);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f15562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f15563d;

        public f(Context context, String str, Map map, int i9) {
            this.f15560a = context;
            this.f15561b = str;
            this.f15562c = map;
            this.f15563d = i9;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f15560a, this.f15561b, this.f15562c, this.f15563d);
        }
    }

    private HiAnalyticsUtils() {
    }

    private static LinkedHashMap<String, String> a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private void b(Context context) {
        synchronized (f15535d) {
            try {
                int i9 = this.f15537a;
                if (i9 < 60) {
                    this.f15537a = i9 + 1;
                } else {
                    this.f15537a = 0;
                    if (this.f15538b) {
                        HiAnalyticsOfCpUtils.onReport(context, 0);
                        HiAnalyticsOfCpUtils.onReport(context, 1);
                    } else {
                        HmsHiAnalyticsUtils.onReport();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void c(Context context, String str, Map map) {
        try {
            com.huawei.hms.stats.a.c().a(new e(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache> failed. " + th.getMessage());
        }
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f15534c) {
            try {
                if (f15536e == null) {
                    f15536e = new HiAnalyticsUtils();
                }
                hiAnalyticsUtils = f15536e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (this.f15538b) {
            HiAnalyticTools.enableLog(context);
        } else {
            HmsHiAnalyticsUtils.enableLog();
        }
    }

    public boolean getInitFlag() {
        return !this.f15538b ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public int getOobeAnalyticsState(Context context) {
        if (context == null) {
            return 0;
        }
        int iA = a(context);
        if (iA == 1) {
            return iA;
        }
        Bundle bundle = new Bundle();
        bundle.putString("hms_cp_bundle_key", "content://com.huawei.hms.contentprovider/com.huawei.hms.privacy.HmsAnalyticsStateProvider");
        try {
            Bundle bundleCall = context.getApplicationContext().getContentResolver().call(Uri.parse("content://com.huawei.hms.contentprovider"), "getAnalyticsState", (String) null, bundle);
            if (bundleCall == null) {
                return iA;
            }
            iA = bundleCall.getInt("SWITCH_IS_CHECKED");
            HMSLog.i("HiAnalyticsUtils", "get hms analyticsOobe state " + iA);
            return iA;
        } catch (IllegalArgumentException unused) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState IllegalArgumentException ");
            return iA;
        } catch (SecurityException unused2) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState SecurityException ");
            return iA;
        } catch (Exception unused3) {
            HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState Exception ");
            return iA;
        }
    }

    public boolean hasError(Context context) {
        return AnalyticsSwitchHolder.isAnalyticsDisabled(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        onEvent2(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, map)) {
            a(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f15538b) {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, a(map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, a(map));
            } else {
                HmsHiAnalyticsUtils.onEvent(0, str, a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, a(map));
            }
            b(context);
        }
    }

    public void onEvent2(Context context, String str, String str2) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onEvent2> context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (!initFlag && andRefreshAnalyticsState != 2 && a(str2)) {
            a(context, str, str2);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f15538b) {
                HiAnalyticsOfCpUtils.onEvent(context, str, str2);
            } else {
                HmsHiAnalyticsUtils.onEvent(context, str, str2);
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onNewEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            b(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f15538b) {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, a((Map<String, String>) map));
            } else {
                HmsHiAnalyticsUtils.onEvent(0, str, a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onEvent(1, str, a((Map<String, String>) map));
            }
            b(context);
        }
    }

    public void onReport(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.e("HiAnalyticsUtils", "<onReport> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            c(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f15538b) {
                HiAnalyticsOfCpUtils.onStreamEvent(context, 0, str, a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onStreamEvent(context, 1, str, a((Map<String, String>) map));
            } else {
                HmsHiAnalyticsUtils.onStreamEvent(0, str, a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onStreamEvent(1, str, a((Map<String, String>) map));
            }
        }
    }

    public void enableLog() {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (!this.f15538b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    private int a(Context context) {
        int i9 = 0;
        try {
            i9 = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
            HMSLog.i("HiAnalyticsUtils", "getOobeStateForSettings value is " + i9);
            return i9;
        } catch (Settings.SettingNotFoundException e9) {
            HMSLog.i("HiAnalyticsUtils", "Settings.SettingNotFoundException " + e9.getMessage());
            return i9;
        }
    }

    private boolean a(boolean z8, boolean z9, Map<?, ?> map) {
        return !z8 && z9 && b(map);
    }

    private boolean b(Map<?, ?> map) {
        try {
            long length = 0;
            for (Object obj : map.values()) {
                if (obj instanceof String) {
                    length += (long) ((String) obj).getBytes(Charset.forName("UTF-8")).length;
                }
            }
            return length <= 512;
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<isValidSize map> Exception: " + th.getMessage());
            return false;
        }
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return str.getBytes(Charset.forName("UTF-8")).length <= 512;
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<isValidSize String> Exception: " + th.getMessage());
            return false;
        }
    }

    public void onReport(Context context, String str, Map map, int i9) {
        if (i9 != 0 && i9 != 1) {
            HMSLog.e("HiAnalyticsUtils", "<onReport with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                b(context, str, map, i9);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f15538b) {
                    HmsHiAnalyticsUtils.onStreamEvent(i9, str, a((Map<String, String>) map));
                    return;
                } else {
                    HiAnalyticsOfCpUtils.onStreamEvent(context, i9, str, a((Map<String, String>) map));
                    return;
                }
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onReport with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    private void a(Context context, String str, Map<String, String> map) {
        try {
            com.huawei.hms.stats.a.c().a(new a(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnEventToCache> failed. " + th.getMessage());
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i9) {
        if (i9 != 0 && i9 != 1) {
            HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                a(context, str, map, i9);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f15538b) {
                    HmsHiAnalyticsUtils.onEvent(i9, str, a((Map<String, String>) map));
                } else {
                    HiAnalyticsOfCpUtils.onEvent(context, i9, str, a((Map<String, String>) map));
                }
                b(context);
                return;
            }
            return;
        }
        HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    private void b(Context context, String str, Map map) {
        try {
            com.huawei.hms.stats.a.c().a(new c(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache> failed. " + th.getMessage());
        }
    }

    private void a(Context context, String str, String str2) {
        try {
            com.huawei.hms.stats.a.c().a(new b(context.getApplicationContext(), str, str2));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnEvent2ToCache> Failed. " + th.getMessage());
        }
    }

    private void b(Context context, String str, Map map, int i9) {
        try {
            com.huawei.hms.stats.a.c().a(new f(context.getApplicationContext(), str, map, i9));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache with type> failed. " + th.getMessage());
        }
    }

    private void a(Context context, String str, Map map, int i9) {
        try {
            com.huawei.hms.stats.a.c().a(new d(context.getApplicationContext(), str, map, i9));
        } catch (Throwable th) {
            HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache with type> failed. " + th.getMessage());
        }
    }
}
