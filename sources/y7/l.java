package y7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: _CollectionsJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
public class l extends k {
    public static void F(Collection collection, Iterable elements) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void G(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
    }
}
