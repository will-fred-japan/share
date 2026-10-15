package cn.jiguang.push.asus;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Intent f10690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PushMessageReceiver f10691c;

    public a(PushMessageReceiver pushMessageReceiver, Context context, Intent intent) {
        this.f10691c = pushMessageReceiver;
        this.f10689a = context;
        this.f10690b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10691c.a(this.f10689a, this.f10690b);
    }
}
