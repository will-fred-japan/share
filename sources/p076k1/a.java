package p076k1;

import java.util.HashMap;

/* JADX INFO: compiled from: FpsAggregateManger.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f19914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f19915c;

    public a(b bVar, String str, float f6) {
        this.f19915c = bVar;
        this.f19913a = str;
        this.f19914b = f6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f19915c;
        HashMap<String, b.a> map = bVar.f19916a;
        String str = this.f19913a;
        b.a aVar = map.get(str);
        float f6 = this.f19914b;
        if (aVar != null) {
            aVar.f19917a += f6;
            aVar.f19919c++;
            return;
        }
        b.a aVar2 = new b.a();
        aVar2.f19917a = f6;
        aVar2.f19918b = System.currentTimeMillis();
        aVar2.f19919c = 1;
        bVar.f19916a.put(str, aVar2);
    }
}
