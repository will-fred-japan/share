package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class az extends ThreadPoolExecutor implements bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bc f17070a;

    public az(int i9, long j, TimeUnit timeUnit, int i10, String str) {
        super(i9, i9, j, timeUnit, new ArrayBlockingQueue(i10), new bb());
        bc bcVar = new bc(str);
        this.f17070a = bcVar;
        setThreadFactory(bcVar);
        allowCoreThreadTimeOut(true);
    }

    @Override // com.xiaomi.push.bg
    /* JADX INFO: renamed from: a */
    public void mo120a() {
        a("");
    }

    @Override // com.xiaomi.push.bg
    public void a(String str) {
        Thread threadCurrentThread = Thread.currentThread();
        String str2 = this.f17070a.f17074a + threadCurrentThread.getId();
        if (TextUtils.isEmpty(str)) {
            threadCurrentThread.setName(str2);
            return;
        }
        threadCurrentThread.setName(str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str);
    }
}
