package p115p1;

import org.json.JSONObject;
import p061i1.h;
import p107o1.b;

/* JADX INFO: compiled from: CommonDataPipeline.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends p107o1.a<b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f20773e;

    public static a g() {
        if (f20773e == null) {
            synchronized (a.class) {
                try {
                    if (f20773e == null) {
                        f20773e = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f20773e;
    }

    @Override // p107o1.a
    public final void d(b bVar) {
        JSONObject jSONObjectA = bVar.a();
        boolean zB = bVar.b();
        if (h.f19230b) {
            p199z2.b.i("<monitor><flow>", "logType: " + bVar.g() + ", subType: " + bVar.d() + "data: " + jSONObjectA, " ,sample: " + zB);
        }
        p107o1.a.a(bVar.g(), bVar.d(), jSONObjectA, zB);
    }
}
