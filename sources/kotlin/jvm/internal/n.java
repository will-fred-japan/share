package kotlin.jvm.internal;

/* JADX INFO: compiled from: MutablePropertyReference0Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends m {
    public n(P7.d dVar, String str, String str2) {
        super(AbstractC0622b.NO_RECEIVER, ((c) dVar).b(), str, str2, !(dVar instanceof P7.c) ? 1 : 0);
    }

    @Override // P7.j
    public Object get() {
        mo846getGetter();
        throw null;
    }

    public void set(Object obj) {
        mo847getSetter();
        throw null;
    }

    public n(Class cls, String str, String str2, int i9) {
        super(AbstractC0622b.NO_RECEIVER, cls, str, str2, i9);
    }

    public n(Object obj, Class cls, String str, String str2, int i9) {
        super(obj, cls, str, str2, i9);
    }
}
