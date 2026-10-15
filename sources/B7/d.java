package B7;

import K7.p;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements h, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f1757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h.a f1758b;

    public d(h left, h.a element) {
        k.e(left, "left");
        k.e(element, "element");
        this.f1757a = left;
        this.f1758b = element;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override // B7.h
    public final <R> R A(R r8, p<? super R, ? super h.a, ? extends R> pVar) {
        return pVar.invoke((Object) this.f1757a.A(r8, pVar), this.f1758b);
    }

    @Override // B7.h
    public final h d(h.b<?> key) {
        k.e(key, "key");
        h.a aVar = this.f1758b;
        h.a aVarI = aVar.i(key);
        h hVar = this.f1757a;
        if (aVarI != null) {
            return hVar;
        }
        h hVarD = hVar.d(key);
        if (hVarD == hVar) {
            return this;
        }
        return hVarD == i.f1761a ? aVar : new d(hVarD, aVar);
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            dVar.getClass();
            int i9 = 2;
            d dVar2 = dVar;
            int i10 = 2;
            while (true) {
                h hVar = dVar2.f1757a;
                dVar2 = hVar instanceof d ? (d) hVar : null;
                if (dVar2 == null) {
                    break;
                }
                i10++;
            }
            d dVar3 = this;
            while (true) {
                h hVar2 = dVar3.f1757a;
                dVar3 = hVar2 instanceof d ? (d) hVar2 : null;
                if (dVar3 == null) {
                    break;
                }
                i9++;
            }
            if (i10 == i9) {
                d dVar4 = this;
                while (true) {
                    h.a aVar = dVar4.f1758b;
                    if (!k.a(dVar.i(aVar.getKey()), aVar)) {
                        zA = false;
                        break;
                    }
                    h hVar3 = dVar4.f1757a;
                    if (!(hVar3 instanceof d)) {
                        k.c(hVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        h.a aVar2 = (h.a) hVar3;
                        zA = k.a(dVar.i(aVar2.getKey()), aVar2);
                        break;
                    }
                    dVar4 = (d) hVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f1758b.hashCode() + this.f1757a.hashCode();
    }

    @Override // B7.h
    public final <E extends h.a> E i(h.b<E> key) {
        k.e(key, "key");
        d dVar = this;
        while (true) {
            E e9 = (E) dVar.f1758b.i(key);
            if (e9 != null) {
                return e9;
            }
            h hVar = dVar.f1757a;
            if (!(hVar instanceof d)) {
                return (E) hVar.i(key);
            }
            dVar = (d) hVar;
        }
    }

    @Override // B7.h
    public final h r(h context) {
        k.e(context, "context");
        return context == i.f1761a ? this : (h) context.A(this, new g(0));
    }

    public final String toString() {
        return "[" + ((String) A("", new c(0))) + ']';
    }
}
