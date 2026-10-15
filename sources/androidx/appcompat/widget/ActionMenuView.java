package androidx.appcompat.widget;

import T.InterfaceC0426m;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements androidx.appcompat.view.menu.f.b, androidx.appcompat.view.menu.k {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public e f6285A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.appcompat.view.menu.f f6286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Context f6287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6288r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6289s;
    public ActionMenuPresenter t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.appcompat.app.p.c f6290u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public androidx.appcompat.view.menu.f.a f6291v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6292w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6293x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f6294y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f6295z;

    public interface a {
        boolean a();

        boolean b();
    }

    public static class c extends LinearLayoutCompat.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f6296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f6297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f6298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f6299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f6300e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6301f;
    }

    public class d implements androidx.appcompat.view.menu.f.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            boolean z8;
            boolean zOnMenuItemSelected;
            e eVar = ActionMenuView.this.f6285A;
            if (eVar != null) {
                Toolbar toolbar = Toolbar.this;
                Iterator<InterfaceC0426m> it = toolbar.f6529G.f4441b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z8 = false;
                        break;
                    }
                    if (it.next().a(menuItem)) {
                        z8 = true;
                        break;
                    }
                }
                if (z8) {
                    zOnMenuItemSelected = true;
                } else {
                    Toolbar.h hVar = toolbar.f6531I;
                    zOnMenuItemSelected = hVar != null ? androidx.appcompat.app.p.this.f5986b.onMenuItemSelected(0, menuItem) : false;
                }
                if (zOnMenuItemSelected) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.f.a aVar = ActionMenuView.this.f6291v;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    public interface e {
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f6 = context.getResources().getDisplayMetrics().density;
        this.f6294y = (int) (56.0f * f6);
        this.f6295z = (int) (f6 * 4.0f);
        this.f6287q = context;
        this.f6288r = 0;
    }

    public static c l() {
        c cVar = new c(-2, -2);
        cVar.f6296a = false;
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    public static c m(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams == null) {
            return l();
        }
        if (layoutParams instanceof c) {
            c cVar2 = (c) layoutParams;
            cVar = new c(cVar2);
            cVar.f6296a = cVar2.f6296a;
        } else {
            cVar = new c(layoutParams);
        }
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean a(androidx.appcompat.view.menu.h hVar) {
        return this.f6286p.q(hVar, null, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public final void b(androidx.appcompat.view.menu.f fVar) {
        this.f6286p = fVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public Menu getMenu() {
        if (this.f6286p == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            this.f6286p = fVar;
            fVar.f6130e = new d();
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.t = actionMenuPresenter;
            actionMenuPresenter.f6266l = true;
            actionMenuPresenter.f6267m = true;
            androidx.appcompat.view.menu.j.a bVar = this.f6290u;
            if (bVar == null) {
                bVar = new b();
            }
            actionMenuPresenter.f6074e = bVar;
            this.f6286p.b(actionMenuPresenter, this.f6287q);
            ActionMenuPresenter actionMenuPresenter2 = this.t;
            actionMenuPresenter2.f6077h = this;
            this.f6286p = actionMenuPresenter2.f6072c;
        }
        return this.f6286p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.t;
        ActionMenuPresenter.d dVar = actionMenuPresenter.f6264i;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (actionMenuPresenter.f6265k) {
            return actionMenuPresenter.j;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f6288r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.a generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: i */
    public final LinearLayoutCompat.a generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: j */
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public final boolean n(int i9) {
        boolean zA = false;
        if (i9 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i9 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i9);
        if (i9 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i9 <= 0 || !(childAt2 instanceof a)) ? zA : ((a) childAt2).b() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.f();
            if (this.t.g()) {
                this.t.d();
                this.t.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.d();
            ActionMenuPresenter.a aVar = actionMenuPresenter.t;
            if (aVar == null || !aVar.b()) {
                return;
            }
            aVar.f6188i.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int width;
        int paddingLeft;
        if (!this.f6292w) {
            super.onLayout(z8, i9, i10, i11, i12);
            return;
        }
        int childCount = getChildCount();
        int i13 = (i12 - i10) / 2;
        int dividerWidth = getDividerWidth();
        int i14 = i11 - i9;
        int paddingRight = (i14 - getPaddingRight()) - getPaddingLeft();
        boolean z9 = Q.f6464a;
        boolean z10 = getLayoutDirection() == 1;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f6296a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (n(i17)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z10) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i18 = i13 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i18, width, measuredHeight + i18);
                    paddingRight -= measuredWidth;
                    i15 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    n(i17);
                    i16++;
                }
            }
        }
        if (childCount == 1 && i15 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i19 = (i14 / 2) - (measuredWidth2 / 2);
            int i20 = i13 - (measuredHeight2 / 2);
            childAt2.layout(i19, i20, measuredWidth2 + i19, measuredHeight2 + i20);
            return;
        }
        int i21 = i16 - (i15 ^ 1);
        int iMax = Math.max(0, i21 > 0 ? paddingRight / i21 : 0);
        if (z10) {
            int width2 = getWidth() - getPaddingRight();
            for (int i22 = 0; i22 < childCount; i22++) {
                View childAt3 = getChildAt(i22);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f6296a) {
                    int i23 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i24 = i13 - (measuredHeight3 / 2);
                    childAt3.layout(i23 - measuredWidth3, i24, i23, measuredHeight3 + i24);
                    width2 = i23 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i25 = 0; i25 < childCount; i25++) {
            View childAt4 = getChildAt(i25);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f6296a) {
                int i26 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i27 = i13 - (measuredHeight4 / 2);
                childAt4.layout(i26, i27, i26 + measuredWidth4, measuredHeight4 + i27);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax + i26;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v40 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        int i12;
        ?? r11;
        int i13;
        int i14;
        androidx.appcompat.view.menu.f fVar;
        boolean z8 = this.f6292w;
        boolean z9 = View.MeasureSpec.getMode(i9) == 1073741824;
        this.f6292w = z9;
        if (z8 != z9) {
            this.f6293x = 0;
        }
        int size = View.MeasureSpec.getSize(i9);
        if (this.f6292w && (fVar = this.f6286p) != null && size != this.f6293x) {
            this.f6293x = size;
            fVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.f6292w || childCount <= 0) {
            for (int i15 = 0; i15 < childCount; i15++) {
                c cVar = (c) getChildAt(i15).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i9, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i9);
        int size3 = View.MeasureSpec.getSize(i10);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingBottom, -2);
        int i16 = size2 - paddingRight;
        int i17 = this.f6294y;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i21 = 0;
        int iMax2 = 0;
        int i22 = 0;
        boolean z10 = false;
        int i23 = 0;
        long j = 0;
        while (true) {
            i11 = this.f6295z;
            if (i22 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i22);
            int i24 = size3;
            int i25 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i13 = i20;
            } else {
                boolean z11 = childAt instanceof ActionMenuItemView;
                i21++;
                if (z11) {
                    childAt.setPadding(i11, 0, i11, 0);
                }
                c cVar2 = (c) childAt.getLayoutParams();
                cVar2.f6301f = false;
                cVar2.f6298c = 0;
                cVar2.f6297b = 0;
                cVar2.f6299d = false;
                ((LinearLayout.LayoutParams) cVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) cVar2).rightMargin = 0;
                cVar2.f6300e = z11 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i26 = cVar2.f6296a ? 1 : i18;
                c cVar3 = (c) childAt.getLayoutParams();
                int i27 = i18;
                i13 = i20;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i25, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z11 ? (ActionMenuItemView) childAt : null;
                boolean z12 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z13 = z12;
                if (i26 <= 0 || (z12 && i26 < 2)) {
                    i14 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i13 * i26, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i14 = measuredWidth / i13;
                    if (measuredWidth % i13 != 0) {
                        i14++;
                    }
                    if (z13 && i14 < 2) {
                        i14 = 2;
                    }
                }
                cVar3.f6299d = !cVar3.f6296a && z13;
                cVar3.f6297b = i14;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i13, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i14);
                if (cVar2.f6299d) {
                    i23++;
                }
                if (cVar2.f6296a) {
                    z10 = true;
                }
                i18 = i27 - i14;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i14 == 1) {
                    j |= (long) (1 << i22);
                }
            }
            i22++;
            size3 = i24;
            paddingBottom = i25;
            i20 = i13;
        }
        int i28 = size3;
        int i29 = i18;
        int i30 = i20;
        boolean z14 = z10 && i21 == 2;
        int i31 = i29;
        boolean z15 = false;
        while (true) {
            if (i23 <= 0 || i31 <= 0) {
                i12 = iMax;
                break;
            }
            int i32 = Integer.MAX_VALUE;
            long j8 = 0;
            int i33 = 0;
            int i34 = 0;
            while (i34 < childCount2) {
                boolean z16 = z14;
                c cVar4 = (c) getChildAt(i34).getLayoutParams();
                int i35 = iMax;
                if (cVar4.f6299d) {
                    int i36 = cVar4.f6297b;
                    if (i36 < i32) {
                        j8 = 1 << i34;
                        i32 = i36;
                        i33 = 1;
                    } else if (i36 == i32) {
                        j8 |= 1 << i34;
                        i33++;
                    }
                }
                i34++;
                iMax = i35;
                z14 = z16;
            }
            boolean z17 = z14;
            i12 = iMax;
            j |= j8;
            if (i33 > i31) {
                break;
            }
            int i37 = i32 + 1;
            int i38 = 0;
            while (i38 < childCount2) {
                View childAt2 = getChildAt(i38);
                c cVar5 = (c) childAt2.getLayoutParams();
                boolean z18 = z10;
                long j9 = 1 << i38;
                if ((j8 & j9) != 0) {
                    if (z17 && cVar5.f6300e) {
                        r11 = 1;
                        r11 = 1;
                        if (i31 == 1) {
                            childAt2.setPadding(i11 + i30, 0, i11, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    cVar5.f6297b += r11;
                    cVar5.f6301f = r11;
                    i31--;
                } else if (cVar5.f6297b == i37) {
                    j |= j9;
                }
                i38++;
                z10 = z18;
            }
            iMax = i12;
            z14 = z17;
            z15 = true;
        }
        boolean z19 = !z10 && i21 == 1;
        if (i31 > 0 && j != 0 && (i31 < i21 - 1 || z19 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j);
            if (!z19) {
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f6300e) {
                    fBitCount -= 0.5f;
                }
                int i39 = childCount2 - 1;
                if ((j & ((long) (1 << i39))) != 0 && !((c) getChildAt(i39).getLayoutParams()).f6300e) {
                    fBitCount -= 0.5f;
                }
            }
            int i40 = fBitCount > 0.0f ? (int) ((i31 * i30) / fBitCount) : 0;
            boolean z20 = z15;
            for (int i41 = 0; i41 < childCount2; i41++) {
                if ((j & ((long) (1 << i41))) != 0) {
                    View childAt3 = getChildAt(i41);
                    c cVar6 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar6.f6298c = i40;
                        cVar6.f6301f = true;
                        if (i41 == 0 && !cVar6.f6300e) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = (-i40) / 2;
                        }
                        z20 = true;
                    } else if (cVar6.f6296a) {
                        cVar6.f6298c = i40;
                        cVar6.f6301f = true;
                        ((LinearLayout.LayoutParams) cVar6).rightMargin = (-i40) / 2;
                        z20 = true;
                    } else {
                        if (i41 != 0) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = i40 / 2;
                        }
                        if (i41 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) cVar6).rightMargin = i40 / 2;
                        }
                    }
                }
            }
            z15 = z20;
        }
        if (z15) {
            for (int i42 = 0; i42 < childCount2; i42++) {
                View childAt4 = getChildAt(i42);
                c cVar7 = (c) childAt4.getLayoutParams();
                if (cVar7.f6301f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar7.f6297b * i30) + cVar7.f6298c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i16, mode != 1073741824 ? i12 : i28);
    }

    public void setExpandedActionViewsExclusive(boolean z8) {
        this.t.f6271q = z8;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f6285A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.t;
        ActionMenuPresenter.d dVar = actionMenuPresenter.f6264i;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            actionMenuPresenter.f6265k = true;
            actionMenuPresenter.j = drawable;
        }
    }

    public void setOverflowReserved(boolean z8) {
        this.f6289s = z8;
    }

    public void setPopupTheme(int i9) {
        if (this.f6288r != i9) {
            this.f6288r = i9;
            if (i9 == 0) {
                this.f6287q = getContext();
            } else {
                this.f6287q = new ContextThemeWrapper(getContext(), i9);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.t = actionMenuPresenter;
        actionMenuPresenter.f6077h = this;
        this.f6286p = actionMenuPresenter.f6072c;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public static class b implements androidx.appcompat.view.menu.j.a {
        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z8) {
        }
    }
}
