package p088l7;

import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import p096m7.b;

/* JADX INFO: compiled from: SettingsChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u.a.C0227a f20202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u.a f20203b;

    public t(u.a aVar, u.a.C0227a c0227a) {
        this.f20203b = aVar;
        this.f20202a = c0227a;
    }

    @Override // m7.b.d
    public final void c(Object obj) {
        u.a aVar = this.f20203b;
        ConcurrentLinkedQueue<u.a.C0227a> concurrentLinkedQueue = aVar.f20206a;
        u.a.C0227a c0227a = this.f20202a;
        concurrentLinkedQueue.remove(c0227a);
        if (aVar.f20206a.isEmpty()) {
            return;
        }
        Log.e("SettingsChannel", "The queue becomes empty after removing config generation " + c0227a.f20210a);
    }
}
