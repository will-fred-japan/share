package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: SimpleItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class z extends RecyclerView.i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8337g;

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean a(RecyclerView.y yVar, RecyclerView.y yVar2, RecyclerView.i.b bVar, RecyclerView.i.b bVar2) {
        int i9;
        int i10;
        int i11 = bVar.f8051a;
        int i12 = bVar.f8052b;
        if (yVar2.o()) {
            int i13 = bVar.f8051a;
            i10 = bVar.f8052b;
            i9 = i13;
        } else {
            i9 = bVar2.f8051a;
            i10 = bVar2.f8052b;
        }
        k kVar = (k) this;
        if (yVar == yVar2) {
            return kVar.g(yVar, i11, i12, i9, i10);
        }
        View view = yVar.f8129a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        kVar.l(yVar);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        kVar.l(yVar2);
        float f6 = -((int) ((i9 - i11) - translationX));
        View view2 = yVar2.f8129a;
        view2.setTranslationX(f6);
        view2.setTranslationY(-((int) ((i10 - i12) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList<k.a> arrayList = kVar.f8241k;
        k.a aVar = new k.a();
        aVar.f8249a = yVar;
        aVar.f8250b = yVar2;
        aVar.f8251c = i11;
        aVar.f8252d = i12;
        aVar.f8253e = i9;
        aVar.f8254f = i10;
        arrayList.add(aVar);
        return true;
    }

    public abstract boolean g(RecyclerView.y yVar, int i9, int i10, int i11, int i12);
}
