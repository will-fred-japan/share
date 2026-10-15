package cn.ikaile.ruoshui.client.push;

import android.content.Context;
import cn.jpush.android.api.NotificationMessage;
import p087l6.a;
import p199z2.b;

/* JADX INFO: loaded from: classes.dex */
public class AppJPushEventReceiver extends a {
    @Override // p087l6.a, cn.jpush.android.service.JPushMessageReceiver
    public final void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        b.F(context);
        super.onNotifyMessageOpened(context, notificationMessage);
    }
}
