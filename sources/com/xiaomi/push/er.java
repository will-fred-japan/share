package com.xiaomi.push;

import java.net.Socket;

/* JADX INFO: loaded from: classes2.dex */
public class er {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final er f17374a = new er();
    }

    public static er a() {
        return a.f17374a;
    }

    public void b() {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[socket] receive message");
        eu.a().m363c();
    }

    public void c() {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[ping] start ping action");
        eu.a().d();
    }

    public void d() {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[ping] stop ping action");
        eu.a().e();
    }

    public void e() {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "modem keep alive function fail too much.");
        eu.a().f();
    }

    public void f() {
        es.a().c();
    }

    private er() {
        try {
            boolean zM365a = ev.a().m365a();
            if (zM365a) {
                ev.a().a(new ev.b() { // from class: com.xiaomi.push.er.1
                    @Override // com.xiaomi.push.ev.b
                    public void a(String str) {
                        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Modem Callback] onTcpKaInd, result=" + str);
                        if ("KEEP_ALIVE_RESULT_OK".equals(str)) {
                            eu.a().a(str);
                            es.a().d();
                        } else {
                            String strM358a = eu.a().m358a();
                            eu.a().b(str);
                            es.a().a(str, strM358a);
                            es.a().b(strM358a, "modemKeepAliveCallbackError");
                            es.a().e();
                        }
                        ep.a().a(str);
                    }
                });
                com.xiaomi.push.service.aq.a(t.m835a()).a(new com.xiaomi.push.service.aq.a(hz.MdKaSwitch.a(), "MdKaSwitch") { // from class: com.xiaomi.push.er.2
                    @Override // com.xiaomi.push.service.aq.a
                    public void onCallback() {
                        boolean zB = et.b();
                        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[config] config is change. isMdKaCloudEnabled:" + zB);
                        eu.a().b(zB);
                    }
                });
                eu.a().m359a();
                a(ax.m104a());
            }
            es.a().a(zM365a);
        } catch (Throwable th) {
            defpackage.f.q("[init]  exception occurred when HwKaManager init, exception: ", "HwKaMgr", th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m352a() {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[socket] send message");
        eu.a().m362b();
    }

    public void b(boolean z8) {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "update fall down state: " + z8);
        eu.a().d(z8);
    }

    public void a(Socket socket) {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[socket] socket connected");
        eu.a().a(socket);
    }

    public void a(int i9, Exception exc) {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[socket] socket is closed.reason:" + i9 + " exception:" + exc);
        eu.a().a(i9, exc, ax.m110a());
    }

    public void a(ay ayVar) {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[network] network change");
        eu.a().a(ayVar);
    }

    public void a(boolean z8) {
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "super power mode is changed. enable:" + z8);
        eu.a().a(z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m353a() {
        return eu.a().m360a();
    }
}
