package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public interface BusResponseCallback {
    BusResponseResult innerError(Activity activity, int i9, String str);

    BusResponseResult succeedReturn(Activity activity, int i9, Intent intent);
}
