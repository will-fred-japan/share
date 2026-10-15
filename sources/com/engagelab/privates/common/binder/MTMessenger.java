package com.engagelab.privates.common.binder;

import H2.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.engagelab.privates.common.MTCommon;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.business.MTCommonBusiness;
import com.engagelab.privates.common.component.MTCommonService;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class MTMessenger {
    private static final String TAG = "MTMessenger";
    private static volatile MTMessenger instance;
    private Messenger mainMessenger;
    private Messenger remoteMessenger;
    private boolean serviceFlag = false;
    private boolean isInitOnMainProcess = false;
    private final ConcurrentLinkedQueue<Message> mainMessageQueue = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<Message> remoteMessageQueue = new ConcurrentLinkedQueue<>();

    public static MTMessenger getInstance() {
        if (instance == null) {
            synchronized (MTMessenger.class) {
                instance = new MTMessenger();
            }
        }
        return instance;
    }

    private boolean initConfig(Context context) {
        String appKey = MTGlobal.getAppKey(context);
        if (TextUtils.isEmpty(appKey)) {
            MTCommonLog.e(TAG, "appKey is empty, please check it");
        }
        String appChannel = MTGlobal.getAppChannel(context);
        String appProcess = MTGlobal.getAppProcess(context);
        String appVersionName = MTGlobal.getAppVersionName(context);
        int appVersionCode = MTGlobal.getAppVersionCode(context);
        StringBuilder sb = new StringBuilder("appVersionCode:");
        sb.append(appVersionCode);
        sb.append(", appVersionName:");
        sb.append(appVersionName);
        sb.append(", appKey:");
        a.j(sb, appKey, ", appChannel:", appChannel, ", appProcess:");
        sb.append(appProcess);
        MTCommonLog.d(TAG, sb.toString());
        MTCommonLog.d(TAG, "SDK_VERSION_NAME:5.4.2, SDK_VERSION_CODE:542");
        return true;
    }

    public IBinder getBinder() {
        Messenger messenger = this.remoteMessenger;
        if (messenger != null) {
            return messenger.getBinder();
        }
        MTCommonLog.e(TAG, "getBinder null");
        return null;
    }

    public void initMainMessenger(Messenger messenger) {
        if (messenger == null) {
            return;
        }
        try {
            this.mainMessenger = messenger;
            Iterator<Message> it = this.mainMessageQueue.iterator();
            while (it.hasNext()) {
                this.mainMessenger.send(it.next());
                it.remove();
            }
        } catch (Throwable th) {
            a.k(th, new StringBuilder("initMainMessenger failed "), TAG);
        }
    }

    public void initOnMainProcess(Context context) {
        try {
            if (this.mainMessenger == null) {
                MTCommonLog.i(TAG, "init common version:5.4.2");
                if (!initConfig(context)) {
                    return;
                }
                this.mainMessenger = new Messenger(new MainMessengerHandler(context, Looper.getMainLooper()));
                Iterator<Message> it = this.mainMessageQueue.iterator();
                while (it.hasNext()) {
                    this.mainMessenger.send(it.next());
                    it.remove();
                }
            }
            if (MTGlobal.isNeedRemoteProcess && !this.serviceFlag) {
                this.serviceFlag = true;
                this.isInitOnMainProcess = true;
                if (MTGlobal.getCommonService(context) == null) {
                    MTCommonLog.e(TAG, "MTCommonService is null, please create new Service extends MTCommonService");
                    return;
                }
                MTMessengerConnection mTMessengerConnection = new MTMessengerConnection(context);
                MTCommonService commonService = MTGlobal.getCommonService(context);
                if (commonService == null) {
                    MTCommonLog.e(TAG, "initOnMainProcess error, there are no service extends MTCommonService");
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(context, commonService.getClass());
                context.bindService(intent, mTMessengerConnection, 1);
            }
        } catch (Throwable th) {
            a.k(th, new StringBuilder("initOnMainProcess failed "), TAG);
        }
    }

    public void initOnRemoteProcess(Context context) {
        try {
            if (this.remoteMessenger != null) {
                return;
            }
            MTGlobal.isNeedRemoteProcess = true;
            MTCommonLog.i(TAG, "init common version:5.4.2");
            if (initConfig(context)) {
                this.remoteMessenger = new Messenger(new RemoteMessengerHandler(context, Looper.getMainLooper()));
                Iterator<Message> it = this.remoteMessageQueue.iterator();
                while (it.hasNext()) {
                    this.remoteMessenger.send(it.next());
                    it.remove();
                }
            }
        } catch (Throwable th) {
            a.k(th, new StringBuilder("initOnRemoteProcess failed "), TAG);
        }
    }

    public void onServiceConnected(Context context, IBinder iBinder) {
        MTCommonLog.i(TAG, "onServiceConnected");
        this.serviceFlag = true;
        MTCommonBusiness.getInstance().init(context);
        this.remoteMessenger = new Messenger(iBinder);
        try {
            Iterator<Message> it = this.remoteMessageQueue.iterator();
            while (it.hasNext()) {
                Message next = it.next();
                if (101 == next.what) {
                    this.remoteMessenger.send(next);
                    it.remove();
                }
            }
            Iterator<Message> it2 = this.remoteMessageQueue.iterator();
            while (it2.hasNext()) {
                this.remoteMessenger.send(it2.next());
                it2.remove();
            }
        } catch (Throwable th) {
            a.k(th, new StringBuilder("sendMessageToRemoteProcess failed "), TAG);
        }
        sendMessageToMainProcess(context, 1001, null);
        sendMessageToRemoteProcess(context, MTCommonConstants.RemoteWhat.ON_SERVICE_CONNECTED, null);
        sendMessageToRemoteProcess(context, MTCommonConstants.RemoteWhat.START_CONNECT, null);
    }

    public void onServiceDisconnected(Context context) {
        MTCommonLog.i(TAG, "onServiceDisconnected");
        this.serviceFlag = false;
        this.mainMessenger = null;
        this.remoteMessenger = null;
        this.mainMessageQueue.clear();
        this.remoteMessageQueue.clear();
        if (this.isInitOnMainProcess) {
            MTCommonLog.i(TAG, "onServiceDisconnected retry init");
            MTCommonPrivatesApi.sendMessageDelayed(context, MTCommon.THREAD_COMMON, 1000, null, 3000L);
        }
    }

    public void sendMessageToMainProcess(Context context, int i9, Bundle bundle) {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = i9;
            messageObtain.setData(bundle);
            Messenger messenger = this.mainMessenger;
            if (messenger != null) {
                messenger.send(messageObtain);
                return;
            }
            this.mainMessageQueue.add(messageObtain);
            if (this.isInitOnMainProcess) {
                MTCommonPrivatesApi.sendMessage(context, MTCommon.THREAD_COMMON, 1000, null);
            }
        } catch (DeadObjectException e9) {
            MTCommonLog.w(TAG, "sendMessageToMainProcess DeadObjectException " + e9.getMessage());
        } catch (Throwable th) {
            a.k(th, new StringBuilder("sendMessageToMainProcess failed "), TAG);
        }
    }

    public void sendMessageToRemoteProcess(Context context, int i9, Bundle bundle) {
        try {
            if (MTGlobal.isNeedRemoteProcess) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i9;
                messageObtain.setData(bundle);
                if (MTGlobal.isMainProcess(context)) {
                    messageObtain.replyTo = this.mainMessenger;
                }
                Messenger messenger = this.remoteMessenger;
                if (messenger == null) {
                    this.remoteMessageQueue.add(messageObtain);
                } else {
                    messenger.send(messageObtain);
                }
            }
        } catch (DeadObjectException e9) {
            MTCommonLog.w(TAG, "sendMessageToRemoteProcess DeadObjectException " + e9.getMessage());
        } catch (Throwable th) {
            a.k(th, new StringBuilder("sendMessageToRemoteProcess failed "), TAG);
        }
    }
}
