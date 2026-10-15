package p061i1;

import org.json.JSONObject;
import p115p1.a;
import p124q1.c;

/* JADX INFO: compiled from: ApmAgent.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f19212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f19213d;

    public b(String str, int i9, JSONObject jSONObject, JSONObject jSONObject2) {
        this.f19210a = str;
        this.f19211b = i9;
        this.f19212c = jSONObject;
        this.f19213d = jSONObject2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.g().c(new c(this.f19210a, this.f19211b, this.f19212c, null, null, this.f19213d));
    }
}
