package U0;

import android.text.TextUtils;

/* JADX INFO: compiled from: CacheHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements d.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4607a;

    public e(d dVar) {
        this.f4607a = dVar;
    }

    @Override // U0.d.b
    public final boolean a(String str) {
        return !TextUtils.isEmpty(str);
    }

    @Override // U0.d.b
    public final void b(String str) {
        this.f4607a.c("device_id", str);
    }

    @Override // U0.d.b
    public final String c(Object obj, String str, a aVar) {
        String str2 = (String) obj;
        return aVar == null ? str2 : (String) aVar.a(str2, str, new e(aVar));
    }

    @Override // U0.d.b
    public final boolean a(String str, String str2) {
        return V0.o.f(str, str2);
    }

    @Override // U0.d.b
    public final String a() {
        return this.f4607a.d("device_id");
    }
}
