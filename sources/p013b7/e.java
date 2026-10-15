package p013b7;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: PlatformTaskQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f8635a;

    public e() {
        Looper mainLooper = Looper.getMainLooper();
        this.f8635a = Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(mainLooper) : new Handler(mainLooper);
    }

    @Override // b7.c.b
    public final void a(b bVar) {
        this.f8635a.post(bVar);
    }
}
