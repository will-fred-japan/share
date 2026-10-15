package com.engagelab.privates.common.business;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.binder.MTMessenger;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.observer.MTObservable;
import com.engagelab.privates.common.observer.MTObserver;

/* JADX INFO: loaded from: classes.dex */
public class MTCommonBusiness {
    private static final String TAG = "MTCommonBusiness";
    private static volatile MTCommonBusiness instance;

    public static MTCommonBusiness getInstance() {
        if (instance == null) {
            synchronized (MTCommonBusiness.class) {
                instance = new MTCommonBusiness();
            }
        }
        return instance;
    }

    public void init(Context context) {
        for (String str : MTObservable.getInstance().observeNameQueue) {
            Bundle bundle = new Bundle();
            bundle.putString(MTCommonConstants.Observer.KEY_OBSERVER_NAME, str);
            MTMessenger.getInstance().sendMessageToRemoteProcess(context, 101, bundle);
        }
        try {
            Object objNewInstance = Class.forName("com.engagelab.privates.collect.MTCollect").newInstance();
            if (objNewInstance instanceof MTObserver) {
                MTCommonPrivatesApi.observer(context.getApplicationContext(), (MTObserver) objNewInstance);
            }
        } catch (Throwable unused) {
        }
        try {
            Object objNewInstance2 = Class.forName("com.engagelab.privates.geofence.MTGeofence").newInstance();
            if (objNewInstance2 instanceof MTObserver) {
                MTCommonPrivatesApi.observer(context.getApplicationContext(), (MTObserver) objNewInstance2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Object objNewInstance3 = Class.forName("cn.jiguang.privates.wake.MTWake").newInstance();
            if (objNewInstance3 instanceof MTObserver) {
                MTCommonPrivatesApi.observer(context.getApplicationContext(), (MTObserver) objNewInstance3);
            }
        } catch (Throwable unused3) {
        }
    }

    public void release(Context context) {
    }
}
