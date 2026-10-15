package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
class bf extends ScheduledThreadPoolExecutor implements bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<bf> f17078a = new AtomicReference<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final bc f142a;

    private bf() {
        super(1);
        bc bcVar = new bc("schedule");
        this.f142a = bcVar;
        setThreadFactory(bcVar);
    }

    public static bf a() {
        AtomicReference<bf> atomicReference = f17078a;
        if (atomicReference.get() == null || atomicReference.get().isTerminated()) {
            synchronized (bf.class) {
                try {
                    if (atomicReference.get() == null || atomicReference.get().isTerminated()) {
                        atomicReference.set(new bf());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return atomicReference.get();
    }

    @Override // com.xiaomi.push.bg
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo120a() {
        a("");
    }

    @Override // com.xiaomi.push.bg
    public void a(String str) {
        Thread threadCurrentThread = Thread.currentThread();
        String str2 = this.f142a.f17074a + threadCurrentThread.getId();
        if (TextUtils.isEmpty(str)) {
            threadCurrentThread.setName(str2);
            return;
        }
        threadCurrentThread.setName(str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str);
    }
}
