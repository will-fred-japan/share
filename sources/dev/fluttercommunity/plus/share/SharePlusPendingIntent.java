package dev.fluttercommunity.plus.share;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: SharePlusPendingIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SharePlusPendingIntent extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18539a = "";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "intent");
        ComponentName componentName = Build.VERSION.SDK_INT >= 33 ? (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT", ComponentName.class) : (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
        if (componentName != null) {
            f18539a = componentName.flattenToString();
        }
    }
}
