package com.vivo.push.restructure.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.i;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes.dex */
final class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f16795a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.f16795a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i9 = message.what;
        if (this.f16795a.f16790a.containsKey(Integer.valueOf(i9))) {
            i.a().execute(new f(this, (b) this.f16795a.f16790a.remove(Integer.valueOf(i9))));
        }
    }
}
