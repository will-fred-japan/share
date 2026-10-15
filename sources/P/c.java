package P;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: ExecutorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f3599b;

    public /* synthetic */ c(Handler handler, int i9) {
        this.f3598a = i9;
        this.f3599b = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f3598a) {
            case 0:
                runnable.getClass();
                Handler handler = this.f3599b;
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            default:
                runnable.getClass();
                Handler handler2 = this.f3599b;
                if (handler2.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler2 + " is shutting down");
        }
    }
}
