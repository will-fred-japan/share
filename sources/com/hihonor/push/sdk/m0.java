package com.hihonor.push.sdk;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class m0 implements k0, IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f14531a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k0.a f14532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f14533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n0 f14534d;

    public m0(k0.a aVar) {
        this.f14532b = aVar;
    }

    public final void a(int i9) {
        Log.i("PushConnectionClient", "notifyFailed result: " + i9);
        a((g) null);
        this.f14531a.set(1);
        k0.a aVar = this.f14532b;
        if (aVar != null) {
            ((j0.a) aVar).a(i9);
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Log.i("PushConnectionClient", "binder died.");
        a((g) null);
        a(8002002);
    }

    public final synchronized void a(g gVar) {
        try {
            g gVar2 = this.f14533c;
            if (gVar2 != null) {
                gVar2.asBinder().unlinkToDeath(this, 0);
            }
            if (gVar != null) {
                try {
                    gVar.asBinder().linkToDeath(this, 0);
                } catch (RemoteException unused) {
                    Log.e("PushConnectionClient", "link to death fail.");
                }
            }
            this.f14533c = gVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a() {
        Log.i("PushConnectionClient", "enter unbind");
        n0 n0Var = this.f14534d;
        if (n0Var != null) {
            try {
                Log.i("AIDLSrvConnection", "trying to unbind service.");
                a0.f14448c.a().unbindService(n0Var);
            } catch (Exception e9) {
                H2.a.h(e9, new StringBuilder("on unBind service exception:"), "AIDLSrvConnection");
            }
            this.f14534d = null;
        }
    }
}
