package com.xiaomi.push.service;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ay {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static String f18272A = "ext_broadcast_time";

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static String f18273B = "ext_sid";

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static String f18274C = "ext_token";

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static String f18275D = "ext_auth_method";

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static String f18276E = "ext_security";

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static String f18277F = "ext_kick";

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static String f18278G = "ext_client_attr";

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static String f18279H = "ext_cloud_attr";

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static String f18280I = "ext_pkg_name";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static String f18281J = "ext_notify_id";

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static String f18282K = "ext_clicked_button";

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static String f18283L = "ext_notify_type";

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static String f18284M = "ext_session";

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static String f18285N = "sig";
    public static String O = "ext_notify_title";

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static String f18286P = "ext_notify_description";

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static String f18287Q = "ext_messenger";

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static String f18288R = "dump";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18289a = "1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f18290b = "2";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f18291c = "3";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f18292d = "com.xiaomi.push.OPEN_CHANNEL";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f18293e = "com.xiaomi.push.SEND_MESSAGE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f18294f = "com.xiaomi.push.SEND_IQ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f18295g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f18296h = "com.xiaomi.push.SEND_PRES";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f18297i = "com.xiaomi.push.CLOSE_CHANNEL";
    public static String j = "com.xiaomi.push.FORCE_RECONN";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f18298k = "com.xiaomi.push.RESET_CONN";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f18299l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f18300m = "com.xiaomi.push.SEND_STATS";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f18301n = "com.xiaomi.push.HANDLE_FCM_MSG";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f18302o = "com.xiaomi.push.APP_NOTIFY_MSG";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f18303p = "com.xiaomi.push.SDK_START_ACTIVITY_EVENT_MSG";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f18304q = "com.xiaomi.push.SDK_LBS_PUSH_EVENT";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f18305r = "com.xiaomi.push.TRIGGER_PING";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f18306s = "com.xiaomi.push.CHANGE_HOST";
    public static String t = "com.xiaomi.push.PING_TIMER";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f18307u = "com.xiaomi.push.APP_CHANNEL_SWITCH";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static String f18308v = "ext_user_id";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f18309w = "ext_user_server";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f18310x = "ext_user_res";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f18311y = "ext_chid";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f18312z = "ext_receive_time";

    public enum a {
        DEFAULT_CACHE(0),
        NOTIFICATION_EXPOSURE_CACHE(1);


        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f1070a;

        a(int i9) {
            this.f1070a = i9;
        }

        public static a a(int i9) {
            a aVar = DEFAULT_CACHE;
            a aVar2 = NOTIFICATION_EXPOSURE_CACHE;
            return i9 == aVar2.f1070a ? aVar2 : aVar;
        }
    }

    public static String a(int i9) {
        switch (i9) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i9);
        }
    }
}
