package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15222e;

    public i1(String str, String str2, String str3, String str4, long j) {
        this.f15218a = str;
        this.f15219b = str2;
        this.f15220c = str3;
        this.f15221d = str4;
        this.f15222e = j;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.f15220c);
        b1Var.d(this.f15219b);
        b1Var.a(this.f15221d);
        b1Var.c(String.valueOf(this.f15222e));
        if ("oper".equals(this.f15219b) && z.i(this.f15218a, "oper")) {
            p0 p0VarA = y.a().a(this.f15218a, this.f15222e);
            String strA = p0VarA.a();
            Boolean boolValueOf = Boolean.valueOf(p0VarA.b());
            b1Var.f(strA);
            b1Var.e(String.valueOf(boolValueOf));
        }
        String strReplace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.f15218a, this.f15219b, q0.g(), arrayList, strReplace).a();
    }
}
