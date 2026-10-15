package androidx.swiperefreshlayout.widget;

import T.C0428o;
import T.G;
import T.InterfaceC0427n;
import T.InterfaceC0429p;
import T.InterfaceC0430q;
import T.L;
import T.r;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements InterfaceC0430q, InterfaceC0429p, InterfaceC0427n {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {R.attr.enabled};
    private static final String LOG_TAG = "SwipeRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private i mChildScrollUpCallback;
    private int mCircleDiameter;
    androidx.swiperefreshlayout.widget.a mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private boolean mEnableLegacyRequestDisallowInterceptTouch;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    j mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final C0428o mNestedScrollingChildHelper;
    private final r mNestedScrollingParentHelper;
    private final int[] mNestedScrollingV2ConsumedCompat;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    androidx.swiperefreshlayout.widget.d mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f6, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f6);
        }
    }

    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f6, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f6);
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8362b;

        public d(int i9, int i10) {
            this.f8361a = i9;
            this.f8362b = i10;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f6, Transformation transformation) {
            androidx.swiperefreshlayout.widget.d dVar = SwipeRefreshLayout.this.mProgress;
            int i9 = this.f8361a;
            dVar.setAlpha((int) (((this.f8362b - i9) * f6) + i9));
        }
    }

    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f6, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.mUsingCustomStart ? swipeRefreshLayout.mSpinnerOffsetEnd - Math.abs(swipeRefreshLayout.mOriginalOffsetTop) : swipeRefreshLayout.mSpinnerOffsetEnd;
            int i9 = swipeRefreshLayout.mFrom;
            swipeRefreshLayout.setTargetOffsetTopAndBottom((i9 + ((int) ((iAbs - i9) * f6))) - swipeRefreshLayout.mCircleView.getTop());
            androidx.swiperefreshlayout.widget.d dVar = swipeRefreshLayout.mProgress;
            float f9 = 1.0f - f6;
            androidx.swiperefreshlayout.widget.d.a aVar = dVar.f8377a;
            if (f9 != aVar.f8397p) {
                aVar.f8397p = f9;
            }
            dVar.invalidateSelf();
        }
    }

    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f6, Transformation transformation) {
            SwipeRefreshLayout.this.moveToStart(f6);
        }
    }

    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f6, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f9 = swipeRefreshLayout.mStartingScale;
            swipeRefreshLayout.setAnimationProgress(((-f9) * f6) + f9);
            swipeRefreshLayout.moveToStart(f6);
        }
    }

    public interface i {
        boolean canChildScrollUp(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface j {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void animateOffsetToCorrectPosition(int i9, Animation.AnimationListener animationListener) {
        this.mFrom = i9;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.f8368a = animationListener;
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i9, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i9, animationListener);
            return;
        }
        this.mFrom = i9;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.f8368a = animationListener;
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void createProgressView() {
        androidx.swiperefreshlayout.widget.a aVar = new androidx.swiperefreshlayout.widget.a(getContext());
        float f6 = aVar.getContext().getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = aVar.getContext().obtainStyledAttributes(p148t0.a.f21384a);
        aVar.f8369b = typedArrayObtainStyledAttributes.getColor(0, -328966);
        typedArrayObtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        aVar.setElevation(f6 * 4.0f);
        shapeDrawable.getPaint().setColor(aVar.f8369b);
        aVar.setBackground(shapeDrawable);
        this.mCircleView = aVar;
        androidx.swiperefreshlayout.widget.d dVar = new androidx.swiperefreshlayout.widget.d(getContext());
        this.mProgress = dVar;
        dVar.c(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                View childAt = getChildAt(i9);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private void finishSpinner(float f6) {
        if (f6 > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        androidx.swiperefreshlayout.widget.d dVar = this.mProgress;
        androidx.swiperefreshlayout.widget.d.a aVar = dVar.f8377a;
        aVar.f8387e = 0.0f;
        aVar.f8388f = 0.0f;
        dVar.invalidateSelf();
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, !this.mScale ? new e() : null);
        androidx.swiperefreshlayout.widget.d dVar2 = this.mProgress;
        androidx.swiperefreshlayout.widget.d.a aVar2 = dVar2.f8377a;
        if (aVar2.f8395n) {
            aVar2.f8395n = false;
        }
        dVar2.invalidateSelf();
    }

    private boolean isAnimationRunning(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void moveSpinner(float f6) {
        androidx.swiperefreshlayout.widget.d dVar = this.mProgress;
        androidx.swiperefreshlayout.widget.d.a aVar = dVar.f8377a;
        if (!aVar.f8395n) {
            aVar.f8395n = true;
        }
        dVar.invalidateSelf();
        float fMin = Math.min(1.0f, Math.abs(f6 / this.mTotalDragDistance));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f6) - this.mTotalDragDistance;
        int i9 = this.mCustomSlingshotDistance;
        if (i9 <= 0) {
            i9 = this.mUsingCustomStart ? this.mSpinnerOffsetEnd - this.mOriginalOffsetTop : this.mSpinnerOffsetEnd;
        }
        float f9 = i9;
        double dMax = Math.max(0.0f, Math.min(fAbs, f9 * DECELERATE_INTERPOLATION_FACTOR) / f9) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
        int i10 = this.mOriginalOffsetTop + ((int) ((f9 * fMin) + (f9 * fPow * DECELERATE_INTERPOLATION_FACTOR)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f6 / this.mTotalDragDistance));
        }
        if (f6 < this.mTotalDragDistance) {
            if (this.mProgress.f8377a.t > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
        } else if (this.mProgress.f8377a.t < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
        }
        float f10 = fMax * MAX_PROGRESS_ANGLE;
        androidx.swiperefreshlayout.widget.d dVar2 = this.mProgress;
        float fMin2 = Math.min(MAX_PROGRESS_ANGLE, f10);
        androidx.swiperefreshlayout.widget.d.a aVar2 = dVar2.f8377a;
        aVar2.f8387e = 0.0f;
        aVar2.f8388f = fMin2;
        dVar2.invalidateSelf();
        androidx.swiperefreshlayout.widget.d dVar3 = this.mProgress;
        float fMin3 = Math.min(1.0f, fMax);
        androidx.swiperefreshlayout.widget.d.a aVar3 = dVar3.f8377a;
        if (fMin3 != aVar3.f8397p) {
            aVar3.f8397p = fMin3;
        }
        dVar3.invalidateSelf();
        float f11 = ((fPow * DECELERATE_INTERPOLATION_FACTOR) + ((fMax * 0.4f) - 0.25f)) * DRAG_RATE;
        androidx.swiperefreshlayout.widget.d dVar4 = this.mProgress;
        dVar4.f8377a.f8389g = f11;
        dVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i10 - this.mCurrentTargetOffsetTop);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void setColorViewAlpha(int i9) {
        this.mCircleView.getBackground().setAlpha(i9);
        this.mProgress.setAlpha(i9);
    }

    private Animation startAlphaAnimation(int i9, int i10) {
        d dVar = new d(i9, i10);
        dVar.setDuration(300L);
        androidx.swiperefreshlayout.widget.a aVar = this.mCircleView;
        aVar.f8368a = null;
        aVar.clearAnimation();
        this.mCircleView.startAnimation(dVar);
        return dVar;
    }

    private void startDragging(float f6) {
        float f9 = this.mInitialDownY;
        float f10 = f6 - f9;
        int i9 = this.mTouchSlop;
        if (f10 <= i9 || this.mIsBeingDragged) {
            return;
        }
        this.mInitialMotionY = f9 + i9;
        this.mIsBeingDragged = true;
        this.mProgress.setAlpha(76);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.f8377a.t, 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.f8377a.t, 76);
    }

    private void startScaleDownReturnToStartAnimation(int i9, Animation.AnimationListener animationListener) {
        this.mFrom = i9;
        this.mStartingScale = this.mCircleView.getScaleX();
        h hVar = new h();
        this.mScaleDownToStartAnimation = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.mCircleView.f8368a = animationListener;
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        b bVar = new b();
        this.mScaleAnimation = bVar;
        bVar.setDuration(this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.f8368a = animationListener;
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public boolean canChildScrollUp() {
        i iVar = this.mChildScrollUpCallback;
        if (iVar != null) {
            return iVar.canChildScrollUp(this, this.mTarget);
        }
        View view = this.mTarget;
        return view instanceof ListView ? ((ListView) view).canScrollList(-1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f6, float f9, boolean z8) {
        return this.mNestedScrollingChildHelper.a(f6, f9, z8);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f6, float f9) {
        return this.mNestedScrollingChildHelper.b(f6, f9);
    }

    public boolean dispatchNestedPreScroll(int i9, int i10, int[] iArr, int[] iArr2, int i11) {
        return i11 == 0 && dispatchNestedPreScroll(i9, i10, iArr, iArr2);
    }

    public void dispatchNestedScroll(int i9, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        if (i13 == 0) {
            this.mNestedScrollingChildHelper.d(i9, i10, i11, i12, iArr, i13, iArr2);
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i9, int i10) {
        int i11 = this.mCircleViewIndex;
        if (i11 < 0) {
            return i10;
        }
        if (i10 == i9 - 1) {
            return i11;
        }
        return i10 >= i11 ? i10 + 1 : i10;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        r rVar = this.mNestedScrollingParentHelper;
        return rVar.f4451b | rVar.f4450a;
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public boolean hasNestedScrollingParent(int i9) {
        return i9 == 0 && hasNestedScrollingParent();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.f4448d;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public void moveToStart(float f6) {
        int i9 = this.mFrom;
        setTargetOffsetTopAndBottom((i9 + ((int) ((this.mOriginalOffsetTop - i9) * f6))) - this.mCircleView.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            int iFindPointerIndex = motionEvent.findPointerIndex(pointerId);
            if (iFindPointerIndex < 0) {
                return false;
            }
            this.mInitialDownY = motionEvent.getY(iFindPointerIndex);
        } else if (actionMasked == 1) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else if (actionMasked == 2) {
            int i9 = this.mActivePointerId;
            if (i9 == -1) {
                Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                return false;
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(i9);
            if (iFindPointerIndex2 < 0) {
                return false;
            }
            startDragging(motionEvent.getY(iFindPointerIndex2));
        } else if (actionMasked == 3) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else if (actionMasked == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        int measuredHeight2 = this.mCircleView.getMeasuredHeight();
        int i13 = measuredWidth / 2;
        int i14 = measuredWidth2 / 2;
        int i15 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(i13 - i14, i15, i13 + i14, measuredHeight2 + i15);
    }

    @Override // android.view.View
    public void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
        this.mCircleViewIndex = -1;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == this.mCircleView) {
                this.mCircleViewIndex = i11;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f6, float f9, boolean z8) {
        return dispatchNestedFling(f6, f9, z8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f6, float f9) {
        return dispatchNestedPreFling(f6, f9);
    }

    @Override // T.InterfaceC0429p
    public void onNestedPreScroll(View view, int i9, int i10, int[] iArr, int i11) {
        if (i11 == 0) {
            onNestedPreScroll(view, i9, i10, iArr);
        }
    }

    @Override // T.InterfaceC0430q
    public void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13, int[] iArr) {
        if (i13 != 0) {
            return;
        }
        int i14 = iArr[1];
        dispatchNestedScroll(i9, i10, i11, i12, this.mParentOffsetInWindow, i13, iArr);
        int i15 = i12 - (iArr[1] - i14);
        int i16 = i15 == 0 ? i12 + this.mParentOffsetInWindow[1] : i15;
        if (i16 >= 0 || canChildScrollUp()) {
            return;
        }
        float fAbs = this.mTotalUnconsumed + Math.abs(i16);
        this.mTotalUnconsumed = fAbs;
        moveSpinner(fAbs);
        iArr[1] = iArr[1] + i15;
    }

    @Override // T.InterfaceC0429p
    public void onNestedScrollAccepted(View view, View view2, int i9, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i9);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f8357a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mRefreshing);
    }

    @Override // T.InterfaceC0429p
    public boolean onStartNestedScroll(View view, View view2, int i9, int i10) {
        if (i10 == 0) {
            return onStartNestedScroll(view, view2, i9);
        }
        return false;
    }

    @Override // T.InterfaceC0429p
    public void onStopNestedScroll(View view, int i9) {
        if (i9 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.mIsBeingDragged) {
                    float y8 = (motionEvent.getY(iFindPointerIndex) - this.mInitialMotionY) * DRAG_RATE;
                    this.mIsBeingDragged = false;
                    finishSpinner(y8);
                }
                this.mActivePointerId = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex2 < 0) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y9 = motionEvent.getY(iFindPointerIndex2);
                startDragging(y9);
                if (this.mIsBeingDragged) {
                    float f6 = (y9 - this.mInitialMotionY) * DRAG_RATE;
                    if (f6 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    moveSpinner(f6);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z8) {
        ViewParent parent;
        View view = this.mTarget;
        if (view != null) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            if (!view.isNestedScrollingEnabled()) {
                if (this.mEnableLegacyRequestDisallowInterceptTouch || (parent = getParent()) == null) {
                    return;
                }
                parent.requestDisallowInterceptTouchEvent(z8);
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z8);
    }

    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public void setAnimationProgress(float f6) {
        this.mCircleView.setScaleX(f6);
        this.mCircleView.setScaleY(f6);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        androidx.swiperefreshlayout.widget.d dVar = this.mProgress;
        androidx.swiperefreshlayout.widget.d.a aVar = dVar.f8377a;
        aVar.f8391i = iArr;
        aVar.a(0);
        aVar.a(0);
        dVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i9 = 0; i9 < iArr.length; i9++) {
            iArr2[i9] = context.getColor(iArr[i9]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i9) {
        this.mTotalDragDistance = i9;
    }

    @Override // android.view.View
    public void setEnabled(boolean z8) {
        super.setEnabled(z8);
        if (z8) {
            return;
        }
        reset();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z8) {
        this.mEnableLegacyRequestDisallowInterceptTouch = z8;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z8) {
        C0428o c0428o = this.mNestedScrollingChildHelper;
        if (c0428o.f4448d) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            c0428o.f4447c.stopNestedScroll();
        }
        c0428o.f4448d = z8;
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.mChildScrollUpCallback = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.mListener = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i9) {
        setProgressBackgroundColorSchemeResource(i9);
    }

    public void setProgressBackgroundColorSchemeColor(int i9) {
        this.mCircleView.setBackgroundColor(i9);
    }

    public void setProgressBackgroundColorSchemeResource(int i9) {
        setProgressBackgroundColorSchemeColor(getContext().getColor(i9));
    }

    public void setProgressViewEndTarget(boolean z8, int i9) {
        this.mSpinnerOffsetEnd = i9;
        this.mScale = z8;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z8, int i9, int i10) {
        this.mScale = z8;
        this.mOriginalOffsetTop = i9;
        this.mSpinnerOffsetEnd = i10;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean z8) {
        if (!z8 || this.mRefreshing == z8) {
            setRefreshing(z8, false);
            return;
        }
        this.mRefreshing = z8;
        setTargetOffsetTopAndBottom((!this.mUsingCustomStart ? this.mSpinnerOffsetEnd + this.mOriginalOffsetTop : this.mSpinnerOffsetEnd) - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    public void setSize(int i9) {
        if (i9 == 0 || i9 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i9 == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.c(i9);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public void setSlingshotDistance(int i9) {
        this.mCustomSlingshotDistance = i9;
    }

    public void setTargetOffsetTopAndBottom(int i9) {
        this.mCircleView.bringToFront();
        androidx.swiperefreshlayout.widget.a aVar = this.mCircleView;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        aVar.offsetTopAndBottom(i9);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public boolean startNestedScroll(int i9, int i10) {
        return i10 == 0 && startNestedScroll(i9);
    }

    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.mScaleDownAnimation = cVar;
        cVar.setDuration(150L);
        androidx.swiperefreshlayout.widget.a aVar = this.mCircleView;
        aVar.f8368a = animationListener;
        aVar.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    public void stopNestedScroll(int i9) {
        if (i9 == 0) {
            stopNestedScroll();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f8357a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i9) {
                return new SavedState[i9];
            }
        }

        public SavedState(Parcelable parcelable, boolean z8) {
            super(parcelable);
            this.f8357a = z8;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeByte(this.f8357a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f8357a = parcel.readByte() != 0;
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new a();
        this.mAnimateToCorrectPosition = new f();
        this.mAnimateToStartPosition = new g();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        int i9 = (int) (displayMetrics.density * 64.0f);
        this.mSpinnerOffsetEnd = i9;
        this.mTotalDragDistance = i9;
        this.mNestedScrollingParentHelper = new r();
        this.mNestedScrollingChildHelper = new C0428o(this);
        setNestedScrollingEnabled(true);
        int i10 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i10;
        this.mOriginalOffsetTop = i10;
        moveToStart(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i9, int i10, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.c(i9, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.f(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i9, int i10, int[] iArr) {
        if (i10 > 0) {
            float f6 = this.mTotalUnconsumed;
            if (f6 > 0.0f) {
                float f9 = i10;
                if (f9 > f6) {
                    iArr[1] = (int) f6;
                    this.mTotalUnconsumed = 0.0f;
                } else {
                    this.mTotalUnconsumed = f6 - f9;
                    iArr[1] = i10;
                }
                moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i10 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i10 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i9 - iArr[0], i10 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i9) {
        this.mNestedScrollingParentHelper.f4450a = i9;
        startNestedScroll(i9 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i9) {
        return (!isEnabled() || this.mReturningToStart || this.mRefreshing || (i9 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.f4450a = 0;
        this.mNestedScrollInProgress = false;
        float f6 = this.mTotalUnconsumed;
        if (f6 > 0.0f) {
            finishSpinner(f6);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i9) {
        return this.mNestedScrollingChildHelper.g(i9, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.h(0);
    }

    public boolean dispatchNestedScroll(int i9, int i10, int i11, int i12, int[] iArr, int i13) {
        return i13 == 0 && this.mNestedScrollingChildHelper.d(i9, i10, i11, i12, iArr, i13, null);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i9, int i10, int i11, int i12, int[] iArr) {
        return this.mNestedScrollingChildHelper.d(i9, i10, i11, i12, iArr, 0, null);
    }

    @Override // T.InterfaceC0429p
    public void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i9, i10, i11, i12, i13, this.mNestedScrollingV2ConsumedCompat);
    }

    private void setRefreshing(boolean z8, boolean z9) {
        if (this.mRefreshing != z8) {
            this.mNotify = z9;
            ensureTarget();
            this.mRefreshing = z8;
            if (z8) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i9, int i10, int i11, int i12) {
        onNestedScroll(view, i9, i10, i11, i12, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.mRefreshing) {
                swipeRefreshLayout.reset();
                return;
            }
            swipeRefreshLayout.mProgress.setAlpha(255);
            swipeRefreshLayout.mProgress.start();
            if (swipeRefreshLayout.mNotify && (jVar = swipeRefreshLayout.mListener) != null) {
                jVar.onRefresh();
            }
            swipeRefreshLayout.mCurrentTargetOffsetTop = swipeRefreshLayout.mCircleView.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.mScale) {
                return;
            }
            swipeRefreshLayout.startScaleDownAnimation(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }
}
