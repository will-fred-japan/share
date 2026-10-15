package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.hz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f18223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Object f1035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static WeakHashMap<Integer, an> f1036a = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f1037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f1038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f18224b;

    private an(String str) {
        this.f1038a = str;
    }

    public static String b(String str, String str2) {
        return a(m737a() ? "mipush|%s|%s" : "mipush_%s_%s", str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Context m742a() {
        return f18223a;
    }

    public String c(String str, String str2) {
        return m737a() ? str : str2;
    }

    public String toString() {
        return A.a.j(new StringBuilder("NotificationManagerHelper{"), this.f1038a, "}");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m743a() {
        return this.f1038a;
    }

    public List<StatusBarNotification> c() {
        String str = this.f1038a;
        NotificationManager notificationManagerA = a();
        ArrayList arrayList = null;
        try {
            if (m737a()) {
                int iA = com.xiaomi.push.j.a();
                if (iA != -1) {
                    return (List) a(com.xiaomi.push.bh.a(f1035a, "getAppActiveNotifications", str, Integer.valueOf(iA)));
                }
            } else {
                StatusBarNotification[] activeNotifications = notificationManagerA.getActiveNotifications();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (str.equals(ao.c(statusBarNotification.getNotification()))) {
                                arrayList2.add(statusBarNotification);
                            }
                        }
                        return arrayList2;
                    } catch (Throwable th) {
                        th = th;
                        arrayList = arrayList2;
                        m736a("getActiveNotifications error " + th);
                        return arrayList;
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static an a(Context context, String str) {
        a(context);
        int iHashCode = str.hashCode();
        an anVar = f1036a.get(Integer.valueOf(iHashCode));
        if (anVar != null) {
            return anVar;
        }
        an anVar2 = new an(str);
        f1036a.put(Integer.valueOf(iHashCode), anVar2);
        return anVar2;
    }

    private String b(String str) {
        return b(this.f1038a, str);
    }

    public String b() {
        if (TextUtils.isEmpty(this.f18224b)) {
            this.f18224b = b("default");
        }
        return this.f18224b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m738a(Context context) {
        a(context);
        return m737a();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public List<StatusBarNotification> m747b() {
        List<StatusBarNotification> listC = c();
        if (listC == null) {
            return new ArrayList();
        }
        ListIterator<StatusBarNotification> listIterator = listC.listIterator();
        while (listIterator.hasNext()) {
            if (!a(listIterator.next())) {
                listIterator.remove();
            }
        }
        return listC;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = a("mipush|%s|%s", str2, "");
        return str.startsWith(strA) ? a("mipush_%s_%s", str2, str.replace(strA, "")) : str;
    }

    private static void a(Context context) {
        if (f18223a == null) {
            f18223a = context.getApplicationContext();
            NotificationManager notificationManagerA = a();
            Boolean bool = (Boolean) com.xiaomi.push.bh.a((Object) notificationManagerA, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m736a("fwk is support.init:" + bool);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            f1037a = zBooleanValue;
            if (zBooleanValue) {
                f1035a = com.xiaomi.push.bh.a((Object) notificationManagerA, "getService", new Object[0]);
            }
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) f18223a.getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m737a() {
        if (com.xiaomi.push.k.m648a() && aq.a(f18223a).a(hz.NotificationBelongToAppSwitch.a(), true)) {
            return f1037a;
        }
        return false;
    }

    private static int a(String str) {
        try {
            return f18223a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(str, str2, str3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m746a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m744a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        return com.xiaomi.push.k.m649a(m742a()) ? b(str) : str;
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f1038a;
        try {
            if (m737a()) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.bh.b(f1035a, "createNotificationChannelsForPackage", str, Integer.valueOf(iA), a(Arrays.asList(notificationChannel)));
                    return;
                }
                return;
            }
            a().createNotificationChannel(notificationChannel);
        } catch (Exception e9) {
            m736a("createNotificationChannel error" + e9);
        }
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NotificationChannel m741a(String str) {
        try {
            if (m737a()) {
                List<NotificationChannel> listM745a = m745a();
                if (listM745a == null) {
                    return null;
                }
                for (NotificationChannel notificationChannel : listM745a) {
                    if (str.equals(notificationChannel.getId())) {
                        return notificationChannel;
                    }
                }
                return null;
            }
            return a().getNotificationChannel(str);
        } catch (Exception e9) {
            m736a("getNotificationChannel error" + e9);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @TargetApi(26)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<NotificationChannel> m745a() {
        String str;
        String str2 = this.f1038a;
        List<NotificationChannel> notificationChannels = null;
        try {
            if (m737a()) {
                int iA = a(str2);
                if (iA != -1) {
                    List<NotificationChannel> list = (List) a(com.xiaomi.push.bh.a(f1035a, "getNotificationChannelsForPackage", str2, Integer.valueOf(iA), Boolean.FALSE));
                    str = "mipush|%s|%s";
                    notificationChannels = list;
                } else {
                    str = null;
                }
            } else {
                notificationChannels = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!com.xiaomi.push.k.m648a() || notificationChannels == null) {
                return notificationChannels;
            }
            ArrayList arrayList = new ArrayList();
            String strA = a(str, str2, "");
            for (NotificationChannel notificationChannel : notificationChannels) {
                if (notificationChannel.getId().startsWith(strA)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e9) {
            m736a("getNotificationChannels error " + e9);
            return notificationChannels;
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z8) {
        String str = this.f1038a;
        try {
            if (z8) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.bh.b(f1035a, "updateNotificationChannelForPackage", str, Integer.valueOf(iA), notificationChannel);
                    return;
                }
                return;
            }
            a(notificationChannel);
        } catch (Exception e9) {
            m736a("updateNotificationChannel error " + e9);
        }
    }

    public void a(int i9, Notification notification) {
        String str = this.f1038a;
        NotificationManager notificationManagerA = a();
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (m737a()) {
                notification.extras.putString("xmsf_target_package", str);
                if (i10 >= 29) {
                    notificationManagerA.notifyAsPackage(str, null, i9, notification);
                    return;
                } else {
                    notificationManagerA.notify(i9, notification);
                    return;
                }
            }
            notificationManagerA.notify(i9, notification);
        } catch (Exception unused) {
        }
    }

    public void a(int i9) {
        String str = this.f1038a;
        try {
            if (m737a()) {
                int iA = com.xiaomi.push.j.a();
                String packageName = m742a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.bh.b(f1035a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i9), Integer.valueOf(iA));
                } else {
                    com.xiaomi.push.bh.b(f1035a, "cancelNotificationWithTag", str, null, Integer.valueOf(i9), Integer.valueOf(iA));
                }
                m736a("cancel succ:" + i9);
                return;
            }
            a().cancel(i9);
        } catch (Exception e9) {
            m736a("cancel error" + e9);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private StatusBarNotification[] m740a() {
        if (!com.xiaomi.push.k.m649a(m742a())) {
            return null;
        }
        try {
            Object objA = com.xiaomi.push.bh.a(f1035a, "getActiveNotifications", m742a().getPackageName());
            if (objA instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) objA;
            }
            return null;
        } catch (Throwable th) {
            m736a("getAllNotifications error " + th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m736a(String str) {
        com.xiaomi.channel.commonutils.logger.c.m9a("NMHelper:" + str);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m739a(String str, String str2) {
        return str.startsWith(b(str2, ""));
    }

    public static boolean a(StatusBarNotification statusBarNotification) {
        return (statusBarNotification == null || statusBarNotification.getNotification() == null || TextUtils.isEmpty(ao.d(statusBarNotification.getNotification())) || !TextUtils.equals(ao.a(statusBarNotification), "com.xiaomi.xmsf") || !m739a(statusBarNotification.getNotification().getChannelId(), statusBarNotification.getPackageName())) ? false : true;
    }
}
