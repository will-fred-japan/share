package com.heytap.msp.push.callback;

/* JADX INFO: loaded from: classes.dex */
public interface ICallBackResultService {
    void onError(int i9, String str, String str2, String str3);

    void onGetNotificationStatus(int i9, int i10);

    void onGetPushStatus(int i9, int i10);

    void onRegister(int i9, String str, String str2, String str3);

    void onSetPushTime(int i9, String str);

    void onUnRegister(int i9, String str, String str2);
}
