package cn.jpush.android.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.VoipDataMessage;
import cn.jpush.android.m.a;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class JPushAction {
    public abstract Object beforLogin(Context context, String str, int i9, String str2);

    public Object getDataByCmd(Context context, int i9) {
        return null;
    }

    public abstract ProxyActivityAction getPopWinActivity(Context context);

    public abstract ProxyActivityAction getPushActivity(Context context);

    public String getSdkVersion(String str) {
        return a.f11448b;
    }

    public abstract Object handleAction(Context context, String str, Object obj);

    public abstract void handleNotificationIntent(Context context, Intent intent);

    public boolean isSupportedCMD(String str, int i9) {
        return i9 == 3 || i9 == 29 || i9 == 28 || i9 == 27 || i9 == 10 || i9 == 26 || i9 == 25 || i9 == 34 || i9 == 36 || i9 == 37;
    }

    public abstract void onActivityLifeCallback(Activity activity, String str);

    public abstract void onInAppMessageClick(Context context, NotificationMessage notificationMessage);

    public abstract void onInAppMessageShow(Context context, NotificationMessage notificationMessage);

    public abstract void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent);

    public abstract void onJPushMessageReceive(Context context, String str, String str2, Bundle bundle);

    public abstract void onMessage(Context context, CustomMessage customMessage);

    public abstract void onMultiAction(Context context, Intent intent);

    public abstract void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage);

    public abstract void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage);

    public abstract void onTagAliasResponse(Context context, long j, int i9, Intent intent);

    public abstract void setAliasAndTags(Context context, String str, Set<String> set, CallBackParams callBackParams);

    public void onVoipMessage(Context context, VoipDataMessage voipDataMessage) {
    }
}
