package N6;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0338i f3428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3429c;

    public /* synthetic */ u(C0338i c0338i, String str, int i9) {
        this.f3427a = i9;
        this.f3428b = c0338i;
        this.f3429c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3427a) {
            case 0:
                this.f3428b.success(y7.u.D(new p188x7.e("code", 200), new p188x7.e("message", "ok"), new p188x7.e("taskId", this.f3429c)));
                break;
            default:
                this.f3428b.success(y7.u.D(new p188x7.e("code", 200), new p188x7.e("message", "ok"), new p188x7.e("response", this.f3429c)));
                break;
        }
    }
}
