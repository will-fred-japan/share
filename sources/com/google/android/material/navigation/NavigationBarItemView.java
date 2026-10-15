package com.google.android.material.navigation;

import T.G;
import T.L;
import U.f;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.O;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationBarItemView extends FrameLayout implements k.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f13566q = {R.attr.state_checked};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b f13567r = new b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c f13568s = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f13569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f13570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13577i;
    public h j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f13578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f13579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f13580m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13581n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13582o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.google.android.material.badge.a f13583p;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            int[] iArr = NavigationBarItemView.f13566q;
        }
    }

    public static class b {
    }

    public static class c extends b {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    public static void c(TextView textView, int i9) {
        int iRound;
        textView.setTextAppearance(i9);
        Context context = textView.getContext();
        if (i9 == 0) {
            iRound = 0;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i9, p103n5.a.f20585C);
            TypedValue typedValue = new TypedValue();
            boolean value = typedArrayObtainStyledAttributes.getValue(0, typedValue);
            typedArrayObtainStyledAttributes.recycle();
            if (value) {
                iRound = typedValue.getComplexUnit() == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            } else {
                iRound = 0;
            }
        }
        if (iRound != 0) {
            textView.setTextSize(0, iRound);
        }
    }

    private View getIconOrContainer() {
        return null;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i9 = 0;
        for (int i10 = 0; i10 < iIndexOfChild; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i9++;
            }
        }
        return i9;
    }

    private int getSuggestedIconHeight() {
        return getIconOrContainer().getMeasuredHeight() + ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin;
    }

    private int getSuggestedIconWidth() {
        com.google.android.material.badge.a aVar = this.f13583p;
        Math.max(aVar == null ? 0 : aVar.getMinimumWidth() - this.f13583p.f12891e.f12850b.f12883w.intValue(), ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).leftMargin);
        throw null;
    }

    public final void a() {
        h hVar = this.j;
        if (hVar != null) {
            setChecked(hVar.isChecked());
        }
    }

    public final void b() {
        Drawable rippleDrawable = this.f13570b;
        if (this.f13569a != null) {
            getActiveIndicatorDrawable();
            if (this.f13581n) {
                getActiveIndicatorDrawable();
            }
            if (rippleDrawable == null) {
                rippleDrawable = new RippleDrawable(F5.a.a(this.f13569a), null, null);
            }
        }
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        setBackground(rippleDrawable);
        setDefaultFocusHighlightEnabled(true);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void d(h hVar) {
        this.j = hVar;
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setIcon(hVar.getIcon());
        setTitle(hVar.f6159e);
        setId(hVar.f6155a);
        if (!TextUtils.isEmpty(hVar.f6170q)) {
            setContentDescription(hVar.f6170q);
        }
        O.a(this, !TextUtils.isEmpty(hVar.f6171r) ? hVar.f6171r : hVar.f6159e);
        setVisibility(hVar.isVisible() ? 0 : 8);
    }

    public Drawable getActiveIndicatorDrawable() {
        return null;
    }

    public com.google.android.material.badge.a getBadge() {
        return this.f13583p;
    }

    public int getItemBackgroundResId() {
        return cn.ikaile.ruoshui.client.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.j;
    }

    public int getItemDefaultMarginResId() {
        return cn.ikaile.ruoshui.client.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f13576h;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        throw null;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i9 + 1);
        h hVar = this.j;
        if (hVar != null && hVar.isCheckable() && this.j.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f13566q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        com.google.android.material.badge.a aVar = this.f13583p;
        if (aVar != null && aVar.isVisible()) {
            h hVar = this.j;
            CharSequence charSequence = hVar.f6159e;
            if (!TextUtils.isEmpty(hVar.f6170q)) {
                charSequence = this.j.f6170q;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.f13583p.c()));
        }
        accessibilityNodeInfo.setCollectionItemInfo(f.g.a(0, 1, getItemVisiblePosition(), 1, isSelected()).f4590a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) f.a.f4579e.f4586a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(cn.ikaile.ruoshui.client.R.string.item_view_role_description));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        post(new a());
    }

    public void setActiveIndicatorEnabled(boolean z8) {
        this.f13581n = z8;
        b();
    }

    public void setActiveIndicatorHeight(int i9) {
        getWidth();
    }

    public void setActiveIndicatorLabelPadding(int i9) {
        if (this.f13573e != i9) {
            this.f13573e = i9;
            a();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i9) {
        getWidth();
    }

    public void setActiveIndicatorResizeable(boolean z8) {
        this.f13582o = z8;
    }

    public void setActiveIndicatorWidth(int i9) {
        getWidth();
    }

    public void setBadge(com.google.android.material.badge.a aVar) {
        if (this.f13583p == aVar) {
            return;
        }
        this.f13583p = aVar;
    }

    public void setCheckable(boolean z8) {
        refreshDrawableState();
    }

    public void setChecked(boolean z8) {
        throw null;
    }

    @Override // android.view.View
    public void setEnabled(boolean z8) {
        super.setEnabled(z8);
        throw null;
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.f13579l) {
            return;
        }
        this.f13579l = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            Drawable drawableMutate = drawable.mutate();
            this.f13580m = drawableMutate;
            ColorStateList colorStateList = this.f13578k;
            if (colorStateList != null) {
                drawableMutate.setTintList(colorStateList);
            }
        }
        throw null;
    }

    public void setIconSize(int i9) {
        throw null;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f13578k = colorStateList;
        if (this.j == null || (drawable = this.f13580m) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.f13580m.invalidateSelf();
    }

    public void setItemBackground(int i9) {
        setItemBackground(i9 == 0 ? null : getContext().getDrawable(i9));
    }

    public void setItemPaddingBottom(int i9) {
        if (this.f13572d != i9) {
            this.f13572d = i9;
            a();
        }
    }

    public void setItemPaddingTop(int i9) {
        if (this.f13571c != i9) {
            this.f13571c = i9;
            a();
        }
    }

    public void setItemPosition(int i9) {
        this.f13576h = i9;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f13569a = colorStateList;
        b();
    }

    public void setLabelVisibilityMode(int i9) {
        if (this.f13574f != i9) {
            this.f13574f = i9;
            if (this.f13582o) {
            }
            getWidth();
            a();
        }
    }

    public void setShifting(boolean z8) {
        if (this.f13575g != z8) {
            this.f13575g = z8;
            a();
        }
    }

    public void setTextAppearanceActive(int i9) {
        this.f13577i = i9;
        c(null, i9);
        throw null;
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z8) {
        setTextAppearanceActive(this.f13577i);
        throw null;
    }

    public void setTextAppearanceInactive(int i9) {
        c(null, i9);
        throw null;
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            throw null;
        }
    }

    public void setTitle(CharSequence charSequence) {
        throw null;
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f13570b = drawable;
        b();
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
    }
}
