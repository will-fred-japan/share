package com.xiaomi.mipush.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface Task<TResult> {
    Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener);

    Task<TResult> addOnFailureListener(OnFailureListener onFailureListener);

    Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener);

    Exception getException();

    TResult getResult();

    boolean isComplete();

    boolean isSuccessful();

    void setException(Exception exc);

    void setResult(TResult tresult);
}
