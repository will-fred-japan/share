package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.push.eo;

/* JADX INFO: loaded from: classes.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            com.xiaomi.channel.commonutils.logger.c.e("[CRcv] receive a msg broadcast: " + intent.getAction());
        }
        MessageHandleService.addJob(context.getApplicationContext(), new MessageHandleService.a(intent, this));
        try {
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (intExtra == 2000) {
                eo.a(context.getApplicationContext()).a(context.getPackageName(), intent, 2003, (String) null);
            } else if (intExtra == 6000) {
                eo.a(context.getApplicationContext()).a(context.getPackageName(), intent, AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, (String) null);
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.d("meet error in PushMessageReceiver. " + e9);
        }
    }

    public void onCallMessage(CallMessage callMessage) {
    }

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    @Deprecated
    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onRequirePermissions(Context context, String[] strArr) {
    }
}
