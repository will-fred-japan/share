package p179w7;

import p096m7.k;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f22248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Exception f22249c;

    public /* synthetic */ j(k kVar, Exception exc, int i9) {
        this.f22247a = i9;
        this.f22248b = kVar;
        this.f22249c = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f22247a) {
            case 0:
                Exception exc = this.f22249c;
                this.f22248b.error("host_connection_state_error", exc.getMessage(), e.f(exc));
                break;
            case 1:
                Exception exc2 = this.f22249c;
                this.f22248b.error("connect_error", exc2.getMessage(), e.f(exc2));
                break;
            case 2:
                Exception exc3 = this.f22249c;
                this.f22248b.error("write_error", exc3.getMessage(), e.f(exc3));
                break;
            default:
                Exception exc4 = this.f22249c;
                this.f22248b.error("a2dp_state_error", exc4.getMessage(), e.f(exc4));
                break;
        }
    }
}
