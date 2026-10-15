package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class n0 implements ServiceConnection {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.hihonor.push.sdk.a f14538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f14539c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14537a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f14540d = null;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 1001) {
                return false;
            }
            Log.e("AIDLSrvConnection", "bind core service time out");
            b bVar = n0.this.f14539c;
            if (bVar == null) {
                return true;
            }
            ((l0) bVar).f14530a.a(8002003);
            return true;
        }
    }

    public interface b {
    }

    public n0(com.hihonor.push.sdk.a aVar) {
        this.f14538b = aVar;
    }

    public final void a() {
        synchronized (this.f14537a) {
            try {
                Handler handler = this.f14540d;
                if (handler != null) {
                    handler.removeMessages(1001);
                    this.f14540d = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onBindingDied.");
        a(8002002);
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onNullBinding, than unBind.");
        a();
        a(8002005);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        g c0161a;
        Log.i("AIDLSrvConnection", "enter onServiceConnected.");
        a();
        b bVar = this.f14539c;
        if (bVar != null) {
            l0 l0Var = (l0) bVar;
            int i9 = g.a.f14488a;
            if (iBinder == null) {
                c0161a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.push.framework.aidl.IPushInvoke");
                c0161a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new g.a.C0161a(iBinder) : (g) iInterfaceQueryLocalInterface;
            }
            if (c0161a == null) {
                Log.e("PushConnectionClient", "failed to get service as interface, trying to unbind.");
                l0Var.f14530a.a(8002001);
                return;
            }
            l0Var.f14530a.a(c0161a);
            l0Var.f14530a.f14531a.set(3);
            k0.a aVar = l0Var.f14530a.f14532b;
            if (aVar != null) {
                j0.a aVar2 = (j0.a) aVar;
                if (Looper.myLooper() == j0.this.f14505a.getLooper()) {
                    aVar2.a();
                } else {
                    j0.this.f14505a.post(new i0(aVar2));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onServiceDisconnected.");
        a(8002002);
    }

    public final void a(Looper looper) {
        synchronized (this.f14537a) {
            try {
                Handler handler = this.f14540d;
                if (handler != null) {
                    handler.removeMessages(1001, this.f14537a);
                } else {
                    this.f14540d = new Handler(looper, new a());
                }
                Message message = new Message();
                message.what = 1001;
                message.obj = this.f14537a;
                this.f14540d.sendMessageDelayed(message, com.heytap.mcssdk.constant.a.f14256r);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(int i9) {
        b bVar = this.f14539c;
        if (bVar != null) {
            ((l0) bVar).f14530a.a(i9);
        }
    }
}
