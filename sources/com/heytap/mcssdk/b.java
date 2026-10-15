package com.heytap.mcssdk;

import android.app.Activity;
import android.content.Context;
import com.heytap.mcssdk.liquid.DownloadRequest;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ILiquidTaskQueryCallback;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.heytap.msp.push.callback.IPackageAuthCallbackListener;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
interface b {
    void cancelNotification(JSONObject jSONObject);

    void clearNotificationAdvanceCallback();

    @Deprecated
    void clearNotificationType();

    @Deprecated
    void clearNotificationType(JSONObject jSONObject);

    void clearNotifications();

    void clearNotifications(JSONObject jSONObject);

    void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    long getAppLimitCLickTime();

    void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService);

    void getNotificationStatus();

    void getNotificationStatus(JSONObject jSONObject);

    void getRegister();

    void getRegister(JSONObject jSONObject);

    String getRegisterID();

    boolean isSupportLiquid(Context context);

    boolean isSupportLiquidBatch(Context context);

    void openNotificationSettings();

    void openNotificationSettings(JSONObject jSONObject);

    void pausePush();

    void pausePush(JSONObject jSONObject);

    void queryLiquidTask(Context context, ILiquidTaskQueryCallback iLiquidTaskQueryCallback);

    void queryPackageAuthDetail(Context context, String str, IPackageAuthCallbackListener iPackageAuthCallbackListener);

    void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService);

    void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService);

    void requestDownloadSeeding(DownloadRequest downloadRequest);

    void requestDownloadSeedingList(List<DownloadRequest> list);

    void requestNotificationAdvance(Activity activity, INotificationPermissionCallback iNotificationPermissionCallback, int i9);

    void requestNotificationPermission();

    void resumePush();

    void resumePush(JSONObject jSONObject);

    @Deprecated
    void setNotificationType(int i9);

    @Deprecated
    void setNotificationType(int i9, JSONObject jSONObject);

    void setPushTime(List<Integer> list, int i9, int i10, int i11, int i12);

    void setPushTime(List<Integer> list, int i9, int i10, int i11, int i12, JSONObject jSONObject);

    void setRegisterID(String str);

    void unRegister();

    void unRegister(JSONObject jSONObject);
}
