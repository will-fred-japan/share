package com.xiaomi.push;

import java.io.InputStream;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final InputStream f159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17117i;

    private c(byte[] bArr, int i9, int i10) {
        this.f17114f = Integer.MAX_VALUE;
        this.f17116h = 64;
        this.f17117i = 67108864;
        this.f160a = bArr;
        this.f17109a = i10 + i9;
        this.f17111c = i9;
        this.f159a = null;
    }

    public static c a(InputStream inputStream) {
        return new c(inputStream);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m149b() {
        return m151c();
    }

    public int c() {
        return d();
    }

    public int d() throws e {
        int i9;
        byte bA = a();
        if (bA >= 0) {
            return bA;
        }
        int i10 = bA & 127;
        byte bA2 = a();
        if (bA2 >= 0) {
            i9 = bA2 << 7;
        } else {
            i10 |= (bA2 & 127) << 7;
            byte bA3 = a();
            if (bA3 >= 0) {
                i9 = bA3 << 14;
            } else {
                i10 |= (bA3 & 127) << 14;
                byte bA4 = a();
                if (bA4 < 0) {
                    int i11 = i10 | ((bA4 & 127) << 21);
                    byte bA5 = a();
                    int i12 = i11 | (bA5 << 28);
                    if (bA5 < 0) {
                        for (int i13 = 0; i13 < 5; i13++) {
                            if (a() < 0) {
                            }
                        }
                        throw e.c();
                    }
                    return i12;
                }
                i9 = bA4 << 21;
            }
        }
        return i10 | i9;
    }

    public int e() throws e {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }

    public static c a(byte[] bArr, int i9, int i10) {
        return new c(bArr, i9, i10);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public int m148b() {
        return d();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m151c() throws e {
        long j = 0;
        for (int i9 = 0; i9 < 64; i9 += 7) {
            byte bA = a();
            j |= ((long) (bA & 127)) << i9;
            if ((bA & 128) == 0) {
                return j;
            }
        }
        throw e.c();
    }

    private void b() {
        int i9 = this.f17109a + this.f17110b;
        this.f17109a = i9;
        int i10 = this.f17113e + i9;
        int i11 = this.f17114f;
        if (i10 > i11) {
            int i12 = i10 - i11;
            this.f17110b = i12;
            this.f17109a = i9 - i12;
            return;
        }
        this.f17110b = 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m139a() throws e {
        if (m150b()) {
            this.f17112d = 0;
            return 0;
        }
        int iD = d();
        this.f17112d = iD;
        if (iD != 0) {
            return iD;
        }
        throw e.d();
    }

    public void c(int i9) throws e {
        if (i9 >= 0) {
            int i10 = this.f17113e;
            int i11 = this.f17111c;
            int i12 = i10 + i11 + i9;
            int i13 = this.f17114f;
            if (i12 <= i13) {
                int i14 = this.f17109a;
                if (i9 <= i14 - i11) {
                    this.f17111c = i11 + i9;
                    return;
                }
                int i15 = i14 - i11;
                this.f17113e = i10 + i14;
                this.f17111c = 0;
                this.f17109a = 0;
                while (i15 < i9) {
                    InputStream inputStream = this.f159a;
                    int iSkip = inputStream == null ? -1 : (int) inputStream.skip(i9 - i15);
                    if (iSkip > 0) {
                        i15 += iSkip;
                        this.f17113e += iSkip;
                    } else {
                        throw e.a();
                    }
                }
                return;
            }
            c((i13 - i10) - i11);
            throw e.a();
        }
        throw e.b();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m144a(int i9) throws e {
        if (this.f17112d != i9) {
            throw e.e();
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public long m152d() throws e {
        byte bA = a();
        return ((((long) a()) & 255) << 8) | (((long) bA) & 255) | ((((long) a()) & 255) << 16) | ((((long) a()) & 255) << 24) | ((((long) a()) & 255) << 32) | ((((long) a()) & 255) << 40) | ((((long) a()) & 255) << 48) | ((((long) a()) & 255) << 56);
    }

    private c(InputStream inputStream) {
        this.f17114f = Integer.MAX_VALUE;
        this.f17116h = 64;
        this.f17117i = 67108864;
        this.f160a = new byte[4096];
        this.f17109a = 0;
        this.f17111c = 0;
        this.f159a = inputStream;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m146a(int i9) throws e {
        int iA = g.a(i9);
        if (iA == 0) {
            m148b();
            return true;
        }
        if (iA == 1) {
            m152d();
            return true;
        }
        if (iA == 2) {
            c(d());
            return true;
        }
        if (iA == 3) {
            m143a();
            m144a(g.a(g.b(i9), 4));
            return true;
        }
        if (iA == 4) {
            return false;
        }
        if (iA == 5) {
            e();
            return true;
        }
        throw e.f();
    }

    public void b(int i9) {
        this.f17114f = i9;
        b();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m150b() {
        return this.f17111c == this.f17109a && !a(false);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m143a() throws e {
        int iM139a;
        do {
            iM139a = m139a();
            if (iM139a == 0) {
                return;
            }
        } while (m146a(iM139a));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m140a() {
        return m151c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m145a() {
        return d() != 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m142a() throws e {
        int iD = d();
        int i9 = this.f17109a;
        int i10 = this.f17111c;
        if (iD <= i9 - i10 && iD > 0) {
            String str = new String(this.f160a, i10, iD, "UTF-8");
            this.f17111c += iD;
            return str;
        }
        return new String(m147a(iD), "UTF-8");
    }

    public void a(f fVar) throws e {
        int iD = d();
        if (this.f17115g < this.f17116h) {
            int iA = a(iD);
            this.f17115g++;
            fVar.a(this);
            m144a(0);
            this.f17115g--;
            b(iA);
            return;
        }
        throw e.g();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public b m141a() throws e {
        int iD = d();
        int i9 = this.f17109a;
        int i10 = this.f17111c;
        if (iD <= i9 - i10 && iD > 0) {
            b bVarA = b.a(this.f160a, i10, iD);
            this.f17111c += iD;
            return bVarA;
        }
        return b.a(m147a(iD));
    }

    public int a(int i9) throws e {
        if (i9 >= 0) {
            int i10 = this.f17113e + this.f17111c + i9;
            int i11 = this.f17114f;
            if (i10 <= i11) {
                this.f17114f = i10;
                b();
                return i11;
            }
            throw e.a();
        }
        throw e.b();
    }

    private boolean a(boolean z8) throws e {
        int i9 = this.f17111c;
        int i10 = this.f17109a;
        if (i9 >= i10) {
            int i11 = this.f17113e;
            if (i11 + i10 == this.f17114f) {
                if (z8) {
                    throw e.a();
                }
                return false;
            }
            this.f17113e = i11 + i10;
            this.f17111c = 0;
            InputStream inputStream = this.f159a;
            int i12 = inputStream == null ? -1 : inputStream.read(this.f160a);
            this.f17109a = i12;
            if (i12 == 0 || i12 < -1) {
                throw new IllegalStateException(A.f.i(new StringBuilder("InputStream#read(byte[]) returned invalid result: "), this.f17109a, "\nThe InputStream implementation is buggy."));
            }
            if (i12 == -1) {
                this.f17109a = 0;
                if (z8) {
                    throw e.a();
                }
                return false;
            }
            b();
            int i13 = this.f17113e + this.f17109a + this.f17110b;
            if (i13 > this.f17117i || i13 < 0) {
                throw e.h();
            }
            return true;
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public byte a() throws e {
        if (this.f17111c == this.f17109a) {
            a(true);
        }
        byte[] bArr = this.f160a;
        int i9 = this.f17111c;
        this.f17111c = i9 + 1;
        return bArr[i9];
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m147a(int i9) throws e {
        if (i9 >= 0) {
            int i10 = this.f17113e;
            int i11 = this.f17111c;
            int i12 = i10 + i11 + i9;
            int i13 = this.f17114f;
            if (i12 <= i13) {
                int i14 = this.f17109a;
                if (i9 <= i14 - i11) {
                    byte[] bArr = new byte[i9];
                    System.arraycopy(this.f160a, i11, bArr, 0, i9);
                    this.f17111c += i9;
                    return bArr;
                }
                if (i9 < 4096) {
                    byte[] bArr2 = new byte[i9];
                    int i15 = i14 - i11;
                    System.arraycopy(this.f160a, i11, bArr2, 0, i15);
                    this.f17111c = this.f17109a;
                    a(true);
                    while (true) {
                        int i16 = i9 - i15;
                        int i17 = this.f17109a;
                        if (i16 > i17) {
                            System.arraycopy(this.f160a, 0, bArr2, i15, i17);
                            int i18 = this.f17109a;
                            i15 += i18;
                            this.f17111c = i18;
                            a(true);
                        } else {
                            System.arraycopy(this.f160a, 0, bArr2, i15, i16);
                            this.f17111c = i16;
                            return bArr2;
                        }
                    }
                } else {
                    this.f17113e = i10 + i14;
                    this.f17111c = 0;
                    this.f17109a = 0;
                    int length = i14 - i11;
                    int i19 = i9 - length;
                    Vector vector = new Vector();
                    while (i19 > 0) {
                        int iMin = Math.min(i19, 4096);
                        byte[] bArr3 = new byte[iMin];
                        int i20 = 0;
                        while (i20 < iMin) {
                            InputStream inputStream = this.f159a;
                            int i21 = inputStream == null ? -1 : inputStream.read(bArr3, i20, iMin - i20);
                            if (i21 != -1) {
                                this.f17113e += i21;
                                i20 += i21;
                            } else {
                                throw e.a();
                            }
                        }
                        i19 -= iMin;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i9];
                    System.arraycopy(this.f160a, i11, bArr4, 0, length);
                    for (int i22 = 0; i22 < vector.size(); i22++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i22);
                        System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
                        length += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                c((i13 - i10) - i11);
                throw e.a();
            }
        } else {
            throw e.b();
        }
    }
}
