package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0572k extends A0.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f14112c = Logger.getLogger(AbstractC0572k.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f14113d = n0.f14133e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0573l f14114b;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.k$a */
    /* JADX INFO: compiled from: CodedOutputStream.java */
    public static class a extends AbstractC0572k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f14115e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f14116f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14117g;

        public a(byte[] bArr, int i9) {
            if (((bArr.length - i9) | i9) < 0) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException(W5.e.h(bArr.length, i9, "Array range is invalid. Buffer.length=", ", offset=0, length="));
            }
            this.f14115e = bArr;
            this.f14117g = 0;
            this.f14116f = i9;
        }

        public final int F() {
            return this.f14116f - this.f14117g;
        }

        public final void G(byte b9) throws b {
            int i9 = this.f14117g;
            try {
                int i10 = i9 + 1;
                try {
                    this.f14115e[i9] = b9;
                    this.f14117g = i10;
                } catch (IndexOutOfBoundsException e9) {
                    e = e9;
                    i9 = i10;
                    throw new b(i9, this.f14116f, 1, e);
                }
            } catch (IndexOutOfBoundsException e10) {
                e = e10;
            }
        }

        public final void H(int i9, boolean z8) throws b {
            Q(i9, 0);
            G(z8 ? (byte) 1 : (byte) 0);
        }

        public final void I(int i9, AbstractC0569h abstractC0569h) throws b {
            Q(i9, 2);
            S(abstractC0569h.size());
            abstractC0569h.p(this);
        }

        public final void J(int i9, int i10) throws b {
            Q(i9, 5);
            K(i10);
        }

        public final void K(int i9) throws b {
            int i10 = this.f14117g;
            try {
                byte[] bArr = this.f14115e;
                bArr[i10] = (byte) i9;
                bArr[i10 + 1] = (byte) (i9 >> 8);
                bArr[i10 + 2] = (byte) (i9 >> 16);
                bArr[i10 + 3] = (byte) (i9 >> 24);
                this.f14117g = i10 + 4;
            } catch (IndexOutOfBoundsException e9) {
                throw new b(i10, this.f14116f, 4, e9);
            }
        }

        public final void L(int i9, long j) throws b {
            Q(i9, 1);
            M(j);
        }

        public final void M(long j) throws b {
            int i9 = this.f14117g;
            try {
                byte[] bArr = this.f14115e;
                bArr[i9] = (byte) j;
                bArr[i9 + 1] = (byte) (j >> 8);
                bArr[i9 + 2] = (byte) (j >> 16);
                bArr[i9 + 3] = (byte) (j >> 24);
                bArr[i9 + 4] = (byte) (j >> 32);
                bArr[i9 + 5] = (byte) (j >> 40);
                bArr[i9 + 6] = (byte) (j >> 48);
                bArr[i9 + 7] = (byte) (j >> 56);
                this.f14117g = i9 + 8;
            } catch (IndexOutOfBoundsException e9) {
                throw new b(i9, this.f14116f, 8, e9);
            }
        }

        public final void N(int i9, int i10) throws b {
            Q(i9, 0);
            O(i10);
        }

        public final void O(int i9) throws b {
            if (i9 >= 0) {
                S(i9);
            } else {
                U(i9);
            }
        }

        public final void P(int i9, String str) throws b {
            Q(i9, 2);
            int i10 = this.f14117g;
            try {
                int iD = AbstractC0572k.D(str.length() * 3);
                int iD2 = AbstractC0572k.D(str.length());
                byte[] bArr = this.f14115e;
                if (iD2 != iD) {
                    S(o0.b(str));
                    this.f14117g = o0.f14142a.b(this.f14117g, bArr, F(), str);
                    return;
                }
                int i11 = i10 + iD2;
                this.f14117g = i11;
                int iB = o0.f14142a.b(i11, bArr, F(), str);
                this.f14117g = i10;
                S((iB - i10) - iD2);
                this.f14117g = iB;
            } catch (o0.d e9) {
                this.f14117g = i10;
                AbstractC0572k.f14112c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e9);
                byte[] bytes = str.getBytes(C0585y.f14183a);
                try {
                    S(bytes.length);
                    v(0, bytes.length, bytes);
                } catch (IndexOutOfBoundsException e10) {
                    throw new b(e10);
                }
            } catch (IndexOutOfBoundsException e11) {
                throw new b(e11);
            }
        }

        public final void Q(int i9, int i10) throws b {
            S((i9 << 3) | i10);
        }

        public final void R(int i9, int i10) throws b {
            Q(i9, 0);
            S(i10);
        }

        public final void S(int i9) throws b {
            int i10;
            int i11 = this.f14117g;
            while (true) {
                int i12 = i9 & (-128);
                byte[] bArr = this.f14115e;
                if (i12 == 0) {
                    i10 = i11 + 1;
                    bArr[i11] = (byte) i9;
                    this.f14117g = i10;
                    return;
                } else {
                    i10 = i11 + 1;
                    try {
                        bArr[i11] = (byte) (i9 | 128);
                        i9 >>>= 7;
                        i11 = i10;
                    } catch (IndexOutOfBoundsException e9) {
                        throw new b(i10, this.f14116f, 1, e9);
                    }
                }
                throw new b(i10, this.f14116f, 1, e9);
            }
        }

        public final void T(int i9, long j) throws b {
            Q(i9, 0);
            U(j);
        }

        public final void U(long j) throws b {
            int i9;
            int i10 = this.f14117g;
            boolean z8 = AbstractC0572k.f14113d;
            byte[] bArr = this.f14115e;
            if (!z8 || F() < 10) {
                while ((j & (-128)) != 0) {
                    i9 = i10 + 1;
                    try {
                        bArr[i10] = (byte) (((int) j) | 128);
                        j >>>= 7;
                        i10 = i9;
                    } catch (IndexOutOfBoundsException e9) {
                        throw new b(i9, this.f14116f, 1, e9);
                    }
                }
                i9 = i10 + 1;
                bArr[i10] = (byte) j;
            } else {
                while ((j & (-128)) != 0) {
                    n0.k(bArr, i10, (byte) (((int) j) | 128));
                    j >>>= 7;
                    i10++;
                }
                i9 = i10 + 1;
                n0.k(bArr, i10, (byte) j);
            }
            this.f14117g = i9;
        }

        @Override // A0.h
        public final void v(int i9, int i10, byte[] bArr) {
            try {
                System.arraycopy(bArr, i9, this.f14115e, this.f14117g, i10);
                this.f14117g += i10;
            } catch (IndexOutOfBoundsException e9) {
                throw new b(this.f14117g, this.f14116f, i10, e9);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.k$b */
    /* JADX INFO: compiled from: CodedOutputStream.java */
    public static class b extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public b(IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(int i9, int i10, int i11, IndexOutOfBoundsException indexOutOfBoundsException) {
            Locale locale = Locale.US;
            StringBuilder sbH = defpackage.f.h(i9, "Pos: ", ", limit: ");
            sbH.append(i10);
            sbH.append(", len: ");
            sbH.append(i11);
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbH.toString()), indexOutOfBoundsException);
        }
    }

    public AbstractC0572k() {
        super(10);
    }

    public static int A(long j) {
        return E((j >> 63) ^ (j << 1));
    }

    public static int B(String str) {
        int length;
        try {
            length = o0.b(str);
        } catch (o0.d unused) {
            length = str.getBytes(C0585y.f14183a).length;
        }
        return D(length) + length;
    }

    public static int C(int i9) {
        return D(i9 << 3);
    }

    public static int D(int i9) {
        return (352 - (Integer.numberOfLeadingZeros(i9) * 9)) >>> 6;
    }

    public static int E(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int w(int i9, AbstractC0569h abstractC0569h) {
        return x(abstractC0569h) + C(i9);
    }

    public static int x(AbstractC0569h abstractC0569h) {
        int size = abstractC0569h.size();
        return D(size) + size;
    }

    public static int y(C c5) {
        int iA;
        if (c5.f14001b != null) {
            iA = c5.f14001b.size();
        } else {
            iA = c5.f14000a != null ? c5.f14000a.a() : 0;
        }
        return D(iA) + iA;
    }

    public static int z(int i9) {
        return D((i9 >> 31) ^ (i9 << 1));
    }
}
