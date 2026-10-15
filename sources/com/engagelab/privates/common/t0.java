package com.engagelab.privates.common;

import android.content.Context;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObserver;

/* JADX INFO: loaded from: classes.dex */
public class t0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile t0 f12377b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12378a = false;

    public static t0 a() {
        if (f12377b == null) {
            synchronized (t0.class) {
                f12377b = new t0();
            }
        }
        return f12377b;
    }

    public final void b(Context context) {
        try {
            MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.oth.ma.OTHMa").newInstance());
        } catch (Throwable unused) {
            MTCommonLog.d("MTMABusiness", "not integrated OTHMa.aar");
        }
    }

    public synchronized void a(Context context) {
        MTCommonLog.d("MTMABusiness", "addObserver:" + this.f12378a);
        if (this.f12378a) {
            return;
        }
        b(context);
        this.f12378a = true;
    }
}
