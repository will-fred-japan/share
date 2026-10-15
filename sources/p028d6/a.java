package p028d6;

/* JADX INFO: compiled from: Hex.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f18527a;

    static {
        int i9 = p019c6.a.f8771a;
        f18527a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i9 = 0;
        for (byte b9 : bArr) {
            int i10 = i9 + 1;
            char[] cArr2 = f18527a;
            cArr[i9] = cArr2[(b9 & 240) >>> 4];
            i9 += 2;
            cArr[i10] = cArr2[b9 & 15];
        }
        return new String(cArr);
    }
}
