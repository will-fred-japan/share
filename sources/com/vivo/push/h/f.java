package com.vivo.push.h;

import android.content.Context;
import android.content.Intent;
import java.util.Map;

/* JADX INFO: compiled from: NotifyOpenClientClickTask.java */
/* JADX INFO: loaded from: classes.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f16634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f16635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f16636c;

    public f(e eVar, Context context, Map map) {
        this.f16636c = eVar;
        this.f16634a = context;
        this.f16635b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent launchIntentForPackage = this.f16634a.getPackageManager().getLaunchIntentForPackage(this.f16634a.getPackageName());
        if (launchIntentForPackage == null) {
            com.vivo.push.util.w.a("NotifyOpenClientTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(268435456);
        e.b(launchIntentForPackage, this.f16635b);
        this.f16634a.startActivity(launchIntentForPackage);
    }
}
