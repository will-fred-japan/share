package p012b6;

import java.util.Arrays;
import p199z2.b;

/* JADX INFO: compiled from: Bytes.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f8594a;

    public a(byte[] bArr, int i9) {
        byte[] bArr2 = new byte[i9];
        this.f8594a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i9);
    }

    public static a a(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        int length = bArr.length;
        if (length > bArr.length) {
            length = bArr.length;
        }
        return new a(bArr, length);
    }

    public final byte[] b() {
        byte[] bArr = this.f8594a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(((a) obj).f8594a, this.f8594a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8594a);
    }

    public final String toString() {
        return "Bytes(" + b.x(this.f8594a) + ")";
    }
}
