package S;

import B0.T;
import androidx.datastore.preferences.protobuf.C0524s;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.k;
import p056h5.C0598e;

/* JADX INFO: compiled from: Pools.kt */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4090b;

    public c(BufferedInputStream bufferedInputStream) {
        this.f4090b = 0;
        this.f4089a = bufferedInputStream;
    }

    public int a(int i9, C0598e c0598e) throws IOException {
        int i10 = this.f4090b;
        BufferedInputStream bufferedInputStream = (BufferedInputStream) this.f4089a;
        p092m3.c cVarS = A1.b.s(bufferedInputStream, i10);
        A1.b.f(bufferedInputStream);
        int iF = A1.b.f(bufferedInputStream);
        int i11 = bufferedInputStream.read();
        p092m3.d dVarA = p092m3.d.a(i11);
        if (dVarA == null) {
            throw new IllegalStateException(W5.e.i(i11, "accept primitive array failed, lost type def of typeId: "));
        }
        int i12 = this.f4090b;
        int i13 = dVarA.f20341b;
        if (i13 != 0) {
            i12 = i13;
        }
        int i14 = i12 * iF;
        A1.b.L(bufferedInputStream, new byte[i14], i14);
        try {
            p092m3.b bVar = p092m3.b.this;
            bVar.f20332e.write(i9);
            bVar.f20332e.write(cVarS.f20335a);
            ByteArrayOutputStream byteArrayOutputStream = bVar.f20332e;
            A1.b.F(byteArrayOutputStream, iF);
            byteArrayOutputStream.write(i11);
            p092m3.d dVarA2 = p092m3.d.a(i11);
            if (dVarA2 != p092m3.d.f20336c && dVarA2 != p092m3.d.f20337d) {
                p092m3.d dVarA3 = p092m3.d.a(i11);
                int i15 = bVar.f20331d;
                int i16 = dVarA3.f20341b;
                if (i16 != 0) {
                    i15 = i16;
                }
                A1.b.G(byteArrayOutputStream, iF * i15);
            }
            return this.f4090b + 9 + i14;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public void b(int i9, int i10, long j, T t) throws IOException {
        int iA;
        int i11;
        int i12;
        Object objS;
        long j8 = j;
        C0598e c0598eC = t.c(i9, i10, j8);
        BufferedInputStream bufferedInputStream = (BufferedInputStream) this.f4089a;
        if (c0598eC == null) {
            A1.b.E(bufferedInputStream, j8);
            return;
        }
        while (j8 > 0) {
            int i13 = bufferedInputStream.read();
            long j9 = j8 - 1;
            if (i13 == 144) {
                j9 = j9;
                c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                iA = this.f4090b;
            } else if (i13 != 195) {
                if (i13 == 254) {
                    int iF = A1.b.f(bufferedInputStream);
                    p092m3.c cVarS = A1.b.s(bufferedInputStream, this.f4090b);
                    p092m3.b bVar = p092m3.b.this;
                    try {
                        bVar.f20332e.write(254);
                        ByteArrayOutputStream byteArrayOutputStream = bVar.f20332e;
                        A1.b.F(byteArrayOutputStream, iF);
                        byteArrayOutputStream.write(cVarS.f20335a);
                        i11 = this.f4090b;
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                } else if (i13 != 255) {
                    switch (i13) {
                        case 1:
                            j9 = j9;
                            c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                            A1.b.E(bufferedInputStream, this.f4090b);
                            iA = this.f4090b << 1;
                            break;
                        case 2:
                            p092m3.c cVarS2 = A1.b.s(bufferedInputStream, this.f4090b);
                            A1.b.f(bufferedInputStream);
                            A1.b.f(bufferedInputStream);
                            p092m3.b bVar2 = p092m3.b.this;
                            try {
                                bVar2.f20332e.write(2);
                                bVar2.f20332e.write(cVarS2.f20335a);
                                i12 = this.f4090b;
                                iA = i12 + 8;
                            } catch (Throwable th2) {
                                throw new RuntimeException(th2);
                            }
                            break;
                        case 3:
                            p092m3.c cVarS3 = A1.b.s(bufferedInputStream, this.f4090b);
                            A1.b.f(bufferedInputStream);
                            A1.b.f(bufferedInputStream);
                            p092m3.b bVar3 = p092m3.b.this;
                            try {
                                bVar3.f20332e.write(3);
                                bVar3.f20332e.write(cVarS3.f20335a);
                                i12 = this.f4090b;
                                iA = i12 + 8;
                            } catch (Throwable th3) {
                                throw new RuntimeException(th3);
                            }
                            break;
                        case 4:
                            p092m3.c cVarS4 = A1.b.s(bufferedInputStream, this.f4090b);
                            A1.b.f(bufferedInputStream);
                            p092m3.b bVar4 = p092m3.b.this;
                            try {
                                bVar4.f20332e.write(4);
                                bVar4.f20332e.write(cVarS4.f20335a);
                                i11 = this.f4090b;
                            } catch (Throwable th4) {
                                throw new RuntimeException(th4);
                            }
                            break;
                        case 5:
                            j9 = j9;
                            c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                            iA = this.f4090b;
                            break;
                        case 6:
                            p092m3.c cVarS5 = A1.b.s(bufferedInputStream, this.f4090b);
                            A1.b.f(bufferedInputStream);
                            p092m3.b bVar5 = p092m3.b.this;
                            try {
                                bVar5.f20332e.write(6);
                                bVar5.f20332e.write(cVarS5.f20335a);
                                i11 = this.f4090b;
                            } catch (Throwable th5) {
                                throw new RuntimeException(th5);
                            }
                            break;
                        case 7:
                            j9 = j9;
                            c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                            iA = this.f4090b;
                            break;
                        case 8:
                            p092m3.c cVarS6 = A1.b.s(bufferedInputStream, this.f4090b);
                            A1.b.f(bufferedInputStream);
                            A1.b.f(bufferedInputStream);
                            p092m3.b bVar6 = p092m3.b.this;
                            try {
                                bVar6.f20332e.write(8);
                                bVar6.f20332e.write(cVarS6.f20335a);
                                i12 = this.f4090b;
                                iA = i12 + 8;
                            } catch (Throwable th6) {
                                throw new RuntimeException(th6);
                            }
                            break;
                        default:
                            switch (i13) {
                                case 32:
                                    p092m3.c cVarS7 = A1.b.s(bufferedInputStream, this.f4090b);
                                    A1.b.f(bufferedInputStream);
                                    p092m3.c cVarS8 = A1.b.s(bufferedInputStream, this.f4090b);
                                    p092m3.c cVarS9 = A1.b.s(bufferedInputStream, this.f4090b);
                                    A1.b.E(bufferedInputStream, this.f4090b << 2);
                                    int iF2 = A1.b.f(bufferedInputStream);
                                    int i14 = this.f4090b * 7;
                                    short sB0 = A1.b.B0(bufferedInputStream);
                                    int i15 = i14 + 10;
                                    for (int i16 = 0; i16 < sB0; i16++) {
                                        A1.b.E(bufferedInputStream, 2L);
                                        int i17 = bufferedInputStream.read();
                                        p092m3.d dVarA = p092m3.d.a(i17);
                                        if (dVarA == null) {
                                            throw new IllegalStateException(W5.e.i(i17, "failure to skip type, cannot find type def of typeid: "));
                                        }
                                        int i18 = this.f4090b;
                                        int i19 = dVarA.f20341b;
                                        if (i19 != 0) {
                                            i18 = i19;
                                        }
                                        A1.b.E(bufferedInputStream, i18);
                                        i15 = i18 + 3 + i15;
                                    }
                                    int iB0 = A1.b.B0(bufferedInputStream);
                                    p092m3.a[] aVarArr = new p092m3.a[iB0];
                                    int i20 = i15 + 2;
                                    int i21 = 0;
                                    while (i21 < iB0) {
                                        p092m3.c cVarS10 = A1.b.s(bufferedInputStream, this.f4090b);
                                        int i22 = bufferedInputStream.read();
                                        p092m3.d dVarA2 = p092m3.d.a(i22);
                                        if (dVarA2 == null) {
                                            throw new IllegalStateException(W5.e.i(i22, "accept class failed, lost type def of typeId: "));
                                        }
                                        long j10 = j9;
                                        int i23 = this.f4090b;
                                        switch (dVarA2.ordinal()) {
                                            case 0:
                                                objS = A1.b.s(bufferedInputStream, i23);
                                                break;
                                            case 1:
                                                objS = Boolean.valueOf(bufferedInputStream.read() != 0);
                                                break;
                                            case 2:
                                                objS = Character.valueOf((char) A1.b.B0(bufferedInputStream));
                                                break;
                                            case 3:
                                                objS = Float.valueOf(Float.intBitsToFloat(A1.b.f(bufferedInputStream)));
                                                break;
                                            case 4:
                                                objS = Double.valueOf(Double.longBitsToDouble(A1.b.l0(bufferedInputStream)));
                                                break;
                                            case 5:
                                                objS = Byte.valueOf((byte) bufferedInputStream.read());
                                                break;
                                            case 6:
                                                objS = Short.valueOf(A1.b.B0(bufferedInputStream));
                                                break;
                                            case 7:
                                                objS = Integer.valueOf(A1.b.f(bufferedInputStream));
                                                break;
                                            case 8:
                                                objS = Long.valueOf(A1.b.l0(bufferedInputStream));
                                                break;
                                            default:
                                                objS = null;
                                                break;
                                        }
                                        aVarArr[i21] = new p092m3.a(i22, cVarS10, objS);
                                        int i24 = this.f4090b;
                                        int i25 = i24 + 1;
                                        int i26 = dVarA2.f20341b;
                                        if (i26 != 0) {
                                            i24 = i26;
                                        }
                                        i20 += i25 + i24;
                                        i21++;
                                        j9 = j10;
                                    }
                                    j9 = j9;
                                    int iB1 = A1.b.B0(bufferedInputStream);
                                    p092m3.a[] aVarArr2 = new p092m3.a[iB1];
                                    int i27 = i20 + 2;
                                    int i28 = 0;
                                    while (i28 < iB1) {
                                        p092m3.a[] aVarArr3 = aVarArr2;
                                        aVarArr3[i28] = new p092m3.a(bufferedInputStream.read(), A1.b.s(bufferedInputStream, this.f4090b), null);
                                        i27 += this.f4090b + 1;
                                        i28++;
                                        aVarArr2 = aVarArr3;
                                    }
                                    p092m3.a[] aVarArr4 = aVarArr2;
                                    p092m3.b bVar7 = p092m3.b.this;
                                    try {
                                        bVar7.f20332e.write(32);
                                        ByteArrayOutputStream byteArrayOutputStream2 = bVar7.f20332e;
                                        byteArrayOutputStream2.write(cVarS7.f20335a);
                                        byteArrayOutputStream2.write(cVarS8.f20335a);
                                        byteArrayOutputStream2.write(cVarS9.f20335a);
                                        A1.b.G(byteArrayOutputStream2, bVar7.f20331d << 1);
                                        A1.b.r0(byteArrayOutputStream2, iF2);
                                        A1.b.r0(byteArrayOutputStream2, 0);
                                        A1.b.r0(byteArrayOutputStream2, iB0);
                                        for (int i29 = 0; i29 < iB0; i29++) {
                                            p092m3.a aVar = aVarArr[i29];
                                            byteArrayOutputStream2.write(aVar.f20328b.f20335a);
                                            byteArrayOutputStream2.write(aVar.f20327a);
                                            A1.b.H(byteArrayOutputStream2, aVar.f20329c);
                                        }
                                        A1.b.r0(byteArrayOutputStream2, iB1);
                                        for (int i30 = 0; i30 < iB1; i30++) {
                                            p092m3.a aVar2 = aVarArr4[i30];
                                            byteArrayOutputStream2.write(aVar2.f20328b.f20335a);
                                            byteArrayOutputStream2.write(aVar2.f20327a);
                                        }
                                        iA = i27;
                                        continue;
                                    } catch (Throwable th7) {
                                        throw new RuntimeException(th7);
                                    }
                                    break;
                                case 33:
                                    p092m3.c cVarS11 = A1.b.s(bufferedInputStream, this.f4090b);
                                    A1.b.f(bufferedInputStream);
                                    p092m3.c cVarS12 = A1.b.s(bufferedInputStream, this.f4090b);
                                    int iF3 = A1.b.f(bufferedInputStream);
                                    byte[] bArr = new byte[iF3];
                                    A1.b.L(bufferedInputStream, bArr, iF3);
                                    p092m3.b bVar8 = p092m3.b.this;
                                    try {
                                        bVar8.f20332e.write(33);
                                        ByteArrayOutputStream byteArrayOutputStream3 = bVar8.f20332e;
                                        byteArrayOutputStream3.write(cVarS11.f20335a);
                                        byteArrayOutputStream3.write(cVarS12.f20335a);
                                        A1.b.F(byteArrayOutputStream3, iF3);
                                        byteArrayOutputStream3.write(bArr);
                                        int i31 = this.f4090b;
                                        iA = i31 + 4 + i31 + 4 + iF3;
                                    } catch (Throwable th8) {
                                        throw new RuntimeException(th8);
                                    }
                                    break;
                                case 34:
                                    p092m3.c cVarS13 = A1.b.s(bufferedInputStream, this.f4090b);
                                    A1.b.f(bufferedInputStream);
                                    int iF4 = A1.b.f(bufferedInputStream);
                                    p092m3.c cVarS14 = A1.b.s(bufferedInputStream, this.f4090b);
                                    int i32 = this.f4090b * iF4;
                                    byte[] bArr2 = new byte[i32];
                                    A1.b.L(bufferedInputStream, bArr2, i32);
                                    p092m3.b bVar9 = p092m3.b.this;
                                    try {
                                        bVar9.f20332e.write(34);
                                        ByteArrayOutputStream byteArrayOutputStream4 = bVar9.f20332e;
                                        byteArrayOutputStream4.write(cVarS13.f20335a);
                                        A1.b.F(byteArrayOutputStream4, iF4);
                                        byteArrayOutputStream4.write(cVarS14.f20335a);
                                        byteArrayOutputStream4.write(bArr2, 0, iF4 * bVar9.f20331d);
                                        int i33 = this.f4090b;
                                        iA = i33 + 8 + i33 + i32;
                                    } catch (Throwable th9) {
                                        throw new RuntimeException(th9);
                                    }
                                    break;
                                case 35:
                                    iA = a(i13, c0598eC);
                                    break;
                                default:
                                    switch (i13) {
                                        case 137:
                                            c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                                            iA = this.f4090b;
                                            break;
                                        case 138:
                                            c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                                            iA = this.f4090b;
                                            break;
                                        case 139:
                                            c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                                            iA = this.f4090b;
                                            break;
                                        case 140:
                                            c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                                            iA = this.f4090b;
                                            break;
                                        case 141:
                                            c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                                            iA = this.f4090b;
                                            break;
                                        case 142:
                                            p092m3.c cVarS15 = A1.b.s(bufferedInputStream, this.f4090b);
                                            A1.b.f(bufferedInputStream);
                                            A1.b.f(bufferedInputStream);
                                            p092m3.b bVar10 = p092m3.b.this;
                                            try {
                                                bVar10.f20332e.write(142);
                                                bVar10.f20332e.write(cVarS15.f20335a);
                                                iA = this.f4090b + 8;
                                            } catch (Throwable th10) {
                                                throw new RuntimeException(th10);
                                            }
                                            break;
                                        default:
                                            StringBuilder sbA = C0524s.a(i13, "acceptHeapDumpRecord loop with unknown tag ", " with ");
                                            sbA.append(bufferedInputStream.available());
                                            sbA.append(" bytes possibly remaining");
                                            throw new IllegalArgumentException(sbA.toString());
                                    }
                                    break;
                            }
                            j9 = j9;
                            break;
                    }
                } else {
                    j9 = j9;
                    c0598eC.l(i13, A1.b.s(bufferedInputStream, this.f4090b));
                    iA = this.f4090b;
                }
                iA = i11 + 4;
            } else {
                j9 = j9;
                iA = a(i13, c0598eC);
            }
            j8 = j9 - ((long) iA);
        }
        m3.b.a aVar3 = (m3.b.a) c0598eC;
        p092m3.b bVar11 = p092m3.b.this;
        try {
            bVar11.f20330c.write(aVar3.f20333h);
            BufferedOutputStream bufferedOutputStream = bVar11.f20330c;
            ByteArrayOutputStream byteArrayOutputStream5 = bVar11.f20332e;
            bufferedOutputStream.write(byteArrayOutputStream5.toByteArray());
            byteArrayOutputStream5.reset();
        } catch (Throwable th11) {
            throw new RuntimeException(th11);
        }
    }

    public void c(T t) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedInputStream bufferedInputStream = (BufferedInputStream) this.f4089a;
        int i9 = 0;
        for (int i10 = bufferedInputStream.read(); i10 != 0; i10 = bufferedInputStream.read()) {
            sb.append((char) i10);
            i9++;
            if (i9 > 2048) {
                throw new IOException("Bad string data which causes result to be too long.");
            }
        }
        String string = sb.toString();
        int iF = A1.b.f(bufferedInputStream);
        if (iF <= 0 || iF >= 1073741823) {
            throw new IOException(W5.e.i(iF, "bad idSize: "));
        }
        long jL0 = A1.b.l0(bufferedInputStream);
        this.f4090b = iF;
        T t6 = t;
        t6.e(iF, string, jL0);
        while (true) {
            try {
                int i11 = bufferedInputStream.read();
                int iF2 = A1.b.f(bufferedInputStream);
                long jF = ((long) A1.b.f(bufferedInputStream)) & 4294967295L;
                if (i11 == 1) {
                    p092m3.c cVarS = A1.b.s(bufferedInputStream, this.f4090b);
                    long j = jF - ((long) this.f4090b);
                    byte[] bArr = new byte[(int) j];
                    A1.b.L(bufferedInputStream, bArr, j);
                    t.h(cVarS, new String(bArr, Charset.forName("UTF-8")), iF2, jF);
                } else if (i11 == 2) {
                    t.f(A1.b.f(bufferedInputStream), A1.b.s(bufferedInputStream, this.f4090b), A1.b.f(bufferedInputStream), A1.b.s(bufferedInputStream, this.f4090b), iF2, jF);
                } else if (i11 == 4) {
                    A1.b.s(bufferedInputStream, this.f4090b);
                    A1.b.s(bufferedInputStream, this.f4090b);
                    A1.b.s(bufferedInputStream, this.f4090b);
                    A1.b.s(bufferedInputStream, this.f4090b);
                    A1.b.f(bufferedInputStream);
                    A1.b.f(bufferedInputStream);
                } else if (i11 == 5) {
                    A1.b.f(bufferedInputStream);
                    A1.b.f(bufferedInputStream);
                    int iF3 = A1.b.f(bufferedInputStream);
                    p092m3.c[] cVarArr = new p092m3.c[iF3];
                    for (int i12 = 0; i12 < iF3; i12++) {
                        cVarArr[i12] = A1.b.s(bufferedInputStream, this.f4090b);
                    }
                } else if (i11 == 12 || i11 == 28) {
                    b(i11, iF2, jF, t);
                } else {
                    byte[] bArr2 = new byte[(int) jF];
                    A1.b.L(bufferedInputStream, bArr2, jF);
                    t6.g(jF, bArr2, i11, iF2);
                }
                t6 = t;
            } catch (EOFException unused) {
                t.d();
                return;
            }
        }
    }

    public Object d() {
        int i9 = this.f4090b;
        if (i9 <= 0) {
            return null;
        }
        int i10 = i9 - 1;
        Object[] objArr = (Object[]) this.f4089a;
        Object obj = objArr[i10];
        k.c(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i10] = null;
        this.f4090b--;
        return obj;
    }

    public void e(p197z.b bVar) {
        int i9 = this.f4090b;
        Object[] objArr = (Object[]) this.f4089a;
        if (i9 < objArr.length) {
            objArr[i9] = bVar;
            this.f4090b = i9 + 1;
        }
    }

    public boolean f(Object instance) {
        Object[] objArr;
        boolean z8;
        k.e(instance, "instance");
        int i9 = this.f4090b;
        int i10 = 0;
        while (true) {
            objArr = (Object[]) this.f4089a;
            if (i10 >= i9) {
                z8 = false;
                break;
            }
            if (objArr[i10] == instance) {
                z8 = true;
                break;
            }
            i10++;
        }
        if (z8) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i11 = this.f4090b;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = instance;
        this.f4090b = i11 + 1;
        return true;
    }

    public c(int i9) {
        if (i9 > 0) {
            this.f4089a = new Object[i9];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public c() {
        this.f4089a = new Object[256];
    }
}
