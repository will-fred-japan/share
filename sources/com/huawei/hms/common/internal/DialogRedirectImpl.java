package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f14962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Intent f14964c;

    public DialogRedirectImpl(Intent intent, Activity activity, int i9) {
        this.f14964c = intent;
        this.f14962a = activity;
        this.f14963b = i9;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.f14964c;
        if (intent == null || (activity = this.f14962a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.f14963b);
    }
}
