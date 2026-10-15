package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.x.b;

/* JADX INFO: loaded from: classes.dex */
public class BasicPushNotificationBuilder extends DefaultPushNotificationBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f11189a;
    public int statusBarDrawable;
    public int notificationDefaults = -2;
    public int notificationFlags = 16;
    public String developerArg0 = "developerArg0";

    public BasicPushNotificationBuilder(Context context) {
        this.statusBarDrawable = 0;
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        this.f11189a = context;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo == null) {
                Logger.ee("BasicPushNotificationBu", "JPush get NULL appInfo.");
            } else {
                this.statusBarDrawable = applicationInfo.icon;
            }
        } catch (Throwable unused) {
            Logger.ww("BasicPushNotificationBu", "[statusBarDrawable] JPush get NULL appInfo.");
        }
    }

    public static PushNotificationBuilder parseFromPreference(Context context, String str) {
        String[] strArrSplit = str.split("_____");
        String str2 = strArrSplit[0];
        BasicPushNotificationBuilder customPushNotificationBuilder = (!"basic".equals(str2) && "custom".equals(str2)) ? new CustomPushNotificationBuilder(context) : new BasicPushNotificationBuilder(context);
        customPushNotificationBuilder.a(strArrSplit);
        return customPushNotificationBuilder;
    }

    public String a() {
        return this.notificationDefaults + "_____" + this.notificationFlags + "_____" + this.statusBarDrawable + "_____" + this.developerArg0;
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder, cn.jpush.android.api.PushNotificationBuilder
    public String getDeveloperArg0() {
        return this.developerArg0;
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    @TargetApi(11)
    public Notification getNotification(Notification.Builder builder) {
        int i9 = this.notificationDefaults;
        if (i9 != -2) {
            builder.setDefaults(i9);
        }
        builder.setSmallIcon(this.statusBarDrawable);
        Context context = this.context;
        NotificationMessage notificationMessage = this.notificationMessage;
        b.a(context, notificationMessage.customButtons, builder, notificationMessage.msgId, (byte) notificationMessage.platform);
        Notification notificationBuild = builder.build();
        notificationBuild.flags = this.notificationFlags | 1;
        return notificationBuild;
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public void resetNotificationParams(Notification notification) {
        notification.defaults = this.notificationDefaults;
        notification.flags = this.notificationFlags;
        notification.icon = this.statusBarDrawable;
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return "basic_____" + a();
    }

    public void a(String[] strArr) {
        this.notificationDefaults = Integer.parseInt(strArr[1]);
        this.notificationFlags = Integer.parseInt(strArr[2]);
        this.statusBarDrawable = Integer.parseInt(strArr[3]);
        if (strArr.length >= 5) {
            this.developerArg0 = strArr[4];
        }
    }
}
