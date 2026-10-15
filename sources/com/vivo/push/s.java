package com.vivo.push;

import com.engagelab.privates.common.constants.MTCommonConstants;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes.dex */
final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f16798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ n f16799b;

    public s(n nVar, String str) {
        this.f16799b = nVar;
        this.f16798a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.a aVarB = this.f16799b.b(this.f16798a);
        if (aVarB != null) {
            aVarB.a(MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED, new Object[0]);
        }
    }
}
