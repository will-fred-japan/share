package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class k extends z {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f8238s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<RecyclerView.y> f8239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<RecyclerView.y> f8240i;
    public ArrayList<b> j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<a> f8241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<ArrayList<RecyclerView.y>> f8242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<ArrayList<b>> f8243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<ArrayList<a>> f8244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<RecyclerView.y> f8245o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<RecyclerView.y> f8246p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<RecyclerView.y> f8247q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<RecyclerView.y> f8248r;

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.y f8249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.y f8250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8254f;

        public final String toString() {
            StringBuilder sb = new StringBuilder("ChangeInfo{oldHolder=");
            sb.append(this.f8249a);
            sb.append(", newHolder=");
            sb.append(this.f8250b);
            sb.append(", fromX=");
            sb.append(this.f8251c);
            sb.append(", fromY=");
            sb.append(this.f8252d);
            sb.append(", toX=");
            sb.append(this.f8253e);
            sb.append(", toY=");
            return H2.a.a(sb, this.f8254f, '}');
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.y f8255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8259e;
    }

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((RecyclerView.y) arrayList.get(size)).f8129a.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final void d(RecyclerView.y yVar) {
        View view = yVar.f8129a;
        view.animate().cancel();
        ArrayList<b> arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (arrayList.get(size).f8255a == yVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(yVar);
                arrayList.remove(size);
            }
        }
        j(this.f8241k, yVar);
        if (this.f8239h.remove(yVar)) {
            view.setAlpha(1.0f);
            c(yVar);
        }
        if (this.f8240i.remove(yVar)) {
            view.setAlpha(1.0f);
            c(yVar);
        }
        ArrayList<ArrayList<a>> arrayList2 = this.f8244n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList3 = arrayList2.get(size2);
            j(arrayList3, yVar);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList<ArrayList<b>> arrayList4 = this.f8243m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList5 = arrayList4.get(size3);
            for (int size4 = arrayList5.size() - 1; size4 >= 0; size4--) {
                if (arrayList5.get(size4).f8255a == yVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(yVar);
                    arrayList5.remove(size4);
                    if (!arrayList5.isEmpty()) {
                        break;
                    }
                    arrayList4.remove(size3);
                    break;
                }
            }
        }
        ArrayList<ArrayList<RecyclerView.y>> arrayList6 = this.f8242l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.y> arrayList7 = arrayList6.get(size5);
            if (arrayList7.remove(yVar)) {
                view.setAlpha(1.0f);
                c(yVar);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f8247q.remove(yVar);
        this.f8245o.remove(yVar);
        this.f8248r.remove(yVar);
        this.f8246p.remove(yVar);
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final void e() {
        ArrayList<b> arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = arrayList.get(size);
            View view = bVar.f8255a.f8129a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(bVar.f8255a);
            arrayList.remove(size);
        }
        ArrayList<RecyclerView.y> arrayList2 = this.f8239h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c(arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList<RecyclerView.y> arrayList3 = this.f8240i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.y yVar = arrayList3.get(size3);
            yVar.f8129a.setAlpha(1.0f);
            c(yVar);
            arrayList3.remove(size3);
        }
        ArrayList<a> arrayList4 = this.f8241k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            a aVar = arrayList4.get(size4);
            RecyclerView.y yVar2 = aVar.f8249a;
            if (yVar2 != null) {
                k(aVar, yVar2);
            }
            RecyclerView.y yVar3 = aVar.f8250b;
            if (yVar3 != null) {
                k(aVar, yVar3);
            }
        }
        arrayList4.clear();
        if (f()) {
            ArrayList<ArrayList<b>> arrayList5 = this.f8243m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList6 = arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList6.get(size6);
                    View view2 = bVar2.f8255a.f8129a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(bVar2.f8255a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList<ArrayList<RecyclerView.y>> arrayList7 = this.f8242l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.y> arrayList8 = arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.y yVar4 = arrayList8.get(size8);
                    yVar4.f8129a.setAlpha(1.0f);
                    c(yVar4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList<ArrayList<a>> arrayList9 = this.f8244n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList10 = arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    a aVar2 = arrayList10.get(size10);
                    RecyclerView.y yVar5 = aVar2.f8249a;
                    if (yVar5 != null) {
                        k(aVar2, yVar5);
                    }
                    RecyclerView.y yVar6 = aVar2.f8250b;
                    if (yVar6 != null) {
                        k(aVar2, yVar6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            h(this.f8247q);
            h(this.f8246p);
            h(this.f8245o);
            h(this.f8248r);
            ArrayList<RecyclerView.i.a> arrayList11 = this.f8046b;
            int size11 = arrayList11.size();
            for (int i9 = 0; i9 < size11; i9++) {
                arrayList11.get(i9).a();
            }
            arrayList11.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean f() {
        return (this.f8240i.isEmpty() && this.f8241k.isEmpty() && this.j.isEmpty() && this.f8239h.isEmpty() && this.f8246p.isEmpty() && this.f8247q.isEmpty() && this.f8245o.isEmpty() && this.f8248r.isEmpty() && this.f8243m.isEmpty() && this.f8242l.isEmpty() && this.f8244n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.z
    public final boolean g(RecyclerView.y yVar, int i9, int i10, int i11, int i12) {
        View view = yVar.f8129a;
        int translationX = i9 + ((int) view.getTranslationX());
        int translationY = i10 + ((int) yVar.f8129a.getTranslationY());
        l(yVar);
        int i13 = i11 - translationX;
        int i14 = i12 - translationY;
        if (i13 == 0 && i14 == 0) {
            c(yVar);
            return false;
        }
        if (i13 != 0) {
            view.setTranslationX(-i13);
        }
        if (i14 != 0) {
            view.setTranslationY(-i14);
        }
        ArrayList<b> arrayList = this.j;
        b bVar = new b();
        bVar.f8255a = yVar;
        bVar.f8256b = translationX;
        bVar.f8257c = translationY;
        bVar.f8258d = i11;
        bVar.f8259e = i12;
        arrayList.add(bVar);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList<RecyclerView.i.a> arrayList = this.f8046b;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.get(i9).a();
        }
        arrayList.clear();
    }

    public final void j(ArrayList arrayList, RecyclerView.y yVar) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            if (k(aVar, yVar) && aVar.f8249a == null && aVar.f8250b == null) {
                arrayList.remove(aVar);
            }
        }
    }

    public final boolean k(a aVar, RecyclerView.y yVar) {
        if (aVar.f8250b == yVar) {
            aVar.f8250b = null;
        } else {
            if (aVar.f8249a != yVar) {
                return false;
            }
            aVar.f8249a = null;
        }
        yVar.f8129a.setAlpha(1.0f);
        View view = yVar.f8129a;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        c(yVar);
        return true;
    }

    public final void l(RecyclerView.y yVar) {
        if (f8238s == null) {
            f8238s = new ValueAnimator().getInterpolator();
        }
        yVar.f8129a.animate().setInterpolator(f8238s);
        d(yVar);
    }
}
