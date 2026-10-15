package Z;

import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class P<T> extends I<T> implements m0<T> {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // Z.m0
    public final Object c(Object obj, D7.c cVar) throws IOException {
        O o2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (cVar instanceof O) {
            o2 = (O) cVar;
            int i9 = o2.f5335e;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                o2.f5335e = i9 - Integer.MIN_VALUE;
            } else {
                o2 = new O(this, cVar);
            }
        } else {
            o2 = new O(this, cVar);
        }
        Object obj2 = o2.f5333c;
        C7.a aVar = C7.a.f1806a;
        int i10 = o2.f5335e;
        if (i10 == 0) {
            p188x7.g.b(obj2);
            if (this.f5305c.get()) {
                throw new IllegalStateException("This scope has already been closed.");
            }
            FileOutputStream fileOutputStream3 = new FileOutputStream(this.f5303a);
            try {
                p015c0.d dVar = this.f5304b;
                j0 j0Var = new j0(fileOutputStream3);
                o2.f5331a = fileOutputStream3;
                o2.f5332b = fileOutputStream3;
                o2.f5335e = 1;
                if (dVar.b(obj, j0Var) == aVar) {
                    return aVar;
                }
                fileOutputStream2 = fileOutputStream3;
                fileOutputStream = fileOutputStream2;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream3;
                throw th;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileOutputStream2 = o2.f5332b;
            fileOutputStream = o2.f5331a;
            try {
                p188x7.g.b(obj2);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    p199z2.b.r(fileOutputStream, th);
                    throw th3;
                }
            }
        }
        fileOutputStream2.getFD().sync();
        p188x7.k kVar = p188x7.k.f22364a;
        p199z2.b.r(fileOutputStream, null);
        return p188x7.k.f22364a;
    }
}
