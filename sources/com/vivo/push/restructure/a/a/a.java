package com.vivo.push.restructure.a.a;

import android.content.Intent;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.vivo.push.util.w;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbstractMessageNodeMonitor.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f16731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16732b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f16735e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f16737g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16733c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16734d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16736f = false;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Lcom/vivo/push/restructure/a/a/i;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public a(String str, com.vivo.push.restructure.a.a aVar, j jVar) {
        this.f16732b = str;
        this.f16731a = aVar;
        this.f16735e = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f16734d = a(this.f16731a);
        this.f16733c = System.currentTimeMillis() - jCurrentTimeMillis;
        int i9 = this.f16734d;
        if (i9 != 0) {
            i iVar = this.f16735e;
            if (iVar != null) {
                iVar.a(this, this.f16731a, i9);
                return;
            }
            return;
        }
        a aVar = this.f16737g;
        if (aVar != null) {
            aVar.a();
            return;
        }
        i iVar2 = this.f16735e;
        if (iVar2 != null) {
            iVar2.a(this.f16731a);
        }
    }

    public abstract int a(T t);

    public final void a(a aVar) {
        if (this != aVar) {
            this.f16737g = aVar;
        }
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (a<T> aVar = this; aVar != null; aVar = aVar.f16737g) {
            try {
                jSONArray.put(aVar.b());
            } catch (Exception e9) {
                w.a("AbstractMessageNodeMoni", e9);
            }
        }
        return jSONArray;
    }

    public final void a(long j) {
        this.f16733c = j;
    }

    public synchronized String b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(MTCommonConstants.Network.KEY_NAME, this.f16732b);
            jSONObject.put("code", this.f16734d);
            jSONObject.put("cost", this.f16733c);
        } catch (Exception e9) {
            w.a("AbstractMessageNodeMoni", e9);
        }
        return jSONObject.toString();
    }

    public static boolean a(Intent intent) {
        return intent != null && "com.vivo.push.sdk.action.receive_extension_message".equals(intent.getAction());
    }

    public final void a() {
        if (this.f16736f) {
            com.vivo.push.util.i.a().execute(new b(this));
        } else {
            d();
        }
    }
}
