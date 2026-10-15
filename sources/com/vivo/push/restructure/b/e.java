package com.vivo.push.restructure.b;

import android.content.Context;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ak;

/* JADX INFO: compiled from: PushRelyImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f16766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PushConfig f16767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f16768c;

    public e(d dVar, Context context, PushConfig pushConfig) {
        this.f16768c = dVar;
        this.f16766a = context;
        this.f16767b = pushConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f16766a;
        ak.a(context, context.getPackageName(), this.f16767b.isAgreePrivacyStatement());
    }
}
