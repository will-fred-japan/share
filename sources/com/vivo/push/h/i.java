package com.vivo.push.h;

import android.text.TextUtils;

/* JADX INFO: compiled from: OnBindAppReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f16639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f16640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f16641c;

    public i(h hVar, String str, com.vivo.push.b.i iVar) {
        this.f16641c = hVar;
        this.f16639a = str;
        this.f16640b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f16639a)) {
            h hVar = this.f16641c;
            ((ag) hVar).f16620b.onReceiveRegId(((com.vivo.push.t) hVar).f16804a, this.f16639a);
        }
        h hVar2 = this.f16641c;
        ((ag) hVar2).f16620b.onBind(((com.vivo.push.t) hVar2).f16804a, this.f16640b.j(), this.f16640b.e());
    }
}
