package cn.jiguang.commons.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class kj {
    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, boolean z8) {
        int i9 = Build.VERSION.SDK_INT;
        Context applicationContext = context.getApplicationContext();
        if (i9 >= 33) {
            return applicationContext.registerReceiver(broadcastReceiver, intentFilter, str, handler, z8 ? 2 : 4);
        }
        return applicationContext.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z8) {
        int i9 = Build.VERSION.SDK_INT;
        Context applicationContext = context.getApplicationContext();
        return i9 >= 33 ? applicationContext.registerReceiver(broadcastReceiver, intentFilter, 4) : applicationContext.registerReceiver(broadcastReceiver, intentFilter);
    }
}
