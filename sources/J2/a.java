package J2;

import A.f;

/* JADX INFO: compiled from: BaseCpuExceptionState.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f2663a;

    public a(c cVar) {
        this.f2663a = cVar;
    }

    public void a() {
        if (A1.b.f1393A) {
            p010b3.b.d("APM-CPU", "stop detect when state is : ".concat(f.o(e())));
        }
    }

    public void b(I2.c cVar, boolean z8) {
        if (A1.b.f1393A) {
            p010b3.b.d("APM-CPU", "enter : ".concat(f.o(e())));
        }
    }

    public final void c(String str) {
        if (A1.b.f1393A) {
            p010b3.b.d("APM-CPU", "[" + f.o(e()) + "]: " + str);
        }
    }

    public void d(boolean z8) {
        if (A1.b.f1393A) {
            p010b3.b.d("APM-CPU", "onLifeCycleChange when state is : ".concat(f.o(e())));
        }
    }

    public abstract int e();
}
