package A0;

import java.util.Objects;

/* JADX INFO: compiled from: WebMessageCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l[] f1376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f1378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1379d;

    public k(String str, l[] lVarArr) {
        this.f1377b = str;
        this.f1378c = null;
        this.f1376a = lVarArr;
        this.f1379d = 0;
    }

    public final void a(int i9) {
        String str;
        int i10 = this.f1379d;
        if (i9 == i10) {
            return;
        }
        StringBuilder sb = new StringBuilder("Wrong data accessor type detected. ");
        String str2 = "String";
        if (i10 != 0) {
            str = i10 != 1 ? "Unknown" : "ArrayBuffer";
        } else {
            str = "String";
        }
        sb.append(str);
        sb.append(" expected, but got ");
        if (i9 != 0) {
            str2 = i9 != 1 ? "Unknown" : "ArrayBuffer";
        }
        sb.append(str2);
        throw new IllegalStateException(sb.toString());
    }

    public k(byte[] bArr, l[] lVarArr) {
        Objects.requireNonNull(bArr);
        this.f1378c = bArr;
        this.f1377b = null;
        this.f1376a = lVarArr;
        this.f1379d = 1;
    }
}
