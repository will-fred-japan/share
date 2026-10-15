package com.engagelab.privates.common.business.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.utils.Guard;
import com.engagelab.privates.common.utils.Utils;
import java.util.LinkedList;
import java.util.List;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class MTLifecycleListener implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "MTLifecycleListener";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f12178a = Guard.string(new byte[]{122, 103, 123, Utf8.REPLACEMENT_BYTE, 72, 73, 120, 103, 123, 120, 30, 77, 112, 120, 99, 98, 88, 14, 106, 108, 125, Utf8.REPLACEMENT_BYTE, 126, 79, 109, 97, 112, 120, 83, 65, 109, 97, 121, 127, 115, 76, 112, 107, 125, 116, 84, 97, 122, 124, 127, 103, 89, 84, 96});

        public static boolean b(Activity activity) {
            if (activity != null) {
                return f12178a.equals(activity.getClass().getCanonicalName());
            }
            return false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<String> f12179a = new LinkedList();

        public static void c(String str) {
            List<String> list = f12179a;
            synchronized (list) {
                list.add(str);
            }
        }

        public static void d(String str) {
            List<String> list = f12179a;
            synchronized (list) {
                try {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        List<String> list2 = f12179a;
                        if (str.equals(list2.get(size))) {
                            list2.remove(size);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public static String b() {
            StringBuilder sb = new StringBuilder();
            synchronized (f12179a) {
                int i9 = 0;
                while (true) {
                    try {
                        List<String> list = f12179a;
                        if (i9 < list.size()) {
                            sb.append("/" + list.get(i9));
                            i9++;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return sb.toString();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (a.b(activity)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        String className = activity.getComponentName().getClassName();
        b.c(className);
        bundle2.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, className);
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), MTCommonConstants.MainWhat.ON_ACTIVITY_CREATED, bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (a.b(activity)) {
            return;
        }
        Bundle bundle = new Bundle();
        String className = activity.getComponentName().getClassName();
        b.d(className);
        CharSequence title = activity.getTitle();
        if (title == null) {
            title = "";
        }
        bundle.putString("title", (String) title);
        bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, className);
        bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY_URL, b.b());
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), MTCommonConstants.MainWhat.ON_ACTIVITY_DESTROYED, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (a.b(activity)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, activity.getComponentName().getClassName());
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), MTCommonConstants.MainWhat.ON_ACTIVITY_PAUSED, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (a.b(activity)) {
            return;
        }
        Bundle bundle = new Bundle();
        String className = activity.getComponentName().getClassName();
        bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, className);
        Utils.setWindowManager(className, activity.getWindowManager());
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), 1013, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a.b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (a.b(activity)) {
            return;
        }
        Bundle bundle = new Bundle();
        CharSequence title = activity.getTitle();
        if (title == null) {
            title = "";
        }
        bundle.putString("title", (String) title);
        bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, activity.getComponentName().getClassName());
        bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY_URL, b.b());
        bundle.putBoolean("state", true);
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), MTCommonConstants.MainWhat.ON_LIFECYCLE_CHANGED, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (a.b(activity)) {
            return;
        }
        Bundle bundle = new Bundle();
        String className = activity.getComponentName().getClassName();
        CharSequence title = activity.getTitle();
        if (title == null) {
            title = "";
        }
        bundle.putString("title", (String) title);
        bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, className);
        bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY_URL, b.b());
        bundle.putBoolean("state", false);
        Utils.clearWindowManagerForActivity(className);
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), MTCommonConstants.MainWhat.ON_LIFECYCLE_CHANGED, bundle);
    }
}
