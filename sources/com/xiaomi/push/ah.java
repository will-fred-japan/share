package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ah f17016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f88a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ScheduledThreadPoolExecutor f91a = new ScheduledThreadPoolExecutor(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, ScheduledFuture> f90a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f89a = new Object();

    public static abstract class a implements Runnable {
        /* JADX INFO: renamed from: a */
        public abstract String mo133a();
    }

    private ah(Context context) {
        this.f88a = context.getSharedPreferences("mipush_extra", 0);
    }

    public boolean b(a aVar, int i9) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> scheduledFutureSchedule = this.f91a.schedule(new b(aVar) { // from class: com.xiaomi.push.ah.2
            @Override // com.xiaomi.push.ah.b
            public void b() {
                synchronized (ah.this.f89a) {
                    ah.this.f90a.remove(super.f17019a.mo133a());
                }
            }
        }, i9, TimeUnit.SECONDS);
        synchronized (this.f89a) {
            this.f90a.put(aVar.mo133a(), scheduledFutureSchedule);
        }
        return true;
    }

    public static ah a(Context context) {
        if (f17016a == null) {
            synchronized (ah.class) {
                try {
                    if (f17016a == null) {
                        f17016a = new ah(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17016a;
    }

    public boolean a(a aVar, int i9) {
        return a(aVar, i9, 0);
    }

    public boolean a(a aVar, int i9, int i10) {
        return a(aVar, i9, i10, false);
    }

    public boolean a(a aVar, int i9, int i10, final boolean z8) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        final String strA = a(aVar.mo133a());
        b bVar = new b(aVar) { // from class: com.xiaomi.push.ah.1
            @Override // com.xiaomi.push.ah.b
            public void a() {
                super.a();
            }

            @Override // com.xiaomi.push.ah.b
            public void b() {
                if (z8) {
                    return;
                }
                ah.this.f88a.edit().putLong(strA, System.currentTimeMillis()).commit();
            }
        };
        if (!z8) {
            long jAbs = Math.abs(System.currentTimeMillis() - this.f88a.getLong(strA, 0L)) / 1000;
            if (jAbs < i9 - i10) {
                i10 = (int) (((long) i9) - jAbs);
            }
        }
        try {
            ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = this.f91a.scheduleAtFixedRate(bVar, i10, i9, TimeUnit.SECONDS);
            synchronized (this.f89a) {
                try {
                    this.f90a.put(aVar.mo133a(), scheduledFutureScheduleAtFixedRate);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            return true;
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i9) {
        this.f91a.schedule(runnable, i9, TimeUnit.SECONDS);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m89a(a aVar) {
        return b(aVar, 0);
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f89a) {
            scheduledFuture = this.f90a.get(aVar.mo133a());
        }
        return scheduledFuture;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m90a(String str) {
        synchronized (this.f89a) {
            try {
                ScheduledFuture scheduledFuture = this.f90a.get(str);
                if (scheduledFuture == null) {
                    return false;
                }
                this.f90a.remove(str);
                return scheduledFuture.cancel(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String a(String str) {
        return W5.e.l("last_job_time", str);
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f17019a;

        public b(a aVar) {
            this.f17019a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f17019a.run();
            b();
        }

        public void a() {
        }

        public void b() {
        }
    }
}
