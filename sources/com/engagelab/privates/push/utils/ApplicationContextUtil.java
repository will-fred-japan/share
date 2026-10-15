package com.engagelab.privates.push.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationContextUtil {
    public static Context mApplicationContext;

    public static Context getAppContext() {
        return mApplicationContext;
    }

    public static void init(Context context) {
        mApplicationContext = context;
    }
}
