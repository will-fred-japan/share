package cn.jpush.android.helper;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<Long, String> f11423a;

    static {
        HashMap<Long, String> map = new HashMap<>();
        f11423a = map;
        map.put(1060L, "need not show notification by foreground");
        map.put(1061L, "need not show notification by isNeedShowNotification return false");
        map.put(1032L, "MSG already cancle");
        map.put(1033L, "overide msg already cancle");
        map.put(1034L, "MSG already end");
        map.put(1035L, "msg delay show");
        map.put(1036L, "notification disabled");
        map.put(1037L, "notification channel disabled");
        map.put(972L, "Deep link set small icon failed");
        map.put(973L, "Deep link set large icon failed");
        map.put(976L, "Deep link jump success");
        map.put(977L, "Deep link jump failed");
        map.put(978L, "Fail Deep link jump success");
        map.put(979L, "Fail Deep link jump failed");
        map.put(993L, "target app uninstall,not found target app small icon");
        map.put(986L, "Message is not in push time");
        map.put(988L, "Deep link target app uninstalled");
        map.put(995L, "Message JSON parsing succeed");
        map.put(996L, "Message JSON parsing failed");
        map.put(1000L, "User clicked and opened the Message");
        map.put(1028L, "User clicked and opened the Message from JPushInterface.reportNotificationOpened");
        map.put(1068L, "User clear the JPush Notification from JPushReportHelper.reportMsgResult");
        map.put(1069L, "User clear the OS Push Notification from JPushReportHelper.reportThirdSDKMsgActionResult");
        map.put(1006L, "User clicked 'Cancel'");
        map.put(1100L, "Invalid param or unexpected result.");
        map.put(1014L, "Failed to preload required resource");
        map.put(1016L, "User clicked the webview's url");
        map.put(1018L, "The Message show in the status bar");
        map.put(1020L, "Down image failed");
        map.put(1021L, "Down html failed");
        map.put(1075L, "Open WX miniprogram failed");
        map.put(1080L, "show notification make unknown error");
        map.put(1106L, "the custom message show");
        map.put(3082L, "float shell activity start dispatched");
        map.put(3088L, "float shell activity content attached success");
    }

    private static long a(byte b9) {
        switch (b9) {
            case 1:
                return 11000000L;
            case 2:
                return 12000000L;
            case 3:
                return 13000000L;
            case 4:
                return 14000000L;
            case 5:
                return 15000000L;
            case 6:
                return 16000000L;
            case 7:
                return 17000000L;
            case 8:
                return 18000000L;
            default:
                return 10000000L;
        }
    }

    public static long a(byte b9, int i9, long j) {
        return a(b9) + a(i9) + j;
    }

    private static long a(int i9) {
        if (i9 == 1) {
            return 100000L;
        }
        if (i9 == 2) {
            return 110000L;
        }
        if (i9 != 3) {
            return i9 != 4 ? -1L : 130000L;
        }
        return 120000L;
    }

    public static long a(int i9, long j) {
        return a((byte) 0, i9, j);
    }

    public static String a(long j) {
        HashMap<Long, String> map = f11423a;
        if (map.get(Long.valueOf(j)) != null) {
            return map.get(Long.valueOf(j));
        }
        Logger.d("StatusCode", "Unknown report code - " + j);
        return "";
    }
}
