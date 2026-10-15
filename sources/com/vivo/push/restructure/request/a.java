package com.vivo.push.restructure.request;

import android.content.Intent;
import android.os.Bundle;
import com.vivo.push.restructure.request.a.a.b;

/* JADX INFO: compiled from: BaseCommand.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private I f16771b;

    public a(int i9, I i10) {
        this.f16770a = i9;
        this.f16771b = i10;
    }

    public final Intent a(int i9) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("client_pkgname", com.vivo.push.restructure.a.a().b().getPackageName());
        bundle.putBoolean("support_rf", true);
        com.vivo.push.restructure.request.a.c cVar = new com.vivo.push.restructure.request.a.c(this.f16770a, i9);
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        cVar.a(aVar);
        bundle.putString("cf_content", aVar.e());
        com.vivo.push.restructure.request.a.a.a aVar2 = new com.vivo.push.restructure.request.a.a.a();
        this.f16771b.a(aVar2);
        bundle.putString("content", aVar2.e());
        intent.putExtras(bundle);
        return intent;
    }

    public abstract O a(com.vivo.push.restructure.request.a.a.a aVar);
}
