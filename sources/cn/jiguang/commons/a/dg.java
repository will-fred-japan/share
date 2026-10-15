package cn.jiguang.commons.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f9875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9876b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static dg f9877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static df f9878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f9879e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static HandlerThread f9880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Handler f9881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f9882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f9883i;
    private static String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f9884k;

    private dg() {
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020 A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:6:0x0007, B:8:0x000b, B:10:0x0020, B:50:0x00de, B:13:0x0028, B:15:0x0036, B:17:0x003c, B:29:0x007d, B:30:0x0091, B:39:0x00a7, B:49:0x00dd, B:48:0x00c6, B:51:0x00f3, B:44:0x00c0, B:35:0x00a1, B:25:0x0077, B:33:0x0096), top: B:60:0x0007, inners: #0, #2, #5, #6 }] */
    public static dg a(Context context) {
        Cursor cursorQuery;
        String str;
        String str2;
        if (f9877c == null) {
            synchronized (dg.class) {
                try {
                    if (f9877c == null) {
                        f9877c = new dg();
                        f9875a = context;
                        f9878d = new df(context);
                        Context context2 = f9875a;
                        if (context2 == null) {
                            f9876b = false;
                        } else {
                            PackageManager packageManager = context2.getPackageManager();
                            String str3 = f.f10031c;
                            String strB = km.b("rIjLIWp9yd1+l2BByOWYjPjGCBlvF2tDounrABnhodw=", str3);
                            if (packageManager == null || packageManager.resolveContentProvider(strB, 0) == null) {
                                f9876b = false;
                            } else {
                                try {
                                    cursorQuery = context2.getContentResolver().query(Uri.parse(km.b("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO", str3)), null, null, new String[]{"supported"}, null);
                                    if (cursorQuery != null) {
                                        try {
                                            cursorQuery.moveToFirst();
                                            int columnIndex = cursorQuery.getColumnIndex("value");
                                            if (columnIndex >= 0) {
                                                f9876b = "0".equals(cursorQuery.getString(columnIndex));
                                            } else {
                                                f9876b = false;
                                            }
                                        } catch (Throwable unused) {
                                            try {
                                                ee.a("MeizuIdManager", "mz not support");
                                                f9876b = false;
                                                if (cursorQuery != null) {
                                                    try {
                                                        cursorQuery.close();
                                                    } catch (Throwable th) {
                                                        str = "MeizuIdManager";
                                                        str2 = "close cursor error: " + th.getMessage();
                                                        ee.a(str, str2);
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                if (cursorQuery == null) {
                                                    throw th2;
                                                }
                                                try {
                                                    cursorQuery.close();
                                                    throw th2;
                                                } catch (Throwable th3) {
                                                    ee.a("MeizuIdManager", "close cursor error: " + th3.getMessage());
                                                    throw th2;
                                                }
                                            }
                                        }
                                    }
                                    if (cursorQuery != null) {
                                        try {
                                            cursorQuery.close();
                                        } catch (Throwable th4) {
                                            str = "MeizuIdManager";
                                            str2 = "close cursor error: " + th4.getMessage();
                                            ee.a(str, str2);
                                        }
                                    }
                                } catch (Throwable unused2) {
                                    cursorQuery = null;
                                }
                            }
                        }
                        ee.a("MeizuIdManager", "check meizu supported:" + f9876b);
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
        }
        return f9877c;
    }

    private static void d() {
        HandlerThread handlerThread = f9880f;
        if (handlerThread != null && handlerThread.isAlive()) {
            try {
                f9880f.quitSafely();
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("quit thread err: "), "MeizuIdManager");
            }
        }
        f9880f = null;
        f9881g = null;
    }

    public final String a() {
        String str;
        String str2;
        if (!f9876b) {
            return null;
        }
        String str3 = f9883i;
        if (str3 != null) {
            return str3;
        }
        HandlerThread handlerThread = f9880f;
        if (handlerThread == null || !handlerThread.isAlive()) {
            HandlerThread handlerThread2 = new HandlerThread("jg_c_meizu_db");
            f9880f = handlerThread2;
            handlerThread2.start();
            f9881g = new dh(f9880f.getLooper());
        }
        try {
            synchronized (f9879e) {
                Message messageObtainMessage = f9881g.obtainMessage();
                messageObtainMessage.what = 11;
                Bundle bundle = new Bundle();
                bundle.putString("type", km.b("ggTIEepvzybHoO4C7/s5eQ==", f.f10031c));
                messageObtainMessage.setData(bundle);
                f9881g.sendMessage(messageObtainMessage);
                long jUptimeMillis = SystemClock.uptimeMillis();
                try {
                    f9879e.wait(2000L);
                } catch (InterruptedException e9) {
                    ee.d("MeizuIdManager", "lock wait err: " + e9.getMessage());
                }
                if (SystemClock.uptimeMillis() - jUptimeMillis < 2000) {
                    f9883i = f9882h;
                    f9882h = null;
                    str = "MeizuIdManager";
                    str2 = "query aaid: " + f9883i;
                } else {
                    str = "MeizuIdManager";
                    str2 = "query timeout";
                }
                ee.a(str, str2);
            }
            d();
            return f9883i;
        } catch (Throwable th) {
            d();
            throw th;
        }
    }
}
