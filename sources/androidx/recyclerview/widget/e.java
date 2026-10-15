package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f8214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f8215b;

    public e(k kVar, ArrayList arrayList) {
        this.f8215b = kVar;
        this.f8214a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f8214a;
        Iterator it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            k kVar = this.f8215b;
            if (!zHasNext) {
                arrayList.clear();
                kVar.f8242l.remove(arrayList);
                return;
            }
            RecyclerView.y yVar = (RecyclerView.y) it.next();
            kVar.getClass();
            View view = yVar.f8129a;
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            kVar.f8245o.add(yVar);
            viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(kVar.f8047c).setListener(new g(view, viewPropertyAnimatorAnimate, kVar, yVar)).start();
        }
    }
}
