package cn.jpush.android.api;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.widget.RemoteViews;
import cn.jpush.android.helper.Logger;

/* JADX INFO: loaded from: classes.dex */
public class CustomPushNotificationBuilder extends BasicPushNotificationBuilder {
    public int layout;
    public int layoutContentId;
    public int layoutIconDrawable;
    public int layoutIconId;
    public int layoutTimeId;
    public int layoutTitleId;

    public CustomPushNotificationBuilder(Context context) {
        super(context);
        this.layoutIconDrawable = 0;
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder
    public String a() {
        return super.a() + "_____" + this.layout + "_____" + this.layoutIconId + "_____" + this.layoutTitleId + "_____" + this.layoutContentId + "_____" + this.layoutIconDrawable + "_____" + this.layoutTimeId;
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public RemoteViews buildContentView(String str, String str2) {
        RemoteViews remoteViews = new RemoteViews(this.f11189a.getPackageName(), this.layout);
        remoteViews.setTextViewText(this.layoutTitleId, str2);
        remoteViews.setImageViewResource(this.layoutIconId, this.layoutIconDrawable);
        remoteViews.setTextViewText(this.layoutContentId, str);
        int i9 = this.layoutTimeId;
        if (i9 != 0) {
            remoteViews.setLong(i9, "setTime", System.currentTimeMillis());
        }
        return remoteViews;
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder, cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return "custom_____" + a();
    }

    public CustomPushNotificationBuilder(Context context, int i9, int i10, int i11, int i12) {
        super(context);
        this.layoutIconDrawable = 0;
        this.layout = i9;
        this.layoutIconId = i10;
        this.layoutTitleId = i11;
        this.layoutContentId = i12;
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder
    public void a(String[] strArr) {
        super.a(strArr);
        this.layout = Integer.parseInt(strArr[5]);
        this.layoutIconId = Integer.parseInt(strArr[6]);
        this.layoutTitleId = Integer.parseInt(strArr[7]);
        this.layoutContentId = Integer.parseInt(strArr[8]);
        this.layoutIconDrawable = Integer.parseInt(strArr[9]);
        if (strArr.length == 11) {
            this.layoutTimeId = Integer.parseInt(strArr[10]);
        }
    }

    public CustomPushNotificationBuilder(Context context, int i9, int i10, int i11, int i12, int i13) {
        super(context);
        this.layoutIconDrawable = 0;
        this.layout = i9;
        this.layoutTitleId = i11;
        this.layoutContentId = i12;
        this.layoutTimeId = i13;
        this.layoutIconId = i10;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo == null) {
                Logger.ee("CustomPushNotificationB", "JPush get NULL appInfo.");
            } else {
                this.layoutIconDrawable = applicationInfo.icon;
            }
        } catch (Throwable unused) {
            Logger.ww("CustomPushNotificationB", "[statusBarDrawable] JPush get NULL appInfo.");
        }
    }
}
