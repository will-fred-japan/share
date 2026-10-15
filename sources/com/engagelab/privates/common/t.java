package com.engagelab.privates.common;

import android.content.Context;
import com.engagelab.privates.common.config.MTRemoteConfigHelper;
import com.engagelab.privates.core.global.MTCoreGlobal;

/* JADX INFO: loaded from: classes.dex */
public class t {
    public static void a(Context context) {
        MTRemoteConfigHelper.start(context, MTCoreGlobal.getHttpAddress(context), x.s(context), x.h(context));
    }
}
