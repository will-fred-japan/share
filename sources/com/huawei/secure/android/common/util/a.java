package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Character f15978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Character f15979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15980d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15981e = 0;

    public a(String str) {
        this.f15977a = str;
    }

    public static boolean c(Character ch) {
        char cCharValue;
        return ch != null && (cCharValue = ch.charValue()) >= '0' && cCharValue <= '7';
    }

    public void a(Character ch) {
        this.f15978b = ch;
    }

    public int b() {
        return this.f15980d;
    }

    public Character d() {
        Character ch = this.f15978b;
        if (ch != null) {
            this.f15978b = null;
            return ch;
        }
        String str = this.f15977a;
        if (str == null || str.length() == 0 || this.f15980d >= this.f15977a.length()) {
            return null;
        }
        String str2 = this.f15977a;
        int i9 = this.f15980d;
        this.f15980d = i9 + 1;
        return Character.valueOf(str2.charAt(i9));
    }

    public Character e() {
        Character chD = d();
        if (chD != null && b(chD)) {
            return chD;
        }
        return null;
    }

    public Character f() {
        Character chD = d();
        if (chD != null && c(chD)) {
            return chD;
        }
        return null;
    }

    public Character g() {
        Character ch = this.f15978b;
        if (ch != null) {
            return ch;
        }
        String str = this.f15977a;
        if (str == null || str.length() == 0 || this.f15980d >= this.f15977a.length()) {
            return null;
        }
        return Character.valueOf(this.f15977a.charAt(this.f15980d));
    }

    public String h() {
        String strSubstring = this.f15977a.substring(this.f15980d);
        if (this.f15978b == null) {
            return strSubstring;
        }
        return this.f15978b + strSubstring;
    }

    public void i() {
        this.f15978b = this.f15979c;
        this.f15980d = this.f15981e;
    }

    public static boolean b(Character ch) {
        if (ch == null) {
            return false;
        }
        char cCharValue = ch.charValue();
        if (cCharValue >= '0' && cCharValue <= '9') {
            return true;
        }
        if (cCharValue < 'a' || cCharValue > 'f') {
            return cCharValue >= 'A' && cCharValue <= 'F';
        }
        return true;
    }

    public boolean a() {
        if (this.f15978b != null) {
            return true;
        }
        String str = this.f15977a;
        return (str == null || str.length() == 0 || this.f15980d >= this.f15977a.length()) ? false : true;
    }

    public void c() {
        this.f15979c = this.f15978b;
        this.f15981e = this.f15980d;
    }

    public boolean a(char c5) {
        Character ch = this.f15978b;
        if (ch != null && ch.charValue() == c5) {
            return true;
        }
        String str = this.f15977a;
        return str != null && str.length() != 0 && this.f15980d < this.f15977a.length() && this.f15977a.charAt(this.f15980d) == c5;
    }
}
