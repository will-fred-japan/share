package com.starburst.sdk.core.keepalive;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.CancellationSignal;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16428b;

    public /* synthetic */ a(int i9, Object obj) {
        this.f16427a = i9;
        this.f16428b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        switch (this.f16427a) {
            case 0:
                KeepAliveManager.lambda$showBatteryOptimizationDialog$0((Activity) this.f16428b, dialogInterface, i9);
                break;
            default:
                ((CancellationSignal) this.f16428b).cancel();
                break;
        }
    }
}
