package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.fw;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f18245a = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> b(Context context, String str, String str2, int i9, int i10) {
        HashMap map = new HashMap();
        map.put("report_time", Long.valueOf(System.currentTimeMillis()));
        map.put("uuid", v.m827a(context));
        map.put("s_count", Integer.valueOf(i9));
        map.put("s_msg_ids", str);
        map.put("not_sure_msg_ids", str2);
        map.put("not_sure_count", Integer.valueOf(i10));
        return map;
    }

    public static void a(final Context context, final int i9, final String str, final String str2) {
        if (context == null) {
            return;
        }
        com.xiaomi.push.ah.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.au.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (au.f18245a) {
                        try {
                            SharedPreferences sharedPreferences = context.getSharedPreferences("passthrough_wake", 0);
                            int i10 = sharedPreferences.getInt("success_count", 0);
                            String string = sharedPreferences.getString("success_msg_ids", "");
                            String string2 = sharedPreferences.getString("not_sure_msg_ids", "");
                            int i11 = sharedPreferences.getInt("not_sure_count", 0);
                            int i12 = i9;
                            if (i12 == -1) {
                                Map<String, Object> mapB = au.b(context, string, string2, i10, i11);
                                au.b(mapB, context, str, str2);
                                fw.a().a("passthrough_wake", mapB);
                                sharedPreferences.edit().clear().apply();
                            } else if (i10 + i11 + 1 >= 20) {
                                if (i12 == 1) {
                                    i10++;
                                    string = string + str2 + ";";
                                } else if (i12 == 0) {
                                    i11++;
                                    string2 = string2 + str2 + ";";
                                }
                                fw.a().a("passthrough_wake", au.b(context, string, string2, i10, i11));
                                sharedPreferences.edit().clear().apply();
                            } else {
                                if (i12 == 1) {
                                    i10++;
                                    string = string + str2 + ";";
                                } else {
                                    i11++;
                                    string2 = string2 + str2 + ";";
                                }
                                sharedPreferences.edit().putString("success_msg_ids", string).putString("not_sure_msg_ids", string2).putInt("success_count", i10).putInt("not_sure_count", i11).apply();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.c.b("PAT-Track", "Failed to record pass through awake data:", th2);
                }
            }
        });
    }

    public static void a(final Context context) {
        if (context == null || com.xiaomi.push.ah.a(context).a(new com.xiaomi.push.ah.a() { // from class: com.xiaomi.push.service.au.2
            @Override // com.xiaomi.push.ah.a
            /* JADX INFO: renamed from: a */
            public String mo133a() {
                return "awake_hour_job";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (au.f18245a) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("passthrough_wake", 0);
                    int i9 = sharedPreferences.getInt("success_count", 0);
                    String string = sharedPreferences.getString("success_msg_ids", "");
                    String string2 = sharedPreferences.getString("not_sure_msg_ids", "");
                    int i10 = sharedPreferences.getInt("not_sure_count", 0);
                    if (i9 != 0 || i10 != 0) {
                        fw.a().a("passthrough_wake", au.b(context, string, string2, i9, i10));
                        sharedPreferences.edit().clear().apply();
                    }
                }
            }
        }, 3600)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.c("PAT-Track", "Failed to add passthrough repeat job");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map<String, Object> map, Context context, String str, String str2) {
        if (str2 == null || context == null) {
            return;
        }
        map.put("failed_pkg", str);
        map.put("failed_permission", Integer.valueOf(com.xiaomi.push.h.a(str, context)));
        map.put("f_msg_id", str2);
    }
}
