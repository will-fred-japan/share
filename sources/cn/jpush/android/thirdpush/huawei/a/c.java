package cn.jpush.android.thirdpush.huawei.a;

import android.app.Activity;
import android.content.Context;
import cn.jpush.android.helper.Logger;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Activity f11594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11595b;

    public c(Context context) {
        if (context == null) {
            Logger.ww("PluginHuaweiPushInterface", "context was null");
        } else {
            this.f11595b = a.j(context);
        }
    }

    public void a(Activity activity) {
        Logger.i("PluginHuaweiPushInterface", "onStart mActivity:" + this.f11594a + ",activity:" + activity);
        if (activity == null) {
            Logger.ww("PluginHuaweiPushInterface", "activity was null");
            return;
        }
        try {
            if (this.f11595b) {
                this.f11594a = activity;
                a();
            }
        } catch (Throwable th) {
            Logger.e("PluginHuaweiPushInterface", "onStart - error:" + th);
        }
    }

    public void b(Activity activity) {
        Logger.i("PluginHuaweiPushInterface", "onStop mActivity:" + this.f11594a + ",activity:" + activity);
        if (activity == null) {
            Logger.ww("PluginHuaweiPushInterface", "activity was null");
        }
        this.f11594a = null;
    }

    private void a() {
        Activity activity = this.f11594a;
        if (activity == null) {
            Logger.d("PluginHuaweiPushInterface", "[getToken] mActivity is null");
        } else {
            a.a((Context) activity, false);
        }
    }
}
