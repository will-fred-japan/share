package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat.b;
import java.util.Iterator;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f7842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f7846e;

    public f(int i9, int i10, Bundle bundle, MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str) {
        this.f7846e = hVar;
        this.f7842a = iVar;
        this.f7843b = i9;
        this.f7844c = str;
        this.f7845d = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaBrowserServiceCompat.b bVar;
        MediaBrowserServiceCompat.i iVar = this.f7842a;
        IBinder binder = iVar.f7820a.getBinder();
        MediaBrowserServiceCompat.h hVar = this.f7846e;
        MediaBrowserServiceCompat.this.f7800e.remove(binder);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        Iterator<MediaBrowserServiceCompat.b> it = mediaBrowserServiceCompat.f7799d.iterator();
        while (true) {
            bVar = null;
            if (!it.hasNext()) {
                break;
            }
            MediaBrowserServiceCompat.b next = it.next();
            if (next.f7804c == this.f7843b) {
                if (TextUtils.isEmpty(this.f7844c) || this.f7845d <= 0) {
                    bVar = mediaBrowserServiceCompat.new b(next.f7802a, next.f7803b, next.f7804c, iVar);
                }
                it.remove();
                break;
            }
        }
        if (bVar == null) {
            bVar = mediaBrowserServiceCompat.new b(this.f7844c, this.f7845d, this.f7843b, iVar);
        }
        mediaBrowserServiceCompat.f7800e.put(binder, bVar);
        try {
            binder.linkToDeath(bVar, 0);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "IBinder is already dead.");
        }
    }
}
