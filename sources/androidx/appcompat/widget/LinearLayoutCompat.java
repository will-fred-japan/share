package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f6432i;
    public int[] j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f6433k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6434l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6435m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6436n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6437o;

    public static class a extends LinearLayout.LayoutParams {
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final void f(Canvas canvas, int i9) {
        this.f6433k.setBounds(getPaddingLeft() + this.f6437o, i9, (getWidth() - getPaddingRight()) - this.f6437o, this.f6435m + i9);
        this.f6433k.draw(canvas);
    }

    public final void g(Canvas canvas, int i9) {
        this.f6433k.setBounds(i9, getPaddingTop() + this.f6437o, this.f6434l + i9, (getHeight() - getPaddingBottom()) - this.f6437o);
        this.f6433k.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i9;
        if (this.f6425b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i10 = this.f6425b;
        if (childCount <= i10) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i10);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f6425b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f6426c;
        if (this.f6427d == 1 && (i9 = this.f6428e & 112) != 48) {
            if (i9 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f6429f) / 2;
            } else if (i9 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f6429f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f6425b;
    }

    public Drawable getDividerDrawable() {
        return this.f6433k;
    }

    public int getDividerPadding() {
        return this.f6437o;
    }

    public int getDividerWidth() {
        return this.f6434l;
    }

    public int getGravity() {
        return this.f6428e;
    }

    public int getOrientation() {
        return this.f6427d;
    }

    public int getShowDividers() {
        return this.f6436n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f6430g;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i9 = this.f6427d;
        if (i9 == 0) {
            return new a(-2, -2);
        }
        if (i9 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return new a((a) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    public final boolean k(int i9) {
        if (i9 == 0) {
            return (this.f6436n & 1) != 0;
        }
        if (i9 == getChildCount()) {
            return (this.f6436n & 4) != 0;
        }
        if ((this.f6436n & 2) != 0) {
            for (int i10 = i9 - 1; i10 >= 0; i10--) {
                if (getChildAt(i10).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i9;
        int bottom;
        if (this.f6433k == null) {
            return;
        }
        int i10 = 0;
        if (this.f6427d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i10 < virtualChildCount) {
                View childAt = getChildAt(i10);
                if (childAt != null && childAt.getVisibility() != 8 && k(i10)) {
                    f(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin) - this.f6435m);
                }
                i10++;
            }
            if (k(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                if (childAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.f6435m;
                } else {
                    bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) childAt2.getLayoutParams())).bottomMargin;
                }
                f(canvas, bottom);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z8 = Q.f6464a;
        boolean z9 = getLayoutDirection() == 1;
        while (i10 < virtualChildCount2) {
            View childAt3 = getChildAt(i10);
            if (childAt3 != null && childAt3.getVisibility() != 8 && k(i10)) {
                a aVar = (a) childAt3.getLayoutParams();
                g(canvas, z9 ? childAt3.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f6434l);
            }
            i10++;
        }
        if (k(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                a aVar2 = (a) childAt4.getLayoutParams();
                if (z9) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i9 = this.f6434l;
                    right = left - i9;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (z9) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i9 = this.f6434l;
                right = left - i9;
            }
            g(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0159  */
    /* JADX WARN: Code duplicated, block: B:65:0x0162  */
    /* JADX WARN: Code duplicated, block: B:67:0x0166  */
    /* JADX WARN: Code duplicated, block: B:69:0x016a  */
    /* JADX WARN: Code duplicated, block: B:70:0x016e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0176  */
    /* JADX WARN: Code duplicated, block: B:74:0x0182  */
    /* JADX WARN: Code duplicated, block: B:76:0x0189  */
    /* JADX WARN: Code duplicated, block: B:77:0x0190  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a8  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int paddingLeft;
        int i13;
        int i14;
        int i15;
        int i16;
        int baseline;
        int i17;
        int i18;
        int i19;
        int measuredHeight;
        int i20;
        int paddingTop;
        int i21;
        int i22;
        int i23;
        int i24 = 8;
        char c5 = 2;
        if (this.f6427d == 1) {
            int paddingLeft2 = getPaddingLeft();
            int i25 = i11 - i9;
            int paddingRight = i25 - getPaddingRight();
            int paddingRight2 = (i25 - paddingLeft2) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i26 = this.f6428e;
            int i27 = i26 & 112;
            int i28 = 8388615 & i26;
            if (i27 != 16) {
                paddingTop = i27 != 80 ? getPaddingTop() : ((getPaddingTop() + i12) - i10) - this.f6429f;
            } else {
                paddingTop = getPaddingTop() + (((i12 - i10) - this.f6429f) / 2);
            }
            int i29 = 0;
            while (i29 < virtualChildCount) {
                View childAt = getChildAt(i29);
                if (childAt != null && childAt.getVisibility() != i24) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    a aVar = (a) childAt.getLayoutParams();
                    int i30 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i30 < 0) {
                        i30 = i28;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i30, getLayoutDirection()) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i23 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft2;
                        } else {
                            i21 = paddingRight - measuredWidth;
                            i22 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                        }
                        if (k(i29)) {
                            paddingTop += this.f6435m;
                        }
                        int i31 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                        childAt.layout(i23, i31, measuredWidth + i23, i31 + measuredHeight2);
                        paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + i31;
                    } else {
                        i21 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft2 + ((LinearLayout.LayoutParams) aVar).leftMargin;
                        i22 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    i23 = i21 - i22;
                    if (k(i29)) {
                        paddingTop += this.f6435m;
                    }
                    int i32 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    childAt.layout(i23, i32, measuredWidth + i23, i32 + measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + i32;
                }
                i29++;
                c5 = c5;
                i24 = 8;
            }
            return;
        }
        boolean z9 = Q.f6464a;
        boolean z10 = getLayoutDirection() == 1;
        int paddingTop2 = getPaddingTop();
        int i33 = i12 - i10;
        int paddingBottom = i33 - getPaddingBottom();
        int paddingBottom2 = (i33 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i34 = this.f6428e;
        int i35 = 8388615 & i34;
        int i36 = i34 & 112;
        boolean z11 = this.f6424a;
        int[] iArr = this.f6432i;
        int[] iArr2 = this.j;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i35, getLayoutDirection());
        if (absoluteGravity2 != 1) {
            paddingLeft = absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i11) - i9) - this.f6429f;
        } else {
            paddingLeft = getPaddingLeft() + (((i11 - i9) - this.f6429f) / 2);
        }
        if (z10) {
            i14 = virtualChildCount2 - 1;
            i13 = -1;
        } else {
            i13 = 1;
            i14 = 0;
        }
        int i37 = 0;
        while (i37 < virtualChildCount2) {
            int i38 = (i13 * i37) + i14;
            View childAt2 = getChildAt(i38);
            if (childAt2 == null) {
                i15 = i14;
            } else {
                i15 = i14;
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight3 = childAt2.getMeasuredHeight();
                    a aVar2 = (a) childAt2.getLayoutParams();
                    int i39 = paddingLeft;
                    if (z11) {
                        i16 = paddingTop2;
                        baseline = ((LinearLayout.LayoutParams) aVar2).height != -1 ? childAt2.getBaseline() : -1;
                        i17 = ((LinearLayout.LayoutParams) aVar2).gravity;
                        if (i17 < 0) {
                            i17 = i36;
                        }
                        i18 = i17 & 112;
                        if (i18 != 16) {
                            if (i18 != 48) {
                                i19 = i16 + ((LinearLayout.LayoutParams) aVar2).topMargin;
                                if (baseline != -1) {
                                    i19 = (iArr[1] - baseline) + i19;
                                }
                            } else if (i18 != 80) {
                                i19 = i16;
                            } else {
                                i19 = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight = iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                                }
                            }
                            if (k(i38)) {
                                i20 = i39 + this.f6434l;
                            } else {
                                i20 = i39;
                            }
                            int i40 = i20 + ((LinearLayout.LayoutParams) aVar2).leftMargin;
                            childAt2.layout(i40, i19, i40 + measuredWidth2, i19 + measuredHeight3);
                            paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + i40;
                        } else {
                            i19 = ((paddingBottom2 - measuredHeight3) / 2) + i16 + ((LinearLayout.LayoutParams) aVar2).topMargin;
                            measuredHeight = ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                        }
                        i19 -= measuredHeight;
                        if (k(i38)) {
                            i20 = i39 + this.f6434l;
                        } else {
                            i20 = i39;
                        }
                        int i41 = i20 + ((LinearLayout.LayoutParams) aVar2).leftMargin;
                        childAt2.layout(i41, i19, i41 + measuredWidth2, i19 + measuredHeight3);
                        paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + i41;
                    } else {
                        i16 = paddingTop2;
                    }
                    i17 = ((LinearLayout.LayoutParams) aVar2).gravity;
                    if (i17 < 0) {
                        i17 = i36;
                    }
                    i18 = i17 & 112;
                    if (i18 != 16) {
                        if (i18 != 48) {
                            i19 = i16 + ((LinearLayout.LayoutParams) aVar2).topMargin;
                            if (baseline != -1) {
                                i19 = (iArr[1] - baseline) + i19;
                            }
                        } else if (i18 != 80) {
                            i19 = i16;
                        } else {
                            i19 = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight = iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                            }
                        }
                        if (k(i38)) {
                            i20 = i39 + this.f6434l;
                        } else {
                            i20 = i39;
                        }
                        int i42 = i20 + ((LinearLayout.LayoutParams) aVar2).leftMargin;
                        childAt2.layout(i42, i19, i42 + measuredWidth2, i19 + measuredHeight3);
                        paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + i42;
                    } else {
                        i19 = ((paddingBottom2 - measuredHeight3) / 2) + i16 + ((LinearLayout.LayoutParams) aVar2).topMargin;
                        measuredHeight = ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                    }
                    i19 -= measuredHeight;
                    if (k(i38)) {
                        i20 = i39 + this.f6434l;
                    } else {
                        i20 = i39;
                    }
                    int i43 = i20 + ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    childAt2.layout(i43, i19, i43 + measuredWidth2, i19 + measuredHeight3);
                    paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + i43;
                }
                i37++;
                i14 = i15;
                paddingTop2 = i16;
            }
            i16 = paddingTop2;
            i37++;
            i14 = i15;
            paddingTop2 = i16;
        }
    }

    /* JADX WARN: Code duplicated, block: B:228:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:231:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:233:0x0502  */
    /* JADX WARN: Code duplicated, block: B:235:0x0506  */
    /* JADX WARN: Code duplicated, block: B:237:0x0527  */
    /* JADX WARN: Code duplicated, block: B:243:0x0537  */
    /* JADX WARN: Code duplicated, block: B:246:0x053e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:248:0x0541  */
    /* JADX WARN: Code duplicated, block: B:250:0x0548 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:252:0x054b  */
    /* JADX WARN: Code duplicated, block: B:366:0x079d  */
    /* JADX WARN: Code duplicated, block: B:64:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0142  */
    /* JADX WARN: Code duplicated, block: B:68:0x0148 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x014b  */
    @Override // android.view.View
    public void onMeasure(int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int iMax;
        int i14;
        int baseline;
        int i15;
        int i16;
        int[] iArr;
        int i17;
        int i18;
        boolean z8;
        boolean z9;
        a aVar;
        View view;
        int i19;
        int[] iArr2;
        int i20;
        int i21;
        boolean z10;
        int i22;
        int measuredHeight;
        boolean z11;
        boolean z12;
        int iMax2;
        int i23;
        int baseline2;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        boolean z13;
        int i29;
        int i30;
        int i31;
        View view2;
        boolean z14;
        LinearLayoutCompat linearLayoutCompat = this;
        int i32 = -2;
        int i33 = 1073741824;
        int i34 = 8;
        int iMax3 = 0;
        if (linearLayoutCompat.f6427d == 1) {
            linearLayoutCompat.f6429f = 0;
            int virtualChildCount = linearLayoutCompat.getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i9);
            int mode2 = View.MeasureSpec.getMode(i10);
            int i35 = linearLayoutCompat.f6425b;
            boolean z15 = linearLayoutCompat.f6431h;
            int i36 = 0;
            int iMax4 = 0;
            int iMax5 = 0;
            boolean z16 = false;
            int i37 = 0;
            boolean z17 = false;
            boolean z18 = true;
            float f6 = 0.0f;
            int iMax6 = 0;
            while (i36 < virtualChildCount) {
                int i38 = mode;
                View childAt = linearLayoutCompat.getChildAt(i36);
                if (childAt == null) {
                    linearLayoutCompat.f6429f = linearLayoutCompat.f6429f;
                } else {
                    if (childAt.getVisibility() != i34) {
                        if (linearLayoutCompat.k(i36)) {
                            linearLayoutCompat.f6429f += linearLayoutCompat.f6435m;
                        }
                        a aVar2 = (a) childAt.getLayoutParams();
                        float f9 = ((LinearLayout.LayoutParams) aVar2).weight;
                        f6 += f9;
                        if (mode2 == i33 && ((LinearLayout.LayoutParams) aVar2).height == 0 && f9 > 0.0f) {
                            int i39 = linearLayoutCompat.f6429f;
                            linearLayoutCompat.f6429f = Math.max(i39, ((LinearLayout.LayoutParams) aVar2).topMargin + i39 + ((LinearLayout.LayoutParams) aVar2).bottomMargin);
                            view2 = childAt;
                            i28 = mode2;
                            i29 = i35;
                            z13 = z15;
                            i30 = i36;
                            z16 = true;
                            i31 = i38;
                        } else {
                            if (((LinearLayout.LayoutParams) aVar2).height != 0 || f9 <= 0.0f) {
                                i27 = Integer.MIN_VALUE;
                            } else {
                                ((LinearLayout.LayoutParams) aVar2).height = i32;
                                i27 = 0;
                            }
                            i28 = mode2;
                            z13 = z15;
                            i29 = i35;
                            i30 = i36;
                            i31 = i38;
                            linearLayoutCompat.measureChildWithMargins(childAt, i9, 0, i10, f6 == 0.0f ? linearLayoutCompat.f6429f : 0);
                            if (i27 != Integer.MIN_VALUE) {
                                ((LinearLayout.LayoutParams) aVar2).height = i27;
                            }
                            int measuredHeight2 = childAt.getMeasuredHeight();
                            int i40 = linearLayoutCompat.f6429f;
                            view2 = childAt;
                            linearLayoutCompat.f6429f = Math.max(i40, i40 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin);
                            if (z13) {
                                iMax6 = Math.max(measuredHeight2, iMax6);
                            }
                        }
                        if (i29 >= 0 && i29 == i30 + 1) {
                            linearLayoutCompat.f6426c = linearLayoutCompat.f6429f;
                        }
                        if (i30 < i29 && ((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (i31 == 1073741824 || ((LinearLayout.LayoutParams) aVar2).width != -1) {
                            z14 = false;
                        } else {
                            z14 = true;
                            z17 = true;
                        }
                        int i41 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                        int measuredWidth = view2.getMeasuredWidth() + i41;
                        int iMax7 = Math.max(iMax3, measuredWidth);
                        int measuredState = view2.getMeasuredState();
                        boolean z19 = z14;
                        int iCombineMeasuredStates = View.combineMeasuredStates(i37, measuredState);
                        if (z18) {
                            i37 = iCombineMeasuredStates;
                            boolean z20 = ((LinearLayout.LayoutParams) aVar2).width == -1;
                            if (((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                                if (!z19) {
                                    i41 = measuredWidth;
                                }
                                iMax5 = Math.max(iMax5, i41);
                            } else {
                                if (!z19) {
                                    i41 = measuredWidth;
                                }
                                iMax4 = Math.max(iMax4, i41);
                            }
                            z18 = z20;
                            iMax3 = iMax7;
                        } else {
                            i37 = iCombineMeasuredStates;
                        }
                        if (((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                            if (!z19) {
                                i41 = measuredWidth;
                            }
                            iMax5 = Math.max(iMax5, i41);
                        } else {
                            if (!z19) {
                                i41 = measuredWidth;
                            }
                            iMax4 = Math.max(iMax4, i41);
                        }
                        z18 = z20;
                        iMax3 = iMax7;
                    }
                    i36 = i30 + 1;
                    i35 = i29;
                    mode = i31;
                    z15 = z13;
                    mode2 = i28;
                    i32 = -2;
                    i33 = 1073741824;
                    i34 = 8;
                }
                i28 = mode2;
                i29 = i35;
                z13 = z15;
                i30 = i36;
                i31 = i38;
                i36 = i30 + 1;
                i35 = i29;
                mode = i31;
                z15 = z13;
                mode2 = i28;
                i32 = -2;
                i33 = 1073741824;
                i34 = 8;
            }
            int i42 = mode;
            int i43 = mode2;
            boolean z21 = z15;
            int i44 = i37;
            int i45 = i10;
            if (linearLayoutCompat.f6429f > 0 && linearLayoutCompat.k(virtualChildCount)) {
                linearLayoutCompat.f6429f += linearLayoutCompat.f6435m;
            }
            if (z21 && (i43 == Integer.MIN_VALUE || i43 == 0)) {
                linearLayoutCompat.f6429f = 0;
                for (int i46 = 0; i46 < virtualChildCount; i46++) {
                    View childAt2 = linearLayoutCompat.getChildAt(i46);
                    if (childAt2 == null) {
                        linearLayoutCompat.f6429f = linearLayoutCompat.f6429f;
                    } else if (childAt2.getVisibility() != 8) {
                        a aVar3 = (a) childAt2.getLayoutParams();
                        int i47 = linearLayoutCompat.f6429f;
                        linearLayoutCompat.f6429f = Math.max(i47, i47 + iMax6 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                    }
                }
            }
            int paddingBottom = linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + linearLayoutCompat.f6429f;
            linearLayoutCompat.f6429f = paddingBottom;
            int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, linearLayoutCompat.getSuggestedMinimumHeight()), i45, 0);
            int i48 = (iResolveSizeAndState & 16777215) - linearLayoutCompat.f6429f;
            if (z16 || (i48 != 0 && f6 > 0.0f)) {
                float f10 = linearLayoutCompat.f6430g;
                if (f10 > 0.0f) {
                    f6 = f10;
                }
                linearLayoutCompat.f6429f = 0;
                int iCombineMeasuredStates2 = i44;
                int i49 = 0;
                while (i49 < virtualChildCount) {
                    View childAt3 = linearLayoutCompat.getChildAt(i49);
                    if (childAt3.getVisibility() == 8) {
                        i49 = i49;
                    } else {
                        a aVar4 = (a) childAt3.getLayoutParams();
                        float f11 = ((LinearLayout.LayoutParams) aVar4).weight;
                        if (f11 > 0.0f) {
                            int i50 = (int) ((i48 * f11) / f6);
                            f6 -= f11;
                            i48 -= i50;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + ((LinearLayout.LayoutParams) aVar4).leftMargin + ((LinearLayout.LayoutParams) aVar4).rightMargin, ((LinearLayout.LayoutParams) aVar4).width);
                            if (((LinearLayout.LayoutParams) aVar4).height == 0) {
                                i26 = 1073741824;
                                if (i43 == 1073741824) {
                                    if (i50 <= 0) {
                                        i50 = 0;
                                    }
                                    childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i50, 1073741824));
                                }
                                iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt3.getMeasuredState() & (-256));
                            } else {
                                i26 = 1073741824;
                            }
                            int measuredHeight3 = childAt3.getMeasuredHeight() + i50;
                            if (measuredHeight3 < 0) {
                                measuredHeight3 = 0;
                            }
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight3, i26));
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt3.getMeasuredState() & (-256));
                        }
                        int i51 = ((LinearLayout.LayoutParams) aVar4).leftMargin + ((LinearLayout.LayoutParams) aVar4).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i51;
                        iMax3 = Math.max(iMax3, measuredWidth2);
                        if (i42 != 1073741824) {
                            i25 = -1;
                            if (((LinearLayout.LayoutParams) aVar4).width == -1) {
                                measuredWidth2 = i51;
                            }
                        } else {
                            i25 = -1;
                        }
                        iMax4 = Math.max(iMax4, measuredWidth2);
                        boolean z22 = z18 && ((LinearLayout.LayoutParams) aVar4).width == i25;
                        int i52 = linearLayoutCompat.f6429f;
                        linearLayoutCompat.f6429f = Math.max(i52, childAt3.getMeasuredHeight() + i52 + ((LinearLayout.LayoutParams) aVar4).topMargin + ((LinearLayout.LayoutParams) aVar4).bottomMargin);
                        z18 = z22;
                    }
                    i49++;
                }
                linearLayoutCompat.f6429f = linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + linearLayoutCompat.f6429f;
                i44 = iCombineMeasuredStates2;
            } else {
                iMax4 = Math.max(iMax4, iMax5);
                if (z21 && i43 != 1073741824) {
                    for (int i53 = 0; i53 < virtualChildCount; i53++) {
                        View childAt4 = linearLayoutCompat.getChildAt(i53);
                        if (childAt4 != null && childAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) childAt4.getLayoutParams())).weight > 0.0f) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(iMax6, 1073741824));
                        }
                    }
                }
            }
            if (z18 || i42 == 1073741824) {
                iMax4 = iMax3;
            }
            linearLayoutCompat.setMeasuredDimension(View.resolveSizeAndState(Math.max(linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + iMax4, linearLayoutCompat.getSuggestedMinimumWidth()), i9, i44), iResolveSizeAndState);
            if (z17) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(linearLayoutCompat.getMeasuredWidth(), 1073741824);
                int i54 = 0;
                while (i54 < virtualChildCount) {
                    View childAt5 = linearLayoutCompat.getChildAt(i54);
                    if (childAt5.getVisibility() != 8) {
                        a aVar5 = (a) childAt5.getLayoutParams();
                        if (((LinearLayout.LayoutParams) aVar5).width == -1) {
                            int i55 = ((LinearLayout.LayoutParams) aVar5).height;
                            ((LinearLayout.LayoutParams) aVar5).height = childAt5.getMeasuredHeight();
                            linearLayoutCompat.measureChildWithMargins(childAt5, iMakeMeasureSpec, 0, i45, 0);
                            ((LinearLayout.LayoutParams) aVar5).height = i55;
                        }
                    }
                    i54++;
                    i45 = i10;
                }
                return;
            }
            return;
        }
        int i56 = i9;
        linearLayoutCompat.f6429f = 0;
        int virtualChildCount2 = linearLayoutCompat.getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i56);
        int mode4 = View.MeasureSpec.getMode(i10);
        if (linearLayoutCompat.f6432i == null || linearLayoutCompat.j == null) {
            linearLayoutCompat.f6432i = new int[4];
            linearLayoutCompat.j = new int[4];
        }
        int[] iArr3 = linearLayoutCompat.f6432i;
        int[] iArr4 = linearLayoutCompat.j;
        iArr3[3] = -1;
        char c5 = 2;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        iArr4[3] = -1;
        iArr4[2] = -1;
        iArr4[1] = -1;
        iArr4[0] = -1;
        boolean z23 = linearLayoutCompat.f6424a;
        boolean z24 = linearLayoutCompat.f6431h;
        boolean z25 = mode3 == 1073741824;
        float f12 = 0.0f;
        boolean z26 = true;
        int i57 = 0;
        int i58 = 0;
        int i59 = 0;
        int iMax8 = 0;
        int iMax9 = 0;
        int iCombineMeasuredStates3 = 0;
        boolean z27 = false;
        boolean z28 = false;
        while (i57 < virtualChildCount2) {
            char c9 = c5;
            View childAt6 = linearLayoutCompat.getChildAt(i57);
            if (childAt6 == null) {
                linearLayoutCompat.f6429f = linearLayoutCompat.f6429f;
                i18 = i57;
                i23 = i59;
                iArr2 = iArr3;
                iArr = iArr4;
                z8 = z23;
                z9 = z24;
            } else {
                int i60 = i58;
                if (childAt6.getVisibility() == 8) {
                    i56 = i9;
                    i18 = i57;
                    i23 = i59;
                    iArr = iArr4;
                    z8 = z23;
                    z9 = z24;
                    i58 = i60;
                    iArr2 = iArr3;
                } else {
                    if (linearLayoutCompat.k(i57)) {
                        linearLayoutCompat.f6429f += linearLayoutCompat.f6434l;
                    }
                    a aVar6 = (a) childAt6.getLayoutParams();
                    float f13 = ((LinearLayout.LayoutParams) aVar6).weight;
                    f12 += f13;
                    int i61 = i57;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) aVar6).width == 0 && f13 > 0.0f) {
                        if (z25) {
                            linearLayoutCompat.f6429f = ((LinearLayout.LayoutParams) aVar6).leftMargin + ((LinearLayout.LayoutParams) aVar6).rightMargin + linearLayoutCompat.f6429f;
                        } else {
                            int i62 = linearLayoutCompat.f6429f;
                            linearLayoutCompat.f6429f = Math.max(i62, ((LinearLayout.LayoutParams) aVar6).leftMargin + i62 + ((LinearLayout.LayoutParams) aVar6).rightMargin);
                        }
                        if (z23) {
                            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt6.measure(iMakeMeasureSpec2, iMakeMeasureSpec2);
                            view = childAt6;
                            z8 = z23;
                            z9 = z24;
                            i19 = i60;
                            i18 = i61;
                            aVar = aVar6;
                            iArr2 = iArr3;
                            iArr = iArr4;
                            i56 = i9;
                            i20 = i59;
                            i17 = iMax8;
                        } else {
                            view = childAt6;
                            z8 = z23;
                            z9 = z24;
                            z28 = true;
                            i19 = i60;
                            i18 = i61;
                            i21 = 1073741824;
                            aVar = aVar6;
                            iArr2 = iArr3;
                            iArr = iArr4;
                            i56 = i9;
                            i20 = i59;
                            i17 = iMax8;
                        }
                        if (mode4 == i21 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                            z10 = true;
                            z27 = true;
                        } else {
                            z10 = false;
                        }
                        i22 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i22;
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view.getMeasuredState());
                        if (z8) {
                            baseline2 = view.getBaseline();
                            z11 = z10;
                            if (baseline2 != -1) {
                                i24 = ((LinearLayout.LayoutParams) aVar).gravity;
                                if (i24 < 0) {
                                    i24 = linearLayoutCompat.f6428e;
                                }
                                int i63 = (((i24 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i63] = Math.max(iArr2[i63], baseline2);
                                iArr[i63] = Math.max(iArr[i63], measuredHeight - baseline2);
                            }
                        } else {
                            z11 = z10;
                        }
                        int iMax10 = Math.max(i19, measuredHeight);
                        if (z26 || ((LinearLayout.LayoutParams) aVar).height != -1) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                            if (!z11) {
                                i22 = measuredHeight;
                            }
                            iMax8 = Math.max(i17, i22);
                            iMax2 = i20;
                        } else {
                            if (!z11) {
                                i22 = measuredHeight;
                            }
                            iMax2 = Math.max(i20, i22);
                            iMax8 = i17;
                        }
                        int i64 = iMax2;
                        i58 = iMax10;
                        i23 = i64;
                        z26 = z12;
                    } else {
                        if (((LinearLayout.LayoutParams) aVar6).width != 0 || f13 <= 0.0f) {
                            i16 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) aVar6).width = -2;
                            i16 = 0;
                        }
                        iArr = iArr4;
                        i17 = iMax8;
                        i18 = i61;
                        z8 = z23;
                        z9 = z24;
                        int i65 = i16;
                        aVar = aVar6;
                        view = childAt6;
                        i19 = i60;
                        i56 = i9;
                        iArr2 = iArr3;
                        i20 = i59;
                        linearLayoutCompat.measureChildWithMargins(view, i56, f12 == 0.0f ? linearLayoutCompat.f6429f : 0, i10, 0);
                        if (i65 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar).width = i65;
                        }
                        int measuredWidth3 = view.getMeasuredWidth();
                        if (z25) {
                            linearLayoutCompat.f6429f = ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth3 + ((LinearLayout.LayoutParams) aVar).rightMargin + linearLayoutCompat.f6429f;
                        } else {
                            int i66 = linearLayoutCompat.f6429f;
                            linearLayoutCompat.f6429f = Math.max(i66, i66 + measuredWidth3 + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin);
                        }
                        if (z9) {
                            iMax9 = Math.max(measuredWidth3, iMax9);
                        }
                    }
                    i21 = 1073741824;
                    if (mode4 == i21) {
                        z10 = false;
                    } else {
                        z10 = false;
                    }
                    i22 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i22;
                    iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view.getMeasuredState());
                    if (z8) {
                        baseline2 = view.getBaseline();
                        z11 = z10;
                        if (baseline2 != -1) {
                            i24 = ((LinearLayout.LayoutParams) aVar).gravity;
                            if (i24 < 0) {
                                i24 = linearLayoutCompat.f6428e;
                            }
                            int i67 = (((i24 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i67] = Math.max(iArr2[i67], baseline2);
                            iArr[i67] = Math.max(iArr[i67], measuredHeight - baseline2);
                        }
                    } else {
                        z11 = z10;
                    }
                    int iMax11 = Math.max(i19, measuredHeight);
                    if (z26) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                        if (!z11) {
                            i22 = measuredHeight;
                        }
                        iMax8 = Math.max(i17, i22);
                        iMax2 = i20;
                    } else {
                        if (!z11) {
                            i22 = measuredHeight;
                        }
                        iMax2 = Math.max(i20, i22);
                        iMax8 = i17;
                    }
                    int i68 = iMax2;
                    i58 = iMax11;
                    i23 = i68;
                    z26 = z12;
                }
            }
            i59 = i23;
            i57 = i18 + 1;
            c5 = c9;
            iArr3 = iArr2;
            iArr4 = iArr;
            z23 = z8;
            z24 = z9;
        }
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        char c10 = c5;
        boolean z29 = z23;
        boolean z30 = z24;
        int i69 = i58;
        int i70 = i59;
        int i71 = iMax8;
        if (linearLayoutCompat.f6429f > 0 && linearLayoutCompat.k(virtualChildCount2)) {
            linearLayoutCompat.f6429f += linearLayoutCompat.f6434l;
        }
        int i72 = iArr5[1];
        int iMax12 = (i72 == -1 && iArr5[0] == -1 && iArr5[c10] == -1 && iArr5[3] == -1) ? i69 : Math.max(i69, Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[c10]))) + Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i72, iArr5[c10]))));
        if (z30 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
            linearLayoutCompat.f6429f = 0;
            for (int i73 = 0; i73 < virtualChildCount2; i73++) {
                View childAt7 = linearLayoutCompat.getChildAt(i73);
                if (childAt7 == null) {
                    linearLayoutCompat.f6429f = linearLayoutCompat.f6429f;
                } else if (childAt7.getVisibility() != 8) {
                    a aVar7 = (a) childAt7.getLayoutParams();
                    if (z25) {
                        linearLayoutCompat.f6429f = ((LinearLayout.LayoutParams) aVar7).leftMargin + iMax9 + ((LinearLayout.LayoutParams) aVar7).rightMargin + linearLayoutCompat.f6429f;
                    } else {
                        int i74 = linearLayoutCompat.f6429f;
                        linearLayoutCompat.f6429f = Math.max(i74, i74 + iMax9 + ((LinearLayout.LayoutParams) aVar7).leftMargin + ((LinearLayout.LayoutParams) aVar7).rightMargin);
                    }
                }
            }
        }
        int paddingRight = linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + linearLayoutCompat.f6429f;
        linearLayoutCompat.f6429f = paddingRight;
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, linearLayoutCompat.getSuggestedMinimumWidth()), i56, 0);
        int i75 = (iResolveSizeAndState2 & 16777215) - linearLayoutCompat.f6429f;
        if (z28 || (i75 != 0 && f12 > 0.0f)) {
            float f14 = linearLayoutCompat.f6430g;
            if (f14 > 0.0f) {
                f12 = f14;
            }
            iArr5[3] = -1;
            iArr5[c10] = -1;
            iArr5[1] = -1;
            iArr5[0] = -1;
            iArr6[3] = -1;
            iArr6[c10] = -1;
            iArr6[1] = -1;
            iArr6[0] = -1;
            linearLayoutCompat.f6429f = 0;
            iMax12 = -1;
            int i76 = 0;
            while (i76 < virtualChildCount2) {
                View childAt8 = linearLayoutCompat.getChildAt(i76);
                if (childAt8 == null || childAt8.getVisibility() == 8) {
                    iResolveSizeAndState2 = iResolveSizeAndState2;
                } else {
                    a aVar8 = (a) childAt8.getLayoutParams();
                    float f15 = ((LinearLayout.LayoutParams) aVar8).weight;
                    if (f15 > 0.0f) {
                        int i77 = (int) ((i75 * f15) / f12);
                        f12 -= f15;
                        i75 -= i77;
                        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + ((LinearLayout.LayoutParams) aVar8).topMargin + ((LinearLayout.LayoutParams) aVar8).bottomMargin, ((LinearLayout.LayoutParams) aVar8).height);
                        if (((LinearLayout.LayoutParams) aVar8).width == 0) {
                            i15 = 1073741824;
                            if (mode3 == 1073741824) {
                                if (i77 <= 0) {
                                    i77 = 0;
                                }
                                childAt8.measure(View.MeasureSpec.makeMeasureSpec(i77, 1073741824), childMeasureSpec2);
                            }
                            iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt8.getMeasuredState() & (-16777216));
                        } else {
                            i15 = 1073741824;
                        }
                        int measuredWidth4 = childAt8.getMeasuredWidth() + i77;
                        if (measuredWidth4 < 0) {
                            measuredWidth4 = 0;
                        }
                        childAt8.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i15), childMeasureSpec2);
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt8.getMeasuredState() & (-16777216));
                    }
                    if (z25) {
                        linearLayoutCompat.f6429f = childAt8.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar8).leftMargin + ((LinearLayout.LayoutParams) aVar8).rightMargin + linearLayoutCompat.f6429f;
                    } else {
                        int i78 = linearLayoutCompat.f6429f;
                        linearLayoutCompat.f6429f = Math.max(i78, childAt8.getMeasuredWidth() + i78 + ((LinearLayout.LayoutParams) aVar8).leftMargin + ((LinearLayout.LayoutParams) aVar8).rightMargin);
                    }
                    boolean z31 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) aVar8).height == -1;
                    int i79 = ((LinearLayout.LayoutParams) aVar8).topMargin + ((LinearLayout.LayoutParams) aVar8).bottomMargin;
                    int measuredHeight4 = childAt8.getMeasuredHeight() + i79;
                    iMax12 = Math.max(iMax12, measuredHeight4);
                    if (!z31) {
                        i79 = measuredHeight4;
                    }
                    int iMax13 = Math.max(i70, i79);
                    if (z26) {
                        i14 = -1;
                        boolean z32 = ((LinearLayout.LayoutParams) aVar8).height == -1;
                        if (!z29 && (baseline = childAt8.getBaseline()) != i14) {
                            int i80 = ((LinearLayout.LayoutParams) aVar8).gravity;
                            if (i80 < 0) {
                                i80 = linearLayoutCompat.f6428e;
                            }
                            int i81 = (((i80 & 112) >> 4) & (-2)) >> 1;
                            iArr5[i81] = Math.max(iArr5[i81], baseline);
                            iArr6[i81] = Math.max(iArr6[i81], measuredHeight4 - baseline);
                        }
                        z26 = z32;
                        i70 = iMax13;
                    } else {
                        i14 = -1;
                    }
                    if (!z29) {
                    }
                    z26 = z32;
                    i70 = iMax13;
                }
                i76++;
                iResolveSizeAndState2 = iResolveSizeAndState2;
            }
            i11 = iResolveSizeAndState2;
            i12 = -16777216;
            linearLayoutCompat.f6429f = linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + linearLayoutCompat.f6429f;
            int i82 = iArr5[1];
            if (i82 == -1 && iArr5[0] == -1 && iArr5[c10] == -1 && iArr5[3] == -1) {
                i13 = 0;
            } else {
                i13 = 0;
                iMax12 = Math.max(iMax12, Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[c10]))) + Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i82, iArr5[c10]))));
            }
            iMax = i70;
        } else {
            iMax = Math.max(i70, i71);
            if (z30 && mode3 != 1073741824) {
                for (int i83 = 0; i83 < virtualChildCount2; i83++) {
                    View childAt9 = linearLayoutCompat.getChildAt(i83);
                    if (childAt9 != null && childAt9.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) childAt9.getLayoutParams())).weight > 0.0f) {
                        childAt9.measure(View.MeasureSpec.makeMeasureSpec(iMax9, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt9.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i11 = iResolveSizeAndState2;
            i12 = -16777216;
            i13 = 0;
        }
        if (!z26 && mode4 != 1073741824) {
            iMax12 = iMax;
        }
        linearLayoutCompat.setMeasuredDimension(i11 | (iCombineMeasuredStates3 & i12), View.resolveSizeAndState(Math.max(linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + iMax12, linearLayoutCompat.getSuggestedMinimumHeight()), i10, iCombineMeasuredStates3 << 16));
        if (z27) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(linearLayoutCompat.getMeasuredHeight(), 1073741824);
            int i84 = i13;
            while (i84 < virtualChildCount2) {
                View childAt10 = linearLayoutCompat.getChildAt(i84);
                if (childAt10.getVisibility() != 8) {
                    a aVar9 = (a) childAt10.getLayoutParams();
                    if (((LinearLayout.LayoutParams) aVar9).height == -1) {
                        int i85 = ((LinearLayout.LayoutParams) aVar9).width;
                        ((LinearLayout.LayoutParams) aVar9).width = childAt10.getMeasuredWidth();
                        linearLayoutCompat.measureChildWithMargins(childAt10, i56, 0, iMakeMeasureSpec3, 0);
                        ((LinearLayout.LayoutParams) aVar9).width = i85;
                    }
                }
                i84++;
                linearLayoutCompat = this;
                i56 = i9;
            }
        }
    }

    public void setBaselineAligned(boolean z8) {
        this.f6424a = z8;
    }

    public void setBaselineAlignedChildIndex(int i9) {
        if (i9 >= 0 && i9 < getChildCount()) {
            this.f6425b = i9;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f6433k) {
            return;
        }
        this.f6433k = drawable;
        if (drawable != null) {
            this.f6434l = drawable.getIntrinsicWidth();
            this.f6435m = drawable.getIntrinsicHeight();
        } else {
            this.f6434l = 0;
            this.f6435m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i9) {
        this.f6437o = i9;
    }

    public void setGravity(int i9) {
        if (this.f6428e != i9) {
            if ((8388615 & i9) == 0) {
                i9 |= 8388611;
            }
            if ((i9 & 112) == 0) {
                i9 |= 48;
            }
            this.f6428e = i9;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i9) {
        int i10 = i9 & 8388615;
        int i11 = this.f6428e;
        if ((8388615 & i11) != i10) {
            this.f6428e = i10 | ((-8388616) & i11);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z8) {
        this.f6431h = z8;
    }

    public void setOrientation(int i9) {
        if (this.f6427d != i9) {
            this.f6427d = i9;
            requestLayout();
        }
    }

    public void setShowDividers(int i9) {
        if (i9 != this.f6436n) {
            requestLayout();
        }
        this.f6436n = i9;
    }

    public void setVerticalGravity(int i9) {
        int i10 = i9 & 112;
        int i11 = this.f6428e;
        if ((i11 & 112) != i10) {
            this.f6428e = i10 | (i11 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f6) {
        this.f6430g = Math.max(0.0f, f6);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, 0);
        this.f6424a = true;
        this.f6425b = -1;
        this.f6426c = 0;
        this.f6428e = 8388659;
        int[] iArr = p059i.a.f19186n;
        K kE = K.e(context, attributeSet, iArr, 0);
        T.G.l(this, context, iArr, attributeSet, kE.f6420b, 0);
        TypedArray typedArray = kE.f6420b;
        int i10 = typedArray.getInt(1, -1);
        if (i10 >= 0) {
            setOrientation(i10);
        }
        int i11 = typedArray.getInt(0, -1);
        if (i11 >= 0) {
            setGravity(i11);
        }
        boolean z8 = typedArray.getBoolean(2, true);
        if (!z8) {
            setBaselineAligned(z8);
        }
        this.f6430g = typedArray.getFloat(4, -1.0f);
        this.f6425b = typedArray.getInt(3, -1);
        this.f6431h = typedArray.getBoolean(7, false);
        setDividerDrawable(kE.b(5));
        this.f6436n = typedArray.getInt(8, 0);
        this.f6437o = typedArray.getDimensionPixelSize(6, 0);
        kE.f();
    }
}
