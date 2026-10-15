package p155u;

import W5.e;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.k;
import p163v.a;
import y7.f;

/* JADX INFO: compiled from: SimpleArrayMap.kt */
/* JADX INFO: loaded from: classes.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f21658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f21659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21660c;

    public g() {
        this(0);
    }

    public final int a(V v5) {
        int i9 = this.f21660c * 2;
        Object[] objArr = this.f21659b;
        if (v5 == null) {
            for (int i10 = 1; i10 < i9; i10 += 2) {
                if (objArr[i10] == null) {
                    return i10 >> 1;
                }
            }
            return -1;
        }
        for (int i11 = 1; i11 < i9; i11 += 2) {
            if (v5.equals(objArr[i11])) {
                return i11 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i9) {
        int i10 = this.f21660c;
        int[] iArr = this.f21658a;
        if (iArr.length < i9) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i9);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f21658a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f21659b, i9 * 2);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f21659b = objArrCopyOf;
        }
        if (this.f21660c != i10) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i9, Object obj) {
        int i10 = this.f21660c;
        if (i10 == 0) {
            return -1;
        }
        int iA = a.a(i10, i9, this.f21658a);
        if (iA < 0 || k.a(obj, this.f21659b[iA << 1])) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f21658a[i11] == i9) {
            if (k.a(obj, this.f21659b[i11 << 1])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f21658a[i12] == i9; i12--) {
            if (k.a(obj, this.f21659b[i12 << 1])) {
                return i12;
            }
        }
        return ~i11;
    }

    public final void clear() {
        if (this.f21660c > 0) {
            this.f21658a = a.f21768a;
            this.f21659b = a.f21769b;
            this.f21660c = 0;
        }
        if (this.f21660c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k7) {
        return d(k7) >= 0;
    }

    public boolean containsValue(V v5) {
        return a(v5) >= 0;
    }

    public final int d(K k7) {
        return k7 == null ? e() : c(k7.hashCode(), k7);
    }

    public final int e() {
        int i9 = this.f21660c;
        if (i9 == 0) {
            return -1;
        }
        int iA = a.a(i9, 0, this.f21658a);
        if (iA < 0 || this.f21659b[iA << 1] == null) {
            return iA;
        }
        int i10 = iA + 1;
        while (i10 < i9 && this.f21658a[i10] == 0) {
            if (this.f21659b[i10 << 1] == null) {
                return i10;
            }
            i10++;
        }
        for (int i11 = iA - 1; i11 >= 0 && this.f21658a[i11] == 0; i11--) {
            if (this.f21659b[i11 << 1] == null) {
                return i11;
            }
        }
        return ~i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof g) {
                int i9 = this.f21660c;
                if (i9 != ((g) obj).f21660c) {
                    return false;
                }
                g gVar = (g) obj;
                for (int i10 = 0; i10 < i9; i10++) {
                    K kF = f(i10);
                    V vI = i(i10);
                    Object obj2 = gVar.get(kF);
                    if (vI == null) {
                        if (obj2 != null || !gVar.containsKey(kF)) {
                            return false;
                        }
                    } else if (!vI.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f21660c != ((Map) obj).size()) {
                return false;
            }
            int i11 = this.f21660c;
            for (int i12 = 0; i12 < i11; i12++) {
                K kF2 = f(i12);
                V vI2 = i(i12);
                Object obj3 = ((Map) obj).get(kF2);
                if (vI2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(kF2)) {
                        return false;
                    }
                } else if (!vI2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final K f(int i9) {
        if (i9 < 0 || i9 >= this.f21660c) {
            throw new IllegalArgumentException(e.i(i9, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return (K) this.f21659b[i9 << 1];
    }

    public final V g(int i9) {
        int i10;
        if (i9 < 0 || i9 >= (i10 = this.f21660c)) {
            throw new IllegalArgumentException(e.i(i9, "Expected index to be within 0..size()-1, but was ").toString());
        }
        Object[] objArr = this.f21659b;
        int i11 = i9 << 1;
        V v5 = (V) objArr[i11 + 1];
        if (i10 <= 1) {
            clear();
            return v5;
        }
        int i12 = i10 - 1;
        int[] iArr = this.f21658a;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i9 < i12) {
                int i13 = i9 + 1;
                f.b(i9, i13, iArr, iArr, i10);
                Object[] objArr2 = this.f21659b;
                f.d(objArr2, objArr2, i11, i13 << 1, i10 << 1);
            }
            Object[] objArr3 = this.f21659b;
            int i14 = i12 << 1;
            objArr3[i14] = null;
            objArr3[i14 + 1] = null;
        } else {
            int i15 = i10 > 8 ? i10 + (i10 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i15);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f21658a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f21659b, i15 << 1);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f21659b = objArrCopyOf;
            if (i10 != this.f21660c) {
                throw new ConcurrentModificationException();
            }
            if (i9 > 0) {
                f.b(0, 0, iArr, this.f21658a, i9);
                f.d(objArr, this.f21659b, 0, 0, i11);
            }
            if (i9 < i12) {
                int i16 = i9 + 1;
                f.b(i9, i16, iArr, this.f21658a, i10);
                f.d(objArr, this.f21659b, i11, i16 << 1, i10 << 1);
            }
        }
        if (i10 != this.f21660c) {
            throw new ConcurrentModificationException();
        }
        this.f21660c = i12;
        return v5;
    }

    public V get(K k7) {
        int iD = d(k7);
        if (iD >= 0) {
            return (V) this.f21659b[(iD << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V getOrDefault(Object obj, V v5) {
        int iD = d(obj);
        return iD >= 0 ? (V) this.f21659b[(iD << 1) + 1] : v5;
    }

    public final V h(int i9, V v5) {
        if (i9 < 0 || i9 >= this.f21660c) {
            throw new IllegalArgumentException(e.i(i9, "Expected index to be within 0..size()-1, but was ").toString());
        }
        int i10 = (i9 << 1) + 1;
        Object[] objArr = this.f21659b;
        V v8 = (V) objArr[i10];
        objArr[i10] = v5;
        return v8;
    }

    public final int hashCode() {
        int[] iArr = this.f21658a;
        Object[] objArr = this.f21659b;
        int i9 = this.f21660c;
        int i10 = 1;
        int i11 = 0;
        int iHashCode = 0;
        while (i11 < i9) {
            Object obj = objArr[i10];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i11];
            i11++;
            i10 += 2;
        }
        return iHashCode;
    }

    public final V i(int i9) {
        if (i9 < 0 || i9 >= this.f21660c) {
            throw new IllegalArgumentException(e.i(i9, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return (V) this.f21659b[(i9 << 1) + 1];
    }

    public final boolean isEmpty() {
        return this.f21660c <= 0;
    }

    public final V put(K k7, V v5) {
        int i9 = this.f21660c;
        int iHashCode = k7 != null ? k7.hashCode() : 0;
        int iC = k7 != null ? c(iHashCode, k7) : e();
        if (iC >= 0) {
            int i10 = (iC << 1) + 1;
            Object[] objArr = this.f21659b;
            V v8 = (V) objArr[i10];
            objArr[i10] = v5;
            return v8;
        }
        int i11 = ~iC;
        int[] iArr = this.f21658a;
        if (i9 >= iArr.length) {
            int i12 = 8;
            if (i9 >= 8) {
                i12 = (i9 >> 1) + i9;
            } else if (i9 < 4) {
                i12 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i12);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f21658a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f21659b, i12 << 1);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f21659b = objArrCopyOf;
            if (i9 != this.f21660c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i11 < i9) {
            int[] iArr2 = this.f21658a;
            int i13 = i11 + 1;
            f.b(i13, i11, iArr2, iArr2, i9);
            Object[] objArr2 = this.f21659b;
            f.d(objArr2, objArr2, i13 << 1, i11 << 1, this.f21660c << 1);
        }
        int i14 = this.f21660c;
        if (i9 == i14) {
            int[] iArr3 = this.f21658a;
            if (i11 < iArr3.length) {
                iArr3[i11] = iHashCode;
                Object[] objArr3 = this.f21659b;
                int i15 = i11 << 1;
                objArr3[i15] = k7;
                objArr3[i15 + 1] = v5;
                this.f21660c = i14 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final V putIfAbsent(K k7, V v5) {
        V v8 = get(k7);
        return v8 == null ? put(k7, v5) : v8;
    }

    public V remove(K k7) {
        int iD = d(k7);
        if (iD >= 0) {
            return g(iD);
        }
        return null;
    }

    public final V replace(K k7, V v5) {
        int iD = d(k7);
        if (iD >= 0) {
            return h(iD, v5);
        }
        return null;
    }

    public final int size() {
        return this.f21660c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f21660c * 28);
        sb.append('{');
        int i9 = this.f21660c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            K kF = f(i10);
            if (kF != sb) {
                sb.append(kF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vI = i(i10);
            if (vI != sb) {
                sb.append(vI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        k.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public g(int i9) {
        this.f21658a = i9 == 0 ? a.f21768a : new int[i9];
        this.f21659b = i9 == 0 ? a.f21769b : new Object[i9 << 1];
    }

    public final boolean remove(K k7, V v5) {
        int iD = d(k7);
        if (iD < 0 || !k.a(v5, i(iD))) {
            return false;
        }
        g(iD);
        return true;
    }

    public final boolean replace(K k7, V v5, V v8) {
        int iD = d(k7);
        if (iD < 0 || !k.a(v5, i(iD))) {
            return false;
        }
        h(iD, v8);
        return true;
    }
}
