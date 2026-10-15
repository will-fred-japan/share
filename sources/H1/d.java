package H1;

import I1.b;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AbsHookStatsTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<T extends I1.b> implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2354b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, T> f2356d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2355c = ActivityLifeObserver.getInstance().isForeground();

    public d(String str) {
        this.f2353a = str;
    }

    public void c(long j, long j8) {
        Iterator<Map.Entry<Integer, T>> it = this.f2356d.entrySet().iterator();
        while (it.hasNext()) {
            T value = it.next().getValue();
            long j9 = value.f2551b;
            if (0 < j9 && j9 < value.f2550a) {
                it.remove();
            } else if (0 < j9 && j9 < j) {
                it.remove();
            } else if (j8 >= value.f2550a) {
                d(value, j, j8);
            }
        }
    }

    @Override // H1.i
    public final void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f2356d.size() != 0) {
            long j = this.f2354b;
            if (jCurrentTimeMillis - j >= 600000) {
                c(j, jCurrentTimeMillis);
            }
        }
        this.f2354b = jCurrentTimeMillis;
    }

    public abstract void d(T t, long j, long j8);
}
