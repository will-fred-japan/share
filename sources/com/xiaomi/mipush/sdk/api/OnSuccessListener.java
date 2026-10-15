package com.xiaomi.mipush.sdk.api;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnSuccessListener<TResult> {
    protected AtomicBoolean mCalled = new AtomicBoolean(false);

    public void callSuccess(TResult tresult) {
        if (this.mCalled.compareAndSet(false, true)) {
            onSuccess(tresult);
        }
    }

    public abstract void onSuccess(TResult tresult);
}
