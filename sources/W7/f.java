package W7;

import java.util.ArrayList;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f<T> implements k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B7.h f5087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final U7.a f5089c;

    public f(B7.h hVar, int i9, U7.a aVar) {
        this.f5087a = hVar;
        this.f5088b = i9;
        this.f5089c = aVar;
    }

    public abstract Object a(U7.r<? super T> rVar, B7.e<? super p188x7.k> eVar);

    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    @Override // W7.k
    public final V7.d<T> b(B7.h hVar, int i9, U7.a aVar) {
        B7.h hVar2 = this.f5087a;
        B7.h hVarR = hVar.r(hVar2);
        U7.a aVar2 = U7.a.f4747a;
        U7.a aVar3 = this.f5089c;
        int i10 = this.f5088b;
        if (aVar == aVar2) {
            if (i10 != -3) {
                if (i9 == -3) {
                    i9 = i10;
                } else if (i10 != -2) {
                    if (i9 == -2) {
                        i9 = i10;
                    } else {
                        i9 += i10;
                        if (i9 < 0) {
                            i9 = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            aVar = aVar3;
        }
        return (kotlin.jvm.internal.k.a(hVarR, hVar2) && i9 == i10 && aVar == aVar3) ? this : d(hVarR, i9, aVar);
    }

    @Override // V7.d
    public Object c(V7.e<? super T> eVar, B7.e<? super p188x7.k> eVar2) throws Throwable {
        d dVar = new d(eVar, this, null);
        X7.r rVar = new X7.r(eVar2, eVar2.getContext());
        Object objA = p027d5.a.A(rVar, rVar, dVar);
        return objA == C7.a.f1806a ? objA : p188x7.k.f22364a;
    }

    public abstract f<T> d(B7.h hVar, int i9, U7.a aVar);

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        B7.i iVar = B7.i.f1761a;
        B7.h hVar = this.f5087a;
        if (hVar != iVar) {
            arrayList.add("context=" + hVar);
        }
        int i9 = this.f5088b;
        if (i9 != -3) {
            arrayList.add("capacity=" + i9);
        }
        U7.a aVar = U7.a.f4747a;
        U7.a aVar2 = this.f5089c;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        return getClass().getSimpleName() + '[' + y7.n.M(arrayList, ", ", null, null, null, 62) + ']';
    }
}
