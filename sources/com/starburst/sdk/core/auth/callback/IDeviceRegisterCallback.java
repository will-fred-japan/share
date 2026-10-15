package com.starburst.sdk.core.auth.callback;

import com.starburst.sdk.core.auth.model.DeviceRegisterRespBean;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceRegisterCallback {
    void onDeviceRegisterFailed(String str);

    void onDeviceRegisterSuccess(DeviceRegisterRespBean deviceRegisterRespBean);
}
