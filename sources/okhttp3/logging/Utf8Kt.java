package okhttp3.logging;

import java.io.EOFException;
import kotlin.jvm.internal.k;
import okio.Buffer;

/* JADX INFO: compiled from: utf8.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(Buffer isProbablyUtf8) {
        k.e(isProbablyUtf8, "$this$isProbablyUtf8");
        try {
            Buffer buffer = new Buffer();
            long size = isProbablyUtf8.size();
            long j = 64;
            if (size <= 64) {
                j = size;
            }
            isProbablyUtf8.copyTo(buffer, 0L, j);
            for (int i9 = 0; i9 < 16 && !buffer.exhausted(); i9++) {
                int utf8CodePoint = buffer.readUtf8CodePoint();
                if (Character.isISOControl(utf8CodePoint) && !Character.isWhitespace(utf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
