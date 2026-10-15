package com.starburst.sdk.common.okhttp.callback;

import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public abstract class StringCallback extends Callback<String> {
    @Override // com.starburst.sdk.common.okhttp.callback.Callback
    public String parseNetworkResponse(Response response, int i9) {
        return response.body().string();
    }
}
