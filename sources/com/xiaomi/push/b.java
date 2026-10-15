package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17071a = new b(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f136a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f137a;

    private b(byte[] bArr) {
        this.f137a = bArr;
    }

    public int a() {
        return this.f137a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        byte[] bArr = this.f137a;
        int length = bArr.length;
        byte[] bArr2 = ((b) obj).f137a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i9 = 0; i9 < length; i9++) {
            if (bArr[i9] != bArr2[i9]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i9 = this.f136a;
        if (i9 != 0) {
            return i9;
        }
        byte[] bArr = this.f137a;
        int length = bArr.length;
        for (byte b9 : bArr) {
            length = (length * 31) + b9;
        }
        if (length == 0) {
            length = 1;
        }
        this.f136a = length;
        return length;
    }

    public static b a(byte[] bArr, int i9, int i10) {
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i9, bArr2, 0, i10);
        return new b(bArr2);
    }

    public static b a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m119a() {
        byte[] bArr = this.f137a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
