package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f7838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f7840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f7841d;

    public e(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, ResultReceiver resultReceiver) {
        this.f7841d = hVar;
        this.f7838a = iVar;
        this.f7839b = str;
        this.f7840c = resultReceiver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (MediaBrowserServiceCompat.this.f7800e.get(this.f7838a.f7820a.getBinder()) == null) {
            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f7839b);
            return;
        }
        ResultReceiver resultReceiver = this.f7840c;
        if ((2 & 2) != 0) {
            resultReceiver.b(-1, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", null);
        resultReceiver.b(0, bundle);
    }
}
