package com.huawei.hms.push.utils.ha;

/* JADX INFO: loaded from: classes.dex */
public class PushAnalyticsCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PushBaseAnalytics f15489a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static PushAnalyticsCenter f15490a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f15490a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f15489a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f15489a = pushBaseAnalytics;
    }
}
