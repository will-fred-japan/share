package Q7;

import K7.p;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3882a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3883b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(p pVar) {
        this.f3883b = (D7.h) pVar;
    }

    @Override // Q7.e
    public final Iterator iterator() {
        switch (this.f3882a) {
            case 0:
                D7.h hVar = (D7.h) this.f3883b;
                f fVar = new f();
                fVar.f3881c = hVar.create(fVar, fVar);
                return fVar;
            default:
                return (Iterator) this.f3883b;
        }
    }

    public i(Iterator it) {
        this.f3883b = it;
    }
}
