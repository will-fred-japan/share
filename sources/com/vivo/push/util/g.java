package com.vivo.push.util;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: ClientHandlerTimer.java */
/* JADX INFO: loaded from: classes.dex */
final class g implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f16871a;

    public g(f fVar) {
        this.f16871a = fVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        if (message.what != 10001 || (obj = message.obj) == null || !(obj instanceof Runnable)) {
            return true;
        }
        ((Runnable) obj).run();
        this.f16871a.f16867c.remove(Integer.valueOf(message.arg1));
        return true;
    }
}
