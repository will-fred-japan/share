package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class HiAnalyticsOfCpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HiAnalyticsInstance f15491a;

    private static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f15491a = analyticsInstance;
        return analyticsInstance;
    }

    public static void onEvent(Context context, String str, String str2) {
        if (a(context) != null) {
            f15491a.onEvent(context, str, str2);
        }
    }

    public static void onReport(Context context, int i9) {
        if (a(context) != null) {
            f15491a.onReport(i9);
        }
    }

    public static void onStreamEvent(Context context, int i9, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f15491a.onStreamEvent(i9, str, linkedHashMap);
        }
    }

    public static void onEvent(Context context, int i9, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f15491a.onEvent(i9, str, linkedHashMap);
        }
    }
}
