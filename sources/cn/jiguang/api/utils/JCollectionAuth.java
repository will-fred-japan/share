package cn.jiguang.api.utils;

import android.content.Context;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.x.f;

/* JADX INFO: loaded from: classes.dex */
public class JCollectionAuth {
    public static void enableAppTerminate(Context context, boolean z8) {
        JCoreManager.onEvent(context, null, 119, null, null, Boolean.valueOf(z8));
    }

    public static void enableAutoWakeup(Context context, boolean z8) {
        f.e("JCollectAuth", "action: enableAutoWakeup: " + z8);
        JCoreManager.onEvent(context, null, 109, null, null, Boolean.valueOf(z8));
    }

    @Deprecated
    public static void enableDynamicLoad(Context context, boolean z8) {
        JCoreManager.onEvent(context, null, 115, null, null, Boolean.valueOf(z8));
    }

    @Deprecated
    public static void setAuth(Context context, boolean z8) {
        f.e("JCollectionAuth", "action:setAuth: " + z8);
        JCoreManager.onEvent(context, null, 96, null, null, Boolean.valueOf(z8));
    }
}
