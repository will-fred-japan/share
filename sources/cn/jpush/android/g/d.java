package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import cn.asus.push.DataBuffer;
import cn.asus.push.g;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private cn.asus.push.d f11398b = null;

    public static /* synthetic */ cn.asus.push.d a(d dVar, cn.asus.push.d dVar2) {
        dVar.f11398b = null;
        return null;
    }

    @Override // cn.jpush.android.g.a
    public final boolean b() {
        cn.asus.push.d dVar = this.f11398b;
        if (dVar == null) {
            return false;
        }
        return dVar.asBinder().isBinderAlive();
    }

    @Override // cn.jpush.android.g.a
    public final void a(String str, String str2) {
        String str3;
        if (this.f11398b != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("JPUSH_CONTENT", str2);
                DataBuffer dataBuffer = new DataBuffer();
                dataBuffer.f8781a = str;
                dataBuffer.f8782b = bundle;
                this.f11398b.f(dataBuffer, new b());
                return;
            } catch (Throwable th) {
                str3 = "send data fail:" + th;
            }
        } else {
            str3 = "send data fail, please init first.";
        }
        cn.jpush.android.i.b.g("ServiceConnection", str3);
    }

    @Override // cn.jpush.android.g.a
    public final boolean a() {
        cn.asus.push.d dVar;
        byte b9 = 0;
        if (a.f11397a.get()) {
            cn.jpush.android.i.b.b("ServiceConnection", "already connecting.");
            return false;
        }
        a.f11397a.set(true);
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(cn.jpush.android.f.c.f11382e, "cn.jpush.android.service.PushManagerService"));
            e eVar = new e(this, b9);
            boolean zBindService = cn.jpush.android.f.c.f11378a.bindService(intent, eVar, 1);
            cn.jpush.android.i.b.b("ServiceConnection", "connect--" + zBindService);
            if (!zBindService) {
                a.f11397a.set(false);
                return zBindService;
            }
            IBinder iBinderTake = eVar.f11399a.take();
            int i9 = cn.asus.push.c.f8783a;
            if (iBinderTake == null) {
                dVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinderTake.queryLocalInterface("cn.asus.push.IAIDLInvoke");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof cn.asus.push.d)) {
                    g gVar = new g();
                    gVar.f8786a = iBinderTake;
                    dVar = gVar;
                } else {
                    dVar = (cn.asus.push.d) iInterfaceQueryLocalInterface;
                }
            }
            this.f11398b = dVar;
            return zBindService;
        } catch (Throwable th) {
            cn.jpush.android.i.b.g("ServiceConnection", "init fail:" + th);
            a.f11397a.set(false);
            return false;
        }
    }
}
