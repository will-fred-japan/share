package p092m3;

import java.util.Arrays;

/* JADX INFO: compiled from: ID.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f20335a;

    public c(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.f20335a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        return Arrays.equals(this.f20335a, ((c) obj).f20335a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f20335a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("0x");
        for (byte b9 : this.f20335a) {
            sb.append(Integer.toHexString(b9 & 255));
        }
        return sb.toString();
    }
}
