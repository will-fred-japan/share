package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0516j extends A0.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f7267c = Logger.getLogger(AbstractC0516j.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7268d = p0.f7296e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0517k f7269b;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.j$a */
    /* JADX INFO: compiled from: CodedOutputStream.java */
    public static abstract class a extends AbstractC0516j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7270e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7271f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7272g;

        public a(int i9) {
            if (i9 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i9, 20)];
            this.f7270e = bArr;
            this.f7271f = bArr.length;
        }

        public final void c0(int i9) {
            int i10 = this.f7272g;
            int i11 = i10 + 1;
            this.f7272g = i11;
            byte[] bArr = this.f7270e;
            bArr[i10] = (byte) (i9 & 255);
            int i12 = i10 + 2;
            this.f7272g = i12;
            bArr[i11] = (byte) ((i9 >> 8) & 255);
            int i13 = i10 + 3;
            this.f7272g = i13;
            bArr[i12] = (byte) ((i9 >> 16) & 255);
            this.f7272g = i10 + 4;
            bArr[i13] = (byte) ((i9 >> 24) & 255);
        }

        public final void d0(long j) {
            int i9 = this.f7272g;
            int i10 = i9 + 1;
            this.f7272g = i10;
            byte[] bArr = this.f7270e;
            bArr[i9] = (byte) (j & 255);
            int i11 = i9 + 2;
            this.f7272g = i11;
            bArr[i10] = (byte) ((j >> 8) & 255);
            int i12 = i9 + 3;
            this.f7272g = i12;
            bArr[i11] = (byte) ((j >> 16) & 255);
            int i13 = i9 + 4;
            this.f7272g = i13;
            bArr[i12] = (byte) (255 & (j >> 24));
            int i14 = i9 + 5;
            this.f7272g = i14;
            bArr[i13] = (byte) (((int) (j >> 32)) & 255);
            int i15 = i9 + 6;
            this.f7272g = i15;
            bArr[i14] = (byte) (((int) (j >> 40)) & 255);
            int i16 = i9 + 7;
            this.f7272g = i16;
            bArr[i15] = (byte) (((int) (j >> 48)) & 255);
            this.f7272g = i9 + 8;
            bArr[i16] = (byte) (((int) (j >> 56)) & 255);
        }

        public final void e0(int i9, int i10) {
            f0((i9 << 3) | i10);
        }

        public final void f0(int i9) {
            boolean z8 = AbstractC0516j.f7268d;
            byte[] bArr = this.f7270e;
            if (z8) {
                while ((i9 & (-128)) != 0) {
                    int i10 = this.f7272g;
                    this.f7272g = i10 + 1;
                    p0.j(bArr, i10, (byte) ((i9 | 128) & 255));
                    i9 >>>= 7;
                }
                int i11 = this.f7272g;
                this.f7272g = i11 + 1;
                p0.j(bArr, i11, (byte) i9);
                return;
            }
            while ((i9 & (-128)) != 0) {
                int i12 = this.f7272g;
                this.f7272g = i12 + 1;
                bArr[i12] = (byte) ((i9 | 128) & 255);
                i9 >>>= 7;
            }
            int i13 = this.f7272g;
            this.f7272g = i13 + 1;
            bArr[i13] = (byte) i9;
        }

        public final void g0(long j) {
            boolean z8 = AbstractC0516j.f7268d;
            byte[] bArr = this.f7270e;
            if (z8) {
                while ((j & (-128)) != 0) {
                    int i9 = this.f7272g;
                    this.f7272g = i9 + 1;
                    p0.j(bArr, i9, (byte) ((((int) j) | 128) & 255));
                    j >>>= 7;
                }
                int i10 = this.f7272g;
                this.f7272g = i10 + 1;
                p0.j(bArr, i10, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                int i11 = this.f7272g;
                this.f7272g = i11 + 1;
                bArr[i11] = (byte) ((((int) j) | 128) & 255);
                j >>>= 7;
            }
            int i12 = this.f7272g;
            this.f7272g = i12 + 1;
            bArr[i12] = (byte) j;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.j$b */
    /* JADX INFO: compiled from: CodedOutputStream.java */
    public static class b extends AbstractC0516j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7273e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7274f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7275g;

        public b(byte[] bArr, int i9) {
            if (((bArr.length - i9) | i9) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i9)));
            }
            this.f7273e = bArr;
            this.f7275g = 0;
            this.f7274f = i9;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void G(byte b9) throws c {
            try {
                byte[] bArr = this.f7273e;
                int i9 = this.f7275g;
                this.f7275g = i9 + 1;
                bArr[i9] = b9;
            } catch (IndexOutOfBoundsException e9) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7275g), Integer.valueOf(this.f7274f), 1), e9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void H(int i9, boolean z8) throws c {
            X(i9, 0);
            G(z8 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void I(int i9, byte[] bArr) throws c {
            Z(i9);
            c0(bArr, 0, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void J(int i9, AbstractC0513g abstractC0513g) throws c {
            X(i9, 2);
            K(abstractC0513g);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void K(AbstractC0513g abstractC0513g) throws c {
            Z(abstractC0513g.size());
            abstractC0513g.n(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void L(int i9, int i10) throws c {
            X(i9, 5);
            M(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void M(int i9) throws c {
            try {
                byte[] bArr = this.f7273e;
                int i10 = this.f7275g;
                int i11 = i10 + 1;
                this.f7275g = i11;
                bArr[i10] = (byte) (i9 & 255);
                int i12 = i10 + 2;
                this.f7275g = i12;
                bArr[i11] = (byte) ((i9 >> 8) & 255);
                int i13 = i10 + 3;
                this.f7275g = i13;
                bArr[i12] = (byte) ((i9 >> 16) & 255);
                this.f7275g = i10 + 4;
                bArr[i13] = (byte) ((i9 >> 24) & 255);
            } catch (IndexOutOfBoundsException e9) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7275g), Integer.valueOf(this.f7274f), 1), e9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void N(int i9, long j) throws c {
            X(i9, 1);
            O(j);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void O(long j) throws c {
            try {
                byte[] bArr = this.f7273e;
                int i9 = this.f7275g;
                int i10 = i9 + 1;
                this.f7275g = i10;
                bArr[i9] = (byte) (((int) j) & 255);
                int i11 = i9 + 2;
                this.f7275g = i11;
                bArr[i10] = (byte) (((int) (j >> 8)) & 255);
                int i12 = i9 + 3;
                this.f7275g = i12;
                bArr[i11] = (byte) (((int) (j >> 16)) & 255);
                int i13 = i9 + 4;
                this.f7275g = i13;
                bArr[i12] = (byte) (((int) (j >> 24)) & 255);
                int i14 = i9 + 5;
                this.f7275g = i14;
                bArr[i13] = (byte) (((int) (j >> 32)) & 255);
                int i15 = i9 + 6;
                this.f7275g = i15;
                bArr[i14] = (byte) (((int) (j >> 40)) & 255);
                int i16 = i9 + 7;
                this.f7275g = i16;
                bArr[i15] = (byte) (((int) (j >> 48)) & 255);
                this.f7275g = i9 + 8;
                bArr[i16] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e9) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7275g), Integer.valueOf(this.f7274f), 1), e9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void P(int i9, int i10) throws c {
            X(i9, 0);
            Q(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void Q(int i9) throws c {
            if (i9 >= 0) {
                Z(i9);
            } else {
                b0(i9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void R(int i9, Q q8, f0 f0Var) throws c {
            X(i9, 2);
            Z(((AbstractC0507a) q8).g(f0Var));
            f0Var.e(q8, this.f7269b);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void S(Q q8) throws c {
            Z(q8.a());
            q8.d(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void T(int i9, Q q8) throws c {
            X(1, 3);
            Y(2, i9);
            X(3, 2);
            S(q8);
            X(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void U(int i9, AbstractC0513g abstractC0513g) throws c {
            X(1, 3);
            Y(2, i9);
            J(3, abstractC0513g);
            X(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void V(int i9, String str) throws c {
            X(i9, 2);
            W(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void W(String str) throws c {
            int i9 = this.f7275g;
            try {
                int iD = AbstractC0516j.D(str.length() * 3);
                int iD2 = AbstractC0516j.D(str.length());
                int i10 = this.f7274f;
                byte[] bArr = this.f7273e;
                if (iD2 != iD) {
                    Z(q0.a(str));
                    int i11 = this.f7275g;
                    this.f7275g = q0.f7302a.b(i11, bArr, i10 - i11, str);
                    return;
                }
                int i12 = i9 + iD2;
                this.f7275g = i12;
                int iB = q0.f7302a.b(i12, bArr, i10 - i12, str);
                this.f7275g = i9;
                Z((iB - i9) - iD2);
                this.f7275g = iB;
            } catch (q0.d e9) {
                this.f7275g = i9;
                F(str, e9);
            } catch (IndexOutOfBoundsException e10) {
                throw new c(e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void X(int i9, int i10) throws c {
            Z((i9 << 3) | i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void Y(int i9, int i10) throws c {
            X(i9, 0);
            Z(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void Z(int i9) throws c {
            while (true) {
                int i10 = i9 & (-128);
                byte[] bArr = this.f7273e;
                if (i10 == 0) {
                    int i11 = this.f7275g;
                    this.f7275g = i11 + 1;
                    bArr[i11] = (byte) i9;
                    return;
                } else {
                    try {
                        int i12 = this.f7275g;
                        this.f7275g = i12 + 1;
                        bArr[i12] = (byte) ((i9 | 128) & 255);
                        i9 >>>= 7;
                    } catch (IndexOutOfBoundsException e9) {
                        throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7275g), Integer.valueOf(this.f7274f), 1), e9);
                    }
                }
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7275g), Integer.valueOf(this.f7274f), 1), e9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void a0(int i9, long j) throws c {
            X(i9, 0);
            b0(j);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void b0(long j) throws c {
            boolean z8 = AbstractC0516j.f7268d;
            int i9 = this.f7274f;
            byte[] bArr = this.f7273e;
            if (z8 && i9 - this.f7275g >= 10) {
                while ((j & (-128)) != 0) {
                    int i10 = this.f7275g;
                    this.f7275g = i10 + 1;
                    p0.j(bArr, i10, (byte) ((((int) j) | 128) & 255));
                    j >>>= 7;
                }
                int i11 = this.f7275g;
                this.f7275g = i11 + 1;
                p0.j(bArr, i11, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    int i12 = this.f7275g;
                    this.f7275g = i12 + 1;
                    bArr[i12] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e9) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7275g), Integer.valueOf(i9), 1), e9);
                }
            }
            int i13 = this.f7275g;
            this.f7275g = i13 + 1;
            bArr[i13] = (byte) j;
        }

        public final void c0(byte[] bArr, int i9, int i10) throws c {
            try {
                System.arraycopy(bArr, i9, this.f7273e, this.f7275g, i10);
                this.f7275g += i10;
            } catch (IndexOutOfBoundsException e9) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7275g), Integer.valueOf(this.f7274f), Integer.valueOf(i10)), e9);
            }
        }

        @Override // A0.h
        public final void v(int i9, int i10, byte[] bArr) throws c {
            c0(bArr, i9, i10);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.j$c */
    /* JADX INFO: compiled from: CodedOutputStream.java */
    public static class c extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public c(IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
        }

        public c(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(str), indexOutOfBoundsException);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.j$d */
    /* JADX INFO: compiled from: CodedOutputStream.java */
    public static final class d extends a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Z.j0 f7276h;

        public d(Z.j0 j0Var, int i9) {
            super(i9);
            this.f7276h = j0Var;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void G(byte b9) throws IOException {
            if (this.f7272g == this.f7271f) {
                h0();
            }
            int i9 = this.f7272g;
            this.f7272g = i9 + 1;
            this.f7270e[i9] = b9;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void H(int i9, boolean z8) throws IOException {
            i0(11);
            e0(i9, 0);
            byte b9 = z8 ? (byte) 1 : (byte) 0;
            int i10 = this.f7272g;
            this.f7272g = i10 + 1;
            this.f7270e[i10] = b9;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void I(int i9, byte[] bArr) throws IOException {
            Z(i9);
            j0(bArr, 0, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void J(int i9, AbstractC0513g abstractC0513g) throws IOException {
            X(i9, 2);
            K(abstractC0513g);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void K(AbstractC0513g abstractC0513g) throws IOException {
            Z(abstractC0513g.size());
            abstractC0513g.n(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void L(int i9, int i10) throws IOException {
            i0(14);
            e0(i9, 5);
            c0(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void M(int i9) throws IOException {
            i0(4);
            c0(i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void N(int i9, long j) throws IOException {
            i0(18);
            e0(i9, 1);
            d0(j);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void O(long j) throws IOException {
            i0(8);
            d0(j);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void P(int i9, int i10) throws IOException {
            i0(20);
            e0(i9, 0);
            if (i10 >= 0) {
                f0(i10);
            } else {
                g0(i10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void Q(int i9) throws IOException {
            if (i9 >= 0) {
                Z(i9);
            } else {
                b0(i9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void R(int i9, Q q8, f0 f0Var) throws IOException {
            X(i9, 2);
            Z(((AbstractC0507a) q8).g(f0Var));
            f0Var.e(q8, this.f7269b);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void S(Q q8) throws IOException {
            Z(q8.a());
            q8.d(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void T(int i9, Q q8) throws IOException {
            X(1, 3);
            Y(2, i9);
            X(3, 2);
            S(q8);
            X(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void U(int i9, AbstractC0513g abstractC0513g) throws IOException {
            X(1, 3);
            Y(2, i9);
            J(3, abstractC0513g);
            X(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void V(int i9, String str) throws IOException {
            X(i9, 2);
            W(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void W(String str) throws IOException {
            try {
                int length = str.length() * 3;
                int iD = AbstractC0516j.D(length);
                int i9 = iD + length;
                int i10 = this.f7271f;
                if (i9 > i10) {
                    byte[] bArr = new byte[length];
                    int iB = q0.f7302a.b(0, bArr, length, str);
                    Z(iB);
                    j0(bArr, 0, iB);
                    return;
                }
                if (i9 > i10 - this.f7272g) {
                    h0();
                }
                int iD2 = AbstractC0516j.D(str.length());
                int i11 = this.f7272g;
                byte[] bArr2 = this.f7270e;
                try {
                    try {
                        if (iD2 == iD) {
                            int i12 = i11 + iD2;
                            this.f7272g = i12;
                            int iB2 = q0.f7302a.b(i12, bArr2, i10 - i12, str);
                            this.f7272g = i11;
                            f0((iB2 - i11) - iD2);
                            this.f7272g = iB2;
                        } else {
                            int iA = q0.a(str);
                            f0(iA);
                            this.f7272g = q0.f7302a.b(this.f7272g, bArr2, iA, str);
                        }
                    } catch (q0.d e9) {
                        this.f7272g = i11;
                        throw e9;
                    }
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw new c(e10);
                }
            } catch (q0.d e11) {
                F(str, e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void X(int i9, int i10) throws IOException {
            Z((i9 << 3) | i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void Y(int i9, int i10) throws IOException {
            i0(20);
            e0(i9, 0);
            f0(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void Z(int i9) throws IOException {
            i0(5);
            f0(i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void a0(int i9, long j) throws IOException {
            i0(20);
            e0(i9, 0);
            g0(j);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0516j
        public final void b0(long j) throws IOException {
            i0(10);
            g0(j);
        }

        public final void h0() throws IOException {
            this.f7276h.write(this.f7270e, 0, this.f7272g);
            this.f7272g = 0;
        }

        public final void i0(int i9) throws IOException {
            if (this.f7271f - this.f7272g < i9) {
                h0();
            }
        }

        public final void j0(byte[] bArr, int i9, int i10) throws IOException {
            int i11 = this.f7272g;
            int i12 = this.f7271f;
            int i13 = i12 - i11;
            byte[] bArr2 = this.f7270e;
            if (i13 >= i10) {
                System.arraycopy(bArr, i9, bArr2, i11, i10);
                this.f7272g += i10;
                return;
            }
            System.arraycopy(bArr, i9, bArr2, i11, i13);
            int i14 = i9 + i13;
            int i15 = i10 - i13;
            this.f7272g = i12;
            h0();
            if (i15 > i12) {
                this.f7276h.write(bArr, i14, i15);
            } else {
                System.arraycopy(bArr, i14, bArr2, 0, i15);
                this.f7272g = i15;
            }
        }

        @Override // A0.h
        public final void v(int i9, int i10, byte[] bArr) throws IOException {
            j0(bArr, i9, i10);
        }
    }

    public AbstractC0516j() {
        super(7);
    }

    public static int A(long j) {
        return E((j >> 63) ^ (j << 1));
    }

    public static int B(String str) {
        int length;
        try {
            length = q0.a(str);
        } catch (q0.d unused) {
            length = str.getBytes(C0530y.f7343a).length;
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

    public static int w(int i9, AbstractC0513g abstractC0513g) {
        return x(abstractC0513g) + C(i9);
    }

    public static int x(AbstractC0513g abstractC0513g) {
        int size = abstractC0513g.size();
        return D(size) + size;
    }

    public static int y(C c5) {
        int iA;
        if (c5.f7162b != null) {
            iA = c5.f7162b.size();
        } else {
            iA = c5.f7161a != null ? c5.f7161a.a() : 0;
        }
        return D(iA) + iA;
    }

    public static int z(int i9) {
        return D((i9 >> 31) ^ (i9 << 1));
    }

    public final void F(String str, q0.d dVar) throws c {
        f7267c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(C0530y.f7343a);
        try {
            Z(bytes.length);
            v(0, bytes.length, bytes);
        } catch (IndexOutOfBoundsException e9) {
            throw new c(e9);
        }
    }

    public abstract void G(byte b9);

    public abstract void H(int i9, boolean z8);

    public abstract void I(int i9, byte[] bArr);

    public abstract void J(int i9, AbstractC0513g abstractC0513g);

    public abstract void K(AbstractC0513g abstractC0513g);

    public abstract void L(int i9, int i10);

    public abstract void M(int i9);

    public abstract void N(int i9, long j);

    public abstract void O(long j);

    public abstract void P(int i9, int i10);

    public abstract void Q(int i9);

    public abstract void R(int i9, Q q8, f0 f0Var);

    public abstract void S(Q q8);

    public abstract void T(int i9, Q q8);

    public abstract void U(int i9, AbstractC0513g abstractC0513g);

    public abstract void V(int i9, String str);

    public abstract void W(String str);

    public abstract void X(int i9, int i10);

    public abstract void Y(int i9, int i10);

    public abstract void Z(int i9);

    public abstract void a0(int i9, long j);

    public abstract void b0(long j);
}
