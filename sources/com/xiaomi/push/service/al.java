package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.huawei.hms.framework.common.BundleUtil;
import com.xiaomi.push.hz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static al f18215a = new al();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SpannableString f1028a;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        List<b> f1029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<b> f18217b;

        private a() {
            this.f1029a = new ArrayList();
            this.f18217b = new ArrayList();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18218a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Notification f1030a;

        public b(int i9, Notification notification) {
            this.f18218a = i9;
            this.f1030a = notification;
        }

        public String toString() {
            return "id:" + this.f18218a;
        }
    }

    private al() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m732a() {
        return true;
    }

    private boolean b(Context context) {
        return aq.a(context).a(hz.NotificationAutoGroupSwitch.a(), true);
    }

    public static al a() {
        return f18215a;
    }

    private boolean a(Context context) {
        if (b(context) && an.m738a(context)) {
            return aq.a(context).a(hz.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m734b(notification) ? a(notification) : notification.getGroup();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private boolean m734b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        long j = bundle.getLong("push_src_group_time");
        String strA = a(notification);
        return notification.getGroup().equals("pushmask_" + j + BundleUtil.UNDERLINE_TAG + strA);
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m733a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object objA = com.xiaomi.push.bh.a((Object) notification, "isGroupSummary", (Object[]) null);
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    private void b(Context context, int i9, Notification notification) {
        String strC = ao.c(notification);
        if (TextUtils.isEmpty(strC)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("group restore not extract pkg from notification:" + i9);
            return;
        }
        an anVarA = an.a(context, strC);
        List<StatusBarNotification> listA = a(anVarA);
        if (listA == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("group restore not get notifications");
            return;
        }
        for (StatusBarNotification statusBarNotification : listA) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && m734b(notification2) && statusBarNotification.getId() != i9) {
                Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                builderRecoverBuilder.setGroup(a(notification2));
                ao.a(builderRecoverBuilder, m733a(notification2));
                anVarA.a(statusBarNotification.getId(), builderRecoverBuilder.build());
                com.xiaomi.channel.commonutils.logger.c.b("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!m732a() || !a(context)) {
            return str;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", jCurrentTimeMillis);
        return "pushmask_" + jCurrentTimeMillis + BundleUtil.UNDERLINE_TAG + str;
    }

    public void a(Context context, int i9, Notification notification) {
        if (m732a()) {
            if (a(context)) {
                try {
                    b(context, i9, notification);
                } catch (Exception e9) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("group notify handle restore error " + e9);
                }
            }
            if (b(context)) {
                try {
                    a(context, i9, notification, true);
                } catch (Exception e10) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("group notify handle auto error " + e10);
                }
            }
        }
    }

    private void a(Context context, int i9, Notification notification, boolean z8) {
        Notification notification2;
        String strC = ao.c(notification);
        if (TextUtils.isEmpty(strC)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("group auto not extract pkg from notification:" + i9);
            return;
        }
        List<StatusBarNotification> listA = a(an.a(context, strC));
        if (listA == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("group auto not get notifications");
            return;
        }
        String strB = b(notification);
        HashMap map = new HashMap();
        for (StatusBarNotification statusBarNotification : listA) {
            if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i9) {
                a(map, statusBarNotification);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) entry.getValue();
                if (z8 && str.equals(strB) && !m734b(notification)) {
                    b bVar = new b(i9, notification);
                    if (m733a(notification)) {
                        aVar.f18217b.add(bVar);
                    } else {
                        aVar.f1029a.add(bVar);
                    }
                }
                int size = aVar.f1029a.size();
                if (aVar.f18217b.size() <= 0) {
                    if (z8 && size >= 2) {
                        a(context, strC, str, aVar.f1029a.get(0).f1030a);
                    }
                } else if (size <= 0) {
                    a(context, strC, str);
                } else if (aq.a(context).a(hz.NotificationGroupUpdateTimeSwitch.a(), false) && (notification2 = aVar.f18217b.get(0).f1030a) != null) {
                    notification2.when = System.currentTimeMillis();
                    a(context, strC, str, notification2);
                }
            }
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String strB = b(statusBarNotification.getNotification());
        a aVar = map.get(strB);
        if (aVar == null) {
            aVar = new a();
            map.put(strB, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (m733a(statusBarNotification.getNotification())) {
            aVar.f18217b.add(bVar);
        } else {
            aVar.f1029a.add(bVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private SpannableString m731a(Context context, String str) {
        Resources resources;
        DisplayMetrics displayMetrics;
        int iMax;
        if (this.f1028a == null) {
            int i9 = (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null || (iMax = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) <= 0) ? 200 : iMax / 16;
            if (TextUtils.isEmpty(str)) {
                str = "新消息";
            }
            StringBuilder sb = new StringBuilder(str.length() + i9 + 12);
            sb.append(str);
            for (int i10 = 0; i10 < i9; i10++) {
                sb.append(' ');
            }
            sb.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb.length(), 33);
            this.f1028a = spannableString;
        }
        return this.f1028a;
    }

    private void a(Context context, String str, String str2, Notification notification) {
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.c.m9a("group show summary group is null");
                return;
            }
            int iA = ao.a(context, str);
            if (iA == 0) {
                com.xiaomi.channel.commonutils.logger.c.m9a("group show summary not get icon from " + str);
                return;
            }
            an anVarA = an.a(context, str);
            int i9 = Build.VERSION.SDK_INT;
            String strC = anVarA.c(notification.getChannelId(), "groupSummary");
            NotificationChannel notificationChannelM741a = anVarA.m741a(strC);
            if ("groupSummary".equals(strC) && notificationChannelM741a == null) {
                anVarA.a(new NotificationChannel(strC, "group_summary", 3));
            }
            Notification.Builder builder = new Notification.Builder(context, strC);
            ao.a(builder, true);
            Notification notificationBuild = builder.setContentTitle(m731a(context, "新消息")).setContentText("你有一条新消息").setSmallIcon(Icon.createWithResource(str, iA)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (i9 >= 31) {
                notificationBuild.contentIntent = a(context, str);
            }
            if (!com.xiaomi.push.k.m654c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ao.m748a(notificationBuild, str);
            }
            int iA2 = a(str, str2);
            anVarA.a(iA2, notificationBuild);
            com.xiaomi.channel.commonutils.logger.c.b("group show summary notify:" + iA2);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("group show summary error " + e9);
        }
    }

    private PendingIntent a(Context context, String str) {
        if (context == null && TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("ctx or pkg must not be null in getting launch intent");
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                com.xiaomi.channel.commonutils.logger.c.m9a("pm must not be null in getting launch intent");
                return null;
            }
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                com.xiaomi.channel.commonutils.logger.c.m9a("targetIntent must not be null in getting launch intent");
                return null;
            }
            launchIntentForPackage.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getActivity(context, 0, launchIntentForPackage, 33554432);
            }
            return PendingIntent.getActivity(context, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.d("error occurred during getting launch pendingIntent. exception:" + th);
            return null;
        }
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.c.b("group cancel summary:" + str2);
        an.a(context, str).a(a(str, str2));
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    private List<StatusBarNotification> a(an anVar) {
        List<StatusBarNotification> listC = anVar != null ? anVar.c() : null;
        if (listC == null || listC.size() == 0) {
            return null;
        }
        return listC;
    }
}
