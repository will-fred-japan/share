package com.starburst.sdk.core.auth.callback;

import com.starburst.sdk.core.auth.model.GetTokenResponseBean;

/* JADX INFO: loaded from: classes.dex */
public interface TokenReceivedCallback {
    void onTokenReceived(GetTokenResponseBean getTokenResponseBean);

    void onTokenReceivedFailed(String str);
}
