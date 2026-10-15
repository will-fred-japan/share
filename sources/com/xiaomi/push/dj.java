package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static db f17231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static dc f257a;

    public static void a(Context context, gp gpVar) {
        if (m237b(context)) {
            if (f17231a == null) {
                f17231a = new db(context);
            }
            if (f257a == null) {
                f257a = new dc(context);
            }
            db dbVar = f17231a;
            gpVar.a(dbVar, dbVar);
            dc dcVar = f257a;
            gpVar.b(dcVar, dcVar);
            a("startStats");
        }
    }

    public static void b(Context context, gp gpVar) {
        db dbVar = f17231a;
        if (dbVar != null) {
            gpVar.a(dbVar);
            f17231a = null;
        }
        dc dcVar = f257a;
        if (dcVar != null) {
            gpVar.b(dcVar);
            f257a = null;
        }
        a("stopStats");
    }

    public static void c(Context context) {
        a("onPing");
        if (m237b(context)) {
            dm.a(context, System.currentTimeMillis(), m236a(context), com.xiaomi.push.service.p.a(context).m807a());
        }
    }

    public static void d(Context context) {
        a("onPong");
        if (m237b(context)) {
            dm.c(context, System.currentTimeMillis(), m236a(context));
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static boolean m237b(Context context) {
        return cz.a(context);
    }

    public static void a(Context context) {
        a("onSendMsg");
        if (m237b(context)) {
            dm.a(context, System.currentTimeMillis(), m236a(context));
        }
    }

    public static void b(Context context) {
        a("onReceiveMsg");
        if (m237b(context)) {
            dm.b(context, System.currentTimeMillis(), m236a(context));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m236a(Context context) {
        return j.m613b(context);
    }

    public static void a(String str) {
        cz.a("Push-PowerStats", str);
    }
}
