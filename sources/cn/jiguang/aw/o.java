package cn.jiguang.aw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("wifi".equalsIgnoreCase(str)) {
            return 1;
        }
        if (MTCommonConstants.Network.NAME_2G.equals(str)) {
            return 2;
        }
        if (MTCommonConstants.Network.NAME_3G.equals(str)) {
            return 3;
        }
        if (MTCommonConstants.Network.NAME_4G.equals(str)) {
            return 4;
        }
        return MTCommonConstants.Network.NAME_5G.equals(str) ? 5 : 0;
    }

    public static int b(Context context) {
        return a(a(context));
    }

    public static String c() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManagerB = b();
        if (connectivityManagerB == null || (activeNetwork = connectivityManagerB.getActiveNetwork()) == null || (networkCapabilities = connectivityManagerB.getNetworkCapabilities(activeNetwork)) == null) {
            return null;
        }
        boolean zHasTransport = networkCapabilities.hasTransport(3);
        boolean zHasTransport2 = networkCapabilities.hasTransport(1);
        boolean zHasTransport3 = networkCapabilities.hasTransport(0);
        if (zHasTransport) {
            return "ethernet";
        }
        if (zHasTransport2) {
            return "wifi";
        }
        if (zHasTransport3) {
            return "cellular";
        }
        return null;
    }

    public static String a(Context context) {
        return cn.jiguang.g.b.f("unknown");
    }

    public static ConnectivityManager b() {
        Context contextA = d.a();
        if (contextA != null && q.a(contextA, "android.permission.ACCESS_NETWORK_STATE")) {
            return (ConnectivityManager) contextA.getSystemService("connectivity");
        }
        return null;
    }

    public static String c(Context context) {
        return cn.jiguang.g.b.f("unknown");
    }

    public static boolean a() {
        return a(10000);
    }

    private static boolean b(int i9) {
        return i9 == 0 || i9 == 4 || i9 == 5 || i9 == 2 || i9 == 6 || i9 == 3;
    }

    private static boolean a(int i9) {
        NetworkCapabilities networkCapabilities;
        int i10;
        ConnectivityManager connectivityManagerB = b();
        Network activeNetwork = connectivityManagerB.getActiveNetwork();
        if (activeNetwork != null && (networkCapabilities = connectivityManagerB.getNetworkCapabilities(activeNetwork)) != null) {
            boolean zHasCapability = networkCapabilities.hasCapability(12);
            boolean zHasCapability2 = networkCapabilities.hasCapability(16);
            if (!zHasCapability || !zHasCapability2) {
                return a(connectivityManagerB, i9);
            }
            if (i9 == 0) {
                i10 = 0;
            } else {
                if (i9 != 1) {
                    return true;
                }
                i10 = 1;
            }
            return networkCapabilities.hasTransport(i10) || a(connectivityManagerB, i9);
        }
        return a(connectivityManagerB, i9);
    }

    private static boolean a(ConnectivityManager connectivityManager, int i9) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (10000 == i9) {
                return true;
            }
            int type = activeNetworkInfo.getType();
            if (i9 == 0) {
                return b(type);
            }
            if (type == i9) {
                return true;
            }
        }
        return false;
    }
}
