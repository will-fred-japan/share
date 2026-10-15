package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: LogCatNode.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f14868a;

    @Override // com.huawei.hms.base.log.d
    public void a(Context context, String str) {
        d dVar = this.f14868a;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d dVar) {
        this.f14868a = dVar;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String str, int i9, String str2, String str3) {
        Log.println(i9, "HMSSDK_" + str2, str3);
        d dVar = this.f14868a;
        if (dVar != null) {
            dVar.a(str, i9, str2, str3);
        }
    }
}
