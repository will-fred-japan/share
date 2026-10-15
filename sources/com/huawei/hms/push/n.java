package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.service.WakedResultReceiver;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* JADX INFO: compiled from: PushNotification.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f15433a;

    public static synchronized void a(Context context, o oVar) {
        int iHashCode;
        int iHashCode2;
        int i9;
        int iHashCode3;
        if (context != null) {
            try {
                if (!a(oVar)) {
                    HMSLog.d("PushSelfShowLog", "showNotification, the msg id = " + oVar.o());
                    if (f15433a == 0) {
                        f15433a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                    }
                    if (TextUtils.isEmpty(oVar.k())) {
                        String strP = oVar.p();
                        if (!TextUtils.isEmpty(strP)) {
                            int iHashCode4 = strP.hashCode();
                            oVar.a(iHashCode4);
                            HMSLog.d("PushSelfShowLog", "notification msgTag = " + iHashCode4);
                        }
                        if (oVar.r() != -1) {
                            iHashCode = oVar.r();
                            iHashCode3 = (oVar.j() + System.currentTimeMillis()).hashCode();
                            i9 = iHashCode3 + 1;
                            iHashCode2 = (oVar.r() + oVar.j() + context.getPackageName()).hashCode();
                        } else {
                            int i10 = f15433a;
                            int i11 = i10 + 1;
                            int i12 = i10 + 2;
                            int i13 = i10 + 3;
                            int i14 = i10 + 4;
                            f15433a = i14;
                            iHashCode2 = i14;
                            iHashCode = i11;
                            iHashCode3 = i12;
                            i9 = i13;
                        }
                    } else {
                        iHashCode = (oVar.k() + oVar.j()).hashCode();
                        int i15 = f15433a;
                        int i16 = i15 + 1;
                        int i17 = i15 + 2;
                        f15433a = i17;
                        iHashCode2 = (oVar.k() + oVar.j() + context.getPackageName()).hashCode();
                        i9 = i17;
                        iHashCode3 = i16;
                    }
                    HMSLog.d("PushSelfShowLog", "notifyId:" + iHashCode + ",openNotifyId:" + iHashCode3 + ",delNotifyId:" + i9 + ",alarmNotifyId:" + iHashCode2);
                    if (oVar.e() <= 0) {
                        iHashCode2 = 0;
                    }
                    Notification notificationA = e.d() ? a(context, oVar, new int[]{iHashCode, iHashCode3, i9, iHashCode2}) : null;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                    if (notificationManager != null && notificationA != null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        notificationManager.notify(iHashCode, notificationA);
                        l.a(context, oVar.o(), oVar.b(), "100");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static PendingIntent b(Context context, o oVar, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], a(context, oVar, iArr, WakedResultReceiver.WAKE_TYPE_KEY, 268435456), e.a());
    }

    private static PendingIntent c(Context context, o oVar, int[] iArr) {
        Intent intentA = a(context, oVar, iArr, "1", 268435456);
        if (!a()) {
            return PendingIntent.getBroadcast(context, iArr[1], intentA, e.a());
        }
        intentA.setClass(context, TransActivity.class);
        intentA.setFlags(268468224);
        return PendingIntent.getActivity(context, iArr[1], intentA, e.a());
    }

    private static void d(o oVar, Notification.Builder builder) {
        String strT = oVar.t();
        String strI = oVar.i();
        if (TextUtils.isEmpty(strI)) {
            builder.setContentText(strT);
            return;
        }
        builder.setContentText(strI);
        if (TextUtils.isEmpty(strT)) {
            return;
        }
        builder.setContentTitle(strT);
    }

    @SuppressLint({"NewApi"})
    private static void b(Context context, Notification.Builder builder, o oVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String strJ = oVar.j();
            if (TextUtils.isEmpty(strJ)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", strJ);
            builder.setExtras(bundle);
        }
    }

    private static void c(o oVar, Notification.Builder builder) {
        builder.setTicker(oVar.w());
    }

    private static void b(o oVar, Notification.Builder builder) {
        String strS = oVar.s();
        if (TextUtils.isEmpty(strS)) {
            return;
        }
        builder.setSubText(strS);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private static Intent a(Context context, o oVar, int[] iArr, String str, int i9) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", oVar.n()).putExtra("selfshow_token", oVar.x()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i9);
        return intent;
    }

    private static Notification a(Context context, o oVar, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (j.a(oVar) == k.STYLE_BIGTEXT) {
            j.a(builder, oVar.f(), oVar);
        }
        h.a(context, builder, oVar);
        b(oVar, builder);
        d(oVar, builder);
        a(context, oVar, builder);
        a(builder);
        a(oVar, builder);
        c(oVar, builder);
        builder.setContentIntent(c(context, oVar, iArr));
        builder.setDeleteIntent(b(context, oVar, iArr));
        builder.setChannelId("HwPushChannelID");
        b(context, builder, oVar);
        a(context, builder, oVar);
        return builder.build();
    }

    @SuppressLint({"NewApi"})
    private static void a(Context context, Notification.Builder builder, o oVar) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !e.a(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        String strJ = oVar.j();
        HMSLog.i("PushSelfShowLog", "the package name of notification is:" + strJ);
        if (!TextUtils.isEmpty(strJ)) {
            String strA = e.a(context, strJ);
            HMSLog.i("PushSelfShowLog", "the app name is:" + strA);
            if (strA != null) {
                bundle.putCharSequence("android.extraAppName", strA);
            }
        }
        builder.setExtras(bundle);
    }

    private static void a(Context context, o oVar, Notification.Builder builder) {
        Bitmap bitmapA = h.a(context, oVar);
        if (bitmapA != null) {
            builder.setLargeIcon(bitmapA);
        }
    }

    private static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    private static void a(o oVar, Notification.Builder builder) {
        builder.setAutoCancel(oVar.d() == 1);
        builder.setOngoing(false);
    }

    private static boolean a(o oVar) {
        if (oVar != null) {
            return TextUtils.isEmpty(oVar.t()) && TextUtils.isEmpty(oVar.i());
        }
        return true;
    }
}
