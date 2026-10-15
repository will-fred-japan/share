package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import com.starburst.sdk.req.GuiControlRequest;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class UpdateAdapterMgr {
    public static final UpdateAdapterMgr INST = new UpdateAdapterMgr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f14855a;

    private Activity a() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f14855a;
        if (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    public boolean needStartUpdateActivity() {
        Activity activityA = a();
        if (activityA == null) {
            return true;
        }
        if (activityA.isTaskRoot()) {
            return false;
        }
        activityA.finish();
        HMSLog.i("UpdateAdapterMgr", " finish old activity.");
        return true;
    }

    public void onActivityCreate(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity activityA = a();
        if (activityA != null) {
            activityA.finish();
            HMSLog.i("UpdateAdapterMgr", "finish old activity.");
        }
        this.f14855a = new WeakReference<>(activity);
    }

    public void onActivityDestroy(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity activityA = a();
        if (activity == null || !activity.equals(activityA)) {
            return;
        }
        HMSLog.i("UpdateAdapterMgr", GuiControlRequest.TYPE_RESET);
        this.f14855a = null;
    }
}
