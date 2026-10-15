package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0551c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f8210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f8211b;

    public RunnableC0551c(k kVar, ArrayList arrayList) {
        this.f8211b = kVar;
        this.f8210a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f8210a;
        Iterator it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            k kVar = this.f8211b;
            if (!zHasNext) {
                arrayList.clear();
                kVar.f8243m.remove(arrayList);
                return;
            }
            k.b bVar = (k.b) it.next();
            RecyclerView.y yVar = bVar.f8255a;
            kVar.getClass();
            View view = yVar.f8129a;
            int i9 = bVar.f8258d - bVar.f8256b;
            int i10 = bVar.f8259e - bVar.f8257c;
            if (i9 != 0) {
                view.animate().translationX(0.0f);
            }
            if (i10 != 0) {
                view.animate().translationY(0.0f);
            }
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            kVar.f8246p.add(yVar);
            viewPropertyAnimatorAnimate.setDuration(kVar.f8049e).setListener(new h(kVar, yVar, i9, view, i10, viewPropertyAnimatorAnimate)).start();
        }
    }
}
