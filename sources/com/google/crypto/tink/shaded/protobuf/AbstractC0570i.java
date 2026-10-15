package com.google.crypto.tink.shaded.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0570i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14092c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14093d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0571j f14094e;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.i$a */
    /* JADX INFO: compiled from: CodedInputStream.java */
    public static final class a extends AbstractC0570i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f14095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14096g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14097h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14098i;
        public final int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f14099k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f14100l = Integer.MAX_VALUE;

        public a(boolean z8, int i9, int i10, byte[] bArr) {
            this.f14095f = bArr;
            this.f14096g = i10 + i9;
            this.f14098i = i9;
            this.j = i9;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final boolean A(int i9) throws C0586z {
            int i10 = i9 & 7;
            int i11 = 0;
            if (i10 != 0) {
                if (i10 == 1) {
                    I(8);
                    return true;
                }
                if (i10 == 2) {
                    I(E());
                    return true;
                }
                if (i10 == 3) {
                    B();
                    a(((i9 >>> 3) << 3) | 4);
                    return true;
                }
                if (i10 == 4) {
                    if (this.f14091b == 0) {
                        a(0);
                    }
                    return false;
                }
                if (i10 != 5) {
                    throw C0586z.c();
                }
                I(4);
                return true;
            }
            int i12 = this.f14096g - this.f14098i;
            byte[] bArr = this.f14095f;
            if (i12 >= 10) {
                while (i11 < 10) {
                    int i13 = this.f14098i;
                    this.f14098i = i13 + 1;
                    if (bArr[i13] < 0) {
                        i11++;
                    }
                }
                throw C0586z.d();
            }
            while (i11 < 10) {
                int i14 = this.f14098i;
                if (i14 == this.f14096g) {
                    throw C0586z.g();
                }
                this.f14098i = i14 + 1;
                if (bArr[i14] < 0) {
                    i11++;
                }
            }
            throw C0586z.d();
            return true;
        }

        public final int C() throws C0586z {
            int i9 = this.f14098i;
            if (this.f14096g - i9 < 4) {
                throw C0586z.g();
            }
            this.f14098i = i9 + 4;
            byte[] bArr = this.f14095f;
            return ((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16);
        }

        public final long D() throws C0586z {
            int i9 = this.f14098i;
            if (this.f14096g - i9 < 8) {
                throw C0586z.g();
            }
            this.f14098i = i9 + 8;
            byte[] bArr = this.f14095f;
            return ((((long) bArr[i9 + 7]) & 255) << 56) | (((long) bArr[i9]) & 255) | ((((long) bArr[i9 + 1]) & 255) << 8) | ((((long) bArr[i9 + 2]) & 255) << 16) | ((((long) bArr[i9 + 3]) & 255) << 24) | ((((long) bArr[i9 + 4]) & 255) << 32) | ((((long) bArr[i9 + 5]) & 255) << 40) | ((((long) bArr[i9 + 6]) & 255) << 48);
        }

        public final int E() {
            int i9;
            int i10 = this.f14098i;
            int i11 = this.f14096g;
            if (i11 != i10) {
                int i12 = i10 + 1;
                byte[] bArr = this.f14095f;
                byte b9 = bArr[i10];
                if (b9 >= 0) {
                    this.f14098i = i12;
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
                    this.f14098i = i13;
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
            int i9 = this.f14098i;
            int i10 = this.f14096g;
            if (i10 != i9) {
                int i11 = i9 + 1;
                byte[] bArr = this.f14095f;
                byte b9 = bArr[i9];
                if (b9 >= 0) {
                    this.f14098i = i11;
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
                    this.f14098i = i12;
                    return j;
                }
            }
            return G();
        }

        public final long G() throws C0586z {
            long j = 0;
            for (int i9 = 0; i9 < 64; i9 += 7) {
                int i10 = this.f14098i;
                if (i10 == this.f14096g) {
                    throw C0586z.g();
                }
                this.f14098i = i10 + 1;
                byte b9 = this.f14095f[i10];
                j |= ((long) (b9 & 127)) << i9;
                if ((b9 & 128) == 0) {
                    return j;
                }
            }
            throw C0586z.d();
        }

        public final void H() {
            int i9 = this.f14096g + this.f14097h;
            this.f14096g = i9;
            int i10 = i9 - this.j;
            int i11 = this.f14100l;
            if (i10 <= i11) {
                this.f14097h = 0;
                return;
            }
            int i12 = i10 - i11;
            this.f14097h = i12;
            this.f14096g = i9 - i12;
        }

        public final void I(int i9) throws C0586z {
            if (i9 >= 0) {
                int i10 = this.f14096g;
                int i11 = this.f14098i;
                if (i9 <= i10 - i11) {
                    this.f14098i = i11 + i9;
                    return;
                }
            }
            if (i9 >= 0) {
                throw C0586z.g();
            }
            throw C0586z.e();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final void a(int i9) throws C0586z {
            if (this.f14099k != i9) {
                throw new C0586z("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int d() {
            return this.f14098i - this.j;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final boolean e() {
            return this.f14098i == this.f14096g;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final void g(int i9) {
            this.f14100l = i9;
            H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int h(int i9) throws C0586z {
            if (i9 < 0) {
                throw C0586z.e();
            }
            int iD = d() + i9;
            if (iD < 0) {
                throw new C0586z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
            }
            int i10 = this.f14100l;
            if (iD > i10) {
                throw C0586z.g();
            }
            this.f14100l = iD;
            H();
            return i10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final boolean i() {
            return F() != 0;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x002f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:16:0x0031 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x0033  */
        /* JADX WARN: Code duplicated, block: B:20:0x003d  */
        /* JADX WARN: Code duplicated, block: B:22:0x0042  */
        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final AbstractC0569h.f j() throws C0586z {
            byte[] bArrCopyOfRange;
            int iE = E();
            byte[] bArr = this.f14095f;
            if (iE > 0) {
                int i9 = this.f14096g;
                int i10 = this.f14098i;
                if (iE <= i9 - i10) {
                    AbstractC0569h.f fVarH = AbstractC0569h.h(i10, iE, bArr);
                    this.f14098i += iE;
                    return fVarH;
                }
            }
            if (iE == 0) {
                return AbstractC0569h.f14069b;
            }
            if (iE > 0) {
                int i11 = this.f14096g;
                int i12 = this.f14098i;
                if (iE <= i11 - i12) {
                    int i13 = iE + i12;
                    this.f14098i = i13;
                    bArrCopyOfRange = Arrays.copyOfRange(bArr, i12, i13);
                } else {
                    if (iE <= 0) {
                        throw C0586z.g();
                    }
                    if (iE == 0) {
                        throw C0586z.e();
                    }
                    bArrCopyOfRange = C0585y.f14184b;
                }
            } else {
                if (iE <= 0) {
                    throw C0586z.g();
                }
                if (iE == 0) {
                    throw C0586z.e();
                }
                bArrCopyOfRange = C0585y.f14184b;
            }
            AbstractC0569h.f fVar = AbstractC0569h.f14069b;
            return new AbstractC0569h.f(bArrCopyOfRange);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final double k() {
            return Double.longBitsToDouble(D());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int l() {
            return E();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int m() {
            return C();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long n() {
            return D();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final float o() {
            return Float.intBitsToFloat(C());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int p() {
            return E();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long q() {
            return F();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int r() {
            return C();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long s() {
            return D();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int t() {
            return AbstractC0570i.b(E());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long u() {
            return AbstractC0570i.c(F());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final String v() throws C0586z {
            int iE = E();
            if (iE > 0) {
                int i9 = this.f14096g;
                int i10 = this.f14098i;
                if (iE <= i9 - i10) {
                    String str = new String(this.f14095f, i10, iE, C0585y.f14183a);
                    this.f14098i += iE;
                    return str;
                }
            }
            if (iE == 0) {
                return "";
            }
            if (iE < 0) {
                throw C0586z.e();
            }
            throw C0586z.g();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final String w() throws C0586z {
            int iE = E();
            if (iE > 0) {
                int i9 = this.f14096g;
                int i10 = this.f14098i;
                if (iE <= i9 - i10) {
                    String strA = o0.f14142a.a(i10, iE, this.f14095f);
                    this.f14098i += iE;
                    return strA;
                }
            }
            if (iE == 0) {
                return "";
            }
            if (iE <= 0) {
                throw C0586z.e();
            }
            throw C0586z.g();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int x() throws C0586z {
            if (e()) {
                this.f14099k = 0;
                return 0;
            }
            int iE = E();
            this.f14099k = iE;
            if ((iE >>> 3) != 0) {
                return iE;
            }
            throw C0586z.a();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int y() {
            return E();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long z() {
            return F();
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.i$b */
    /* JADX INFO: compiled from: CodedInputStream.java */
    public static final class b extends AbstractC0570i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ByteArrayInputStream f14101f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f14102g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14103h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14104i;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f14105k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f14106l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f14107m = Integer.MAX_VALUE;

        public b(ByteArrayInputStream byteArrayInputStream) {
            Charset charset = C0585y.f14183a;
            this.f14101f = byteArrayInputStream;
            this.f14102g = new byte[4096];
            this.f14103h = 0;
            this.j = 0;
            this.f14106l = 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final boolean A(int i9) throws C0586z {
            int i10 = i9 & 7;
            int i11 = 0;
            if (i10 != 0) {
                if (i10 == 1) {
                    M(8);
                    return true;
                }
                if (i10 == 2) {
                    M(H());
                    return true;
                }
                if (i10 == 3) {
                    B();
                    a(((i9 >>> 3) << 3) | 4);
                    return true;
                }
                if (i10 == 4) {
                    if (this.f14091b == 0) {
                        a(0);
                    }
                    return false;
                }
                if (i10 != 5) {
                    throw C0586z.c();
                }
                M(4);
                return true;
            }
            int i12 = this.f14103h - this.j;
            byte[] bArr = this.f14102g;
            if (i12 >= 10) {
                while (i11 < 10) {
                    int i13 = this.j;
                    this.j = i13 + 1;
                    if (bArr[i13] < 0) {
                        i11++;
                    }
                }
                throw C0586z.d();
            }
            while (i11 < 10) {
                if (this.j == this.f14103h) {
                    L(1);
                }
                int i14 = this.j;
                this.j = i14 + 1;
                if (bArr[i14] < 0) {
                    i11++;
                }
            }
            throw C0586z.d();
            return true;
        }

        public final byte[] C(int i9) throws IOException {
            byte[] bArrD = D(i9);
            if (bArrD != null) {
                return bArrD;
            }
            int i10 = this.j;
            int i11 = this.f14103h;
            int length = i11 - i10;
            this.f14106l += i11;
            this.j = 0;
            this.f14103h = 0;
            ArrayList<byte[]> arrayListE = E(i9 - length);
            byte[] bArr = new byte[i9];
            System.arraycopy(this.f14102g, i10, bArr, 0, length);
            for (byte[] bArr2 : arrayListE) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] D(int i9) throws IOException {
            if (i9 == 0) {
                return C0585y.f14184b;
            }
            if (i9 < 0) {
                throw C0586z.e();
            }
            int i10 = this.f14106l;
            int i11 = this.j;
            int i12 = i10 + i11 + i9;
            if (i12 - this.f14093d > 0) {
                throw new C0586z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
            }
            int i13 = this.f14107m;
            if (i12 > i13) {
                M((i13 - i10) - i11);
                throw C0586z.g();
            }
            int i14 = this.f14103h - i11;
            int i15 = i9 - i14;
            ByteArrayInputStream byteArrayInputStream = this.f14101f;
            if (i15 >= 4096) {
                try {
                    if (i15 > byteArrayInputStream.available()) {
                        return null;
                    }
                } catch (C0586z e9) {
                    e9.f14185a = true;
                    throw e9;
                }
            }
            byte[] bArr = new byte[i9];
            System.arraycopy(this.f14102g, this.j, bArr, 0, i14);
            this.f14106l += this.f14103h;
            this.j = 0;
            this.f14103h = 0;
            while (i14 < i9) {
                try {
                    int i16 = byteArrayInputStream.read(bArr, i14, i9 - i14);
                    if (i16 == -1) {
                        throw C0586z.g();
                    }
                    this.f14106l += i16;
                    i14 += i16;
                } catch (C0586z e10) {
                    e10.f14185a = true;
                    throw e10;
                }
            }
            return bArr;
        }

        public final ArrayList E(int i9) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i9 > 0) {
                int iMin = Math.min(i9, 4096);
                byte[] bArr = new byte[iMin];
                int i10 = 0;
                while (i10 < iMin) {
                    int i11 = this.f14101f.read(bArr, i10, iMin - i10);
                    if (i11 == -1) {
                        throw C0586z.g();
                    }
                    this.f14106l += i11;
                    i10 += i11;
                }
                i9 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public final int F() throws C0586z {
            int i9 = this.j;
            if (this.f14103h - i9 < 4) {
                L(4);
                i9 = this.j;
            }
            this.j = i9 + 4;
            byte[] bArr = this.f14102g;
            return ((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16);
        }

        public final long G() throws C0586z {
            int i9 = this.j;
            if (this.f14103h - i9 < 8) {
                L(8);
                i9 = this.j;
            }
            this.j = i9 + 8;
            byte[] bArr = this.f14102g;
            return ((((long) bArr[i9 + 7]) & 255) << 56) | (((long) bArr[i9]) & 255) | ((((long) bArr[i9 + 1]) & 255) << 8) | ((((long) bArr[i9 + 2]) & 255) << 16) | ((((long) bArr[i9 + 3]) & 255) << 24) | ((((long) bArr[i9 + 4]) & 255) << 32) | ((((long) bArr[i9 + 5]) & 255) << 40) | ((((long) bArr[i9 + 6]) & 255) << 48);
        }

        public final int H() {
            int i9;
            int i10 = this.j;
            int i11 = this.f14103h;
            if (i11 != i10) {
                int i12 = i10 + 1;
                byte[] bArr = this.f14102g;
                byte b9 = bArr[i10];
                if (b9 >= 0) {
                    this.j = i12;
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
                    this.j = i13;
                    return i9;
                }
            }
            return (int) J();
        }

        public final long I() {
            long j;
            long j8;
            long j9;
            long j10;
            int i9 = this.j;
            int i10 = this.f14103h;
            if (i10 != i9) {
                int i11 = i9 + 1;
                byte[] bArr = this.f14102g;
                byte b9 = bArr[i9];
                if (b9 >= 0) {
                    this.j = i11;
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
                    this.j = i12;
                    return j;
                }
            }
            return J();
        }

        public final long J() throws C0586z {
            long j = 0;
            for (int i9 = 0; i9 < 64; i9 += 7) {
                if (this.j == this.f14103h) {
                    L(1);
                }
                int i10 = this.j;
                this.j = i10 + 1;
                byte b9 = this.f14102g[i10];
                j |= ((long) (b9 & 127)) << i9;
                if ((b9 & 128) == 0) {
                    return j;
                }
            }
            throw C0586z.d();
        }

        public final void K() {
            int i9 = this.f14103h + this.f14104i;
            this.f14103h = i9;
            int i10 = this.f14106l + i9;
            int i11 = this.f14107m;
            if (i10 <= i11) {
                this.f14104i = 0;
                return;
            }
            int i12 = i10 - i11;
            this.f14104i = i12;
            this.f14103h = i9 - i12;
        }

        public final void L(int i9) throws C0586z {
            if (N(i9)) {
                return;
            }
            if (i9 <= (this.f14093d - this.f14106l) - this.j) {
                throw C0586z.g();
            }
            throw new C0586z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }

        public final void M(int i9) throws C0586z {
            int i10 = this.f14103h;
            int i11 = this.j;
            int i12 = i10 - i11;
            if (i9 <= i12 && i9 >= 0) {
                this.j = i11 + i9;
                return;
            }
            ByteArrayInputStream byteArrayInputStream = this.f14101f;
            if (i9 < 0) {
                throw C0586z.e();
            }
            int i13 = this.f14106l;
            int i14 = i13 + i11;
            int i15 = i14 + i9;
            int i16 = this.f14107m;
            if (i15 > i16) {
                M((i16 - i13) - i11);
                throw C0586z.g();
            }
            this.f14106l = i14;
            this.f14103h = 0;
            this.j = 0;
            while (i12 < i9) {
                long j = i9 - i12;
                try {
                    try {
                        long jSkip = byteArrayInputStream.skip(j);
                        if (jSkip < 0 || jSkip > j) {
                            throw new IllegalStateException(byteArrayInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                        }
                        if (jSkip == 0) {
                            break;
                        } else {
                            i12 += (int) jSkip;
                        }
                    } catch (C0586z e9) {
                        e9.f14185a = true;
                        throw e9;
                    }
                } catch (Throwable th) {
                    this.f14106l += i12;
                    K();
                    throw th;
                }
            }
            this.f14106l += i12;
            K();
            if (i12 >= i9) {
                return;
            }
            int i17 = this.f14103h;
            int i18 = i17 - this.j;
            this.j = i17;
            L(1);
            while (true) {
                int i19 = i9 - i18;
                int i20 = this.f14103h;
                if (i19 <= i20) {
                    this.j = i19;
                    return;
                } else {
                    i18 += i20;
                    this.j = i20;
                    L(1);
                }
            }
        }

        public final boolean N(int i9) throws IOException {
            int i10 = this.j;
            int i11 = i10 + i9;
            int i12 = this.f14103h;
            if (i11 <= i12) {
                throw new IllegalStateException(defpackage.f.b(i9, "refillBuffer() called when ", " bytes were already available in buffer"));
            }
            int i13 = this.f14106l;
            int i14 = this.f14093d;
            if (i9 <= (i14 - i13) - i10 && i13 + i10 + i9 <= this.f14107m) {
                byte[] bArr = this.f14102g;
                if (i10 > 0) {
                    if (i12 > i10) {
                        System.arraycopy(bArr, i10, bArr, 0, i12 - i10);
                    }
                    this.f14106l += i10;
                    this.f14103h -= i10;
                    this.j = 0;
                }
                int i15 = this.f14103h;
                int iMin = Math.min(bArr.length - i15, (i14 - this.f14106l) - i15);
                ByteArrayInputStream byteArrayInputStream = this.f14101f;
                try {
                    int i16 = byteArrayInputStream.read(bArr, i15, iMin);
                    if (i16 == 0 || i16 < -1 || i16 > bArr.length) {
                        throw new IllegalStateException(byteArrayInputStream.getClass() + "#read(byte[]) returned invalid result: " + i16 + "\nThe InputStream implementation is buggy.");
                    }
                    if (i16 > 0) {
                        this.f14103h += i16;
                        K();
                        if (this.f14103h >= i9 || N(i9)) {
                            return true;
                        }
                    }
                } catch (C0586z e9) {
                    e9.f14185a = true;
                    throw e9;
                }
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final void a(int i9) throws C0586z {
            if (this.f14105k != i9) {
                throw new C0586z("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int d() {
            return this.f14106l + this.j;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final boolean e() {
            return this.j == this.f14103h && !N(1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final void g(int i9) {
            this.f14107m = i9;
            K();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int h(int i9) throws C0586z {
            if (i9 < 0) {
                throw C0586z.e();
            }
            int i10 = this.f14106l + this.j + i9;
            if (i10 < 0) {
                throw new C0586z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
            }
            int i11 = this.f14107m;
            if (i10 > i11) {
                throw C0586z.g();
            }
            this.f14107m = i10;
            K();
            return i11;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final boolean i() {
            return I() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final AbstractC0569h.f j() throws IOException {
            int iH = H();
            int i9 = this.f14103h;
            int i10 = this.j;
            int i11 = i9 - i10;
            byte[] bArr = this.f14102g;
            if (iH <= i11 && iH > 0) {
                AbstractC0569h.f fVarH = AbstractC0569h.h(i10, iH, bArr);
                this.j += iH;
                return fVarH;
            }
            if (iH == 0) {
                return AbstractC0569h.f14069b;
            }
            if (iH < 0) {
                throw C0586z.e();
            }
            byte[] bArrD = D(iH);
            if (bArrD != null) {
                return AbstractC0569h.h(0, bArrD.length, bArrD);
            }
            int i12 = this.j;
            int i13 = this.f14103h;
            int length = i13 - i12;
            this.f14106l += i13;
            this.j = 0;
            this.f14103h = 0;
            ArrayList<byte[]> arrayListE = E(iH - length);
            byte[] bArr2 = new byte[iH];
            System.arraycopy(bArr, i12, bArr2, 0, length);
            for (byte[] bArr3 : arrayListE) {
                System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
                length += bArr3.length;
            }
            AbstractC0569h.f fVar = AbstractC0569h.f14069b;
            return new AbstractC0569h.f(bArr2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final double k() {
            return Double.longBitsToDouble(G());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int l() {
            return H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int m() {
            return F();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long n() {
            return G();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final float o() {
            return Float.intBitsToFloat(F());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int p() {
            return H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long q() {
            return I();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int r() {
            return F();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long s() {
            return G();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int t() {
            return AbstractC0570i.b(H());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long u() {
            return AbstractC0570i.c(I());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final String v() throws C0586z {
            int iH = H();
            byte[] bArr = this.f14102g;
            if (iH > 0) {
                int i9 = this.f14103h;
                int i10 = this.j;
                if (iH <= i9 - i10) {
                    String str = new String(bArr, i10, iH, C0585y.f14183a);
                    this.j += iH;
                    return str;
                }
            }
            if (iH == 0) {
                return "";
            }
            if (iH < 0) {
                throw C0586z.e();
            }
            if (iH > this.f14103h) {
                return new String(C(iH), C0585y.f14183a);
            }
            L(iH);
            String str2 = new String(bArr, this.j, iH, C0585y.f14183a);
            this.j += iH;
            return str2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final String w() throws IOException {
            int iH = H();
            int i9 = this.j;
            int i10 = this.f14103h;
            int i11 = i10 - i9;
            byte[] bArrC = this.f14102g;
            if (iH <= i11 && iH > 0) {
                this.j = i9 + iH;
            } else {
                if (iH == 0) {
                    return "";
                }
                if (iH < 0) {
                    throw C0586z.e();
                }
                i9 = 0;
                if (iH <= i10) {
                    L(iH);
                    this.j = iH;
                } else {
                    bArrC = C(iH);
                }
            }
            return o0.f14142a.a(i9, iH, bArrC);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int x() throws C0586z {
            if (e()) {
                this.f14105k = 0;
                return 0;
            }
            int iH = H();
            this.f14105k = iH;
            if ((iH >>> 3) != 0) {
                return iH;
            }
            throw C0586z.a();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final int y() {
            return H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0570i
        public final long z() {
            return I();
        }
    }

    public static int b(int i9) {
        return (-(i9 & 1)) ^ (i9 >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static a f(boolean z8, int i9, int i10, byte[] bArr) {
        a aVar = new a(z8, i9, i10, bArr);
        try {
            aVar.h(i10);
            return aVar;
        } catch (C0586z e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public abstract boolean A(int i9);

    public final void B() throws C0586z {
        boolean zA;
        do {
            int iX = x();
            if (iX == 0) {
                return;
            }
            int i9 = this.f14090a;
            int i10 = this.f14091b;
            if (i9 + i10 >= this.f14092c) {
                throw new C0586z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.f14091b = i10 + 1;
            zA = A(iX);
            this.f14091b--;
        } while (zA);
    }

    public abstract void a(int i9);

    public abstract int d();

    public abstract boolean e();

    public abstract void g(int i9);

    public abstract int h(int i9);

    public abstract boolean i();

    public abstract AbstractC0569h.f j();

    public abstract double k();

    public abstract int l();

    public abstract int m();

    public abstract long n();

    public abstract float o();

    public abstract int p();

    public abstract long q();

    public abstract int r();

    public abstract long s();

    public abstract int t();

    public abstract long u();

    public abstract String v();

    public abstract String w();

    public abstract int x();

    public abstract int y();

    public abstract long z();
}
