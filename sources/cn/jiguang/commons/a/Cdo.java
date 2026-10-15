package cn.jiguang.commons.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: cn.jiguang.commons.a.do, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class Cdo implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f9898a = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f9898a.put(iBinder);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("service connect error: "), "SumsungSericeConnection");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
