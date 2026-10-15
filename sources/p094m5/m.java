package p094m5;

import android.os.Looper;
import java.util.concurrent.Executor;
import p064i5.a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f20367a;

    public m() {
        a aVar = new a(Looper.getMainLooper());
        Looper.getMainLooper();
        this.f20367a = aVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f20367a.post(runnable);
    }
}
