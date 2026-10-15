package com.hihonor.push.sdk;

import android.util.Log;
import com.hihonor.push.sdk.common.PushTokenResult;

/* JADX INFO: loaded from: classes.dex */
public class g1 extends i1<PushTokenResult> {
    public g1(String str, e eVar) {
        super(str, eVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.hihonor.push.sdk.i1
    public void a(j jVar, Object obj) {
        if (jVar == null) {
            jVar = k.ERROR_UNKNOWN.a();
        }
        int i9 = jVar.f14502a;
        k kVar = k.SUCCESS;
        if (i9 == 0) {
            if (obj instanceof PushTokenResult) {
                this.f14497a.a((TResult) ((PushTokenResult) obj));
                return;
            }
            jVar = k.ERROR_INTERNAL_ERROR.a();
        }
        Log.e("GetPushTokenTask", "task execute failed. error:" + jVar.f14502a);
        this.f14497a.a((Exception) jVar);
    }
}
