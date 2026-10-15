package com.huawei.hms.framework.common;

import B0.C0300n;
import B0.C0301o;
import B0.C0302p;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.HwTelephonyManager;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.secure.android.common.webview.UriUtil;
import com.starburst.sdk.api.GuiControlConfig;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkUtil {
    private static final int INVALID_RSSI = -127;
    private static final String STR_NSA = "5G_NSA";
    private static final String STR_SA = "5G_SA";
    private static final String TAG = "NKUtil";
    private static final int TYPE_WIFI_P2P = 13;
    public static final int UNAVAILABLE = Integer.MAX_VALUE;
    public static volatile boolean isSupportIpv6Net = true;
    public static volatile int networkTypeByReceiver;

    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_4G_NSA = 7;
        public static final int TYPE_5G = 5;
        public static final int TYPE_5G_SA = 8;
        public static final int TYPE_MOBILE = 6;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    public static final class SignalType {
        public static final String LTE_CQI = "lteCqi";
        public static final String LTE_DBM = "lteDbm";
        public static final String LTE_RSRP = "lteRsrp";
        public static final String LTE_RSRQ = "lteRsrq";
        public static final String LTE_RSSI = "lteRssi";
        public static final String LTE_RSSNR = "lteRssnr";
        public static final String NR_CSIRSRP = "nrCSIRsrp";
        public static final String NR_CSIRSRQ = "nrCSIRsrq";
        public static final String NR_CSISINR = "nrCSISinr";
        public static final String NR_DBM = "nrDbm";
        public static final String NR_SSRSRP = "nrSSRsrp";
        public static final String NR_SSRSRQ = "nrSSRsrq";
        public static final String NR_SSSINR = "nrSSSinr";
    }

    public static int getCurrentNetworkType() {
        return networkTypeByReceiver;
    }

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(getDnsServerIpsFromConnectionManager(context));
    }

    @SuppressLint({"MissingPermission"})
    private static String[] getDnsServerIpsFromConnectionManager(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        LinkProperties linkProperties;
        LinkedList linkedList = new LinkedList();
        if (context != null && (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (network != null && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.getType() == activeNetworkInfo.getType() && (linkProperties = connectivityManager.getLinkProperties(network)) != null) {
                            Iterator<InetAddress> it = linkProperties.getDnsServers().iterator();
                            while (it.hasNext()) {
                                linkedList.add(it.next().getHostAddress());
                            }
                        }
                    }
                }
            } catch (SecurityException e9) {
                Logger.i(TAG, "getActiveNetworkInfo failed, exception:".concat(e9.getClass().getSimpleName()));
            } catch (RuntimeException e10) {
                Logger.i(TAG, "getActiveNetworkInfo failed, exception:".concat(e10.getClass().getSimpleName()));
            }
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static String getHost(String str) {
        return TextUtils.isEmpty(str) ? "" : UriUtil.getHostByURI(str);
    }

    public static int getInfoWithReflect(SignalStrength signalStrength, String str) {
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return Integer.MAX_VALUE;
            }
            final Method declaredMethod = SignalStrength.class.getDeclaredMethod(str, new Class[0]);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.NetworkUtil.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    declaredMethod.setAccessible(true);
                    return null;
                }
            });
            return ((Integer) declaredMethod.invoke(signalStrength, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            Logger.i(TAG, str + " : cannot access");
            return Integer.MAX_VALUE;
        } catch (NoSuchMethodException unused2) {
            Logger.i(TAG, str + " : function not found");
            return Integer.MAX_VALUE;
        } catch (InvocationTargetException unused3) {
            Logger.i(TAG, str + " : InvocationTargetException");
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            StringBuilder sbC = p171w.a.c(str, " : throwable:");
            sbC.append(th.getClass());
            Logger.i(TAG, sbC.toString());
            return Integer.MAX_VALUE;
        }
    }

    public static int getLteCqi(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return getInfoWithReflect(signalStrength, "getLteCqi");
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getLteCqi: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getLteRsrp(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return getInfoWithReflect(signalStrength, "getLteRsrp");
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getLteRsrp: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getLteRsrq(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return getInfoWithReflect(signalStrength, "getLteRsrq");
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getLteRsrq: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getLteRssi(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return Integer.MAX_VALUE;
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getLteRssnr(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return getInfoWithReflect(signalStrength, "getLteRssnr");
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getLteRssnr: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static Map<String, Integer> getLteSignalInfo(Context context) {
        HashMap map = new HashMap();
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength != null) {
            try {
                if (Build.VERSION.SDK_INT <= 28) {
                    map.put(SignalType.LTE_DBM, Integer.valueOf(getInfoWithReflect(signalStrength, "getDbm")));
                    map.put(SignalType.LTE_RSRP, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRsrp")));
                    map.put(SignalType.LTE_RSRQ, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRsrq")));
                    map.put(SignalType.LTE_RSSNR, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRssnr")));
                    map.put(SignalType.LTE_CQI, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteCqi")));
                    return map;
                }
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    map.put(SignalType.LTE_DBM, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getDbm()));
                    map.put(SignalType.LTE_RSRP, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp()));
                    map.put(SignalType.LTE_RSRQ, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq()));
                    map.put(SignalType.LTE_RSSNR, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr()));
                    map.put(SignalType.LTE_CQI, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi()));
                    map.put(SignalType.LTE_RSSI, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi()));
                    return map;
                }
            } catch (Throwable th) {
                Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
            }
        }
        return map;
    }

    public static String getMNC(Context context) {
        if (context == null || !isSimReady(context)) {
            return "unknown";
        }
        Object systemService = ContextCompat.getSystemService(context, GuiControlConfig.DEVICE_PHONE);
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            Logger.e(TAG, "getSubscriptionOperatorType: other error!");
            return "unknown";
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if ("46001".equals(networkOperator) || "46006".equals(networkOperator) || "46009".equals(networkOperator)) {
            return "China_Unicom";
        }
        if ("46000".equals(networkOperator) || "46002".equals(networkOperator) || "46004".equals(networkOperator) || "46007".equals(networkOperator)) {
            return "China_Mobile";
        }
        return ("46003".equals(networkOperator) || "46005".equals(networkOperator) || "46011".equals(networkOperator)) ? "China_Telecom" : "other";
    }

    public static int getMobileRsrp(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            return Build.VERSION.SDK_INT > 28 ? getMobileSingalStrengthUpPPlatfrom(context) : getInfoWithReflect(signalStrength, "getDbm");
        } catch (Throwable th) {
            Logger.i(TAG, "getDbm: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    private static int getMobileSingalStrengthUpPPlatfrom(Context context) {
        SignalStrength signalStrength;
        if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        int networkType = getNetworkType(context);
        try {
            if (networkType == 3) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthCdma.class);
                if (cellSignalStrengths.size() > 0) {
                    return ((CellSignalStrengthCdma) cellSignalStrengths.get(0)).getDbm();
                }
                List cellSignalStrengths2 = signalStrength.getCellSignalStrengths(C0301o.s());
                if (cellSignalStrengths2.size() > 0) {
                    return C0302p.l(cellSignalStrengths2.get(0)).getDbm();
                }
                List cellSignalStrengths3 = signalStrength.getCellSignalStrengths(CellSignalStrengthWcdma.class);
                if (cellSignalStrengths3.size() > 0) {
                    return ((CellSignalStrengthWcdma) cellSignalStrengths3.get(0)).getDbm();
                }
                return Integer.MAX_VALUE;
            }
            if (networkType == 4) {
                List cellSignalStrengths4 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths4.size() > 0) {
                    return ((CellSignalStrengthLte) cellSignalStrengths4.get(0)).getDbm();
                }
                return Integer.MAX_VALUE;
            }
            if (networkType != 5) {
                return Integer.MAX_VALUE;
            }
            List cellSignalStrengths5 = signalStrength.getCellSignalStrengths(C0302p.q());
            if (cellSignalStrengths5.size() > 0) {
                return C0300n.l(cellSignalStrengths5.get(0)).getDbm();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getMobileSingalStrength: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static String getNetWorkNSAorSA() {
        try {
            HwTelephonyManager hwTelephonyManager = HwTelephonyManager.getDefault();
            int default4GSlotId = hwTelephonyManager.getDefault4GSlotId();
            Logger.v(TAG, "phoneId " + default4GSlotId);
            boolean zIsNsaState = hwTelephonyManager.isNsaState(default4GSlotId);
            Logger.v(TAG, "isNsa " + zIsNsaState);
            return zIsNsaState ? STR_NSA : STR_SA;
        } catch (Throwable unused) {
            Logger.v(TAG, "isNsaState error");
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (RuntimeException e9) {
                Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e9.getClass().getSimpleName() + e9.getMessage());
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo.DetailedState getNetworkStatus(Context context) {
        NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof ConnectivityManager) {
                try {
                    if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            return activeNetworkInfo.getDetailedState();
                        }
                        Logger.i(TAG, "getNetworkStatus networkIsConnected netInfo is null!");
                        return detailedState;
                    }
                } catch (RuntimeException e9) {
                    Logger.i(TAG, "getNetworkStatus exception" + e9.getClass().getSimpleName() + e9.getMessage());
                }
            } else {
                Logger.i(TAG, "getNetworkStatus ConnectivityManager is null!");
            }
        }
        return detailedState;
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context), context);
        }
        return 0;
    }

    public static int getNrCsiRsrp(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT > 28 && (signalStrength = getSignalStrength(context)) != null) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(C0302p.q());
                if (cellSignalStrengths.size() > 0) {
                    return C0300n.l(cellSignalStrengths.get(0)).getCsiRsrp();
                }
                return Integer.MAX_VALUE;
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getNrCsiRsrp: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrCsiRsrq(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT > 28 && (signalStrength = getSignalStrength(context)) != null) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(C0302p.q());
                if (cellSignalStrengths.size() > 0) {
                    return C0300n.l(cellSignalStrengths.get(0)).getCsiRsrq();
                }
                return Integer.MAX_VALUE;
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getNrCsiRsrq: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrCsiSinr(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT > 28 && (signalStrength = getSignalStrength(context)) != null) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(C0302p.q());
                if (cellSignalStrengths.size() > 0) {
                    return C0300n.l(cellSignalStrengths.get(0)).getCsiSinr();
                }
                return Integer.MAX_VALUE;
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getNrCsiSinr: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static Map<String, Integer> getNrSignalInfo(Context context) {
        HashMap map = new HashMap();
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength != null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    List cellSignalStrengths = signalStrength.getCellSignalStrengths(C0302p.q());
                    if (cellSignalStrengths.size() > 0) {
                        map.put(SignalType.NR_DBM, Integer.valueOf(C0300n.l(cellSignalStrengths.get(0)).getDbm()));
                        map.put(SignalType.NR_CSIRSRP, Integer.valueOf(C0300n.l(cellSignalStrengths.get(0)).getCsiRsrp()));
                        map.put(SignalType.NR_CSIRSRQ, Integer.valueOf(C0300n.l(cellSignalStrengths.get(0)).getCsiRsrq()));
                        map.put(SignalType.NR_CSISINR, Integer.valueOf(C0300n.l(cellSignalStrengths.get(0)).getCsiSinr()));
                        map.put(SignalType.NR_SSRSRP, Integer.valueOf(C0300n.l(cellSignalStrengths.get(0)).getSsRsrp()));
                        map.put(SignalType.NR_SSRSRQ, Integer.valueOf(C0300n.l(cellSignalStrengths.get(0)).getSsRsrq()));
                        map.put(SignalType.NR_SSSINR, Integer.valueOf(C0300n.l(cellSignalStrengths.get(0)).getSsSinr()));
                        return map;
                    }
                }
            } catch (Throwable th) {
                Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
            }
        }
        return map;
    }

    public static int getNrSsRsrp(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT > 28 && (signalStrength = getSignalStrength(context)) != null) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(C0302p.q());
                if (cellSignalStrengths.size() > 0) {
                    return C0300n.l(cellSignalStrengths.get(0)).getSsRsrp();
                }
                return Integer.MAX_VALUE;
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getNrSsRsrp: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrSsRsrq(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT > 28 && (signalStrength = getSignalStrength(context)) != null) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(C0302p.q());
                if (cellSignalStrengths.size() > 0) {
                    return C0300n.l(cellSignalStrengths.get(0)).getSsRsrq();
                }
                return Integer.MAX_VALUE;
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getNrSsRsrq: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrSsSinr(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT > 28 && (signalStrength = getSignalStrength(context)) != null) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(C0302p.q());
                if (cellSignalStrengths.size() > 0) {
                    return C0300n.l(cellSignalStrengths.get(0)).getSsSinr();
                }
                return Integer.MAX_VALUE;
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(TAG, "getNrSsSinr: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getPrimaryNetworkType(Context context) {
        return groupNetworkType(getNetworkType(getNetworkInfo(context), context));
    }

    private static SignalStrength getSignalStrength(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 28) {
            return null;
        }
        return getTrafficCardTelephonyManager(context).getSignalStrength();
    }

    public static TelephonyManager getTrafficCardTelephonyManager(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = ContextCompat.getSystemService(context, GuiControlConfig.DEVICE_PHONE);
        if (systemService instanceof TelephonyManager) {
            return ((TelephonyManager) systemService).createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId());
        }
        return null;
    }

    public static String getWifiGatewayIp(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
            if (systemService instanceof WifiManager) {
                try {
                    int i9 = ((WifiManager) systemService).getDhcpInfo().gateway;
                    return InetAddress.getByAddress(new byte[]{(byte) (i9 & 255), (byte) ((i9 >> 8) & 255), (byte) ((i9 >> 16) & 255), (byte) ((i9 >> 24) & 255)}).getHostAddress();
                } catch (RuntimeException | UnknownHostException e9) {
                    Logger.i(TAG, "getWifiGatewayIp error!" + e9.getClass().getSimpleName() + e9.getMessage());
                }
            }
        }
        return " ";
    }

    public static int getWifiRssi(Context context) {
        TransportInfo transportInfo;
        int rssi = INVALID_RSSI;
        if (context != null && Build.VERSION.SDK_INT >= 31) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                for (Network network : connectivityManager.getAllNetworks()) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(1) && (transportInfo = networkCapabilities.getTransportInfo()) != null && (transportInfo instanceof WifiInfo)) {
                        rssi = ((WifiInfo) transportInfo).getRssi();
                    }
                }
                return rssi;
            } catch (RuntimeException e9) {
                Logger.i(TAG, "getWifiRssiLevel did not has permission!" + e9.getClass().getSimpleName() + e9.getMessage());
            }
        }
        return INVALID_RSSI;
    }

    public static int getWifiRssiLevel(Context context) {
        return WifiManager.calculateSignalLevel(getWifiRssi(context), 5);
    }

    private static int groupNetworkType(int i9) {
        int i10 = -1;
        if (i9 != -1) {
            i10 = 1;
            if (i9 != 1) {
                return (i9 == 2 || i9 == 3 || i9 == 4 || i9 == 5) ? 6 : 0;
            }
        }
        return i10;
    }

    public static boolean isChangeToConnected(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if ((networkInfo != null && networkInfo.isConnected()) || !networkInfo2.isConnected()) {
            return false;
        }
        Logger.v(TAG, "Find network state changed to connected");
        return true;
    }

    public static boolean isConnectTypeChange(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo2.isConnected() || getPrimaryNetworkType(networkInfo) == getPrimaryNetworkType(networkInfo2)) {
            return false;
        }
        Logger.v(TAG, "Find activity network changed");
        return true;
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return ActivityUtil.isForeground(context);
    }

    public static boolean isNetworkAvailable(Context context) {
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isSimReady(Context context) {
        Object systemService = ContextCompat.getSystemService(context, GuiControlConfig.DEVICE_PHONE);
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isSupportIpv6Net(Context context, int i9) {
        boolean z8 = i9 > 1;
        if (context == null) {
            return z8;
        }
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            Logger.v(TAG, "has no network state permission");
            return z8;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            Logger.e(TAG, "mConnectivityManager is null");
            return z8;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            Logger.e(TAG, "network is null");
            return z8;
        }
        LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
        if (linkProperties == null) {
            Logger.e(TAG, "ipInfo is null");
            return z8;
        }
        List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
        for (int i10 = 0; i10 < linkAddresses.size(); i10++) {
            InetAddress address = linkAddresses.get(i10).getAddress();
            if ((address instanceof Inet6Address) && !address.isLinkLocalAddress() && !address.isLoopbackAddress()) {
                Logger.v(TAG, "has ipv6 interface");
                return true;
            }
        }
        Logger.v(TAG, "has not ipv6 interface");
        return false;
    }

    public static boolean isUserUnlocked(Context context) {
        UserManager userManager = (UserManager) ContextCompat.getSystemService(context, "user");
        if (userManager == null) {
            return true;
        }
        try {
            return userManager.isUserUnlocked();
        } catch (RuntimeException e9) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", e9);
            return true;
        }
    }

    public static int netWork(Context context) {
        int networkType = getNetworkType(context);
        Logger.v(TAG, "networkType " + networkType);
        if (networkType == 4) {
            if (TextUtils.equals(STR_NSA, getNetWorkNSAorSA())) {
                return 7;
            }
            return networkType;
        }
        if (networkType == 5 && TextUtils.equals(STR_SA, getNetWorkNSAorSA())) {
            return 8;
        }
        return networkType;
    }

    @Deprecated
    public static NetworkInfo.DetailedState networkStatus(Context context) {
        return getNetworkStatus(context);
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        if (context != null && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            Object systemService = ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof ConnectivityManager) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                try {
                    if (connectivityManager.isActiveNetworkMetered()) {
                        return connectivityManager.getRestrictBackgroundStatus();
                    }
                    Logger.v(TAG, "ConnectType is not Mobile Network!");
                    return 0;
                } catch (RuntimeException e9) {
                    Logger.e(TAG, "SystemServer error:", e9);
                }
            }
        }
        return 0;
    }

    public static void updateCurrentNetworkType() {
        networkTypeByReceiver = netWork(ContextHolder.getResourceContext());
        if (InitReport.isHasConnectNet()) {
            isSupportIpv6Net = isSupportIpv6Net(ContextHolder.getResourceContext(), networkTypeByReceiver);
            Logger.i(TAG, "update currentNetworkType: " + networkTypeByReceiver + ", isSupportIpv6Net:" + isSupportIpv6Net);
        }
    }

    public static boolean isForeground() {
        return ActivityUtil.getInstance().isForeground();
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        int i9;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        int i10 = 1;
        if (1 != type && 13 != type) {
            i10 = 0;
            if (type == 0) {
                int subtype = networkInfo.getSubtype();
                Logger.v(TAG, "getHwNetworkType return is: " + subtype);
                if (subtype == 0) {
                    subtype = networkInfo.getSubtype();
                }
                if (subtype != 20) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            i9 = 2;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i9 = 3;
                            break;
                        case 13:
                            i9 = 4;
                            break;
                        default:
                            i9 = 0;
                            break;
                    }
                } else {
                    i9 = 5;
                }
                if (i9 != 0) {
                    return i9;
                }
                if (subtype != 16) {
                    return subtype != 17 ? 0 : 3;
                }
                return 2;
            }
        }
        return i10;
    }

    public static int getPrimaryNetworkType(NetworkInfo networkInfo) {
        return groupNetworkType(getNetworkType(networkInfo));
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        return getNetworkType(networkInfo, null);
    }

    public static boolean isSupportIpv6Net() {
        return isSupportIpv6Net;
    }
}
