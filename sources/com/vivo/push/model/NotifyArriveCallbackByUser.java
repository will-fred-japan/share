package com.vivo.push.model;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class NotifyArriveCallbackByUser {
    private Intent mIntent;
    private boolean mIsIntercept;
    private boolean mIsSetVivoSummaryIconRes;

    public NotifyArriveCallbackByUser(Intent intent, boolean z8) {
        this(intent, z8, true);
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public boolean isIntercept() {
        return this.mIsIntercept;
    }

    public boolean isSetVivoSummaryIconRes() {
        return this.mIsSetVivoSummaryIconRes;
    }

    public NotifyArriveCallbackByUser(Intent intent, boolean z8, boolean z9) {
        this.mIntent = intent;
        this.mIsIntercept = z8;
        this.mIsSetVivoSummaryIconRes = z9;
    }
}
