package com.xiaomi.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class eu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f17381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HandlerThread f390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final AtomicBoolean f391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final AtomicInteger f392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final AtomicReference<ew> f393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f17382b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final AtomicInteger f394b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final AtomicReference<String> f395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f17383c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private final AtomicReference<String> f396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f17384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f17385e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final eu f17401a = new eu();
    }

    private void b(ew ewVar, ew ewVar2, String str) {
        if (ewVar == null || ewVar2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (TextUtils.equals("startModemKeepAliveTimeOut", str)) {
                es.a().m354a();
                es.a().b(ewVar.mo367a(), "startModemKeepAliveTimeOut");
                es.a().e();
            }
            if (ewVar instanceof ey) {
                ep.a().j();
            } else if (ewVar2 instanceof ey) {
                ep.a().i();
            }
            if ((ewVar instanceof fc) && !(ewVar2 instanceof fd)) {
                ep.a().g();
            } else if ((ewVar2 instanceof fc) || (ewVar2 instanceof fd)) {
                ep.a().h();
            }
            ep.a().a(ewVar, ewVar2, str);
        } catch (Throwable th) {
            defpackage.f.q("[stat] exception occurred when record state change, exception: ", "HwKaMgr", th);
        }
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m363c() {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).mo372c();
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when socket receive msg, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void d() {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).d();
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when start ping, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void e() {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).e();
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when stop ping, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void f() {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).f();
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when fail too much, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void g() {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).g();
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when start modem keep alive time out, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    private eu() {
        this.f393a = new AtomicReference<>(new fd());
        this.f395b = new AtomicReference<>();
        this.f392a = new AtomicInteger();
        this.f396c = new AtomicReference<>();
        this.f394b = new AtomicInteger();
        this.f391a = new AtomicBoolean(false);
        this.f17382b = new AtomicBoolean(false);
        this.f17383c = new AtomicBoolean(et.c());
        this.f17384d = new AtomicBoolean(ax.m110a());
        this.f17385e = new AtomicBoolean(et.a());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m358a() {
        return this.f393a.get().mo367a();
    }

    public void a(ew ewVar, ew ewVar2, String str) {
        boolean z8;
        if (ewVar2 == null) {
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[stateSwitch] state change failed, nextState is empty");
            return;
        }
        if (ewVar == null) {
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[stateSwitch] state change failed, expectState is empty");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[stateSwitch] state change failed, event is empty");
            return;
        }
        try {
            String strMo367a = ewVar.mo367a();
            String strMo367a2 = ewVar2.mo367a();
            if (ewVar.getClass() == ewVar2.getClass()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[stateSwitch] switch state failed, because same state: " + strMo367a + "->" + strMo367a2 + " event:" + str);
                return;
            }
            AtomicReference<ew> atomicReference = this.f393a;
            while (true) {
                if (atomicReference.compareAndSet(ewVar, ewVar2)) {
                    z8 = true;
                    break;
                } else if (atomicReference.get() != ewVar) {
                    z8 = false;
                    break;
                }
            }
            if (z8) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[stateSwitch] switch state: " + strMo367a + "->" + strMo367a2 + " event:" + str);
                ewVar.a(ewVar2);
                ewVar2.b(ewVar);
            } else {
                com.xiaomi.channel.commonutils.logger.c.c("HwKaMgr", "[stateSwitch] switch state failed, because expect state: " + strMo367a + " current:" + this.f393a.get().mo367a());
            }
            fk.b();
            b(ewVar, ewVar2, str);
        } catch (Throwable th) {
            defpackage.f.q("[stateSwitch] exception occurred in changing state, exception: ", "HwKaMgr", th);
        }
    }

    public void c(final boolean z8) {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).c(z8);
                } catch (Throwable th) {
                    defpackage.f.q("[network]  exception occurred when mobile network changed, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void d(final boolean z8) {
        if (this.f17381a == null) {
            return;
        }
        this.f391a.set(z8);
        this.f17381a.post(new Runnable() { // from class: com.xiaomi.push.eu.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).d(z8);
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when update fall down state, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public String c() {
        return this.f396c.get();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m362b() {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).mo370b();
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when socket send msg, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void b(final boolean z8) {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).b(z8);
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when cloud config change, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void b(final String str) {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).b(str);
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when modem keep alive callback error, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m361b() {
        return this.f395b.get();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m359a() {
        if (this.f17381a == null) {
            HandlerThread handlerThread = new HandlerThread("eu");
            this.f390a = handlerThread;
            handlerThread.start();
            this.f17381a = new Handler(this.f390a.getLooper());
        }
        this.f17381a.post(new Runnable() { // from class: com.xiaomi.push.eu.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).mo368a();
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when init, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public int b() {
        return this.f394b.get();
    }

    public void a(final Socket socket) {
        if (this.f17381a == null) {
            return;
        }
        if (socket == null) {
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[socket] socket is null when socket connected");
            return;
        }
        InetAddress localAddress = socket.getLocalAddress();
        InetAddress inetAddress = socket.getInetAddress();
        if (localAddress == null || inetAddress == null) {
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[socket] local address or inet address is null when socket connected");
            return;
        }
        this.f17382b.set(true);
        this.f395b.set(localAddress.getHostAddress());
        this.f392a.set(socket.getLocalPort());
        this.f396c.set(inetAddress.getHostAddress());
        this.f394b.set(socket.getPort());
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[socket] update address info, source=" + this.f395b.get() + Constants.COLON_SEPARATOR + this.f392a.get() + ", target=" + this.f396c.get() + Constants.COLON_SEPARATOR + this.f394b.get());
        this.f17381a.post(new Runnable() { // from class: com.xiaomi.push.eu.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).a(socket);
                    ep.a().m349a();
                } catch (Throwable th) {
                    defpackage.f.q("[socket]  exception occurred when socket connected, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void a(final int i9, final Exception exc, final boolean z8) {
        if (this.f17381a == null) {
            return;
        }
        this.f17382b.set(false);
        this.f17381a.post(new Runnable() { // from class: com.xiaomi.push.eu.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).a(i9, exc, z8);
                    ep.a().c();
                } catch (Throwable th) {
                    defpackage.f.q("[socket]  exception occurred when socket closed, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void a(final boolean z8) {
        if (this.f17381a == null) {
            return;
        }
        this.f17383c.set(z8);
        this.f17381a.post(new Runnable() { // from class: com.xiaomi.push.eu.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).a(z8);
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when super power mode change, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void a(final String str) {
        Handler handler = this.f17381a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaomi.push.eu.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((ew) eu.this.f393a.get()).a(str);
                } catch (Throwable th) {
                    defpackage.f.q("[stateContext]  exception occurred when modem keep alive callback success, exception: ", "HwKaMgr", th);
                }
            }
        });
    }

    public void a(ay ayVar) {
        try {
            this.f17385e.set(et.a());
            this.f17384d.set(ax.e(ayVar));
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[network] network is change. isMobileNetworkConnected:" + this.f17384d.get());
            c(this.f17384d.get());
            ep.a().a(ayVar);
        } catch (Throwable th) {
            defpackage.f.q("[network]  exception occurred when network changed, exception: ", "HwKaMgr", th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m357a() {
        return this.f392a.get();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m360a() {
        try {
            if (!ev.a().m365a()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Unavailable. reason: not supported");
                return false;
            }
            if (!this.f17382b.get()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Unavailable. reason: socket is closed");
                return false;
            }
            if (es.a().m355a()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Unavailable. reason: fail too much");
                return false;
            }
            if (this.f391a.get()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Unavailable. reason: fall down");
                return false;
            }
            if (!et.b()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Unavailable. reason: cloud config is not enable");
                return false;
            }
            if (!this.f17384d.get()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Unavailable. reason:mobile network is disconnected");
                return false;
            }
            if (this.f17383c.get()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Unavailable. reason: super power mode enable");
                return false;
            }
            if (!this.f17385e.get()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Unavailable. reason: data card not supported");
                return false;
            }
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Available] MdKa is Available.");
            return true;
        } catch (Throwable th) {
            defpackage.f.q("[Available]  exception occurred when check keep alive function availability, exception: ", "HwKaMgr", th);
            return false;
        }
    }

    public boolean a(Class<? extends ew> cls) {
        if (cls == null) {
            return false;
        }
        return cls.isInstance(this.f393a.get());
    }

    public static eu a() {
        return a.f17401a;
    }
}
