package N6;

import com.starburst.sdk.core.feed.FeedManager;
import java.util.Arrays;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3273c;

    public /* synthetic */ B(Object obj, int i9, int i10) {
        this.f3271a = i10;
        this.f3273c = obj;
        this.f3272b = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3271a) {
            case 0:
                ((C0338i) this.f3273c).success(y7.u.D(new p188x7.e("code", Integer.valueOf(this.f3272b)), new p188x7.e("message", "getDeviceAudioFiles failed"), new p188x7.e("remainingCapacity", 0), new p188x7.e("audioFiles", y7.p.f22408a)));
                break;
            case 1:
                ((FeedManager) this.f3273c).lambda$handleFileUpdateReq$3(this.f3272b);
                break;
            default:
                int i9 = this.f3272b & 4;
                io.flutter.plugin.platform.c cVar = ((io.flutter.plugin.platform.d) this.f3273c).f19605b;
                if (i9 != 0) {
                    p088l7.j jVar = cVar.f19599b;
                    jVar.getClass();
                    jVar.f20133a.a("SystemChrome.systemUIChange", Arrays.asList(Boolean.FALSE), null);
                } else {
                    p088l7.j jVar2 = cVar.f19599b;
                    jVar2.getClass();
                    jVar2.f20133a.a("SystemChrome.systemUIChange", Arrays.asList(Boolean.TRUE), null);
                }
                break;
        }
    }
}
