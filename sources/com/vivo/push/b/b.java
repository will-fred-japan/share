package com.vivo.push.b;

import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;

/* JADX INFO: compiled from: AppCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16493d;

    public b(boolean z8, String str) {
        super(z8 ? 2006 : 2007, str);
        this.f16492c = 1;
        this.f16493d = false;
    }

    public final void a(int i9) {
        this.f16492c = i9;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("sdk_clients", this.f16490a);
        dVar.a(HianalyticsBaseData.SDK_VERSION, 363L);
        dVar.a("PUSH_REGID", this.f16491b);
        if (b() == 2007) {
            dVar.a("PUSH_UNBIND_SOURCE_CODE", this.f16492c);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16490a = dVar.a("sdk_clients");
        this.f16491b = dVar.a("PUSH_REGID");
        if (b() == 2007) {
            this.f16492c = dVar.b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final String toString() {
        return "AppCommand:" + b();
    }
}
