package b8;

import B0.N;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final N f8654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final N f8655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final N f8656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final N f8657e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8653a = X7.g.c(100, 12, "kotlinx.coroutines.semaphore.maxSpinCycles");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8658f = X7.g.c(16, 12, "kotlinx.coroutines.semaphore.segmentSize");

    static {
        int i9 = 7;
        f8654b = new N(i9, "PERMIT");
        f8655c = new N(i9, "TAKEN");
        f8656d = new N(i9, "BROKEN");
        f8657e = new N(i9, "CANCELLED");
    }
}
