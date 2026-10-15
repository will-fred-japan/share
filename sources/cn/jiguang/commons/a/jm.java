package cn.jiguang.commons.a;

import java.lang.ref.WeakReference;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class jm extends ThreadLocal<WeakReference<MessageDigest>> {
    private static WeakReference<MessageDigest> a() {
        try {
            return new WeakReference<>(MessageDigest.getInstance(d.f9865g));
        } catch (Throwable th) {
            ee.d("DigestUtils", "failed to init sha1 digest: " + th.getMessage());
            return new WeakReference<>(null);
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* synthetic */ WeakReference<MessageDigest> initialValue() {
        return a();
    }
}
