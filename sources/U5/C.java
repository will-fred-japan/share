package U5;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: PrimitiveRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4671b;

    /* JADX INFO: compiled from: PrimitiveRegistry.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f4674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f4675b;

        public b() {
            throw null;
        }

        public b(Class cls, Class cls2) {
            this.f4674a = cls;
            this.f4675b = cls2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f4674a.equals(this.f4674a) && bVar.f4675b.equals(this.f4675b);
        }

        public final int hashCode() {
            return Objects.hash(this.f4674a, this.f4675b);
        }

        public final String toString() {
            return this.f4674a.getSimpleName() + " with primitive type: " + this.f4675b.getSimpleName();
        }
    }

    public C(a aVar) {
        this.f4670a = new HashMap(aVar.f4672a);
        this.f4671b = new HashMap(aVar.f4673b);
    }

    public final <KeyT extends A0.h, PrimitiveT> PrimitiveT a(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        b bVar = new b(keyt.getClass(), cls);
        HashMap map = this.f4670a;
        if (map.containsKey(bVar)) {
            return (PrimitiveT) ((A) map.get(bVar)).a(keyt);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + bVar + " available, see https://developers.google.com/tink/faq/registration_errors");
    }

    /* JADX INFO: compiled from: PrimitiveRegistry.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap f4672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f4673b;

        public a() {
            this.f4672a = new HashMap();
            this.f4673b = new HashMap();
        }

        public final void a(A a3) throws GeneralSecurityException {
            if (a3 == null) {
                throw new NullPointerException("primitive constructor must be non-null");
            }
            b bVar = new b(a3.f4666a, a3.f4667b);
            HashMap map = this.f4672a;
            if (!map.containsKey(bVar)) {
                map.put(bVar, a3);
                return;
            }
            A a9 = (A) map.get(bVar);
            if (a9.equals(a3) && a3.equals(a9)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + bVar);
        }

        public a(C c5) {
            this.f4672a = new HashMap(c5.f4670a);
            this.f4673b = new HashMap(c5.f4671b);
        }
    }
}
