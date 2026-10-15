package com.vivo.push.restructure.a.a;

import com.vivo.push.PushClient;

/* JADX INFO: compiled from: DispatchNode.java */
/* JADX INFO: loaded from: classes.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f16742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f16743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f16744c;

    public f(e eVar, int i9, String str) {
        this.f16744c = eVar;
        this.f16742a = i9;
        this.f16743b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f16742a;
        if (i9 == 3) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).unBindAlias(this.f16743b, null);
        } else if (i9 == 4) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).delTopic(this.f16743b, null);
        }
    }
}
