package cn.jiguang.ae;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9014a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f9018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f9019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    byte[] f9020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f9021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f9022i;
    boolean j;

    public e(long j, String str, int i9, int i10, long j8, long j9, byte[] bArr) {
        this.f9015b = j;
        this.f9016c = str;
        this.f9017d = i9;
        this.f9018e = i10;
        this.f9019f = j8;
        this.f9022i = j9;
        this.f9020g = bArr;
        if (j9 > 0) {
            this.j = true;
        }
    }

    public void a() {
        this.f9014a++;
    }

    public String toString() {
        return "InnerRequest{times=" + this.f9014a + ", requestId=" + this.f9015b + ", sdkType='" + this.f9016c + "', command=" + this.f9017d + ", ver=" + this.f9018e + ", rid=" + this.f9019f + ", reqeustTime=" + this.f9021h + ", timeout=" + this.f9022i + '}';
    }
}
