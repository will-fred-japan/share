package kotlin.jvm.internal;

/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends o implements P7.g {
    public m() {
    }

    @Override // kotlin.jvm.internal.AbstractC0622b
    public P7.b computeReflected() {
        z.f20009a.getClass();
        return this;
    }

    @Override // P7.j
    public Object getDelegate() {
        return ((P7.g) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ P7.i.a getGetter() {
        mo846getGetter();
        return null;
    }

    public /* bridge */ /* synthetic */ P7.f getSetter() {
        mo847getSetter();
        return null;
    }

    @Override // K7.a
    public Object invoke() {
        return get();
    }

    public m(Object obj) {
        super(obj);
    }

    @Override // P7.j
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public P7.j.a mo846getGetter() {
        ((P7.g) getReflected()).mo846getGetter();
        return null;
    }

    @Override // P7.g
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public P7.g.a mo847getSetter() {
        ((P7.g) getReflected()).mo847getSetter();
        return null;
    }

    public m(Object obj, Class cls, String str, String str2, int i9) {
        super(obj, cls, str, str2, i9);
    }
}
