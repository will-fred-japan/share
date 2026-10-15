package com.engagelab.privates.flutter_plugin_engagelab;

import android.content.Context;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.push.api.AliasMessage;
import com.engagelab.privates.push.api.CustomMessage;
import com.engagelab.privates.push.api.InAppMessage;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.api.PlatformTokenMessage;
import com.engagelab.privates.push.api.TagMessage;
import com.engagelab.privates.push.api.VoipDataMessage;

/* JADX INFO: loaded from: classes.dex */
public class UserReceiver extends MTCommonReceiver {
    private static final String TAG = "UserReceiver";

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onAliasMessage(Context context, AliasMessage aliasMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onAliasMessage:" + aliasMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onAliasMessage", MsgToJson.aliasMessageToJson(aliasMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onConnectStatus(Context context, boolean z8) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onConnectState:" + z8);
        FlutterPluginEngagelabPlugin.onCommonReceiver("onConnectStatus", MsgToJson.booleanToJson(z8));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onCustomMessage(Context context, CustomMessage customMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onCustomMessage:" + customMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onCustomMessage", MsgToJson.customMessageToJson(customMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onInAppMessageClick(Context context, InAppMessage inAppMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onInAppMessageClick:" + inAppMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onInAppMessageClick", MsgToJson.inappMessageToJson(inAppMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onInAppMessageShow(Context context, InAppMessage inAppMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onInAppMessageShow:" + inAppMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onInAppMessageShow", MsgToJson.inappMessageToJson(inAppMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onNotificationArrived(Context context, NotificationMessage notificationMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onNotificationArrived:" + notificationMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onNotificationArrived", MsgToJson.notificationMessageToJson(notificationMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onNotificationClicked(Context context, NotificationMessage notificationMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onNotificationClicked:" + notificationMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onNotificationClicked", MsgToJson.notificationMessageToJson(notificationMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onNotificationDeleted(Context context, NotificationMessage notificationMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onNotificationDeleted:" + notificationMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onNotificationDeleted", MsgToJson.notificationMessageToJson(notificationMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onNotificationStatus(Context context, boolean z8) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onNotificationStatus:" + z8);
        FlutterPluginEngagelabPlugin.onCommonReceiver("onNotificationStatus", MsgToJson.booleanToJson(z8));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onNotificationUnShow(Context context, NotificationMessage notificationMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onNotificationUnShow:" + notificationMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onNotificationUnShow", MsgToJson.notificationMessageToJson(notificationMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onPlatformToken(Context context, PlatformTokenMessage platformTokenMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onPlatformToken:" + platformTokenMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onPlatformToken", MsgToJson.platformTokenMessageToJson(platformTokenMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onTagMessage(Context context, TagMessage tagMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onTagMessage:" + tagMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onTagMessage", MsgToJson.tagMessageToJson(tagMessage));
    }

    @Override // com.engagelab.privates.common.component.MTCommonReceiver
    public void onVoipMessage(Context context, VoipDataMessage voipDataMessage) {
        FlutterPluginEngagelabPlugin.logD(TAG, "onVoipMessage:" + voipDataMessage.toString());
        FlutterPluginEngagelabPlugin.onCommonReceiver("onVoipMessage", MsgToJson.voipMessageToJson(voipDataMessage));
    }
}
