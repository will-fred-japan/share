package cn.jpush.android.helper;

import android.content.Context;
import cn.jpush.android.ad.h;
import cn.jpush.android.local.ActionHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, ActionHelper.CallBack> f11403a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Object> f11404b = new ConcurrentHashMap();

    public static void a(Context context, String str) {
        Logger.d("AddCallBackHelper", "addCallBack context: " + context + ", clazz: " + str);
        Map<String, ActionHelper.CallBack> map = f11403a;
        if (map.containsKey(str)) {
            return;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (ActionHelper.CallBack.class.isAssignableFrom(cls)) {
                try {
                    ActionHelper.CallBack callBack = (ActionHelper.CallBack) cls.newInstance();
                    map.put(str, callBack);
                    Logger.d("AddCallBackHelper", "addCallBack success: " + callBack);
                    callBack.onData(context, ActionHelper.CallBack.TYPE_ADD_CALLBACK_SUCCESS, f11404b);
                } catch (Throwable th) {
                    Logger.d("AddCallBackHelper", "addCallBack error: " + th.getMessage());
                }
            }
        } catch (Throwable th2) {
            Logger.d("AddCallBackHelper", "addCallBack error2: " + th2.getMessage());
        }
    }

    public static void b(Context context, String str) {
        Logger.d("AddCallBackHelper", "onRegister context: " + context + ", registrationId: " + str);
        try {
            a(context, "register", str);
        } catch (Throwable th) {
            Logger.d("AddCallBackHelper", "onRegister error: " + th.getMessage());
        }
    }

    private static void a(final Context context, final String str, final Object obj) {
        Logger.d("AddCallBackHelper", "onData context: " + context + ", type: " + str + ", object: " + obj);
        JCoreHelper.futureExecutor(context, new h("add_call_back") { // from class: cn.jpush.android.helper.a.1
            @Override // cn.jpush.android.ad.h
            public void a() {
                try {
                    a.f11404b.put(str, obj);
                } catch (Throwable th) {
                    Logger.d("AddCallBackHelper", "onData error: " + th.getMessage());
                }
                try {
                    for (ActionHelper.CallBack callBack : a.f11403a.values()) {
                        try {
                            Logger.d("AddCallBackHelper", "onData callBack: " + callBack + ", type: " + str + ", object: " + obj);
                            callBack.onData(context, str, obj);
                        } catch (Throwable th2) {
                            Logger.d("AddCallBackHelper", "onData error1: " + th2.getMessage());
                        }
                    }
                } catch (Throwable th3) {
                    Logger.d("AddCallBackHelper", "onData error2: " + th3.getMessage());
                }
            }
        });
    }

    public static void a(Context context, boolean z8) {
        Logger.d("AddCallBackHelper", "onConnected context: " + context + ", isConnected: " + z8);
        try {
            a(context, ActionHelper.CallBack.TYPE_TCP_CONNECTED, Boolean.valueOf(z8));
        } catch (Throwable th) {
            Logger.d("AddCallBackHelper", "onConnected error: " + th.getMessage());
        }
    }
}
