package com.huawei.hms.framework.common;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActivityUtil {
    private static final int MAX_NUM = 20;
    private static final String TAG = "ActivityUtil";
    private static volatile ActivityUtil instance;
    private boolean isForeground;
    private List<OnAppStatusListener> onAppStatusListeners = new ArrayList();
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.huawei.hms.framework.common.ActivityUtil.1
        private int activityStartCount = 0;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i9 = this.activityStartCount + 1;
            this.activityStartCount = i9;
            if (i9 == 1) {
                ActivityUtil.this.isForeground = true;
                Logger.d(ActivityUtil.TAG, "onActivityStarted");
                for (int i10 = 0; i10 < ActivityUtil.this.onAppStatusListeners.size(); i10++) {
                    ((OnAppStatusListener) ActivityUtil.this.onAppStatusListeners.get(i10)).onFront();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i9 = this.activityStartCount - 1;
            this.activityStartCount = i9;
            if (i9 == 0) {
                Logger.d(ActivityUtil.TAG, "onActivityStopped");
                ActivityUtil.this.isForeground = false;
                for (int i10 = 0; i10 < ActivityUtil.this.onAppStatusListeners.size(); i10++) {
                    ((OnAppStatusListener) ActivityUtil.this.onAppStatusListeners.get(i10)).onBack();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    };

    public interface OnAppStatusListener {
        void onBack();

        void onFront();
    }

    private ActivityUtil() {
    }

    public static PendingIntent getActivities(Context context, int i9, Intent[] intentArr, int i10) {
        if (context == null) {
            Logger.w(TAG, "context is null");
            return null;
        }
        try {
            return PendingIntent.getActivities(context, i9, intentArr, i10);
        } catch (RuntimeException e9) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", e9);
            return null;
        }
    }

    public static ActivityUtil getInstance() {
        if (instance == null) {
            synchronized (ActivityUtil.class) {
                try {
                    if (instance == null) {
                        instance = new ActivityUtil();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return getInstance().isForeground();
    }

    public void register() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            ((Application) appContext).registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        } else {
            Logger.w(TAG, "context is not application, register background fail");
        }
    }

    public void setOnAppStatusListener(OnAppStatusListener onAppStatusListener) {
        if (onAppStatusListener == null) {
            Logger.w(TAG, "onAppStatusListener is null");
        } else if (this.onAppStatusListeners.size() >= 20) {
            Logger.w(TAG, "onAppStatusListener of count is max");
        } else {
            this.onAppStatusListeners.add(onAppStatusListener);
        }
    }

    public void unRegister() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            ((Application) appContext).unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        } else {
            Logger.w(TAG, "context is not application, unRegister background fail");
        }
    }

    public boolean isForeground() {
        return this.isForeground;
    }
}
