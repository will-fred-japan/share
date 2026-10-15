package U5;

import A0.h;

/* JADX INFO: compiled from: PrimitiveConstructor.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class A<KeyT extends A0.h, PrimitiveT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<KeyT> f4666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<PrimitiveT> f4667b;

    /* JADX INFO: compiled from: PrimitiveConstructor.java */
    public interface a<KeyT extends A0.h, PrimitiveT> {
        PrimitiveT c(KeyT keyt);
    }

    public A() {
        throw null;
    }

    public A(Class cls, Class cls2) {
        this.f4666a = cls;
        this.f4667b = cls2;
    }

    public abstract PrimitiveT a(KeyT keyt);
}
