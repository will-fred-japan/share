package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public interface SystemNotifier {
    void notifyNoticeObservers(int i9);

    void notifyObservers(int i9);

    void notifyObservers(Intent intent, String str);

    void registerObserver(SystemObserver systemObserver);

    void unRegisterObserver(SystemObserver systemObserver);
}
