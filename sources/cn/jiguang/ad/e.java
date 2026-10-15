package cn.jiguang.ad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static i[] f8963d = new i[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static h[] f8964e = new h[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f8965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List[] f8966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8967c;

    public e() {
        this(new d());
    }

    private int a(c cVar, int i9, a aVar, int i10) {
        int size = this.f8966b[i9].size();
        int iA = cVar.a();
        int i11 = 0;
        i iVar = null;
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i iVar2 = (i) this.f8966b[i9].get(i13);
            if (i9 == 3) {
                i12++;
            } else {
                if (iVar != null && !a(iVar2, iVar)) {
                    iA = cVar.a();
                    i11 = i13;
                }
                iVar2.a(cVar, i9, aVar);
                if (cVar.a() > i10) {
                    cVar.a(iA);
                    return (size - i11) + i12;
                }
                iVar = iVar2;
            }
        }
        return i12;
    }

    public h[] b(int i9) {
        if (this.f8966b[i9] == null) {
            return f8964e;
        }
        LinkedList linkedList = new LinkedList();
        i[] iVarArrA = a(i9);
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < iVarArrA.length; i10++) {
            g gVarD = iVarArrA[i10].d();
            if (!hashSet.contains(gVarD)) {
                linkedList.add(new h(iVarArrA[i10]));
                hashSet.add(gVarD);
                break;
                break;
            }
            int size = linkedList.size() - 1;
            while (true) {
                if (size < 0) {
                    linkedList.add(new h(iVarArrA[i10]));
                    hashSet.add(gVarD);
                    break;
                }
                h hVar = (h) linkedList.get(size);
                if (hVar.c() == iVarArrA[i10].f() && hVar.d() == iVarArrA[i10].g() && hVar.b().equals(gVarD)) {
                    hVar.a(iVarArrA[i10]);
                    break;
                }
                size--;
            }
        }
        return (h[]) linkedList.toArray(new h[linkedList.size()]);
    }

    public byte[] c(int i9) {
        c cVar = new c();
        a(cVar, i9);
        this.f8967c = cVar.a();
        return cVar.b();
    }

    public Object clone() {
        e eVar = new e();
        int i9 = 0;
        while (true) {
            List[] listArr = this.f8966b;
            if (i9 >= listArr.length) {
                eVar.f8965a = (d) this.f8965a.clone();
                eVar.f8967c = this.f8967c;
                return eVar;
            }
            if (listArr[i9] != null) {
                eVar.f8966b[i9] = new LinkedList(this.f8966b[i9]);
            }
            i9++;
        }
    }

    public e(b bVar) throws IOException {
        this(new d(bVar));
        for (int i9 = 0; i9 < 4; i9++) {
            int iC = this.f8965a.c(i9);
            if (iC > 0) {
                this.f8966b[i9] = new ArrayList(iC);
            }
            for (int i10 = 0; i10 < iC; i10++) {
                this.f8966b[i9].add(i.a(bVar, i9));
            }
        }
        this.f8967c = bVar.a();
    }

    public static e a(i iVar) {
        e eVar = new e();
        eVar.a(iVar, 0);
        return eVar;
    }

    private e(d dVar) {
        this.f8966b = new List[4];
        this.f8965a = dVar;
    }

    public i a() {
        List list = this.f8966b[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (i) list.get(0);
    }

    public e(byte[] bArr) {
        this(new b(bArr));
    }

    public void a(i iVar, int i9) {
        List[] listArr = this.f8966b;
        if (listArr[i9] == null) {
            listArr[i9] = new LinkedList();
        }
        this.f8965a.b(i9);
        this.f8966b[i9].add(iVar);
    }

    private boolean a(c cVar, int i9) {
        if (i9 < 12) {
            return false;
        }
        cVar.a();
        this.f8965a.a(cVar);
        a aVar = new a();
        this.f8965a.c();
        for (int i10 = 0; i10 < 4; i10++) {
            if (this.f8966b[i10] != null) {
                a(cVar, i10, aVar, i9);
            }
        }
        return true;
    }

    private static boolean a(i iVar, i iVar2) {
        return iVar.f() == iVar2.f() && iVar.g() == iVar2.g() && iVar.d().equals(iVar2.d());
    }

    public i[] a(int i9) {
        List list = this.f8966b[i9];
        return list == null ? f8963d : (i[]) list.toArray(new i[list.size()]);
    }
}
