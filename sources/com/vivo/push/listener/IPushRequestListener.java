package com.vivo.push.listener;

/* JADX INFO: loaded from: classes.dex */
public interface IPushRequestListener<T, V> {
    void onFail(V v5);

    void onSuccess(T t);
}
