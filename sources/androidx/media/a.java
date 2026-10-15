package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat.b;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f7822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f7826e;

    public a(int i9, int i10, Bundle bundle, MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str) {
        this.f7826e = hVar;
        this.f7822a = iVar;
        this.f7823b = str;
        this.f7824c = i9;
        this.f7825d = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaBrowserServiceCompat.i iVar = this.f7822a;
        Messenger messenger = iVar.f7820a;
        IBinder binder = messenger.getBinder();
        MediaBrowserServiceCompat.h hVar = this.f7826e;
        MediaBrowserServiceCompat.this.f7800e.remove(binder);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        String str = this.f7823b;
        mediaBrowserServiceCompat.new b(str, this.f7824c, this.f7825d, iVar);
        mediaBrowserServiceCompat.a();
        StringBuilder sbI = defpackage.f.i("No root for client ", str, " from service ");
        sbI.append(a.class.getName());
        Log.i("MBServiceCompat", sbI.toString());
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.arg1 = 2;
            messageObtain.setData(null);
            messenger.send(messageObtain);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=".concat(str));
        }
    }
}
