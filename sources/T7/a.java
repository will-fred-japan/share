package T7;

import X7.n;
import android.os.Looper;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements n {
    @Override // X7.n
    public final c a() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new c(e.a(mainLooper), false);
        }
        throw new IllegalStateException("The main looper is not available");
    }
}
