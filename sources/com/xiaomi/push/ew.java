package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.net.Socket;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ew {
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract String mo367a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo368a() {
    }

    public abstract void a(ew ewVar);

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void mo370b() {
    }

    public abstract void b(ew ewVar);

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void mo372c() {
    }

    public void d() {
    }

    public void h() {
        Context contextM835a = t.m835a();
        if (contextM835a == null) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[" + mo367a() + "]  trigger a ping package");
        Intent intent = new Intent();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.xmsf.push.service.XMPushService");
        intent.putExtra("mipush_app_package", "com.xiaomi.xmsf");
        intent.setAction(com.xiaomi.push.service.ay.f18305r);
        contextM835a.startService(intent);
    }

    public void a(int i9, Exception exc, boolean z8) {
    }

    public void b(String str) {
    }

    public void c(boolean z8) {
    }

    public void d(boolean z8) {
    }

    public void a(String str) {
    }

    public void b(boolean z8) {
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m371c() {
        return eu.a().c();
    }

    public static int c() {
        int iB = gv.b();
        Context contextM835a = t.m835a();
        if (contextM835a == null) {
            return iB;
        }
        int iA = com.xiaomi.push.service.aq.a(contextM835a).a(hz.HWHeartbeatInterval.a(), iB);
        if (210000 <= iA && iA <= iB) {
            return iA;
        }
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "illegal ping interval. configInterval:" + iA);
        return iB;
    }

    public void a(Socket socket) {
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m369b() {
        return eu.a().m361b();
    }

    public void a(boolean z8) {
    }

    public int b() {
        return eu.a().b();
    }

    public void a(ew ewVar, String str) {
        if (ewVar != null && !TextUtils.isEmpty(str)) {
            m366a().a(this, ewVar, str);
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[" + mo367a() + "] next state or event is null when setting state");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public eu m366a() {
        return eu.a();
    }

    public int a() {
        return eu.a().m357a();
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }
}
