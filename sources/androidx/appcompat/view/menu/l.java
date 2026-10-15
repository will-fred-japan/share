package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.v;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: compiled from: StandardMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends p097n.d implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f6192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f6193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MenuPopupWindow f6197h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i.a f6199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f6200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f6201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j.a f6202n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewTreeObserver f6203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6204p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6205q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6206r;
    public boolean t;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f6198i = new a();
    public final b j = new b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6207s = 0;

    /* JADX INFO: compiled from: StandardMenuPopup.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            l lVar = l.this;
            if (lVar.b()) {
                MenuPopupWindow menuPopupWindow = lVar.f6197h;
                if (menuPopupWindow.f6730y) {
                    return;
                }
                View view = lVar.f6201m;
                if (view == null || !view.isShown()) {
                    lVar.dismiss();
                } else {
                    menuPopupWindow.d();
                }
            }
        }
    }

    public l(int i9, Context context, View view, f fVar, boolean z8) {
        this.f6191b = context;
        this.f6192c = fVar;
        this.f6194e = z8;
        this.f6193d = new e(fVar, LayoutInflater.from(context), z8, R.layout.abc_popup_menu_item_layout);
        this.f6196g = i9;
        Resources resources = context.getResources();
        this.f6195f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f6200l = view;
        this.f6197h = new MenuPopupWindow(context, null, i9);
        fVar.b(this, context);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f fVar, boolean z8) {
        if (fVar != this.f6192c) {
            return;
        }
        dismiss();
        j.a aVar = this.f6202n;
        if (aVar != null) {
            aVar.a(fVar, z8);
        }
    }

    @Override // p097n.f
    public final boolean b() {
        return !this.f6204p && this.f6197h.f6731z.isShowing();
    }

    @Override // p097n.f
    public final void d() {
        View view;
        if (b()) {
            return;
        }
        if (this.f6204p || (view = this.f6200l) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f6201m = view;
        MenuPopupWindow menuPopupWindow = this.f6197h;
        menuPopupWindow.f6731z.setOnDismissListener(this);
        menuPopupWindow.f6722p = this;
        menuPopupWindow.f6730y = true;
        menuPopupWindow.f6731z.setFocusable(true);
        View view2 = this.f6201m;
        boolean z8 = this.f6203o == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f6203o = viewTreeObserver;
        if (z8) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f6198i);
        }
        view2.addOnAttachStateChangeListener(this.j);
        menuPopupWindow.f6721o = view2;
        menuPopupWindow.f6718l = this.f6207s;
        boolean z9 = this.f6205q;
        Context context = this.f6191b;
        e eVar = this.f6193d;
        if (!z9) {
            this.f6206r = p097n.d.m(eVar, context, this.f6195f);
            this.f6205q = true;
        }
        menuPopupWindow.r(this.f6206r);
        menuPopupWindow.f6731z.setInputMethodMode(2);
        Rect rect = this.f20542a;
        menuPopupWindow.f6729x = rect != null ? new Rect(rect) : null;
        menuPopupWindow.d();
        v vVar = menuPopupWindow.f6710c;
        vVar.setOnKeyListener(this);
        if (this.t) {
            f fVar = this.f6192c;
            if (fVar.f6137m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) vVar, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(fVar.f6137m);
                }
                frameLayout.setEnabled(false);
                vVar.addHeaderView(frameLayout, null, false);
            }
        }
        menuPopupWindow.p(eVar);
        menuPopupWindow.d();
    }

    @Override // p097n.f
    public final void dismiss() {
        if (b()) {
            this.f6197h.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void f() {
        this.f6205q = false;
        e eVar = this.f6193d;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // p097n.f
    public final v g() {
        return this.f6197h.f6710c;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean h(m mVar) {
        if (mVar.hasVisibleItems()) {
            View view = this.f6201m;
            i iVar = new i(this.f6196g, this.f6191b, view, mVar, this.f6194e);
            j.a aVar = this.f6202n;
            iVar.f6187h = aVar;
            p097n.d dVar = iVar.f6188i;
            if (dVar != null) {
                dVar.j(aVar);
            }
            boolean zU = p097n.d.u(mVar);
            iVar.f6186g = zU;
            p097n.d dVar2 = iVar.f6188i;
            if (dVar2 != null) {
                dVar2.o(zU);
            }
            iVar.j = this.f6199k;
            this.f6199k = null;
            this.f6192c.c(false);
            MenuPopupWindow menuPopupWindow = this.f6197h;
            int width = menuPopupWindow.f6713f;
            int iM = menuPopupWindow.m();
            if ((Gravity.getAbsoluteGravity(this.f6207s, this.f6200l.getLayoutDirection()) & 7) == 5) {
                width += this.f6200l.getWidth();
            }
            if (!iVar.b()) {
                if (iVar.f6184e != null) {
                    iVar.d(width, iM, true, true);
                }
            }
            j.a aVar2 = this.f6202n;
            if (aVar2 != null) {
                aVar2.b(mVar);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void j(j.a aVar) {
        this.f6202n = aVar;
    }

    @Override // p097n.d
    public final void n(View view) {
        this.f6200l = view;
    }

    @Override // p097n.d
    public final void o(boolean z8) {
        this.f6193d.f6121c = z8;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f6204p = true;
        this.f6192c.c(true);
        ViewTreeObserver viewTreeObserver = this.f6203o;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f6203o = this.f6201m.getViewTreeObserver();
            }
            this.f6203o.removeGlobalOnLayoutListener(this.f6198i);
            this.f6203o = null;
        }
        this.f6201m.removeOnAttachStateChangeListener(this.j);
        i.a aVar = this.f6199k;
        if (aVar != null) {
            aVar.onDismiss();
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
        this.f6207s = i9;
    }

    @Override // p097n.d
    public final void q(int i9) {
        this.f6197h.f6713f = i9;
    }

    @Override // p097n.d
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f6199k = (i.a) onDismissListener;
    }

    @Override // p097n.d
    public final void s(boolean z8) {
        this.t = z8;
    }

    @Override // p097n.d
    public final void t(int i9) {
        this.f6197h.i(i9);
    }

    /* JADX INFO: compiled from: StandardMenuPopup.java */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            l lVar = l.this;
            ViewTreeObserver viewTreeObserver = lVar.f6203o;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    lVar.f6203o = view.getViewTreeObserver();
                }
                lVar.f6203o.removeGlobalOnLayoutListener(lVar.f6198i);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    }

    @Override // p097n.d
    public final void l(f fVar) {
    }
}
