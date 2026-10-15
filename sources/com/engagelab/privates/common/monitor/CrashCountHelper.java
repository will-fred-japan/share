package com.engagelab.privates.common.monitor;

import android.content.Context;
import com.engagelab.privates.common.cache.MTRemoteConfig;
import com.engagelab.privates.common.log.MTCommonLog;

/* JADX INFO: loaded from: classes.dex */
public class CrashCountHelper {
    private static final String TAG = "CrashCountHelper";
    private static volatile boolean sColdStartCounted = false;

    private static void maybeReport(Context context) {
        Context context2;
        String str = CrashCountCache.today();
        if (str.equals(CrashCountCache.getLastReportDay(context))) {
            return;
        }
        int crashCount = CrashCountCache.getCrashCount(context);
        int anrCount = CrashCountCache.getAnrCount(context);
        int coldStartCount = CrashCountCache.getColdStartCount(context);
        MTCommonLog.d(TAG, "maybeReport day=" + str + " crash=" + crashCount + " anr=" + anrCount + " coldStart=" + coldStartCount);
        long firstCrashTime = CrashCountCache.getFirstCrashTime(context);
        long firstAnrTime = CrashCountCache.getFirstAnrTime(context);
        long firstColdStartTime = CrashCountCache.getFirstColdStartTime(context);
        if (crashCount > 0 || anrCount > 0) {
            context2 = context;
            SdkMonitorReporter.reportCrashANR(context2, crashCount, firstCrashTime, anrCount, firstAnrTime);
        } else {
            context2 = context;
        }
        SdkMonitorReporter.reportColdStart(context2, coldStartCount, firstColdStartTime);
        CrashCountCache.resetCrashCount(context2);
        CrashCountCache.resetAnrCount(context2);
        CrashCountCache.resetColdStartCount(context2);
        CrashCountCache.setLastReportDay(context2, str);
    }

    public static void onAnrDetected(Context context) {
        if (context != null && MTRemoteConfig.isCrashCountEnable(context)) {
            CrashCountCache.incrementAnrCount(context);
            MTCommonLog.d(TAG, "anr count: " + CrashCountCache.getAnrCount(context));
        }
    }

    public static void onColdStart(Context context) {
        if (context == null) {
            return;
        }
        if (sColdStartCounted) {
            MTCommonLog.d(TAG, "cold start already counted, skip");
            return;
        }
        sColdStartCounted = true;
        if (!MTRemoteConfig.isCrashCountEnable(context)) {
            MTCommonLog.d(TAG, "crash count disabled, skip");
        } else {
            CrashCountCache.incrementColdStartCount(context);
            maybeReport(context);
        }
    }

    public static void onCrashDetected(Context context) {
        if (context != null && MTRemoteConfig.isCrashCountEnable(context)) {
            CrashCountCache.incrementCrashCount(context);
            MTCommonLog.d(TAG, "crash count: " + CrashCountCache.getCrashCount(context));
        }
    }
}
