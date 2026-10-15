package cn.ikaile.ruoshui.client.push;

import android.content.Context;
import com.engagelab.privates.flutter_plugin_engagelab.UserReceiver;
import com.engagelab.privates.push.api.NotificationMessage;
import p199z2.b;

/* JADX INFO: loaded from: classes.dex */
public class AppEngageLabReceiver extends UserReceiver {
    @Override // com.engagelab.privates.flutter_plugin_engagelab.UserReceiver, com.engagelab.privates.common.component.MTCommonReceiver
    public final void onNotificationClicked(Context context, NotificationMessage notificationMessage) {
        b.F(context);
        super.onNotificationClicked(context, notificationMessage);
    }
}
