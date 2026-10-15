package com.huawei.hms.framework.network.grs;

import W5.e;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15018i = "c";
    private static final ExecutorService j = ExecutorsUtils.newSingleThreadExecutor("GrsInit");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f15019k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GrsBaseInfo f15020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f15022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f15023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f15024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f15025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a f15026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FutureTask<Boolean> f15027h;

    public class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GrsBaseInfo f15029b;

        /* JADX INFO: renamed from: com.huawei.hms.framework.network.grs.c$a$a, reason: collision with other inner class name */
        public class RunnableC0167a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.huawei.hms.framework.network.grs.f.b f15031a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f15032b;

            public RunnableC0167a(com.huawei.hms.framework.network.grs.f.b bVar, com.huawei.hms.framework.network.grs.e.c cVar) {
                this.f15031a = bVar;
                this.f15032b = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f15031a.a(a.this.f15028a.getPackageName(), this.f15032b);
            }
        }

        public a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f15028a = context;
            this.f15029b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.this.f15022c = new g();
            c.this.f15024e = new com.huawei.hms.framework.network.grs.e.c(this.f15028a, GrsApp.getInstance().getBrand(BundleUtil.UNDERLINE_TAG) + "share_pre_grs_conf_");
            c.this.f15025f = new com.huawei.hms.framework.network.grs.e.c(this.f15028a, GrsApp.getInstance().getBrand(BundleUtil.UNDERLINE_TAG) + "share_pre_grs_services_");
            c cVar = c.this;
            cVar.f15023d = new com.huawei.hms.framework.network.grs.e.a(cVar.f15024e, c.this.f15025f, c.this.f15022c);
            c cVar2 = c.this;
            cVar2.f15026g = new com.huawei.hms.framework.network.grs.a(cVar2.f15020a, c.this.f15023d, c.this.f15022c, c.this.f15025f);
            if (com.huawei.hms.framework.network.grs.f.b.a(this.f15028a.getPackageName()) == null) {
                com.huawei.hms.framework.network.grs.e.c cVar3 = new com.huawei.hms.framework.network.grs.e.c(this.f15028a, GrsApp.getInstance().getBrand(BundleUtil.UNDERLINE_TAG) + "share_pre_grs_local_conf_");
                String strA = cVar3.a(this.f15028a.getPackageName() + "#localConfig", "");
                if (TextUtils.isEmpty(strA) || !new com.huawei.hms.framework.network.grs.f.b().a(this.f15028a, strA)) {
                    c.j.execute(new RunnableC0167a(new com.huawei.hms.framework.network.grs.f.b(this.f15028a, true), cVar3));
                }
            }
            String strC = new com.huawei.hms.framework.network.grs.g.j.c(this.f15029b, this.f15028a).c();
            Logger.v(c.f15018i, "scan serviceSet is: " + strC);
            String strA2 = c.this.f15025f.a("services", "");
            String strA3 = h.a(strA2, strC);
            if (!TextUtils.isEmpty(strA3)) {
                c.this.f15025f.b("services", strA3);
                Logger.i(c.f15018i, "postList is:" + StringUtils.anonymizeMessage(strA3));
                Logger.d(c.f15018i, "currentServices:" + StringUtils.anonymizeMessage(strA2));
                if (!strA3.equals(strA2)) {
                    c.this.f15022c.a(c.this.f15020a.getGrsParasKey(true, true, this.f15028a));
                    c.this.f15022c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f15029b, this.f15028a), null, null, c.this.f15025f, c.this.f15020a.getQueryTimeout());
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - c.f15019k;
            if (c.f15019k == 0 || TimeUnit.MILLISECONDS.toHours(jElapsedRealtime) > 24) {
                Logger.i(c.f15018i, "Try to clear unUsed sp data.");
                long unused = c.f15019k = SystemClock.elapsedRealtime();
                c cVar4 = c.this;
                cVar4.a(cVar4.f15024e.a());
            }
            c.this.f15023d.b(this.f15029b, this.f15028a);
            return Boolean.TRUE;
        }
    }

    public c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f15027h = null;
        this.f15021b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f15020a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.f15021b, grsBaseInfo2));
        this.f15027h = futureTask;
        j.execute(futureTask);
        Logger.i(f15018i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    private boolean f() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f15027h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e9) {
            e = e9;
            str = f15018i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(f15018i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e10) {
            e = e10;
            str = f15018i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f15018i, "init compute task timed out");
            return false;
        } catch (Exception e11) {
            e = e11;
            str = f15018i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    public c(GrsBaseInfo grsBaseInfo) {
        this.f15027h = null;
        a(grsBaseInfo);
    }

    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!f() || (grsBaseInfo = this.f15020a) == null || (context = this.f15021b) == null) {
            return false;
        }
        this.f15023d.a(grsBaseInfo, context);
        return true;
    }

    private boolean b(long j8) {
        return System.currentTimeMillis() - j8 <= 604800000;
    }

    public String a(String str, String str2, int i9) {
        if (this.f15020a == null || str == null || str2 == null) {
            Logger.w(f15018i, "invalid para!");
            return null;
        }
        if (f()) {
            return this.f15026g.a(str, str2, this.f15021b, i9);
        }
        return null;
    }

    public Map<String, String> a(String str, int i9) {
        if (this.f15020a != null && str != null) {
            return f() ? this.f15026g.a(str, this.f15021b, i9) : new HashMap();
        }
        Logger.w(f15018i, "invalid para!");
        return new HashMap();
    }

    public void a() {
        if (f()) {
            String grsParasKey = this.f15020a.getGrsParasKey(true, true, this.f15021b);
            this.f15024e.a(grsParasKey);
            this.f15024e.a(grsParasKey + CrashHianalyticsData.TIME);
            this.f15024e.a(grsParasKey + "ETag");
            this.f15022c.a(grsParasKey);
        }
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f15020a = grsBaseInfo.m6clone();
        } catch (CloneNotSupportedException e9) {
            Logger.w(f15018i, "GrsClient catch CloneNotSupportedException", e9);
            this.f15020a = grsBaseInfo.copy();
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i9) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f15018i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f15020a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (f()) {
            this.f15026g.a(str, iQueryUrlsCallBack, this.f15021b, i9);
        } else {
            Logger.i(f15018i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i9) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f15018i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f15020a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (f()) {
            this.f15026g.a(str, str2, iQueryUrlCallBack, this.f15021b, i9);
        } else {
            Logger.i(f15018i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f15018i, "sp's content is empty.");
            return;
        }
        Set<String> setKeySet = map.keySet();
        for (String str : setKeySet) {
            if (str.endsWith(this.f15021b.getPackageName() + CrashHianalyticsData.TIME)) {
                String strA = this.f15024e.a(str, "");
                long j8 = 0;
                if (!TextUtils.isEmpty(strA) && strA.matches("\\d+")) {
                    try {
                        j8 = Long.parseLong(strA);
                    } catch (NumberFormatException e9) {
                        Logger.w(f15018i, "convert expire time from String to Long catch NumberFormatException.", e9);
                    }
                }
                String strH = A.a.h(4, 0, str);
                String strU = e.u(strH, "ETag");
                if (!b(j8) || !setKeySet.contains(strH) || !setKeySet.contains(strU)) {
                    Logger.i(f15018i, "init interface auto clear some invalid sp's data: ".concat(str));
                    this.f15024e.a(strH);
                    this.f15024e.a(str);
                    this.f15024e.a(strU);
                }
            }
        }
    }

    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.f15020a.compare(((c) obj).f15020a);
        }
        return false;
    }
}
