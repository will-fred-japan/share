package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f7849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f7851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f7852d;

    public h(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.f7852d = hVar;
        this.f7849a = iVar;
        this.f7850b = str;
        this.f7851c = resultReceiver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (MediaBrowserServiceCompat.this.f7800e.get(this.f7849a.f7820a.getBinder()) != null) {
            this.f7851c.b(-1, null);
            return;
        }
        Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f7850b);
    }
}
