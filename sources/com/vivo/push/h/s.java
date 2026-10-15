package com.vivo.push.h;

import com.vivo.push.model.RemoteNotificationInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: OnExtensionNotificationArriveTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.m f16659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RemoteNotificationInfo f16660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f16661c;

    public s(p pVar, com.vivo.push.b.m mVar, RemoteNotificationInfo remoteNotificationInfo) {
        this.f16661c = pVar;
        this.f16659a = mVar;
        this.f16660b = remoteNotificationInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.vivo.push.util.w.c("OnExtensionNotificationArriveTask", "start expire:" + this.f16659a.k() + " taskId:" + this.f16661c.f16653d);
        this.f16661c.f16652c.onExtensionTimeWillExpire(((com.vivo.push.t) this.f16661c).f16804a, this.f16660b, new t(this));
    }
}
