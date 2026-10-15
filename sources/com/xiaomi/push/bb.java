package com.xiaomi.push;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class bb implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        com.xiaomi.channel.commonutils.logger.c.c(Thread.currentThread().getName(), "Thread pool overflows, and this task has been refused.");
    }
}
