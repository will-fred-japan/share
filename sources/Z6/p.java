package Z6;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: MotionEventTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static p f5605c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<MotionEvent> f5606a = new LongSparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<Long> f5607b = new PriorityQueue<>();

    /* JADX INFO: compiled from: MotionEventTracker.java */
    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicLong f5608b = new AtomicLong(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5609a;

        public a(long j) {
            this.f5609a = j;
        }
    }

    public final MotionEvent a(a aVar) {
        PriorityQueue<Long> priorityQueue;
        LongSparseArray<MotionEvent> longSparseArray;
        long j;
        while (true) {
            priorityQueue = this.f5607b;
            boolean zIsEmpty = priorityQueue.isEmpty();
            longSparseArray = this.f5606a;
            j = aVar.f5609a;
            if (zIsEmpty || priorityQueue.peek().longValue() >= j) {
                break;
            }
            longSparseArray.remove(priorityQueue.poll().longValue());
        }
        if (!priorityQueue.isEmpty() && priorityQueue.peek().longValue() == j) {
            priorityQueue.poll();
        }
        MotionEvent motionEvent = longSparseArray.get(j);
        longSparseArray.remove(j);
        return motionEvent;
    }
}
