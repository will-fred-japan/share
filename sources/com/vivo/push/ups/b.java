package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: compiled from: VUpsManager.java */
/* JADX INFO: loaded from: classes.dex */
final class b implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f16813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f16814b;

    public b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f16814b = vUpsManager;
        this.f16813a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i9) {
        this.f16813a.onResult(new TokenResult(i9, ""));
    }
}
