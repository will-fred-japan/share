package androidx.media;

import android.os.IBinder;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f7847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f7848b;

    public g(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar) {
        this.f7848b = hVar;
        this.f7847a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IBinder binder = this.f7847a.f7820a.getBinder();
        MediaBrowserServiceCompat.b bVarRemove = MediaBrowserServiceCompat.this.f7800e.remove(binder);
        if (bVarRemove != null) {
            binder.unlinkToDeath(bVarRemove, 0);
        }
    }
}
