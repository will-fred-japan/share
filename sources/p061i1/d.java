package p061i1;

import org.json.JSONObject;
import p115p1.a;
import p124q1.c;

/* JADX INFO: compiled from: ApmAgent.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f19219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f19220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f19221d;

    public d(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.f19218a = str;
        this.f19219b = jSONObject;
        this.f19220c = jSONObject2;
        this.f19221d = jSONObject3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.g().c(new c(this.f19218a, 0, null, this.f19219b, this.f19220c, this.f19221d));
    }
}
