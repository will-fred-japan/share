package y7;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static <T> List<T> a(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        List<T> listAsList = Arrays.asList(tArr);
        kotlin.jvm.internal.k.d(listAsList, "asList(...)");
        return listAsList;
    }

    public static void b(int i9, int i10, int[] iArr, int[] destination, int i11) {
        kotlin.jvm.internal.k.e(iArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(iArr, i10, destination, i9, i11 - i10);
    }

    public static void c(byte[] bArr, int i9, byte[] destination, int i10, int i11) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(bArr, i10, destination, i9, i11 - i10);
    }

    public static void d(Object[] objArr, Object[] destination, int i9, int i10, int i11) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(objArr, i10, destination, i9, i11 - i10);
    }

    public static /* synthetic */ void e(Object[] objArr, Object[] objArr2, int i9, int i10, int i11) {
        if ((i11 & 4) != 0) {
            i9 = 0;
        }
        d(objArr, objArr2, 0, i9, i10);
    }

    public static byte[] f(int i9, int i10, byte[] bArr) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        h(i10, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i9, i10);
        kotlin.jvm.internal.k.d(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static <T> T[] g(T[] tArr, int i9, int i10) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        h(i10, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i9, i10);
        kotlin.jvm.internal.k.d(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static final void h(int i9, int i10) {
        if (i9 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i9 + ") is greater than size (" + i10 + ").");
    }

    public static void i(Object[] objArr, int i9, int i10) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        Arrays.fill(objArr, i9, i10, (Object) null);
    }

    public static byte[] j(byte[] bArr, byte[] elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, bArrCopyOf, length, length2);
        kotlin.jvm.internal.k.b(bArrCopyOf);
        return bArrCopyOf;
    }
}
