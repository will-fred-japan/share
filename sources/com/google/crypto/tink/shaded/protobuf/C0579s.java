package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C0579s.a;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FieldSet.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0579s<T extends a<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0579s<?> f14157d = new C0579s<>(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f14158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14160c;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.s$a */
    /* JADX INFO: compiled from: FieldSet.java */
    public interface a<T extends a<T>> extends Comparable<T> {
        q0 F();
    }

    public C0579s() {
        int i9 = h0.f14075g;
        this.f14158a = new g0();
    }

    public static int b(a<?> aVar, Object obj) {
        int iA;
        int iD;
        aVar.getClass();
        Enum r8 = null;
        int iC = AbstractC0572k.C(0);
        if (p0.f14143a == null) {
            iC *= 2;
        }
        int iE = 4;
        switch (r8.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = AbstractC0572k.f14112c;
                iE = 8;
                return iE + iC;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = AbstractC0572k.f14112c;
                return iE + iC;
            case 2:
                iE = AbstractC0572k.E(((Long) obj).longValue());
                return iE + iC;
            case 3:
                iE = AbstractC0572k.E(((Long) obj).longValue());
                return iE + iC;
            case 4:
                iE = AbstractC0572k.E(((Integer) obj).intValue());
                return iE + iC;
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = AbstractC0572k.f14112c;
                iE = 8;
                return iE + iC;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = AbstractC0572k.f14112c;
                return iE + iC;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = AbstractC0572k.f14112c;
                iE = 1;
                return iE + iC;
            case 8:
                iE = obj instanceof AbstractC0569h ? AbstractC0572k.x((AbstractC0569h) obj) : AbstractC0572k.B((String) obj);
                return iE + iC;
            case 9:
                iE = ((Q) obj).a();
                return iE + iC;
            case 10:
                if (obj instanceof B) {
                    iE = AbstractC0572k.y((B) obj);
                } else {
                    Logger logger6 = AbstractC0572k.f14112c;
                    iA = ((Q) obj).a();
                    iD = AbstractC0572k.D(iA);
                    iE = iD + iA;
                }
                return iE + iC;
            case 11:
                if (obj instanceof AbstractC0569h) {
                    iE = AbstractC0572k.x((AbstractC0569h) obj);
                } else {
                    Logger logger7 = AbstractC0572k.f14112c;
                    iA = ((byte[]) obj).length;
                    iD = AbstractC0572k.D(iA);
                    iE = iD + iA;
                }
                return iE + iC;
            case 12:
                iE = AbstractC0572k.D(((Integer) obj).intValue());
                return iE + iC;
            case 13:
                iE = obj instanceof C0585y.a ? AbstractC0572k.E(((C0585y.a) obj).a()) : AbstractC0572k.E(((Integer) obj).intValue());
                return iE + iC;
            case 14:
                ((Integer) obj).getClass();
                Logger logger8 = AbstractC0572k.f14112c;
                return iE + iC;
            case 15:
                ((Long) obj).getClass();
                Logger logger9 = AbstractC0572k.f14112c;
                iE = 8;
                return iE + iC;
            case 16:
                iE = AbstractC0572k.z(((Integer) obj).intValue());
                return iE + iC;
            case 17:
                iE = AbstractC0572k.A(((Long) obj).longValue());
                return iE + iC;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(Map.Entry entry) {
        a aVar = (a) entry.getKey();
        entry.getValue();
        aVar.F();
        throw null;
    }

    public static <T extends a<T>> boolean e(Map.Entry<T, Object> entry) {
        entry.getKey().F();
        throw null;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C0579s<T> clone() {
        C0579s<T> c0579s = new C0579s<>();
        g0 g0Var = this.f14158a;
        if (g0Var.f14077b > 0) {
            h0.a aVarC = g0Var.c(0);
            c0579s.i((a) aVarC.f14082a, aVarC.f14083b);
            throw null;
        }
        Iterator it = g0Var.d().iterator();
        if (!it.hasNext()) {
            c0579s.f14160c = this.f14160c;
            return c0579s;
        }
        Map.Entry entry = (Map.Entry) it.next();
        c0579s.i((a) entry.getKey(), entry.getValue());
        throw null;
    }

    public final boolean d() {
        g0 g0Var = this.f14158a;
        if (g0Var.f14077b > 0) {
            e(g0Var.c(0));
            throw null;
        }
        Iterator it = g0Var.d().iterator();
        if (!it.hasNext()) {
            return true;
        }
        e((Map.Entry) it.next());
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0579s) {
            return this.f14158a.equals(((C0579s) obj).f14158a);
        }
        return false;
    }

    public final Iterator<Map.Entry<T, Object>> f() {
        g0 g0Var = this.f14158a;
        if (g0Var.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (!this.f14160c) {
            return ((h0.c) g0Var.entrySet()).iterator();
        }
        Iterator<Map.Entry<K, Object>> it = ((h0.c) g0Var.entrySet()).iterator();
        B.b bVar = new B.b();
        bVar.f13999a = it;
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        if (this.f14159b) {
            return;
        }
        g0 g0Var = this.f14158a;
        int i9 = g0Var.f14077b;
        for (int i10 = 0; i10 < i9; i10++) {
            V v5 = g0Var.c(i10).f14083b;
            if (v5 instanceof AbstractC0583w) {
                ((AbstractC0583w) v5).t();
            }
        }
        Iterator it = g0Var.d().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof AbstractC0583w) {
                ((AbstractC0583w) value).t();
            }
        }
        g0Var.f();
        this.f14159b = true;
    }

    public final void h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        boolean z8 = entry.getValue() instanceof B;
        key.getClass();
        key.F();
        throw null;
    }

    public final int hashCode() {
        return this.f14158a.hashCode();
    }

    public final void i(T t, Object obj) {
        t.getClass();
        t.getClass();
        Charset charset = C0585y.f14183a;
        obj.getClass();
        throw null;
    }

    public C0579s(int i9) {
        int i10 = h0.f14075g;
        this.f14158a = new g0();
        g();
        g();
    }
}
