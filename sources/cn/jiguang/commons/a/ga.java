package cn.jiguang.commons.a;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class ga implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f10089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f10090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ fz f10091c;

    public ga(fz fzVar, Intent intent, String str) {
        this.f10091c = fzVar;
        this.f10089a = intent;
        this.f10090b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        fy.a(this.f10091c.f10084a, this.f10089a, this.f10090b);
    }
}
