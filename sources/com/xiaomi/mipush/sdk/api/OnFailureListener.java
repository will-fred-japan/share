package com.xiaomi.mipush.sdk.api;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnFailureListener {
    protected AtomicBoolean mCalled = new AtomicBoolean(false);

    public void callFailure(Exception exc) {
        if (this.mCalled.compareAndSet(false, true)) {
            onFailure(exc);
        }
    }

    public abstract void onFailure(Exception exc);
}
