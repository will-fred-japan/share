package cn.jiguang.ad;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f8956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8958c;

    public c() {
        this(32);
    }

    private void d(int i9) {
        byte[] bArr = this.f8956a;
        int length = bArr.length;
        int i10 = this.f8957b;
        if (length - i10 >= i9) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i10 + i9) {
            length2 = i10 + i9;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        this.f8956a = bArr2;
    }

    public int a() {
        return this.f8957b;
    }

    public void b(int i9) {
        a(i9, 8);
        d(1);
        byte[] bArr = this.f8956a;
        int i10 = this.f8957b;
        this.f8957b = i10 + 1;
        bArr[i10] = (byte) (i9 & 255);
    }

    public void c(int i9) {
        a(i9, 16);
        d(2);
        byte[] bArr = this.f8956a;
        int i10 = this.f8957b;
        int i11 = i10 + 1;
        this.f8957b = i11;
        bArr[i10] = (byte) ((i9 >>> 8) & 255);
        this.f8957b = i10 + 2;
        bArr[i11] = (byte) (i9 & 255);
    }

    public c(int i9) {
        this.f8956a = new byte[i9];
        this.f8957b = 0;
        this.f8958c = -1;
    }

    public void a(int i9) {
        if (i9 > this.f8957b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.f8957b = i9;
    }

    public byte[] b() {
        int i9 = this.f8957b;
        byte[] bArr = new byte[i9];
        System.arraycopy(this.f8956a, 0, bArr, 0, i9);
        return bArr;
    }

    public void a(int i9, int i10) {
        a(i9, 16);
        if (i10 > this.f8957b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f8956a;
        bArr[i10] = (byte) ((i9 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (i9 & 255);
    }

    public void a(long j) {
        a(j, 32);
        d(4);
        byte[] bArr = this.f8956a;
        int i9 = this.f8957b;
        int i10 = i9 + 1;
        this.f8957b = i10;
        bArr[i9] = (byte) ((j >>> 24) & 255);
        int i11 = i9 + 2;
        this.f8957b = i11;
        bArr[i10] = (byte) ((j >>> 16) & 255);
        int i12 = i9 + 3;
        this.f8957b = i12;
        bArr[i11] = (byte) ((j >>> 8) & 255);
        this.f8957b = i9 + 4;
        bArr[i12] = (byte) (j & 255);
    }

    private void a(long j, int i9) {
        long j8 = 1 << i9;
        if (j < 0 || j > j8) {
            throw new IllegalArgumentException(j + " out of range for " + i9 + " bit value");
        }
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i9, int i10) {
        d(i10);
        System.arraycopy(bArr, i9, this.f8956a, this.f8957b, i10);
        this.f8957b += i10;
    }
}
