package N6;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0338i f3431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f3433d;

    public /* synthetic */ v(C0338i c0338i, int i9, String str, int i10) {
        this.f3430a = i10;
        this.f3431b = c0338i;
        this.f3432c = i9;
        this.f3433d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3430a) {
            case 0:
                p188x7.e eVar = new p188x7.e("code", Integer.valueOf(this.f3432c));
                String str = this.f3433d;
                if (str == null) {
                    str = "";
                }
                this.f3431b.success(y7.u.D(eVar, new p188x7.e("message", str), new p188x7.e("taskId", null)));
                break;
            case 1:
                p188x7.e eVar2 = new p188x7.e("code", Integer.valueOf(this.f3432c));
                String str2 = this.f3433d;
                if (str2 == null) {
                    str2 = "";
                }
                this.f3431b.success(y7.u.D(eVar2, new p188x7.e("message", str2), new p188x7.e("authInfo", null)));
                break;
            default:
                p188x7.e eVar3 = new p188x7.e("code", Integer.valueOf(this.f3432c));
                String str3 = this.f3433d;
                if (str3 == null) {
                    str3 = "";
                }
                this.f3431b.success(y7.u.D(eVar3, new p188x7.e("message", str3), new p188x7.e("response", null)));
                break;
        }
    }
}
