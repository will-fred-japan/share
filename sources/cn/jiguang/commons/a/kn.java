package cn.jiguang.commons.a;

import java.lang.ref.WeakReference;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
final class kn extends ThreadLocal<WeakReference<ko>> {
    private static WeakReference<ko> a() {
        try {
            return new WeakReference<>(new ko(Cipher.getInstance(d.j)));
        } catch (Throwable th) {
            ee.d("SECURE", "failed to init thread local cipher: " + th.getMessage());
            return new WeakReference<>(null);
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* synthetic */ WeakReference<ko> initialValue() {
        return a();
    }
}
