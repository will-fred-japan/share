package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class bc implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f17074a;

    public bc(String str) {
        this.f17074a = W5.e.u(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() { // from class: com.xiaomi.push.bc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.c.a(Thread.currentThread().getName(), th);
                }
            }
        });
        thread.setName(this.f17074a + thread.getId());
        return thread;
    }
}
