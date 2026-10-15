package Q;

import java.util.ArrayList;

/* JADX INFO: compiled from: FontRequestWorker.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements S.a<k.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3672a;

    public j(String str) {
        this.f3672a = str;
    }

    @Override // S.a
    public final void accept(k.a aVar) {
        k.a aVar2 = aVar;
        synchronized (k.f3675c) {
            try {
                p155u.g<String, ArrayList<S.a<k.a>>> gVar = k.f3676d;
                ArrayList<S.a<k.a>> arrayList = gVar.get(this.f3672a);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.f3672a);
                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                    arrayList.get(i9).accept(aVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
