package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: ConcurrentUtils.java */
/* JADX INFO: loaded from: classes.dex */
final class j implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f16876a;

    public j(String str) {
        this.f16876a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f16876a);
        thread.setDaemon(true);
        return thread;
    }
}
