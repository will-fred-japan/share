package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.w;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: NodeSaveImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, m> f16752a = new ConcurrentHashMap();

    @Override // com.vivo.push.restructure.a.a.n
    public final void a(com.vivo.push.restructure.a.a aVar, a aVar2) {
        if (aVar == null) {
            w.d("addToCache error. msg is null");
        } else if (TextUtils.isEmpty(aVar.a())) {
            w.d("addToCache error. messageID is null");
        } else if (aVar2 == null) {
            w.d("addToCache error. firstNode is null");
        }
    }
}
