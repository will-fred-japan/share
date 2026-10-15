package com.engagelab.privates.common.observer;

import H2.a;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.binder.MTMessenger;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class MTObservable {
    private static final String TAG = "MTObservable";
    public static final int WHAT_OBSERVER = 101;
    private static volatile MTObservable instance;
    public ConcurrentLinkedQueue<MTObserver> observeQueue = new ConcurrentLinkedQueue<>();
    public ConcurrentLinkedQueue<String> observeNameQueue = new ConcurrentLinkedQueue<>();

    public static MTObservable getInstance() {
        if (instance == null) {
            synchronized (MTObservable.class) {
                instance = new MTObservable();
            }
        }
        return instance;
    }

    public void dispatchMessage(Context context, int i9, Bundle bundle) {
        for (MTObserver mTObserver : this.observeQueue) {
            try {
                if (mTObserver.isSupport(i9)) {
                    mTObserver.dispatchMessage(context, i9, bundle);
                }
            } catch (Throwable th) {
                MTCommonLog.w(TAG, "handleMessage dispatchMessage failed what=" + i9);
                a.k(th, new StringBuilder("handleMessage dispatchMessage failed "), TAG);
            }
        }
    }

    public void handleMessage(Context context, int i9, String str, int i10, Bundle bundle) {
        for (MTObserver mTObserver : this.observeQueue) {
            if (Arrays.asList(mTObserver.getThreadName()).contains(str) && mTObserver.isSupport(i10)) {
                if (i9 == 0) {
                    mTObserver.handleMessage(context, i10, bundle);
                }
                if (i9 == 1) {
                    mTObserver.handleDelayMessage(context, i10, bundle);
                }
            }
        }
    }

    public void observer(Context context, MTObserver mTObserver) {
        if (this.observeQueue.contains(mTObserver)) {
            return;
        }
        String canonicalName = mTObserver.getClass().getCanonicalName();
        if (this.observeNameQueue.contains(canonicalName)) {
            return;
        }
        MTCommonLog.d(TAG, "observer " + canonicalName);
        this.observeQueue.add(mTObserver);
        this.observeNameQueue.add(canonicalName);
        Bundle bundle = new Bundle();
        bundle.putString(MTCommonConstants.Observer.KEY_OBSERVER_NAME, canonicalName);
        if (MTGlobal.isMainProcess(context)) {
            boolean lifecycleState = MTGlobal.getLifecycleState();
            String currentActivityName = MTGlobal.getCurrentActivityName();
            if (!TextUtils.isEmpty(currentActivityName)) {
                bundle.putBoolean("state", lifecycleState);
                bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, currentActivityName);
                if (mTObserver.isSupport(1005) || mTObserver.isSupport(1006)) {
                    mTObserver.dispatchMessage(context, 1005, null);
                }
            }
            boolean networkState = MTGlobal.getNetworkState();
            int networkType = MTGlobal.getNetworkType();
            String networkName = MTGlobal.getNetworkName();
            String networkRadio = MTGlobal.getNetworkRadio();
            if (!TextUtils.isEmpty(networkRadio)) {
                bundle.putBoolean("state", networkState);
                bundle.putInt("type", networkType);
                bundle.putString(MTCommonConstants.Network.KEY_NAME, networkName);
                bundle.putString(MTCommonConstants.Network.KEY_RADIO, networkRadio);
                int i9 = MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED;
                if (mTObserver.isSupport(MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED) || mTObserver.isSupport(1004)) {
                    if (!networkState) {
                        i9 = 1004;
                    }
                    mTObserver.dispatchMessage(context, i9, null);
                }
            }
        }
        MTMessenger.getInstance().sendMessageToRemoteProcess(context, 101, bundle);
    }

    public void observerOnRemoteProcess(Context context, Bundle bundle) {
        try {
            String string = bundle.getString(MTCommonConstants.Observer.KEY_OBSERVER_NAME);
            if (this.observeNameQueue.contains(string)) {
                return;
            }
            Object objNewInstance = Class.forName(string).newInstance();
            if (objNewInstance instanceof MTObserver) {
                MTObserver mTObserver = (MTObserver) objNewInstance;
                observer(context, mTObserver);
                boolean z8 = bundle.getBoolean("state");
                String string2 = bundle.getString(MTCommonConstants.Lifecycle.KEY_ACTIVITY);
                if (!TextUtils.isEmpty(string2)) {
                    MTGlobal.setLifecycleState(z8);
                    MTGlobal.setCurrentActivityName(string2);
                    int i9 = MTCommonConstants.RemoteWhat.TO_FOREGROUND;
                    if (mTObserver.isSupport(MTCommonConstants.RemoteWhat.TO_FOREGROUND) || mTObserver.isSupport(MTCommonConstants.RemoteWhat.TO_BACKGROUND)) {
                        if (!z8) {
                            i9 = 1994;
                        }
                        mTObserver.dispatchMessage(context, i9, null);
                    }
                }
                boolean z9 = bundle.getBoolean("state");
                int i10 = bundle.getInt("type");
                String string3 = bundle.getString(MTCommonConstants.Network.KEY_NAME);
                String string4 = bundle.getString(MTCommonConstants.Network.KEY_RADIO);
                if (TextUtils.isEmpty(string4)) {
                    return;
                }
                MTGlobal.setNetworkState(z9);
                MTGlobal.setNetworkType(i10);
                MTGlobal.setNetworkName(string3);
                MTGlobal.setNetworkRadio(string4);
                int i11 = MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED;
                if (mTObserver.isSupport(MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED) || mTObserver.isSupport(MTCommonConstants.RemoteWhat.ON_NETWORK_DISCONNECTED)) {
                    if (!z8) {
                        i11 = 1996;
                    }
                    mTObserver.dispatchMessage(context, i11, null);
                }
            }
        } catch (Throwable th) {
            a.k(th, new StringBuilder("observer failed "), TAG);
        }
    }
}
