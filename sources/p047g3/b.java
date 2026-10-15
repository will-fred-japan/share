package p047g3;

import java.util.HashMap;
import java.util.LinkedList;
import p063i3.c;

/* JADX INFO: compiled from: DataStoreManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList f18866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f18867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f18868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p063i3.b f18869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p070j3.b f18870e;

    /* JADX INFO: compiled from: DataStoreManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18871a;

        static {
            b bVar = new b();
            LinkedList linkedList = new LinkedList();
            bVar.f18866a = linkedList;
            HashMap map = new HashMap();
            bVar.f18867b = map;
            bVar.f18870e = new p070j3.b();
            c cVar = new c();
            bVar.f18868c = cVar;
            linkedList.add(cVar);
            map.put(R1.c.class, cVar);
            p063i3.b bVar2 = new p063i3.b();
            bVar.f18869d = bVar2;
            linkedList.add(bVar2);
            map.put(R1.a.class, bVar2);
            f18871a = bVar;
        }
    }
}
