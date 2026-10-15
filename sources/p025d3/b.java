package p025d3;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AsyncTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f18498d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f18499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<p025d3.a, ScheduledFuture> f18500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap<p025d3.a, Runnable> f18501c;

    /* JADX INFO: compiled from: AsyncTaskManager.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p025d3.a f18502a;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f18502a.run();
            } catch (Throwable th) {
                p010b3.b.b("APM-AsyncTask", "thread " + Thread.currentThread().getName() + " exception", th);
            }
        }
    }

    public static synchronized b a(c cVar) {
        b bVar;
        HashMap map = f18498d;
        bVar = (b) map.get(cVar);
        if (bVar == null) {
            String strName = cVar.name();
            bVar = new b();
            bVar.f18500b = new ConcurrentHashMap<>();
            bVar.f18501c = new ConcurrentHashMap<>();
            bVar.f18499a = new ScheduledThreadPoolExecutor(1, new d(strName));
            map.put(cVar, bVar);
        }
        return bVar;
    }

    public final void b(p025d3.a aVar) {
        try {
            Runnable runnableRemove = this.f18501c.remove(aVar);
            if (runnableRemove != null) {
                this.f18499a.remove(runnableRemove);
            }
            ScheduledFuture scheduledFutureRemove = this.f18500b.remove(aVar);
            if (scheduledFutureRemove != null) {
                scheduledFutureRemove.cancel(true);
            }
        } catch (Throwable th) {
            p010b3.b.b("APM-AsyncTask", "removeTask failed", th);
        }
    }

    public final void c(p025d3.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            a aVar2 = new a();
            aVar2.f18502a = aVar;
            boolean z8 = aVar.f18496b;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f18499a;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = z8 ? scheduledThreadPoolExecutor.scheduleWithFixedDelay(aVar2, aVar.f18495a, aVar.f18497c, TimeUnit.MILLISECONDS) : scheduledThreadPoolExecutor.schedule(aVar2, aVar.f18495a, TimeUnit.MILLISECONDS);
            this.f18501c.put(aVar, aVar2);
            this.f18500b.put(aVar, scheduledFutureScheduleWithFixedDelay);
        } catch (Throwable th) {
            p010b3.b.b("APM-AsyncTask", "sendTask failed.", th);
        }
    }
}
