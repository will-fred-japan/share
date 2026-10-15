package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
final class e implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f11399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f11400b;

    private e(d dVar) {
        this.f11400b = dVar;
        this.f11399a = new LinkedBlockingQueue<>(1);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            a.f11397a.set(false);
            cn.jpush.android.i.b.b("ServiceConnection", "onServiceConnected:" + componentName);
            if (iBinder != null) {
                this.f11399a.put(iBinder);
            } else {
                cn.jpush.android.i.b.g("ServiceConnection", "onServiceConnected, but IBinder is null.");
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a.f11397a.set(false);
        d.a(this.f11400b, (cn.asus.push.d) null);
        cn.jpush.android.i.b.g("ServiceConnection", "onServiceDisconnected:" + componentName);
    }

    public /* synthetic */ e(d dVar, byte b9) {
        this(dVar);
    }
}
