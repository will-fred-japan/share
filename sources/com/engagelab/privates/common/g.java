package com.engagelab.privates.common;

import android.content.Context;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f12210c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f12211a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12212b = 0;

    public static g a() {
        if (f12210c == null) {
            synchronized (g.class) {
                f12210c = new g();
            }
        }
        return f12210c;
    }

    public void b(Context context) {
        if (x.c(context)) {
            if (!i.a().b()) {
                MTCommonLog.d("MTActiveBusiness", "re connect toForeground");
                MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.START_CONNECT, null);
            } else {
                if (this.f12212b == 0) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f12211a = jCurrentTimeMillis;
                if (jCurrentTimeMillis - this.f12212b < MTCoreGlobal.getHeartbeatInterval() / 2) {
                    return;
                }
                MTCommonLog.d("MTActiveBusiness", "re heartbeat");
                i.a().g(context);
                i.a().e(context);
            }
        }
    }

    public void a(Context context) {
        if (x.c(context)) {
            this.f12212b = System.currentTimeMillis();
        }
    }
}
