package com.vivo.push.b;

import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: ReporterCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class z extends com.vivo.push.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f16547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16548b;

    public z() {
        super(2012);
    }

    public final void a(HashMap<String, String> map) {
        this.f16547a = map;
    }

    @Override // com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        dVar.a("ReporterCommand.EXTRA_PARAMS", this.f16547a);
        dVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f16548b);
    }

    @Override // com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        this.f16547a = (HashMap) dVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f16548b = dVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f16548b);
    }

    public final void e() {
        if (this.f16547a == null) {
            com.vivo.push.util.w.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.f16548b);
        sb.append(",msgId:");
        String str = this.f16547a.get(com.heytap.mcssdk.constant.b.f14286c);
        if (TextUtils.isEmpty(str)) {
            str = this.f16547a.get(MTPushConstants.Message.KEY_MESSAGE_ID);
        }
        sb.append(str);
        com.vivo.push.util.w.d("ReporterCommand", sb.toString());
    }

    @Override // com.vivo.push.w
    public final String toString() {
        return W5.e.m(new StringBuilder("ReporterCommand（"), this.f16548b, ")");
    }

    public z(long j) {
        this();
        this.f16548b = j;
    }
}
