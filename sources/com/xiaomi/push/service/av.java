package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.fw;
import com.xiaomi.push.ih;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class av {
    /* JADX INFO: Access modifiers changed from: private */
    public static void b(long j, Map<String, ?> map, SharedPreferences sharedPreferences) {
        if (map == null || sharedPreferences == null) {
            com.xiaomi.channel.commonutils.logger.c.c("PT-Track", "Cannot upload pass through data, because sp is null.");
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                Integer num = (Integer) value;
                num.intValue();
                if (!"last_upload_time".equals(key) && !TextUtils.isEmpty(key)) {
                    String[] strArrSplit = key.split(Constants.COLON_SEPARATOR);
                    if (strArrSplit.length == 2 && ("awake".equals(strArrSplit[1]) || "non_awake".equals(strArrSplit[1]))) {
                        HashMap map2 = new HashMap();
                        map2.put("target_pkg", strArrSplit[0]);
                        map2.put("awake", Boolean.valueOf("awake".equals(strArrSplit[1])));
                        map2.put("cnt", num);
                        fw.a().a("pt_stat_no_charge_and_screen_off", map2);
                    }
                }
            }
        }
        sharedPreferences.edit().clear().putLong("last_upload_time", j).apply();
    }

    public static void a(final Context context, final String str, ih ihVar) {
        if (context == null || TextUtils.isEmpty(str) || ihVar == null || ihVar.m519a() == null) {
            return;
        }
        try {
            boolean zB = com.xiaomi.push.ag.b(context);
            boolean zC = com.xiaomi.push.ag.c(context);
            if (!zB && !zC) {
                final boolean z8 = ihVar.m519a().containsKey("__check_alive") && Boolean.parseBoolean(ihVar.m519a().get("__awake"));
                com.xiaomi.push.ah.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.av.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Map<String, ?> all;
                        try {
                            SharedPreferences sharedPreferences = context.getSharedPreferences("passthrough_stat", 0);
                            String strB = av.b(str, z8);
                            sharedPreferences.edit().putInt(strB, sharedPreferences.getInt(strB, 0) + 1).apply();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            long j = sharedPreferences.getLong("last_upload_time", 0L);
                            if (j == 0) {
                                sharedPreferences.edit().putLong("last_upload_time", jCurrentTimeMillis).apply();
                                return;
                            }
                            if (Math.abs(jCurrentTimeMillis - j) >= com.heytap.mcssdk.constant.a.f14246g && (all = sharedPreferences.getAll()) != null && !all.isEmpty()) {
                                av.b(jCurrentTimeMillis, all, sharedPreferences);
                            }
                        } catch (Throwable th) {
                            defpackage.f.q("An unexpected exception occurred while record and upload pass through message: ", "PT-Track", th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            defpackage.f.q("Failed to record pass through data: ", "PT-Track", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, boolean z8) {
        StringBuilder sbC = p171w.a.c(str, Constants.COLON_SEPARATOR);
        sbC.append(z8 ? "awake" : "non_awake");
        return sbC.toString();
    }
}
