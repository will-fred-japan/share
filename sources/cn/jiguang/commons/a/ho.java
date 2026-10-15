package cn.jiguang.commons.a;

import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.data.JPushCollectControl;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ho extends AbstractC0552a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f10156b;

    private ho() {
    }

    public static ho b() {
        return hp.f10157a;
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JDeviceMac";
    }

    public /* synthetic */ ho(byte b9) {
        this();
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        ac next;
        String str;
        String str2;
        try {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 < 29) {
                str2 = "it need not business, because os version less than 29, current is " + i9;
            } else {
                String strB = bu.a().b(JPushCollectControl.IMSI, z8);
                ee.a("JDeviceMac", "mac: " + strB);
                if (!TextUtils.equals(strB, f10155a)) {
                    f10155a = strB;
                    List<ac> listA = ib.a(z8);
                    if (listA.isEmpty()) {
                        str = "wifi info list empty";
                    } else {
                        Iterator<ac> it = listA.iterator();
                        ac acVar = null;
                        ac acVar2 = null;
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (TextUtils.equals(next.f9612c, TCPTimingCache.P_CONNECT)) {
                                ee.a("JDeviceMac", "connect wifi: " + next.toString());
                                break;
                            } else if (TextUtils.equals(next.f9612c, "strongest")) {
                                ee.a("JDeviceMac", "strongest wifi: " + next.toString());
                                acVar2 = next;
                            }
                        }
                        if (next != null && !TextUtils.isEmpty(next.f9611b) && !TextUtils.equals(next.f9611b, "<unknown ssid>") && !TextUtils.equals(next.f9611b, "unknownssid")) {
                            ee.c("JDeviceMac", "use connect wifi, ssid: " + next.f9611b);
                            acVar = next;
                        } else if (acVar2 != null && !TextUtils.isEmpty(acVar2.f9611b) && !TextUtils.equals(acVar2.f9611b, "<unknown ssid>") && !TextUtils.equals(acVar2.f9611b, "unknownssid")) {
                            ee.c("JDeviceMac", "use strongest wifi, ssid: " + acVar2.f9611b);
                            acVar = acVar2;
                        }
                        if (acVar == null) {
                            str = "exact wifi info null, cannot report ssid mac";
                        } else {
                            if (TextUtils.isEmpty(f10156b) || !TextUtils.equals(f10156b, acVar.f9611b)) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("tag", acVar.f9612c);
                                    jSONObject.put("l_mac_address", strB);
                                    jSONObject.put("ssid", acVar.f9611b);
                                    ee.a("JDeviceMac", "report ssid data success");
                                    ca.a().a(jSONObject, "ssid_mac_info");
                                    f10156b = acVar.f9611b;
                                    AbstractC0552a.a("JDeviceMac");
                                    return;
                                } catch (Throwable th) {
                                    ee.d("JDeviceMac", "ssid mac report err: " + th.getMessage());
                                    return;
                                }
                            }
                            str2 = "ssid unchanged, skip report: " + acVar.f9611b;
                        }
                    }
                    ee.d("JDeviceMac", str);
                    return;
                }
                str2 = "mac unchanged, skip report: " + strB;
            }
            ee.a("JDeviceMac", str2);
        } catch (Throwable th2) {
            ee.d("JDeviceMac", "ssid mac err:" + th2.getMessage());
        }
    }
}
