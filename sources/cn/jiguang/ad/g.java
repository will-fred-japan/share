package cn.jiguang.ad;

import com.alibaba.fastjson.asm.Opcodes;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class g implements Serializable, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f8976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f8977b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f8978f = {0};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f8979g = {1, 42};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final DecimalFormat f8980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f8981i;
    private static final g j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f8982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8984e;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f8980h = decimalFormat;
        f8981i = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        int i9 = 0;
        while (true) {
            byte[] bArr = f8981i;
            if (i9 >= bArr.length) {
                g gVar = new g();
                f8976a = gVar;
                gVar.b(f8978f, 0, 1);
                g gVar2 = new g();
                f8977b = gVar2;
                gVar2.f8982c = new byte[0];
                g gVar3 = new g();
                j = gVar3;
                gVar3.b(f8979g, 0, 1);
                return;
            }
            if (i9 < 65 || i9 > 90) {
                bArr[i9] = (byte) i9;
            } else {
                bArr[i9] = (byte) (i9 + 32);
            }
            i9++;
        }
    }

    private g() {
    }

    private final int a(int i9) {
        if (i9 == 0 && d() == 0) {
            return 0;
        }
        if (i9 < 0 || i9 >= d()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i9 < 7) {
            return ((int) (this.f8983d >>> ((7 - i9) * 8))) & 255;
        }
        int iA = a(6);
        for (int i10 = 6; i10 < i9; i10++) {
            iA += this.f8982c[iA] + 1;
        }
        return iA;
    }

    private final int d() {
        return (int) (this.f8983d & 255);
    }

    public int b() {
        return d();
    }

    public byte[] c() {
        int iB = b();
        if (iB == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.f8982c.length - a(0)];
        int iA = a(0);
        int i9 = 0;
        for (int i10 = 0; i10 < iB; i10++) {
            byte b9 = this.f8982c[iA];
            if (b9 > 63) {
                throw new IllegalStateException("invalid label");
            }
            iA++;
            bArr[i9] = b9;
            i9++;
            int i11 = 0;
            while (i11 < b9) {
                bArr[i9] = f8981i[this.f8982c[iA] & 255];
                i11++;
                i9++;
                iA++;
            }
        }
        return bArr;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        g gVar = (g) obj;
        if (this == gVar) {
            return 0;
        }
        int iB = b();
        int iB2 = gVar.b();
        int i9 = iB > iB2 ? iB2 : iB;
        for (int i10 = 1; i10 <= i9; i10++) {
            int iA = a(iB - i10);
            int iA2 = gVar.a(iB2 - i10);
            byte b9 = this.f8982c[iA];
            byte b10 = gVar.f8982c[iA2];
            for (int i11 = 0; i11 < b9 && i11 < b10; i11++) {
                byte[] bArr = f8981i;
                int i12 = bArr[this.f8982c[(i11 + iA) + 1] & 255] - bArr[gVar.f8982c[(i11 + iA2) + 1] & 255];
                if (i12 != 0) {
                    return i12;
                }
            }
            if (b9 != b10) {
                return b9 - b10;
            }
        }
        return iB - iB2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.f8984e == 0) {
            gVar.hashCode();
        }
        if (this.f8984e == 0) {
            hashCode();
        }
        if (gVar.f8984e == this.f8984e && gVar.b() == b()) {
            return b(gVar.f8982c, gVar.a(0));
        }
        return false;
    }

    public int hashCode() {
        int i9 = this.f8984e;
        if (i9 != 0) {
            return i9;
        }
        int i10 = 0;
        int iA = a(0);
        while (true) {
            byte[] bArr = this.f8982c;
            if (iA >= bArr.length) {
                this.f8984e = i10;
                return i10;
            }
            i10 += (i10 << 3) + f8981i[bArr[iA] & 255];
            iA++;
        }
    }

    public String toString() {
        return a(false);
    }

    public g(b bVar) throws IOException {
        byte[] bArr = new byte[64];
        boolean z8 = false;
        boolean z9 = false;
        while (!z8) {
            int iF = bVar.f();
            int i9 = iF & Opcodes.CHECKCAST;
            if (i9 != 0) {
                if (i9 != 192) {
                    throw new IOException("bad label type");
                }
                int iF2 = bVar.f() + ((iF & (-193)) << 8);
                if (iF2 >= bVar.a() - 2) {
                    throw new IOException("bad compression");
                }
                if (!z9) {
                    bVar.d();
                    z9 = true;
                }
                bVar.b(iF2);
            } else {
                if (d() >= 128) {
                    throw new IOException("too many labels");
                }
                if (iF == 0) {
                    a(f8978f, 0, 1);
                    z8 = true;
                } else {
                    bArr[0] = (byte) iF;
                    bVar.a(bArr, 1, iF);
                    a(bArr, 0, 1);
                }
            }
        }
        if (z9) {
            bVar.e();
        }
    }

    public static g a(g gVar, g gVar2) throws IOException {
        if (gVar.a()) {
            return gVar;
        }
        g gVar3 = new g();
        b(gVar, gVar3);
        gVar3.a(gVar2.f8982c, gVar2.a(0), gVar2.d());
        return gVar3;
    }

    private final void b(int i9) {
        this.f8983d = (this.f8983d & (-256)) | ((long) i9);
    }

    public g(g gVar, int i9) {
        int iB = gVar.b();
        if (i9 > iB) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.f8982c = gVar.f8982c;
        int i10 = iB - i9;
        b(i10);
        for (int i11 = 0; i11 < 7 && i11 < i10; i11++) {
            a(i11, gVar.a(i11 + i9));
        }
    }

    public static g a(String str) {
        return a(str, (g) null);
    }

    private static final void b(g gVar, g gVar2) {
        if (gVar.a(0) == 0) {
            gVar2.f8982c = gVar.f8982c;
            gVar2.f8983d = gVar.f8983d;
            return;
        }
        int iA = gVar.a(0);
        int length = gVar.f8982c.length - iA;
        int iB = gVar.b();
        byte[] bArr = new byte[length];
        gVar2.f8982c = bArr;
        System.arraycopy(gVar.f8982c, iA, bArr, 0, length);
        for (int i9 = 0; i9 < iB && i9 < 7; i9++) {
            gVar2.a(i9, gVar.a(i9) - iA);
        }
        gVar2.b(iB);
    }

    public g(String str, g gVar) throws IOException {
        int i9;
        boolean z8;
        int i10;
        if (str.equals("")) {
            throw a(str, "empty name");
        }
        if (str.equals("@")) {
            if (gVar == null) {
                b(f8977b, this);
                return;
            } else {
                b(gVar, this);
                return;
            }
        }
        if (str.equals(".")) {
            b(f8976a, this);
            return;
        }
        byte[] bArr = new byte[64];
        int i11 = 0;
        boolean z9 = false;
        int i12 = -1;
        int i13 = 1;
        int i14 = 0;
        for (int i15 = 0; i15 < str.length(); i15++) {
            byte bCharAt = (byte) str.charAt(i15);
            if (z9) {
                if (bCharAt >= 48 && bCharAt <= 57 && i11 < 3) {
                    i11++;
                    i14 = (i14 * 10) + (bCharAt - 48);
                    if (i14 > 255) {
                        throw a(str, "bad escape");
                    }
                    if (i11 < 3) {
                        continue;
                    } else {
                        bCharAt = (byte) i14;
                    }
                } else if (i11 > 0 && i11 < 3) {
                    throw a(str, "bad escape");
                }
                if (i13 > 63) {
                    throw a(str, "label too long");
                }
                i10 = i13 + 1;
                bArr[i13] = bCharAt;
                i12 = i13;
                z9 = false;
                i13 = i10;
            } else if (bCharAt == 92) {
                i11 = 0;
                i14 = 0;
                z9 = true;
            } else if (bCharAt != 46) {
                i12 = i12 == -1 ? i15 : i12;
                if (i13 > 63) {
                    throw a(str, "label too long");
                }
                i10 = i13 + 1;
                bArr[i13] = bCharAt;
                i13 = i10;
            } else {
                if (i12 == -1) {
                    throw a(str, "invalid empty label");
                }
                bArr[0] = (byte) (i13 - 1);
                a(str, bArr, 0, 1);
                i12 = -1;
                i13 = 1;
            }
        }
        if (i11 > 0 && i11 < 3) {
            throw a(str, "bad escape");
        }
        if (z9) {
            throw a(str, "bad escape");
        }
        if (i12 == -1) {
            z8 = true;
            i9 = 0;
            a(str, f8978f, 0, 1);
        } else {
            i9 = 0;
            bArr[0] = (byte) (i13 - 1);
            a(str, bArr, 0, 1);
            z8 = false;
        }
        if (gVar == null || z8) {
            return;
        }
        a(str, gVar.f8982c, gVar.a(i9), gVar.d());
    }

    public static g a(String str, g gVar) {
        if (!str.equals("@") || gVar == null) {
            return str.equals(".") ? f8976a : new g(str, gVar);
        }
        return gVar;
    }

    private final void b(byte[] bArr, int i9, int i10) {
        try {
            a(bArr, i9, i10);
        } catch (Exception unused) {
        }
    }

    private static IOException a(String str, String str2) {
        return new IOException("'" + str + "': " + str2);
    }

    private final boolean b(byte[] bArr, int i9) {
        int iB = b();
        int iA = a(0);
        for (int i10 = 0; i10 < iB; i10++) {
            byte b9 = this.f8982c[iA];
            if (b9 != bArr[i9]) {
                return false;
            }
            iA++;
            i9++;
            if (b9 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i11 = 0;
            while (i11 < b9) {
                byte[] bArr2 = f8981i;
                int i12 = iA + 1;
                int i13 = i9 + 1;
                if (bArr2[this.f8982c[iA] & 255] != bArr2[bArr[i9] & 255]) {
                    return false;
                }
                i11++;
                i9 = i13;
                iA = i12;
            }
        }
        return true;
    }

    public String a(boolean z8) {
        int iB = b();
        if (iB == 0) {
            return "@";
        }
        if (iB == 1 && this.f8982c[a(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int iA = a(0);
        for (int i9 = 0; i9 < iB; i9++) {
            byte b9 = this.f8982c[iA];
            if (b9 > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b9 == 0) {
                if (!z8) {
                    stringBuffer.append('.');
                    break;
                }
                break;
            }
            if (i9 > 0) {
                stringBuffer.append('.');
            }
            stringBuffer.append(a(this.f8982c, iA));
            iA += b9 + 1;
        }
        return stringBuffer.toString();
    }

    private String a(byte[] bArr, int i9) {
        StringBuffer stringBuffer = new StringBuffer();
        int i10 = i9 + 1;
        int i11 = bArr[i9];
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            int i13 = bArr[i12] & 255;
            if (i13 <= 32 || i13 >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(f8980h.format(i13));
            } else {
                if (i13 == 34 || i13 == 40 || i13 == 41 || i13 == 46 || i13 == 59 || i13 == 92 || i13 == 64 || i13 == 36) {
                    stringBuffer.append('\\');
                }
                stringBuffer.append((char) i13);
            }
        }
        return stringBuffer.toString();
    }

    private final void a(int i9, int i10) {
        if (i9 >= 7) {
            return;
        }
        int i11 = (7 - i9) * 8;
        this.f8983d = (((long) i10) << i11) | (this.f8983d & (~(255 << i11)));
    }

    public void a(c cVar) {
        cVar.a(c());
    }

    public void a(c cVar, a aVar) {
        int iB = b();
        int i9 = 0;
        while (i9 < iB - 1) {
            g gVar = i9 == 0 ? this : new g(this, i9);
            int iA = aVar != null ? aVar.a(gVar) : -1;
            if (iA >= 0) {
                cVar.c(49152 | iA);
                return;
            }
            if (aVar != null) {
                aVar.a(cVar.a(), gVar);
            }
            int iA2 = a(i9);
            byte[] bArr = this.f8982c;
            cVar.a(bArr, iA2, bArr[iA2] + 1);
            i9++;
        }
        cVar.b(0);
    }

    public void a(c cVar, a aVar, boolean z8) {
        if (z8) {
            a(cVar);
        } else {
            a(cVar, aVar);
        }
    }

    private final void a(String str, byte[] bArr, int i9, int i10) throws IOException {
        try {
            a(bArr, i9, i10);
        } catch (Exception unused) {
            throw a(str, "Name too long");
        }
    }

    private final void a(byte[] bArr, int i9, int i10) throws IOException {
        byte[] bArr2 = this.f8982c;
        int length = bArr2 == null ? 0 : bArr2.length - a(0);
        int i11 = i9;
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = bArr[i11];
            if (i14 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i15 = i14 + 1;
            i11 += i15;
            i12 += i15;
        }
        int i16 = length + i12;
        if (i16 > 255) {
            throw new IOException();
        }
        int iD = d();
        int i17 = iD + i10;
        if (i17 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i16];
        if (length != 0) {
            System.arraycopy(this.f8982c, a(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i9, bArr3, length, i12);
        this.f8982c = bArr3;
        for (int i18 = 0; i18 < i10; i18++) {
            a(iD + i18, length);
            length += bArr3[length] + 1;
        }
        b(i17);
    }

    public boolean a() {
        int iB = b();
        return iB != 0 && this.f8982c[a(iB - 1)] == 0;
    }
}
