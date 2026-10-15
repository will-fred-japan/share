package y7;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import p056h5.C0598e;

/* JADX INFO: compiled from: _Collections.kt */
/* JADX INFO: loaded from: classes2.dex */
public class n extends l {
    public static List H(ArrayList arrayList) {
        return S(new LinkedHashSet(arrayList));
    }

    public static <T> T I(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T J(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final void K(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, K7.l lVar) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        sb.append(charSequence2);
        int i9 = 0;
        for (Object obj : iterable) {
            i9++;
            if (i9 > 1) {
                sb.append(charSequence);
            }
            p142s2.j.k(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String M(Iterable iterable, String str, String str2, String str3, K7.l lVar, int i9) {
        if ((i9 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i9 & 2) != 0 ? "" : str2;
        String str6 = (i9 & 4) != 0 ? "" : str3;
        if ((i9 & 32) != 0) {
            lVar = null;
        }
        kotlin.jvm.internal.k.e(iterable, "<this>");
        StringBuilder sb = new StringBuilder();
        K(iterable, sb, str4, str5, str6, "...", lVar);
        return sb.toString();
    }

    public static <T> T N(List<? extends T> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(list.size() - 1);
    }

    public static ArrayList O(Collection collection, Iterable elements) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            l.F(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList P(Collection collection, Object obj) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> Q(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        ArrayList arrayListT;
        kotlin.jvm.internal.k.e(iterable, "<this>");
        boolean z8 = iterable instanceof Collection;
        if (z8) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return S(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            kotlin.jvm.internal.k.e(array, "<this>");
            if (array.length > 1) {
                Arrays.sort(array, comparator);
            }
            return f.a(array);
        }
        if (z8) {
            arrayListT = T((Collection) iterable);
        } else {
            ArrayList arrayList = new ArrayList();
            R(iterable, arrayList);
            arrayListT = arrayList;
        }
        if (arrayListT.size() > 1) {
            Collections.sort(arrayListT, comparator);
        }
        return arrayListT;
    }

    public static final void R(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static <T> List<T> S(Iterable<? extends T> iterable) {
        ArrayList arrayListT;
        kotlin.jvm.internal.k.e(iterable, "<this>");
        boolean z8 = iterable instanceof Collection;
        p pVar = p.f22408a;
        if (z8) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return pVar;
            }
            if (size != 1) {
                return T(collection);
            }
            return C0598e.y(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
        }
        if (z8) {
            arrayListT = T((Collection) iterable);
        } else {
            ArrayList arrayList = new ArrayList();
            R(iterable, arrayList);
            arrayListT = arrayList;
        }
        int size2 = arrayListT.size();
        if (size2 != 0) {
            return size2 != 1 ? arrayListT : C0598e.y(arrayListT.get(0));
        }
        return pVar;
    }

    public static ArrayList T(Collection collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> U(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        boolean z8 = iterable instanceof Collection;
        r rVar = r.f22410a;
        if (z8) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(t.A(collection.size()));
                    R(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set<T> setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                kotlin.jvm.internal.k.d(setSingleton, "singleton(...)");
                return setSingleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            R(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set<T> setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                kotlin.jvm.internal.k.d(setSingleton2, "singleton(...)");
                return setSingleton2;
            }
        }
        return rVar;
    }
}
