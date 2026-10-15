package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: LogWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class z extends Writer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f7686b = new StringBuilder(128);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7685a = "FragmentManager";

    public final void a() {
        StringBuilder sb = this.f7686b;
        if (sb.length() > 0) {
            Log.d(this.f7685a, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i9, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            char c5 = cArr[i9 + i11];
            if (c5 == '\n') {
                a();
            } else {
                this.f7686b.append(c5);
            }
        }
    }
}
