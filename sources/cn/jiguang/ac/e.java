package cn.jiguang.ac;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<d> f8872a = new Comparator<d>() { // from class: cn.jiguang.ac.e.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            if (dVar.equals(dVar2)) {
                return 0;
            }
            int i9 = dVar.f8868b;
            int i10 = dVar2.f8868b;
            if (i9 > i10) {
                return -1;
            }
            if (i9 < i10) {
                return 1;
            }
            int i11 = dVar.f8871e;
            int i12 = dVar2.f8871e;
            if (i11 > i12) {
                return -1;
            }
            if (i11 < i12) {
                return 1;
            }
            long j = dVar.f8870d;
            if (j != 0) {
                long j8 = dVar2.f8870d;
                if (j8 != 0) {
                    if (j < j8) {
                        return -1;
                    }
                    if (j > j8) {
                        return 1;
                    }
                }
            }
            long j9 = dVar.f8869c;
            if (j9 != 0) {
                long j10 = dVar2.f8869c;
                if (j10 != 0) {
                    if (j9 > j10 + 180000) {
                        return -1;
                    }
                    if (j9 < j10 - 180000) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    };

    public static LinkedHashSet<g> a(Context context, LinkedHashSet<g> linkedHashSet, long j) {
        if ((linkedHashSet != null ? linkedHashSet.size() : 0) == 0) {
            return new LinkedHashSet<>();
        }
        LinkedList linkedList = new LinkedList();
        boolean z8 = true;
        for (g gVar : linkedHashSet) {
            if (gVar.a()) {
                cn.jiguang.e.d<String> dVarF = cn.jiguang.e.d.f(gVar.toString());
                cn.jiguang.e.d<String> dVarG = cn.jiguang.e.d.g(gVar.toString());
                String str = (String) cn.jiguang.e.f.a(context, dVarG);
                if (TextUtils.isEmpty(str)) {
                    str = (String) cn.jiguang.e.f.a(context, dVarF);
                }
                d dVarA = d.a(str);
                if (dVarA == null) {
                    dVarA = new d(gVar);
                }
                if (z8) {
                    dVarA.f8871e = 1;
                    z8 = false;
                }
                if (j > 0) {
                    dVarA.f8869c = j;
                    cn.jiguang.e.f.a(context, (cn.jiguang.e.d<?>[]) new cn.jiguang.e.d[]{dVarG.a(dVarA.a())});
                }
                linkedList.add(dVarA);
            }
        }
        return a(context, (LinkedList<LinkedList<d>>) a(linkedList, f8872a));
    }

    public static LinkedHashSet<g> a(Context context, LinkedList<LinkedList<d>> linkedList) {
        boolean zE = cn.jiguang.aw.b.e(context);
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<LinkedList<d>> it = linkedList.iterator();
        while (it.hasNext()) {
            Iterator<d> it2 = it.next().iterator();
            while (it2.hasNext()) {
                g gVar = it2.next().f8867a;
                if (gVar.f8876a.contains(Constants.COLON_SEPARATOR)) {
                    arrayList.add(gVar);
                } else {
                    arrayList2.add(gVar);
                }
            }
        }
        linkedHashSet.clear();
        if (zE) {
            linkedHashSet.addAll(arrayList);
            linkedHashSet.addAll(arrayList2);
            return linkedHashSet;
        }
        linkedHashSet.addAll(arrayList2);
        linkedHashSet.addAll(arrayList);
        return linkedHashSet;
    }

    private static <T> LinkedList<LinkedList<T>> a(Collection<T> collection, Comparator<T> comparator) {
        int size = collection != null ? collection.size() : 0;
        if (size == 0) {
            return new LinkedList<>();
        }
        LinkedList<LinkedList<T>> linkedList = new LinkedList<>();
        if (size == 1) {
            linkedList.add(new LinkedList<>(collection));
            return linkedList;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (T t : collection) {
            int i9 = 0;
            while (true) {
                if (i9 >= linkedList.size()) {
                    LinkedList<T> linkedList2 = new LinkedList<>();
                    linkedList2.add(t);
                    linkedList.add(linkedList2);
                    break;
                }
                LinkedList<T> linkedList3 = linkedList.get(i9);
                int iCompare = comparator.compare(t, linkedList3.get(0));
                if (iCompare == 0) {
                    linkedList3.add(secureRandom.nextInt(linkedList3.size() + 1), t);
                    break;
                }
                if (iCompare < 0) {
                    LinkedList<T> linkedList4 = new LinkedList<>();
                    linkedList4.add(t);
                    linkedList.add(i9, linkedList4);
                    break;
                }
                i9++;
            }
        }
        return linkedList;
    }

    public static void a(Context context, g gVar, int i9, long j) {
        if (gVar != null) {
            cn.jiguang.e.d<String> dVarF = cn.jiguang.e.d.f(gVar.toString());
            cn.jiguang.e.d<String> dVarG = cn.jiguang.e.d.g(gVar.toString());
            String str = (String) cn.jiguang.e.f.a(context, dVarG);
            if (TextUtils.isEmpty(str)) {
                str = (String) cn.jiguang.e.f.a(context, dVarF);
            }
            d dVarA = d.a(str);
            if (dVarA == null) {
                dVarA = new d(gVar);
            }
            dVarA.f8870d = j;
            dVarA.f8868b = i9;
            cn.jiguang.e.f.a(context, (cn.jiguang.e.d<?>[]) new cn.jiguang.e.d[]{dVarG.a(dVarA.a())});
        }
    }
}
