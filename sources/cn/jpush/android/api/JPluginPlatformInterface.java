package cn.jpush.android.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.thirdpush.huawei.a.a;
import cn.jpush.android.thirdpush.huawei.a.c;
import defpackage.f;

/* JADX INFO: loaded from: classes.dex */
public class JPluginPlatformInterface {
    public static final int JPLUGIN_REQUEST_CODE = 10001;
    private static final String TAG = "JPluginPlatformInterface";
    private c pHuaweiPushInterface;

    public JPluginPlatformInterface(Context context) {
        try {
            if (a.j(context)) {
                this.pHuaweiPushInterface = new c(context);
            }
        } catch (Throwable th) {
            f.p("new JPluginPlatformInterface failed:", TAG, th);
        }
    }

    public void onStart(Activity activity) {
        c cVar = this.pHuaweiPushInterface;
        if (cVar != null) {
            cVar.a(activity);
        }
    }

    public void onStop(Activity activity) {
        c cVar = this.pHuaweiPushInterface;
        if (cVar != null) {
            cVar.b(activity);
        }
    }

    public void onActivityResult(Activity activity, int i9, int i10, Intent intent) {
    }
}
