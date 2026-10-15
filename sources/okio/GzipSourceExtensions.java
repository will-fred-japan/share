package okio;

import kotlin.jvm.internal.k;

/* JADX INFO: renamed from: okio.-GzipSourceExtensions, reason: invalid class name */
/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    private static final boolean getBit(int i9, int i10) {
        return ((i9 >> i10) & 1) == 1;
    }

    public static final GzipSource gzip(Source source) {
        k.e(source, "<this>");
        return new GzipSource(source);
    }
}
