package S4;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class Q implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S f4144a;

    public /* synthetic */ Q(S s8) {
        this.f4144a = s8;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i9 = message.what;
        if (i9 == 0) {
            synchronized (this.f4144a.f4145d) {
                try {
                    O o2 = (O) message.obj;
                    P p8 = (P) this.f4144a.f4145d.get(o2);
                    if (p8 != null && p8.f4137a.isEmpty()) {
                        if (p8.f4139c) {
                            p8.f4143g.f4147f.removeMessages(1, p8.f4141e);
                            S s8 = p8.f4143g;
                            s8.f4148g.a(s8.f4146e, p8);
                            p8.f4139c = false;
                            p8.f4138b = 2;
                        }
                        this.f4144a.f4145d.remove(o2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i9 != 1) {
            return false;
        }
        synchronized (this.f4144a.f4145d) {
            try {
                O o8 = (O) message.obj;
                P p9 = (P) this.f4144a.f4145d.get(o8);
                if (p9 != null && p9.f4138b == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(o8)), new Exception());
                    ComponentName componentName = p9.f4142f;
                    if (componentName == null) {
                        o8.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = o8.f4135b;
                        C0376g.e(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    p9.onServiceDisconnected(componentName);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}
