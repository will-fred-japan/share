package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.w;

/* JADX INFO: compiled from: NodeReportItem.java */
/* JADX INFO: loaded from: classes.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16751b;

    public m(com.vivo.push.restructure.a.a aVar, String str) {
        if (aVar != null) {
            this.f16750a = aVar.a();
        }
        this.f16751b = str;
    }

    public final com.vivo.push.b.h a() {
        if (!TextUtils.isEmpty(this.f16750a) && !TextUtils.isEmpty(this.f16751b)) {
            return new com.vivo.push.b.h(this.f16750a, this.f16751b);
        }
        w.d("convertOffLineMsg() error, mMessageID = " + this.f16750a + ", mNodeArrayInfo = " + this.f16751b);
        return null;
    }
}
