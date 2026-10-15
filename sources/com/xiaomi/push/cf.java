package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class cf extends cj.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f17130a;

    public cf(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f17130a = str3;
    }

    public static cf a(String str) {
        return new cf(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
