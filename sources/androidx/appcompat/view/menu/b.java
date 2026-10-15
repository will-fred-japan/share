package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.A;
import androidx.appcompat.widget.C0498j;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.v;
import cn.ikaile.ruoshui.client.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends p097n.d implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f6082f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f6089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f6090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6092q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6093r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6094s;
    public int t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6096v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public j.a f6097w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewTreeObserver f6098x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public i.a f6099y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6100z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f6083g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f6084h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f6085i = new a();
    public final ViewOnAttachStateChangeListenerC0093b j = new ViewOnAttachStateChangeListenerC0093b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f6086k = new c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6087l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6088m = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6095u = false;

    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            b bVar = b.this;
            if (bVar.b()) {
                ArrayList arrayList = bVar.f6084h;
                if (arrayList.size() <= 0 || ((d) arrayList.get(0)).f6104a.f6730y) {
                    return;
                }
                View view = bVar.f6090o;
                if (view == null || !view.isShown()) {
                    bVar.dismiss();
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f6104a.d();
                }
            }
        }
    }

    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    public class c implements A {
        public c() {
        }

        @Override // androidx.appcompat.widget.A
        public final void a(f fVar, h hVar) {
            b bVar = b.this;
            bVar.f6082f.removeCallbacksAndMessages(null);
            ArrayList arrayList = bVar.f6084h;
            int size = arrayList.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    i9 = -1;
                    break;
                } else if (fVar == ((d) arrayList.get(i9)).f6105b) {
                    break;
                } else {
                    i9++;
                }
            }
            if (i9 == -1) {
                return;
            }
            int i10 = i9 + 1;
            bVar.f6082f.postAtTime(new androidx.appcompat.view.menu.c(this, i10 < arrayList.size() ? (d) arrayList.get(i10) : null, hVar, fVar), fVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.A
        public final void n(f fVar, h hVar) {
            b.this.f6082f.removeCallbacksAndMessages(fVar);
        }
    }

    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f6104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f6105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6106c;

        public d(MenuPopupWindow menuPopupWindow, f fVar, int i9) {
            this.f6104a = menuPopupWindow;
            this.f6105b = fVar;
            this.f6106c = i9;
        }
    }

    public b(Context context, View view, int i9, boolean z8) {
        this.f6078b = context;
        this.f6089n = view;
        this.f6080d = i9;
        this.f6081e = z8;
        this.f6091p = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f6079c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f6082f = new Handler();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f fVar, boolean z8) {
        ArrayList arrayList = this.f6084h;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                i9 = -1;
                break;
            } else if (fVar == ((d) arrayList.get(i9)).f6105b) {
                break;
            } else {
                i9++;
            }
        }
        if (i9 < 0) {
            return;
        }
        int i10 = i9 + 1;
        if (i10 < arrayList.size()) {
            ((d) arrayList.get(i10)).f6105b.c(false);
        }
        d dVar = (d) arrayList.remove(i9);
        dVar.f6105b.r(this);
        boolean z9 = this.f6100z;
        MenuPopupWindow menuPopupWindow = dVar.f6104a;
        if (z9) {
            MenuPopupWindow.a.b(menuPopupWindow.f6731z, null);
            menuPopupWindow.f6731z.setAnimationStyle(0);
        }
        menuPopupWindow.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f6091p = ((d) arrayList.get(size2 - 1)).f6106c;
        } else {
            this.f6091p = this.f6089n.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z8) {
                ((d) arrayList.get(0)).f6105b.c(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.f6097w;
        if (aVar != null) {
            aVar.a(fVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f6098x;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f6098x.removeGlobalOnLayoutListener(this.f6085i);
            }
            this.f6098x = null;
        }
        this.f6090o.removeOnAttachStateChangeListener(this.j);
        this.f6099y.onDismiss();
    }

    @Override // p097n.f
    public final boolean b() {
        ArrayList arrayList = this.f6084h;
        return arrayList.size() > 0 && ((d) arrayList.get(0)).f6104a.f6731z.isShowing();
    }

    @Override // p097n.f
    public final void d() {
        if (b()) {
            return;
        }
        ArrayList arrayList = this.f6083g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v((f) it.next());
        }
        arrayList.clear();
        View view = this.f6089n;
        this.f6090o = view;
        if (view != null) {
            boolean z8 = this.f6098x == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f6098x = viewTreeObserver;
            if (z8) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f6085i);
            }
            this.f6090o.addOnAttachStateChangeListener(this.j);
        }
    }

    @Override // p097n.f
    public final void dismiss() {
        ArrayList arrayList = this.f6084h;
        int size = arrayList.size();
        if (size > 0) {
            d[] dVarArr = (d[]) arrayList.toArray(new d[size]);
            for (int i9 = size - 1; i9 >= 0; i9--) {
                d dVar = dVarArr[i9];
                if (dVar.f6104a.f6731z.isShowing()) {
                    dVar.f6104a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void f() {
        Iterator it = this.f6084h.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((d) it.next()).f6104a.f6710c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((e) adapter).notifyDataSetChanged();
        }
    }

    @Override // p097n.f
    public final v g() {
        ArrayList arrayList = this.f6084h;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((d) arrayList.get(arrayList.size() - 1)).f6104a.f6710c;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean h(m mVar) {
        for (d dVar : this.f6084h) {
            if (mVar == dVar.f6105b) {
                dVar.f6104a.f6710c.requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        l(mVar);
        j.a aVar = this.f6097w;
        if (aVar != null) {
            aVar.b(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void j(j.a aVar) {
        this.f6097w = aVar;
    }

    @Override // p097n.d
    public final void l(f fVar) {
        fVar.b(this, this.f6078b);
        if (b()) {
            v(fVar);
        } else {
            this.f6083g.add(fVar);
        }
    }

    @Override // p097n.d
    public final void n(View view) {
        if (this.f6089n != view) {
            this.f6089n = view;
            this.f6088m = Gravity.getAbsoluteGravity(this.f6087l, view.getLayoutDirection());
        }
    }

    @Override // p097n.d
    public final void o(boolean z8) {
        this.f6095u = z8;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        d dVar;
        ArrayList arrayList = this.f6084h;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) arrayList.get(i9);
            if (!dVar.f6104a.f6731z.isShowing()) {
                break;
            } else {
                i9++;
            }
        }
        if (dVar != null) {
            dVar.f6105b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i9, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i9 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // p097n.d
    public final void p(int i9) {
        if (this.f6087l != i9) {
            this.f6087l = i9;
            this.f6088m = Gravity.getAbsoluteGravity(i9, this.f6089n.getLayoutDirection());
        }
    }

    @Override // p097n.d
    public final void q(int i9) {
        this.f6092q = true;
        this.f6094s = i9;
    }

    @Override // p097n.d
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f6099y = (i.a) onDismissListener;
    }

    @Override // p097n.d
    public final void s(boolean z8) {
        this.f6096v = z8;
    }

    @Override // p097n.d
    public final void t(int i9) {
        this.f6093r = true;
        this.t = i9;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:53:0x010d  */
    /* JADX WARN: Code duplicated, block: B:56:0x013c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0148  */
    /* JADX WARN: Code duplicated, block: B:59:0x014b  */
    /* JADX WARN: Code duplicated, block: B:60:0x014e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0156  */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Code duplicated, block: B:68:0x0163 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0166  */
    /* JADX WARN: Code duplicated, block: B:71:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x016f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0174  */
    /* JADX WARN: Code duplicated, block: B:75:0x0181  */
    /* JADX WARN: Code duplicated, block: B:77:0x0185  */
    /* JADX WARN: Code duplicated, block: B:80:0x018d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0196  */
    /* JADX WARN: Code duplicated, block: B:84:0x019c  */
    /* JADX WARN: Code duplicated, block: B:94:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void v(f fVar) {
        int i9;
        d dVar;
        View childAt;
        Rect rect;
        Rect rect2;
        int i10;
        C0498j c0498j;
        v vVar;
        int[] iArr;
        Rect rect3;
        int i11;
        int i12;
        boolean z8;
        Method method;
        MenuItem item;
        e eVar;
        int headersCount;
        int firstVisiblePosition;
        Context context = this.f6078b;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        e eVar2 = new e(fVar, layoutInflaterFrom, this.f6081e, R.layout.abc_cascading_menu_item_layout);
        if (!b() && this.f6095u) {
            eVar2.f6121c = true;
        } else if (b()) {
            eVar2.f6121c = p097n.d.u(fVar);
        }
        int iM = p097n.d.m(eVar2, context, this.f6079c);
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(context, null, this.f6080d);
        menuPopupWindow.f6441C = this.f6086k;
        menuPopupWindow.f6722p = this;
        menuPopupWindow.f6731z.setOnDismissListener(this);
        menuPopupWindow.f6721o = this.f6089n;
        menuPopupWindow.f6718l = this.f6088m;
        menuPopupWindow.f6730y = true;
        menuPopupWindow.f6731z.setFocusable(true);
        menuPopupWindow.f6731z.setInputMethodMode(2);
        menuPopupWindow.p(eVar2);
        menuPopupWindow.r(iM);
        menuPopupWindow.f6718l = this.f6088m;
        ArrayList arrayList = this.f6084h;
        if (arrayList.size() > 0) {
            dVar = (d) arrayList.get(arrayList.size() - 1);
            f fVar2 = dVar.f6105b;
            int size = fVar2.f6131f.size();
            int i13 = 0;
            while (true) {
                if (i13 >= size) {
                    item = null;
                    break;
                }
                item = fVar2.getItem(i13);
                if (item.hasSubMenu() && fVar == item.getSubMenu()) {
                    break;
                } else {
                    i13++;
                }
            }
            if (item == null) {
                i9 = 1;
                childAt = null;
            } else {
                v vVar2 = dVar.f6104a.f6710c;
                ListAdapter adapter = vVar2.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    eVar = (e) headerViewListAdapter.getWrappedAdapter();
                } else {
                    eVar = (e) adapter;
                    headersCount = 0;
                }
                int count = eVar.getCount();
                i9 = 1;
                int i14 = 0;
                while (true) {
                    if (i14 >= count) {
                        i14 = -1;
                        break;
                    } else if (item == eVar.getItem(i14)) {
                        break;
                    } else {
                        i14++;
                    }
                }
                if (i14 != -1 && (firstVisiblePosition = (i14 + headersCount) - vVar2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < vVar2.getChildCount()) {
                    childAt = vVar2.getChildAt(firstVisiblePosition);
                }
            }
            if (childAt != null) {
                i10 = Build.VERSION.SDK_INT;
                c0498j = menuPopupWindow.f6731z;
                if (i10 <= 28) {
                    method = MenuPopupWindow.f6440D;
                    if (method != null) {
                        try {
                            method.invoke(c0498j, Boolean.FALSE);
                        } catch (Exception unused) {
                            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                        }
                    }
                } else {
                    MenuPopupWindow.b.a(c0498j, false);
                }
                MenuPopupWindow.a.a(menuPopupWindow.f6731z, null);
                vVar = ((d) arrayList.get(arrayList.size() - 1)).f6104a.f6710c;
                iArr = new int[2];
                vVar.getLocationOnScreen(iArr);
                rect3 = new Rect();
                this.f6090o.getWindowVisibleDisplayFrame(rect3);
                if (this.f6091p == i9) {
                    if (vVar.getWidth() + iArr[0] + iM > rect3.right) {
                        i12 = 0;
                        i11 = 1;
                    } else {
                        i11 = 1;
                        i12 = 1;
                    }
                } else if (iArr[0] - iM < 0) {
                    i11 = 1;
                    i12 = 1;
                } else {
                    i12 = 0;
                    i11 = 1;
                }
                if (i12 == i11) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                this.f6091p = i12;
                menuPopupWindow.f6721o = childAt;
                if ((this.f6088m & 5) == 5) {
                    if (!z8) {
                        iM = 0 - childAt.getWidth();
                    }
                } else if (z8) {
                    iM = childAt.getWidth();
                } else {
                    iM = 0 - iM;
                }
                menuPopupWindow.f6713f = iM;
                menuPopupWindow.f6717k = true;
                menuPopupWindow.j = true;
                menuPopupWindow.i(0);
            } else {
                if (this.f6092q) {
                    menuPopupWindow.f6713f = this.f6094s;
                }
                if (this.f6093r) {
                    menuPopupWindow.i(this.t);
                }
                rect = this.f20542a;
                if (rect != null) {
                    rect2 = new Rect(rect);
                } else {
                    rect2 = null;
                }
                menuPopupWindow.f6729x = rect2;
            }
            arrayList.add(new d(menuPopupWindow, fVar, this.f6091p));
            menuPopupWindow.d();
            v vVar3 = menuPopupWindow.f6710c;
            vVar3.setOnKeyListener(this);
            if (dVar == null || !this.f6096v || fVar.f6137m == null) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) vVar3, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(fVar.f6137m);
            vVar3.addHeaderView(frameLayout, null, false);
            menuPopupWindow.d();
            return;
        }
        i9 = 1;
        dVar = null;
        childAt = null;
        if (childAt != null) {
            i10 = Build.VERSION.SDK_INT;
            c0498j = menuPopupWindow.f6731z;
            if (i10 <= 28) {
                method = MenuPopupWindow.f6440D;
                if (method != null) {
                    method.invoke(c0498j, Boolean.FALSE);
                }
            } else {
                MenuPopupWindow.b.a(c0498j, false);
            }
            MenuPopupWindow.a.a(menuPopupWindow.f6731z, null);
            vVar = ((d) arrayList.get(arrayList.size() - 1)).f6104a.f6710c;
            iArr = new int[2];
            vVar.getLocationOnScreen(iArr);
            rect3 = new Rect();
            this.f6090o.getWindowVisibleDisplayFrame(rect3);
            if (this.f6091p == i9) {
                if (vVar.getWidth() + iArr[0] + iM > rect3.right) {
                    i12 = 0;
                    i11 = 1;
                } else {
                    i11 = 1;
                    i12 = 1;
                }
            } else if (iArr[0] - iM < 0) {
                i11 = 1;
                i12 = 1;
            } else {
                i12 = 0;
                i11 = 1;
            }
            if (i12 == i11) {
                z8 = true;
            } else {
                z8 = false;
            }
            this.f6091p = i12;
            menuPopupWindow.f6721o = childAt;
            if ((this.f6088m & 5) == 5) {
                if (!z8) {
                    iM = 0 - childAt.getWidth();
                }
            } else if (z8) {
                iM = childAt.getWidth();
            } else {
                iM = 0 - iM;
            }
            menuPopupWindow.f6713f = iM;
            menuPopupWindow.f6717k = true;
            menuPopupWindow.j = true;
            menuPopupWindow.i(0);
        } else {
            if (this.f6092q) {
                menuPopupWindow.f6713f = this.f6094s;
            }
            if (this.f6093r) {
                menuPopupWindow.i(this.t);
            }
            rect = this.f20542a;
            if (rect != null) {
                rect2 = new Rect(rect);
            } else {
                rect2 = null;
            }
            menuPopupWindow.f6729x = rect2;
        }
        arrayList.add(new d(menuPopupWindow, fVar, this.f6091p));
        menuPopupWindow.d();
        v vVar4 = menuPopupWindow.f6710c;
        vVar4.setOnKeyListener(this);
        if (dVar == null) {
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    public class ViewOnAttachStateChangeListenerC0093b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0093b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            b bVar = b.this;
            ViewTreeObserver viewTreeObserver = bVar.f6098x;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    bVar.f6098x = view.getViewTreeObserver();
                }
                bVar.f6098x.removeGlobalOnLayoutListener(bVar.f6085i);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    }
}
