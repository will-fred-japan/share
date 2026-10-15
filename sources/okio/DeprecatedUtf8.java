package okio;

import kotlin.jvm.internal.k;

/* JADX INFO: renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* JADX INFO: compiled from: -DeprecatedUtf8.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    public final long size(String string) {
        k.e(string, "string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    public final long size(String string, int i9, int i10) {
        k.e(string, "string");
        return Utf8.size(string, i9, i10);
    }
}
