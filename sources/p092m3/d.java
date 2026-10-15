package p092m3;

import java.util.HashMap;

/* JADX INFO: compiled from: Type.java */
/* JADX INFO: loaded from: classes.dex */
public enum d {
    /* JADX INFO: Fake field, exist only in values array */
    EF0(0, "OBJECT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1(1, "BOOLEAN"),
    f20336c(2, "CHAR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF3(4, "FLOAT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4(8, "DOUBLE"),
    f20337d(1, "BYTE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF67(2, "SHORT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF76(4, "INT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF85(8, "LONG");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f20338e = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20341b;

    static {
        d[] dVarArrValues = values();
        for (int i9 = 0; i9 < 9; i9++) {
            d dVar = dVarArrValues[i9];
            f20338e.put(Integer.valueOf(dVar.f20340a), dVar);
        }
    }

    d(int i9, String str) {
        this.f20340a = i;
        this.f20341b = i9;
    }

    public static d a(int i9) {
        return (d) f20338e.get(Integer.valueOf(i9));
    }
}
