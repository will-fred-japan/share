package cn.jiguang.commons.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class fz extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ fy f10084a;

    public fz(fy fyVar) {
        this.f10084a = fyVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        fe.a().a(new ga(this, intent, action), fl.APP_COLLECTION);
    }
}
