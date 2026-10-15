package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f7853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f7855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f7856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f7857e;

    public i(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.f7857e = hVar;
        this.f7853a = iVar;
        this.f7854b = str;
        this.f7855c = bundle;
        this.f7856d = resultReceiver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (MediaBrowserServiceCompat.this.f7800e.get(this.f7853a.f7820a.getBinder()) != null) {
            this.f7856d.b(-1, null);
            return;
        }
        Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f7854b + ", extras=" + this.f7855c);
    }
}
