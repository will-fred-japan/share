package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigInteger f11802d = BigInteger.ONE.shiftLeft(64);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f11803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11805c;

    public d() {
        this(32);
    }

    private void c(int i9) {
        byte[] bArr = this.f11803a;
        int length = bArr.length;
        int i10 = this.f11804b;
        if (length - i10 >= i9) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i10 + i9) {
            length2 = i10 + i9;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        this.f11803a = bArr2;
    }

    public void a(int i9) {
        a(i9, 8);
        c(1);
        byte[] bArr = this.f11803a;
        int i10 = this.f11804b;
        this.f11804b = i10 + 1;
        bArr[i10] = (byte) (i9 & 255);
    }

    public void b(int i9) {
        a(i9, 16);
        c(2);
        byte[] bArr = this.f11803a;
        int i10 = this.f11804b;
        int i11 = i10 + 1;
        this.f11804b = i11;
        bArr[i10] = (byte) ((i9 >>> 8) & 255);
        this.f11804b = i10 + 2;
        bArr[i11] = (byte) (i9 & 255);
    }

    public d(int i9) {
        this.f11803a = new byte[i9];
        this.f11804b = 0;
        this.f11805c = -1;
    }

    public void a(long j) {
        c(8);
        byte[] bArr = this.f11803a;
        int i9 = this.f11804b;
        int i10 = i9 + 1;
        this.f11804b = i10;
        bArr[i9] = (byte) ((j >>> 56) & 255);
        int i11 = i9 + 2;
        this.f11804b = i11;
        bArr[i10] = (byte) ((j >>> 48) & 255);
        int i12 = i9 + 3;
        this.f11804b = i12;
        bArr[i11] = (byte) ((j >>> 40) & 255);
        int i13 = i9 + 4;
        this.f11804b = i13;
        bArr[i12] = (byte) ((j >>> 32) & 255);
        int i14 = i9 + 5;
        this.f11804b = i14;
        bArr[i13] = (byte) ((j >>> 24) & 255);
        int i15 = i9 + 6;
        this.f11804b = i15;
        bArr[i14] = (byte) ((j >>> 16) & 255);
        int i16 = i9 + 7;
        this.f11804b = i16;
        bArr[i15] = (byte) ((j >>> 8) & 255);
        this.f11804b = i9 + 8;
        bArr[i16] = (byte) (j & 255);
    }

    private void a(long j, int i9) {
        long j8 = 1 << i9;
        if (j < 0 || j > j8) {
            Logger.w("OutputDataUtil", j + " out of range for " + i9 + " bit value max:" + j8);
        }
    }

    public void a(String str) {
        byte[] bArrB = b.b(str);
        b(bArrB.length);
        a(bArrB, 0, bArrB.length);
    }

    public void a(byte[] bArr) {
        b(bArr.length);
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i9, int i10) {
        c(i10);
        System.arraycopy(bArr, i9, this.f11803a, this.f11804b, i10);
        this.f11804b += i10;
    }

    public byte[] a() {
        int i9 = this.f11804b;
        byte[] bArr = new byte[i9];
        System.arraycopy(this.f11803a, 0, bArr, 0, i9);
        return bArr;
    }
}
