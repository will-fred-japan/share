package p099n1;

import java.lang.Comparable;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: TopK.java */
/* JADX INFO: loaded from: classes.dex */
public final class g<E extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue<E> f20564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20565b;

    /* JADX INFO: compiled from: TopK.java */
    public class a implements Comparator<E> {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    public g(int i9) {
        if (i9 <= 0) {
            throw new IllegalStateException();
        }
        this.f20565b = i9;
        this.f20564a = new PriorityQueue<>(i9, new a());
    }

    public final void a(c2.g.b bVar) {
        PriorityQueue<E> priorityQueue = this.f20564a;
        if (priorityQueue.size() < this.f20565b) {
            priorityQueue.add(bVar);
        } else if (bVar.compareTo(priorityQueue.peek()) > 0) {
            priorityQueue.poll();
            priorityQueue.add(bVar);
        }
    }
}
