package com.jieli.jl_bt_ota.impl;

import android.os.Bundle;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import p130r.l;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16158a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f16161d;

    public /* synthetic */ d(IUpgradeCallback iUpgradeCallback, String str, boolean z8) {
        this.f16160c = iUpgradeCallback;
        this.f16161d = str;
        this.f16159b = z8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16158a) {
            case 0:
                ((IUpgradeCallback) this.f16160c).onNeedReconnect((String) this.f16161d, this.f16159b);
                break;
            default:
                ((l) this.f16160c).onSessionEnded(this.f16159b, (Bundle) this.f16161d);
                break;
        }
    }

    public /* synthetic */ d(l lVar, boolean z8, Bundle bundle) {
        this.f16160c = lVar;
        this.f16159b = z8;
        this.f16161d = bundle;
    }
}
