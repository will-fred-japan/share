package p163v;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ContainerHelpers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f21768a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object[] f21769b = new Object[0];

    public static final int a(int i9, int i10, int[] array) {
        k.e(array, "array");
        int i11 = i9 - 1;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            int i14 = array[i13];
            if (i14 < i10) {
                i12 = i13 + 1;
            } else {
                if (i14 <= i10) {
                    return i13;
                }
                i11 = i13 - 1;
            }
        }
        return ~i12;
    }

    public static final int b(long[] array, int i9, long j) {
        k.e(array, "array");
        int i10 = i9 - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            long j8 = array[i12];
            if (j8 < j) {
                i11 = i12 + 1;
            } else {
                if (j8 <= j) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return ~i11;
    }
}
