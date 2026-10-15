package cn.jiguang.commons.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
final class dv implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ du f9919a;

    public dv(du duVar) {
        this.f9919a = duVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f9919a.f9917c.put(iBinder);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("linkedBlockingQueue error: "), "MsaOpenIDHelper");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
