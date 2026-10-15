package cn.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;

/* JADX INFO: loaded from: classes.dex */
public class JTransitActivity extends Activity {
    public final void a(Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        try {
            ActionHelper.getInstance().handleNotificationIntent(getApplicationContext(), intent);
            finish();
        } catch (Throwable th) {
            try {
                Logger.d("JTransitActivity", "handle intent failed:" + th.getMessage());
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setFlags(8192, 8192);
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setBackgroundColor(0);
            setContentView(frameLayout);
            a(getIntent());
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            a(intent);
        } catch (Throwable unused) {
        }
    }
}
