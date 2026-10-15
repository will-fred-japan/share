package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f18445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1182a;

    static {
        String str = ad.f17014a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f1181a = str;
        f1182a = false;
        f18445a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            f18445a = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            f18445a = 3;
        } else {
            f18445a = 1;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m845a() {
        return f18445a == 2;
    }

    public static boolean b() {
        return f18445a == 3;
    }

    public static int a() {
        return f18445a;
    }

    public static void a(int i9) {
        f18445a = i9;
    }
}
