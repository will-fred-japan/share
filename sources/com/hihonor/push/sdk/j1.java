package com.hihonor.push.sdk;

import android.util.Log;
import com.hihonor.push.sdk.common.BaseResult;

/* JADX INFO: loaded from: classes.dex */
public class j1 extends i1<BaseResult> {
    public j1(String str, e eVar) {
        super(str, eVar);
    }

    @Override // com.hihonor.push.sdk.i1
    public void a(j jVar, Object obj) {
        if (jVar == null) {
            jVar = k.ERROR_UNKNOWN.a();
        }
        int i9 = jVar.f14502a;
        k kVar = k.SUCCESS;
        if (i9 == 0) {
            this.f14497a.a((Object) null);
            return;
        }
        Log.e("VoidTask", "task execute failed. error:" + jVar.f14502a);
        this.f14497a.a((Exception) jVar);
    }
}
