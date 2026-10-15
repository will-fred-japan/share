package com.xiaomi.push.service;

import com.xiaomi.push.it;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f18364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f1110a;

    public interface a {
        boolean a(it itVar);
    }

    public interface b {
        void a(it itVar, boolean z8);
    }

    public static void a(b bVar) {
        f1110a = bVar;
    }

    public static void a(it itVar) {
        a(itVar, false);
    }

    public static void a(it itVar, boolean z8) {
        if (f1110a != null && itVar != null) {
            if (!com.xiaomi.push.k.m649a(com.xiaomi.push.t.m835a())) {
                com.xiaomi.channel.commonutils.logger.c.m9a("rp app not permission to cpra");
                return;
            } else {
                f1110a.a(itVar, z8);
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("rp params is null, not cpra");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m788a(it itVar) {
        if (f18364a != null && itVar != null) {
            if (!com.xiaomi.push.k.m649a(com.xiaomi.push.t.m835a())) {
                com.xiaomi.channel.commonutils.logger.c.m9a("rc app not permission to cpra");
                return false;
            }
            return f18364a.a(itVar);
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("rc params is null, not cpra");
        return false;
    }
}
