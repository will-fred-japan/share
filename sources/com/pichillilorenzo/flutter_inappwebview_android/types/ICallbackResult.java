package com.pichillilorenzo.flutter_inappwebview_android.types;

import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public interface ICallbackResult<T> extends l.d {
    T decodeResult(Object obj);

    void defaultBehaviour(T t);

    @Override // m7.l.d
    /* synthetic */ void error(String str, String str2, Object obj);

    boolean nonNullSuccess(T t);

    @Override // m7.l.d
    /* synthetic */ void notImplemented();

    boolean nullSuccess();

    @Override // m7.l.d
    /* synthetic */ void success(Object obj);
}
