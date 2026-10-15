package cn.jiguang.aj;

import cn.jiguang.aw.v;
import cn.jiguang.x.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigInteger f9183d = BigInteger.ONE.shiftLeft(64);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f9184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9186c;

    public b() {
        this(32);
    }

    private void c(int i9) {
        byte[] bArr = this.f9184a;
        int length = bArr.length;
        int i10 = this.f9185b;
        if (length - i10 >= i9) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i10 + i9) {
            length2 = i10 + i9;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        this.f9184a = bArr2;
    }

    public int a() {
        return this.f9185b;
    }

    public void b(int i9) {
        b(i9, 16);
        c(2);
        byte[] bArr = this.f9184a;
        int i10 = this.f9185b;
        int i11 = i10 + 1;
        this.f9185b = i11;
        bArr[i10] = (byte) ((i9 >>> 8) & 255);
        this.f9185b = i10 + 2;
        bArr[i11] = (byte) (i9 & 255);
    }

    public b(int i9) {
        this.f9184a = new byte[i9];
        this.f9185b = 0;
        this.f9186c = -1;
    }

    public void a(int i9) {
        b(i9, 8);
        c(1);
        byte[] bArr = this.f9184a;
        int i10 = this.f9185b;
        this.f9185b = i10 + 1;
        bArr[i10] = (byte) (i9 & 255);
    }

    public void b(int i9, int i10) {
        b(i9, 16);
        if (i10 > this.f9185b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f9184a;
        bArr[i10] = (byte) ((i9 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (i9 & 255);
    }

    public void a(int i9, int i10) {
        b(i9, 8);
        if (i10 > this.f9185b - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.f9184a[i10] = (byte) (i9 & 255);
    }

    public void b(long j) {
        c(8);
        byte[] bArr = this.f9184a;
        int i9 = this.f9185b;
        int i10 = i9 + 1;
        this.f9185b = i10;
        bArr[i9] = (byte) ((j >>> 56) & 255);
        int i11 = i9 + 2;
        this.f9185b = i11;
        bArr[i10] = (byte) ((j >>> 48) & 255);
        int i12 = i9 + 3;
        this.f9185b = i12;
        bArr[i11] = (byte) ((j >>> 40) & 255);
        int i13 = i9 + 4;
        this.f9185b = i13;
        bArr[i12] = (byte) ((j >>> 32) & 255);
        int i14 = i9 + 5;
        this.f9185b = i14;
        bArr[i13] = (byte) ((j >>> 24) & 255);
        int i15 = i9 + 6;
        this.f9185b = i15;
        bArr[i14] = (byte) ((j >>> 16) & 255);
        int i16 = i9 + 7;
        this.f9185b = i16;
        bArr[i15] = (byte) ((j >>> 8) & 255);
        this.f9185b = i9 + 8;
        bArr[i16] = (byte) (j & 255);
    }

    private void b(long j, int i9) {
        long j8 = 1 << i9;
        if (j < 0 || j > j8) {
            f.i("Outputer", j + " out of range for " + i9 + " bit value max:" + j8);
        }
    }

    public void a(long j) {
        b(j, 32);
        c(4);
        byte[] bArr = this.f9184a;
        int i9 = this.f9185b;
        int i10 = i9 + 1;
        this.f9185b = i10;
        bArr[i9] = (byte) ((j >>> 24) & 255);
        int i11 = i9 + 2;
        this.f9185b = i11;
        bArr[i10] = (byte) ((j >>> 16) & 255);
        int i12 = i9 + 3;
        this.f9185b = i12;
        bArr[i11] = (byte) ((j >>> 8) & 255);
        this.f9185b = i9 + 4;
        bArr[i12] = (byte) (j & 255);
    }

    public void a(long j, int i9) {
        b(j, 32);
        if (i9 > this.f9185b - 4) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f9184a;
        bArr[i9] = (byte) ((j >>> 24) & 255);
        bArr[i9 + 1] = (byte) ((j >>> 16) & 255);
        bArr[i9 + 2] = (byte) ((j >>> 8) & 255);
        bArr[i9 + 3] = (byte) (j & 255);
    }

    public void b(byte[] bArr) {
        b(bArr.length);
        a(bArr, 0, bArr.length);
    }

    public void a(String str) {
        byte[] bArrJ = v.j(str);
        b(bArrJ.length);
        a(bArrJ, 0, bArrJ.length);
    }

    public byte[] b() {
        int i9 = this.f9185b;
        byte[] bArr = new byte[i9];
        System.arraycopy(this.f9184a, 0, bArr, 0, i9);
        return bArr;
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i9, int i10) {
        c(i10);
        System.arraycopy(bArr, i9, this.f9184a, this.f9185b, i10);
        this.f9185b += i10;
    }
}
