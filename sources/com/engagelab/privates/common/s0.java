package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObserver;
import com.engagelab.privates.inapp.MTInApp;
import com.engagelab.privates.push.constants.MTPushConstants;

/* JADX INFO: loaded from: classes.dex */
public class s0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile s0 f12359b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12360a;

    public synchronized void a(Context context) {
        MTCommonLog.d("MTInAppBusiness", " init:" + this.f12360a);
        if (this.f12360a) {
            return;
        }
        b(context);
        this.f12360a = true;
    }

    public final void b(Context context) {
        try {
            String str = MTInApp.f12421a;
            MTCommonPrivatesApi.observer(context, (MTObserver) MTInApp.class.newInstance());
        } catch (Throwable unused) {
            MTCommonLog.d("MTInAppBusiness", "not integrated OTHSound.aar");
        }
    }

    public static s0 a() {
        if (f12359b == null) {
            synchronized (s0.class) {
                f12359b = new s0();
            }
        }
        return f12359b;
    }

    public synchronized void a(Context context, Bundle bundle) {
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.INAPP_MESSAGE, bundle);
    }
}
