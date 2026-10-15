package okhttp3.internal.http1;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Headers;
import okio.BufferedSource;

/* JADX INFO: compiled from: HeadersReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HeadersReader {
    public static final Companion Companion = new Companion(null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final BufferedSource source;

    /* JADX INFO: compiled from: HeadersReader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public HeadersReader(BufferedSource source) {
        k.e(source, "source");
        this.source = source;
        this.headerLimit = 262144;
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String line = readLine();
            if (line.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(line);
        }
    }

    public final String readLine() {
        String utf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) utf8LineStrict.length();
        return utf8LineStrict;
    }
}
