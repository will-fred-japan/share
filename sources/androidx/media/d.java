package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f7834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IBinder f7836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f7837d;

    public d(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, IBinder iBinder) {
        this.f7837d = hVar;
        this.f7834a = iVar;
        this.f7835b = str;
        this.f7836c = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f7800e.get(this.f7834a.f7820a.getBinder());
        String str = this.f7835b;
        if (bVar == null) {
            Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
            return;
        }
        HashMap<String, List<S.b<IBinder, Bundle>>> map = bVar.f7806e;
        IBinder iBinder = this.f7836c;
        boolean z8 = false;
        if (iBinder != null) {
            List<S.b<IBinder, Bundle>> list = map.get(str);
            if (list != null) {
                Iterator<S.b<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().f4087a) {
                        it.remove();
                        z8 = true;
                    }
                }
                if (list.size() == 0) {
                    map.remove(str);
                }
            }
        } else if (map.remove(str) != null) {
            z8 = true;
        }
        if (z8) {
            return;
        }
        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
    }
}
