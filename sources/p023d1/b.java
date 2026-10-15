package p023d1;

import android.util.Pair;
import com.bytedance.apm.doctor.DoctorManager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p016c1.f;

/* JADX INFO: compiled from: ApmInnerThreadPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ScheduledThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f18489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f18490b;

    public b(a aVar) {
        super(1, aVar);
        this.f18489a = new ConcurrentHashMap();
        this.f18490b = new ConcurrentHashMap();
    }

    public final void a(f fVar, long j) {
        ScheduledFuture<?> scheduledFutureSchedule = schedule(fVar, j, TimeUnit.MILLISECONDS);
        int iHashCode = fVar.hashCode();
        ConcurrentHashMap concurrentHashMap = this.f18489a;
        List copyOnWriteArrayList = (List) concurrentHashMap.get(Integer.valueOf(iHashCode));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            concurrentHashMap.put(Integer.valueOf(iHashCode), copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(scheduledFutureSchedule);
        this.f18490b.put(scheduledFutureSchedule, new Pair(Integer.valueOf(iHashCode), Boolean.FALSE));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable runnable, Throwable th) {
        Object obj;
        super.afterExecute(runnable, th);
        if (runnable instanceof ScheduledFuture) {
            ScheduledFuture scheduledFuture = (ScheduledFuture) runnable;
            ConcurrentHashMap concurrentHashMap = this.f18490b;
            Pair pair = (Pair) concurrentHashMap.get(scheduledFuture);
            if (pair == null || (obj = pair.first) == null) {
                return;
            }
            Integer num = (Integer) obj;
            Boolean bool = (Boolean) pair.second;
            if (bool == null || bool.booleanValue()) {
                return;
            }
            ConcurrentHashMap concurrentHashMap2 = this.f18489a;
            List list = (List) concurrentHashMap2.get(num);
            if (list != null) {
                list.remove(scheduledFuture);
                if (list.isEmpty()) {
                    concurrentHashMap2.remove(num);
                }
            }
            concurrentHashMap.remove(scheduledFuture);
        }
    }

    public final void b(DoctorManager.a aVar) {
        super.submit(aVar);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void terminated() {
        super.terminated();
    }
}
