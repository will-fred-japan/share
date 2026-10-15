package A1;

/* JADX INFO: compiled from: PageTraceEntity.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1436f;

    public final String toString() {
        StringBuilder sb = new StringBuilder("PageTraceEntity{pageName='");
        sb.append(this.f1431a);
        sb.append("', onCreateStartTs=");
        sb.append(this.f1432b);
        sb.append(", onCreateEndTs=");
        sb.append(this.f1433c);
        sb.append(", onResumeStartTs=");
        sb.append(this.f1434d);
        sb.append(", onResumeEndTs=");
        sb.append(this.f1435e);
        sb.append(", onWindowFocusTs=");
        return W5.e.m(sb, this.f1436f, ", onViewShowTs=0}");
    }
}
