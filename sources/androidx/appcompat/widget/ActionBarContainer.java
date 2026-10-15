package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.ikaile.ruoshui.client.R;
import com.xiaomi.mipush.sdk.api.MiPushSdk;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScrollingTabContainerView f6213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f6216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f6218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6220i;
    public final int j;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new C0490b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p059i.a.f19174a);
        boolean z8 = false;
        this.f6216e = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f6217f = typedArrayObtainStyledAttributes.getDrawable(2);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f6219h = true;
            this.f6218g = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f6219h ? !(this.f6216e != null || this.f6217f != null) : this.f6218g == null) {
            z8 = true;
        }
        setWillNotDraw(z8);
    }

    public static int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6216e;
        if (drawable != null && drawable.isStateful()) {
            this.f6216e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f6217f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f6217f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f6218g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f6218g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f6213b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6216e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f6217f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f6218g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f6214c = findViewById(R.id.action_bar);
        this.f6215d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f6212a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0049 A[PHI: r1
  0x0049: PHI (r1v8 boolean) = (r1v1 boolean), (r1v1 boolean), (r1v0 boolean) binds: [B:31:0x00a6, B:33:0x00aa, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        Drawable drawable;
        super.onLayout(z8, i9, i10, i11, i12);
        ScrollingTabContainerView scrollingTabContainerView = this.f6213b;
        boolean z9 = true;
        boolean z10 = false;
        boolean z11 = (scrollingTabContainerView == null || scrollingTabContainerView.getVisibility() == 8) ? false : true;
        if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) scrollingTabContainerView.getLayoutParams();
            int measuredHeight2 = measuredHeight - scrollingTabContainerView.getMeasuredHeight();
            int i13 = layoutParams.bottomMargin;
            scrollingTabContainerView.layout(i9, measuredHeight2 - i13, i11, measuredHeight - i13);
        }
        if (this.f6219h) {
            Drawable drawable2 = this.f6218g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z9 = z10;
            }
        } else {
            if (this.f6216e != null) {
                if (this.f6214c.getVisibility() == 0) {
                    this.f6216e.setBounds(this.f6214c.getLeft(), this.f6214c.getTop(), this.f6214c.getRight(), this.f6214c.getBottom());
                } else {
                    View view = this.f6215d;
                    if (view == null || view.getVisibility() != 0) {
                        this.f6216e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f6216e.setBounds(this.f6215d.getLeft(), this.f6215d.getTop(), this.f6215d.getRight(), this.f6215d.getBottom());
                    }
                }
                z10 = true;
            }
            this.f6220i = z11;
            if (!z11 || (drawable = this.f6217f) == null) {
                z9 = z10;
            } else {
                drawable.setBounds(scrollingTabContainerView.getLeft(), scrollingTabContainerView.getTop(), scrollingTabContainerView.getRight(), scrollingTabContainerView.getBottom());
            }
        }
        if (z9) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        int iA;
        int i11;
        if (this.f6214c == null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE && (i11 = this.j) >= 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(i11, View.MeasureSpec.getSize(i10)), Integer.MIN_VALUE);
        }
        super.onMeasure(i9, i10);
        if (this.f6214c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        ScrollingTabContainerView scrollingTabContainerView = this.f6213b;
        if (scrollingTabContainerView == null || scrollingTabContainerView.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        View view = this.f6214c;
        if (view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0) {
            View view2 = this.f6215d;
            iA = (view2 == null || view2.getVisibility() == 8 || view2.getMeasuredHeight() == 0) ? 0 : a(this.f6215d);
        } else {
            iA = a(this.f6214c);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f6213b) + iA, mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i10) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f6216e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f6216e);
        }
        this.f6216e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f6214c;
            if (view != null) {
                this.f6216e.setBounds(view.getLeft(), this.f6214c.getTop(), this.f6214c.getRight(), this.f6214c.getBottom());
            }
        }
        boolean z8 = false;
        if (!this.f6219h ? !(this.f6216e != null || this.f6217f != null) : this.f6218g == null) {
            z8 = true;
        }
        setWillNotDraw(z8);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f6218g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f6218g);
        }
        this.f6218g = drawable;
        boolean z8 = this.f6219h;
        boolean z9 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z8 && (drawable2 = this.f6218g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z8 ? !(this.f6216e != null || this.f6217f != null) : this.f6218g == null) {
            z9 = true;
        }
        setWillNotDraw(z9);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f6217f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f6217f);
        }
        this.f6217f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f6220i && (drawable2 = this.f6217f) != null) {
                drawable2.setBounds(this.f6213b.getLeft(), this.f6213b.getTop(), this.f6213b.getRight(), this.f6213b.getBottom());
            }
        }
        boolean z8 = false;
        if (!this.f6219h ? !(this.f6216e != null || this.f6217f != null) : this.f6218g == null) {
            z8 = true;
        }
        setWillNotDraw(z8);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.f6213b;
        if (scrollingTabContainerView2 != null) {
            removeView(scrollingTabContainerView2);
        }
        this.f6213b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z8) {
        this.f6212a = z8;
        setDescendantFocusability(z8 ? 393216 : MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION);
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        boolean z8 = i9 == 0;
        Drawable drawable = this.f6216e;
        if (drawable != null) {
            drawable.setVisible(z8, false);
        }
        Drawable drawable2 = this.f6217f;
        if (drawable2 != null) {
            drawable2.setVisible(z8, false);
        }
        Drawable drawable3 = this.f6218g;
        if (drawable3 != null) {
            drawable3.setVisible(z8, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f6216e;
        boolean z8 = this.f6219h;
        if (drawable == drawable2 && !z8) {
            return true;
        }
        if (drawable == this.f6217f && this.f6220i) {
            return true;
        }
        return (drawable == this.f6218g && z8) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i9) {
        if (i9 != 0) {
            return super.startActionModeForChild(view, callback, i9);
        }
        return null;
    }
}
