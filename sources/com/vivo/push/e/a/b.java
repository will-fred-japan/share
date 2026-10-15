package com.vivo.push.e.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: SyncProfileInfoInputDS.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<b> f16580a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<com.vivo.push.e.b> f16582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16583d;

    public b(String str, List<com.vivo.push.e.b> list, int i9) {
        new ArrayList();
        this.f16581b = str;
        this.f16583d = i9;
        this.f16582c = list;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f16581b);
        aVar.a(this.f16583d);
        aVar.a(this.f16582c);
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.vivo.push.e.b> it = this.f16582c.iterator();
        while (it.hasNext()) {
            String strB = it.next().b();
            if (!TextUtils.isEmpty(strB)) {
                arrayList.add(strB);
            }
        }
        return arrayList;
    }

    public b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f16582c = new ArrayList();
        this.f16581b = aVar.c();
        this.f16583d = aVar.a();
        aVar.a(com.vivo.push.e.b.f16584a, this.f16582c);
    }
}
