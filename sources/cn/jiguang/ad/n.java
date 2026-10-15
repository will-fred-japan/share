package cn.jiguang.ad;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f9007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f9008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String[] f9009c;

    static {
        f fVar = new f("Message Section", 3);
        f9007a = fVar;
        f9008b = new String[4];
        f9009c = new String[4];
        fVar.a(3);
        f9007a.a(true);
        f9007a.a(0, "qd");
        f9007a.a(1, "an");
        f9007a.a(2, "au");
        f9007a.a(3, "ad");
        String[] strArr = f9008b;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = f9009c;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i9) {
        return f9007a.d(i9);
    }
}
