package Q4;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: Q4.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExecutorC0364u implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3843a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f3844b;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f3843a) {
            case 0:
                ((p041f5.h) this.f3844b).post(runnable);
                break;
            default:
                ((p048g5.d) this.f3844b).post(runnable);
                break;
        }
    }

    public ExecutorC0364u(Looper looper) {
        this.f3844b = new p048g5.d(looper);
    }
}
