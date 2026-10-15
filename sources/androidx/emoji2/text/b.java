package androidx.emoji2.text;

import android.os.Build;
import java.util.ArrayList;
import p022d0.f;
import p022d0.g;
import p022d0.i;

/* JADX INFO: compiled from: EmojiCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f7368a;

    public b(c.a aVar) {
        this.f7368a = aVar;
    }

    @Override // androidx.emoji2.text.c.h
    public final void a(Throwable th) {
        this.f7368a.f7381a.d(th);
    }

    @Override // androidx.emoji2.text.c.h
    public final void b(i iVar) {
        c.a aVar = this.f7368a;
        aVar.f7380c = iVar;
        i iVar2 = aVar.f7380c;
        c cVar = aVar.f7381a;
        aVar.f7379b = new g(iVar2, cVar.f7376g, cVar.f7378i, Build.VERSION.SDK_INT >= 34 ? p022d0.e.a() : f.a());
        c cVar2 = aVar.f7381a;
        cVar2.getClass();
        ArrayList arrayList = new ArrayList();
        cVar2.f7370a.writeLock().lock();
        try {
            cVar2.f7372c = 1;
            arrayList.addAll(cVar2.f7371b);
            cVar2.f7371b.clear();
            cVar2.f7370a.writeLock().unlock();
            cVar2.f7373d.post(new c.f(arrayList, cVar2.f7372c, null));
        } catch (Throwable th) {
            cVar2.f7370a.writeLock().unlock();
            throw th;
        }
    }
}
