package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.BundleUtil;
import com.xiaomi.push.ff;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class bn {
    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public static void c(Context context, String str, int i9, String str2, Notification notification) {
        an anVarA;
        Notification notificationA;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (notificationA = a(notification, i9, str2, (anVarA = an.a(context, str)))) == null) {
            return;
        }
        boolean z8 = notification != null;
        if (notificationA.getGroupAlertBehavior() != 1) {
            com.xiaomi.push.bh.a((Object) notificationA, "mGroupAlertBehavior", (Object) 1);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = notificationA.extras.getLong("mipush_org_when", 0L);
        int i10 = notificationA.extras.getInt("mipush_n_top_fre", 0);
        int iMin = notificationA.extras.getInt("mipush_n_top_prd", 0);
        if (iMin <= 0 || iMin < i10) {
            return;
        }
        long j8 = j + ((long) (iMin * 1000));
        if (j >= jCurrentTimeMillis || jCurrentTimeMillis >= j8) {
            iMin = 0;
        } else if (i10 > 0) {
            iMin = (int) Math.min((j8 - jCurrentTimeMillis) / 1000, i10);
        }
        if (!z8) {
            if (iMin > 0) {
                notificationA.when = jCurrentTimeMillis;
                com.xiaomi.channel.commonutils.logger.c.m9a("update top notification: " + str2);
                anVarA.a(i9, notificationA);
            } else {
                Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, notificationA);
                builderRecoverBuilder.setPriority(0);
                builderRecoverBuilder.setWhen(jCurrentTimeMillis);
                Bundle extras = builderRecoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    builderRecoverBuilder.setExtras(extras);
                }
                com.xiaomi.channel.commonutils.logger.c.m9a("update top notification to common: " + str2);
                anVarA.a(i9, builderRecoverBuilder.build());
            }
        }
        if (iMin > 0) {
            com.xiaomi.channel.commonutils.logger.c.m9a("schedule top notification next update delay: " + iMin);
            com.xiaomi.push.ah.a(context).m90a(b(i9, str2));
            com.xiaomi.push.ah.a(context).b(a(context, str, i9, str2, (Notification) null), iMin);
        }
    }

    public static void a(Context context, Map<String, String> map, ff ffVar, long j) {
        if (map == null || ffVar == null || !com.xiaomi.push.k.m649a(context) || !m785a(map)) {
            return;
        }
        int iA = a(map);
        int iB = b(map);
        if (iA <= 0 || iB > iA) {
            com.xiaomi.channel.commonutils.logger.c.d("set top notification failed - period:" + iA + " frequency:" + iB);
            return;
        }
        ffVar.setPriority(2);
        Bundle bundle = new Bundle();
        bundle.putLong("mipush_org_when", j);
        bundle.putBoolean("mipush_n_top_flag", true);
        if (iB > 0) {
            bundle.putInt("mipush_n_top_fre", iB);
        }
        bundle.putInt("mipush_n_top_prd", iA);
        ffVar.addExtras(bundle);
    }

    private static int b(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.u.a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i9, String str) {
        return "n_top_update_" + i9 + BundleUtil.UNDERLINE_TAG + str;
    }

    @TargetApi(19)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m784a(Context context, String str, int i9, String str2, Notification notification) {
        if (com.xiaomi.push.k.m649a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i9, str2, notification);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m785a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z8 = Boolean.parseBoolean(str);
        com.xiaomi.channel.commonutils.logger.c.c("top notification' repeat is " + z8);
        return z8;
    }

    private static int a(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.u.a(map.get("notification_top_period"), 0));
    }

    @TargetApi(19)
    private static Notification a(Notification notification, int i9, String str, an anVar) {
        if (notification != null) {
            if (str.equals(notification.extras.getString(MTPushConstants.Message.KEY_MESSAGE_ID))) {
                return notification;
            }
            return null;
        }
        List<StatusBarNotification> listC = anVar.c();
        if (listC == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : listC) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString(MTPushConstants.Message.KEY_MESSAGE_ID);
            if (i9 == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    private static com.xiaomi.push.ah.a a(final Context context, final String str, final int i9, final String str2, final Notification notification) {
        return new com.xiaomi.push.ah.a() { // from class: com.xiaomi.push.service.bn.1
            @Override // com.xiaomi.push.ah.a
            /* JADX INFO: renamed from: a */
            public String mo133a() {
                return bn.b(i9, str2);
            }

            @Override // java.lang.Runnable
            @TargetApi(19)
            public void run() {
                bn.c(context, str, i9, str2, notification);
            }
        };
    }
}
