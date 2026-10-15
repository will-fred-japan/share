package com.xiaomi.mipush.sdk.api;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnCompleteListener<TResult> {
    protected AtomicBoolean mCalled = new AtomicBoolean(false);

    public void callComplete(Task<TResult> task) {
        if (this.mCalled.compareAndSet(false, true)) {
            onComplete(task);
        }
    }

    public abstract void onComplete(Task<TResult> task);
}
