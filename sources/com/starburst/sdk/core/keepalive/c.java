package com.starburst.sdk.core.keepalive;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.CancellationSignal;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16431b;

    public /* synthetic */ c(int i9, Object obj) {
        this.f16430a = i9;
        this.f16431b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        switch (this.f16430a) {
            case 0:
                KeepAliveManager.lambda$showConfirmDialog$2((Activity) this.f16431b, dialogInterface, i9);
                break;
            default:
                ((CancellationSignal) this.f16431b).cancel();
                break;
        }
    }
}
