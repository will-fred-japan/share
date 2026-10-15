package com.engagelab.privates.common.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.MTCommon;
import com.engagelab.privates.common.binder.MTMessenger;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.handler.MTHandler;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;
import com.engagelab.privates.common.observer.MTObserver;

/* JADX INFO: loaded from: classes.dex */
public class MTCommonPrivatesApi {
    public static final int SDK_VERSION_CODE = 542;
    public static final String SDK_VERSION_NAME = "5.4.2";
    private static final String TAG = "MTCommonPrivatesApi";

    public static void buildHandler(Context context, String str) {
        MTHandler.getInstance().buildHandler(context, str);
    }

    public static void init(Context context, boolean z8) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't init with empty context");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTGlobal.context = context.getApplicationContext();
            MTGlobal.isNeedRemoteProcess = z8 || MTGlobal.isNeedRemoteProcess;
            if (MTGlobal.isMainProcess(context.getApplicationContext())) {
                sendMessage(context, MTCommon.THREAD_COMMON, 1000, null);
            }
        }
    }

    public static void observer(Context context, MTObserver mTObserver) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't observer with empty context");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTObservable.getInstance().observer(context.getApplicationContext(), mTObserver);
        } else {
            MTCommonLog.e(TAG, "can't observer in another process");
        }
    }

    public static void postMessageDelayed(Context context, String str, Runnable runnable, long j) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't postMessageDelayed with empty context");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "can't postMessageDelayed with empty name");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTHandler.getInstance().postMessageDelayed(context, str, runnable, j);
        } else {
            MTCommonLog.e(TAG, "can't postMessageDelayed in another process");
        }
    }

    public static void releaseHandler(Context context, String str) {
        MTHandler.getInstance().releaseHandler(context, str);
    }

    public static void removeMessages(Context context, String str, int i9) {
        MTHandler.getInstance().removeMessages(context, str, i9);
    }

    public static void sendMessage(Context context, String str, int i9, Bundle bundle) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't sendMessage with empty context");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "can't sendMessage with empty name");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTHandler.getInstance().sendMessage(context, str, i9, bundle);
        } else {
            MTCommonLog.e(TAG, "can't sendMessage in another process");
        }
    }

    public static void sendMessageDelayed(Context context, String str, int i9, Bundle bundle, long j) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't sendMessageDelayed with empty context");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "can't sendMessageDelayed with empty name");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTHandler.getInstance().sendMessageDelayed(context, str, i9, bundle, j);
        } else {
            MTCommonLog.e(TAG, "can't sendMessageDelayed in another process");
        }
    }

    public static void sendMessageToMainProcess(Context context, int i9, Bundle bundle) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't sendMessageToMainProcess with empty context");
        } else {
            MTMessenger.getInstance().sendMessageToMainProcess(context.getApplicationContext(), i9, bundle);
        }
    }

    public static void sendMessageToRemoteProcess(Context context, int i9, Bundle bundle) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't sendMessageToRemoteProcess with empty context");
        } else {
            MTMessenger.getInstance().sendMessageToRemoteProcess(context.getApplicationContext(), i9, bundle);
        }
    }

    public static void buildHandler(Context context, String str, int i9) {
        MTHandler.getInstance().buildHandler(context, str, i9);
    }
}
