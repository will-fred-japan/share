package androidx.datastore.preferences.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0513g implements Iterable<Byte>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f7223b = new f(C0530y.f7344b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f7224c;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7225a = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$a */
    /* JADX INFO: compiled from: ByteString.java */
    public static abstract class a implements Iterator {
        @Override // java.util.Iterator
        public final Object next() {
            C0512f c0512f = (C0512f) this;
            int i9 = c0512f.f7220a;
            if (i9 >= c0512f.f7221b) {
                throw new NoSuchElementException();
            }
            c0512f.f7220a = i9 + 1;
            return Byte.valueOf(c0512f.f7222c.k(i9));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$b */
    /* JADX INFO: compiled from: ByteString.java */
    public static final class b implements d {
        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g.d
        public final byte[] a(int i9, int i10, byte[] bArr) {
            return Arrays.copyOfRange(bArr, i9, i10 + i9);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$c */
    /* JADX INFO: compiled from: ByteString.java */
    public static final class c extends f {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7226e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7227f;

        public c(byte[] bArr, int i9, int i10) {
            super(bArr);
            AbstractC0513g.g(i9, i9 + i10, bArr.length);
            this.f7226e = i9;
            this.f7227f = i10;
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g.f, androidx.datastore.preferences.protobuf.AbstractC0513g
        public final byte f(int i9) {
            int i10 = this.f7227f;
            if (((i10 - (i9 + 1)) | i9) >= 0) {
                return this.f7228d[this.f7226e + i9];
            }
            if (i9 < 0) {
                throw new ArrayIndexOutOfBoundsException(W5.e.i(i9, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(W5.e.h(i9, i10, "Index > length: ", ", "));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g.f, androidx.datastore.preferences.protobuf.AbstractC0513g
        public final void i(int i9, byte[] bArr) {
            System.arraycopy(this.f7228d, this.f7226e, bArr, 0, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g.f, androidx.datastore.preferences.protobuf.AbstractC0513g
        public final byte k(int i9) {
            return this.f7228d[this.f7226e + i9];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g.f
        public final int o() {
            return this.f7226e;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g.f, androidx.datastore.preferences.protobuf.AbstractC0513g
        public final int size() {
            return this.f7227f;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$d */
    /* JADX INFO: compiled from: ByteString.java */
    public interface d {
        byte[] a(int i9, int i10, byte[] bArr);
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$e */
    /* JADX INFO: compiled from: ByteString.java */
    public static abstract class e extends AbstractC0513g {
        private static final long serialVersionUID = 1;

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g, java.lang.Iterable
        public final Iterator<Byte> iterator() {
            return new C0512f(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$f */
    /* JADX INFO: compiled from: ByteString.java */
    public static class f extends e {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f7228d;

        public f(byte[] bArr) {
            bArr.getClass();
            this.f7228d = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC0513g) || size() != ((AbstractC0513g) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof f)) {
                return obj.equals(this);
            }
            f fVar = (f) obj;
            int i9 = this.f7225a;
            int i10 = fVar.f7225a;
            if (i9 != 0 && i10 != 0 && i9 != i10) {
                return false;
            }
            int size = size();
            if (size > fVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            }
            if (size > fVar.size()) {
                StringBuilder sbA = C0524s.a(size, "Ran off end of other: 0, ", ", ");
                sbA.append(fVar.size());
                throw new IllegalArgumentException(sbA.toString());
            }
            int iO = o() + size;
            int iO2 = o();
            int iO3 = fVar.o();
            while (iO2 < iO) {
                if (this.f7228d[iO2] != fVar.f7228d[iO3]) {
                    return false;
                }
                iO2++;
                iO3++;
            }
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g
        public byte f(int i9) {
            return this.f7228d[i9];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g
        public void i(int i9, byte[] bArr) {
            System.arraycopy(this.f7228d, 0, bArr, 0, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g
        public byte k(int i9) {
            return this.f7228d[i9];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g
        public final int l(int i9, int i10) {
            int iO = o();
            Charset charset = C0530y.f7343a;
            for (int i11 = iO; i11 < iO + i10; i11++) {
                i9 = (i9 * 31) + this.f7228d[i11];
            }
            return i9;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g
        public final f m(int i9) {
            int iG = AbstractC0513g.g(0, i9, size());
            if (iG == 0) {
                return AbstractC0513g.f7223b;
            }
            return new c(this.f7228d, o(), iG);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g
        public final void n(AbstractC0516j abstractC0516j) {
            abstractC0516j.v(o(), size(), this.f7228d);
        }

        public int o() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g
        public int size() {
            return this.f7228d.length;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteString.java */
    public static final class C0101g implements d {
        @Override // androidx.datastore.preferences.protobuf.AbstractC0513g.d
        public final byte[] a(int i9, int i10, byte[] bArr) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, i9, bArr2, 0, i10);
            return bArr2;
        }
    }

    static {
        f7224c = C0510d.a() ? new C0101g() : new b();
    }

    public static int g(int i9, int i10, int i11) {
        int i12 = i10 - i9;
        if ((i9 | i10 | i12 | (i11 - i10)) >= 0) {
            return i12;
        }
        if (i9 < 0) {
            throw new IndexOutOfBoundsException(defpackage.f.b(i9, "Beginning index: ", " < 0"));
        }
        if (i10 < i9) {
            throw new IndexOutOfBoundsException(W5.e.h(i9, i10, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(W5.e.h(i10, i11, "End index: ", " >= "));
    }

    public static f h(int i9, int i10, byte[] bArr) {
        g(i9, i9 + i10, bArr.length);
        return new f(f7224c.a(i9, i10, bArr));
    }

    public abstract boolean equals(Object obj);

    public abstract byte f(int i9);

    public final int hashCode() {
        int iL = this.f7225a;
        if (iL == 0) {
            int size = size();
            iL = l(size, size);
            if (iL == 0) {
                iL = 1;
            }
            this.f7225a = iL;
        }
        return iL;
    }

    public abstract void i(int i9, byte[] bArr);

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new C0512f(this);
    }

    public abstract byte k(int i9);

    public abstract int l(int i9, int i10);

    public abstract f m(int i9);

    public abstract void n(AbstractC0516j abstractC0516j);

    public abstract int size();

    public final String toString() {
        String strA;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strA = k0.a(this);
        } else {
            strA = k0.a(m(47)) + "...";
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return A.a.j(sb, strA, "\">");
    }
}
