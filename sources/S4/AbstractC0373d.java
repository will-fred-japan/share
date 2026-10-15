package S4;

import android.content.ServiceConnection;
import android.os.HandlerThread;

/* JADX INFO: renamed from: S4.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0373d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4186a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static S f4187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HandlerThread f4188c;

    public final void a(String str, ServiceConnection serviceConnection, boolean z8) {
        O o2 = new O(str, z8);
        S s8 = (S) this;
        C0376g.f(serviceConnection, "ServiceConnection must not be null");
        synchronized (s8.f4145d) {
            try {
                P p8 = (P) s8.f4145d.get(o2);
                if (p8 == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(o2.toString()));
                }
                if (!p8.f4137a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(o2.toString()));
                }
                p8.f4137a.remove(serviceConnection);
                if (p8.f4137a.isEmpty()) {
                    s8.f4147f.sendMessageDelayed(s8.f4147f.obtainMessage(0, o2), s8.f4149h);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
