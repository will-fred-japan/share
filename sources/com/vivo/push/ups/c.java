package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: compiled from: VUpsManager.java */
/* JADX INFO: loaded from: classes.dex */
final class c implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f16815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f16816b;

    public c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f16816b = vUpsManager;
        this.f16815a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i9) {
        this.f16815a.onResult(new CodeResult(i9));
    }
}
