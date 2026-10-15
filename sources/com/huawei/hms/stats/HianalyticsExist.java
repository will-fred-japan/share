package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public class HianalyticsExist {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f15492a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15493b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f15494c = false;

    public static boolean isHianalyticsExist() {
        synchronized (f15492a) {
            if (!f15493b) {
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                }
                f15493b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f15494c);
            }
        }
        return f15494c;
    }
}
