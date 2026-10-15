package com.vivo.push;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: IPCManager.java */
/* JADX INFO: loaded from: classes.dex */
final class k implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f16682a;

    public k(j jVar) {
        this.f16682a = jVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message == null) {
            com.vivo.push.util.w.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i9 = message.what;
        if (i9 == 1) {
            com.vivo.push.util.w.a("AidlManager", "In connect, bind core service time out");
            if (this.f16682a.f16678f.get() == 2) {
                this.f16682a.a(1);
            }
        } else if (i9 != 2) {
            com.vivo.push.util.w.b("AidlManager", "unknow msg what [" + message.what + "]");
        } else {
            if (this.f16682a.f16678f.get() == 4) {
                this.f16682a.f();
            }
            this.f16682a.a(1);
        }
        return true;
    }
}
