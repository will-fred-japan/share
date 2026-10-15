package cn.jiguang.commons.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class hr extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ hq f10160a;

    public hr(hq hqVar) {
        this.f10160a = hqVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        fe.a().a(new hs(this, action), fl.LIGHT_TASK);
    }
}
