package y7;

import java.util.Collections;
import java.util.Map;
import p056h5.C0598e;

/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public class t extends C0598e {
    public static int A(int i9) {
        if (i9 < 0) {
            return i9;
        }
        if (i9 < 3) {
            return i9 + 1;
        }
        if (i9 < 1073741824) {
            return (int) ((i9 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> Map<K, V> B(p188x7.e<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.k.e(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.f22353a, pair.f22354b);
        kotlin.jvm.internal.k.d(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }
}
