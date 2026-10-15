package cn.jiguang.commons.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class dq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f9900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9901b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static dq f9902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static dp f9903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f9904e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static HandlerThread f9905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Handler f9906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f9907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f9908i;
    private static String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f9909k;

    private dq() {
    }

    public static dq a(Context context) {
        if (f9902c == null) {
            synchronized (dq.class) {
                try {
                    if (f9902c == null) {
                        f9902c = new dq();
                        f9900a = context;
                        f9903d = new dp(context);
                        f9901b = "1".equals(ks.a("persist.sys.identifierid.supported", "0"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9902c;
    }

    private static void d() {
        HandlerThread handlerThread = f9905f;
        if (handlerThread != null && handlerThread.isAlive()) {
            try {
                f9905f.quitSafely();
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("quit thread err: "), "VivoIdManager");
            }
        }
        f9905f = null;
        f9906g = null;
    }

    public final String a() {
        if (!f9901b) {
            return null;
        }
        String str = f9908i;
        if (str != null) {
            return str;
        }
        HandlerThread handlerThread = f9905f;
        if (handlerThread == null || !handlerThread.isAlive()) {
            HandlerThread handlerThread2 = new HandlerThread("jg_c_vivo_db");
            f9905f = handlerThread2;
            handlerThread2.start();
            f9906g = new dr(f9905f.getLooper());
        }
        try {
            synchronized (f9904e) {
                Message messageObtainMessage = f9906g.obtainMessage();
                messageObtainMessage.what = 11;
                Bundle bundle = new Bundle();
                bundle.putInt("type", 0);
                messageObtainMessage.setData(bundle);
                f9906g.sendMessage(messageObtainMessage);
                long jUptimeMillis = SystemClock.uptimeMillis();
                try {
                    f9904e.wait(2000L);
                } catch (InterruptedException e9) {
                    ee.d("VivoIdManager", "lock wait error: " + e9.getMessage());
                }
                if (SystemClock.uptimeMillis() - jUptimeMillis < 2000) {
                    f9908i = f9907h;
                    f9907h = null;
                } else {
                    ee.a("VivoIdManager", "query timeout");
                }
            }
            d();
            return f9908i;
        } catch (Throwable th) {
            d();
            throw th;
        }
    }
}
