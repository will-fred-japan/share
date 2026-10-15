package p097n;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;

/* JADX INFO: compiled from: MenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements f, j, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f20542a;

    public static int m(ListAdapter listAdapter, Context context, int i9) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i10 = 0;
        int i11 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i12 = 0; i12 < count; i12++) {
            int itemViewType = listAdapter.getItemViewType(i12);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i12, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i9) {
                return i9;
            }
            if (measuredWidth > i10) {
                i10 = measuredWidth;
            }
        }
        return i10;
    }

    public static boolean u(f fVar) {
        int size = fVar.f6131f.size();
        for (int i9 = 0; i9 < size; i9++) {
            MenuItem item = fVar.getItem(i9);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean k(h hVar) {
        return false;
    }

    public abstract void l(f fVar);

    public abstract void n(View view);

    public abstract void o(boolean z8);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i9, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (e) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (e) listAdapter).f6119a.q((MenuItem) listAdapter.getItem(i9), this, !(this instanceof b) ? 0 : 4);
    }

    public abstract void p(int i9);

    public abstract void q(int i9);

    public abstract void r(PopupWindow.OnDismissListener onDismissListener);

    public abstract void s(boolean z8);

    public abstract void t(int i9);

    @Override // androidx.appcompat.view.menu.j
    public final void e(Context context, f fVar) {
    }
}
