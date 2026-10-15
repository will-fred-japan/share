package cn.jiguang.commons.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class ea implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f9937a = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f9937a.put(iBinder);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("service connect error: "), "ZuiSericeConnection");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
