package okio;

import R7.a;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: -JvmPlatform.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class _JvmPlatformKt {
    public static final byte[] asUtf8ToByteArray(String str) {
        k.e(str, "<this>");
        byte[] bytes = str.getBytes(a.f4067b);
        k.d(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    public static final String toUtf8String(byte[] bArr) {
        k.e(bArr, "<this>");
        return new String(bArr, a.f4067b);
    }

    public static final <T> T withLock(ReentrantLock reentrantLock, K7.a<? extends T> action) {
        k.e(reentrantLock, "<this>");
        k.e(action, "action");
        reentrantLock.lock();
        try {
            return action.invoke();
        } finally {
            reentrantLock.unlock();
        }
    }
}
