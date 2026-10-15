package com.huawei.hms.hatool;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    s0 f15151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    s0 f15152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f15153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f15154d;

    public b(Context context) {
        if (context != null) {
            this.f15153c = context.getApplicationContext();
        }
        this.f15151a = new s0();
        this.f15152b = new s0();
    }

    public b a(int i9, String str) {
        v.a("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i9);
        if (!p1.b(str)) {
            str = "";
        }
        if (i9 == 0) {
            this.f15151a.b(str);
            return this;
        }
        if (i9 != 1) {
            v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        }
        this.f15152b.b(str);
        return this;
    }

    @Deprecated
    public b b(boolean z8) {
        v.a("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f15151a.j().b(z8);
        this.f15152b.j().b(z8);
        return this;
    }

    @Deprecated
    public b c(boolean z8) {
        v.a("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f15151a.j().c(z8);
        this.f15152b.j().c(z8);
        return this;
    }

    public b a(String str) {
        v.a("hmsSdk", "Builder.setAppID is execute");
        this.f15154d = str;
        return this;
    }

    @Deprecated
    public b a(boolean z8) {
        v.a("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f15151a.j().a(z8);
        this.f15152b.j().a(z8);
        return this;
    }

    public void a() {
        if (this.f15153c == null) {
            v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        v.a("hmsSdk", "Builder.create() is execute.");
        z0 z0Var = new z0("_hms_config_tag");
        z0Var.b(new s0(this.f15151a));
        z0Var.a(new s0(this.f15152b));
        m.a().a(this.f15153c);
        g0.a().a(this.f15153c);
        q.c().a(z0Var);
        m.a().a(this.f15154d);
    }
}
