package cn.jpush.android.local;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class ActivityLifeCallBack implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "ActivityLifeCallBack";
    public static int activityTaskCount;
    private String lastActivity;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ActivityLifeCallBack f11446a = new ActivityLifeCallBack();
    }

    private ActivityLifeCallBack() {
        this.lastActivity = "";
    }

    public static ActivityLifeCallBack getInstance() {
        return a.f11446a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "destroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "paused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "resumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "started");
        if (activityTaskCount == 0) {
            Logger.d(TAG, "is Foreground");
            if (activity != null) {
                JPushConstants.changeForegroudStat(activity.getApplicationContext(), true);
            }
        }
        activityTaskCount++;
        this.lastActivity = activity.getClass().getCanonicalName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "stopped");
        int i9 = activityTaskCount;
        if (i9 > 0) {
            activityTaskCount = i9 - 1;
        }
        if (activityTaskCount != 0 || activity == null) {
            return;
        }
        if (!TextUtils.equals(this.lastActivity, activity.getClass().getCanonicalName())) {
            activityTaskCount++;
        } else {
            Logger.d(TAG, "is not Foreground");
            JPushConstants.changeForegroudStat(activity.getApplicationContext(), false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
