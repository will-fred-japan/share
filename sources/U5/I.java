package U5;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: SerializationRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f4687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f4688d;

    /* JADX INFO: compiled from: SerializationRegistry.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends H> f4693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p012b6.a f4694b;

        public b() {
            throw null;
        }

        public b(Class cls, p012b6.a aVar) {
            this.f4693a = cls;
            this.f4694b = aVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f4693a.equals(this.f4693a) && bVar.f4694b.equals(this.f4694b);
        }

        public final int hashCode() {
            return Objects.hash(this.f4693a, this.f4694b);
        }

        public final String toString() {
            return this.f4693a.getSimpleName() + ", object identifier: " + this.f4694b;
        }
    }

    /* JADX INFO: compiled from: SerializationRegistry.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f4695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<? extends H> f4696b;

        public c() {
            throw null;
        }

        public c(Class cls, Class cls2) {
            this.f4695a = cls;
            this.f4696b = cls2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f4695a.equals(this.f4695a) && cVar.f4696b.equals(this.f4696b);
        }

        public final int hashCode() {
            return Objects.hash(this.f4695a, this.f4696b);
        }

        public final String toString() {
            return this.f4695a.getSimpleName() + " with serialization type: " + this.f4696b.getSimpleName();
        }
    }

    public I(a aVar) {
        this.f4685a = new HashMap(aVar.f4689a);
        this.f4686b = new HashMap(aVar.f4690b);
        this.f4687c = new HashMap(aVar.f4691c);
        this.f4688d = new HashMap(aVar.f4692d);
    }

    /* JADX INFO: compiled from: SerializationRegistry.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap f4689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f4690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap f4691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final HashMap f4692d;

        public a() {
            this.f4689a = new HashMap();
            this.f4690b = new HashMap();
            this.f4691c = new HashMap();
            this.f4692d = new HashMap();
        }

        public final void a(AbstractC0443e abstractC0443e) throws GeneralSecurityException {
            b bVar = new b(abstractC0443e.f4705b, abstractC0443e.f4704a);
            HashMap map = this.f4690b;
            if (!map.containsKey(bVar)) {
                map.put(bVar, abstractC0443e);
                return;
            }
            AbstractC0443e abstractC0443e2 = (AbstractC0443e) map.get(bVar);
            if (abstractC0443e2.equals(abstractC0443e) && abstractC0443e.equals(abstractC0443e2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + bVar);
        }

        public final void b(AbstractC0445g abstractC0445g) throws GeneralSecurityException {
            c cVar = new c(abstractC0445g.f4707a, abstractC0445g.f4708b);
            HashMap map = this.f4689a;
            if (!map.containsKey(cVar)) {
                map.put(cVar, abstractC0445g);
                return;
            }
            AbstractC0445g abstractC0445g2 = (AbstractC0445g) map.get(cVar);
            if (abstractC0445g2.equals(abstractC0445g) && abstractC0445g.equals(abstractC0445g2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + cVar);
        }

        public final void c(v vVar) throws GeneralSecurityException {
            b bVar = new b(vVar.f4734b, vVar.f4733a);
            HashMap map = this.f4692d;
            if (!map.containsKey(bVar)) {
                map.put(bVar, vVar);
                return;
            }
            v vVar2 = (v) map.get(bVar);
            if (vVar2.equals(vVar) && vVar.equals(vVar2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + bVar);
        }

        public final void d(x xVar) throws GeneralSecurityException {
            c cVar = new c(xVar.f4736a, xVar.f4737b);
            HashMap map = this.f4691c;
            if (!map.containsKey(cVar)) {
                map.put(cVar, xVar);
                return;
            }
            x xVar2 = (x) map.get(cVar);
            if (xVar2.equals(xVar) && xVar.equals(xVar2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + cVar);
        }

        public a(I i9) {
            this.f4689a = new HashMap(i9.f4685a);
            this.f4690b = new HashMap(i9.f4686b);
            this.f4691c = new HashMap(i9.f4687c);
            this.f4692d = new HashMap(i9.f4688d);
        }
    }
}
