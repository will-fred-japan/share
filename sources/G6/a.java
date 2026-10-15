package G6;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements K7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2297a;

    @Override // K7.a
    public final Object invoke() {
        switch (this.f2297a) {
            case 0:
                return new Handler(Looper.getMainLooper());
            default:
                M7.c.f3103a.getClass();
                return Integer.valueOf(M7.c.f3104b.a().nextInt(2147418112) + 65536);
        }
    }
}
