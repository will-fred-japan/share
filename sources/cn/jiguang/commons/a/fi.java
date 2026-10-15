package cn.jiguang.commons.a;

import com.huawei.hms.framework.common.BundleUtil;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
final class fi implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f10061b = new AtomicInteger(1);

    public fi(String str) {
        this.f10060a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f10060a + BundleUtil.UNDERLINE_TAG + this.f10061b.getAndIncrement());
        thread.setDaemon(true);
        thread.setUncaughtExceptionHandler(new fj(this));
        return thread;
    }
}
