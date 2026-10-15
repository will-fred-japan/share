package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.vivo.push.util.ad;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: compiled from: BaseAppCommand.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.vivo.push.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f16501h;

    public c(int i9, String str) {
        super(i9);
        this.f16496c = -1L;
        this.f16497d = -1;
        this.f16494a = null;
        this.f16495b = str;
    }

    public final int a(Context context) {
        if (this.f16497d == -1) {
            String strA = this.f16495b;
            if (TextUtils.isEmpty(strA)) {
                com.vivo.push.util.w.a("BaseAppCommand", "pkg name is null");
                strA = a();
                if (TextUtils.isEmpty(strA)) {
                    com.vivo.push.util.w.a("BaseAppCommand", "src is null");
                    return -1;
                }
            }
            this.f16497d = ad.b(context, strA);
            if (!TextUtils.isEmpty(this.f16499f)) {
                this.f16497d = 2;
            }
        }
        return this.f16497d;
    }

    public final void b(int i9) {
        this.f16498e = i9;
    }

    public final void c(String str) {
        this.f16501h = str;
    }

    public final void d(String str) {
        this.f16500g = str;
    }

    public final int e() {
        return this.f16498e;
    }

    public final void f() {
        this.f16499f = null;
    }

    public final String g() {
        return this.f16494a;
    }

    @Override // com.vivo.push.w
    public String toString() {
        return "BaseAppCommand";
    }

    public final void b(String str) {
        this.f16494a = str;
    }

    @Override // com.vivo.push.w
    public void c(com.vivo.push.d dVar) {
        dVar.a("req_id", this.f16494a);
        dVar.a(Constants.PACKAGE_NAME, this.f16495b);
        dVar.a(HianalyticsBaseData.SDK_VERSION, 363L);
        dVar.a("PUSH_APP_STATUS", this.f16497d);
        if (!TextUtils.isEmpty(this.f16499f)) {
            dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f16499f);
        }
        dVar.a("BaseAppCommand.EXTRA_APPID", this.f16501h);
        dVar.a("BaseAppCommand.EXTRA_APPKEY", this.f16500g);
    }

    @Override // com.vivo.push.w
    public void d(com.vivo.push.d dVar) {
        this.f16494a = dVar.a("req_id");
        this.f16495b = dVar.a(Constants.PACKAGE_NAME);
        this.f16496c = dVar.b(HianalyticsBaseData.SDK_VERSION, 0L);
        this.f16497d = dVar.b("PUSH_APP_STATUS", 0);
        this.f16499f = dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.f16501h = dVar.a("BaseAppCommand.EXTRA_APPID");
        this.f16500g = dVar.a("BaseAppCommand.EXTRA_APPKEY");
    }
}
