package X7;

import S7.O;
import X7.x;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes2.dex */
public class w<T extends x & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5176b = AtomicIntegerFieldUpdater.newUpdater(w.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f5177a;

    public final void a(O.a aVar) {
        aVar.b((O.b) this);
        T[] tArr = this.f5177a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f5176b;
        if (tArr == null) {
            tArr = (T[]) new x[4];
            this.f5177a = tArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= tArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(tArr, atomicIntegerFieldUpdater.get(this) * 2);
            kotlin.jvm.internal.k.d(objArrCopyOf, "copyOf(...)");
            tArr = (T[]) ((x[]) objArrCopyOf);
            this.f5177a = tArr;
        }
        int i9 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i9 + 1);
        tArr[i9] = aVar;
        aVar.f4244b = i9;
        c(i9);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0047  */
    /* JADX WARN: Code duplicated, block: B:14:0x0054  */
    /* JADX WARN: Code duplicated, block: B:17:0x0067  */
    /* JADX WARN: Code duplicated, block: B:21:0x007b A[LOOP:0: B:9:0x003c->B:21:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x0080 A[EDGE_INSN: B:24:0x0080->B:22:0x0080 BREAK  A[LOOP:0: B:9:0x003c->B:21:0x007b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0080 A[EDGE_INSN: B:25:0x0080->B:22:0x0080 BREAK  A[LOOP:0: B:9:0x003c->B:21:0x007b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:? A[SYNTHETIC] */
    public final T b(int i9) {
        int i10;
        int i11;
        T[] tArr;
        int i12;
        T t;
        T t6;
        T t8;
        T t9;
        T[] tArr2 = this.f5177a;
        kotlin.jvm.internal.k.b(tArr2);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f5176b;
        atomicIntegerFieldUpdater.set(this, atomicIntegerFieldUpdater.get(this) - 1);
        if (i9 < atomicIntegerFieldUpdater.get(this)) {
            d(i9, atomicIntegerFieldUpdater.get(this));
            int i13 = (i9 - 1) / 2;
            if (i9 > 0) {
                T t10 = tArr2[i9];
                kotlin.jvm.internal.k.b(t10);
                T t11 = tArr2[i13];
                kotlin.jvm.internal.k.b(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    d(i9, i13);
                    c(i13);
                } else {
                    while (true) {
                        i10 = i9 * 2;
                        i11 = i10 + 1;
                        if (i11 >= atomicIntegerFieldUpdater.get(this)) {
                            break;
                        }
                        tArr = this.f5177a;
                        kotlin.jvm.internal.k.b(tArr);
                        i12 = i10 + 2;
                        if (i12 < atomicIntegerFieldUpdater.get(this)) {
                            t8 = tArr[i12];
                            kotlin.jvm.internal.k.b(t8);
                            t9 = tArr[i11];
                            kotlin.jvm.internal.k.b(t9);
                            if (((Comparable) t8).compareTo(t9) >= 0) {
                                i12 = i11;
                            }
                        } else {
                            i12 = i11;
                        }
                        t = tArr[i9];
                        kotlin.jvm.internal.k.b(t);
                        t6 = tArr[i12];
                        kotlin.jvm.internal.k.b(t6);
                        if (((Comparable) t).compareTo(t6) <= 0) {
                            break;
                        }
                        d(i9, i12);
                        i9 = i12;
                    }
                }
            } else {
                while (true) {
                    i10 = i9 * 2;
                    i11 = i10 + 1;
                    if (i11 >= atomicIntegerFieldUpdater.get(this)) {
                        break;
                        break;
                    }
                    tArr = this.f5177a;
                    kotlin.jvm.internal.k.b(tArr);
                    i12 = i10 + 2;
                    if (i12 < atomicIntegerFieldUpdater.get(this)) {
                        t8 = tArr[i12];
                        kotlin.jvm.internal.k.b(t8);
                        t9 = tArr[i11];
                        kotlin.jvm.internal.k.b(t9);
                        if (((Comparable) t8).compareTo(t9) >= 0) {
                            i12 = i11;
                        }
                    } else {
                        i12 = i11;
                    }
                    t = tArr[i9];
                    kotlin.jvm.internal.k.b(t);
                    t6 = tArr[i12];
                    kotlin.jvm.internal.k.b(t6);
                    if (((Comparable) t).compareTo(t6) <= 0) {
                        break;
                        break;
                    }
                    d(i9, i12);
                    i9 = i12;
                }
            }
        }
        T t12 = tArr2[atomicIntegerFieldUpdater.get(this)];
        kotlin.jvm.internal.k.b(t12);
        t12.b(null);
        t12.a(-1);
        tArr2[atomicIntegerFieldUpdater.get(this)] = null;
        return t12;
    }

    public final void c(int i9) {
        while (i9 > 0) {
            T[] tArr = this.f5177a;
            kotlin.jvm.internal.k.b(tArr);
            int i10 = (i9 - 1) / 2;
            T t = tArr[i10];
            kotlin.jvm.internal.k.b(t);
            T t6 = tArr[i9];
            kotlin.jvm.internal.k.b(t6);
            if (((Comparable) t).compareTo(t6) <= 0) {
                return;
            }
            d(i9, i10);
            i9 = i10;
        }
    }

    public final void d(int i9, int i10) {
        T[] tArr = this.f5177a;
        kotlin.jvm.internal.k.b(tArr);
        T t = tArr[i10];
        kotlin.jvm.internal.k.b(t);
        T t6 = tArr[i9];
        kotlin.jvm.internal.k.b(t6);
        tArr[i9] = t;
        tArr[i10] = t6;
        t.a(i9);
        t6.a(i10);
    }
}
