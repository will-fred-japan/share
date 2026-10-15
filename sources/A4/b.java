package A4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.starburst.sdk.api.GuiControlConfig;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static EnumC0001b f1457a = EnumC0001b.UNKNOWN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f1458b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f1459c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1460d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f1461e = -1;

    /* JADX INFO: compiled from: NetworkUtils.java */
    public static class a extends PhoneStateListener {
        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i9, int i10) {
            super.onDataConnectionStateChanged(i9, i10);
            b.f1461e = i10;
        }
    }

    /* JADX INFO: renamed from: A4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NetworkUtils.java */
    public enum EnumC0001b {
        UNKNOWN(-1),
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6),
        WIFI_24GHZ(7),
        WIFI_5GHZ(8),
        MOBILE_3G_H(9),
        MOBILE_3G_HP(10);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1474a;

        EnumC0001b(int i9) {
            this.f1474a = i9;
        }
    }

    public static String a(EnumC0001b enumC0001b) {
        if (enumC0001b == EnumC0001b.WIFI) {
            return "wifi";
        }
        if (enumC0001b == EnumC0001b.WIFI_24GHZ) {
            return "wifi24ghz";
        }
        if (enumC0001b == EnumC0001b.WIFI_5GHZ) {
            return "wifi5ghz";
        }
        if (enumC0001b == EnumC0001b.MOBILE_2G) {
            return MTCommonConstants.Network.NAME_2G;
        }
        if (enumC0001b == EnumC0001b.MOBILE_3G) {
            return MTCommonConstants.Network.NAME_3G;
        }
        if (enumC0001b == EnumC0001b.MOBILE_3G_H) {
            return "3gh";
        }
        if (enumC0001b == EnumC0001b.MOBILE_3G_HP) {
            return "3ghp";
        }
        if (enumC0001b == EnumC0001b.MOBILE_4G) {
            return MTCommonConstants.Network.NAME_4G;
        }
        if (enumC0001b == EnumC0001b.MOBILE_5G) {
            return MTCommonConstants.Network.NAME_5G;
        }
        return enumC0001b == EnumC0001b.MOBILE ? "mobile" : "";
    }

    public static EnumC0001b b(Context context) {
        if (f1457a == EnumC0001b.UNKNOWN) {
            f1457a = c(context);
        }
        if (System.currentTimeMillis() - f1458b > 2000) {
            f1457a = c(context);
            f1458b = System.currentTimeMillis();
        }
        return f1457a;
    }

    public static EnumC0001b c(Context context) {
        int i9;
        EnumC0001b enumC0001b;
        EnumC0001b enumC0001b2 = EnumC0001b.MOBILE;
        try {
            if (!f1460d) {
                try {
                    ((TelephonyManager) context.getSystemService(GuiControlConfig.DEVICE_PHONE)).listen(new a(), 64);
                    f1460d = true;
                } catch (Exception unused) {
                }
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            EnumC0001b enumC0001b3 = EnumC0001b.NONE;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                EnumC0001b enumC0001b4 = EnumC0001b.WIFI;
                if (1 == type) {
                    return enumC0001b4;
                }
                if (type != 0) {
                    f1457a = enumC0001b2;
                    return enumC0001b2;
                }
                if (System.currentTimeMillis() - f1459c < 60000 && (enumC0001b = f1457a) != enumC0001b3 && enumC0001b != EnumC0001b.UNKNOWN && enumC0001b != enumC0001b4) {
                    return enumC0001b;
                }
                f1459c = System.currentTimeMillis();
                int networkType = ((TelephonyManager) context.getSystemService(GuiControlConfig.DEVICE_PHONE)).getNetworkType();
                if (networkType <= 0 && (i9 = f1461e) > 0) {
                    networkType = i9;
                }
                switch (networkType) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        EnumC0001b enumC0001b5 = EnumC0001b.MOBILE_3G;
                        f1457a = enumC0001b5;
                        return enumC0001b5;
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                    case 17:
                    default:
                        f1457a = enumC0001b2;
                        return enumC0001b2;
                    case 13:
                    case 18:
                    case 19:
                        EnumC0001b enumC0001b6 = EnumC0001b.MOBILE_4G;
                        f1457a = enumC0001b6;
                        return enumC0001b6;
                    case 20:
                        EnumC0001b enumC0001b7 = EnumC0001b.MOBILE_5G;
                        f1457a = enumC0001b7;
                        return enumC0001b7;
                }
            }
            return enumC0001b3;
        } catch (Throwable unused2) {
            f1457a = enumC0001b2;
            return enumC0001b2;
        }
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception unused) {
        }
    }
}
