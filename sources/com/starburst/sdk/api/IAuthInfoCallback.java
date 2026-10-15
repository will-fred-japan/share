package com.starburst.sdk.api;

import com.starburst.sdk.resp.AuthInfoRes;

/* JADX INFO: loaded from: classes.dex */
public interface IAuthInfoCallback {
    void onFailure(int i9, String str);

    void onSuccess(AuthInfoRes authInfoRes);
}
