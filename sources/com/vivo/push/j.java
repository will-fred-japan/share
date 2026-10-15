package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.ad;
import com.vivo.push.util.ak;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: IPCManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f16673a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, j> f16674b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f16677e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile IPCInvoke f16679g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f16681i;
    private Handler j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f16680h = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f16678f = new AtomicInteger(1);

    private j(Context context, String str) {
        this.f16676d = null;
        this.j = null;
        this.f16677e = context;
        this.f16681i = str;
        this.j = new Handler(Looper.getMainLooper(), new k(this));
        String strA = ad.a(context);
        this.f16676d = strA;
        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(this.f16681i)) {
            this.f16675c = ak.a(context, this.f16676d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.w.c("init error : push pkgname is " + this.f16676d + " ; action is " + this.f16681i);
        this.f16675c = false;
    }

    private void d() {
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, 3000L);
    }

    private void e() {
        this.j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.f16677e.unbindService(this);
        } catch (Exception e9) {
            A.f.m(e9, new StringBuilder("On unBindServiceException:"), "AidlManager");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.w.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.f16679g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f16679g == null) {
            com.vivo.push.util.w.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f16678f.set(1);
            return;
        }
        if (this.f16678f.get() == 2) {
            a(4);
        } else if (this.f16678f.get() != 4) {
            f();
        }
        synchronized (this.f16680h) {
            this.f16680h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f16679g = null;
        a(1);
    }

    public static j a(Context context, String str) {
        j jVar;
        j jVar2 = f16674b.get(str);
        if (jVar2 != null) {
            return jVar2;
        }
        synchronized (f16673a) {
            try {
                jVar = f16674b.get(str);
                if (jVar == null) {
                    jVar = new j(context, str);
                    f16674b.put(str, jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    private void b() {
        int i9 = this.f16678f.get();
        com.vivo.push.util.w.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i9)));
        if (i9 == 4 || i9 == 2 || i9 == 3 || i9 == 5 || !this.f16675c) {
            return;
        }
        a(2);
        if (c()) {
            d();
        } else {
            a(1);
            com.vivo.push.util.w.a("AidlManager", "bind core service fail");
        }
    }

    private boolean c() {
        Intent intent = new Intent(this.f16681i);
        intent.setPackage(this.f16676d);
        try {
            return this.f16677e.bindService(intent, this, 1);
        } catch (Exception e9) {
            com.vivo.push.util.w.a("AidlManager", "bind core error", e9);
            return false;
        }
    }

    public final boolean a() {
        String strA = ad.a(this.f16677e);
        this.f16676d = strA;
        if (TextUtils.isEmpty(strA)) {
            com.vivo.push.util.w.c("push pkgname is null");
            return false;
        }
        boolean z8 = ak.a(this.f16677e, this.f16676d) >= 1260;
        this.f16675c = z8;
        return z8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i9) {
        this.f16678f.set(i9);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f16678f.get() == 2) {
            synchronized (this.f16680h) {
                try {
                    this.f16680h.wait(2000L);
                } catch (InterruptedException e9) {
                    e9.printStackTrace();
                }
            }
        }
        try {
            int i9 = this.f16678f.get();
            if (i9 == 4) {
                this.j.removeMessages(2);
                this.j.sendEmptyMessageDelayed(2, 30000L);
                this.f16679g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.w.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i9)));
            return false;
        } catch (Exception e10) {
            com.vivo.push.util.w.a("AidlManager", "invoke error ", e10);
            int i10 = this.f16678f.get();
            com.vivo.push.util.w.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i10)));
            if (i10 == 2) {
                e();
                a(1);
                return false;
            }
            if (i10 == 3) {
                a(1);
                return false;
            }
            if (i10 != 4) {
                return false;
            }
            a(1);
            f();
            return false;
        }
    }
}
