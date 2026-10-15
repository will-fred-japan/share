package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.ad;
import com.vivo.push.util.w;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePushMessageReceiver extends BroadcastReceiver implements PushMessageCallback, VOIPMessageCallback {
    public static final String TAG = "PushMessageReceiver";

    @Override // com.vivo.push.sdk.PushMessageCallback
    public boolean isAllowNet(Context context) {
        if (context == null) {
            w.a(TAG, "isAllowNet sContext is null");
            return false;
        }
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            w.a(TAG, "isAllowNet pkgName is null");
            return false;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(packageName);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
            return ad.a(context, packageName);
        }
        w.a(TAG, "this is client sdk");
        return true;
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onAppInstallCompleteShowMsg(String str) {
        w.d(TAG, "thirdPackageName=".concat(String.valueOf(str)));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        w.c(TAG, "not need do something");
    }

    @Override // com.vivo.push.sdk.VOIPMessageCallback
    public void onCallMessage(CallMessage callMessage) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onForegroundMessageArrived(UPSNotificationMessage uPSNotificationMessage) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onNotifyGuideDialogResult(int i9) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessageExpired(UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onBind(Context context, int i9, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onPublish(Context context, int i9, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onUnBind(Context context, int i9, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onListTags(Context context, int i9, List<String> list, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onLog(Context context, String str, int i9, boolean z8) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelAlias(Context context, int i9, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelTags(Context context, int i9, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetAlias(Context context, int i9, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetTags(Context context, int i9, List<String> list, List<String> list2, String str) {
    }
}
