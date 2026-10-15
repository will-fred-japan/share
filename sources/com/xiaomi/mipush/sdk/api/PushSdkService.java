package com.xiaomi.mipush.sdk.api;

import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.BaseService;
import com.xiaomi.push.ba;

/* JADX INFO: loaded from: classes.dex */
public abstract class PushSdkService extends BaseService {
    public static final String EXTRA_TOKEN = "token";
    public static final String TASK_NAME_CALL_ON_NEW_TOKEN = "callOnNewToken";

    @Override // com.xiaomi.mipush.sdk.BaseService
    public boolean hasJob() {
        return false;
    }

    public abstract void onNewToken(String str);

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public int onStartCommand(final Intent intent, int i9, int i10) {
        if (intent != null && TextUtils.equals(intent.getAction(), "com.xiaomi.mipush.MESSAGING_EVENT")) {
            ba.a(TASK_NAME_CALL_ON_NEW_TOKEN, new Runnable() { // from class: com.xiaomi.mipush.sdk.api.PushSdkService.1
                @Override // java.lang.Runnable
                public void run() {
                    PushSdkService.this.onNewToken(intent.getStringExtra("token"));
                }
            }, false);
        }
        return super.onStartCommand(intent, i9, i10);
    }
}
