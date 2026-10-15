package U5;

import A0.h;
import U5.H;

/* JADX INFO: renamed from: U5.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: KeySerializer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0445g<KeyT extends A0.h, SerializationT extends H> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<KeyT> f4707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<SerializationT> f4708b;

    /* JADX INFO: renamed from: U5.g$a */
    /* JADX INFO: compiled from: KeySerializer.java */
    public interface a<KeyT extends A0.h, SerializationT extends H> {
        E e(A0.h hVar);
    }

    public AbstractC0445g() {
        throw null;
    }

    public AbstractC0445g(Class cls) {
        this.f4707a = cls;
        this.f4708b = E.class;
    }

    public abstract H a(A0.h hVar);
}
