package R1;

/* JADX INFO: compiled from: BatteryLogEntity.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f3969i;
    public String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3971l;

    public b() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BatteryLogEntity{id=");
        sb.append(this.f3961a);
        sb.append(", front=");
        sb.append(this.f3962b);
        sb.append(", time=");
        sb.append(this.f3963c);
        sb.append(", type='");
        sb.append(this.f3964d);
        sb.append("', status=");
        sb.append(this.f3965e);
        sb.append(", scene='");
        sb.append(this.f3966f);
        sb.append("', accumulation=");
        sb.append(this.f3967g);
        sb.append(", source='");
        sb.append(this.f3968h);
        sb.append("', versionId=");
        sb.append(this.f3969i);
        sb.append(", processName='");
        sb.append(this.j);
        sb.append("', mainProcess=");
        sb.append(this.f3970k);
        sb.append(", startUuid='");
        return A.a.j(sb, this.f3971l, "', deleteFlag=false}");
    }

    public b(boolean z8, String str, long j, long j8) {
        this.f3962b = z8;
        this.f3963c = j;
        this.f3964d = str;
        this.f3967g = j8;
    }
}
