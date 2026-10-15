package cn.jiguang.commons.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public final class jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile y f10248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f10249b;

    public static y a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f10248a != null && jCurrentTimeMillis - f10249b < com.heytap.mcssdk.constant.a.f14256r) {
            return f10248a;
        }
        y yVarB = b();
        f10248a = yVarB;
        f10249b = jCurrentTimeMillis;
        return yVarB;
    }

    private static y b() {
        int i9;
        String str;
        y yVar = new y();
        try {
            Context contextA = jg.a();
            if (contextA == null) {
                str = "Context null, cannot get battery info";
            } else {
                Intent intentA = kj.a(contextA, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), false);
                if (intentA != null) {
                    int intExtra = intentA.getIntExtra("level", -1);
                    int intExtra2 = intentA.getIntExtra("scale", -1);
                    if (intExtra == -1 || intExtra2 == -1 || intExtra2 <= 0) {
                        yVar.f10439a = -1;
                    } else {
                        yVar.f10439a = Math.round((intExtra * 100.0f) / intExtra2);
                    }
                    yVar.f10440b = intExtra2;
                    int intExtra3 = intentA.getIntExtra("status", -1);
                    if (intExtra3 == 1) {
                        i9 = 0;
                    } else if (intExtra3 != 2) {
                        i9 = 3;
                        if (intExtra3 == 3 || intExtra3 == 4) {
                            i9 = 1;
                        } else if (intExtra3 != 5) {
                            i9 = -1;
                        }
                    } else {
                        i9 = 2;
                    }
                    yVar.f10441c = i9;
                    int intExtra4 = intentA.getIntExtra("temperature", -1);
                    if (intExtra4 == -1) {
                        intExtra4 = -1;
                    }
                    yVar.f10442d = intExtra4;
                    int intExtra5 = intentA.getIntExtra("voltage", -1);
                    if (intExtra5 == -1) {
                        intExtra5 = -1;
                    }
                    yVar.f10443e = intExtra5;
                    yVar.f10444f = intExtra3 == 2 || intExtra3 == 5;
                    int intExtra6 = intentA.getIntExtra("plugged", -1);
                    yVar.f10445g = intExtra6 == 1 || intExtra6 == 2 || intExtra6 == 4;
                    yVar.f10446h = intExtra6;
                    return yVar;
                }
                str = "Failed to get battery status intent";
            }
            ee.d("BatteryUtils", str);
            return yVar;
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("Error fetching battery info: "), "BatteryUtils");
            return yVar;
        }
    }
}
