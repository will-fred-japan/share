package Q4;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: Q4.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0361q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3841a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3842b = Collections.synchronizedMap(new WeakHashMap());

    public final void a(boolean z8, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f3841a) {
            map = new HashMap(this.f3841a);
        }
        synchronized (this.f3842b) {
            map2 = new HashMap(this.f3842b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z8 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z8 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((p094m5.f) entry2.getKey()).b(new P4.b(status));
            }
        }
    }
}
