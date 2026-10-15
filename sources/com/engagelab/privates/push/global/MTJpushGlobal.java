package com.engagelab.privates.push.global;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.common.utils.DeviceUtil;
import com.engagelab.privates.common.x;

/* JADX INFO: loaded from: classes.dex */
public class MTJpushGlobal {
    public static String getUserLanguage(Context context) {
        String strT = x.t(context);
        return TextUtils.isEmpty(strT) ? DeviceUtil.getLanguage(context) : strT;
    }
}
