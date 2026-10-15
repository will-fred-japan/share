package com.jieli.jl_bt_ota.interfaces;

import com.jieli.jl_bt_ota.model.base.BaseError;

/* JADX INFO: loaded from: classes.dex */
public interface IUpgradeCallback {
    void onCancelOTA();

    void onError(BaseError baseError);

    void onNeedReconnect(String str, boolean z8);

    void onProgress(int i9, float f6);

    void onStartOTA();

    void onStopOTA();
}
