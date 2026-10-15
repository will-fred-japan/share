package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.w;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class OpenClientPushMessageReceiver extends BasePushMessageReceiver {
    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final boolean isAllowNet(Context context) {
        return super.isAllowNet(context);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onAppInstallCompleteShowMsg(String str) {
        w.d(BasePushMessageReceiver.TAG, "thirdPackageName=".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onBind(Context context, int i9, String str) {
        super.onBind(context, i9, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onForegroundMessageArrived(UPSNotificationMessage uPSNotificationMessage) {
        w.d(BasePushMessageReceiver.TAG, "");
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onListTags(Context context, int i9, List<String> list, String str) {
        super.onListTags(context, i9, list, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onLog(Context context, String str, int i9, boolean z8) {
        super.onLog(context, str, i9, z8);
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public final NotifyArriveCallbackByUser onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage) {
        return new NotifyArriveCallbackByUser(null, false);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onPublish(Context context, int i9, String str) {
        super.onPublish(context, i9, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onUnBind(Context context, int i9, String str) {
        super.onUnBind(context, i9, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotifyGuideDialogResult(int i9) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessageExpired(UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
    }

    public void onReceiveRegId(Context context, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelAlias(Context context, int i9, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelTags(Context context, int i9, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetAlias(Context context, int i9, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetTags(Context context, int i9, List<String> list, List<String> list2, String str) {
    }
}
