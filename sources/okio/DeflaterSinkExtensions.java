package okio;

import java.util.zip.Deflater;
import kotlin.jvm.internal.k;

/* JADX INFO: renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink sink, Deflater deflater) {
        k.e(sink, "<this>");
        k.e(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            deflater = new Deflater();
        }
        k.e(sink, "<this>");
        k.e(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
