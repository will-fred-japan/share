package cn.jiguang.ad;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Integer[] f8968a = new Integer[64];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8973f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8975h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap f8969b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap f8970c = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8974g = Integer.MAX_VALUE;

    static {
        int i9 = 0;
        while (true) {
            Integer[] numArr = f8968a;
            if (i9 >= numArr.length) {
                return;
            }
            numArr[i9] = Integer.valueOf(i9);
            i9++;
        }
    }

    public f(String str, int i9) {
        this.f8971d = str;
        this.f8972e = i9;
    }

    private String a(String str) {
        int i9 = this.f8972e;
        if (i9 == 2) {
            return str.toUpperCase();
        }
        return i9 == 3 ? str.toLowerCase() : str;
    }

    public static Integer b(int i9) {
        if (i9 >= 0) {
            Integer[] numArr = f8968a;
            if (i9 < numArr.length) {
                return numArr[i9];
            }
        }
        return Integer.valueOf(i9);
    }

    public void c(int i9) {
        if (i9 < 0 || i9 > this.f8974g) {
            throw new IllegalArgumentException(this.f8971d + " " + i9 + "is out of range");
        }
    }

    public String d(int i9) {
        c(i9);
        String str = (String) this.f8970c.get(b(i9));
        if (str != null) {
            return str;
        }
        String string = Integer.toString(i9);
        return this.f8973f != null ? A.a.j(new StringBuilder(), this.f8973f, string) : string;
    }

    public void a(int i9) {
        this.f8974g = i9;
    }

    public void a(int i9, String str) {
        c(i9);
        Integer numB = b(i9);
        String strA = a(str);
        this.f8969b.put(strA, numB);
        this.f8970c.put(numB, strA);
    }

    public void a(boolean z8) {
        this.f8975h = z8;
    }
}
