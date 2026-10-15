package S4;

import android.content.Context;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class S extends AbstractC0373d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f4145d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f4146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile p048g5.d f4147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p003a5.a f4148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4150i;

    public S(Context context, Looper looper) {
        Q q8 = new Q(this);
        this.f4146e = context.getApplicationContext();
        p048g5.d dVar = new p048g5.d(looper, q8);
        Looper.getMainLooper();
        this.f4147f = dVar;
        if (p003a5.a.f5682b == null) {
            synchronized (p003a5.a.f5681a) {
                try {
                    if (p003a5.a.f5682b == null) {
                        p003a5.a aVar = new p003a5.a();
                        new ConcurrentHashMap();
                        p003a5.a.f5682b = aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        p003a5.a aVar2 = p003a5.a.f5682b;
        C0376g.e(aVar2);
        this.f4148g = aVar2;
        this.f4149h = com.heytap.mcssdk.constant.a.f14256r;
        this.f4150i = 300000L;
    }

    public final boolean b(O o2, H h9, String str, Executor executor) {
        boolean z8;
        synchronized (this.f4145d) {
            try {
                P p8 = (P) this.f4145d.get(o2);
                if (executor == null) {
                    executor = null;
                }
                if (p8 == null) {
                    p8 = new P(this, o2);
                    p8.f4137a.put(h9, h9);
                    p8.a(str, executor);
                    this.f4145d.put(o2, p8);
                } else {
                    this.f4147f.removeMessages(0, o2);
                    if (p8.f4137a.containsKey(h9)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(o2.toString()));
                    }
                    p8.f4137a.put(h9, h9);
                    int i9 = p8.f4138b;
                    if (i9 == 1) {
                        h9.onServiceConnected(p8.f4142f, p8.f4140d);
                    } else if (i9 == 2) {
                        p8.a(str, executor);
                    }
                }
                z8 = p8.f4139c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z8;
    }
}
