package J5;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f2687b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2688a = new Object();

    /* JADX INFO: compiled from: SnackbarManager.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b bVar = b.this;
            C0025b c0025b = (C0025b) message.obj;
            synchronized (bVar.f2688a) {
                try {
                    if (c0025b == null || c0025b == null) {
                        c0025b.getClass();
                        throw null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: J5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SnackbarManager.java */
    public static class C0025b {
    }

    public b() {
        new Handler(Looper.getMainLooper(), new a());
    }

    public static b a() {
        if (f2687b == null) {
            f2687b = new b();
        }
        return f2687b;
    }
}
