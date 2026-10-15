package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<a> f18359a = new CopyOnWriteArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18360a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f1106a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1107a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f1108a;

        public a(String str, long j, int i9, Notification.Action[] actionArr) {
            this.f1107a = str;
            this.f1106a = j;
            this.f18360a = i9;
            this.f1108a = actionArr;
        }
    }

    public static void a(Context context, StatusBarNotification statusBarNotification, int i9) {
        if (!com.xiaomi.push.k.m649a(context) || i9 <= 0 || statusBarNotification == null) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i9, ao.m750a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        f18359a.add(aVar);
        a();
    }

    private static void a() {
        for (int size = f18359a.size() - 1; size >= 0; size--) {
            a aVar = f18359a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f1106a > com.heytap.mcssdk.constant.a.f14256r) {
                f18359a.remove(aVar);
            }
        }
        if (f18359a.size() > 10) {
            f18359a.remove(0);
        }
    }
}
