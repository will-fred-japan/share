package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public final class jy extends jz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18119b;

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.jz
    public int a_() {
        return this.f18118a;
    }

    public void b(byte[] bArr, int i9, int i10) {
        this.f922a = bArr;
        this.f18118a = i9;
        this.f18119b = i9 + i10;
    }

    @Override // com.xiaomi.push.jz
    public int a(byte[] bArr, int i9, int i10) {
        int iB = b();
        if (i10 > iB) {
            i10 = iB;
        }
        if (i10 > 0) {
            System.arraycopy(this.f922a, this.f18118a, bArr, i9, i10);
            a(i10);
        }
        return i10;
    }

    @Override // com.xiaomi.push.jz
    public int b() {
        return this.f18119b - this.f18118a;
    }

    @Override // com.xiaomi.push.jz
    /* JADX INFO: renamed from: a */
    public void mo644a(byte[] bArr, int i9, int i10) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.jz
    public byte[] a() {
        return this.f922a;
    }

    @Override // com.xiaomi.push.jz
    public void a(int i9) {
        this.f18118a += i9;
    }
}
