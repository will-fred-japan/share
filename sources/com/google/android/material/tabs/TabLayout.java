package com.google.android.material.tabs;

import T.G;
import T.L;
import U.f;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.O;
import androidx.viewpager.widget.ViewPager;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.internal.l;
import java.util.WeakHashMap;
import p056h5.C0598e;
import p142s2.j;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.b
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final S.d f13717p = new S.d(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f13718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f13719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f13720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f13721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f13722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13726i;
    public int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13727k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13728l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13729m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13730n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p190y0.a f13731o;

    public final class TabView extends LinearLayout {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int f13732i = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f13733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f13734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f13735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f13736d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.android.material.badge.a f13737e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f13738f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f13739g;

        public TabView(Context context) {
            GradientDrawable gradientDrawable;
            super(context);
            this.f13739g = 2;
            TabLayout.this.getClass();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            Drawable rippleDrawable = gradientDrawable2;
            if (TabLayout.this.f13721d != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateListA = F5.a.a(TabLayout.this.f13721d);
                boolean z8 = TabLayout.this.f13730n;
                if (z8) {
                    gradientDrawable = gradientDrawable2;
                    gradientDrawable = null;
                }
                rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable, z8 ? null : gradientDrawable3);
            }
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            setBackground(rippleDrawable);
            TabLayout.this.invalidate();
            TabLayout.this.getClass();
            setPaddingRelative(0, 0, 0, 0);
            setGravity(17);
            setOrientation(!TabLayout.this.f13727k ? 1 : 0);
            setClickable(true);
            G.f.a(this, PointerIcon.getSystemIcon(getContext(), 1002));
        }

        private com.google.android.material.badge.a getBadge() {
            return this.f13737e;
        }

        private com.google.android.material.badge.a getOrCreateBadge() {
            if (this.f13737e == null) {
                this.f13737e = new com.google.android.material.badge.a(getContext());
            }
            b();
            com.google.android.material.badge.a aVar = this.f13737e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void a() {
            if (this.f13737e != null) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.f13736d;
                if (view != null) {
                    com.google.android.material.badge.a aVar = this.f13737e;
                    if (aVar != null) {
                        if (aVar.d() != null) {
                            aVar.d().setForeground(null);
                        } else {
                            view.getOverlay().remove(aVar);
                        }
                    }
                    this.f13736d = null;
                }
            }
        }

        public final void b() {
            if (this.f13737e != null) {
                if (this.f13738f != null) {
                    a();
                    return;
                }
                TextView textView = this.f13734b;
                if (textView == null || this.f13733a == null) {
                    a();
                    return;
                }
                if (this.f13736d == textView) {
                    c(textView);
                    return;
                }
                a();
                TextView textView2 = this.f13734b;
                if (this.f13737e == null || textView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                com.google.android.material.badge.a aVar = this.f13737e;
                Rect rect = new Rect();
                textView2.getDrawingRect(rect);
                aVar.setBounds(rect);
                aVar.i(textView2, null);
                if (aVar.d() != null) {
                    aVar.d().setForeground(aVar);
                } else {
                    textView2.getOverlay().add(aVar);
                }
                this.f13736d = textView2;
            }
        }

        public final void c(View view) {
            com.google.android.material.badge.a aVar = this.f13737e;
            if (aVar == null || view != this.f13736d) {
                return;
            }
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            aVar.setBounds(rect);
            aVar.i(view, null);
        }

        public final void d() {
            boolean z8;
            TabLayout tabLayout = TabLayout.this;
            boolean z9 = false;
            d dVar = this.f13733a;
            View view = this.f13738f;
            if (view != null) {
                removeView(view);
                this.f13738f = null;
            }
            if (this.f13738f == null) {
                if (this.f13735c == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.f13735c = imageView;
                    addView(imageView, 0);
                }
                if (this.f13734b == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.f13734b = textView;
                    addView(textView);
                    this.f13739g = this.f13734b.getMaxLines();
                }
                TextView textView2 = this.f13734b;
                S.d dVar2 = TabLayout.f13717p;
                tabLayout.getClass();
                textView2.setTextAppearance(0);
                if (isSelected()) {
                    this.f13734b.setTextAppearance(0);
                } else {
                    this.f13734b.setTextAppearance(0);
                }
                ColorStateList colorStateList = tabLayout.f13719b;
                if (colorStateList != null) {
                    this.f13734b.setTextColor(colorStateList);
                }
                TextView textView3 = this.f13734b;
                ImageView imageView2 = this.f13735c;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    imageView2.setImageDrawable(null);
                }
                boolean zIsEmpty = TextUtils.isEmpty(null);
                if (textView3 != null) {
                    if (zIsEmpty) {
                        z8 = false;
                    } else {
                        this.f13733a.getClass();
                        z8 = true;
                    }
                    textView3.setText((CharSequence) null);
                    textView3.setVisibility(z8 ? 0 : 8);
                    if (!zIsEmpty) {
                        setVisibility(0);
                    }
                } else {
                    z8 = false;
                }
                if (imageView2 != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
                    int iA = (z8 && imageView2.getVisibility() == 0) ? (int) l.a(getContext(), 8) : 0;
                    if (tabLayout.f13727k) {
                        if (iA != marginLayoutParams.getMarginEnd()) {
                            marginLayoutParams.setMarginEnd(iA);
                            marginLayoutParams.bottomMargin = 0;
                            imageView2.setLayoutParams(marginLayoutParams);
                            imageView2.requestLayout();
                        }
                    } else if (iA != marginLayoutParams.bottomMargin) {
                        marginLayoutParams.bottomMargin = iA;
                        marginLayoutParams.setMarginEnd(0);
                        imageView2.setLayoutParams(marginLayoutParams);
                        imageView2.requestLayout();
                    }
                }
                d dVar3 = this.f13733a;
                O.a(this, zIsEmpty ? dVar3 != null ? dVar3.f13742a : null : null);
                b();
                ImageView imageView3 = this.f13735c;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new com.google.android.material.tabs.a(this, imageView3));
                }
                TextView textView4 = this.f13734b;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new com.google.android.material.tabs.a(this, textView4));
                }
            }
            if (dVar != null && !TextUtils.isEmpty(dVar.f13742a)) {
                setContentDescription(dVar.f13742a);
            }
            d dVar4 = this.f13733a;
            if (dVar4 != null) {
                TabLayout tabLayout2 = dVar4.f13743b;
                if (tabLayout2 == null) {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
                int selectedTabPosition = tabLayout2.getSelectedTabPosition();
                if (selectedTabPosition != -1 && selectedTabPosition == -1) {
                    z9 = true;
                }
            }
            setSelected(z9);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            getDrawableState();
        }

        public int getContentHeight() {
            View[] viewArr = {this.f13734b, this.f13735c, this.f13738f};
            int iMax = 0;
            int iMin = 0;
            boolean z8 = false;
            for (int i9 = 0; i9 < 3; i9++) {
                View view = viewArr[i9];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z8 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z8 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z8 = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f13734b, this.f13735c, this.f13738f};
            int iMax = 0;
            int iMin = 0;
            boolean z8 = false;
            for (int i9 = 0; i9 < 3; i9++) {
                View view = viewArr[i9];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z8 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z8 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z8 = true;
                }
            }
            return iMax - iMin;
        }

        public d getTab() {
            return this.f13733a;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            com.google.android.material.badge.a aVar = this.f13737e;
            if (aVar != null && aVar.isVisible()) {
                accessibilityNodeInfo.setContentDescription(this.f13737e.c());
            }
            this.f13733a.getClass();
            accessibilityNodeInfo.setCollectionItemInfo(f.g.a(0, 1, -1, 1, isSelected()).f4590a);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) f.a.f4579e.f4586a);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i9, int i10) {
            int size = View.MeasureSpec.getSize(i9);
            int mode = View.MeasureSpec.getMode(i9);
            TabLayout tabLayout = TabLayout.this;
            int tabMaxWidth = tabLayout.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i9 = View.MeasureSpec.makeMeasureSpec(tabLayout.f13724g, Integer.MIN_VALUE);
            }
            super.onMeasure(i9, i10);
            if (this.f13734b != null) {
                tabLayout.getClass();
                int i11 = this.f13739g;
                ImageView imageView = this.f13735c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f13734b;
                    if (textView != null && textView.getLineCount() > 1) {
                        tabLayout.getClass();
                    }
                } else {
                    i11 = 1;
                }
                float textSize = this.f13734b.getTextSize();
                int lineCount = this.f13734b.getLineCount();
                int maxLines = this.f13734b.getMaxLines();
                if (0.0f != textSize || (maxLines >= 0 && i11 != maxLines)) {
                    if (tabLayout.j == 1 && 0.0f > textSize && lineCount == 1) {
                        Layout layout = this.f13734b.getLayout();
                        if (layout == null) {
                            return;
                        }
                        if ((0.0f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                            return;
                        }
                    }
                    this.f13734b.setTextSize(0, 0.0f);
                    this.f13734b.setMaxLines(i11);
                    super.onMeasure(i9, i10);
                }
            }
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f13733a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            d dVar = this.f13733a;
            TabLayout tabLayout = dVar.f13743b;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            d dVar2 = tabLayout.f13718a;
            if (dVar2 != dVar) {
                tabLayout.f13718a = dVar;
                if ((dVar2 != null && dVar2.f13743b != null) || dVar != null) {
                    throw null;
                }
            } else if (dVar2 != null) {
                throw null;
            }
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z8) {
            isSelected();
            super.setSelected(z8);
            TextView textView = this.f13734b;
            if (textView != null) {
                textView.setSelected(z8);
            }
            ImageView imageView = this.f13735c;
            if (imageView != null) {
                imageView.setSelected(z8);
            }
            View view = this.f13738f;
            if (view != null) {
                view.setSelected(z8);
            }
        }

        public void setTab(d dVar) {
            if (dVar != this.f13733a) {
                this.f13733a = dVar;
                d();
            }
        }
    }

    @Deprecated
    public interface a<T extends d> {
    }

    public interface b extends a<d> {
    }

    public class c extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f13741a = 0;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f13742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TabLayout f13743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TabView f13744c;
    }

    private int getDefaultHeight() {
        throw null;
    }

    private int getTabMinWidth() {
        return 0;
    }

    private int getTabScrollRange() {
        throw null;
    }

    private void setSelectedTabView(int i9) {
        throw null;
    }

    public final void a(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        d dVar = (d) f13717p.d();
        if (dVar == null) {
            dVar = new d();
        }
        dVar.f13743b = this;
        TabView tabView = new TabView(getContext());
        tabView.setTab(dVar);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(dVar.f13742a)) {
            tabView.setContentDescription(null);
        } else {
            tabView.setContentDescription(dVar.f13742a);
        }
        dVar.f13744c = tabView;
        tabItem.getClass();
        if (TextUtils.isEmpty(tabItem.getContentDescription())) {
            throw null;
        }
        dVar.f13742a = tabItem.getContentDescription();
        TabView tabView2 = dVar.f13744c;
        if (tabView2 == null) {
            throw null;
        }
        tabView2.d();
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        a(view);
        throw null;
    }

    public final void b(ViewPager viewPager) {
        Object obj = null;
        obj.getClass();
        throw null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        return -1;
    }

    public int getTabCount() {
        throw null;
    }

    public int getTabGravity() {
        return this.f13725h;
    }

    public ColorStateList getTabIconTint() {
        return this.f13720c;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f13729m;
    }

    public int getTabIndicatorGravity() {
        return this.f13726i;
    }

    public int getTabMaxWidth() {
        return this.f13724g;
    }

    public int getTabMode() {
        return this.j;
    }

    public ColorStateList getTabRippleColor() {
        return this.f13721d;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f13722e;
    }

    public ColorStateList getTabTextColors() {
        return this.f13719b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.z(this);
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            b((ViewPager) parent);
            throw null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        throw null;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        int iRound = Math.round(l.a(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i10 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + iRound, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i10) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i9);
        if (View.MeasureSpec.getMode(i9) != 0) {
            this.f13724g = (int) (size - l.a(getContext(), 56));
        }
        super.onMeasure(i9, i10);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i11 = this.j;
            if (i11 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (i11 != 1) {
                if (i11 != 2) {
                    return;
                }
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        j.w(this, f6);
    }

    public void setInlineLabel(boolean z8) {
        if (this.f13727k == z8) {
            return;
        }
        this.f13727k = z8;
        throw null;
    }

    public void setInlineLabelResource(int i9) {
        setInlineLabel(getResources().getBoolean(i9));
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        setOnTabSelectedListener((a) bVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        throw null;
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = drawable.mutate();
        this.f13722e = drawableMutate;
        int i9 = this.f13723f;
        if (i9 != 0) {
            drawableMutate.setTint(i9);
        } else {
            drawableMutate.setTintList(null);
        }
        if (this.f13728l != -1) {
            throw null;
        }
        this.f13722e.getIntrinsicHeight();
        throw null;
    }

    public void setSelectedTabIndicatorColor(int i9) {
        this.f13723f = i9;
        Drawable drawable = this.f13722e;
        if (i9 != 0) {
            drawable.setTint(i9);
            throw null;
        }
        drawable.setTintList(null);
        throw null;
    }

    public void setSelectedTabIndicatorGravity(int i9) {
        if (this.f13726i == i9) {
            return;
        }
        this.f13726i = i9;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        throw null;
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i9) {
        this.f13728l = i9;
        throw null;
    }

    public void setTabGravity(int i9) {
        if (this.f13725h == i9) {
            return;
        }
        this.f13725h = i9;
        int i10 = this.j;
        if (i10 == 0 || i10 == 2) {
            Math.max(0, 0);
        }
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        throw null;
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f13720c == colorStateList) {
            return;
        }
        this.f13720c = colorStateList;
        throw null;
    }

    public void setTabIconTintResource(int i9) {
        setTabIconTint(I.a.b(getContext(), i9));
    }

    public void setTabIndicatorAnimationMode(int i9) {
        this.f13729m = i9;
        if (i9 == 0 || i9 == 1 || i9 == 2) {
            return;
        }
        throw new IllegalArgumentException(i9 + " is not a valid TabIndicatorAnimationMode");
    }

    public void setTabIndicatorFullWidth(boolean z8) {
        int i9 = c.f13741a;
        throw null;
    }

    public void setTabMode(int i9) {
        if (i9 == this.j) {
            return;
        }
        this.j = i9;
        if (i9 == 0 || i9 == 2) {
            Math.max(0, 0);
        }
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        throw null;
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f13721d == colorStateList) {
            return;
        }
        this.f13721d = colorStateList;
        throw null;
    }

    public void setTabRippleColorResource(int i9) {
        setTabRippleColor(I.a.b(getContext(), i9));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f13719b == colorStateList) {
            return;
        }
        this.f13719b = colorStateList;
        throw null;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(p190y0.a aVar) {
        p190y0.a aVar2 = this.f13731o;
        if (aVar2 != null) {
            aVar2.f22365a.unregisterObserver(null);
        }
        this.f13731o = aVar;
        throw null;
    }

    public void setUnboundedRipple(boolean z8) {
        if (this.f13730n == z8) {
            return;
        }
        this.f13730n = z8;
        throw null;
    }

    public void setUnboundedRippleResource(int i9) {
        setUnboundedRipple(getResources().getBoolean(i9));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        b(viewPager);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i9) {
        a(view);
        throw null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(a aVar) {
        if (aVar != null) {
            throw null;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        a(view);
        throw null;
    }

    public void setSelectedTabIndicator(int i9) {
        if (i9 != 0) {
            setSelectedTabIndicator(C0598e.v(getContext(), i9));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
