package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: PushClientThread.java */
/* JADX INFO: loaded from: classes.dex */
final class v extends Handler {
    public v(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof t) {
            t tVar = (t) obj;
            com.vivo.push.util.w.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(tVar)));
            tVar.run();
        }
    }
}
