package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f15067l = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f15068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f15070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f15071d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.g.j.c f15076i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, Future<d>> f15072e = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<d> f15073f = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JSONArray f15074g = new JSONArray();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<String> f15075h = new CopyOnWriteArrayList();
    private String j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f15077k = 1;

    public c(com.huawei.hms.framework.network.grs.g.j.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.f15076i = cVar;
        this.f15068a = cVar.b();
        this.f15069b = cVar.a();
        this.f15070c = aVar;
        b();
        c();
    }

    private d b(d dVar) throws ExecutionException, InterruptedException, TimeoutException {
        String str;
        String str2;
        for (Map.Entry<String, Future<d>> entry : this.f15072e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e9) {
                e = e9;
                str = f15067l;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(f15067l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e10) {
                e = e10;
                str = f15067l;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(f15067l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    private void c() {
        String grsParasKey = this.f15068a.getGrsParasKey(true, true, this.f15069b);
        this.j = this.f15070c.a().a(grsParasKey + "ETag", "");
    }

    private String d() {
        com.huawei.hms.framework.network.grs.f.b bVarA = com.huawei.hms.framework.network.grs.f.b.a(this.f15069b.getPackageName());
        com.huawei.hms.framework.network.grs.local.model.a aVarA = bVarA != null ? bVarA.a() : null;
        if (aVarA == null) {
            return "";
        }
        String strA = aVarA.a();
        Logger.v(f15067l, "get appName from local assets is{%s}", strA);
        return strA;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        if (this.f15075h.isEmpty()) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        d dVarA = a(executorService, this.f15075h, str, cVar);
        Logger.i(f15067l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(dVarA == null ? 0 : dVarA.b()));
        e.a(new ArrayList(this.f15073f), SystemClock.elapsedRealtime() - jElapsedRealtime, this.f15074g, this.f15069b);
        this.f15073f.clear();
        return dVarA;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0098 A[LOOP:0: B:3:0x0004->B:36:0x0098, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0090 A[SYNTHETIC] */
    private d a(ExecutorService executorService, List<String> list, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        String str2;
        com.huawei.hms.framework.network.grs.e.c cVar2;
        boolean z8;
        ExecutionException executionException;
        d dVar = null;
        int i9 = 0;
        while (i9 < list.size()) {
            String str3 = list.get(i9);
            if (TextUtils.isEmpty(str3)) {
                str2 = str;
                cVar2 = cVar;
            } else {
                str2 = str;
                cVar2 = cVar;
                Future<d> futureSubmit = executorService.submit(new a(str3, i9, this, this.f15069b, str2, this.f15068a, cVar2).g());
                this.f15072e.put(str3, futureSubmit);
                z8 = true;
                try {
                    d dVar2 = futureSubmit.get(this.f15077k, TimeUnit.SECONDS);
                    if (dVar2 != null) {
                        try {
                            if (dVar2.o() || dVar2.m()) {
                                Logger.i(f15067l, "grs request return body is not null and is OK.");
                                dVar = dVar2;
                            }
                        } catch (InterruptedException e9) {
                            e = e9;
                            dVar = dVar2;
                            Logger.w(f15067l, "the current thread was interrupted while waiting", e);
                        } catch (CancellationException unused) {
                            dVar = dVar2;
                            Logger.i(f15067l, "{requestServer} the computation was cancelled");
                        } catch (ExecutionException e10) {
                            executionException = e10;
                            dVar = dVar2;
                            Logger.w(f15067l, "the computation threw an ExecutionException", executionException);
                        } catch (TimeoutException unused2) {
                            dVar = dVar2;
                            Logger.w(f15067l, "the wait timed out");
                        }
                        if (z8) {
                            Logger.v(f15067l, "needBreak is true so need break current circulation");
                            break;
                        }
                        i9++;
                        str = str2;
                        cVar = cVar2;
                    }
                    dVar = dVar2;
                } catch (InterruptedException e11) {
                    e = e11;
                } catch (CancellationException unused3) {
                } catch (ExecutionException e12) {
                    executionException = e12;
                } catch (TimeoutException unused4) {
                }
            }
            z8 = false;
            if (z8) {
                Logger.v(f15067l, "needBreak is true so need break current circulation");
                break;
            }
            i9++;
            str = str2;
            cVar = cVar2;
        }
        return b(dVar);
    }

    private void b() {
        com.huawei.hms.framework.network.grs.g.j.d dVarA = com.huawei.hms.framework.network.grs.g.i.a.a(this.f15069b);
        if (dVarA == null) {
            Logger.w(f15067l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(dVarA);
        List<String> listA = dVarA.a();
        if (listA == null || listA.size() <= 0) {
            Logger.v(f15067l, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (listA.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String strB = dVarA.b();
        if (listA.size() > 0) {
            for (String str : listA) {
                if (str.startsWith(JPushConstants.HTTPS_PRE)) {
                    a(strB, str);
                } else {
                    Logger.w(f15067l, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.v(f15067l, "request to GRS server url is {%s}", this.f15075h);
    }

    public String a() {
        return this.j;
    }

    public synchronized void a(d dVar) {
        try {
            this.f15073f.add(dVar);
            d dVar2 = this.f15071d;
            if (dVar2 == null || (!dVar2.o() && !this.f15071d.m())) {
                if (dVar.n()) {
                    Logger.i(f15067l, "GRS server open 503 limiting strategy.");
                    com.huawei.hms.framework.network.grs.h.d.a(this.f15068a.getGrsParasKey(true, true, this.f15069b), new com.huawei.hms.framework.network.grs.h.d.a(dVar.k(), SystemClock.elapsedRealtime()));
                    return;
                }
                if (dVar.m()) {
                    Logger.i(f15067l, "GRS server open 304 Not Modified.");
                }
                if (!dVar.o() && !dVar.m()) {
                    Logger.v(f15067l, "grsResponseResult has exception so need return");
                    return;
                }
                this.f15071d = dVar;
                this.f15070c.a(this.f15068a, dVar, this.f15069b, this.f15076i);
                for (Map.Entry<String, Future<d>> entry : this.f15072e.entrySet()) {
                    if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                        Logger.i(f15067l, "future cancel");
                        entry.getValue().cancel(true);
                    }
                }
                return;
            }
            Logger.v(f15067l, "grsResponseResult is ok");
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.d dVar) {
    }

    private void a(String str, String str2) {
        StringBuilder sbC = p171w.a.c(str2, str);
        String grsReqParamJoint = this.f15068a.getGrsReqParamJoint(false, false, d(), this.f15069b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sbC.append("?");
            sbC.append(grsReqParamJoint);
        }
        this.f15075h.add(sbC.toString());
    }
}
