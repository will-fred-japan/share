package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.log.MTLogConfigHelper;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static void a(Context context, Bundle bundle) {
        MTLogConfigHelper.Ctrl.ctrl(context, bundle.getInt(MTCoreConstants.Protocol.KEY_CMD), bundle.getString("protocol"));
    }

    public static void b(Context context, Bundle bundle) {
        MTLogConfigHelper.Report.report(context, MTCoreGlobal.getHttpAddress(context), x.s(context), x.h(context));
    }
}
