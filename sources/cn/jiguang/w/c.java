package cn.jiguang.w;

import android.content.Context;
import cn.jpush.android.api.JPushInterface;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f10835a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f10836b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10837c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f10838d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f10839e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f10840f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f10841g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f10842h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static AtomicInteger f10843i = new AtomicInteger(0);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f10844a = new c();
    }

    private c() {
        f10835a = f();
        f10836b = g();
        f10837c = h();
        f10838d = i();
        f10839e = j();
        f10840f = k();
        f10841g = l();
        f10842h = m();
    }

    public static c a() {
        return a.f10844a;
    }

    public static boolean b() {
        return (!f10835a || f10839e || f10836b || f10837c || f10838d || f10840f || f10841g || f10842h) ? false : true;
    }

    public static boolean c() {
        return (!f10842h || f10839e || f10836b || f10837c || f10838d || f10840f || f10841g || f10835a) ? false : true;
    }

    private static boolean f() {
        int i9;
        boolean z8 = false;
        try {
            if ((f10843i.intValue() & 1) != 0) {
                cn.jiguang.x.f.c("JClientsHelper", "p jpush init");
                return f10835a;
            }
            int iAddAndGet = f10843i.addAndGet(1);
            try {
                String str = JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX;
                z8 = true;
            } catch (ClassNotFoundException e9) {
                i9 = iAddAndGet;
                e = e9;
                cn.jiguang.x.f.a("JClientsHelper", "isPluginJpushSDK:" + e.getMessage());
                iAddAndGet = i9;
            }
            cn.jiguang.x.f.a("JClientsHelper", "isPluginJpushSDK:" + z8 + ", mPluginInitState: " + iAddAndGet);
            return z8;
        } catch (ClassNotFoundException e10) {
            e = e10;
            i9 = 0;
        }
    }

    private static boolean g() {
        int i9;
        boolean z8 = false;
        try {
            if ((f10843i.intValue() & 2) != 0) {
                cn.jiguang.x.f.c("JClientsHelper", "p jmessage init");
                return f10836b;
            }
            int iAddAndGet = f10843i.addAndGet(2);
            try {
                Class.forName("cn.jpush.im.android.api.JMessageClient");
                z8 = true;
            } catch (ClassNotFoundException e9) {
                i9 = iAddAndGet;
                e = e9;
                cn.jiguang.x.f.a("JClientsHelper", "isPluginJMessageSDK:" + e.getMessage());
                iAddAndGet = i9;
            }
            cn.jiguang.x.f.a("JClientsHelper", "isPluginJMessageSDK:" + z8 + ", pluginState: " + iAddAndGet);
            return z8;
        } catch (ClassNotFoundException e10) {
            e = e10;
            i9 = 0;
        }
    }

    private static boolean h() {
        int i9;
        boolean z8 = false;
        try {
            if ((f10843i.intValue() & 4) != 0) {
                cn.jiguang.x.f.c("JClientsHelper", "p janalytics init");
                return f10837c;
            }
            int iAddAndGet = f10843i.addAndGet(4);
            try {
                Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
                z8 = true;
            } catch (ClassNotFoundException e9) {
                i9 = iAddAndGet;
                e = e9;
                cn.jiguang.x.f.a("JClientsHelper", "isPluginJanalyticsSDK:" + e.getMessage());
                iAddAndGet = i9;
            }
            cn.jiguang.x.f.a("JClientsHelper", "isPluginJanalyticsSDK:" + z8 + ", pluginState: " + iAddAndGet);
            return z8;
        } catch (ClassNotFoundException e10) {
            e = e10;
            i9 = 0;
        }
    }

    private static boolean i() {
        int i9;
        boolean z8 = false;
        try {
            if ((f10843i.intValue() & 8) != 0) {
                cn.jiguang.x.f.c("JClientsHelper", "p jshare init");
                return f10838d;
            }
            int iAddAndGet = f10843i.addAndGet(8);
            try {
                Class.forName("cn.jiguang.share.android.api.JShareInterface");
                z8 = true;
            } catch (ClassNotFoundException e9) {
                i9 = iAddAndGet;
                e = e9;
                cn.jiguang.x.f.a("JClientsHelper", "isPluginJshareSDK:" + e.getMessage());
                iAddAndGet = i9;
            }
            cn.jiguang.x.f.a("JClientsHelper", "isPluginJshareSDK:" + z8 + ", pluginState: " + iAddAndGet);
            return z8;
        } catch (ClassNotFoundException e10) {
            e = e10;
            i9 = 0;
        }
    }

    private static boolean j() {
        int i9;
        boolean z8 = false;
        try {
            if ((f10843i.intValue() & 64) != 0) {
                cn.jiguang.x.f.c("JClientsHelper", "p jverification init");
                return f10839e;
            }
            int iAddAndGet = f10843i.addAndGet(64);
            try {
                Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
                z8 = true;
            } catch (ClassNotFoundException e9) {
                i9 = iAddAndGet;
                e = e9;
                cn.jiguang.x.f.a("JClientsHelper", "isPluginJVerificationSDK:" + e.getMessage());
                iAddAndGet = i9;
            }
            cn.jiguang.x.f.a("JClientsHelper", "isPluginJVerificationSDK:" + z8 + ", pluginState: " + iAddAndGet);
            return z8;
        } catch (ClassNotFoundException e10) {
            e = e10;
            i9 = 0;
        }
    }

    private static boolean k() {
        int i9;
        boolean z8 = false;
        try {
            if ((f10843i.intValue() & 128) != 0) {
                cn.jiguang.x.f.c("JClientsHelper", "p jmlink init");
                return f10840f;
            }
            int iAddAndGet = f10843i.addAndGet(128);
            try {
                Class.forName("cn.jiguang.jmlinksdk.core.JMlinkInterfaceImpl");
                z8 = true;
            } catch (ClassNotFoundException e9) {
                i9 = iAddAndGet;
                e = e9;
                cn.jiguang.x.f.a("JClientsHelper", "isPluginJMLinkSDK:" + e.getMessage());
                iAddAndGet = i9;
            }
            cn.jiguang.x.f.a("JClientsHelper", "isPluginJMLinkSDK:" + z8 + ", pluginState: " + iAddAndGet);
            return z8;
        } catch (ClassNotFoundException e10) {
            e = e10;
            i9 = 0;
        }
    }

    private static boolean l() {
        int i9;
        boolean z8 = false;
        try {
            if ((f10843i.intValue() & 256) != 0) {
                cn.jiguang.x.f.c("JClientsHelper", "p junion init");
                return f10841g;
            }
            int iAddAndGet = f10843i.addAndGet(256);
            try {
                Class.forName("cn.jiguang.junion.JUnionInterface");
                z8 = true;
            } catch (ClassNotFoundException e9) {
                i9 = iAddAndGet;
                e = e9;
                cn.jiguang.x.f.a("JClientsHelper", "isPluginJUnionSDK:" + e.getMessage());
                iAddAndGet = i9;
            }
            cn.jiguang.x.f.a("JClientsHelper", "isPluginJUnionSDK:" + z8 + ", pluginState: " + iAddAndGet);
            return z8;
        } catch (ClassNotFoundException e10) {
            e = e10;
            i9 = 0;
        }
    }

    private static boolean m() {
        int i9;
        boolean z8 = false;
        try {
            if ((f10843i.intValue() & OpusCodecConfig.APPLICATION_VOIP) != 0) {
                cn.jiguang.x.f.c("JClientsHelper", "p joperate init");
                return f10842h;
            }
            int iAddAndGet = f10843i.addAndGet(OpusCodecConfig.APPLICATION_VOIP);
            try {
                Class.forName("cn.jiguang.joperate.api.JOperateInterface");
                z8 = true;
            } catch (ClassNotFoundException e9) {
                i9 = iAddAndGet;
                e = e9;
                cn.jiguang.x.f.a("JClientsHelper", "isPluginJOperateSDK:" + e.getMessage());
                iAddAndGet = i9;
            }
            cn.jiguang.x.f.a("JClientsHelper", "isPluginJOperateSDK:" + z8 + ", pluginState: " + iAddAndGet);
            return z8;
        } catch (ClassNotFoundException e10) {
            e = e10;
            i9 = 0;
        }
    }

    public boolean d() {
        return f10836b;
    }

    public boolean e() {
        return f10835a;
    }

    public boolean a(Context context) {
        boolean z8 = f10836b || f10835a;
        cn.jiguang.x.f.c("JClientsHelper", "isNeedKeepTcpConnect:" + z8);
        return z8;
    }
}
