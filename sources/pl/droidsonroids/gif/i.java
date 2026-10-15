package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: compiled from: InvalidationHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<d> f20871a;

    public i(d dVar) {
        super(Looper.getMainLooper());
        this.f20871a = new WeakReference<>(dVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        d dVar = this.f20871a.get();
        if (dVar == null) {
            return;
        }
        if (message.what == -1) {
            dVar.invalidateSelf();
            return;
        }
        Iterator<a> it = dVar.f20850h.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
