package X7;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: ResizableAtomicArray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q<T> {
    private volatile AtomicReferenceArray<T> array;

    public q(int i9) {
        this.array = new AtomicReferenceArray<>(i9);
    }

    public final int a() {
        return this.array.length();
    }

    public final T b(int i9) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i9 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i9);
        }
        return null;
    }

    public final void c(int i9, Z7.a.C0085a c0085a) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i9 < length) {
            atomicReferenceArray.set(i9, c0085a);
            return;
        }
        int i10 = i9 + 1;
        int i11 = length * 2;
        if (i10 < i11) {
            i10 = i11;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(i10);
        for (int i12 = 0; i12 < length; i12++) {
            atomicReferenceArray2.set(i12, atomicReferenceArray.get(i12));
        }
        atomicReferenceArray2.set(i9, c0085a);
        this.array = atomicReferenceArray2;
    }
}
