package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: MenuAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f6119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6120b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f6123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6124f;

    public e(f fVar, LayoutInflater layoutInflater, boolean z8, int i9) {
        this.f6122d = z8;
        this.f6123e = layoutInflater;
        this.f6119a = fVar;
        this.f6124f = i9;
        b();
    }

    public final void b() {
        f fVar = this.f6119a;
        h hVar = fVar.f6146w;
        if (hVar != null) {
            fVar.i();
            ArrayList<h> arrayList = fVar.j;
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                if (arrayList.get(i9) == hVar) {
                    this.f6120b = i9;
                    return;
                }
            }
        }
        this.f6120b = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final h getItem(int i9) {
        ArrayList<h> arrayListL;
        f fVar = this.f6119a;
        if (this.f6122d) {
            fVar.i();
            arrayListL = fVar.j;
        } else {
            arrayListL = fVar.l();
        }
        int i10 = this.f6120b;
        if (i10 >= 0 && i9 >= i10) {
            i9++;
        }
        return arrayListL.get(i9);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<h> arrayListL;
        f fVar = this.f6119a;
        if (this.f6122d) {
            fVar.i();
            arrayListL = fVar.j;
        } else {
            arrayListL = fVar.l();
        }
        return this.f6120b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        return i9;
    }

    @Override // android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        boolean z8 = false;
        if (view == null) {
            view = this.f6123e.inflate(this.f6124f, viewGroup, false);
        }
        int i10 = getItem(i9).f6156b;
        int i11 = i9 - 1;
        int i12 = i11 >= 0 ? getItem(i11).f6156b : i10;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f6119a.m() && i10 != i12) {
            z8 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z8);
        k.a aVar = (k.a) view;
        if (this.f6121c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i9));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
