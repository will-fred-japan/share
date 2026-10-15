package com.vivo.push.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: MsgArriveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends com.vivo.push.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16504b;

    public h() {
        super(2013);
    }

    @Override // com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        dVar.a("MsgArriveCommand.MSG_TAG", this.f16503a);
        if (TextUtils.isEmpty(this.f16504b)) {
            return;
        }
        dVar.a("MsgArriveCommand.NODE_INFO", this.f16504b);
    }

    @Override // com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        this.f16503a = dVar.a("MsgArriveCommand.MSG_TAG");
        this.f16504b = dVar.a("MsgArriveCommand.NODE_INFO");
    }

    public h(String str) {
        this();
        this.f16503a = str;
    }

    public h(String str, String str2) {
        this(str);
        this.f16504b = str2;
    }
}
