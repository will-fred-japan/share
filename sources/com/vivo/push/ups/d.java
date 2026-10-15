package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: compiled from: VUpsManager.java */
/* JADX INFO: loaded from: classes.dex */
final class d implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f16817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f16818b;

    public d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f16818b = vUpsManager;
        this.f16817a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i9) {
        this.f16817a.onResult(new CodeResult(i9));
    }
}
