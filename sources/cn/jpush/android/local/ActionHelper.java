package cn.jpush.android.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.h;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.api.VoipDataMessage;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JPushMessageReceiver;
import defpackage.f;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ActionHelper {
    private static final String TAG = "ActionHelper";
    private static volatile ActionHelper actionHelper;
    private static final Object locker = new Object();
    private JPushAction jPushAction;
    private cn.jpush.android.y.a loadedResource;
    int sequence = 10;

    public static abstract class CallBack {
        public static final String TYPE_ADD_CALLBACK_SUCCESS = "add_callback_success";
        public static final String TYPE_REGISTER = "register";
        public static final String TYPE_TCP_CONNECTED = "tcp_connected";

        public abstract void onData(Context context, String str, Object obj);
    }

    public class a extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f11437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Object f11439d;

        public a(Context context, String str, Object obj) {
            this.f11437b = context;
            this.f11438c = str;
            this.f11439d = obj;
            this.f11137e = "ActionHelper#Action";
        }

        @Override // cn.jpush.android.ad.h
        public void a() {
            try {
                ActionHelper.this.initLoad(this.f11437b);
                ActionHelper.this.jPushAction.handleAction(this.f11437b, this.f11438c, this.f11439d);
            } catch (Throwable unused) {
            }
        }
    }

    public class b extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f11441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f11443d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Set<String> f11444f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private CallBackParams f11445g;

        public b(Context context, String str, Set<String> set, int i9, CallBackParams callBackParams) {
            this.f11445g = callBackParams;
            this.f11442c = str;
            this.f11443d = i9;
            this.f11441b = context;
            this.f11444f = set;
            this.f11137e = "ActionHelper#TagAliasAction";
        }

        @Override // cn.jpush.android.ad.h
        public void a() {
            try {
                ActionHelper.this.initLoad(this.f11441b);
                ActionHelper.this.jPushAction.setAliasAndTags(this.f11441b, this.f11442c, this.f11444f, this.f11445g);
            } catch (Throwable unused) {
            }
        }
    }

    private ActionHelper() {
    }

    public static ActionHelper getInstance() {
        if (actionHelper == null) {
            synchronized (locker) {
                try {
                    if (actionHelper == null) {
                        actionHelper = new ActionHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return actionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0074 A[Catch: all -> 0x0083, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0006, B:18:0x0070, B:20:0x0074, B:17:0x005b, B:8:0x000c, B:10:0x0010, B:12:0x0016, B:14:0x0044), top: B:28:0x0006, inners: #1 }] */
    public synchronized void initLoad(Context context) {
        if (this.jPushAction != null) {
            return;
        }
        try {
            if (!JPushConstants.SUPPORT_DY || JConstants.SDK_VERSION_INT < 220) {
                if (this.jPushAction == null) {
                    Logger.d(TAG, "load from local");
                    this.jPushAction = new cn.jpush.android.l.a();
                }
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.loadedResource = cn.jpush.android.y.a.a(context);
            Logger.d(TAG, "load use time:" + (System.currentTimeMillis() - jCurrentTimeMillis) + ",lr:" + this.loadedResource);
            cn.jpush.android.y.a aVar = this.loadedResource;
            if (aVar != null) {
                Class clsB = aVar.b("cn.p.jpush.JPushActionImpl");
                Logger.d(TAG, "load from cloud");
                this.jPushAction = (JPushAction) clsB.newInstance();
            }
            if (this.jPushAction == null) {
                Logger.d(TAG, "load from local");
                this.jPushAction = new cn.jpush.android.l.a();
            }
            return;
        } catch (Throwable th) {
            Logger.ww(TAG, "try l p failed:" + th.getMessage());
        }
        throw th;
    }

    public void addCallBack(Context context, Class<? extends CallBack> cls) {
        JCoreHelper.majorExecutor(context, TAG, new a(context, "add_callback", cls.getName()));
    }

    public Object beforLogin(Context context, String str, int i9, String str2) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.beforLogin(context, str, i9, str2);
        }
        return null;
    }

    public void doAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doAction:" + str);
        JCoreHelper.majorExecutor(context, TAG, new a(context, str, obj));
    }

    public void doSingleAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doSingleAction: " + str);
        JCoreHelper.futureExecutor(context, TAG, new a(context, str, obj));
    }

    public Class getClassInPlugin(String str) {
        try {
            cn.jpush.android.y.a aVar = this.loadedResource;
            if (aVar == null) {
                return null;
            }
            Class clsB = aVar.b(str);
            Logger.d(TAG, "load class from p");
            if (clsB != null) {
                return clsB;
            }
            return null;
        } catch (Throwable th) {
            f.o("[getClassInPlugin] error:", TAG, th);
            return null;
        }
    }

    public Object getDataByCmd(Context context, int i9) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getDataByCmd(context, i9);
        }
        return null;
    }

    public ProxyActivityAction getPopWinActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPopWinActivity(context);
        }
        return null;
    }

    public ProxyActivityAction getPushActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPushActivity(context);
        }
        return null;
    }

    public int getResourceID(Context context, String str, String str2, String str3) {
        int identifier;
        StringBuilder sb;
        cn.jpush.android.y.a aVar = this.loadedResource;
        if (aVar != null) {
            identifier = aVar.a(str2, str);
            sb = new StringBuilder("[getResourceID] try load:");
        } else {
            identifier = context.getResources().getIdentifier(str, str2, str3);
            sb = new StringBuilder("[getResourceID]:");
        }
        sb.append(identifier);
        Logger.d(TAG, sb.toString());
        return identifier;
    }

    public String getSdkVersion(String str) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.getSdkVersion(str) : JPushConstants.SDK_VERSION_NAME;
    }

    public void handleNotificationIntent(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.handleNotificationIntent(context, intent);
        }
    }

    public boolean isSupportedCMD(String str, int i9) {
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.isSupportedCMD(str, i9);
        }
        return i9 == 3 || i9 == 29 || i9 == 28 || i9 == 27 || i9 == 10 || i9 == 26 || i9 == 25 || i9 == 34 || i9 == 36 || i9 == 37;
    }

    public void onActivityLifeCallback(Activity activity, String str) {
        JPushAction jPushAction;
        if (activity == null || (jPushAction = this.jPushAction) == null) {
            return;
        }
        jPushAction.onActivityLifeCallback(activity, str);
    }

    public void onEvent(Thread thread, Throwable th) {
        JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
    }

    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageClick(context, notificationMessage);
        }
    }

    public void onInAppMessageShow(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageShow(context, notificationMessage);
        }
    }

    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onJPushMessageReceive(context, jPushMessageReceiver, intent);
        }
    }

    public void onMessage(Context context, CustomMessage customMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMessage(context, customMessage);
        }
    }

    public void onMultiAction(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMultiAction(context, intent);
        }
    }

    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageArrived(context, notificationMessage);
        }
    }

    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageOpened(context, notificationMessage);
        }
    }

    public void onTagAliasResponse(Context context, long j, int i9, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onTagAliasResponse(context, j, i9, intent);
        }
    }

    public void onVoipMessage(Context context, VoipDataMessage voipDataMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onVoipMessage(context, voipDataMessage);
        }
    }

    public void setAliasAndTagsWithCallBack(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i9, int i10) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, set, 0, new CallBackParams(str, set, tagAliasCallback, System.currentTimeMillis(), i9, i10)));
    }

    public void setAliasWithCallBack(Context context, int i9, String str, int i10, int i11) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, null, i9, new CallBackParams(i9, str, System.currentTimeMillis(), i10, i11)));
    }

    public void setPropertyWithCallBack(Context context, int i9, Map<String, Object> map, int i10, int i11) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, null, i9, new CallBackParams(i9, map, System.currentTimeMillis(), i10, i11)));
    }

    public void setPushStatusWithCallBack(Context context, int i9, int i10) {
        int i11 = this.sequence + 1;
        this.sequence = i11;
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, null, this.sequence, new CallBackParams(i11, System.currentTimeMillis(), i9, i10)));
    }

    public void setTagsWithCallBack(Context context, int i9, Set<String> set, int i10, int i11) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, set, i9, new CallBackParams(i9, set, System.currentTimeMillis(), i10, i11)));
    }

    public void onJPushMessageReceive(Context context, String str, String str2, Bundle bundle) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onJPushMessageReceive(context, str, str2, bundle);
        }
    }
}
