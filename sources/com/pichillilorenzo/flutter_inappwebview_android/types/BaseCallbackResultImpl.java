package com.pichillilorenzo.flutter_inappwebview_android.types;

/* JADX INFO: loaded from: classes.dex */
public class BaseCallbackResultImpl<T> implements ICallbackResult<T> {
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
    public T decodeResult(Object obj) {
        return null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
    public boolean nonNullSuccess(T t) {
        return true;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, m7.l.d
    public void notImplemented() {
        defaultBehaviour(null);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
    public boolean nullSuccess() {
        return true;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, m7.l.d
    public void success(Object obj) {
        T tDecodeResult = decodeResult(obj);
        if (tDecodeResult == null ? nullSuccess() : nonNullSuccess(tDecodeResult)) {
            defaultBehaviour(tDecodeResult);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
    public void defaultBehaviour(T t) {
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, m7.l.d
    public void error(String str, String str2, Object obj) {
    }
}
