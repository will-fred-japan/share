package p061i1;

import org.json.JSONObject;
import p124q1.c;
import p124q1.g;

/* JADX INFO: compiled from: ApmAgent.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19206a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f19208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f19209d;

    public a(String str, String str2, JSONObject jSONObject) {
        this.f19207b = str;
        this.f19209d = str2;
        this.f19208c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19206a) {
            case 0:
                p115p1.a.g().c(new c(this.f19207b, 0, this.f19208c, null, null, (JSONObject) this.f19209d));
                break;
            default:
                p115p1.a aVarG = p115p1.a.g();
                g gVar = new g();
                gVar.f20902a = this.f19207b;
                gVar.f20903b = (String) this.f19209d;
                gVar.f20904c = this.f19208c;
                gVar.f20905d = null;
                aVarG.c(gVar);
                break;
        }
    }

    public a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        this.f19207b = str;
        this.f19208c = jSONObject;
        this.f19209d = jSONObject2;
    }
}
