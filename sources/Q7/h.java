package Q7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p056h5.C0598e;
import y7.p;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends k {
    public static List B(e eVar) {
        Iterator it = eVar.iterator();
        if (!it.hasNext()) {
            return p.f22408a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return C0598e.y(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
