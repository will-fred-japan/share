package y7;

import java.util.Collection;
import java.util.List;
import p056h5.C0598e;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes2.dex */
public class h extends C0598e {
    public static O7.h A(Collection<?> collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        return new O7.h(0, collection.size() - 1, 1);
    }

    public static <T> int B(List<? extends T> list) {
        return list.size() - 1;
    }

    public static <T> List<T> C(T... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return elements.length > 0 ? f.a(elements) : p.f22408a;
    }

    public static void D() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
