package androidx.datastore.preferences.protobuf;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0514h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7233b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7234c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0515i f7235d;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h$a */
    /* JADX INFO: compiled from: CodedInputStream.java */
    public static final class a extends AbstractC0514h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7236e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7237f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7238g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7239h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f7240i;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7241k = Integer.MAX_VALUE;

        public a(boolean z8, int i9, int i10, byte[] bArr) {
            this.f7236e = bArr;
            this.f7237f = i10 + i9;
            this.f7239h = i9;
            this.f7240i = i9;
        }

        public final long A() throws C0531z {
            int i9 = this.f7239h;
            if (this.f7237f - i9 < 8) {
                throw C0531z.e();
            }
            this.f7239h = i9 + 8;
            byte[] bArr = this.f7236e;
            return ((((long) bArr[i9 + 7]) & 255) << 56) | (((long) bArr[i9]) & 255) | ((((long) bArr[i9 + 1]) & 255) << 8) | ((((long) bArr[i9 + 2]) & 255) << 16) | ((((long) bArr[i9 + 3]) & 255) << 24) | ((((long) bArr[i9 + 4]) & 255) << 32) | ((((long) bArr[i9 + 5]) & 255) << 40) | ((((long) bArr[i9 + 6]) & 255) << 48);
        }

        public final int B() {
            int i9;
            int i10 = this.f7239h;
            int i11 = this.f7237f;
            if (i11 != i10) {
                int i12 = i10 + 1;
                byte[] bArr = this.f7236e;
                byte b9 = bArr[i10];
                if (b9 >= 0) {
                    this.f7239h = i12;
                    return b9;
                }
                if (i11 - i12 >= 9) {
                    int i13 = i10 + 2;
                    int i14 = (bArr[i12] << 7) ^ b9;
                    if (i14 < 0) {
                        i9 = i14 ^ (-128);
                    } else {
                        int i15 = i10 + 3;
                        int i16 = (bArr[i13] << 14) ^ i14;
                        if (i16 >= 0) {
                            i9 = i16 ^ 16256;
                        } else {
                            int i17 = i10 + 4;
                            int i18 = i16 ^ (bArr[i15] << 21);
                            if (i18 < 0) {
                                i9 = (-2080896) ^ i18;
                            } else {
                                i15 = i10 + 5;
                                byte b10 = bArr[i17];
                                int i19 = (i18 ^ (b10 << 28)) ^ 266354560;
                                if (b10 < 0) {
                                    i17 = i10 + 6;
                                    if (bArr[i15] < 0) {
                                        i15 = i10 + 7;
                                        if (bArr[i17] < 0) {
                                            i17 = i10 + 8;
                                            if (bArr[i15] < 0) {
                                                i15 = i10 + 9;
                                                if (bArr[i17] < 0) {
                                                    int i20 = i10 + 10;
                                                    if (bArr[i15] >= 0) {
                                                        i13 = i20;
                                                        i9 = i19;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i9 = i19;
                                }
                                i9 = i19;
                            }
                            i13 = i17;
                        }
                        i13 = i15;
                    }
                    this.f7239h = i13;
                    return i9;
                }
            }
            return (int) D();
        }

        public final long C() {
            long j;
            long j8;
            long j9;
            long j10;
            int i9 = this.f7239h;
            int i10 = this.f7237f;
            if (i10 != i9) {
                int i11 = i9 + 1;
                byte[] bArr = this.f7236e;
                byte b9 = bArr[i9];
                if (b9 >= 0) {
                    this.f7239h = i11;
                    return b9;
                }
                if (i10 - i11 >= 9) {
                    int i12 = i9 + 2;
                    int i13 = (bArr[i11] << 7) ^ b9;
                    if (i13 < 0) {
                        j = i13 ^ (-128);
                    } else {
                        int i14 = i9 + 3;
                        int i15 = (bArr[i12] << 14) ^ i13;
                        if (i15 >= 0) {
                            j = i15 ^ 16256;
                            i12 = i14;
                        } else {
                            int i16 = i9 + 4;
                            int i17 = i15 ^ (bArr[i14] << 21);
                            if (i17 < 0) {
                                j10 = (-2080896) ^ i17;
                            } else {
                                long j11 = i17;
                                i12 = i9 + 5;
                                long j12 = j11 ^ (((long) bArr[i16]) << 28);
                                if (j12 >= 0) {
                                    j9 = 266354560;
                                } else {
                                    i16 = i9 + 6;
                                    long j13 = j12 ^ (((long) bArr[i12]) << 35);
                                    if (j13 < 0) {
                                        j8 = -34093383808L;
                                    } else {
                                        i12 = i9 + 7;
                                        j12 = j13 ^ (((long) bArr[i16]) << 42);
                                        if (j12 >= 0) {
                                            j9 = 4363953127296L;
                                        } else {
                                            i16 = i9 + 8;
                                            j13 = j12 ^ (((long) bArr[i12]) << 49);
                                            if (j13 < 0) {
                                                j8 = -558586000294016L;
                                            } else {
                                                i12 = i9 + 9;
                                                long j14 = (j13 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                                if (j14 < 0) {
                                                    int i18 = i9 + 10;
                                                    if (bArr[i12] >= 0) {
                                                        i12 = i18;
                                                    }
                                                }
                                                j = j14;
                                            }
                                        }
                                    }
                                    j10 = j8 ^ j13;
                                }
                                j = j9 ^ j12;
                            }
                            i12 = i16;
                            j = j10;
                        }
                    }
                    this.f7239h = i12;
                    return j;
                }
            }
            return D();
        }

        public final long D() throws C0531z {
            long j = 0;
            for (int i9 = 0; i9 < 64; i9 += 7) {
                int i10 = this.f7239h;
                if (i10 == this.f7237f) {
                    throw C0531z.e();
                }
                this.f7239h = i10 + 1;
                byte b9 = this.f7236e[i10];
                j |= ((long) (b9 & 127)) << i9;
                if ((b9 & 128) == 0) {
                    return j;
                }
            }
            throw C0531z.c();
        }

        public final void E() {
            int i9 = this.f7237f + this.f7238g;
            this.f7237f = i9;
            int i10 = i9 - this.f7240i;
            int i11 = this.f7241k;
            if (i10 <= i11) {
                this.f7238g = 0;
                return;
            }
            int i12 = i10 - i11;
            this.f7238g = i12;
            this.f7237f = i9 - i12;
        }

        public final void F(int i9) throws C0531z {
            if (i9 >= 0) {
                int i10 = this.f7237f;
                int i11 = this.f7239h;
                if (i9 <= i10 - i11) {
                    this.f7239h = i11 + i9;
                    return;
                }
            }
            if (i9 >= 0) {
                throw C0531z.e();
            }
            throw C0531z.d();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final void a(int i9) throws C0531z {
            if (this.j != i9) {
                throw new C0531z("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int b() {
            return this.f7239h - this.f7240i;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final boolean c() {
            return this.f7239h == this.f7237f;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final void d(int i9) {
            this.f7241k = i9;
            E();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int e(int i9) {
            if (i9 < 0) {
                throw C0531z.d();
            }
            int iB = b() + i9;
            if (iB < 0) {
                throw new C0531z("Failed to parse the message.");
            }
            int i10 = this.f7241k;
            if (iB > i10) {
                throw C0531z.e();
            }
            this.f7241k = iB;
            E();
            return i10;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final boolean f() {
            return C() != 0;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x002f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:16:0x0031 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x0033  */
        /* JADX WARN: Code duplicated, block: B:20:0x003d  */
        /* JADX WARN: Code duplicated, block: B:22:0x0042  */
        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final AbstractC0513g.f g() throws C0531z {
            byte[] bArrCopyOfRange;
            int iB = B();
            byte[] bArr = this.f7236e;
            if (iB > 0) {
                int i9 = this.f7237f;
                int i10 = this.f7239h;
                if (iB <= i9 - i10) {
                    AbstractC0513g.f fVarH = AbstractC0513g.h(i10, iB, bArr);
                    this.f7239h += iB;
                    return fVarH;
                }
            }
            if (iB == 0) {
                return AbstractC0513g.f7223b;
            }
            if (iB > 0) {
                int i11 = this.f7237f;
                int i12 = this.f7239h;
                if (iB <= i11 - i12) {
                    int i13 = iB + i12;
                    this.f7239h = i13;
                    bArrCopyOfRange = Arrays.copyOfRange(bArr, i12, i13);
                } else {
                    if (iB <= 0) {
                        throw C0531z.e();
                    }
                    if (iB == 0) {
                        throw C0531z.d();
                    }
                    bArrCopyOfRange = C0530y.f7344b;
                }
            } else {
                if (iB <= 0) {
                    throw C0531z.e();
                }
                if (iB == 0) {
                    throw C0531z.d();
                }
                bArrCopyOfRange = C0530y.f7344b;
            }
            AbstractC0513g.f fVar = AbstractC0513g.f7223b;
            return new AbstractC0513g.f(bArrCopyOfRange);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final double h() {
            return Double.longBitsToDouble(A());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int i() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int j() {
            return z();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long k() {
            return A();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final float l() {
            return Float.intBitsToFloat(z());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int m() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long n() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int o() {
            return z();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long p() {
            return A();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int q() {
            int iB = B();
            return (-(iB & 1)) ^ (iB >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long r() {
            long jC = C();
            return (-(jC & 1)) ^ (jC >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final String s() throws C0531z {
            int iB = B();
            if (iB > 0) {
                int i9 = this.f7237f;
                int i10 = this.f7239h;
                if (iB <= i9 - i10) {
                    String str = new String(this.f7236e, i10, iB, C0530y.f7343a);
                    this.f7239h += iB;
                    return str;
                }
            }
            if (iB == 0) {
                return "";
            }
            if (iB < 0) {
                throw C0531z.d();
            }
            throw C0531z.e();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final String t() throws C0531z {
            int iB = B();
            if (iB > 0) {
                int i9 = this.f7237f;
                int i10 = this.f7239h;
                if (iB <= i9 - i10) {
                    String strA = q0.f7302a.a(i10, iB, this.f7236e);
                    this.f7239h += iB;
                    return strA;
                }
            }
            if (iB == 0) {
                return "";
            }
            if (iB <= 0) {
                throw C0531z.d();
            }
            throw C0531z.e();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int u() throws C0531z {
            if (c()) {
                this.j = 0;
                return 0;
            }
            int iB = B();
            this.j = iB;
            if ((iB >>> 3) != 0) {
                return iB;
            }
            throw new C0531z("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int v() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long w() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final boolean x(int i9) throws C0531z {
            int i10 = i9 & 7;
            int i11 = 0;
            if (i10 != 0) {
                if (i10 == 1) {
                    F(8);
                    return true;
                }
                if (i10 == 2) {
                    F(B());
                    return true;
                }
                if (i10 == 3) {
                    y();
                    a(((i9 >>> 3) << 3) | 4);
                    return true;
                }
                if (i10 == 4) {
                    return false;
                }
                if (i10 != 5) {
                    throw C0531z.b();
                }
                F(4);
                return true;
            }
            int i12 = this.f7237f - this.f7239h;
            byte[] bArr = this.f7236e;
            if (i12 >= 10) {
                while (i11 < 10) {
                    int i13 = this.f7239h;
                    this.f7239h = i13 + 1;
                    if (bArr[i13] < 0) {
                        i11++;
                    }
                }
                throw C0531z.c();
            }
            while (i11 < 10) {
                int i14 = this.f7239h;
                if (i14 == this.f7237f) {
                    throw C0531z.e();
                }
                this.f7239h = i14 + 1;
                if (bArr[i14] < 0) {
                    i11++;
                }
            }
            throw C0531z.c();
            return true;
        }

        public final int z() throws C0531z {
            int i9 = this.f7239h;
            if (this.f7237f - i9 < 4) {
                throw C0531z.e();
            }
            this.f7239h = i9 + 4;
            byte[] bArr = this.f7236e;
            return ((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h$b */
    /* JADX INFO: compiled from: CodedInputStream.java */
    public static final class b extends AbstractC0514h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final FileInputStream f7242e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f7243f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7244g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7245h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7246i;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7247k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7248l = Integer.MAX_VALUE;

        public b(FileInputStream fileInputStream) {
            Charset charset = C0530y.f7343a;
            this.f7242e = fileInputStream;
            this.f7243f = new byte[4096];
            this.f7244g = 0;
            this.f7246i = 0;
            this.f7247k = 0;
        }

        public final byte[] A(int i9) throws IOException {
            if (i9 == 0) {
                return C0530y.f7344b;
            }
            if (i9 < 0) {
                throw C0531z.d();
            }
            int i10 = this.f7247k;
            int i11 = this.f7246i;
            int i12 = i10 + i11 + i9;
            if (i12 - this.f7234c > 0) {
                throw new C0531z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            int i13 = this.f7248l;
            if (i12 > i13) {
                J((i13 - i10) - i11);
                throw C0531z.e();
            }
            int i14 = this.f7244g - i11;
            int i15 = i9 - i14;
            FileInputStream fileInputStream = this.f7242e;
            if (i15 >= 4096) {
                try {
                    if (i15 > fileInputStream.available()) {
                        return null;
                    }
                } catch (C0531z e9) {
                    e9.f7345a = true;
                    throw e9;
                }
            }
            byte[] bArr = new byte[i9];
            System.arraycopy(this.f7243f, this.f7246i, bArr, 0, i14);
            this.f7247k += this.f7244g;
            this.f7246i = 0;
            this.f7244g = 0;
            while (i14 < i9) {
                try {
                    int i16 = fileInputStream.read(bArr, i14, i9 - i14);
                    if (i16 == -1) {
                        throw C0531z.e();
                    }
                    this.f7247k += i16;
                    i14 += i16;
                } catch (C0531z e10) {
                    e10.f7345a = true;
                    throw e10;
                }
            }
            return bArr;
        }

        public final ArrayList B(int i9) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i9 > 0) {
                int iMin = Math.min(i9, 4096);
                byte[] bArr = new byte[iMin];
                int i10 = 0;
                while (i10 < iMin) {
                    int i11 = this.f7242e.read(bArr, i10, iMin - i10);
                    if (i11 == -1) {
                        throw C0531z.e();
                    }
                    this.f7247k += i11;
                    i10 += i11;
                }
                i9 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public final int C() throws C0531z {
            int i9 = this.f7246i;
            if (this.f7244g - i9 < 4) {
                I(4);
                i9 = this.f7246i;
            }
            this.f7246i = i9 + 4;
            byte[] bArr = this.f7243f;
            return ((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16);
        }

        public final long D() throws C0531z {
            int i9 = this.f7246i;
            if (this.f7244g - i9 < 8) {
                I(8);
                i9 = this.f7246i;
            }
            this.f7246i = i9 + 8;
            byte[] bArr = this.f7243f;
            return ((((long) bArr[i9 + 7]) & 255) << 56) | (((long) bArr[i9]) & 255) | ((((long) bArr[i9 + 1]) & 255) << 8) | ((((long) bArr[i9 + 2]) & 255) << 16) | ((((long) bArr[i9 + 3]) & 255) << 24) | ((((long) bArr[i9 + 4]) & 255) << 32) | ((((long) bArr[i9 + 5]) & 255) << 40) | ((((long) bArr[i9 + 6]) & 255) << 48);
        }

        public final int E() {
            int i9;
            int i10 = this.f7246i;
            int i11 = this.f7244g;
            if (i11 != i10) {
                int i12 = i10 + 1;
                byte[] bArr = this.f7243f;
                byte b9 = bArr[i10];
                if (b9 >= 0) {
                    this.f7246i = i12;
                    return b9;
                }
                if (i11 - i12 >= 9) {
                    int i13 = i10 + 2;
                    int i14 = (bArr[i12] << 7) ^ b9;
                    if (i14 < 0) {
                        i9 = i14 ^ (-128);
                    } else {
                        int i15 = i10 + 3;
                        int i16 = (bArr[i13] << 14) ^ i14;
                        if (i16 >= 0) {
                            i9 = i16 ^ 16256;
                        } else {
                            int i17 = i10 + 4;
                            int i18 = i16 ^ (bArr[i15] << 21);
                            if (i18 < 0) {
                                i9 = (-2080896) ^ i18;
                            } else {
                                i15 = i10 + 5;
                                byte b10 = bArr[i17];
                                int i19 = (i18 ^ (b10 << 28)) ^ 266354560;
                                if (b10 < 0) {
                                    i17 = i10 + 6;
                                    if (bArr[i15] < 0) {
                                        i15 = i10 + 7;
                                        if (bArr[i17] < 0) {
                                            i17 = i10 + 8;
                                            if (bArr[i15] < 0) {
                                                i15 = i10 + 9;
                                                if (bArr[i17] < 0) {
                                                    int i20 = i10 + 10;
                                                    if (bArr[i15] >= 0) {
                                                        i13 = i20;
                                                        i9 = i19;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i9 = i19;
                                }
                                i9 = i19;
                            }
                            i13 = i17;
                        }
                        i13 = i15;
                    }
                    this.f7246i = i13;
                    return i9;
                }
            }
            return (int) G();
        }

        public final long F() {
            long j;
            long j8;
            long j9;
            long j10;
            int i9 = this.f7246i;
            int i10 = this.f7244g;
            if (i10 != i9) {
                int i11 = i9 + 1;
                byte[] bArr = this.f7243f;
                byte b9 = bArr[i9];
                if (b9 >= 0) {
                    this.f7246i = i11;
                    return b9;
                }
                if (i10 - i11 >= 9) {
                    int i12 = i9 + 2;
                    int i13 = (bArr[i11] << 7) ^ b9;
                    if (i13 < 0) {
                        j = i13 ^ (-128);
                    } else {
                        int i14 = i9 + 3;
                        int i15 = (bArr[i12] << 14) ^ i13;
                        if (i15 >= 0) {
                            j = i15 ^ 16256;
                            i12 = i14;
                        } else {
                            int i16 = i9 + 4;
                            int i17 = i15 ^ (bArr[i14] << 21);
                            if (i17 < 0) {
                                j10 = (-2080896) ^ i17;
                            } else {
                                long j11 = i17;
                                i12 = i9 + 5;
                                long j12 = j11 ^ (((long) bArr[i16]) << 28);
                                if (j12 >= 0) {
                                    j9 = 266354560;
                                } else {
                                    i16 = i9 + 6;
                                    long j13 = j12 ^ (((long) bArr[i12]) << 35);
                                    if (j13 < 0) {
                                        j8 = -34093383808L;
                                    } else {
                                        i12 = i9 + 7;
                                        j12 = j13 ^ (((long) bArr[i16]) << 42);
                                        if (j12 >= 0) {
                                            j9 = 4363953127296L;
                                        } else {
                                            i16 = i9 + 8;
                                            j13 = j12 ^ (((long) bArr[i12]) << 49);
                                            if (j13 < 0) {
                                                j8 = -558586000294016L;
                                            } else {
                                                i12 = i9 + 9;
                                                long j14 = (j13 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                                if (j14 < 0) {
                                                    int i18 = i9 + 10;
                                                    if (bArr[i12] >= 0) {
                                                        i12 = i18;
                                                    }
                                                }
                                                j = j14;
                                            }
                                        }
                                    }
                                    j10 = j8 ^ j13;
                                }
                                j = j9 ^ j12;
                            }
                            i12 = i16;
                            j = j10;
                        }
                    }
                    this.f7246i = i12;
                    return j;
                }
            }
            return G();
        }

        public final long G() throws C0531z {
            long j = 0;
            for (int i9 = 0; i9 < 64; i9 += 7) {
                if (this.f7246i == this.f7244g) {
                    I(1);
                }
                int i10 = this.f7246i;
                this.f7246i = i10 + 1;
                byte b9 = this.f7243f[i10];
                j |= ((long) (b9 & 127)) << i9;
                if ((b9 & 128) == 0) {
                    return j;
                }
            }
            throw C0531z.c();
        }

        public final void H() {
            int i9 = this.f7244g + this.f7245h;
            this.f7244g = i9;
            int i10 = this.f7247k + i9;
            int i11 = this.f7248l;
            if (i10 <= i11) {
                this.f7245h = 0;
                return;
            }
            int i12 = i10 - i11;
            this.f7245h = i12;
            this.f7244g = i9 - i12;
        }

        public final void I(int i9) throws C0531z {
            if (K(i9)) {
                return;
            }
            if (i9 <= (this.f7234c - this.f7247k) - this.f7246i) {
                throw C0531z.e();
            }
            throw new C0531z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }

        public final void J(int i9) throws C0531z {
            int i10 = this.f7244g;
            int i11 = this.f7246i;
            int i12 = i10 - i11;
            if (i9 <= i12 && i9 >= 0) {
                this.f7246i = i11 + i9;
                return;
            }
            FileInputStream fileInputStream = this.f7242e;
            if (i9 < 0) {
                throw C0531z.d();
            }
            int i13 = this.f7247k;
            int i14 = i13 + i11;
            int i15 = i14 + i9;
            int i16 = this.f7248l;
            if (i15 > i16) {
                J((i16 - i13) - i11);
                throw C0531z.e();
            }
            this.f7247k = i14;
            this.f7244g = 0;
            this.f7246i = 0;
            while (i12 < i9) {
                long j = i9 - i12;
                try {
                    try {
                        long jSkip = fileInputStream.skip(j);
                        if (jSkip < 0 || jSkip > j) {
                            throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                        }
                        if (jSkip == 0) {
                            break;
                        } else {
                            i12 += (int) jSkip;
                        }
                    } catch (C0531z e9) {
                        e9.f7345a = true;
                        throw e9;
                    }
                } catch (Throwable th) {
                    this.f7247k += i12;
                    H();
                    throw th;
                }
            }
            this.f7247k += i12;
            H();
            if (i12 >= i9) {
                return;
            }
            int i17 = this.f7244g;
            int i18 = i17 - this.f7246i;
            this.f7246i = i17;
            I(1);
            while (true) {
                int i19 = i9 - i18;
                int i20 = this.f7244g;
                if (i19 <= i20) {
                    this.f7246i = i19;
                    return;
                } else {
                    i18 += i20;
                    this.f7246i = i20;
                    I(1);
                }
            }
        }

        public final boolean K(int i9) throws IOException {
            int i10 = this.f7246i;
            int i11 = i10 + i9;
            int i12 = this.f7244g;
            if (i11 <= i12) {
                throw new IllegalStateException(defpackage.f.b(i9, "refillBuffer() called when ", " bytes were already available in buffer"));
            }
            int i13 = this.f7247k;
            int i14 = this.f7234c;
            if (i9 <= (i14 - i13) - i10 && i13 + i10 + i9 <= this.f7248l) {
                byte[] bArr = this.f7243f;
                if (i10 > 0) {
                    if (i12 > i10) {
                        System.arraycopy(bArr, i10, bArr, 0, i12 - i10);
                    }
                    this.f7247k += i10;
                    this.f7244g -= i10;
                    this.f7246i = 0;
                }
                int i15 = this.f7244g;
                int iMin = Math.min(bArr.length - i15, (i14 - this.f7247k) - i15);
                FileInputStream fileInputStream = this.f7242e;
                try {
                    int i16 = fileInputStream.read(bArr, i15, iMin);
                    if (i16 == 0 || i16 < -1 || i16 > bArr.length) {
                        throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + i16 + "\nThe InputStream implementation is buggy.");
                    }
                    if (i16 > 0) {
                        this.f7244g += i16;
                        H();
                        if (this.f7244g >= i9) {
                            return true;
                        }
                        return K(i9);
                    }
                } catch (C0531z e9) {
                    e9.f7345a = true;
                    throw e9;
                }
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final void a(int i9) throws C0531z {
            if (this.j != i9) {
                throw new C0531z("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int b() {
            return this.f7247k + this.f7246i;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final boolean c() {
            return this.f7246i == this.f7244g && !K(1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final void d(int i9) {
            this.f7248l = i9;
            H();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int e(int i9) throws C0531z {
            if (i9 < 0) {
                throw C0531z.d();
            }
            int i10 = this.f7247k + this.f7246i + i9;
            if (i10 < 0) {
                throw new C0531z("Failed to parse the message.");
            }
            int i11 = this.f7248l;
            if (i10 > i11) {
                throw C0531z.e();
            }
            this.f7248l = i10;
            H();
            return i11;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final boolean f() {
            return F() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final AbstractC0513g.f g() throws IOException {
            int iE = E();
            int i9 = this.f7244g;
            int i10 = this.f7246i;
            int i11 = i9 - i10;
            byte[] bArr = this.f7243f;
            if (iE <= i11 && iE > 0) {
                AbstractC0513g.f fVarH = AbstractC0513g.h(i10, iE, bArr);
                this.f7246i += iE;
                return fVarH;
            }
            if (iE == 0) {
                return AbstractC0513g.f7223b;
            }
            if (iE < 0) {
                throw C0531z.d();
            }
            byte[] bArrA = A(iE);
            if (bArrA != null) {
                return AbstractC0513g.h(0, bArrA.length, bArrA);
            }
            int i12 = this.f7246i;
            int i13 = this.f7244g;
            int length = i13 - i12;
            this.f7247k += i13;
            this.f7246i = 0;
            this.f7244g = 0;
            ArrayList<byte[]> arrayListB = B(iE - length);
            byte[] bArr2 = new byte[iE];
            System.arraycopy(bArr, i12, bArr2, 0, length);
            for (byte[] bArr3 : arrayListB) {
                System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
                length += bArr3.length;
            }
            AbstractC0513g.f fVar = AbstractC0513g.f7223b;
            return new AbstractC0513g.f(bArr2);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final double h() {
            return Double.longBitsToDouble(D());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int i() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int j() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long k() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final float l() {
            return Float.intBitsToFloat(C());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int m() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long n() {
            return F();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int o() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long p() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int q() {
            int iE = E();
            return (-(iE & 1)) ^ (iE >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long r() {
            long jF = F();
            return (-(jF & 1)) ^ (jF >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final String s() throws C0531z {
            int iE = E();
            byte[] bArr = this.f7243f;
            if (iE > 0) {
                int i9 = this.f7244g;
                int i10 = this.f7246i;
                if (iE <= i9 - i10) {
                    String str = new String(bArr, i10, iE, C0530y.f7343a);
                    this.f7246i += iE;
                    return str;
                }
            }
            if (iE == 0) {
                return "";
            }
            if (iE < 0) {
                throw C0531z.d();
            }
            if (iE > this.f7244g) {
                return new String(z(iE), C0530y.f7343a);
            }
            I(iE);
            String str2 = new String(bArr, this.f7246i, iE, C0530y.f7343a);
            this.f7246i += iE;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final String t() throws IOException {
            int iE = E();
            int i9 = this.f7246i;
            int i10 = this.f7244g;
            int i11 = i10 - i9;
            byte[] bArrZ = this.f7243f;
            if (iE <= i11 && iE > 0) {
                this.f7246i = i9 + iE;
            } else {
                if (iE == 0) {
                    return "";
                }
                if (iE < 0) {
                    throw C0531z.d();
                }
                i9 = 0;
                if (iE <= i10) {
                    I(iE);
                    this.f7246i = iE;
                } else {
                    bArrZ = z(iE);
                }
            }
            return q0.f7302a.a(i9, iE, bArrZ);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int u() throws C0531z {
            if (c()) {
                this.j = 0;
                return 0;
            }
            int iE = E();
            this.j = iE;
            if ((iE >>> 3) != 0) {
                return iE;
            }
            throw new C0531z("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final int v() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final long w() {
            return F();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0514h
        public final boolean x(int i9) throws C0531z {
            int i10 = i9 & 7;
            int i11 = 0;
            if (i10 != 0) {
                if (i10 == 1) {
                    J(8);
                    return true;
                }
                if (i10 == 2) {
                    J(E());
                    return true;
                }
                if (i10 == 3) {
                    y();
                    a(((i9 >>> 3) << 3) | 4);
                    return true;
                }
                if (i10 == 4) {
                    return false;
                }
                if (i10 != 5) {
                    throw C0531z.b();
                }
                J(4);
                return true;
            }
            int i12 = this.f7244g - this.f7246i;
            byte[] bArr = this.f7243f;
            if (i12 >= 10) {
                while (i11 < 10) {
                    int i13 = this.f7246i;
                    this.f7246i = i13 + 1;
                    if (bArr[i13] < 0) {
                        i11++;
                    }
                }
                throw C0531z.c();
            }
            while (i11 < 10) {
                if (this.f7246i == this.f7244g) {
                    I(1);
                }
                int i14 = this.f7246i;
                this.f7246i = i14 + 1;
                if (bArr[i14] < 0) {
                    i11++;
                }
            }
            throw C0531z.c();
            return true;
        }

        public final byte[] z(int i9) throws IOException {
            byte[] bArrA = A(i9);
            if (bArrA != null) {
                return bArrA;
            }
            int i10 = this.f7246i;
            int i11 = this.f7244g;
            int length = i11 - i10;
            this.f7247k += i11;
            this.f7246i = 0;
            this.f7244g = 0;
            ArrayList<byte[]> arrayListB = B(i9 - length);
            byte[] bArr = new byte[i9];
            System.arraycopy(this.f7243f, i10, bArr, 0, length);
            for (byte[] bArr2 : arrayListB) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }
    }

    public abstract void a(int i9);

    public abstract int b();

    public abstract boolean c();

    public abstract void d(int i9);

    public abstract int e(int i9);

    public abstract boolean f();

    public abstract AbstractC0513g.f g();

    public abstract double h();

    public abstract int i();

    public abstract int j();

    public abstract long k();

    public abstract float l();

    public abstract int m();

    public abstract long n();

    public abstract int o();

    public abstract long p();

    public abstract int q();

    public abstract long r();

    public abstract String s();

    public abstract String t();

    public abstract int u();

    public abstract int v();

    public abstract long w();

    public abstract boolean x(int i9);

    public final void y() throws C0531z {
        boolean zX;
        do {
            int iU = u();
            if (iU == 0) {
                return;
            }
            int i9 = this.f7232a;
            if (i9 >= this.f7233b) {
                throw new C0531z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.f7232a = i9 + 1;
            zX = x(iU);
            this.f7232a--;
        } while (zX);
    }
}
