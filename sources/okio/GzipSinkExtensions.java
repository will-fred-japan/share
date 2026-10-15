package okio;

import kotlin.jvm.internal.k;

/* JADX INFO: renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* JADX INFO: compiled from: GzipSink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        k.e(sink, "<this>");
        return new GzipSink(sink);
    }
}
