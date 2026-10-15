package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<String, String, String> f18225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static Boolean f1039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a<String, String, String> f18226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a<String, String, String> f18227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a<String, String, String> f18228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a<String, String, String> f18229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a<String, String, String> f18230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a<String, String, String> f18231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a<String, String, String> f18232h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f1041a = {"com.mi.globalbrowser", "com.android.browser"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f1040a = null;

    public static class a<F, S, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        F f18233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        S f18234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f18235c;

        private a(F f6, S s8, T t) {
            this.f18233a = f6;
            this.f18234b = s8;
            this.f18235c = t;
        }
    }

    static {
        String str = "getNotificationSettings";
        f18225a = new a<>(str, str, str);
        String str2 = "canSound";
        f18226b = new a<>("setSound", str2, str2);
        String str3 = "canVibrate";
        f18227c = new a<>("setVibrate", str3, str3);
        String str4 = "canLights";
        f18228d = new a<>("setLights", str4, str4);
        String str5 = "canShowOnKeyguard";
        f18229e = new a<>("setShowOnKeyguard", str5, str5);
        f18230f = new a<>("setFloat", "canFloat", "canShowFloat");
        String str6 = "canShowBadge";
        f18231g = new a<>("setShowBadge", str6, str6);
        String str7 = "canShowOngoing";
        f18232h = new a<>("setShowOngoing", str7, str7);
    }

    public static boolean a() {
        Bundle bundleM786a;
        if (f1039a == null) {
            if (Build.VERSION.SDK_INT < 30 || (bundleM786a = g.m786a("com.xiaomi.xmsf", (String) null)) == null || bundleM786a.isEmpty()) {
                f1039a = Boolean.FALSE;
            } else {
                f1039a = Boolean.TRUE;
            }
        }
        return f1039a.booleanValue();
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence("android.text");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.bigText");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static String c(Notification notification) {
        Object objA;
        String string = null;
        try {
            Bundle bundle = notification.extras;
            string = bundle != null ? bundle.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE) : null;
            if (TextUtils.isEmpty(string) && (objA = com.xiaomi.push.bh.a(notification, "extraNotification")) != null) {
                return (String) com.xiaomi.push.bh.a(objA, "getTargetPkg", new Object[0]);
            }
        } catch (Exception unused) {
        }
        return string;
    }

    public static String d(Notification notification) {
        return (String) a(notification, MTPushConstants.Message.KEY_MESSAGE_ID, "");
    }

    public static void b(Notification notification, boolean z8) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableKeyguard", z8);
            }
            Object objA = com.xiaomi.push.bh.a(notification, "extraNotification");
            if (objA != null) {
                com.xiaomi.push.bh.a(objA, "setEnableKeyguard", Boolean.valueOf(z8));
            }
        } catch (Exception unused) {
        }
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence("android.title");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.title.big");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Notification.Action[] m750a(Notification notification) {
        Parcelable[] parcelableArray;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static <T> T a(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return null;
        }
        try {
            return (T) bundle.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map != null && bundle != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(map.get(str))) {
                bundle.remove(str);
                return;
            } else {
                bundle.putString(str, map.get(str));
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("cp map to b fail:" + str);
    }

    public static void a(Map<String, String> map, Bundle bundle, String str, String str2, boolean z8) {
        if (map != null && bundle != null && !TextUtils.isEmpty(str)) {
            String strRemove = z8 ? map.remove(str) : map.get(str);
            if (TextUtils.isEmpty(strRemove)) {
                bundle.remove(str);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            bundle.putString(str, strRemove);
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("cp map to b fail:" + str);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m748a(Notification notification, String str) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object objA = com.xiaomi.push.bh.a(notification, "extraNotification");
            if (objA != null) {
                com.xiaomi.push.bh.a(objA, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, boolean z8) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableFloat", z8);
            }
            Object objA = com.xiaomi.push.bh.a(notification, "extraNotification");
            if (objA != null) {
                com.xiaomi.push.bh.a(objA, "setEnableFloat", Boolean.valueOf(z8));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, int i9) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putInt("miui.messageCount", i9);
            }
            Object objA = com.xiaomi.push.bh.a(notification, "extraNotification");
            if (objA != null) {
                com.xiaomi.push.bh.a(objA, "setMessageCount", Integer.valueOf(i9));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, int i9, int i10) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i9);
            notification.extras.putInt("mipush_class", i10);
        }
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    public static <T> T a(Object obj, String str, T t) {
        Object objA = null;
        try {
            if (obj instanceof Notification) {
                objA = a((Notification) obj, str);
            } else if (obj instanceof Map) {
                objA = ((Map) obj).get(str);
            } else if (obj instanceof Bundle) {
                objA = ((Bundle) obj).get(str);
            } else {
                com.xiaomi.channel.commonutils.logger.c.m9a("not support get value from classType:" + obj);
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("get value error " + e9);
        }
        return objA == null ? t : (T) objA;
    }

    public static int a(Context context, String str) {
        return com.xiaomi.push.h.b(context, str);
    }

    public static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f1041a));
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            String str2 = (String) arrayList.get(i9);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e9) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("can't match url intent. " + e9);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("get user aggregate failed, " + e9);
            return 0;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m749a(ContentResolver contentResolver) {
        int iA = a(contentResolver);
        return iA == 1 || iA == 2;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a(map, "not_suppress", "true"));
    }

    public static boolean a(Notification.Builder builder, boolean z8) {
        builder.setGroupAlertBehavior(z8 ? 2 : 1);
        return true;
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar == null) {
            return -1;
        }
        try {
            Bundle bundleA = a(context, aVar.f18234b, str, str2, (Bundle) null);
            if (bundleA == null || !bundleA.containsKey(aVar.f18235c)) {
                return -1;
            }
            return bundleA.getBoolean(aVar.f18235c) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static Bundle a(Context context, String str, String str2) {
        try {
            Bundle bundleA = a(context, f18225a.f18234b, str, str2, (Bundle) null);
            if (bundleA != null) {
                return bundleA;
            }
        } catch (Exception unused) {
        }
        return new Bundle();
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z8) {
        if (aVar == null) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(aVar.f18235c, z8);
            a(context, aVar.f18233a, str, str2, bundle);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("package", str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle2.putString("channel_id", str3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
        }
        throw new IllegalArgumentException("call notification provider failed!");
    }

    public static String a(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null) {
            return "";
        }
        return (String) com.xiaomi.push.bh.a((Object) statusBarNotification, "getOpPkg", new Object[0]);
    }
}
