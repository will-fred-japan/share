package Z;

import S7.C0403o;
import android.content.Context;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5348b;

    public Y(Context context, p193y3.a aVar) {
        this.f5347a = context;
        this.f5348b = aVar;
    }

    public abstract Object a(D7.c cVar);

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object b(D7.c cVar) throws Throwable {
        X x8;
        b8.a aVar;
        Y y8;
        b8.a aVar2;
        Throwable th;
        Y y9;
        if (cVar instanceof X) {
            x8 = (X) cVar;
            int i9 = x8.f5346e;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                x8.f5346e = i9 - Integer.MIN_VALUE;
            } else {
                x8 = new X(this, cVar);
            }
        } else {
            x8 = new X(this, cVar);
        }
        Object obj = x8.f5344c;
        C7.a aVar3 = C7.a.f1806a;
        int i10 = x8.f5346e;
        try {
            if (i10 == 0) {
                p188x7.g.b(obj);
                C0403o c0403o = (C0403o) this.f5348b;
                c0403o.getClass();
                if (!(S7.c0.f4259a.get(c0403o) instanceof S7.U)) {
                    return p188x7.k.f22364a;
                }
                x8.f5342a = this;
                aVar = (b8.d) this.f5347a;
                x8.f5343b = aVar;
                x8.f5346e = 1;
                if (aVar.b(x8) != aVar3) {
                    y8 = this;
                }
                return aVar3;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar2 = x8.f5343b;
                y9 = x8.f5342a;
                try {
                    p188x7.g.b(obj);
                    C0403o c0403o2 = (C0403o) y9.f5348b;
                    p188x7.k kVar = p188x7.k.f22364a;
                    c0403o2.U(kVar);
                    aVar2.a(null);
                    return kVar;
                } catch (Throwable th2) {
                    th = th2;
                    aVar2.a(null);
                    throw th;
                }
            }
            b8.a aVar4 = x8.f5343b;
            y8 = x8.f5342a;
            p188x7.g.b(obj);
            aVar = aVar4;
            C0403o c0403o3 = (C0403o) y8.f5348b;
            c0403o3.getClass();
            if (!(S7.c0.f4259a.get(c0403o3) instanceof S7.U)) {
                p188x7.k kVar2 = p188x7.k.f22364a;
                aVar.a(null);
                return kVar2;
            }
            x8.f5342a = y8;
            x8.f5343b = aVar;
            x8.f5346e = 2;
            if (y8.a(x8) != aVar3) {
                aVar2 = aVar;
                y9 = y8;
                C0403o c0403o4 = (C0403o) y9.f5348b;
                p188x7.k kVar3 = p188x7.k.f22364a;
                c0403o4.U(kVar3);
                aVar2.a(null);
                return kVar3;
            }
            return aVar3;
        } catch (Throwable th3) {
            aVar2 = aVar;
            th = th3;
            aVar2.a(null);
            throw th;
        }
    }

    public Y() {
        this.f5347a = new b8.d();
        C0403o c0403o = new C0403o(true);
        c0403o.R(null);
        this.f5348b = c0403o;
    }
}
