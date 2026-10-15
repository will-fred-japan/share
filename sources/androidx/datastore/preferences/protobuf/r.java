package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.r.a;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: compiled from: FieldSet.java */
/* JADX INFO: loaded from: classes.dex */
public final class r<T extends a<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r<?> f7303d = new r<>(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f7304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7306c;

    /* JADX INFO: compiled from: FieldSet.java */
    public interface a<T extends a<T>> extends Comparable<T> {
        s0 F();
    }

    public r() {
        int i9 = i0.f7253f;
        this.f7304a = new h0();
    }

    public static int b(r0 r0Var, int i9, Object obj) {
        int iA;
        int iD;
        int iC = AbstractC0516j.C(i9);
        if (r0Var == r0.f7308d) {
            iC *= 2;
        }
        int iE = 4;
        switch (r0Var.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = AbstractC0516j.f7267c;
                iE = 8;
                return iE + iC;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = AbstractC0516j.f7267c;
                return iE + iC;
            case 2:
                iE = AbstractC0516j.E(((Long) obj).longValue());
                return iE + iC;
            case 3:
                iE = AbstractC0516j.E(((Long) obj).longValue());
                return iE + iC;
            case 4:
                iE = AbstractC0516j.E(((Integer) obj).intValue());
                return iE + iC;
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = AbstractC0516j.f7267c;
                iE = 8;
                return iE + iC;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = AbstractC0516j.f7267c;
                return iE + iC;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = AbstractC0516j.f7267c;
                iE = 1;
                return iE + iC;
            case 8:
                iE = obj instanceof AbstractC0513g ? AbstractC0516j.x((AbstractC0513g) obj) : AbstractC0516j.B((String) obj);
                return iE + iC;
            case 9:
                Logger logger6 = AbstractC0516j.f7267c;
                iE = ((Q) obj).a();
                return iE + iC;
            case 10:
                if (obj instanceof B) {
                    iE = AbstractC0516j.y((B) obj);
                } else {
                    Logger logger7 = AbstractC0516j.f7267c;
                    iA = ((Q) obj).a();
                    iD = AbstractC0516j.D(iA);
                    iE = iD + iA;
                }
                return iE + iC;
            case 11:
                if (obj instanceof AbstractC0513g) {
                    iE = AbstractC0516j.x((AbstractC0513g) obj);
                } else {
                    Logger logger8 = AbstractC0516j.f7267c;
                    iA = ((byte[]) obj).length;
                    iD = AbstractC0516j.D(iA);
                    iE = iD + iA;
                }
                return iE + iC;
            case 12:
                iE = AbstractC0516j.D(((Integer) obj).intValue());
                return iE + iC;
            case 13:
                iE = obj instanceof C0530y.a ? AbstractC0516j.E(((C0530y.a) obj).a()) : AbstractC0516j.E(((Integer) obj).intValue());
                return iE + iC;
            case 14:
                ((Integer) obj).getClass();
                Logger logger9 = AbstractC0516j.f7267c;
                return iE + iC;
            case 15:
                ((Long) obj).getClass();
                Logger logger10 = AbstractC0516j.f7267c;
                iE = 8;
                return iE + iC;
            case 16:
                iE = AbstractC0516j.z(((Integer) obj).intValue());
                return iE + iC;
            case 17:
                iE = AbstractC0516j.A(((Long) obj).longValue());
                return iE + iC;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(a<?> aVar, Object obj) {
        aVar.getClass();
        return b(null, 0, obj);
    }

    public static int d(Map.Entry entry) {
        a aVar = (a) entry.getKey();
        entry.getValue();
        aVar.F();
        throw null;
    }

    public static <T extends a<T>> boolean f(Map.Entry<T, Object> entry) {
        entry.getKey().F();
        throw null;
    }

    public static void k(AbstractC0516j abstractC0516j, r0 r0Var, int i9, Object obj) {
        if (r0Var == r0.f7308d) {
            abstractC0516j.X(i9, 3);
            ((Q) obj).d(abstractC0516j);
            abstractC0516j.X(i9, 4);
        }
        abstractC0516j.X(i9, r0Var.f7312b);
        switch (r0Var.ordinal()) {
            case 0:
                abstractC0516j.O(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                abstractC0516j.M(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                abstractC0516j.b0(((Long) obj).longValue());
                break;
            case 3:
                abstractC0516j.b0(((Long) obj).longValue());
                break;
            case 4:
                abstractC0516j.Q(((Integer) obj).intValue());
                break;
            case 5:
                abstractC0516j.O(((Long) obj).longValue());
                break;
            case 6:
                abstractC0516j.M(((Integer) obj).intValue());
                break;
            case 7:
                abstractC0516j.G(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof AbstractC0513g)) {
                    abstractC0516j.W((String) obj);
                } else {
                    abstractC0516j.K((AbstractC0513g) obj);
                }
                break;
            case 9:
                ((Q) obj).d(abstractC0516j);
                break;
            case 10:
                abstractC0516j.S((Q) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC0513g)) {
                    byte[] bArr = (byte[]) obj;
                    abstractC0516j.I(bArr.length, bArr);
                } else {
                    abstractC0516j.K((AbstractC0513g) obj);
                }
                break;
            case 12:
                abstractC0516j.Z(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof C0530y.a)) {
                    abstractC0516j.Q(((Integer) obj).intValue());
                } else {
                    abstractC0516j.Q(((C0530y.a) obj).a());
                }
                break;
            case 14:
                abstractC0516j.M(((Integer) obj).intValue());
                break;
            case 15:
                abstractC0516j.O(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                abstractC0516j.Z((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                abstractC0516j.b0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final r<T> clone() {
        r<T> rVar = new r<>();
        h0 h0Var = this.f7304a;
        if (h0Var.f7254a.size() > 0) {
            Map.Entry<a<Object>, Object> entryC = h0Var.c(0);
            rVar.j(entryC.getKey(), entryC.getValue());
            throw null;
        }
        Iterator it = h0Var.d().iterator();
        if (!it.hasNext()) {
            rVar.f7306c = this.f7306c;
            return rVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        rVar.j((a) entry.getKey(), entry.getValue());
        throw null;
    }

    public final boolean e() {
        h0 h0Var = this.f7304a;
        if (h0Var.f7254a.size() > 0) {
            f(h0Var.c(0));
            throw null;
        }
        Iterator it = h0Var.d().iterator();
        if (!it.hasNext()) {
            return true;
        }
        f((Map.Entry) it.next());
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return this.f7304a.equals(((r) obj).f7304a);
        }
        return false;
    }

    public final Iterator<Map.Entry<T, Object>> g() {
        h0 h0Var = this.f7304a;
        if (h0Var.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (!this.f7306c) {
            return ((i0.c) h0Var.entrySet()).iterator();
        }
        Iterator<Map.Entry<K, Object>> it = ((i0.c) h0Var.entrySet()).iterator();
        B.b bVar = new B.b();
        bVar.f7160a = it;
        return bVar;
    }

    public final void h() {
        if (this.f7305b) {
            return;
        }
        h0 h0Var = this.f7304a;
        int size = h0Var.f7254a.size();
        for (int i9 = 0; i9 < size; i9++) {
            Map.Entry<a<Object>, Object> entryC = h0Var.c(i9);
            if (entryC.getValue() instanceof AbstractC0528w) {
                AbstractC0528w abstractC0528w = (AbstractC0528w) entryC.getValue();
                abstractC0528w.getClass();
                c0 c0Var = c0.f7206c;
                c0Var.getClass();
                c0Var.a(abstractC0528w.getClass()).b(abstractC0528w);
                abstractC0528w.n();
            }
        }
        h0Var.f();
        this.f7305b = true;
    }

    public final int hashCode() {
        return this.f7304a.hashCode();
    }

    public final void i(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        boolean z8 = entry.getValue() instanceof B;
        key.getClass();
        key.F();
        throw null;
    }

    public final void j(T t, Object obj) {
        t.getClass();
        t.getClass();
        Charset charset = C0530y.f7343a;
        obj.getClass();
        throw null;
    }

    public r(int i9) {
        int i10 = i0.f7253f;
        this.f7304a = new h0();
        h();
        h();
    }
}
