package p069j2;

import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: SizeUnit.java */
/* JADX INFO: loaded from: classes.dex */
public enum b {
    /* JADX INFO: Fake field, exist only in values array */
    B(0),
    KB(1),
    MB(2),
    /* JADX INFO: Fake field, exist only in values array */
    GB(3),
    /* JADX INFO: Fake field, exist only in values array */
    TB(4),
    /* JADX INFO: Fake field, exist only in values array */
    PB(5);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19843b = -1;

    b(int i9) {
        this.f19842a = i9;
    }

    public final long a() {
        long j = this.f19843b;
        if (j > 0) {
            return j;
        }
        long j8 = 1;
        for (int i9 = 0; i9 < this.f19842a; i9++) {
            j8 *= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        }
        this.f19843b = j8;
        return j8;
    }
}
