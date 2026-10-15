package com.google.crypto.tink.shaded.protobuf;

import androidx.datastore.preferences.protobuf.C0524s;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0569h implements Iterable<Byte>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f14069b = new f(C0585y.f14184b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f14070c;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14071a = 0;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.h$a */
    /* JADX INFO: compiled from: ByteString.java */
    public static abstract class a implements Iterator {
        @Override // java.util.Iterator
        public final Object next() {
            C0568g c0568g = (C0568g) this;
            int i9 = c0568g.f14066a;
            if (i9 >= c0568g.f14067b) {
                throw new NoSuchElementException();
            }
            c0568g.f14066a = i9 + 1;
            return Byte.valueOf(c0568g.f14068c.k(i9));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.h$b */
    /* JADX INFO: compiled from: ByteString.java */
    public static final class b implements d {
        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h.d
        public final byte[] a(int i9, int i10, byte[] bArr) {
            return Arrays.copyOfRange(bArr, i9, i10 + i9);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.h$c */
    /* JADX INFO: compiled from: ByteString.java */
    public static final class c extends f {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f14072e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f14073f;

        public c(byte[] bArr, int i9, int i10) {
            super(bArr);
            AbstractC0569h.g(i9, i9 + i10, bArr.length);
            this.f14072e = i9;
            this.f14073f = i10;
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h.f, com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final byte f(int i9) {
            int i10 = this.f14073f;
            if (((i10 - (i9 + 1)) | i9) >= 0) {
                return this.f14074d[this.f14072e + i9];
            }
            if (i9 < 0) {
                throw new ArrayIndexOutOfBoundsException(W5.e.i(i9, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(W5.e.h(i9, i10, "Index > length: ", ", "));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h.f, com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final void i(int i9, byte[] bArr) {
            System.arraycopy(this.f14074d, this.f14072e, bArr, 0, i9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h.f, com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final byte k(int i9) {
            return this.f14074d[this.f14072e + i9];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h.f
        public final int q() {
            return this.f14072e;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h.f, com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final int size() {
            return this.f14073f;
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.h$d */
    /* JADX INFO: compiled from: ByteString.java */
    public interface d {
        byte[] a(int i9, int i10, byte[] bArr);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.h$e */
    /* JADX INFO: compiled from: ByteString.java */
    public static abstract class e extends AbstractC0569h {
        private static final long serialVersionUID = 1;

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h, java.lang.Iterable
        public final Iterator<Byte> iterator() {
            return new C0568g(this);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.h$f */
    /* JADX INFO: compiled from: ByteString.java */
    public static class f extends e {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f14074d;

        public f(byte[] bArr) {
            bArr.getClass();
            this.f14074d = bArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC0569h) || size() != ((AbstractC0569h) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof f)) {
                return obj.equals(this);
            }
            f fVar = (f) obj;
            int i9 = this.f14071a;
            int i10 = fVar.f14071a;
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
            int iQ = q() + size;
            int iQ2 = q();
            int iQ3 = fVar.q();
            while (iQ2 < iQ) {
                if (this.f14074d[iQ2] != fVar.f14074d[iQ3]) {
                    return false;
                }
                iQ2++;
                iQ3++;
            }
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public byte f(int i9) {
            return this.f14074d[i9];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public void i(int i9, byte[] bArr) {
            System.arraycopy(this.f14074d, 0, bArr, 0, i9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public byte k(int i9) {
            return this.f14074d[i9];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final AbstractC0570i.a l() {
            return AbstractC0570i.f(true, q(), size(), this.f14074d);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final int m(int i9, int i10) {
            int iQ = q();
            Charset charset = C0585y.f14183a;
            for (int i11 = iQ; i11 < iQ + i10; i11++) {
                i9 = (i9 * 31) + this.f14074d[i11];
            }
            return i9;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final f n(int i9) {
            int iG = AbstractC0569h.g(0, i9, size());
            if (iG == 0) {
                return AbstractC0569h.f14069b;
            }
            return new c(this.f14074d, q(), iG);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public final void p(AbstractC0572k.a aVar) {
            aVar.v(q(), size(), this.f14074d);
        }

        public int q() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h
        public int size() {
            return this.f14074d.length;
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.h$g */
    /* JADX INFO: compiled from: ByteString.java */
    public static final class g implements d {
        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0569h.d
        public final byte[] a(int i9, int i10, byte[] bArr) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, i9, bArr2, 0, i10);
            return bArr2;
        }
    }

    static {
        f14070c = C0565d.a() ? new g() : new b();
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
        return new f(f14070c.a(i9, i10, bArr));
    }

    public abstract boolean equals(Object obj);

    public abstract byte f(int i9);

    public final int hashCode() {
        int iM = this.f14071a;
        if (iM == 0) {
            int size = size();
            iM = m(size, size);
            if (iM == 0) {
                iM = 1;
            }
            this.f14071a = iM;
        }
        return iM;
    }

    public abstract void i(int i9, byte[] bArr);

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new C0568g(this);
    }

    public abstract byte k(int i9);

    public abstract AbstractC0570i.a l();

    public abstract int m(int i9, int i10);

    public abstract f n(int i9);

    public final byte[] o() {
        int size = size();
        if (size == 0) {
            return C0585y.f14184b;
        }
        byte[] bArr = new byte[size];
        i(size, bArr);
        return bArr;
    }

    public abstract void p(AbstractC0572k.a aVar);

    public abstract int size();

    public final String toString() {
        String strW;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strW = p011b4.h.w(this);
        } else {
            strW = p011b4.h.w(n(47)) + "...";
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return A.a.j(sb, strW, "\">");
    }
}
