package cn.jpush.android.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (Build.VERSION.SDK_INT >= 33) {
            context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter, str, handler, 2);
        } else {
            context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
    }
}
