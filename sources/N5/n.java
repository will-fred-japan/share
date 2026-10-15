package N5;

/* JADX INFO: compiled from: InsecureNonceXChaCha20.java */
/* JADX INFO: loaded from: classes.dex */
public final class n extends k {
    @Override // N5.k
    public final int[] b(int[] iArr, int i9) {
        if (iArr.length != 6) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
        }
        int[] iArr2 = new int[16];
        int[] iArrB = i.b(this.f3243a, iArr);
        int[] iArr3 = i.f3242a;
        System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
        System.arraycopy(iArrB, 0, iArr2, iArr3.length, 8);
        iArr2[12] = i9;
        iArr2[13] = 0;
        iArr2[14] = iArr[4];
        iArr2[15] = iArr[5];
        return iArr2;
    }

    @Override // N5.k
    public final int c() {
        return 24;
    }
}
