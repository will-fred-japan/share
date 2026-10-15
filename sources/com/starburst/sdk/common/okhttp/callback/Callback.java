package com.starburst.sdk.common.okhttp.callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public abstract class Callback<T> {
    public static Callback CALLBACK_DEFAULT = new Callback() { // from class: com.starburst.sdk.common.okhttp.callback.Callback.1
        @Override // com.starburst.sdk.common.okhttp.callback.Callback
        public Object parseNetworkResponse(Response response, int i9) {
            return null;
        }

        @Override // com.starburst.sdk.common.okhttp.callback.Callback
        public void onResponse(Object obj, int i9) {
        }

        @Override // com.starburst.sdk.common.okhttp.callback.Callback
        public void onError(Call call, Exception exc, int i9) {
        }
    };

    public abstract void onError(Call call, Exception exc, int i9);

    public abstract void onResponse(T t, int i9);

    public abstract T parseNetworkResponse(Response response, int i9);

    public boolean validateReponse(Response response, int i9) {
        return response.isSuccessful();
    }

    public void onAfter(int i9) {
    }

    public void onBefore(Request request, int i9) {
    }

    public void inProgress(float f6, long j, int i9) {
    }
}
