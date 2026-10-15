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
public class CommonActivityUtil {
    private static final int MAX_NUM = 20;
    private static final String TAG = "CommonActivityUtil";
    private static volatile CommonActivityUtil instance;
    private boolean isForeground;
    private List<OnAppStatusListener> onAppStatusListeners = new ArrayList();
    private boolean isRegistered = false;
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.huawei.hms.framework.common.CommonActivityUtil.1
        private int activityStartCount = 0;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Logger.i(CommonActivityUtil.TAG, "onActivityStarted");
            int i9 = this.activityStartCount + 1;
            this.activityStartCount = i9;
            if (i9 == 1) {
                CommonActivityUtil.this.isForeground = true;
                Logger.d(CommonActivityUtil.TAG, "onActivityStarted");
                for (int i10 = 0; i10 < CommonActivityUtil.this.onAppStatusListeners.size(); i10++) {
                    ((OnAppStatusListener) CommonActivityUtil.this.onAppStatusListeners.get(i10)).onFront();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            this.activityStartCount--;
            Logger.i(CommonActivityUtil.TAG, "onActivityStopped");
            if (this.activityStartCount == 0) {
                Logger.d(CommonActivityUtil.TAG, "onActivityStopped");
                CommonActivityUtil.this.isForeground = false;
                for (int i9 = 0; i9 < CommonActivityUtil.this.onAppStatusListeners.size(); i9++) {
                    ((OnAppStatusListener) CommonActivityUtil.this.onAppStatusListeners.get(i9)).onBack();
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

    private CommonActivityUtil() {
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

    public static CommonActivityUtil getInstance() {
        if (instance == null) {
            synchronized (CommonActivityUtil.class) {
                try {
                    if (instance == null) {
                        Logger.i(TAG, "new CommonActivityUtil");
                        instance = new CommonActivityUtil();
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

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void register(Context context) {
        if (context == null) {
            Logger.i(TAG, "appContext is null");
        }
        if (!(context instanceof Application)) {
            Logger.w(TAG, "context is not application, register background fail");
        } else {
            ((Application) context).registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
            this.isRegistered = true;
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
