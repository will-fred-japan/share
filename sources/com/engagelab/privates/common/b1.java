package com.engagelab.privates.common;

import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue<Long> f12177a = new ConcurrentLinkedQueue<>();

    public int a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f12177a.size() < 10) {
            f12177a.offer(Long.valueOf(jCurrentTimeMillis));
            return 0;
        }
        long jLongValue = jCurrentTimeMillis - f12177a.element().longValue();
        if (jLongValue < 0) {
            f12177a.clear();
            MTCommonLog.w("MTOperationBusiness", "set tags/alias failed, time shaft error，please try again");
            return MTPushPrivatesApi.Code.INVOKE_TOO_SOON;
        }
        if (jLongValue <= 10000) {
            MTCommonLog.w("MTOperationBusiness", "set tags/alias too soon, over 10 times in 10s");
            return MTPushPrivatesApi.Code.INVOKE_TOO_SOON;
        }
        while (f12177a.size() >= 10) {
            f12177a.poll();
        }
        f12177a.offer(Long.valueOf(jCurrentTimeMillis));
        return 0;
    }
}
