package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
public interface IBridgeActivityDelegate {
    int getRequestCode();

    void onBridgeActivityCreate(Activity activity);

    void onBridgeActivityDestroy();

    boolean onBridgeActivityResult(int i9, int i10, Intent intent);

    void onBridgeConfigurationChanged();

    void onKeyUp(int i9, KeyEvent keyEvent);
}
