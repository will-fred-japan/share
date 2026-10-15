package cn.jpush.android.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jpush.android.helper.JCoreHelper;

/* JADX INFO: loaded from: classes.dex */
public class f {

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile a f11132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f11133b;

        public a(Context context, Looper looper) {
            super(looper);
            this.f11133b = context.getApplicationContext();
        }

        public static a a(Context context) {
            if (f11132a == null) {
                synchronized (f.class) {
                    try {
                        if (f11132a == null) {
                            f11132a = new a(context, Looper.getMainLooper());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f11132a;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof Runnable) {
                final Runnable runnable = (Runnable) obj;
                JCoreHelper.futureExecutor(this.f11133b, "HandlerDelay", new Runnable() { // from class: cn.jpush.android.ad.f.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                });
            }
        }
    }

    public static void a(Context context, int i9) {
        a.a(context).removeMessages(i9);
    }

    public static void a(Context context, int i9, long j, Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i9;
        messageObtain.obj = runnable;
        a.a(context).sendMessageDelayed(messageObtain, j);
    }
}
