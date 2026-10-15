package androidx.core.widget;

import T.A;
import T.C0414a;
import T.C0417d;
import T.C0428o;
import T.C0436x;
import T.C0438z;
import T.G;
import T.I;
import T.InterfaceC0427n;
import T.InterfaceC0430q;
import T.L;
import T.r;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0430q, InterfaceC0427n {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final float f7082C = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final a f7083D = new a();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final int[] f7084E = {R.attr.fillViewport};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public float f7085A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final C0417d f7086B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f7089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OverScroller f7090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EdgeEffect f7091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EdgeEffect f7092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C0436x f7093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7095i;
    public boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f7096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7097l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f7098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7099n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7100o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f7101p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f7102q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f7103r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f7104s;
    public final int[] t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int[] f7105u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7106v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7107w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SavedState f7108x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r f7109y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final C0428o f7110z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7111a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState(parcel);
                savedState.f7111a = parcel.readInt();
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i9) {
                return new SavedState[i9];
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            return A.f.i(sb, this.f7111a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeInt(this.f7111a);
        }
    }

    public static class a extends C0414a {
        @Override // T.C0414a
        public final void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
        }

        @Override // T.C0414a
        public final void d(View view, U.f fVar) {
            int scrollRange;
            View.AccessibilityDelegate accessibilityDelegate = this.f4401a;
            AccessibilityNodeInfo accessibilityNodeInfo = fVar.f4577a;
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfo.setClassName(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            fVar.i(true);
            if (nestedScrollView.getScrollY() > 0) {
                fVar.b(U.f.a.f4581g);
                fVar.b(U.f.a.f4584k);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                fVar.b(U.f.a.f4580f);
                fVar.b(U.f.a.f4585l);
            }
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006a  */
        /* JADX WARN: Code duplicated, block: B:28:0x0087  */
        @Override // T.C0414a
        public final boolean g(View view, int i9, Bundle bundle) {
            int iMin;
            if (super.g(view, i9, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled()) {
                int height = nestedScrollView.getHeight();
                Rect rect = new Rect();
                if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                    height = rect.height();
                }
                if (i9 == 4096) {
                    iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                    if (iMin != nestedScrollView.getScrollY()) {
                        nestedScrollView.o(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
                        return true;
                    }
                } else if (i9 == 8192 || i9 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax != nestedScrollView.getScrollY()) {
                        nestedScrollView.o(0 - nestedScrollView.getScrollX(), iMax - nestedScrollView.getScrollY(), true);
                        return true;
                    }
                } else if (i9 == 16908346) {
                    iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                    if (iMin != nestedScrollView.getScrollY()) {
                        nestedScrollView.o(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static final class b {
        public static void a(NestedScrollView nestedScrollView, float f6) {
            try {
                nestedScrollView.setFrameContentVelocity(f6);
            } catch (LinkageError unused) {
            }
        }
    }

    public class c {
        public c() {
        }
    }

    public interface d {
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, cn.ikaile.ruoshui.client.R.attr.nestedScrollViewStyle);
        this.f7089c = new Rect();
        this.f7095i = true;
        this.j = false;
        this.f7096k = null;
        this.f7097l = false;
        this.f7100o = true;
        this.f7104s = -1;
        this.t = new int[2];
        this.f7105u = new int[2];
        this.f7086B = new C0417d(getContext(), new c());
        int i9 = Build.VERSION.SDK_INT;
        this.f7091e = i9 >= 31 ? androidx.core.widget.b.a.a(context, attributeSet) : new EdgeEffect(context);
        this.f7092f = i9 >= 31 ? androidx.core.widget.b.a.a(context, attributeSet) : new EdgeEffect(context);
        this.f7087a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f7090d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f7101p = viewConfiguration.getScaledTouchSlop();
        this.f7102q = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7103r = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7084E, cn.ikaile.ruoshui.client.R.attr.nestedScrollViewStyle, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f7109y = new r();
        this.f7110z = new C0428o(this);
        setNestedScrollingEnabled(true);
        G.m(this, f7083D);
    }

    public static boolean f(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && f((View) parent, nestedScrollView);
    }

    private C0436x getScrollFeedbackProvider() {
        if (this.f7093g == null) {
            this.f7093g = new C0436x(this);
        }
        return this.f7093g;
    }

    public final boolean a(int i9) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View view = viewFindFocus;
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i9);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !g(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i9 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i9 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i9 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m(maxScrollAmount, -1, null, 0, 1, true);
        } else {
            Rect rect = this.f7089c;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            m(b(rect), -1, null, 0, 1, true);
            viewFindNextFocus.requestFocus(i9);
        }
        if (view != null && view.isFocused() && !g(view, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public final int b(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i9 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i10 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i9 - verticalFadingEdgeLength : i9;
        int i11 = rect.bottom;
        if (i11 > i10 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i10, (childAt.getBottom() + layoutParams.bottomMargin) - i9);
        }
        if (rect.top >= scrollY || i11 >= i10) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i10 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0098  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ab  */
    public final boolean c(KeyEvent keyEvent) {
        View viewFindFocus;
        View viewFindNextFocus;
        this.f7089c.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode == 19) {
                        return keyEvent.isAltPressed() ? e(33) : a(33);
                    }
                    if (keyCode == 20) {
                        return keyEvent.isAltPressed() ? e(130) : a(130);
                    }
                    if (keyCode == 62) {
                        k(keyEvent.isShiftPressed() ? 33 : 130);
                        return false;
                    }
                    if (keyCode == 92) {
                        return e(33);
                    }
                    if (keyCode == 93) {
                        return e(130);
                    }
                    if (keyCode == 122) {
                        k(33);
                        return false;
                    }
                    if (keyCode == 123) {
                        k(130);
                        return false;
                    }
                }
            } else if (isFocused() && keyEvent.getKeyCode() != 4) {
                viewFindFocus = findFocus();
                if (viewFindFocus == this) {
                    viewFindFocus = null;
                }
                viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
                if (viewFindNextFocus == null && viewFindNextFocus != this && viewFindNextFocus.requestFocus(130)) {
                    return true;
                }
            }
        } else if (isFocused()) {
            viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            if (viewFindNextFocus == null) {
            }
        }
        return false;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0087  */
    /* JADX WARN: Code duplicated, block: B:24:0x0096  */
    /* JADX WARN: Code duplicated, block: B:26:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:33:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00de  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fc  */
    @Override // android.view.View
    public final void computeScroll() {
        int iRound;
        int[] iArr;
        int i9;
        int scrollRange;
        int overScrollMode;
        if (this.f7090d.isFinished()) {
            return;
        }
        this.f7090d.computeScrollOffset();
        int currY = this.f7090d.getCurrY();
        int i10 = currY - this.f7107w;
        int height = getHeight();
        EdgeEffect edgeEffect = this.f7092f;
        EdgeEffect edgeEffect2 = this.f7091e;
        if (i10 <= 0 || androidx.core.widget.b.a(edgeEffect2) == 0.0f) {
            if (i10 < 0 && androidx.core.widget.b.a(edgeEffect) != 0.0f) {
                float f6 = height;
                iRound = Math.round(androidx.core.widget.b.b(edgeEffect, (i10 * 4.0f) / f6, 0.5f) * (f6 / 4.0f));
                if (iRound != i10) {
                    edgeEffect.finish();
                }
            }
            int i11 = i10;
            this.f7107w = currY;
            iArr = this.f7105u;
            iArr[1] = 0;
            this.f7110z.c(0, i11, iArr, null, 1);
            i9 = i11 - iArr[1];
            scrollRange = getScrollRange();
            if (Build.VERSION.SDK_INT >= 35) {
                b.a(this, Math.abs(this.f7090d.getCurrVelocity()));
            }
            if (i9 != 0) {
                int scrollY = getScrollY();
                j(i9, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i12 = i9 - scrollY2;
                iArr[1] = 0;
                this.f7110z.d(0, scrollY2, 0, i12, this.t, 1, iArr);
                i9 = i12 - iArr[1];
            }
            if (i9 != 0) {
                overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    if (i9 < 0) {
                        if (edgeEffect2.isFinished()) {
                            edgeEffect2.onAbsorb((int) this.f7090d.getCurrVelocity());
                        }
                    } else if (edgeEffect.isFinished()) {
                        edgeEffect.onAbsorb((int) this.f7090d.getCurrVelocity());
                    }
                }
                this.f7090d.abortAnimation();
                q(1);
            }
            if (this.f7090d.isFinished()) {
                q(1);
            } else {
                postInvalidateOnAnimation();
            }
        }
        iRound = Math.round(androidx.core.widget.b.b(edgeEffect2, ((-i10) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
        if (iRound != i10) {
            edgeEffect2.finish();
        }
        i10 -= iRound;
        int i13 = i10;
        this.f7107w = currY;
        iArr = this.f7105u;
        iArr[1] = 0;
        this.f7110z.c(0, i13, iArr, null, 1);
        i9 = i13 - iArr[1];
        scrollRange = getScrollRange();
        if (Build.VERSION.SDK_INT >= 35) {
            b.a(this, Math.abs(this.f7090d.getCurrVelocity()));
        }
        if (i9 != 0) {
            int scrollY3 = getScrollY();
            j(i9, getScrollX(), scrollY3, scrollRange);
            int scrollY4 = getScrollY() - scrollY3;
            int i14 = i9 - scrollY4;
            iArr[1] = 0;
            this.f7110z.d(0, scrollY4, 0, i14, this.t, 1, iArr);
            i9 = i14 - iArr[1];
        }
        if (i9 != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (i9 < 0) {
                    if (edgeEffect2.isFinished()) {
                        edgeEffect2.onAbsorb((int) this.f7090d.getCurrVelocity());
                    }
                } else if (edgeEffect.isFinished()) {
                    edgeEffect.onAbsorb((int) this.f7090d.getCurrVelocity());
                }
            } else if (i9 < 0) {
                if (edgeEffect2.isFinished()) {
                    edgeEffect2.onAbsorb((int) this.f7090d.getCurrVelocity());
                }
            } else if (edgeEffect.isFinished()) {
                edgeEffect.onAbsorb((int) this.f7090d.getCurrVelocity());
            }
            this.f7090d.abortAnimation();
            q(1);
        }
        if (this.f7090d.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            q(1);
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? (scrollY - iMax) + bottom : bottom;
    }

    public final void d(int i9) {
        if (getChildCount() > 0) {
            this.f7090d.fling(getScrollX(), getScrollY(), 0, i9, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.f7110z.g(2, 1);
            this.f7107w = getScrollY();
            postInvalidateOnAnimation();
            if (Build.VERSION.SDK_INT >= 35) {
                b.a(this, Math.abs(this.f7090d.getCurrVelocity()));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || c(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f6, float f9, boolean z8) {
        return this.f7110z.a(f6, f9, z8);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f6, float f9) {
        return this.f7110z.b(f6, f9);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i9, int i10, int[] iArr, int[] iArr2) {
        return this.f7110z.c(i9, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i9, int i10, int i11, int i12, int[] iArr) {
        return this.f7110z.d(i9, i10, i11, i12, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f7091e;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (getClipToPadding()) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            } else {
                paddingLeft = 0;
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.f7092f;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (getClipToPadding()) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (getClipToPadding()) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    public final boolean e(int i9) {
        int childCount;
        boolean z8 = i9 == 130;
        int height = getHeight();
        Rect rect = this.f7089c;
        rect.top = 0;
        rect.bottom = height;
        if (z8 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return l(i9, rect.top, rect.bottom);
    }

    public final boolean g(View view, int i9, int i10) {
        Rect rect = this.f7089c;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i9 >= getScrollY() && rect.top - i9 <= getScrollY() + i10;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        r rVar = this.f7109y;
        return rVar.f4451b | rVar.f4450a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.f7085A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f7085A = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f7085A;
    }

    public final void h(int i9, int i10, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i9);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f7110z.d(0, scrollY2, 0, i9 - scrollY2, null, i10, iArr);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f7110z.f(0);
    }

    public final void i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f7104s) {
            int i9 = actionIndex == 0 ? 1 : 0;
            this.f7094h = (int) motionEvent.getY(i9);
            this.f7104s = motionEvent.getPointerId(i9);
            VelocityTracker velocityTracker = this.f7098m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f7110z.f4448d;
    }

    public final boolean j(int i9, int i10, int i11, int i12) {
        int i13;
        boolean z8;
        int i14;
        boolean z9;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i15 = i11 + i9;
        if (i10 <= 0 && i10 >= 0) {
            i13 = i10;
            z8 = false;
        } else {
            i13 = 0;
            z8 = true;
        }
        if (i15 <= i12) {
            if (i15 < 0) {
                i14 = 0;
            } else {
                i14 = i15;
                z9 = false;
            }
            if (z9 && !this.f7110z.f(1)) {
                this.f7090d.springBack(i13, i14, 0, 0, 0, getScrollRange());
            }
            super.scrollTo(i13, i14);
            return !z8 || z9;
        }
        i14 = i12;
        z9 = true;
        if (z9) {
            this.f7090d.springBack(i13, i14, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i13, i14);
        if (z8) {
        }
    }

    public final void k(int i9) {
        boolean z8 = i9 == 130;
        int height = getHeight();
        Rect rect = this.f7089c;
        if (z8) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i10 = rect.top;
        int i11 = height + i10;
        rect.bottom = i11;
        l(i9, i10, i11);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    public final boolean l(int i9, int i10, int i11) {
        boolean z8;
        int height = getHeight();
        int scrollY = getScrollY();
        int i12 = height + scrollY;
        boolean z9 = i9 == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z10 = false;
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = focusables.get(i13);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                boolean z11 = i10 < top && bottom < i11;
                if (view == null) {
                    view = view2;
                    z10 = z11;
                } else {
                    boolean z12 = (z9 && top < view.getTop()) || (!z9 && bottom > view.getBottom());
                    if (z10) {
                        if (z11 && z12) {
                            view = view2;
                        }
                    } else if (z11) {
                        view = view2;
                        z10 = true;
                    } else if (z12) {
                        view = view2;
                    }
                }
            }
        }
        View view3 = view == null ? this : view;
        if (i10 < scrollY || i11 > i12) {
            m(z9 ? i10 - scrollY : i11 - i12, -1, null, 0, 1, true);
            z8 = true;
        } else {
            z8 = false;
        }
        if (view3 != findFocus()) {
            view3.requestFocus(i9);
        }
        return z8;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0117  */
    /* JADX WARN: Code duplicated, block: B:59:0x0128  */
    public final int m(int i9, int i10, MotionEvent motionEvent, int i11, int i12, boolean z8) {
        int i13;
        int i14;
        boolean z9;
        boolean z10;
        VelocityTracker velocityTracker;
        C0428o c0428o = this.f7110z;
        if (i12 == 1) {
            c0428o.g(2, i12);
        }
        boolean zC = this.f7110z.c(0, i9, this.f7105u, this.t, i12);
        int[] iArr = this.f7105u;
        int[] iArr2 = this.t;
        if (zC) {
            i13 = i9 - iArr[1];
            i14 = iArr2[1];
        } else {
            i13 = i9;
            i14 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z11 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z8;
        boolean z12 = j(i13, 0, scrollY, scrollRange) && !c0428o.f(i12);
        int scrollY2 = getScrollY() - scrollY;
        if (motionEvent != null && scrollY2 != 0) {
            getScrollFeedbackProvider().f4458a.b(motionEvent.getDeviceId(), motionEvent.getSource(), i10, scrollY2);
        }
        iArr[1] = 0;
        this.f7110z.d(0, scrollY2, 0, i13 - scrollY2, this.t, i12, iArr);
        int i15 = i14 + iArr2[1];
        int i16 = i13 - iArr[1];
        int i17 = scrollY + i16;
        EdgeEffect edgeEffect = this.f7092f;
        EdgeEffect edgeEffect2 = this.f7091e;
        if (i17 >= 0) {
            if (i17 > scrollRange && z11) {
                androidx.core.widget.b.b(edgeEffect, i16 / getHeight(), 1.0f - (i11 / getWidth()));
                if (motionEvent != null) {
                    z9 = false;
                    getScrollFeedbackProvider().f4458a.a(motionEvent.getDeviceId(), motionEvent.getSource(), i10, false);
                } else {
                    z9 = false;
                }
                if (!edgeEffect2.isFinished()) {
                    edgeEffect2.onRelease();
                }
            }
            if (edgeEffect2.isFinished() || !edgeEffect.isFinished()) {
                postInvalidateOnAnimation();
                z10 = z9;
            } else {
                z10 = z12;
            }
            if (z10 && i12 == 0 && (velocityTracker = this.f7098m) != null) {
                velocityTracker.clear();
            }
            if (i12 == 1) {
                q(i12);
                edgeEffect2.onRelease();
                edgeEffect.onRelease();
            }
            return i15;
        }
        if (z11) {
            androidx.core.widget.b.b(edgeEffect2, (-i16) / getHeight(), i11 / getWidth());
            if (motionEvent != null) {
                getScrollFeedbackProvider().f4458a.a(motionEvent.getDeviceId(), motionEvent.getSource(), i10, true);
            }
            if (!edgeEffect.isFinished()) {
                edgeEffect.onRelease();
            }
        }
        z9 = false;
        if (edgeEffect2.isFinished()) {
            postInvalidateOnAnimation();
            z10 = z9;
        } else {
            postInvalidateOnAnimation();
            z10 = z9;
        }
        if (z10) {
            velocityTracker.clear();
        }
        if (i12 == 1) {
            q(i12);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i15;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i9, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i9, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i9, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i9, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean n(EdgeEffect edgeEffect, int i9) {
        if (i9 > 0) {
            return true;
        }
        float fA = androidx.core.widget.b.a(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i9) * 0.35f;
        float f6 = this.f7087a * 0.015f;
        double dLog = Math.log(fAbs / f6);
        double d9 = f7082C;
        return ((float) (Math.exp((d9 / (d9 - 1.0d)) * dLog) * ((double) f6))) < fA;
    }

    public final void o(int i9, int i10, boolean z8) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f7088b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f7090d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i10 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z8) {
                this.f7110z.g(2, 1);
            } else {
                q(1);
            }
            this.f7107w = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f7090d.isFinished()) {
                this.f7090d.abortAnimation();
                q(1);
            }
            scrollBy(i9, i10);
        }
        this.f7088b = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = false;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:65:0x010c  */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f6;
        int i9;
        int width;
        int i10;
        int i11;
        int scaledMinimumFlingVelocity;
        int scaledMaximumFlingVelocity;
        boolean z8;
        VelocityTracker velocityTracker;
        float yVelocity;
        float f9;
        long j;
        float f10;
        float fSqrt;
        int i12;
        int i13;
        if (motionEvent.getAction() != 8 || this.f7097l) {
            return false;
        }
        if ((motionEvent.getSource() & 2) == 2) {
            float axisValue = motionEvent.getAxisValue(9);
            width = (int) motionEvent.getX();
            i9 = 9;
            f6 = axisValue;
        } else if ((motionEvent.getSource() & 4194304) == 4194304) {
            float axisValue2 = motionEvent.getAxisValue(26);
            width = getWidth() / 2;
            f6 = axisValue2;
            i9 = 26;
        } else {
            f6 = 0.0f;
            i9 = 0;
            width = 0;
        }
        if (f6 == 0.0f) {
            return false;
        }
        m(-((int) (getVerticalScrollFactorCompat() * f6)), i9, motionEvent, width, 1, (motionEvent.getSource() & ErrorCode.SUB_ERR_SCAN_DEVICE_FAILED) == 8194);
        if (i9 != 0) {
            C0417d c0417d = this.f7086B;
            c0417d.getClass();
            int source = motionEvent.getSource();
            int deviceId = motionEvent.getDeviceId();
            int i14 = c0417d.f4423f;
            int[] iArr = c0417d.f4425h;
            int i15 = 1;
            if (i14 == source && c0417d.f4424g == deviceId && c0417d.f4422e == i9) {
                z8 = false;
                i10 = 20;
                i11 = 0;
            } else {
                Context context = c0417d.f4418a;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                i10 = 20;
                int deviceId2 = motionEvent.getDeviceId();
                int source2 = motionEvent.getSource();
                i11 = 0;
                int i16 = Build.VERSION.SDK_INT;
                if (i16 >= 34) {
                    scaledMinimumFlingVelocity = I.b(viewConfiguration, deviceId2, i9, source2);
                } else {
                    InputDevice device = InputDevice.getDevice(deviceId2);
                    if (device == null || device.getMotionRange(i9, source2) == null) {
                        scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                    } else {
                        Resources resources = context.getResources();
                        int identifier = (source2 == 4194304 && i9 == 26) ? resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                        Objects.requireNonNull(viewConfiguration);
                        if (identifier == -1) {
                            scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                        } else if (identifier == 0 || (scaledMinimumFlingVelocity = resources.getDimensionPixelSize(identifier)) < 0) {
                            scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                        }
                    }
                }
                iArr[0] = scaledMinimumFlingVelocity;
                int deviceId3 = motionEvent.getDeviceId();
                int source3 = motionEvent.getSource();
                if (i16 >= 34) {
                    scaledMaximumFlingVelocity = I.a(viewConfiguration, deviceId3, i9, source3);
                } else {
                    InputDevice device2 = InputDevice.getDevice(deviceId3);
                    if ((device2 == null || device2.getMotionRange(i9, source3) == null) ? false : true) {
                        Resources resources2 = context.getResources();
                        int identifier2 = (source3 == 4194304 && i9 == 26) ? resources2.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                        Objects.requireNonNull(viewConfiguration);
                        if (identifier2 == -1) {
                            scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                        } else if (identifier2 == 0 || (scaledMaximumFlingVelocity = resources2.getDimensionPixelSize(identifier2)) < 0) {
                            scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                        }
                    } else {
                        scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                    }
                }
                iArr[1] = scaledMaximumFlingVelocity;
                c0417d.f4423f = source;
                c0417d.f4424g = deviceId;
                c0417d.f4422e = i9;
                z8 = true;
            }
            if (iArr[i11] == Integer.MAX_VALUE) {
                VelocityTracker velocityTracker2 = c0417d.f4420c;
                if (velocityTracker2 == null) {
                    return true;
                }
                velocityTracker2.recycle();
                c0417d.f4420c = null;
                return true;
            }
            if (c0417d.f4420c == null) {
                c0417d.f4420c = VelocityTracker.obtain();
            }
            VelocityTracker velocityTracker3 = c0417d.f4420c;
            Map<VelocityTracker, A> map = C0438z.f4460a;
            velocityTracker3.addMovement(motionEvent);
            if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
                Map<VelocityTracker, A> map2 = C0438z.f4460a;
                if (!map2.containsKey(velocityTracker3)) {
                    map2.put(velocityTracker3, new A());
                }
                A a3 = map2.get(velocityTracker3);
                a3.getClass();
                long eventTime = motionEvent.getEventTime();
                int i17 = a3.f4311d;
                long[] jArr = a3.f4309b;
                if (i17 != 0 && eventTime - jArr[a3.f4312e] > 40) {
                    a3.f4311d = i11;
                    a3.f4310c = 0.0f;
                }
                int i18 = (a3.f4312e + 1) % 20;
                a3.f4312e = i18;
                int i19 = a3.f4311d;
                if (i19 != i10) {
                    a3.f4311d = i19 + 1;
                }
                a3.f4308a[i18] = motionEvent.getAxisValue(26);
                jArr[a3.f4312e] = eventTime;
            }
            float f11 = Float.MAX_VALUE;
            velocityTracker3.computeCurrentVelocity(1000, Float.MAX_VALUE);
            A a9 = C0438z.f4460a.get(velocityTracker3);
            if (a9 != null) {
                int i20 = a9.f4311d;
                if (i20 < 2) {
                    velocityTracker = velocityTracker3;
                    f10 = Float.MAX_VALUE;
                    i12 = 1000;
                    fSqrt = 0.0f;
                } else {
                    int i21 = a9.f4312e;
                    int i22 = ((i21 + 20) - (i20 - 1)) % 20;
                    long[] jArr2 = a9.f4309b;
                    long j8 = jArr2[i21];
                    while (true) {
                        j = jArr2[i22];
                        if (j8 - j <= 100) {
                            break;
                        }
                        a9.f4311d--;
                        i22 = (i22 + 1) % 20;
                    }
                    int i23 = a9.f4311d;
                    if (i23 < 2) {
                        velocityTracker = velocityTracker3;
                        f10 = Float.MAX_VALUE;
                        i12 = 1000;
                        fSqrt = 0.0f;
                    } else {
                        float[] fArr = a9.f4308a;
                        if (i23 == 2) {
                            int i24 = (i22 + 1) % 20;
                            long j9 = jArr2[i24];
                            if (j == j9) {
                                velocityTracker = velocityTracker3;
                                f10 = Float.MAX_VALUE;
                                i12 = 1000;
                                fSqrt = 0.0f;
                            } else {
                                velocityTracker = velocityTracker3;
                                f10 = Float.MAX_VALUE;
                                i12 = 1000;
                                fSqrt = fArr[i24] / (j9 - j);
                            }
                        } else {
                            float f12 = 0.0f;
                            int i25 = 0;
                            int i26 = 0;
                            while (true) {
                                if (i25 >= a9.f4311d - 1) {
                                    break;
                                }
                                int i27 = i25 + i22;
                                long j10 = jArr2[i27 % 20];
                                int i28 = (i27 + 1) % 20;
                                if (jArr2[i28] == j10) {
                                    i13 = i15;
                                } else {
                                    i26++;
                                    float fSqrt2 = (f12 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f12) * 2.0f));
                                    float f13 = fArr[i28] / (jArr2[i28] - j10);
                                    float fAbs = (Math.abs(f13) * (f13 - fSqrt2)) + f12;
                                    i13 = i15;
                                    if (i26 == i13) {
                                        fAbs *= 0.5f;
                                    }
                                    f12 = fAbs;
                                }
                                i25 += i13;
                                f11 = f11;
                                i15 = i13;
                                velocityTracker3 = velocityTracker3;
                            }
                            velocityTracker = velocityTracker3;
                            f10 = f11;
                            fSqrt = ((float) Math.sqrt(Math.abs(f12) * 2.0f)) * (f12 < 0.0f ? -1.0f : 1.0f);
                            i12 = 1000;
                        }
                    }
                }
                float f14 = fSqrt * i12;
                a9.f4310c = f14;
                if (f14 < (-Math.abs(f10))) {
                    a9.f4310c = -Math.abs(f10);
                } else if (a9.f4310c > Math.abs(f10)) {
                    a9.f4310c = Math.abs(f10);
                }
            } else {
                velocityTracker = velocityTracker3;
            }
            if (Build.VERSION.SDK_INT >= 34) {
                yVelocity = C0438z.a.a(velocityTracker, i9);
            } else {
                VelocityTracker velocityTracker4 = velocityTracker;
                if (i9 == 0) {
                    yVelocity = velocityTracker4.getXVelocity();
                } else if (i9 == 1) {
                    yVelocity = velocityTracker4.getYVelocity();
                } else {
                    A a10 = C0438z.f4460a.get(velocityTracker4);
                    yVelocity = (a10 == null || i9 != 26) ? 0.0f : a10.f4310c;
                }
            }
            NestedScrollView nestedScrollView = NestedScrollView.this;
            float f15 = yVelocity * (-nestedScrollView.getVerticalScrollFactorCompat());
            float fSignum = Math.signum(f15);
            if (z8 || (fSignum != Math.signum(c0417d.f4421d) && fSignum != 0.0f)) {
                nestedScrollView.f7090d.abortAnimation();
            }
            if (Math.abs(f15) >= iArr[0]) {
                int i29 = iArr[1];
                float fMax = Math.max(-i29, Math.min(f15, i29));
                if (fMax == 0.0f) {
                    f9 = 0.0f;
                } else {
                    nestedScrollView.f7090d.abortAnimation();
                    nestedScrollView.d((int) fMax);
                    f9 = fMax;
                }
                c0417d.f4421d = f9;
                return true;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x0119  */
    /* JADX WARN: Code duplicated, block: B:70:0x012f  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int action = motionEvent.getAction();
        boolean z8 = true;
        if (action == 2 && this.f7097l) {
            return true;
        }
        int i9 = action & 255;
        if (i9 == 0) {
            int y8 = (int) motionEvent.getY();
            int x8 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y8 < childAt.getTop() - scrollY || y8 >= childAt.getBottom() - scrollY || x8 < childAt.getLeft() || x8 >= childAt.getRight()) {
                    if (!p(motionEvent) && this.f7090d.isFinished()) {
                        z8 = false;
                    }
                    this.f7097l = z8;
                    velocityTracker = this.f7098m;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.f7098m = null;
                    }
                } else {
                    this.f7094h = y8;
                    this.f7104s = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker3 = this.f7098m;
                    if (velocityTracker3 == null) {
                        this.f7098m = VelocityTracker.obtain();
                    } else {
                        velocityTracker3.clear();
                    }
                    this.f7098m.addMovement(motionEvent);
                    this.f7090d.computeScrollOffset();
                    if (!p(motionEvent) && this.f7090d.isFinished()) {
                        z8 = false;
                    }
                    this.f7097l = z8;
                    this.f7110z.g(2, 0);
                }
            } else {
                if (!p(motionEvent)) {
                    z8 = false;
                }
                this.f7097l = z8;
                velocityTracker = this.f7098m;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f7098m = null;
                }
            }
        } else if (i9 == 1) {
            this.f7097l = false;
            this.f7104s = -1;
            velocityTracker2 = this.f7098m;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f7098m = null;
            }
            if (this.f7090d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            q(0);
        } else if (i9 == 2) {
            int i10 = this.f7104s;
            if (i10 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i10 + " in onInterceptTouchEvent");
                } else {
                    int y9 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y9 - this.f7094h) > this.f7101p && (2 & getNestedScrollAxes()) == 0) {
                        this.f7097l = true;
                        this.f7094h = y9;
                        if (this.f7098m == null) {
                            this.f7098m = VelocityTracker.obtain();
                        }
                        this.f7098m.addMovement(motionEvent);
                        this.f7106v = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i9 == 3) {
            this.f7097l = false;
            this.f7104s = -1;
            velocityTracker2 = this.f7098m;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f7098m = null;
            }
            if (this.f7090d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            q(0);
        } else if (i9 == 6) {
            i(motionEvent);
        }
        return this.f7097l;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int measuredHeight;
        super.onLayout(z8, i9, i10, i11, i12);
        int i13 = 0;
        this.f7095i = false;
        View view = this.f7096k;
        if (view != null && f(view, this)) {
            View view2 = this.f7096k;
            Rect rect = this.f7089c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iB = b(rect);
            if (iB != 0) {
                scrollBy(0, iB);
            }
        }
        this.f7096k = null;
        if (!this.j) {
            if (this.f7108x != null) {
                scrollTo(getScrollX(), this.f7108x.f7111a);
                this.f7108x = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i13 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i13 != scrollY) {
                scrollTo(getScrollX(), i13);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.j = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (this.f7099n && View.MeasureSpec.getMode(i10) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i9, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f6, float f9, boolean z8) {
        if (z8) {
            return false;
        }
        dispatchNestedFling(0.0f, f9, true);
        d((int) f9);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f6, float f9) {
        return this.f7110z.b(f6, f9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr) {
        this.f7110z.c(i9, i10, iArr, null, 0);
    }

    @Override // T.InterfaceC0430q
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13, int[] iArr) {
        h(i12, i13, iArr);
    }

    @Override // T.InterfaceC0429p
    public final void onNestedScrollAccepted(View view, View view2, int i9, int i10) {
        r rVar = this.f7109y;
        if (i10 == 1) {
            rVar.f4451b = i9;
        } else {
            rVar.f4450a = i9;
        }
        this.f7110z.g(2, i10);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i9, int i10, boolean z8, boolean z9) {
        super.scrollTo(i9, i10);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i9, Rect rect) {
        if (i9 == 2) {
            i9 = 130;
        } else if (i9 == 1) {
            i9 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i9) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i9);
        if (viewFindNextFocus != null && g(viewFindNextFocus, 0, getHeight())) {
            return viewFindNextFocus.requestFocus(i9, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f7108x = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7111a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i9, int i10, int i11, int i12) {
        super.onScrollChanged(i9, i10, i11, i12);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !g(viewFindFocus, 0, i12)) {
            return;
        }
        Rect rect = this.f7089c;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iB = b(rect);
        if (iB != 0) {
            if (this.f7100o) {
                o(0, iB, false);
            } else {
                scrollBy(0, iB);
            }
        }
    }

    @Override // T.InterfaceC0429p
    public final boolean onStartNestedScroll(View view, View view2, int i9, int i10) {
        return (i9 & 2) != 0;
    }

    @Override // T.InterfaceC0429p
    public final void onStopNestedScroll(View view, int i9) {
        r rVar = this.f7109y;
        if (i9 == 1) {
            rVar.f4451b = 0;
        } else {
            rVar.f4450a = 0;
        }
        q(i9);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0124  */
    /* JADX WARN: Code duplicated, block: B:56:0x013a  */
    /* JADX WARN: Code duplicated, block: B:59:0x0141  */
    /* JADX WARN: Code duplicated, block: B:60:0x0145  */
    /* JADX WARN: Code duplicated, block: B:63:0x014c  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        float fB;
        int iRound;
        int i9;
        ViewParent parent2;
        if (this.f7098m == null) {
            this.f7098m = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f7106v = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float f6 = 0.0f;
        motionEventObtain.offsetLocation(0.0f, this.f7106v);
        C0428o c0428o = this.f7110z;
        if (actionMasked != 0) {
            EdgeEffect edgeEffect = this.f7092f;
            EdgeEffect edgeEffect2 = this.f7091e;
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f7098m;
                velocityTracker.computeCurrentVelocity(1000, this.f7103r);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f7104s);
                if (Math.abs(yVelocity) >= this.f7102q) {
                    if (androidx.core.widget.b.a(edgeEffect2) != 0.0f) {
                        if (n(edgeEffect2, yVelocity)) {
                            edgeEffect2.onAbsorb(yVelocity);
                        } else {
                            d(-yVelocity);
                        }
                    } else if (androidx.core.widget.b.a(edgeEffect) != 0.0f) {
                        int i10 = -yVelocity;
                        if (n(edgeEffect, i10)) {
                            edgeEffect.onAbsorb(i10);
                        } else {
                            d(i10);
                        }
                    } else {
                        int i11 = -yVelocity;
                        float f9 = i11;
                        if (!c0428o.b(0.0f, f9)) {
                            dispatchNestedFling(0.0f, f9, true);
                            d(i11);
                        }
                    }
                } else if (this.f7090d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f7104s = -1;
                this.f7097l = false;
                VelocityTracker velocityTracker2 = this.f7098m;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f7098m = null;
                }
                q(0);
                this.f7091e.onRelease();
                this.f7092f.onRelease();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f7104s);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f7104s + " in onTouchEvent");
                } else {
                    int y8 = (int) motionEvent.getY(iFindPointerIndex);
                    int i12 = this.f7094h - y8;
                    float x8 = motionEvent.getX(iFindPointerIndex) / getWidth();
                    float height = i12 / getHeight();
                    if (androidx.core.widget.b.a(edgeEffect2) != 0.0f) {
                        fB = -androidx.core.widget.b.b(edgeEffect2, -height, x8);
                        if (androidx.core.widget.b.a(edgeEffect2) == 0.0f) {
                            edgeEffect2.onRelease();
                        }
                    } else if (androidx.core.widget.b.a(edgeEffect) != 0.0f) {
                        fB = androidx.core.widget.b.b(edgeEffect, height, 1.0f - x8);
                        if (androidx.core.widget.b.a(edgeEffect) == 0.0f) {
                            edgeEffect.onRelease();
                        }
                    } else {
                        iRound = Math.round(f6 * getHeight());
                        if (iRound != 0) {
                            invalidate();
                        }
                        i9 = i12 - iRound;
                        if (!this.f7097l && Math.abs(i9) > this.f7101p) {
                            parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.f7097l = true;
                            if (i9 > 0) {
                                i9 -= this.f7101p;
                            } else {
                                i9 += this.f7101p;
                            }
                        }
                        if (this.f7097l) {
                            int iM = m(i9, 1, motionEvent, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                            this.f7094h = y8 - iM;
                            this.f7106v += iM;
                        }
                    }
                    f6 = fB;
                    iRound = Math.round(f6 * getHeight());
                    if (iRound != 0) {
                        invalidate();
                    }
                    i9 = i12 - iRound;
                    if (!this.f7097l) {
                        parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f7097l = true;
                        if (i9 > 0) {
                            i9 -= this.f7101p;
                        } else {
                            i9 += this.f7101p;
                        }
                    }
                    if (this.f7097l) {
                        int iM2 = m(i9, 1, motionEvent, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f7094h = y8 - iM2;
                        this.f7106v += iM2;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f7097l && getChildCount() > 0 && this.f7090d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f7104s = -1;
                this.f7097l = false;
                VelocityTracker velocityTracker3 = this.f7098m;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f7098m = null;
                }
                q(0);
                this.f7091e.onRelease();
                this.f7092f.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f7094h = (int) motionEvent.getY(actionIndex);
                this.f7104s = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                i(motionEvent);
                this.f7094h = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f7104s));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f7097l && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f7090d.isFinished()) {
                this.f7090d.abortAnimation();
                q(1);
            }
            int y9 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.f7094h = y9;
            this.f7104s = pointerId;
            c0428o.g(2, 0);
        }
        VelocityTracker velocityTracker4 = this.f7098m;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final boolean p(MotionEvent motionEvent) {
        boolean z8;
        EdgeEffect edgeEffect = this.f7091e;
        if (androidx.core.widget.b.a(edgeEffect) != 0.0f) {
            androidx.core.widget.b.b(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z8 = true;
        } else {
            z8 = false;
        }
        EdgeEffect edgeEffect2 = this.f7092f;
        if (androidx.core.widget.b.a(edgeEffect2) == 0.0f) {
            return z8;
        }
        androidx.core.widget.b.b(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void q(int i9) {
        this.f7110z.h(i9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f7095i) {
            this.f7096k = view2;
        } else {
            Rect rect = this.f7089c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iB = b(rect);
            if (iB != 0) {
                scrollBy(0, iB);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z8) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iB = b(rect);
        boolean z9 = iB != 0;
        if (z9) {
            if (z8) {
                scrollBy(0, iB);
                return z9;
            }
            o(0, iB, false);
        }
        return z9;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z8) {
        VelocityTracker velocityTracker;
        if (z8 && (velocityTracker = this.f7098m) != null) {
            velocityTracker.recycle();
            this.f7098m = null;
        }
        super.requestDisallowInterceptTouchEvent(z8);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f7095i = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public final void scrollTo(int i9, int i10) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i9 < 0) {
                i9 = 0;
            } else if (width + i9 > width2) {
                i9 = width2 - width;
            }
            if (height >= height2 || i10 < 0) {
                i10 = 0;
            } else if (height + i10 > height2) {
                i10 = height2 - height;
            }
            if (i9 == getScrollX() && i10 == getScrollY()) {
                return;
            }
            super.scrollTo(i9, i10);
        }
    }

    public void setFillViewport(boolean z8) {
        if (z8 != this.f7099n) {
            this.f7099n = z8;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z8) {
        C0428o c0428o = this.f7110z;
        if (c0428o.f4448d) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            c0428o.f4447c.stopNestedScroll();
        }
        c0428o.f4448d = z8;
    }

    public void setSmoothScrollingEnabled(boolean z8) {
        this.f7100o = z8;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i9) {
        return this.f7110z.g(i9, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        q(0);
    }

    @Override // T.InterfaceC0429p
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr, int i11) {
        this.f7110z.c(i9, i10, iArr, null, i11);
    }

    @Override // T.InterfaceC0429p
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13) {
        h(i12, i13, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i9) {
        return onStartNestedScroll(view, view2, i9, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12) {
        h(i12, 0, null);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9) {
        if (getChildCount() <= 0) {
            super.addView(view, i9);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i9) {
        onNestedScrollAccepted(view, view2, i9, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i9, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(d dVar) {
    }
}
