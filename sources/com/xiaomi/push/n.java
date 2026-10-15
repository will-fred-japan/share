package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Handler f18124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f925a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f18125b;

    public static Handler a() {
        if (f18125b == null) {
            synchronized (f925a) {
                try {
                    if (f18125b == null) {
                        HandlerThread handlerThread = new HandlerThread("receiver_task");
                        handlerThread.start();
                        f18125b = new Handler(handlerThread.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18125b;
    }

    private static Handler b() {
        if (f18124a == null) {
            synchronized (n.class) {
                try {
                    if (f18124a == null) {
                        HandlerThread handlerThread = new HandlerThread("handle_receiver");
                        handlerThread.start();
                        f18124a = new Handler(handlerThread.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18124a;
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return a(context, broadcastReceiver, intentFilter, 2);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i9) {
        return a(context, broadcastReceiver, intentFilter, (String) null, i9);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i9) {
        return a(context, broadcastReceiver, intentFilter, str, b(), i9);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return a(context, broadcastReceiver, intentFilter, str, handler, 2);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i9) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i9);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    public static Intent a(Context context, IntentFilter intentFilter) {
        if (context != null && intentFilter != null && intentFilter.countActions() != 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                return context.registerReceiver(null, intentFilter, null, null, 4);
            }
            return context.registerReceiver(null, intentFilter, null, null);
        }
        com.xiaomi.channel.commonutils.logger.c.c("ReceiverHelper", "Invalid parameters for registerStickyBroadcastReceiver");
        return null;
    }
}
