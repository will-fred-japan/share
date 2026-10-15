package U5;

import L5.n;
import U5.H;

/* JADX INFO: compiled from: ParametersSerializer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class x<ParametersT extends L5.n, SerializationT extends H> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<ParametersT> f4736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<SerializationT> f4737b;

    /* JADX INFO: compiled from: ParametersSerializer.java */
    public interface a<ParametersT extends L5.n, SerializationT extends H> {
        F f(L5.n nVar);
    }

    public x() {
        throw null;
    }

    public x(Class cls) {
        this.f4736a = cls;
        this.f4737b = F.class;
    }

    public abstract SerializationT a(ParametersT parameterst);
}
