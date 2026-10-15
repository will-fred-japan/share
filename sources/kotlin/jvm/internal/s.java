package kotlin.jvm.internal;

/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s extends u implements P7.k {
    @Override // kotlin.jvm.internal.AbstractC0622b
    public final P7.b computeReflected() {
        z.f20009a.getClass();
        return this;
    }

    @Override // P7.k
    public final void getGetter() {
        ((P7.k) getReflected()).getGetter();
    }

    @Override // K7.l
    public final Object invoke(Object obj) {
        ((t) this).getGetter();
        throw null;
    }
}
