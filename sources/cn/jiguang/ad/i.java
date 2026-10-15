package cn.jiguang.ad;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements Serializable, Cloneable, Comparable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final DecimalFormat f8988e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f8989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f8990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f8991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f8992d;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f8988e = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    public static i a(b bVar, int i9) throws IOException {
        g gVar = new g(bVar);
        int iG = bVar.g();
        int iG2 = bVar.g();
        return i9 == 0 ? a(gVar, iG, iG2) : a(gVar, iG, iG2, bVar.h(), bVar.g(), bVar);
    }

    public abstract void a(b bVar);

    public abstract void a(c cVar, a aVar, boolean z8);

    public abstract String b();

    public String c() {
        return b();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        i iVar = (i) obj;
        if (this == iVar) {
            return 0;
        }
        int iCompareTo = this.f8989a.compareTo(iVar.f8989a);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i9 = this.f8991c - iVar.f8991c;
        if (i9 != 0) {
            return i9;
        }
        int i10 = this.f8990b - iVar.f8990b;
        if (i10 != 0) {
            return i10;
        }
        byte[] bArrA = a();
        byte[] bArrA2 = iVar.a();
        for (int i11 = 0; i11 < bArrA.length && i11 < bArrA2.length; i11++) {
            int i12 = (bArrA[i11] & 255) - (bArrA2[i11] & 255);
            if (i12 != 0) {
                return i12;
            }
        }
        return bArrA.length - bArrA2.length;
    }

    public g d() {
        return this.f8989a;
    }

    public int e() {
        return this.f8990b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i)) {
            i iVar = (i) obj;
            if (this.f8990b == iVar.f8990b && this.f8991c == iVar.f8991c && this.f8989a.equals(iVar.f8989a)) {
                return Arrays.equals(a(), iVar.a());
            }
        }
        return false;
    }

    public int f() {
        return this.f8990b;
    }

    public int g() {
        return this.f8991c;
    }

    public long h() {
        return this.f8992d;
    }

    public int hashCode() {
        int i9 = 0;
        for (byte b9 : a(true)) {
            i9 += (i9 << 3) + (b9 & 255);
        }
        return i9;
    }

    public i i() {
        try {
            return (i) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f8989a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String strB = b();
        if (!strB.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(strB);
        }
        return stringBuffer.toString();
    }

    public static i a(g gVar, int i9, int i10) {
        return a(gVar, i9, i10, 0L);
    }

    public static i a(g gVar, int i9, int i10, long j) {
        if (gVar.a()) {
            return a(gVar, i9, i10, j, false);
        }
        throw new j(gVar);
    }

    private static i a(g gVar, int i9, int i10, long j, int i11, b bVar) throws IOException {
        i iVarA = a(gVar, i9, i10, j, bVar != null);
        if (bVar == null) {
            return iVarA;
        }
        if (bVar.b() < i11) {
            throw new IOException("truncated record");
        }
        bVar.a(i11);
        iVarA.a(bVar);
        if (bVar.b() > 0) {
            throw new IOException("invalid record length");
        }
        bVar.c();
        return iVarA;
    }

    private static final i a(g gVar, int i9, int i10, long j, boolean z8) {
        m mVar = new m();
        mVar.f8989a = gVar;
        mVar.f8990b = i9;
        mVar.f8991c = i10;
        mVar.f8992d = j;
        return mVar;
    }

    public void a(long j) {
        this.f8992d = j;
    }

    public void a(c cVar, int i9, a aVar) {
        this.f8989a.a(cVar, aVar);
        cVar.c(this.f8990b);
        cVar.c(this.f8991c);
    }

    private void a(c cVar, boolean z8) {
        this.f8989a.a(cVar);
        cVar.c(this.f8990b);
        cVar.c(this.f8991c);
        cVar.a(z8 ? 0L : this.f8992d);
        int iA = cVar.a();
        cVar.c(0);
        a(cVar, (a) null, true);
        cVar.a((cVar.a() - iA) - 2, iA);
    }

    public boolean a(i iVar) {
        return f() == iVar.f() && this.f8991c == iVar.f8991c && this.f8989a.equals(iVar.f8989a);
    }

    public byte[] a() {
        c cVar = new c();
        a(cVar, (a) null, true);
        return cVar.b();
    }

    private byte[] a(boolean z8) {
        c cVar = new c();
        a(cVar, z8);
        return cVar.b();
    }
}
