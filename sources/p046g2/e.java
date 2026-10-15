package p046g2;

/* JADX INFO: compiled from: TrafficUsageModel.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18860b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f18862d = System.currentTimeMillis();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18861c = 1;

    public e(String str, long j) {
        this.f18859a = str;
        this.f18860b = j;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = this.f18860b;
        long j8 = ((e) obj).f18860b;
        if (j == j8) {
            return 0;
        }
        return j > j8 ? 1 : -1;
    }
}
