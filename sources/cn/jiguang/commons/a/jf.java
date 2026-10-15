package cn.jiguang.commons.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import java.net.Inet6Address;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class jf {
    private static String a(ConnectivityManager connectivityManager) {
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return "WiFi";
                }
                if (b(type)) {
                    return kt.c();
                }
                if (type == 9) {
                    return "Ethernet";
                }
                if (type == 17) {
                    return "VPN";
                }
                if (type == 7) {
                    return "Bluetooth";
                }
                ee.d("ConnectUtils", "Unknown network type: " + type);
                return "Unknown";
            }
            ee.d("ConnectUtils", "No active network connection");
            return "";
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("Error in network info fallback: "), "ConnectUtils");
            return "";
        }
    }

    public static boolean b() {
        return a(0);
    }

    public static boolean c() {
        return a(10000);
    }

    public static String d() {
        try {
            ConnectivityManager connectivityManagerF = f();
            if (connectivityManagerF == null) {
                ee.d("ConnectUtils", "ConnectivityManager null");
                return "";
            }
            Network activeNetwork = connectivityManagerF.getActiveNetwork();
            if (activeNetwork == null) {
                ee.d("ConnectUtils", "No active network");
            } else {
                NetworkCapabilities networkCapabilities = connectivityManagerF.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null) {
                    ee.d("ConnectUtils", "Network capabilities null");
                } else {
                    boolean zHasCapability = networkCapabilities.hasCapability(12);
                    boolean zHasCapability2 = networkCapabilities.hasCapability(16);
                    if (!zHasCapability || !zHasCapability2) {
                        ee.d("ConnectUtils", "Network not connected");
                    } else {
                        if (networkCapabilities.hasTransport(1)) {
                            return "WiFi";
                        }
                        if (networkCapabilities.hasTransport(0)) {
                            return kt.c();
                        }
                        if (networkCapabilities.hasTransport(3)) {
                            return "Ethernet";
                        }
                        if (networkCapabilities.hasTransport(4)) {
                            return "VPN";
                        }
                        if (networkCapabilities.hasTransport(2)) {
                            return "Bluetooth";
                        }
                        ee.d("ConnectUtils", "Unknown network transport");
                    }
                }
            }
            return a(connectivityManagerF);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("Error getting current network type: "), "ConnectUtils");
            return "";
        }
    }

    public static boolean e() {
        LinkProperties linkProperties;
        try {
            ConnectivityManager connectivityManagerF = f();
            if (connectivityManagerF == null || (linkProperties = connectivityManagerF.getLinkProperties(connectivityManagerF.getActiveNetwork())) == null) {
                return false;
            }
            Iterator<LinkAddress> it = linkProperties.getLinkAddresses().iterator();
            while (it.hasNext()) {
                if (it.next().getAddress() instanceof Inet6Address) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static ConnectivityManager f() {
        Context contextA = jg.a();
        if (contextA != null && kh.a("android.permission.ACCESS_NETWORK_STATE")) {
            return (ConnectivityManager) contextA.getSystemService("connectivity");
        }
        return null;
    }

    private static boolean b(int i9) {
        return i9 == 0 || i9 == 4 || i9 == 5 || i9 == 2 || i9 == 6 || i9 == 3;
    }

    public static boolean a() {
        return a(1);
    }

    private static boolean a(int i9) {
        NetworkCapabilities networkCapabilities;
        int i10;
        ConnectivityManager connectivityManagerF = f();
        if (connectivityManagerF == null) {
            return false;
        }
        Network activeNetwork = connectivityManagerF.getActiveNetwork();
        if (activeNetwork != null && (networkCapabilities = connectivityManagerF.getNetworkCapabilities(activeNetwork)) != null) {
            boolean zHasCapability = networkCapabilities.hasCapability(12);
            boolean zHasCapability2 = networkCapabilities.hasCapability(16);
            if (!zHasCapability || !zHasCapability2) {
                return a(connectivityManagerF, i9);
            }
            if (i9 == 0) {
                i10 = 0;
            } else {
                if (i9 != 1) {
                    return true;
                }
                i10 = 1;
            }
            return networkCapabilities.hasTransport(i10) || a(connectivityManagerF, i9);
        }
        return a(connectivityManagerF, i9);
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
