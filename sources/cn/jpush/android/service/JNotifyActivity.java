package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;

/* JADX INFO: loaded from: classes.dex */
public class JNotifyActivity extends Activity {
    private static final String TAG = "JNotifyActivity";

    private void handleIntent(Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        try {
            ActionHelper.getInstance().handleNotificationIntent(getApplicationContext(), intent);
            finish();
        } catch (Throwable th) {
            try {
                Logger.d(TAG, "handle intent failed:" + th.getMessage());
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setFlags(8192, 8192);
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setBackgroundColor(0);
            setContentView(frameLayout);
            handleIntent(getIntent());
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            handleIntent(intent);
        } catch (Throwable unused) {
        }
    }
}
