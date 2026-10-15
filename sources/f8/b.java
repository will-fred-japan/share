package f8;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f18720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f18723e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f18724f;

        public final String toString() {
            return a.class.getSimpleName() + "[buffer=" + Arrays.toString(this.f18720b) + ", currentLinePos=0, eof=" + this.f18723e + ", ibitWorkArea=" + this.f18719a + ", lbitWorkArea=0, modulus=" + this.f18724f + ", pos=" + this.f18721c + ", readPos=" + this.f18722d + "]";
        }
    }

    public static byte[] a(int i9, a aVar) {
        byte[] bArr = aVar.f18720b;
        if (bArr != null && bArr.length >= aVar.f18721c + i9) {
            return bArr;
        }
        if (bArr == null) {
            aVar.f18720b = new byte[8192];
            aVar.f18721c = 0;
            aVar.f18722d = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f18720b = bArr2;
        }
        return aVar.f18720b;
    }
}
