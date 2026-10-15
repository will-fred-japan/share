package com.starburst.sdk.core.auth.api;

import com.starburst.sdk.resp.AuthInfoRes;

/* JADX INFO: loaded from: classes.dex */
public interface IAuthInfoUpdateCallback {
    void onRequestSuccess();

    void onUpdateFailed();

    void onUpdateSuccess(AuthInfoRes authInfoRes);
}
