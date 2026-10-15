package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: compiled from: VUpsManager.java */
/* JADX INFO: loaded from: classes.dex */
final class a implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f16811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f16812b;

    public a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f16812b = vUpsManager;
        this.f16811a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i9) {
        this.f16811a.onResult(new TokenResult(i9, com.vivo.push.restructure.a.a().h().b()));
    }
}
