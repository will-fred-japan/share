package cn.jiguang.commons.a;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.C0524s;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ib {
    private static int a(List<ac> list, List<ScanResult> list2, String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList(list2);
        Collections.sort(arrayList, new ic());
        int i9 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ScanResult scanResult = (ScanResult) arrayList.get(i10);
            if (scanResult != null) {
                try {
                    String strB = ks.b(scanResult.SSID);
                    if (TextUtils.isEmpty(strB) || "<unknown ssid>".equals(strB) || "unknownssid".equals(strB)) {
                        str3 = "skip invalid ssid: " + strB;
                    } else {
                        ac acVar = new ac();
                        acVar.f9610a = ca.a().k();
                        acVar.f9611b = strB;
                        String str4 = TCPTimingCache.P_CONNECT;
                        if (i10 != 0) {
                            if (!TextUtils.equals(strB, str) || !TextUtils.equals(scanResult.BSSID, str2)) {
                                acVar.f9612c = null;
                            }
                            acVar.f9613d = scanResult.level;
                            acVar.f9614e = scanResult.BSSID;
                            list.add(acVar);
                            i9++;
                            str3 = "added wifi: " + strB + " " + scanResult.BSSID + " " + scanResult.level;
                        } else if (!TextUtils.equals(strB, str) || !TextUtils.equals(scanResult.BSSID, str2)) {
                            str4 = "strongest";
                        }
                        acVar.f9612c = str4;
                        acVar.f9613d = scanResult.level;
                        acVar.f9614e = scanResult.BSSID;
                        list.add(acVar);
                        i9++;
                        str3 = "added wifi: " + strB + " " + scanResult.BSSID + " " + scanResult.level;
                    }
                    ee.a("JLocationWifi", str3);
                } catch (Throwable th) {
                    defpackage.f.n(th, C0524s.a(i10, "scan err ", ": "), "JLocationWifi");
                }
            }
        }
        return i9;
    }

    private static String b(boolean z8) {
        try {
            try {
                List<WifiConfiguration> listC = bu.a().c(1508, z8);
                if (listC == null || listC.isEmpty()) {
                    ee.d("JLocationWifi", "no wifi config");
                    return null;
                }
                try {
                    int iA = bu.a().a(1611, z8, -1);
                    if (iA == -1) {
                        ee.d("JLocationWifi", "invalid net id: " + iA);
                        return null;
                    }
                    ee.a("JLocationWifi", "search net id " + iA + " in " + listC.size());
                    for (WifiConfiguration wifiConfiguration : listC) {
                        if (wifiConfiguration != null && wifiConfiguration.networkId == iA) {
                            String str = wifiConfiguration.SSID;
                            if (!TextUtils.isEmpty(str)) {
                                ee.a("JLocationWifi", "found wifi config: " + str);
                                return ks.b(str);
                            }
                        }
                    }
                    ee.d("JLocationWifi", "no match net id: " + iA);
                    return null;
                } catch (Throwable th) {
                    ee.d("JLocationWifi", "net id err: " + th.getMessage());
                    return null;
                }
            } catch (Throwable th2) {
                ee.d("JLocationWifi", "wifi config err: " + th2.getMessage());
                return null;
            }
        } catch (Throwable th3) {
            W5.f.o(th3, new StringBuilder("wifi config ssid err: "), "JLocationWifi");
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:43:0x0101  */
    public static List<ac> a(boolean z8) {
        ey eyVarB;
        int i9;
        String strB;
        String strB2;
        ArrayList arrayList = new ArrayList();
        try {
            List listC = bu.a().c(1505, z8);
            try {
                strB = bu.a().b(1608, z8);
                try {
                    StringBuilder sb = new StringBuilder("ssid: ");
                    sb.append(strB != null ? "ok" : "null");
                    ee.a("JLocationWifi", sb.toString());
                } catch (Throwable th) {
                    th = th;
                    ee.d("JLocationWifi", "ssid err: " + th.getMessage());
                }
            } catch (Throwable th2) {
                th = th2;
                strB = null;
            }
            try {
                strB2 = bu.a().b(1601, z8);
                try {
                    StringBuilder sb2 = new StringBuilder("bssid: ");
                    sb2.append(strB2 != null ? "ok" : "null");
                    ee.a("JLocationWifi", sb2.toString());
                } catch (Throwable th3) {
                    th = th3;
                    ee.d("JLocationWifi", "bssid err: " + th.getMessage());
                }
            } catch (Throwable th4) {
                th = th4;
                strB2 = null;
            }
            if (listC != null && !listC.isEmpty()) {
                int iA = a(arrayList, (List<ScanResult>) listC, strB, strB2);
                ee.a("JLocationWifi", "wifi scan: " + listC.size() + ", processed: " + iA);
                if (iA <= 0) {
                    ee.a("JLocationWifi", "wifi scan all filtered, try current wifi");
                }
                if (arrayList.size() > 0) {
                    eyVarB = ey.b();
                    i9 = BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT;
                } else {
                    eyVarB = ey.b();
                    i9 = 3001;
                }
                eyVarB.e(Integer.valueOf(i9));
                return arrayList;
            }
            ee.a("JLocationWifi", "wifi scan empty");
            a(arrayList, z8, strB, strB2);
        } catch (Throwable th5) {
            ee.e("JLocationWifi", "wifi list err: " + th5.getMessage());
            ey.b().e((Object) 3002);
            a(arrayList, z8, (String) null, (String) null);
        }
        if (arrayList.size() > 0) {
            eyVarB = ey.b();
            i9 = BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT;
        } else {
            eyVarB = ey.b();
            i9 = 3001;
        }
        eyVarB.e(Integer.valueOf(i9));
        return arrayList;
    }

    private static void a(List<ac> list, boolean z8, String str, String str2) {
        String str3;
        try {
            ee.a("JLocationWifi", "get current wifi");
            if (str == null) {
                try {
                    str = bu.a().b(1608, z8);
                } catch (Throwable th) {
                    ee.d("JLocationWifi", "ssid err: " + th.getMessage());
                }
            }
            StringBuilder sb = new StringBuilder("ssid: ");
            sb.append(str != null ? "ok" : "null");
            ee.a("JLocationWifi", sb.toString());
            if (str2 == null) {
                try {
                    str2 = bu.a().b(1601, z8);
                } catch (Throwable th2) {
                    ee.d("JLocationWifi", "bssid err: " + th2.getMessage());
                }
            }
            StringBuilder sb2 = new StringBuilder("bssid: ");
            sb2.append(str2 != null ? "ok" : "null");
            ee.a("JLocationWifi", sb2.toString());
            int i9 = -1;
            try {
                int iA = bu.a().a(1610, z8, -1);
                ee.a("JLocationWifi", "signal: " + iA);
                i9 = iA;
            } catch (Throwable th3) {
                ee.d("JLocationWifi", "signal err: " + th3.getMessage());
            }
            if (TextUtils.isEmpty(str) || "<unknown ssid>".equals(str) || "unknownssid".equals(str)) {
                ee.a("JLocationWifi", "ssid empty, try config");
                str = b(z8);
            }
            if (TextUtils.isEmpty(str) || "<unknown ssid>".equals(str) || "unknownssid".equals(str)) {
                str3 = "ssid still empty";
            } else {
                if (!TextUtils.isEmpty(str2)) {
                    ac acVar = new ac();
                    acVar.f9610a = ca.a().k();
                    acVar.f9611b = str;
                    acVar.f9614e = str2;
                    acVar.f9613d = i9;
                    acVar.f9612c = "strongest";
                    list.add(acVar);
                    ee.c("JLocationWifi", "wifi added: " + str + " " + str2 + " " + i9);
                    return;
                }
                str3 = "bssid empty";
            }
            ee.d("JLocationWifi", str3);
        } catch (Throwable th4) {
            W5.f.o(th4, new StringBuilder("current wifi err: "), "JLocationWifi");
        }
    }
}
