package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public abstract class jz {
    public abstract int a(byte[] bArr, int i9, int i10);

    public void a(int i9) {
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo644a(byte[] bArr, int i9, int i10);

    public int a_() {
        return 0;
    }

    public int b() {
        return -1;
    }

    public byte[] a() {
        return null;
    }

    public int b(byte[] bArr, int i9, int i10) throws ka {
        int i11 = 0;
        while (i11 < i10) {
            int iA = a(bArr, i9 + i11, i10 - i11);
            if (iA <= 0) {
                throw new ka("Cannot read. Remote side has closed. Tried to read " + i10 + " bytes, but only got " + i11 + " bytes.");
            }
            i11 += iA;
        }
        return i11;
    }
}
