package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f16957a = new HashSet();

    public static void a(Context context) {
        a((Application) context.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (TextUtils.isEmpty(stringExtra) || intExtra <= 0 || this.f16957a.contains(stringExtra)) {
                return;
            }
            this.f16957a.add(stringExtra);
            if (intExtra == 3000) {
                eo.a(activity.getApplicationContext()).a(activity.getPackageName(), en.m346a(intExtra), stringExtra, MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS, null);
            } else if (intExtra == 1000) {
                eo.a(activity.getApplicationContext()).a(activity.getPackageName(), en.m346a(intExtra), stringExtra, MTCommonConstants.MainWhat.ON_LIFECYCLE_CHANGED, null);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.d("An error occurred in onActivityResumed method: " + th);
        }
    }

    private static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
