package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObserver;
import com.engagelab.privates.push.constants.MTPushConstants;

/* JADX INFO: loaded from: classes.dex */
public class f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile f1 f12205e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f12206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12207b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12208c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12209d = null;

    public static f1 a() {
        if (f12205e == null) {
            synchronized (f1.class) {
                f12205e = new f1();
            }
        }
        return f12205e;
    }

    public synchronized void b(Context context, Bundle bundle) {
        MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.OTH_SOUND_MESSAGE, bundle);
    }

    public synchronized void a(Context context, Bundle bundle) {
        Bundle bundle2;
        try {
            MTCommonLog.d("MTSoundBusiness", "on_tcp_connected init:" + this.f12207b);
            String appKey = MTGlobal.getAppKey(context);
            String str = this.f12209d;
            if (str == null) {
                this.f12209d = appKey;
            } else if (!str.equals(appKey)) {
                this.f12207b = false;
                this.f12206a = null;
            }
            if (this.f12207b) {
                return;
            }
            a(context);
            if (bundle != null && (bundle2 = this.f12206a) != null) {
                bundle.putAll(bundle2);
            }
            MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.OTH_SOUND_INIT, bundle);
            this.f12207b = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(Context context) {
        try {
            MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.oth.sound.OTHSound").newInstance());
            this.f12208c = true;
        } catch (Throwable unused) {
            MTCommonLog.d("MTSoundBusiness", "not integrated OTHSound.aar");
        }
    }

    public synchronized void a(Context context, boolean z8) {
        try {
            MTCommonLog.d("MTSoundBusiness", "setEnablePushTextToSpeech");
            Bundle bundle = new Bundle();
            bundle.putBoolean(MTPushConstants.OTHConfig.OTH_SOUND_ENABLE_SET, z8);
            if (this.f12207b && this.f12208c) {
                MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.OTH_SOUND_ENABLE_SET, bundle);
            } else {
                this.f12206a = bundle;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
