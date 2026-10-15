package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f15208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15209b = 0;

    public h(int i9) {
        this.f15208a = null;
        this.f15208a = new byte[i9];
    }

    public void a(byte[] bArr, int i9) {
        if (i9 <= 0) {
            return;
        }
        byte[] bArr2 = this.f15208a;
        int length = bArr2.length;
        int i10 = this.f15209b;
        if (length - i10 >= i9) {
            System.arraycopy(bArr, 0, bArr2, i10, i9);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i9) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i10);
            System.arraycopy(bArr, 0, bArr3, this.f15209b, i9);
            this.f15208a = bArr3;
        }
        this.f15209b += i9;
    }

    public int b() {
        return this.f15209b;
    }

    public byte[] a() {
        int i9 = this.f15209b;
        if (i9 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i9];
        System.arraycopy(this.f15208a, 0, bArr, 0, i9);
        return bArr;
    }
}
