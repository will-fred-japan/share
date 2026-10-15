package com.vivo.push.restructure.request;

/* JADX INFO: loaded from: classes.dex */
public interface IPushRequestCallback<T> {
    void onError(int i9);

    void onSuccess(T t);
}
