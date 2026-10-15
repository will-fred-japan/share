package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ContextUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f15919a;

    public static Context getInstance() {
        return f15919a;
    }

    public static void setContext(Context context) {
        if (context == null || f15919a != null) {
            return;
        }
        f15919a = context.getApplicationContext();
    }
}
