package N5;

/* JADX INFO: compiled from: InsecureNonceChaCha20.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends k {
    @Override // N5.k
    public final int[] b(int[] iArr, int i9) {
        if (iArr.length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
        }
        int[] iArr2 = new int[16];
        int[] iArr3 = this.f3243a;
        int[] iArr4 = i.f3242a;
        System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
        System.arraycopy(iArr3, 0, iArr2, iArr4.length, 8);
        iArr2[12] = i9;
        System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
        return iArr2;
    }

    @Override // N5.k
    public final int c() {
        return 12;
    }
}
