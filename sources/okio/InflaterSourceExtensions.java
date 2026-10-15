package okio;

import java.util.zip.Inflater;
import kotlin.jvm.internal.k;

/* JADX INFO: renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InflaterSourceExtensions {
    public static final InflaterSource inflate(Source source, Inflater inflater) {
        k.e(source, "<this>");
        k.e(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            inflater = new Inflater();
        }
        k.e(source, "<this>");
        k.e(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
