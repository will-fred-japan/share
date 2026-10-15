package com.vivo.push.h;

import com.vivo.push.model.RemoteNotificationContent;
import com.vivo.push.sdk.IExtensionCallback;

/* JADX INFO: compiled from: OnExtensionNotificationArriveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class t implements IExtensionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f16662a;

    public t(s sVar) {
        this.f16662a = sVar;
    }

    @Override // com.vivo.push.sdk.IExtensionCallback
    public final void onFinish(RemoteNotificationContent remoteNotificationContent) {
        com.vivo.push.util.w.c("OnExtensionNotificationArriveTask", "finish expire:" + this.f16662a.f16659a.k());
        s sVar = this.f16662a;
        p.a(sVar.f16661c, sVar.f16659a, remoteNotificationContent);
    }
}
