package com.vivo.push.util;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface BaseNotifyLayoutAdapter {
    int getNotificationLayout();

    int getSuitIconId();

    int getTitleColor();

    void init(Context context);
}
