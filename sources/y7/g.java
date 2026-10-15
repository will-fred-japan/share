package y7;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import p056h5.C0598e;

/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes2.dex */
public class g extends f {
    public static ArrayList k(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> T l(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> O7.h m(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return new O7.h(0, tArr.length - 1, 1);
    }

    public static List<Byte> n(byte[] bArr) {
        int length = bArr.length;
        if (length == 0) {
            return p.f22408a;
        }
        if (length == 1) {
            return C0598e.y(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b9 : bArr) {
            arrayList.add(Byte.valueOf(b9));
        }
        return arrayList;
    }

    public static <T> List<T> o(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? new ArrayList(new d(tArr, false)) : C0598e.y(tArr[0]);
        }
        return p.f22408a;
    }
}
