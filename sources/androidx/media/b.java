package androidx.media;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f7827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f7828b;

    public b(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar) {
        this.f7828b = hVar;
        this.f7827a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaBrowserServiceCompat.b bVarRemove = MediaBrowserServiceCompat.this.f7800e.remove(this.f7827a.f7820a.getBinder());
        if (bVarRemove != null) {
            bVarRemove.f7805d.f7820a.getBinder().unlinkToDeath(bVarRemove, 0);
        }
    }
}
