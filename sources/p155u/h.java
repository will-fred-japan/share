package p155u;

import java.util.Arrays;
import kotlin.jvm.internal.k;
import p163v.a;
import y7.f;

/* JADX INFO: compiled from: SparseArrayCompat.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ int[] f21661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object[] f21662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f21663c;

    public h() {
        int i9;
        int i10 = 4;
        while (true) {
            i9 = 40;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (40 <= i11) {
                i9 = i11;
                break;
            }
            i10++;
        }
        int i12 = i9 / 4;
        this.f21661a = new int[i12];
        this.f21662b = new Object[i12];
    }

    public final void a(int i9, E e9) {
        int i10 = this.f21663c;
        if (i10 != 0 && i9 <= this.f21661a[i10 - 1]) {
            c(i9, e9);
            return;
        }
        if (i10 >= this.f21661a.length) {
            int i11 = (i10 + 1) * 4;
            for (int i12 = 4; i12 < 32; i12++) {
                int i13 = (1 << i12) - 12;
                if (i11 <= i13) {
                    i11 = i13;
                    break;
                }
            }
            int i14 = i11 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f21661a, i14);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f21661a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f21662b, i14);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f21662b = objArrCopyOf;
        }
        this.f21661a[i10] = i9;
        this.f21662b[i10] = e9;
        this.f21663c = i10 + 1;
    }

    public final E b(int i9) {
        E e9;
        int iA = a.a(this.f21663c, i9, this.f21661a);
        if (iA < 0 || (e9 = (E) this.f21662b[iA]) == i.f21664a) {
            return null;
        }
        return e9;
    }

    public final void c(int i9, E e9) {
        int iA = a.a(this.f21663c, i9, this.f21661a);
        if (iA >= 0) {
            this.f21662b[iA] = e9;
            return;
        }
        int i10 = ~iA;
        int i11 = this.f21663c;
        if (i10 < i11) {
            Object[] objArr = this.f21662b;
            if (objArr[i10] == i.f21664a) {
                this.f21661a[i10] = i9;
                objArr[i10] = e9;
                return;
            }
        }
        if (i11 >= this.f21661a.length) {
            int i12 = (i11 + 1) * 4;
            for (int i13 = 4; i13 < 32; i13++) {
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
            }
            int i15 = i12 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f21661a, i15);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f21661a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f21662b, i15);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f21662b = objArrCopyOf;
        }
        int i16 = this.f21663c;
        if (i16 - i10 != 0) {
            int[] iArr = this.f21661a;
            int i17 = i10 + 1;
            f.b(i17, i10, iArr, iArr, i16);
            Object[] objArr2 = this.f21662b;
            f.d(objArr2, objArr2, i17, i10, this.f21663c);
        }
        this.f21661a[i10] = i9;
        this.f21662b[i10] = e9;
        this.f21663c++;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        k.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        h hVar = (h) objClone;
        hVar.f21661a = (int[]) this.f21661a.clone();
        hVar.f21662b = (Object[]) this.f21662b.clone();
        return hVar;
    }

    public final String toString() {
        int i9 = this.f21663c;
        if (i9 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i9 * 28);
        sb.append('{');
        int i10 = this.f21663c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            sb.append(this.f21661a[i11]);
            sb.append('=');
            Object obj = this.f21662b[i11];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        k.d(string, "buffer.toString()");
        return string;
    }
}
