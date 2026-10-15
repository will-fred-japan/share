package cn.jiguang.commons.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class dh extends Handler {
    public dh(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 11) {
            ee.a("MeizuIdManager", "message type valid");
            return;
        }
        try {
            String unused = dg.f9882h = dg.f9878d.a(message.getData().getString("type"));
            synchronized (dg.f9879e) {
                dg.f9879e.notify();
            }
        } catch (Throwable th) {
            try {
                String unused2 = dg.f9882h = "";
                ee.a("MeizuIdManager", "getID exception, " + th.getMessage());
            } finally {
                synchronized (dg.f9879e) {
                    dg.f9879e.notify();
                }
            }
        }
    }
}
