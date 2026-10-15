package p106o0;

import V7.s;
import W5.e;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: NavigationEventDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R3.c f20630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f20631b = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f20632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f20633d;

    public c(R3.c cVar) {
        this.f20630a = cVar;
        new LinkedHashSet();
        this.f20632c = new LinkedHashSet();
        this.f20633d = new LinkedHashSet();
    }

    public final void a(f fVar) {
        if (this.f20633d.add(fVar)) {
            this.f20631b.a(this, fVar, -1);
        }
    }

    public final void b(m mVar, int i9) {
        if (i9 != 1 && i9 != 0) {
            throw new IllegalArgumentException(e.i(i9, "Unsupported priority value: ").toString());
        }
        if (this.f20633d.add(mVar)) {
            this.f20631b.a(this, mVar, i9);
        }
    }

    public final void c(f input, b bVar) {
        k.e(input, "input");
        g gVar = this.f20631b;
        gVar.getClass();
        if (gVar.f20649g != 0) {
            return;
        }
        d<?> dVarC = gVar.c(-1);
        gVar.f20648f = dVarC;
        gVar.f20649g = -1;
        gVar.f20650h = input;
        if (bVar != null) {
            if (dVarC != null) {
                new h.b(bVar, -1);
                dVarC.d(bVar);
            }
            h.b bVar2 = new h.b(bVar, -1);
            s sVar = gVar.f20643a;
            sVar.getClass();
            sVar.d(null, bVar2);
        }
    }
}
