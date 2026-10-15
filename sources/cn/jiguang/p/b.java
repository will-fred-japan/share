package cn.jiguang.p;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class b extends HandlerThread {
    public b(String str) {
        super(str);
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            super.run();
        } catch (Throwable unused) {
        }
    }
}
