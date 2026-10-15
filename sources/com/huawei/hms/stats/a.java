package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AnalyticsCacheManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f15495f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f15496a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15497b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Runnable> f15498c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f15499d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f15500e = new RunnableC0168a();

    /* JADX INFO: renamed from: com.huawei.hms.stats.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnalyticsCacheManager.java */
    public class RunnableC0168a implements Runnable {
        public RunnableC0168a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (HiAnalyticsUtils.getInstance().getInitFlag()) {
                a.this.b();
            } else {
                a.this.a();
            }
        }
    }

    private a() {
    }

    public static a c() {
        return f15495f;
    }

    public void a(Runnable runnable) {
        synchronized (this.f15496a) {
            try {
                if (runnable == null) {
                    return;
                }
                if (this.f15497b) {
                    return;
                }
                if (this.f15498c.size() >= 60) {
                    return;
                }
                this.f15498c.add(runnable);
                this.f15499d.removeCallbacks(this.f15500e);
                this.f15499d.postDelayed(this.f15500e, 10000L);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f15496a) {
            HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f15498c.size());
            this.f15497b = true;
            try {
                Iterator<Runnable> it = this.f15498c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th) {
                HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th.getMessage());
                a();
            }
            this.f15497b = false;
        }
    }

    public void a() {
        synchronized (this.f15496a) {
            HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f15498c.clear();
        }
    }
}
